;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 55)
(include sci.sh)
(use Main)
(use Interface)
(use dropInScript)
(use DLetter)
(use KQ5Room)
(use RandCycle)
(use PolyPath)
(use LoadMany)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm055 0
	priBlock 1
)

(local
	local0
	[local1 2] = [0 50]
	[local3 19] = [7 -3 5 -7 7 -3 7 -2 5 3 5 5 7 12 2 26 0 18 -32768]
	local22
	local23
	local24
	local25
	[local26 43] = [8 6 0 7 6 1 7 7 3 6 7 2 5 7 3 5 6 2 5 5 3 6 5 1 6 4 3 7 4 1 7 3 0 7 2 1 6 2 2 5 2 3 -32768]
	[local69 4] = [126 89 205 228]
	[local73 4] = [121 136 121 136]
	[local77 4] = [88 53 237 264]
	[local81 4] = [121 136 121 136]
	local85
	local86
	local87
	local88
	[local89 9] = [155 9 2 155 50 1 38 50 -32768]
	[local98 9] = [155 9 2 155 50 0 270 50 -32768]
	[local107 15] = [155 9 2 155 50 1 90 50 2 90 85 1 38 85 -32768]
	[local122 15] = [155 9 2 155 50 0 231 50 2 231 85 0 270 85 -32768]
	[local137 15] = [38 85 0 90 85 3 90 50 0 155 50 3 155 9 -32768]
	[local152 12] = [38 85 0 90 85 3 90 50 0 270 50 -32768]
	[local164 12] = [270 85 1 231 85 3 231 50 1 38 50 -32768]
)

