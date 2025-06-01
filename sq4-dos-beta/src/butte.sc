;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 703)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	butte 0
	butteFallScript 1
	policeLand 2
	cop 4
	shootEgoScript 5
)

(local
	[local0 13] = [300 305 315 310 315 305 300 299 306 299 300 310 320]
	[local13 13] = [300 300 310 320 310 300 299 306 299 300 305 315 310]
	local26 = 1
	local27 = 1
	local28
	local29
	local30
	local31
	local32
)

(procedure (localproc_0 &tmp temp0)
	(= temp0 (cop loop:))
	(DirLoop cop (GetAngle (cop x:) (cop y:) (gEgo x:) (gEgo y:)))
	(if (!= temp0 (cop loop:))
		(cop forceUpd:)
	)
	(cop setMotion: 0)
)

(procedure (localproc_1)
	(return
		(and
			(< (gEgo x:) 260)
			(> (gEgo x:) 60)
			(< (gEgo y:) 160)
			(> (gEgo y:) 80)
		)
	)
)

(procedure (localproc_2 param1 param2 param3 param4 &tmp temp0 temp1 temp2)
	(gLongSong2 number: 105 vol: 127 loop: 1 play:)
	(if (< param1 param3)
		(= temp0 (- param1 1))
		(= temp1 (+ param3 1))
	else
		(= temp0 (- param3 1))
		(= temp1 (+ param1 1))
	)
	(= temp2 (Graph grSAVE_BOX temp0 (- param2 1) temp1 (+ param4 1) 1))
	(Graph grDRAW_LINE param1 param2 param3 param4 global143 -1 -1)
	(Graph grREDRAW_BOX temp0 (- param2 1) temp1 (+ param4 1))
	(Wait 1)
	(Wait 4)
	(Graph grRESTORE_BOX temp2)
	(Graph grREDRAW_BOX temp0 (- param2 1) temp1 (+ param4 1) 1)
)

(class butte of Rgn
	(properties
		sawShadow 0
		beenCaptured 0
		policeLanded 1000
		junctioned 0
		roomCount 120
		oldPoliceRoom 0
		curPolice1Room 300
		curPolice2Room 305
		egoSwims 0
		onLedgeFlag 0
		sawGirlShadow 0
		entered315 0
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 299 300 305 306 310 315 320 298))
		(= junctioned (= initialized 0))
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(or (== gCurRoomNum curPolice1Room) (== gCurRoomNum curPolice2Room))
				(or
					(and (> (cop y:) 50) (< (cop y:) 150))
					(and (> (cop y:) 50) (< (cop y:) 150))
				)
				(!= local32 1)
			)
			(gCurRoom setScript: warnScript)
		)
		(cond
			(
				(and
					(< policeLanded 0)
					(!= junctioned 1)
					(or
						(== [local0 local26] gCurRoomNum)
						(== [local13 local27] gCurRoomNum)
					)
				)
				(= junctioned 1)
				(if (== [local0 local26] gCurRoomNum)
					(= oldPoliceRoom [local0 (- local26 1)])
				else
					(= oldPoliceRoom [local13 (- local27 1)])
				)
			)
			(
				(and
					(== junctioned 1)
					(!= [local0 local26] gCurRoomNum)
					(!= [local13 local27] gCurRoomNum)
				)
				(= junctioned 0)
			)
			((< policeLanded 0)
				(if
					(and
						(localproc_1)
						(< (-- roomCount) 0)
						(not (cop script:))
						(!= local26 12)
					)
					(= roomCount 120)
					(if (== [local0 local26] gCurRoomNum)
						(= oldPoliceRoom [local0 local26])
					else
						(= oldPoliceRoom [local13 local27])
					)
					(= curPolice1Room [local0 (++ local26)])
					(= curPolice2Room [local13 (++ local27)])
				)
			)
			(
				(and
					(not (gCurRoom script:))
					(not (gEgo edgeHit:))
					(!= gCurRoomNum 300)
					(!= gCurRoomNum 298)
					(not (-- policeLanded))
				)
				(HandsOff)
				(gCurRoom setScript: policeLand)
			)
		)
	)
)

