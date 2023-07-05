;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use eRS)
(use Language)
(use MCyc)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
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
		(Load rsVIEW 15)
		(LoadMany rsSOUND 115)
		(super init:)
		(pukeSFX init:)
		(self setRegions: 707) ; intro
		(switch gPrevRoomNum
			(16
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
		(barSign init: cycleSpeed: 1 setCycle: Fwd)
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
				(= cycles 10)
			)
			(3
				(aSound number: 115 priority: 15 play:)
				(spGun setCycle: End)
				(= cycles 2)
			)
			(4
				(trGun setPri: -1)
				(spNoGun setCycle: End)
				(= cycles 10)
			)
			(5
				(trNoGun setCycle: MCyc @local141 self)
			)
			(6
				(trNoGun setPri: 9 setCycle: MCyc @local174 self)
			)
			(7
				(aSound number: 115 priority: 15 play:)
				(= local0
					(proc0_12
						{"You go left to split 'em up!\nMr. Wilco! Follow me and do exactly\nas I say! LET'S MOVE!"}
						67
						60
						30
						70
						260
						28
						(proc0_18 28 global136)
						29
						global129
						30
						0
					)
				)
				(= seconds 5)
			)
			(8
				(trGun
					view: 21
					setLoop: 0
					setCycle: Walk
					setStep: 3 4
					setMotion: MoveTo (- (trNoGun x:) 60) 250
				)
				(= cycles 5)
			)
			(9
				(trNoGun
					view: 21
					setLoop: 1
					setPri: 13
					setCycle: Walk
					setStep: 3 4
					setMotion: MoveTo (+ (trGun x:) 60) 270
				)
				(= cycles 5)
			)
			(10
				(roger
					view: 21
					setCycle: 0
					setLoop: 2
					setCycle: Walk
					setStep: 3 4
					setPri: -1
					setMotion: MoveTo (- (roger x:) 60) 250
				)
				(= seconds 3)
			)
			(11
				(spGun setCycle: Beg self)
				(spNoGun setCycle: Beg)
			)
			(12
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
				(= seconds 4)
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
				0
				(= cycles 2)
				(proc0_14 4)
				(gLongSong number: 803 vol: 94 loop: -1 changeState: playBed:)
			)
			(1
				1
				(= local0
					(proc0_12
						{As our story begins, we find the Aluminum\nMallard parked outside a seedy spaceport bar.}
						67
						5
						(LangSwitch 160 145)
						70
						310
						28
						global136
						29
						global129
						30
						1
						33
						310
					)
				)
				(= cycles 2)
			)
			(2
				2
				(puker
					setCycle: Fwd
					moveSpeed: 3
					cycleSpeed: 2
					setMotion: MoveTo 178 138 self
				)
			)
			(3
				3
				(puker setPri: 3 cycleSpeed: 2 setMotion: MoveTo 188 140 self)
			)
			(4
				4
				(puker setLoop: 1 posn: 215 148 setCycle: End self)
			)
			(5
				5
				(puker
					setLoop: 2
					setCel: 0
					posn: 267 143
					cycleSpeed: 0
					setCycle: CT 2 1 self
				)
			)
			(6
				6
				(puker setCycle: Beg self)
			)
			(7
				7
				(puker setCycle: CT 3 1 self)
			)
			(8
				8
				(puker setCycle: Beg self)
			)
			(9
				9
				(puker setCycle: CT 5 1 self)
			)
			(10
				10
				(puker setCycle: Beg self)
			)
			(11
				11
				(puker setCycle: CT 6 1 self)
			)
			(12
				12
				(pukeSFX play:)
				(= cycles 2)
			)
			(13
				13
				(puke z: 0 setCycle: End)
				(= cycles 2)
			)
			(14
				14
				(puker setCel: 0 setCycle: CT 5 1 self)
			)
			(15
				15
				(puker setCel: 8 cycleSpeed: 2 setCycle: End self)
			)
			(16
				16
				(puker setLoop: 5 posn: 297 148 setCycle: End)
				(= cycles 5)
			)
			(17
				17
				(proc0_12 local0)
				(= cycles 2)
			)
			(18
				18
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

(instance puker of Actor
	(properties
		x 175
		y 144
		view 15
		priority 1
		signal 2064
		cycleSpeed 3
		illegalBits 0
	)
)

(instance puke of Prop
	(properties
		x 291
		y 137
		z 1000
		view 15
		loop 3
	)
)

(instance barSign of Prop
	(properties
		x 163
		y 83
		view 15
		loop 4
	)
)

(instance spGun of Actor
	(properties
		view 5
		signal 16384
	)
)

(instance spNoGun of Actor
	(properties
		view 5
		signal 16384
	)
)

(instance trNoGun of Actor
	(properties
		view 5
		signal 16384
		illegalBits 0
	)
)

(instance trGun of Actor
	(properties
		view 5
		signal 16384
		illegalBits 0
	)
)

(instance roger of Actor
	(properties)
)

(instance aSound of Sound
	(properties)
)