(procedure (localproc_0 &tmp temp0)
	(HandsOff)
	(gCurRoom drawPic: 55)
	(gAddToPics eachElementDo: #dispose)
	(gAddToPics eachElementDo: #delete)
	(gAddToPics dispose:)
	(hole dispose:)
	(cell dispose:)
	(door dispose:)
	(doorBack dispose:)
	(dink dispose:)
	(dinkHair dispose:)
	(dinkBlink dispose:)
	(hairPin dispose:)
	(mazeBug dispose:)
	(helper dispose:)
	(arrow dispose:)
	(if (!= (gGlobalSound number:) 25)
		(gGlobalSound loop: -1 number: 25 playBed:)
	)
	(gEgo illegalBits: 0)
	(localproc_1)
	(if (== (cass script:) cassScript)
		(SetFlag 110)
	)
)

(procedure (localproc_1)
	(= global383 (mod global383 360))
	(gEgo posn: 161 145 0 setMotion: 0 heading: 0 loop: 3)
	(if (== gPrevRoomNum 55)
		(switch global383
			(0
				(-- global385)
			)
			(90
				(++ global384)
			)
			(180
				(++ global385)
			)
			(270
				(-- global384)
			)
		)
	)
	(proc603_19)
	(proc603_14)
	(proc603_15)
	(proc603_16)
	(proc603_17)
	(proc603_6)
	(proc603_7)
	(proc603_8)
	(proc603_9)
	(proc603_10)
	(proc603_11)
	(proc603_12)
	(proc603_13)
	(cond
		((localproc_5) 0)
		((localproc_6) 0)
		((localproc_2) 0)
		((localproc_3) 0)
		((localproc_4) 0)
		((< (gGame detailLevel:) 3) 0)
		((localproc_7) 0)
	)
)

(procedure (localproc_2)
	(cond
		(
			(and
				(not (and (== global384 3) (== global385 5)))
				(not (and (== global384 3) (== global385 4)))
				(not (and (== global384 3) (== global385 6)))
				(not (and (== global384 2) (== global385 5)))
				(not (and (== global384 4) (== global385 5)))
			)
			(return 0)
		)
		((and (== global384 3) (== global385 5))
			(hole
				view: 878
				setLoop: 5
				cel: 2
				setPri: 12
				x: 162
				y: 48
				init:
				show:
			)
			(return 1)
		)
		(
			(or
				(and (== global384 3) (== global385 4) (!= global383 180))
				(and (== global384 3) (== global385 6) (!= global383 0))
				(and (== global384 2) (== global385 5) (!= global383 90))
				(and (== global384 4) (== global385 5) (!= global383 270))
			)
			(return 0)
		)
		(else
			(hole view: 878 setLoop: 5 cel: 3 setPri: 12 x: 162 y: 55 init:)
			(return 1)
		)
	)
)

(procedure (localproc_3)
	(cond
		((not (IsFlag 67))
			(return 0)
		)
		((and (== global384 8) (== global385 6))
			(if (== global383 90)
				(cell
					view: 878
					setLoop: 5
					cel: 0
					setPri: 11
					x: 162
					y: 119
					init:
					show:
				)
			)
			(return 1)
		)
	)
)

(procedure (localproc_4)
	(if (and (== global384 5) (== global385 1) (== global383 0))
		(door view: 862 setLoop: 0 cel: 0 setPri: 11 x: 162 y: 128 init: show:)
		(doorBack x: 162 y: 128 init: show:)
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_5)
	(cond
		((not (gEgo has: 34)) ; Tambourine
			(return 0)
		)
		(
			(or
				(and (== global384 1) (== global385 7))
				(and (== global384 3) (== global385 1))
				(and (== global384 8) (== global385 1))
				(and (== global384 8) (== global385 8))
			)
			(gGlobalSound fade:)
			(dink init: setScript: mainDinkScript)
			(dinkHair init:)
			(gEgo x: (- (gEgo x:) 30))
			(return 1)
		)
		(else
			(return 0)
		)
	)
)

(procedure (localproc_6)
	(if (and (== global384 local24) (== global385 local25))
		(hairPin init: posn: local22 local23 0 setCycle: 0)
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_7)
	(if (and (> (Random 0 99) 89) (not (cass script:)))
		(mazeBugScript start: 0)
		(mazeBug init: setScript: mazeBugScript)
		(return 1)
	else
		(return 0)
	)
)

(instance rm055 of KQ5Room
	(properties
		picture 55
	)

	(method (init)
		(LoadMany rsSCRIPT 603)
		(LoadMany rsVIEW 877 878 678 862 861 865 871 872 876)
		(Load rsSOUND 78)
		(Load rsVIEW 874 1060)
		(LoadMany rsSOUND 888 889 890 50)
		(super init:)
		(gEgo
			init:
			view: 0
			setLoop: -1
			loop: 3
			posn: 161 145 0
			setMotion: 0
			setCycle: KQ5SyncWalk
			cycleSpeed: 0
			setStep: 3 2
			setPri: 11
		)
		(switch gPrevRoomNum
			(56
				(arrow cel: 2)
				(= global384 5)
				(= global385 1)
				(= global383 0)
				(gEgo heading: 0)
			)
			(67
				(= global384 8)
				(= global385 6)
				(arrow cel: 1)
				(if (IsFlag 69)
					(cass
						init:
						setCycle: Walk
						setScript: cassScript
						posn: [local69 [local26 2]] [local73 [local26 2]] 0
						setPri: 10
						loop: 1
					)
					(= global383 270)
					(gEgo observeControl: 8 heading: 0)
				else
					(= global383 90)
					(gEgo heading: 0)
				)
				(SetFlag 67)
			)
			(else
				(= global384 3)
				(= global385 5)
				(arrow cel: 3)
				(= global383 0)
				(gEgo heading: 0)
				(HandsOff)
				(self setScript: (ScriptID 603 21)) ; dropInScript
			)
		)
		(localproc_0)
		(= gPrevRoomNum 55)
		(gGlobalSound loop: -1 number: 25 play:)
		(if (== script (ScriptID 603 21)) ; dropInScript
			((ScriptID 603 21) cue:) ; dropInScript
		)
		(self setFeatures: helpFeat room)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script
				(script doit:)
			)
			(local0
				(= local0 0)
				(HandsOn)
			)
			((== temp0 8)
				(+= global383 180)
				(localproc_0)
				(= local0 1)
			)
			((== temp0 1024)
				(localproc_0)
				(= local0 1)
			)
			((& temp0 $0040)
				(+= global383 90)
				(localproc_0)
				(= local0 1)
			)
			((& temp0 $0002)
				(+= global383 270)
				(localproc_0)
				(= local0 1)
			)
		)
	)

	(method (handleEvent event &tmp [temp0 100])
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (dispose)
		(gGlobalSound fade:)
		(DisposeScript 969)
		(DisposeScript 941)
		(DisposeScript 603)
		(super dispose:)
	)
)