(instance warnScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cop setStep: 0 0)
				(gEgo setStep: 0 0)
				(HandsOff)
				(= local32 1)
				(if (== (Random 1 2) 1)
					(= local30
						(proc0_12
							{"*** Alpha Delta Zebra Foxtrot. Do you read? I found Wilco... repeate I found Wilco!"}
							67
							2
							150
							28
							0
							29
							28
							30
							1
							28
							global135
							29
							global129
						)
					)
				else
					(= local30
						(proc0_12
							{"*** Beta Charlie Niner. Do you read? I found Wilco... repeate I found Wilco!"}
							67
							2
							150
							28
							0
							29
							28
							30
							1
							28
							global135
							29
							global129
						)
					)
				)
				(= seconds 7)
			)
			(1
				(HandsOn)
				(Display 703 0 dsRESTOREPIXELS local30)
				(cop setStep: 3 2)
				(gEgo setStep: 3 2)
				(self dispose:)
			)
		)
	)
)

(instance butteFallScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCast contains: cop)
					(cop setMotion: 0)
				)
				(gLongSong number: 131 vol: 127 loop: 1 play:)
				(gEgo
					view: 300
					x:
						(switch (gEgo loop:)
							(0
								(+ (gEgo x:) 10)
							)
							(1
								(- (gEgo x:) 10)
							)
							(else
								(gEgo x:)
							)
						)
					setLoop:
					setCycle: 0
					setStep: 3 20
					setPri:
					illegalBits: 0
					setMotion: MoveTo (gEgo x:) 250 self
				)
			)
			(1
				(= seconds 3)
			)
			(2
				(gLongSong fade: 0 1 2 1)
				(= seconds 1)
			)
			(3
				(EgoDead) ; "We're glad you could play SQIV. As usual, you've been a real pantload."
			)
		)
	)
)

(instance policePod of View
	(properties
		x 138
		y 79
		lookStr {You give the Time Pod a long glance. It's not the most attractive vehicle you've ever seen. It resembles an overgrown titanium tennis shoe. A gold-tinted glass shield seals the top.}
		view 305
		loop 1
		cel 10
		priority 5
		signal 16
	)
)

(instance door of Prop
	(properties
		x 79
		y 55
		view 305
		loop 2
		priority 6
		signal 16
	)
)

(instance police1 of Actor
	(properties
		x 102
		y 90
		lookStr {A Sequel Policeman! Better keep a low profile.}
		view 378
		loop 2
		signal 16384
	)
)

(instance police2 of Actor
	(properties
		x 114
		y 91
		lookStr {A Sequel Policeman! Better keep a low profile.}
		view 378
		loop 2
		signal 16384
	)
)

