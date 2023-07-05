;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Narrator)
(use Sq4Feature)
(use MCyc)
(use LoadMany)
(use Sound)
(use Motion)
(use System)

(public
	rm015 0
)

(local
	local0
	[local1 33] = [0 0 19 101 0 0 19 99 0 0 19 97 0 0 19 95 0 0 19 93 0 0 19 91 0 0 19 89 0 0 19 87 -32768]
	[local34 37] = [0 0 19 87 0 0 19 90 0 0 20 84 0 0 22 80 1 0 21 87 1 1 29 82 1 2 41 78 1 3 44 79 1 4 48 82 -32768]
	[local71 49] = [1 0 48 82 1 1 58 81 1 2 68 78 1 2 78 80 1 2 88 88 1 2 98 102 1 2 108 115 1 2 118 146 1 3 130 153 1 4 140 165 1 5 140 165 1 6 140 165 -32768]
	[local120 21] = [0 0 34 105 0 0 34 104 0 0 34 103 0 0 34 102 0 0 34 101 -32768]
	[local141 33] = [0 0 34 100 0 0 34 102 0 0 34 94 1 0 34 92 1 1 35 93 1 2 44 81 1 3 45 83 1 4 48 83 -32768]
	[local174 49] = [1 4 49 85 1 0 52 82 1 1 57 85 1 2 67 79 1 2 77 76 1 2 89 93 1 2 102 120 1 2 107 133 1 3 108 143 1 4 111 153 1 5 111 153 1 6 111 153 -32768]
)

(instance rm015 of SQRoom
	(properties
		picture 15
	)

	(method (init)
		(LoadMany rsVIEW 15)
		(LoadMany rsSOUND 115)
		(super init:)
		(pukeSFX init:)
		(self setRegions: 707) ; intro
		(switch gPrevRoomNum
			(16
				(LoadMany rsVIEW 5 21)
				(roger
					view: 0
					setLoop: 6
					setCel: 3
					posn: 137 181
					init:
					setCycle: 0
				)
				(spGun setLoop: 3 setCel: 0 posn: 152 171 init:)
				(spNoGun setLoop: 2 setCel: 0 posn: 167 173 init:)
				(trGun setLoop: 0 setCel: 0 posn: 19 103 init:)
				(trNoGun setLoop: 0 setCel: 0 posn: 34 106 init:)
				(self setScript: ripper1Script)
			)
			(17
				(roger
					view: 0
					setLoop: 6
					setCel: 3
					posn: 137 181
					init:
					setCycle: 0
				)
				(spGun setLoop: 3 setCel: 0 posn: 152 171 init:)
				(spNoGun setLoop: 2 setCel: 0 posn: 167 173 init:)
				(trGun setLoop: 0 setCel: 0 posn: 19 87 init:)
				(trNoGun setLoop: 0 setCel: 0 posn: 34 101 init:)
				(self setScript: ripper2Script)
			)
			(else
				(Load rsSOUND 162)
				(self setScript: barScript)
				(puker init:)
				(puke init:)
			)
		)
		(barSign init: cycleSpeed: 12 setCycle: Fwd)
	)
)

(instance ripper2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong number: 800 loop: -1 vol: 127 playBed:)
				(= cycles 10)
			)
			(1
				(trGun setCycle: MCyc @local34 self)
			)
			(2
				(trGun setPri: 9 setCycle: MCyc @local71)
				(= cycles 1)
			)
			(3
				(if (< (trGun x:) 130)
					(-- state)
				)
				(= cycles 1)
			)
			(4
				(aSound number: 115 priority: 15 play:)
				(spGun setCycle: End)
				(= cycles 2)
			)
			(5
				(trGun setPri: -1)
				(spNoGun setCycle: End)
				(= cycles 10)
			)
			(6
				(trNoGun setCycle: MCyc @local141 self)
			)
			(7
				(trNoGun setPri: 9 setCycle: MCyc @local174 self)
			)
			(8
				(aSound number: 115 priority: 15 play:)
				(trHead setPri: 13 init:)
				(tTIMERIPPER init: 0 0 trHead)
				(tTIMERIPPER ; "You go left to split 'em up!  Mr. Wilco! Follow me and do exactly  as I say! LET'S MOVE!"
					say:
						1
						self
						2
						64
						60
						30
						67
						260
						25
						(proc0_18 28 global136)
						26
						global129
						27
						0
				)
			)
			(9
				(trHead dispose:)
				(trGun
					view: 21
					setLoop: 0
					setCycle: Walk
					setStep: 3 4
					moveSpeed: 2
					setMotion: MoveTo (- (trNoGun x:) 60) 250
				)
				(= cycles 5)
			)
			(10
				(trNoGun
					view: 21
					setLoop: 1
					setPri: 13
					setCycle: Walk
					setStep: 3 4
					moveSpeed: 2
					setMotion: MoveTo (+ (trGun x:) 60) 270
				)
				(= cycles 5)
			)
			(11
				(roger
					view: 21
					setCycle: 0
					setLoop: 2
					setCycle: Walk
					setStep: 3 4
					setPri: -1
					moveSpeed: 2
					setMotion: MoveTo (- (roger x:) 60) 250
				)
				(= seconds 3)
			)
			(12
				(spNoGun cycleSpeed: 10 setCycle: Beg)
				(= seconds 1)
			)
			(13
				(spGun setCycle: Beg self)
			)
			(14
				(= seconds 1)
			)
			(15
				(gCurRoom newRoom: 20)
			)
		)
	)
)

