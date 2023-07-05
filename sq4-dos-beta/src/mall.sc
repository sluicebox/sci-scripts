;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use RegionPath)
(use Inertia)
(use PolyPath)
(use StopWalk)
(use Sight)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	mall 0
	enS 1
	exS 2
	TestMallFlag 3
	eSwimCode 4
	proc700_5 5
	sp1 6
	sp2 7
)

(local
	[local0 43] = [32767 400 324 90 -5 90 32767 370 78 231 324 87 32767 375 78 233 324 87 32767 380 -5 142 324 127 32767 385 -5 142 324 158 32767 390 -5 89 239 233 32767 395 -5 88 230 238 -32768]
	[local43 43] = [32767 400 -5 145 324 145 32767 395 324 179 -5 3 32767 390 324 173 -5 0 32767 385 324 116 -5 100 32767 380 324 87 -5 101 32767 375 324 -3 -5 169 32767 370 324 -3 -5 169 -32768]
)

(procedure (TestMallFlag param1 param2 param3)
	(if (& (param1 param2:) param3)
		(return 1)
	else
		(return 0)
	)
)

(procedure (proc700_5 param1)
	(if param1
		(= global57 1)
		(gEgo illegalBits: 0)
		(if (IsObject (gEgo mover:))
			(gEgo
				setMotion: PolyPath ((gEgo mover:) x:) ((gEgo mover:) y:)
			)
		)
	else
		(= global57 0)
		(gEgo illegalBits: -32768)
	)
)

(procedure (localproc_0 param1) ; UNUSED
	(if (and (not (CantBeSeen gEgo param1 60 9)) (not (param1 z:)))
		(gCurRoom setScript: egoBumpScript 0 param1)
	)
)

(class mall of Rgn
	(properties
		enterBelt 0
		whichBelt 0
		rFlag1 0
		rFlag2 0
		rFlag3 0
	)

	(method (offScreen)
		(return
			(or
				(< (gEgo nsRight:) 0)
				(> (gEgo nsLeft:) 319)
				(< (gEgo nsBottom:) 0)
				(> ((gEgo _head:) nsTop:) 189)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(cond
			(
				(and
					(not (OneOf newRoomNumber 390 370))
					(IsFlag 24)
					(not (IsFlag 32))
				)
				(SetFlag 32)
				(if (gCast contains: shopper2)
					(shopperPath2 value: 29)
					(shopper2 z: 1000 setMotion: shopperPath2)
				)
				(if (gCast contains: shopper3)
					(shopperPath3 value: 11)
					(shopper3 z: 1000 setMotion: shopperPath3)
				)
			)
			((and (IsFlag 20) (not (IsFlag 32)))
				(if (gCast contains: shopper2)
					(shopper2 z: 2000)
				)
				(if (gCast contains: shopper3)
					(shopper3 z: 2000)
				)
			)
		)
		(if (SetFlag 26)
			(++ global110)
			(if (and (IsFlag 27) (> global110 2))
				(ClearFlag 27)
			)
		)
		(= keep
			(OneOf
				newRoomNumber
				370
				371
				375
				376
				380
				381
				385
				386
				387
				390
				391
				395
				397
				398
				399
				400
				405
				406
				410
				411
			)
		)
		(= initialized 0)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(Load rsVIEW 370)
		(Load rsVIEW 7)
		(if (!= gCurRoomNum 387)
			(shopper2 setCycle: Walk init: setMotion: shopperPath2)
			(shopper3 setCycle: Walk init: setMotion: shopperPath3)
		)
		(if (== (gEgo view:) 370)
			(gEgo setCel: 15)
		)
		(if (not (OneOf gCurRoomNum 405 406 410 411))
			(= temp0
				(switch (gEgo view:)
					(0 4)
					(402 14)
					(373 374)
				)
			)
			(gEgo setCycle: StopWalk temp0)
		)
		(if (OneOf gCurRoomNum 370 375 380 385 390 395 400)
			(gEgo setScript: nearScript)
		)
	)
)

(instance enS of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if
			(or
				(not (gEgo onControl: 1))
				(<= (gEgo x:) 0)
				(>= (gEgo x:) 319)
				(<= (gEgo y:) (gCurRoom horizon:))
				(>= (gEgo y:) 189)
			)
			0
		else
			(self dispose:)
			(HandsOn)
		)
		(register who: gEgo doit:)
	)
)