(instance policeLand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0 stopUpd:)
				(= cycles 1)
			)
			(1
				(Print 703 1 #at 5 155 #dispose) ; "Meanwhile, on another part of the planet...."
				(= seconds 5)
			)
			(2
				(gIconBar disable:)
				(= cycles 1)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCast eachElementDo: #hide)
				(DrawPic 300 30)
				(self cue:)
			)
			(4
				(gEgo setMotion: 0)
				(policePod init: stopUpd:)
				(door init: cel: 0 setPri: 7)
				(= cycles 3)
			)
			(5
				(gIconBar enable:)
				(gEgo setMotion: 0)
				(gLongSong2 number: 124 loop: 1 vol: 127 play:)
				(door setCycle: End self)
				(police1 illegalBits: 0 setPri: 6 init:)
				(police2 illegalBits: 0 setPri: 6 init:)
			)
			(6
				(gEgo setMotion: 0)
				(Print 703 2 #at 5 155 #dispose) ; "Oh No!! The Sequel Police!!"
				(= seconds 4)
			)
			(7
				(gEgo setMotion: 0)
				(door dispose:)
				(police2 setCycle: End self)
			)
			(8
				(police2
					view: 7
					cycleSpeed: 0
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo (+ (police2 x:) 30) (police2 y:) self
				)
			)
			(9
				(police1 setCycle: End self)
			)
			(10
				(Face police2 police1)
				(police1 view: 7 cycleSpeed: 0 setLoop: -1 setPri: 12)
				(= cycles 1)
			)
			(11
				(police1
					setCycle: Walk
					setMotion: MoveTo (+ (police1 x:) 2) (police1 y:) self
				)
			)
			(12
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= local30
					(proc0_12
						{"*** Let's split up, I'll check out Wilco's time pod."}
						67
						2
						10
						28
						0
						29
						28
						30
						1
						28
						global135
						29
						global129
					)
				)
				(= seconds 5)
			)
			(13
				(Display 703 0 dsRESTOREPIXELS local30)
				(= local30
					(proc0_12
						{"*** Yea, Wilco is around here somewhere. I'll go down to the water and take a look around."}
						67
						2
						150
						28
						0
						29
						28
						30
						1
						28
						global135
						29
						global129
					)
				)
				(= seconds 5)
			)
			(14
				(Display 703 0 dsRESTOREPIXELS local30)
				(= local30
					(proc0_12
						{"*** Yea, Wilco is around here somewhere. I'll go down to the water and take a look around."}
						67
						2
						150
						28
						0
						29
						28
						30
						1
						28
						global135
						29
						global129
					)
				)
				(= seconds 7)
			)
			(15
				(Display 703 0 dsRESTOREPIXELS local30)
				(police2 setMotion: MoveTo 300 80)
				(police1 setMotion: MoveTo 206 182)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= seconds 3)
			)
			(16
				(gIconBar disable:)
				(= cycles 1)
			)
			(17
				(gEgo setMotion: 0)
				(policePod dispose:)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(DrawPic gCurRoomNum 30)
				(police1 dispose:)
				(police2 dispose:)
				(gEgo show:)
				(if (== gCurRoomNum 305)
					((ScriptID 305 1) show:) ; pod
				)
				(= cycles 1)
			)
			(18
				(gIconBar enable:)
				(HandsOn)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance cop of Actor
	(properties
		lookStr {A Sequel Policeman! Better keep a low profile.}
		view 7
		priority 8
		signal 8208
	)
)

(instance shootEgoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(localproc_0)
				(if
					(and
						(>
							(= local31
								(GetAngle
									(cop x:)
									(cop y:)
									(gEgo x:)
									(gEgo y:)
								)
							)
							110
						)
						(< local31 235)
						(!= (cop loop:) 2)
					)
					(cop loop: 2)
				)
				(= cycles 2)
			)
			(1
				(cop view: 13 cel: 0 setCycle: CT 1 1 self)
			)
			(2
				(cop setCycle: End)
				(switch (cop loop:)
					(0
						(= local28 (+ (cop x:) 30))
						(= local29 (- (cop y:) 29))
					)
					(1
						(= local28 (- (cop x:) 35))
						(= local29 (- (cop y:) 27))
					)
					(2
						(= local28 (cop x:))
						(= local29 (- (cop y:) 27))
					)
					(3
						(= local28 (cop x:))
						(= local29 (- (cop y:) 40))
					)
					(4
						(= local28 (+ (cop x:) 20))
						(= local29 (- (cop y:) 27))
					)
					(5
						(= local28 (- (cop x:) 20))
						(= local29 (- (cop y:) 27))
					)
				)
				(if (< (cop x:) (gEgo x:))
					(localproc_2
						local29
						local28
						(- (gEgo y:) 32)
						(gEgo x:)
					)
				else
					(localproc_2
						(- (gEgo y:) 32)
						(gEgo x:)
						local29
						local28
					)
				)
				(= cycles 2)
			)
			(3
				(gEgo
					view: 26
					loop:
						(switch (gEgo loop:)
							(4 0)
							(5 1)
							(6 0)
							(7 1)
							(else
								(gEgo loop:)
							)
						)
					cel: 0
					cycleSpeed: 0
					setCycle: CT 2 1 self
				)
			)
			(4
				(cop view: 7)
				(gEgo setCycle: CT 1 -1 self)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(= seconds 3)
			)
			(7
				(EgoDead) ; "We're glad you could play SQIV. As usual, you've been a real pantload."
			)
			(8
				(if (not (gCurRoom script:))
					(EgoDead) ; "We're glad you could play SQIV. As usual, you've been a real pantload."
					(cop view: 7)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

