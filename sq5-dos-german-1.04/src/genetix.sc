;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use VelocityMover)
(use Scaler)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	genetix 0
	proc31_1 1
	proc31_2 2
	sGenInNout 3
)

(local
	[local0 11] = [354 259 6 126 -20 -20 16 90 281 280 99]
	[local11 11] = [120 103 123 104 128 150 100 53 126 43 99]
	[local22 11] = [760 740 790 730 760 730 740 790 730 730 99]
)

(procedure (proc31_1 param1 param2)
	(gEgo
		view: 600
		init:
		signal: 12290
		posn: param1 param2
		moveSpeed: 0
		ignoreActors: 1
		illegalBits: 0
		setLoop: 1
		setPri: 15
		cycleSpeed: 2
		setStep: 7 7
		setCycle: Fwd
		setMotion: VelocityMover param1 param2 0 0
		looper: 0
	)
	(switch (gCurRoom picture:)
		(116
			(gEgo
				scaleSignal: (| (gEgo scaleSignal:) $0004)
				setScale: Scaler 64 17 139 24
			)
		)
		(112
			(gEgo
				scaleSignal: (| (gEgo scaleSignal:) $0004)
				setScale: Scaler 64 17 139 24
				setStep: 8 8
			)
		)
		(110
			(gEgo
				scaleSignal: (| (gEgo scaleSignal:) $0004)
				setScale: Scaler 64 17 139 24
				setStep: 3 3
				moveSpeed: 1
			)
		)
		(113
			(gEgo
				scaleSignal: (| (gEgo scaleSignal:) $0004)
				setScale: Scaler 64 17 139 24
				setStep: 3 3
				moveSpeed: 0
			)
		)
	)
)

(procedure (proc31_2 param1 &tmp temp0 temp1 temp2)
	(= temp1
		(switch
			(= temp0
				(cond
					((< 150 param1) 120)
					((< 100 param1) 33)
					((< 59 param1) 32)
					(else 31)
				)
			)
			(31 17)
			(32 17)
			(33 17)
			(120 70)
		)
	)
	(= temp2
		(switch temp0
			(31
				(if (OneOf (gCurRoom picture:) 112 116) 9 else 13)
			)
			(32
				(if (OneOf (gCurRoom picture:) 112 116) 9 else 13)
			)
			(33 13)
			(120 15)
		)
	)
	(gEgo setScale: Scaler temp0 temp1 167 80 setPri: temp2)
)

(class genetix of Rgn
	(properties)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 730 740 750 760 770 790))
		(= initialized 0)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(gSq5Music1 stop:)
		(gSq5Music2 stop:)
		(super dispose: &rest)
	)
)

(instance sGenInNout of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion: MoveTo [local0 register] [local11 register] self
				)
			)
			(1
				(if (and (IsFlag 23) (OneOf (gCurRoom curPic:) 110 112 113))
					(= seconds 2)
				else
					(= cycles 2)
				)
			)
			(2
				(if (== gCurRoom [local22 register])
					(gGame handsOn:)
					(self dispose:)
				else
					(gGame handsOn:)
					(gCurRoom newRoom: [local22 register])
				)
			)
		)
	)
)

(class MyFeature of Feature
	(properties)

	(method (init &tmp temp0)
		(= temp0 onMeCheck)
		(super init:)
		(self setOnMeCheck: 1 temp0)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((not (IsFlag 22))
				(super handleEvent: event &rest)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
					(IsFlag 22)
				)
				(event claimed: 1)
				(self doVerb: (event message:))
				(event claimed:)
				(return)
			)
		)
	)
)

(class MyProp of Prop
	(properties)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((not (IsFlag 22))
				(super handleEvent: event &rest)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
					(IsFlag 22)
				)
				(event claimed: 1)
				(self doVerb: (event message:))
				(event claimed:)
				(return)
			)
		)
	)
)

(class MyActor of Actor
	(properties)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((not (IsFlag 22))
				(super handleEvent: event &rest)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
					(IsFlag 22)
				)
				(event claimed: 1)
				(self doVerb: (event message:))
				(event claimed:)
				(return)
			)
		)
	)
)

(instance cliffy of MyActor ; UNUSED
	(properties
		noun 1
		view 20
		signal 16384
	)
)

