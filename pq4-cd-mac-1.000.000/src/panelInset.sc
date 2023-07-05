;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use Inset)
(use User)
(use Actor)
(use System)

(public
	panelInset 0
)

(local
	local0
	local1
)

(instance panelInset of Inset
	(properties
		picture -2
		view 525
		x 196
		y 25
		modNum 31
	)

	(method (doit)
		(if local0
			(self dispose:)
		else
			(super doit:)
		)
	)

	(method (dispose param1 &tmp temp0)
		(gFeatures delete: self)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(gWalkHandler delete: self)
		(gTheDoits delete: self)
		(if inset
			(inset dispose: 0)
		)
		(gCast eachElementDo: #dispose)
		(gFeatures eachElementDo: #dispose)
		(gMouseDownHandler eachElementDo: #dispose)
		(gKeyDownHandler eachElementDo: #dispose)
		(gDirectionHandler eachElementDo: #dispose)
		(gWalkHandler eachElementDo: #dispose)
		(FrameOut)
		(gCast dispose:)
		(plane dispose:)
		(= plane 0)
		(gFeatures dispose:)
		(gMouseDownHandler dispose:)
		(gKeyDownHandler dispose:)
		(gDirectionHandler dispose:)
		(gWalkHandler dispose:)
		((gCurRoom obstacles:) dispose:)
		(client inset: 0)
		(gCurRoom obstacles: oldObstacles)
		(= gCast (((gCurRoom plane:) casts:) at: 0))
		(= gFeatures oldFeatures)
		(= gMouseDownHandler oldMH)
		(= gKeyDownHandler oldKH)
		(= gDirectionHandler oldDH)
		(= gWalkHandler oldWH)
		(if (and (or (not argc) param1) caller)
			(= temp0 caller)
			(= caller 0)
			(temp0 cue:)
		)
		(gTheIconBar enable: 7 4 5)
		(Platform 0 2 0)
	)

	(method (drawInset)
		(= local0 0)
		(button1 init:)
		(button2 init:)
		(button3 init:)
		(button4 init:)
		(button5 init:)
		(button6 init:)
		(button7 init:)
		(button8 init:)
		(buttonG init:)
		(buttonOpen init:)
		(buttonClose init:)
		(emergencyButton init:)
		(panicButton init:)
		(gGame handsOn:)
		(super drawInset:)
		(gTheIconBar disable: 7 4 5)
		(plane setSize:)
		(Platform 0 2 1)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(cond
			(local1
				(event claimed: 1)
				(return)
			)
			((or (event modifiers:) (& (event type:) evMOUSERELEASE) local0)
				(event claimed: 0)
				(return)
			)
			(
				(or
					(& (event type:) evMOVE)
					(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
				)
				(gGame handsOff:)
				((gCurRoom script:) register: 1 cue:)
				(event claimed: 1)
				(= local0 1)
				(return 1)
			)
			((= temp0 (gCast firstTrue: #onMe event))
				(= temp1
					(if (== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
						((gTheIconBar curInvIcon:) message:)
					else
						((gTheIconBar curIcon:) message:)
					)
				)
				(temp0 doVerb: temp1)
				(event claimed: 1)
				(return)
			)
			(else
				(event globalize:)
				(OnMeAndLowY init:)
				(((gCurRoom plane:) casts:)
					eachElementDo: #eachElementDo 106 OnMeAndLowY event
				)
				(oldFeatures eachElementDo: #perform OnMeAndLowY event)
				(if (= temp0 (OnMeAndLowY theObj:))
					(= temp1
						(if (== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
							((gTheIconBar curInvIcon:) message:)
						else
							((gTheIconBar curIcon:) message:)
						)
					)
					(temp0 doVerb: temp1)
					(event claimed: 1)
					(return)
				)
			)
		)
	)
)

(instance button1 of View
	(properties
		noun 1
		modNum 31
		x 52
		y 51
		priority 250
		fixPriority 1
		view 525
		loop 1
		yStep 520
	)

	(method (init)
		(= cel (== yStep gCurRoomNum))
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== gCurRoomNum yStep)
				(gMessager say: noun theVerb 1 0 0 31) ; "You're currently in the lobby. Choose a different destination."
			else
				(= local1 1)
				(= cel 1)
				(gMessager say: noun theVerb 0 0 0 31) ; "You select the lobby as your destination."
				(gGame setScript: goToNewRoom 0 yStep)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance button2 of View
	(properties
		noun 2
		modNum 31
		x 27
		y 41
		priority 250
		fixPriority 1
		view 525
		loop 1
		yStep 530
	)

	(method (init)
		(= cel (== yStep gCurRoomNum))
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== gCurRoomNum yStep)
				(gMessager say: noun theVerb 1 0 0 31) ; "You're currently on the second floor. Choose a different destination."
			else
				(= local1 1)
				(= cel 1)
				(gMessager say: noun theVerb 0 0 0 31) ; "You select the second floor as your destination."
				(gGame setScript: goToNewRoom 0 yStep)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance button3 of View
	(properties
		noun 3
		modNum 31
		x 52
		y 41
		priority 250
		fixPriority 1
		view 525
		loop 1
		yStep 525
	)

	(method (init)
		(= cel (== yStep gCurRoomNum))
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== gCurRoomNum yStep)
				(gMessager say: noun theVerb 1 0 0 31) ; "You're currently on the third floor. Choose a different destination."
			else
				(= local1 1)
				(= cel 1)
				(gMessager say: noun theVerb 0 0 0 31) ; "You select the third floor as your destination."
				(gGame setScript: goToNewRoom 0 yStep)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance button4 of View
	(properties
		noun 4
		modNum 31
		x 27
		y 30
		priority 250
		fixPriority 1
		view 525
		loop 1
		yStep 512
	)

	(method (init)
		(= cel (== yStep gCurRoomNum))
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== gCurRoomNum yStep)
				(gMessager say: noun theVerb 1 0 0 31) ; "You're currently on the fourth floor. Choose a different destination."
			else
				(= local1 1)
				(= cel 1)
				(gMessager say: noun theVerb 0 0 0 31) ; "You select the fourth floor as your destination."
				(gGame setScript: goToNewRoom 0 yStep)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance button5 of View
	(properties
		noun 5
		modNum 31
		x 52
		y 30
		priority 250
		fixPriority 1
		view 525
		loop 1
		yStep 531
	)

	(method (init)
		(= cel (== yStep gCurRoomNum))
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== gCurRoomNum yStep)
				(gMessager say: noun theVerb 1 0 0 31) ; "You're currently on the fifth floor. Choose a different destination."
			else
				(= local1 1)
				(= cel 1)
				(gMessager say: noun theVerb 0 0 0 31) ; "You select the fifth floor as your destination."
				(gGame setScript: goToNewRoom 0 yStep)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance button6 of View
	(properties
		noun 6
		modNum 31
		x 27
		y 19
		priority 250
		fixPriority 1
		view 525
		loop 1
		yStep 532
	)

	(method (init)
		(= cel (== yStep gCurRoomNum))
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== gCurRoomNum yStep)
				(gMessager say: noun theVerb 1 0 0 31) ; "You're currently on the sixth floor. Choose a different destination."
			else
				(= local1 1)
				(= cel 1)
				(gMessager say: noun theVerb 0 0 0 31) ; "You select the sixth floor as your destination."
				(gGame setScript: goToNewRoom 0 yStep)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance button7 of View
	(properties
		noun 7
		modNum 31
		x 52
		y 19
		priority 250
		fixPriority 1
		view 525
		loop 1
		yStep 533
	)

	(method (init)
		(= cel (== yStep gCurRoomNum))
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== gCurRoomNum yStep)
				(gMessager say: noun theVerb 1 0 0 31) ; "You're currently on the seventh floor. Choose a different destination."
			else
				(= local1 1)
				(= cel 1)
				(gMessager say: noun theVerb 0 0 0 31) ; "You select the seventh floor as your destination."
				(gGame setScript: goToNewRoom 0 yStep)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance button8 of View
	(properties
		noun 8
		modNum 31
		x 27
		y 8
		priority 250
		fixPriority 1
		view 525
		loop 1
		yStep 534
	)

	(method (init)
		(= cel (== yStep gCurRoomNum))
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== gCurRoomNum yStep)
				(gMessager say: noun theVerb 1 0 0 31) ; "You're currently on the eighth floor. Choose a different destination."
			else
				(= local1 1)
				(= cel 1)
				(gMessager say: noun theVerb 0 0 0 31) ; "You select the eighth floor as your destination."
				(gGame setScript: goToNewRoom 0 yStep)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance buttonG of View
	(properties
		noun 11
		modNum 31
		x 27
		y 52
		priority 250
		fixPriority 1
		view 525
		loop 1
		yStep 570
	)

	(method (init)
		(= cel (== yStep gCurRoomNum))
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== gCurRoomNum yStep)
				(gMessager say: noun theVerb 1 0 0 31) ; "You're currently in the basement. Choose a different destination."
			else
				(= local1 1)
				(= cel 1)
				(gMessager say: noun theVerb 0 0 0 31) ; "You select the basement as your destination."
				(gGame setScript: goToNewRoom 0 yStep)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance buttonOpen of View
	(properties
		noun 10
		modNum 31
		x 27
		y 62
		priority 250
		fixPriority 1
		view 525
		loop 1
		yStep 0
	)
)

(instance buttonClose of View
	(properties
		noun 9
		modNum 31
		x 52
		y 62
		priority 250
		fixPriority 1
		view 525
		loop 1
		yStep 0
	)
)

(instance panicButton of View
	(properties
		noun 13
		modNum 31
		x 27
		y 72
		priority 250
		fixPriority 1
		view 525
		loop 1
		yStep 0
	)
)

(instance emergencyButton of View
	(properties
		noun 12
		modNum 31
		x 52
		y 72
		priority 250
		fixPriority 1
		view 525
		loop 1
		yStep 0
	)
)

(instance goToNewRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 4)
			)
			(1
				(panelInset dispose:)
				(= ticks 30)
			)
			(2
				((gCurRoom script:) caller: self cue:)
			)
			(3
				(if (!= register 525)
					(= gCurRoomNum 525)
				)
				(= local1 0)
				(self dispose:)
				(gCurRoom newRoom: register)
			)
		)
	)
)

