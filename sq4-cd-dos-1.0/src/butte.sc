;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 703)
(include sci.sh)
(use Main)
(use Sq4Narrator)
(use Sq4Feature)
(use StopWalk)
(use Motion)
(use Game)
(use User)
(use System)

(public
	butte 0
	butteFallScript 1
	policeLand 2
	cop 4
	shootEgoScript 5
	theRoom 6
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
	local33
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

(class rssScript of Script
	(properties)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if local30
			(if (or (== (= temp0 ((User curEvent:) type:)) evMOUSEBUTTON) (== temp0 evKEYBOARD))
				(= local30 0)
				(= seconds 0)
				(= cycles 1)
			)
			(= temp0 evNULL)
		)
	)
)

(class butte of Rgn
	(properties
		sawShadow 0
		beenCaptured 0
		policeLanded 4000
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
		(= local33 gGameSpeed)
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
				(!= (gEgo view:) 378)
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
					(not (-- local33))
				)
				(= local33 gGameSpeed)
				(if (not (-- policeLanded))
					(HandsOff)
					(gCurRoom setScript: policeLand)
				)
			)
		)
	)
)

(instance warnScript of rssScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cop setStep: 0 0 stopUpd:)
				(gEgo setStep: 0 0 stopUpd:)
				(HandsOff)
				(Animate (gCast elements:) 0)
				(= local32 1)
				(if (== (Random 1 2) 1)
					(tSP1 modNum: 703 say: 1 self) ; "This is Buford! You there, Delphoid? I found Wilco... repeat, I found Wilco!"
				else
					(tSP2 modNum: 703 say: 1 self) ; "This is Delphoid! You there, Buford? I found Wilco... repeat, I found Wilco!"
				)
				(= seconds 7)
			)
			(1
				(HandsOn)
				(cop setStep: 3 2 startUpd:)
				(gEgo setStep: 3 2 startUpd:)
				(if (and (== gPrevRoomNum 531) (== gCurRoomNum 305))
					(client setScript: shootEgoScript)
				)
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

(instance policePod of Sq4View
	(properties
		x 138
		y 79
		view 305
		loop 1
		cel 10
		priority 5
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 530 say: 1) ; "You give the Time Pod a long glance. It's not the most attractive vehicle you've ever seen. It resembles an overgrown titanium tennis shoe. A gold-tinted glass shield seals the top."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance door of Sq4Prop
	(properties
		x 79
		y 55
		view 305
		loop 2
		priority 6
		signal 16
	)
)

(instance police1 of Sq4Actor
	(properties
		x 102
		y 90
		view 378
		loop 2
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 703 say: 1) ; "A Sequel Policeman! Better keep a low profile."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance police2 of Sq4Actor
	(properties
		x 114
		y 91
		view 378
		loop 2
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 703 say: 1) ; "A Sequel Policeman! Better keep a low profile."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance policeLand of rssScript
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (== state 5) (== (gLongSong2 prevSignal:) -1))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0 stopUpd:)
				(gTheIconBar disable:)
				(= cycles 1)
			)
			(1
				(gNarrator x: 5 y: 155 modNum: 703 say: 2) ; "Meanwhile, on another part of the planet...."
				(= seconds 5)
			)
			(2
				(gTheIconBar disable:)
				(= cycles 1)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCast eachElementDo: #hide)
				(DrawPic 300 10)
				(self cue:)
			)
			(4
				(gEgo setMotion: 0)
				(policePod init: stopUpd:)
				(door init: cel: 0 setPri: 7)
				(= cycles 3)
			)
			(5
				(gEgo setMotion: 0)
				(gLongSong2 number: 124 loop: 1 vol: 127 play:)
			)
			(6
				(gLongSong2 number: 142 play:)
				(door setCycle: End self)
				(police1 illegalBits: 0 setPri: 6 init:)
				(police2 illegalBits: 0 setPri: 6 init:)
			)
			(7
				(gLongSong2 stop:)
				(gEgo setMotion: 0)
				(gNarrator x: 5 y: 155 modNum: 703 say: 3) ; "Oh No!! The Sequel Police!!"
				(= seconds 4)
			)
			(8
				(gEgo setMotion: 0)
				(door dispose:)
				(police2 setCycle: End self)
			)
			(9
				(police2
					view: 7
					cycleSpeed: 6
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo (+ (police2 x:) 30) (police2 y:) self
				)
			)
			(10
				(police1 setCycle: End self)
			)
			(11
				(Face police2 police1)
				(police1 view: 7 cycleSpeed: 6 setLoop: -1 setPri: 12)
				(= cycles 1)
			)
			(12
				(police1
					setCycle: Walk
					setMotion: MoveTo (+ (police1 x:) 2) (police1 y:) self
				)
			)
			(13
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(if (== gCurRoomNum 305)
					(tSP1 modNum: 703 say: 2 self) ; "Let's split up, I'll check out Wilco's time pod. Our sensors picked up some movement near there."
					(= seconds 7)
				else
					(tSP2 modNum: 703 say: 2 self) ; "Let's split up, I'll check out Wilco's time pod."
					(= seconds 5)
				)
			)
			(14
				(tSP1 modNum: 703 say: 3 self) ; "Yeah, Wilco is around here somewhere. I'll search the vicinity."
				(= seconds 5)
			)
			(15
				(police2 setMotion: MoveTo 300 80)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= seconds 3)
			)
			(16
				(gTheIconBar disable:)
				(= cycles 1)
			)
			(17
				(gEgo setMotion: 0)
				(policePod dispose: delete:)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(DrawPic gCurRoomNum 10)
				(police1 dispose: delete:)
				(police2 dispose: delete:)
				(gEgo show: setCycle: StopWalk 4)
				(if (== gCurRoomNum 305)
					((ScriptID 305 1) show:) ; pod
				)
				(gCast eachElementDo: #show)
				((gEgo _head:) show:)
				(= cycles 1)
			)
			(18
				(gTheIconBar enable:)
				(HandsOn)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance cop of Sq4Actor
	(properties
		view 7
		priority 8
		signal 8208
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 703 say: 1) ; "A Sequel Policeman! Better keep a low profile."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
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
				(gEgo setMotion: 0)
				(cop view: 13 cel: 0 setCycle: CT 1 1 self)
			)
			(2
				(gEgo setMotion: 0)
				(cop setCycle: End)
				(if
					(and
						(> (gEgo distanceTo: cop) 40)
						(not
							(and
								(== gCurRoomNum 310)
								(> (gEgo y:) 133)
								(< (gEgo priority:) 13)
							)
						)
					)
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
				else
					0
				)
				(= cycles 2)
			)
			(3
				(gEgo setMotion: 0)
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
					cycleSpeed: 6
					setCycle: CT 2 1 self
				)
			)
			(4
				(gEgo setMotion: 0)
				(cop view: 7)
				(gEgo setCycle: CT 1 -1 self)
			)
			(5
				(gEgo setMotion: 0)
				(gEgo setCycle: End self)
			)
			(6
				(gEgo setMotion: 0)
				(= seconds 3)
			)
			(7
				(EgoDead 8) ; "We're glad you could play SQIV. As usual, you've been a real pantload."
			)
			(8
				(if (not (gCurRoom script:))
					(EgoDead 8) ; "We're glad you could play SQIV. As usual, you've been a real pantload."
					(cop view: 7)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance theRoom of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (not (gCurRoom script:))
					(gCurRoom setScript: sEcho)
				else
					0
				)
			)
			(else 0)
		)
	)
)