(instance cassScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(HandsOff)
				(cass
					posn:
						[local69 [local26 (+ register 2)]]
						[local73 [local26 (+ register 2)]]
						0
					setPri: 10
					setMotion:
						MoveTo
						[local77 [local26 (+ register 2)]]
						[local81 [local26 (+ register 2)]]
						self
				)
			)
			(2
				(HandsOn)
				(cass z: 1000)
				(= cycles 120)
			)
			(3
				(= register 997)
				(= cycles 1)
			)
			(4
				(+= register 3)
				(cond
					((== [local26 register] -32768)
						(cass
							setPri: (- (door priority:) 1)
							posn: (- (door x:) 20) (door y:) 0
						)
						(HandsOff)
						(= cycles 1)
					)
					(
						(or
							(== register 1000)
							(!= global384 [local26 register])
							(!= global385 [local26 (+ register 1)])
						)
						(cass dispose:)
						(self dispose:)
					)
					(else
						(= cycles 0)
						(= start 1)
						(self init:)
					)
				)
			)
			(5
				(SetFlag 68)
				(gGlobalSound3 number: 122 loop: 1 play:)
				(door cel: (door lastCel:))
				(cass setMotion: MoveTo (+ (door x:) 2) (- (door y:) 2) self)
			)
			(6
				(gGlobalSound3 number: 124 loop: 1 play:)
				(door setCycle: Beg self)
			)
			(7
				(HandsOn)
				(cass z: 1000)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (IsFlag 110)
			(ClearFlag 110)
			(if (not (IsFlag 69))
				(cass z: 1000)
			)
			(gEgo loop: 3)
			(if (not (IsFlag 69))
				(if (<= state 2)
					(= cycles 0)
					(= start 4)
					(self init:)
				)
			else
				(self cue:)
				(ClearFlag 69)
			)
		)
		(if (& (cass onControl: 1) $0020)
			(cass setPri: 8)
		)
	)
)

(instance mainDinkScript of Script
	(properties)

	(method (dispose)
		(if (not (dink script:))
			(gGlobalSound loop: -1 number: 25 playBed:)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound number: 887 loop: -1 playBed:)
				(= register 3)
			)
		)
	)

	(method (doit &tmp temp0 temp1)
		(super doit: &rest)
		(cond
			(
				(and
					(>=
						(= temp0
							(GetAngle
								(client x:)
								(client y:)
								(gEgo x:)
								(gEgo y:)
							)
						)
						270
					)
					(<= temp0 360)
				)
				(= temp1 1)
			)
			((and (>= temp0 255) (<= temp0 269))
				(= temp1 2)
			)
			((and (>= temp0 106) (<= temp0 255))
				(= temp1 3)
			)
			((and (>= temp0 89) (<= temp0 105))
				(= temp1 4)
			)
			((and (>= temp0 0) (<= temp0 90))
				(= temp1 5)
			)
		)
		(if (!= temp1 register)
			(switch temp1
				(1
					(client setLoop: 4 cel: 0 setCycle: End)
				)
				(2
					(if (== register 1)
						(client setCycle: Beg)
					else
						(client setLoop: 0 cel: 0 setCycle: End)
					)
				)
				(3
					(if (== register 2)
						(client setLoop: 0)
						(client cel: (client lastCel:) setCycle: Beg)
					else
						(client setLoop: 1)
						(client cel: (client lastCel:) setCycle: Beg)
					)
				)
				(4
					(if (== register 5)
						(client setCycle: Beg)
					else
						(client setLoop: 1 cel: 0 setCycle: End)
					)
				)
				(5
					(client setLoop: 5 cel: 0 setCycle: End)
				)
			)
			(= register temp1)
		)
		(if (and (not (gCurRoom script:)) (gEgo inRect: 150 120 319 189))
			(HandsOff)
			(gCurRoom setScript: hugScript 0 temp1)
		)
	)
)