(instance ripper1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(trGun setCycle: MCyc @local120)
				(trNoGun setCycle: MCyc @local1)
				(= seconds 5)
			)
			(2
				(gLongSong fade:)
				(Animate (gCast elements:) 0)
				(gCurRoom newRoom: 17)
			)
		)
	)
)

(instance barScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
				(proc0_14 4)
				(gLongSong number: 803 vol: 94 loop: -1 play:)
				(gLongSong setVol: 94)
			)
			(1
				(gNarrator ; "As our story begins, we find the Aluminum Mallard parked outside a seedy spaceport bar."
					modeless: 1
					returnVal: 0
					nMsgType: 3
					say:
						1
						0
						2
						64
						5
						160
						67
						310
						25
						global136
						26
						global129
						27
						1
						30
						310
				)
				(= cycles 2)
			)
			(2
				(puker
					setCycle: Fwd
					moveSpeed: 3
					cycleSpeed: 7
					setMotion: MoveTo 178 138 self
				)
			)
			(3
				(puker setPri: 3 cycleSpeed: 7 setMotion: MoveTo 188 140 self)
			)
			(4
				(puker
					setLoop: 1
					posn: 215 148
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(5
				(puker
					setLoop: 2
					setCel: 0
					posn: 267 143
					setCycle: CT 2 1 self
					cycleSpeed: 13
				)
			)
			(6
				(puker setCycle: Beg self)
			)
			(7
				(puker setCycle: CT 3 1 self)
			)
			(8
				(puker setCycle: Beg self)
			)
			(9
				(puker setCycle: CT 5 1 self)
			)
			(10
				(puker setCycle: Beg self)
			)
			(11
				(puker setCycle: CT 6 1 self)
			)
			(12
				(pukeSFX play:)
				(= cycles 2)
			)
			(13
				(puke z: 0 cycleSpeed: 6 setCycle: End)
				(= seconds 2)
			)
			(14
				(puker setCycle: CT 8 1)
				(= seconds 1)
			)
			(15
				(puker setCel: 8 setCycle: End self)
			)
			(16
				(puker setLoop: 5 posn: 297 148 setCycle: End self)
			)
			(17
				(gLongSong2 number: 886 loop: 1 play:)
				(puker
					posn: 287 143
					setLoop: 6
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(18
				(puker posn: 287 115 setLoop: 8 setCel: 0 setCycle: Fwd)
				(= seconds 4)
			)
			(19
				(gCurRoom newRoom: 16)
			)
		)
	)
)

(instance pukeSFX of Sound
	(properties
		number 162
	)
)

(instance puker of Sq4Actor
	(properties
		x 175
		y 144
		view 15
		priority 1
		signal 2064
		cycleSpeed 24
		illegalBits 0
	)
)

(instance puke of Sq4Prop
	(properties
		x 291
		y 137
		z 1000
		view 15
		loop 3
		priority 2
		signal 16
	)
)

(instance barSign of Sq4Prop
	(properties
		x 163
		y 83
		view 15
		loop 4
	)
)

(instance spGun of Sq4Actor
	(properties
		view 5
		signal 16384
	)
)

(instance spNoGun of Sq4Actor
	(properties
		view 5
		signal 16384
	)
)

(instance trNoGun of Sq4Actor
	(properties
		view 5
		signal 16384
		illegalBits 0
	)
)

(instance trGun of Sq4Actor
	(properties
		view 5
		signal 16384
		illegalBits 0
	)
)

(instance roger of Sq4Actor
	(properties)
)

(instance aSound of Sound
	(properties)
)

(instance trHead of Sq4Prop
	(properties
		x 145
		y 136
		view 5
		loop 6
	)
)

(instance tTIMERIPPER of FaceTalker
	(properties
		noun 4
		talkerNum 4
	)
)