(instance sEcho of Script
	(properties)

	(method (changeState newState &tmp [temp0 3])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0 setCycle: 0)
				(= cycles 2)
			)
			(1
				(gEgo view: 297 setCel: 0)
				(= ticks 30)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(tRogNar say: 2 self) ; "HELLLLLOOOO!"
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo
					view: 0
					loop: 3
					normal: 1
					moveHead: 1
					setLoop: -1
					setLoop: gStopGroop
					setMotion: 0
					setCycle: StopWalk 4
					setStep: 3 2
					illegalBits: 0
					ignoreActors: 0
					setSpeed: gGameSpeed
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance tRogNar of Sq4Narrator
	(properties
		noun 7
		modNum 297
		disposeWhenDone 0
		talkerNum 7
	)
)

(instance tSP1 of Sq4Talker
	(properties
		z 400
		noun 22
		modNum 703
		view 1015
		talkerNum 11
		mouthOffsetX 24
		mouthOffsetY 34
		eyeOffsetX 1
		eyeOffsetY 1
	)
)

(instance tSP2 of Sq4Talker
	(properties
		z 400
		noun 14
		modNum 703
		view 1016
		talkerNum 12
		mouthOffsetX 21
		mouthOffsetY 34
		eyeOffsetX 1
		eyeOffsetY 1
	)
)