(instance hugScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(PrintDC 55 0 #at -1 20 #dispose) ; "Duh...DINK!"
				(= cycles 1)
			)
			(1
				(gEgo setPri: (+ (dink priority:) 1))
				(dink
					setScript: 0
					setLoop: 6
					cel: 0
					cycleSpeed: 3
					setCycle: CT 3 1 self
				)
			)
			(2
				((gEgo head:) dispose:)
				(gEgo dispose:)
				(dink setCycle: End self)
			)
			(3
				(= seconds 1)
				(Load rsVIEW 545)
				(= global103 0)
			)
			(4
				(cls)
				(= seconds 3)
			)
			(5
				(= global330
					{Shouldn't mess with Dink, Graham!}
				)
				(EgoDead 545)
			)
		)
	)
)

(instance giveTamboScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gEgo put: 34) ; Tambourine
				(HandsOff)
				(SetScore 3)
				(gEgo
					setPri: (+ (dink priority:) 1)
					setMotion: PolyPath (- (dink x:) 20) (dink y:) self
				)
				(if (and (== (dink loop:) 4) (!= (dink cel:) 0))
					(dink setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(1 0)
			(2
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 874
					setLoop: 5
					cel: 0
					cycleSpeed: 1
					setPri: (+ (dink priority:) 1)
					setCycle: RandCycle 30 self
				)
				(gGlobalSound2 number: 50 loop: -1 play:)
			)
			(3
				(gGlobalSound2 stop:)
				(dink setScript: 0 ignoreActors: 1)
				(if (== (dink loop:) 4)
					(= temp0 (- (dink x:) 3))
					(= temp1 (+ (dink y:) 2))
				else
					(= temp0 (dink x:))
					(= temp1 (dink y:))
				)
				(gEgo
					view: 1060
					setLoop: 1
					x: temp0
					y: temp1
					cel: 0
					cycleSpeed: 1
					setPri: (+ (dink priority:) 1)
					setCycle: End self
				)
				(UnLoad 132 50)
			)
			(4
				(gEgo
					normal: 1
					view: 0
					x: (- (dink x:) 20)
					y: (dink y:)
					cycleSpeed: 0
					setCycle: KQ5SyncWalk
					moveSpeed: (gGame egoMoveSpeed:)
					setScript: moveEgoScript
				)
				(gGlobalSound number: 890 loop: -1 playBed:)
				(dink
					view: 874
					setLoop: 2
					cel: 0
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(5
				(dink setCycle: End self)
			)
			(6
				(dink setCycle: End self)
			)
			(7
				(dink view: 874 setLoop: 3 cel: 0 setCycle: Fwd)
				(= seconds 5)
			)
			(8
				(gGlobalSound number: 888 loop: 1 playBed:)
				(UnLoad 132 890)
				(dink view: 1060 setLoop: 0 cel: 0 setCycle: End self)
			)
			(9
				(gGlobalSound number: 889 loop: 1 play:)
				(UnLoad 132 888)
				(hairPin init:)
				(self setScript: hairPinScript self)
			)
			(10
				(= local22 (hairPin x:))
				(= local23 (hairPin y:))
				(= local24 global384)
				(= local25 global385)
				(dink view: 873 setLoop: 4 cel: 0 setCycle: End self)
			)
			(11
				(dink
					setLoop: 3
					setPri: 10
					setCycle: Walk
					setMotion: MoveTo (- (dink x:) 75) (+ (dink y:) 75) self
				)
				(gGlobalSound fade:)
			)
			(12
				(gGlobalSound loop: -1 number: 25 playBed:)
				(hairPin setCycle: 0 ignoreActors: 1)
				(HandsOn)
				(UnLoad 132 889)
			)
			(13
				(dink dispose:)
				(self dispose:)
			)
		)
	)
)