(instance exS of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (mall offScreen:)
			(gCurRoom newRoom: register)
		else
			((mall enterBelt:) who: gEgo doit:)
		)
	)
)

(instance moveNear of Motion
	(properties)

	(method (doit &tmp temp0)
		(if (self onTarget:)
			(self moveDone:)
		else
			(if (!= (client heading:) (GetAngle (client x:) (client y:) x y))
				(InitBresen self)
			)
			(super doit:)
		)
	)
)

(instance nearScript of Script
	(properties)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(
				(or
					(!= (gIconBar curIcon:) (gIconBar at: 0))
					(not (User controls:))
					(!= (event type:) evMOUSEBUTTON)
					(event modifiers:)
				)
				(super handleEvent: event)
			)
			(else
				(client
					setMotion:
						(if global57 PolyPath else moveNear)
						(event x:)
						(event y:)
				)
				(User prevDir: 0)
				(event claimed: 1)
			)
		)
	)
)

(instance eSwimCode of Inertia
	(properties
		maxInertia 5
	)
)

(instance spSwimCode of Inertia ; UNUSED
	(properties
		maxInertia 4
	)
)

(instance shopper2 of Actor
	(properties
		z 1000
		view 367
		signal 8192
		illegalBits 0
	)

	(method (doit)
		(super doit:)
		(cond
			((StepOn self 1)
				(if (not cycler)
					(self
						view: (if (IsFlag 32) 7 else 384)
						setCycle: Walk
						setCel: -1
						setStep: 4 2
					)
				)
			)
			(cycler
				(self
					view: (if (IsFlag 32) 13 else 367)
					setCycle: 0
					setCel: 0
					setStep: 2 2
				)
			)
		)
	)
)

(instance shopper3 of Actor
	(properties
		z 1000
		view 368
		signal 8192
		illegalBits 0
	)

	(method (doit)
		(super doit:)
		(cond
			((StepOn self 1)
				(if (not cycler)
					(self
						view: (if (IsFlag 24) 7 else 388)
						setCycle: Walk
						setCel: -1
						setStep: 5 2
					)
				)
			)
			((and (not script) cycler)
				(self
					view: (if (IsFlag 24) 13 else 368)
					setCycle: 0
					setCel: 0
					setStep: 2 2
				)
			)
		)
	)
)

(instance sp1 of Actor
	(properties
		view 7
		signal 24576
	)
)

(instance sp2 of Actor
	(properties
		view 7
		signal 24576
	)
)

(instance shopperPath2 of RegionPath
	(properties
		value 17
		theRegion 700
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(== currentRoom gCurRoomNum)
				(!= (client script:) spOnBelt)
				(IsFlag 32)
			)
			(client setScript: spOnBelt)
		)
	)

	(method (at param1)
		(return [local0 param1])
	)
)

(instance shopperPath3 of RegionPath
	(properties
		value 17
		theRegion 700
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(== currentRoom gCurRoomNum)
				(!= (client script:) spOnBelt)
				(IsFlag 32)
			)
			(client setScript: spOnBelt)
		)
	)

	(method (at param1)
		(return [local43 param1])
	)
)

(instance egoBumpScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(= temp1
					(GetAngle
						(register x:)
						(register y:)
						(gEgo x:)
						(gEgo y:)
					)
				)
				(= temp1 (umod (+ temp1 45) 360))
				(gEgo
					view: 370
					cel: 0
					setMotion: 0
					x: temp0 ; UNINIT
					setCycle: End self
				)
			)
			(1
				(User canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance egoStandScript of Script ; UNUSED
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo view: 0 setCycle: Walk)
				(self dispose:)
				(HandsOn)
			)
		)
	)
)

(instance spOnBelt of Script
	(properties)

	(method (doit)
		(cond
			((gCurRoom script:)
				(Face client gEgo)
			)
			((and (== state 0) (< 20 (client x:) 300))
				(self cue:)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState &tmp [temp0 4])
		(switch (= state newState)
			(0
				(HandsOff)
			)
			(1
				(ClearFlag 32)
				(Face client gEgo self)
			)
			(2
				(client setCel: 0 view: 13 setCycle: End self)
			)
			(3
				(EgoDead 700 0)
			)
		)
	)
)

