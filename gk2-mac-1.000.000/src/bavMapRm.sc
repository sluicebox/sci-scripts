;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 800)
(include sci.sh)
(use Main)
(use n011)
(use MunichMapRm)
(use Plane)
(use Print)
(use System)

(public
	bavMapRm 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(procedure (localproc_0)
	(SetFlag 20)
	(if (!= gChapter 6)
		(SetFlag 18)
	else
		(ClearFlag 18)
		(ClearFlag 17)
	)
	(if (and (IsFlag 279) (!= gChapter 6)) ; "Do you know anything about the 'new Wagner opera'?" in topic810
		(SetFlag 16)
	else
		(ClearFlag 16)
	)
	(switch gChapter
		(4
			(if (and (IsFlag 622) (gEgo has: 44)) ; invDiaryTranslation
				(= local5 1)
			)
			(if (IsFlag 617)
				(= local4 1)
			)
			(if
				(and
					(IsFlag 995)
					(IsFlag 996)
					(IsFlag 997)
					(IsFlag 999)
					(IsFlag 1000)
					(IsFlag 624)
					(IsFlag 1002)
					(IsFlag 1003)
					(IsFlag 1004)
					(IsFlag 1005)
					(IsFlag 278) ; "Is there any way to see more of Ludwig's diary?" in topic810
					(IsFlag 279) ; "Do you know anything about the 'new Wagner opera'?" in topic810
				)
				(= local0 1)
			)
			(if
				(and
					(IsFlag 579)
					(IsFlag 580)
					(IsFlag 581)
					(IsFlag 582)
					(IsFlag 583)
					(IsFlag 584)
					(IsFlag 585)
					(IsFlag 586)
					(IsFlag 587)
					(IsFlag 588)
					(IsFlag 589)
					(IsFlag 590)
					(IsFlag 592)
					(IsFlag 628)
					(IsFlag 1031)
				)
				(= local3 1)
			)
		)
		(6
			(SetFlag 21)
			(ClearFlag 17)
			(ClearFlag 16)
			(= local4 1)
			(= local0 1)
			(= local1 1)
			(if (gEgo has: 58) ; invOperaAct3
				(= local3 1)
			)
			(if (and (IsFlag 710) (IsFlag 718) (IsFlag 387)) ; "Von Glower's Letter" in smithTopicCh6
				(= local5 1)
			)
		)
	)
)

(instance bavMapRm of MapRoom ; "Southern Bavaria Map"
	(properties
		noun 1
		picture 800
	)

	(method (newRoom newRoomNumber)
		(if (or local6 (OneOf newRoomNumber 100)) ; srExtRoom
			(Lock 140 800 0) ; WAVE
			(Lock rsAUDIO 801 0)
			(super newRoom: newRoomNumber &rest)
		else
			(gCurRoom setScript: goSomewhere 0 newRoomNumber)
		)
	)

	(method (init &tmp temp0)
		(= local6 0)
		(localproc_0)
		(ClearFlag 714)
		(gCurInvView update:)
		(gUser curVerb: 62)
		(= myList buttonList)
		(self setScript: flashEm)
		(super init: &rest)
		(Lock rsAUDIO 801 1)
		(gGk2Music setLoop: -1 number: 801 play:)
	)
)

(instance herrenSee of MapButton
	(properties
		noun 2
		modNum 800
		view 499
	)

	(method (setHintFlash)
		(self setFlash: (not local0))
	)

	(method (doMe)
		(SetFlag 409)
		(gGame handsOff:)
		(gCurRoom newRoom: 810)
	)
)

(instance ritter of MapButton
	(properties
		noun 3
		modNum 800
		view 499
		loop 1
	)

	(method (setHintFlash)
		(self setFlash: (not local5))
	)

	(method (doMe)
		(gGame handsOff:)
		(gCurRoom newRoom: 100) ; srExtRoom
	)
)

(instance altotting of MapButton
	(properties
		noun 4
		modNum 800
		view 499
		loop 2
	)

	(method (setHintFlash)
		(self setFlash: (not local2))
	)

	(method (doMe)
		(SetFlag 409)
		(gGame handsOff:)
		(gCurRoom newRoom: 10045)
	)
)

(instance wanfried of MapButton
	(properties
		noun 5
		modNum 800
		view 499
		loop 3
	)

	(method (setHintFlash)
		(self setFlash: (not local1))
	)

	(method (doMe)
		(SetFlag 409)
		(gGame handsOff:)
		(gCurRoom newRoom: 850) ; wahnEntryRm
	)
)

(instance neu of MapButton
	(properties
		noun 6
		modNum 800
		view 499
		loop 4
	)

	(method (setHintFlash)
		(self setFlash: (not local3))
	)

	(method (doMe)
		(SetFlag 409)
		(gGame handsOff:)
		(gCurRoom newRoom: 900)
	)
)

(instance starnSee of MapButton
	(properties
		noun 7
		modNum 800
		view 499
		loop 5
	)

	(method (setHintFlash)
		(self setFlash: (not local4))
	)

	(method (doMe)
		(SetFlag 409)
		(gGame handsOff:)
		(gCurRoom newRoom: 840) ; starnSeeRm
	)
)

(instance bavMapPrint of Print ; UNUSED
	(properties)

	(method (addButtonBM param1)
		(if (IsFlag param1)
			(super addButtonBM: &rest)
		)
	)

	(method (init)
		(= plane (Plane new:))
		(plane picture: -2)
		(self posn: 6 19)
		(super init: &rest)
	)
)

(instance buttonList of List
	(properties)

	(method (init)
		(if (and (!= gChapter 6) (IsFlag 18))
			(self add: (herrenSee init: 18 406 139))
		)
		(SetFlag 20)
		(self add: (ritter init: 20 231 178))
		(if (IsFlag 21)
			(self add: (altotting init: 21 493 9))
		)
		(if (IsFlag 16)
			(self add: (wanfried init: 16 376 1))
		)
		(if (IsFlag 19)
			(self add: (neu init: 19 90 206))
		)
		(if (IsFlag 17)
			(self add: (starnSee init: 17 162 98))
		)
		(super init: &rest)
	)
)

(instance goSomewhere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Lock 140 800 1) ; WAVE
				(Lock rsAUDIO 801 0)
				(= local6 1)
				(gGame handsOff:)
				(= seconds 1)
			)
			(1
				(gGk2Music number: 800 setLoop: 1 play: self)
			)
			(2
				(gCurRoom newRoom: register)
				(self dispose:)
			)
		)
	)
)

(instance flashEm of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(for ((= temp0 0)) (< temp0 (buttonList size:)) ((++ temp0))
					(= temp1 (buttonList at: temp0))
					(if (temp1 pFlash:)
						(temp1 hilite: 0)
					)
				)
				(= ticks 15)
			)
			(1
				(for ((= temp0 0)) (< temp0 (buttonList size:)) ((++ temp0))
					(if ((buttonList at: temp0) pFlash:)
						((buttonList at: temp0) hilite: 1 setHintFlash:)
					)
				)
				(= ticks 15)
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