(instance moveEgoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((gEgo head:) show:)
				(gEgo
					setMotion: MoveTo (- (gEgo x:) 45) (gEgo y:) self
				)
			)
			(1
				(gEgo loop: 0 setLoop: -1)
				((gEgo head:) show:)
				(self dispose:)
			)
		)
	)
)

(instance hairPinScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hairPin
					posn:
						(+ (hairPin x:) [local3 register])
						(+ (hairPin y:) [local3 (++ register)])
				)
				(= cycles 1)
			)
			(1
				(if (== [local3 (++ register)] -32768)
					(= cycles 1)
				else
					(self init:)
				)
			)
			(2
				(gGlobalSound3 number: 797 loop: 1 play:)
				(client cue:)
				(= seconds 3)
			)
			(3
				(hairPin setCycle: 0 ignoreActors: 1)
				(client setScript: 0)
			)
		)
	)
)

(instance goHoleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 162 131 self)
			)
			(1
				((gEgo head:) dispose:)
				(gEgo
					normal: 0
					view: 861
					setLoop: 0
					cel: 0
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(2
				(gEgo dispose:)
				(gCurRoom newRoom: 67)
			)
		)
	)
)

(instance goDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsSOUND 122 124)
				(gEgo setMotion: MoveTo (- (door x:) 4) (+ (door y:) 6) self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 678
					setLoop: 0
					cycleSpeed: 2
					cel: 0
					setCycle: End self
				)
				(gGlobalSound3 number: 122 loop: 1 play:)
				(door setCycle: End)
			)
			(2
				(gEgo
					normal: 1
					view: 0
					setLoop: -1
					cycleSpeed: 0
					loop: 3
					setCycle: KQ5SyncWalk
				)
				((gEgo head:) show:)
				(= cycles 2)
			)
			(3
				(gEgo
					setMotion: MoveTo (- (gEgo x:) 16) (gEgo y:) self
				)
			)
			(4
				(gEgo
					illegalBits: 0
					setPri: (- (door priority:) 1)
					setMotion: MoveTo (+ (door x:) 2) (- (door y:) 1) self
				)
			)
			(5
				(gEgo z: 1000)
				(door setCycle: Beg self)
			)
			(6
				(gGlobalSound3 number: 124 loop: 1 play:)
				(gCurRoom newRoom: 56)
			)
		)
	)
)

(instance lockedDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (- (door x:) 4) (+ (door y:) 6) self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 678
					setLoop: 2
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(= cycles 10)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(= cycles 10)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				((gEgo head:) show:)
				(gEgo
					normal: 1
					view: 0
					setLoop: -1
					loop: 3
					cycleSpeed: 0
					setCycle: KQ5SyncWalk
				)
				(= seconds 2)
			)
			(8
				(PrintDC 55 1) ; "Graham tries to open the wooden door, but to no avail. It's securely locked."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance pickLockScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetScore 4)
				(gEgo setMotion: MoveTo (- (door x:) 4) (+ (door y:) 6) self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 678
					setLoop: 1
					setCycle: RandCycle 15 self
				)
			)
			(2
				((gEgo head:) show:)
				(gEgo normal: 1 view: 0 setLoop: -1 setCycle: KQ5SyncWalk)
				(= seconds 1)
			)
			(3
				(PrintDC 55 2) ; "Graham inserts the hairpin into the door's large keyhole and discovers, to his amazement, that it fits perfectly! Turning it ever so gently, he soon hears a soft click and the door is unlocked!"
				(SetFlag 68)
				(HandsOn)
				(= global103 0)
				(self dispose:)
			)
		)
	)
)

(instance getHairPinScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: MoveTo (- (hairPin x:) 10) (hairPin y:) self
				)
			)
			(1
				((gEgo head:) hide:)
				(gEgo normal: 0 view: 56 setLoop: 2 setCycle: End self)
			)
			(2
				(SetScore 2)
				(gEgo get: 36 setCycle: Beg self) ; Hairpin
				(hairPin dispose:)
				(= local24 0)
				(= local25 0)
			)
			(3
				((gEgo head:) show:)
				(gEgo normal: 1 view: 0 setLoop: -1 setCycle: KQ5SyncWalk)
				(PrintDC 55 3) ; "Graham reaches down and grabs the hairpin off the labyrinth floor."
				(HandsOn)
				(= global103 0)
				(self dispose:)
			)
		)
	)
)

(instance mazeBugScript of Script
	(properties)

	(method (dispose)
		(gGlobalSound2 stop:)
		(mazeBug z: 1000)
		(= start 0)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(switch (Random 0 2)
					(0
						(mazeBug view: 871)
					)
					(1
						(mazeBug view: 872)
					)
					(2
						(mazeBug view: 876)
					)
				)
				(= cycles 5)
			)
			(1
				(= local85 0)
				(if
					(==
						(proc603_18 (proc603_3 -1 0 1 0) (proc603_4 0 -1 0 1))
						1
					)
					(|= local85 $0002)
				)
				(if
					(==
						(proc603_18 (proc603_3 1 0 -1 0) (proc603_4 0 1 0 -1))
						1
					)
					(|= local85 $0001)
				)
				(cond
					((and (& local85 $0002) (& local85 $0001))
						(= local85 (+ (Random 0 2) 2))
					)
					((and (not (& local85 $0002)) (not (& local85 $0001)))
						(= local85 (Random 0 1))
					)
					((and (not (& local85 $0002)) (& local85 $0001))
						(= local85 (* (Random 0 1) 6))
					)
					(else
						(= local85 (+ (= temp0 (Random 1 4)) (* 1 (> temp0 2))))
					)
				)
				(switch local85
					(0
						(= local86 [local89 0])
						(= local87 [local89 1])
						(= local88 [local89 2])
					)
					(1
						(= local86 [local98 0])
						(= local87 [local98 1])
						(= local88 [local98 2])
					)
					(2
						(= local86 [local107 0])
						(= local87 [local107 1])
						(= local88 [local107 2])
					)
					(3
						(= local86 [local122 0])
						(= local87 [local122 1])
						(= local88 [local122 2])
					)
					(4
						(= local86 [local137 0])
						(= local87 [local137 1])
						(= local88 [local137 2])
					)
					(5
						(= local86 [local152 0])
						(= local87 [local152 1])
						(= local88 [local152 2])
					)
					(6
						(= local86 [local164 0])
						(= local87 [local164 1])
						(= local88 [local164 2])
					)
				)
				(gGlobalSound2 number: 150 priority: 3 loop: -1 play:)
				(mazeBug
					posn: local86 local87 0
					setLoop: local88
					priority: 11
					show:
					setCycle: Fwd
				)
				(= register 3)
				(= cycles 1)
			)
			(2
				(switch local85
					(0
						(= local86 [local89 register])
						(= local87 [local89 (++ register)])
					)
					(1
						(= local86 [local98 register])
						(= local87 [local98 (++ register)])
					)
					(2
						(= local86 [local107 register])
						(= local87 [local107 (++ register)])
					)
					(3
						(= local86 [local122 register])
						(= local87 [local122 (++ register)])
					)
					(4
						(= local86 [local137 register])
						(= local87 [local137 (++ register)])
					)
					(5
						(= local86 [local152 register])
						(= local87 [local152 (++ register)])
					)
					(6
						(= local86 [local164 register])
						(= local87 [local164 (++ register)])
					)
				)
				(mazeBug setMotion: MoveTo local86 local87 self)
				(++ register)
			)
			(3
				(switch local85
					(0
						(= local88 [local89 register])
						(if (== [local89 register] -32768)
							(= register -1)
						)
					)
					(1
						(= local88 [local98 register])
						(if (== [local98 register] -32768)
							(= register -1)
						)
					)
					(2
						(= local88 [local107 register])
						(if (== [local107 register] -32768)
							(= register -1)
						)
					)
					(3
						(= local88 [local122 register])
						(if (== [local122 register] -32768)
							(= register -1)
						)
					)
					(4
						(= local88 [local137 register])
						(if (== [local137 register] -32768)
							(= register -1)
						)
					)
					(5
						(= local88 [local152 register])
						(if (== [local152 register] -32768)
							(= register -1)
						)
					)
					(6
						(= local88 [local164 register])
						(if (== [local164 register] -32768)
							(= register -1)
						)
					)
				)
				(if (== register -1)
					(self dispose:)
				else
					(mazeBug setLoop: local88)
					(++ register)
					(= start 2)
					(self init:)
				)
			)
		)
	)
)

(instance helpScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(helper z: 0)
				(arrow init: posn: (helper x:) (helper y:) 0)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			((== (gEgo loop:) 7)
				(= temp0 (arrow cel:))
			)
			((== (gEgo loop:) 3)
				(switch global383
					(0
						(= temp0 3)
					)
					(90
						(= temp0 1)
					)
					(180
						(= temp0 4)
					)
					(270
						(= temp0 2)
					)
				)
			)
			((== (gEgo loop:) 0)
				(switch global383
					(0
						(= temp0 1)
					)
					(90
						(= temp0 4)
					)
					(180
						(= temp0 2)
					)
					(270
						(= temp0 3)
					)
				)
			)
			((== (gEgo loop:) 2)
				(switch global383
					(0
						(= temp0 4)
					)
					(90
						(= temp0 2)
					)
					(180
						(= temp0 3)
					)
					(270
						(= temp0 1)
					)
				)
			)
			((== (gEgo loop:) 1)
				(switch global383
					(0
						(= temp0 2)
					)
					(90
						(= temp0 3)
					)
					(180
						(= temp0 1)
					)
					(270
						(= temp0 4)
					)
				)
			)
		)
		(arrow cel: temp0)
		(super doit:)
	)
)

(instance blinkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(client show:)
				(= cycles 4)
			)
			(2
				(client hide:)
				(self init:)
			)
		)
	)
)

(instance mazeBug of Actor
	(properties
		z 1000
		signal 24592
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 55 4) ; "A grotesque creature scurries along the stone walls of the labyrinth."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 55 5) ; "Graham can't catch the creature... and wouldn't want to!"
					(event claimed: 1)
				)
			)
		)
	)
)

(instance hole of Prop
	(properties
		signal 16400
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 55 6) ; "High above him, Graham sees the hole by which he entered these confusing underground tunnels."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 55 7) ; "The hole is much too high for Graham to ever reach. He'll have to find another way out."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance cell of Prop
	(properties
		signal 16400
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 55 8) ; "That's the hole through which Graham exited the dungeon."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: goHoleScript)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance door of Prop
	(properties
		signal 16400
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 55 9) ; "There is a wooden door here! Perhaps it will lead into the castle."
					(event claimed: 1)
				)
				(3 ; Do
					(if (not (IsFlag 68))
						(HandsOff)
						(gCurRoom setScript: lockedDoorScript)
					else
						(HandsOff)
						(gCurRoom setScript: goDoorScript)
					)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(1
							(PrintDC 55 10) ; "The key won't fit this lock."
							(event claimed: 1)
						)
						(36
							(if (IsFlag 68)
								(PrintDC 55 11) ; "The door is already unlocked."
							else
								(HandsOff)
								(gCurRoom setScript: pickLockScript)
							)
							(event claimed: 1)
						)
						(28
							(event claimed: 0)
						)
						(else
							(PrintDC 55 12) ; "That won't work with the labyrinth door."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance doorBack of Prop
	(properties
		view 863
		priority 9
		signal 24592
	)
)

(instance cass of Actor
	(properties
		view 864
		signal 24576
		illegalBits 0
	)
)

(instance dink of Actor
	(properties
		x 188
		y 138
		view 873
		priority 11
		signal 16400
		cycleSpeed 2
	)

	(method (init)
		(super init: &rest)
		(self setLoop: 0 cel: 0)
		(dinkBlink
			init:
			hide:
			setPri: (+ (dink priority:) 1)
			setScript: blinkScript
		)
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 55 13) ; "A huge beast, sporting a funny-looking topknot bound in a crude hairpin on top of his head, skulks in one dark corner of the labyrinth."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 55 14) ; "Graham should watch his step around this ugly beast!"
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(34
							(dink setScript: 0)
							(gCurRoom setScript: giveTamboScript)
							(event claimed: 1)
						)
						(28
							(event claimed: 0)
						)
						(else
							(PrintDC 55 15) ; "It makes no impression on the huge beast."
							(event claimed: 1)
						)
					)
				)
				(5 ; Talk
					(PrintDC 55 16) ; "Duh... Dink! Dink! Duh... duh... duh... Dink!"
					(event claimed: 1)
				)
			)
		)
	)
)

(instance dinkBlink of Prop
	(properties
		view 875
		signal 24592
	)

	(method (doit)
		(super doit:)
		(cond
			((!= (dink view:) 873)
				(self z: 1000)
			)
			((and (== (dink loop:) 0) (== (dink cel:) 0))
				(self posn: (dink x:) (- (dink y:) 39) 0 loop: 0 cel: 0)
			)
			((and (== (dink loop:) 0) (== (dink cel:) 6))
				(self posn: (- (dink x:) 4) (- (dink y:) 38) 0 loop: 0 cel: 1)
			)
			((and (== (dink loop:) 4) (== (dink cel:) 0))
				(self posn: (- (dink x:) 6) (- (dink y:) 36) 0 loop: 1 cel: 0)
			)
			((and (== (dink loop:) 4) (== (dink cel:) 4))
				(self posn: (- (dink x:) 10) (- (dink y:) 35) 0 loop: 1 cel: 1)
			)
			((and (== (dink loop:) 6) (== (dink cel:) 8))
				(self posn: (- (dink x:) 4) (- (dink y:) 38) 0 loop: 2 cel: 0)
			)
			(else
				(self z: 1000)
			)
		)
	)
)

(instance dinkHair of Prop
	(properties
		view 923
		priority 10
		signal 24592
	)

	(method (doit)
		(super doit:)
		(if (== (dink view:) 873)
			(self
				loop: (dink loop:)
				cel: (dink cel:)
				x: (dink x:)
				y: (dink y:)
				z: 0
			)
		else
			(self z: 1000)
		)
	)
)

(instance hairPin of Actor
	(properties
		view 874
		priority 11
		signal 24592
	)

	(method (init)
		(super init: &rest)
		(self
			setLoop: 4
			ignoreActors: 1
			posn: (+ (dink x:) 7) (- (dink y:) 46) 0
			setCycle: Fwd
		)
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 55 17) ; "Graham sees the beast's hairpin lying on the stone floor of the labyrinth."
					(event claimed: 1)
				)
				(3 ; Do
					(Load rsVIEW 56)
					(HandsOff)
					(gCurRoom setScript: getHairPinScript)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance priBlock of View
	(properties
		x 158
		y 41
		view 865
		loop 1
		priority 15
		signal 24592
	)
)

(instance room of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 55 18) ; "Graham looks around in terrified confusion as he finds himself in a labyrinth somewhere underneath Mordack's castle."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance helpFeat of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $4000))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(helper init: z: 1000 setScript: helpScript)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance helper of Prop
	(properties
		x 159
		y 168
		view 877
		loop 2
		priority 14
		signal 26640
	)
)

(instance arrow of View
	(properties
		view 877
		loop 2
		priority 14
		signal 24592
	)
)

