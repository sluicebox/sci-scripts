;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 235)
(include sci.sh)
(use Main)
(use n013)
(use Inset)
(use Cursor)
(use Actor)
(use System)

(public
	thermoInset 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance insetExitCursor of Cursor
	(properties
		view 961
	)
)

(instance doubleArrowCursor of Cursor
	(properties
		view 397
	)
)

(instance thermoInset of Inset
	(properties
		view 2341
		x 82
		y 32
		disposeNotOnMe 1
		noun 24
	)

	(method (doit &tmp temp0 temp1 temp2)
		(if script
			(script doit:)
		else
			(= temp1 ((gUser curEvent:) new:))
			(temp1 localize: plane)
			(if local0
				(if (> (= local1 (GetAngle 174 110 gMouseX gMouseY)) 100)
					(= local4 (/ (- local1 340) 5))
				else
					(= local4 (+ (/ local1 5) 4))
				)
				(arrow cel: local4)
			)
			(cond
				(
					(and
						(= temp0 (self onMe: temp1))
						(!= gTheCursor doubleArrowCursor)
					)
					(gGame setCursor: doubleArrowCursor 1)
				)
				((and (not temp0) (!= gTheCursor insetExitCursor))
					(gGame setCursor: insetExitCursor 1)
				)
			)
		)
	)

	(method (init &tmp temp0)
		(= local3 (gGame setCursor: doubleArrowCursor 1 155 95))
		(if (= local5 (or (!= gDay 2) (IsFlag 99)))
			(= cel 1)
			(super init: &rest)
		else
			(super init: &rest)
			(line
				init:
				setCel: (/ (- global179 50) 5)
				setPri: (+ (GetHighPlanePri) 1)
			)
			(arrow
				init:
				setCel: (/ (- global179 50) 5)
				setPri: (+ (GetHighPlanePri) 1)
			)
		)
		(gTheIconBar disable: 1 2 0 3 7 8 9 12 4)
		(if (= local0 0)
			(SetCursor 174 45)
			(SetCursor 151 43 206 59)
			(= temp0 (GetAngle 170 110 gMouseX gMouseY))
			(arrow
				cel:
					(if (> local1 100)
						(/ (- local1 340) 5)
					else
						(+ (/ local1 5) 4)
					)
			)
		)
		(UpdatePlane plane)
		(FrameOut)
		(self doVerb: 8)
	)

	(method (doVerb theVerb &tmp [temp0 2])
		(cond
			((!= theVerb 8) ; Operate
				(super doVerb: theVerb)
			)
			(local5
				(self setScript: imCovered)
			)
			(local0
				(= local0 0)
				(SetCursor 0 0 319 155)
			)
			(else
				(= local0 1)
				(SetCursor 174 45)
				(SetCursor 151 43 208 59)
			)
		)
	)

	(method (dispose)
		(if local5
			(= global179 65)
		else
			(= global179 (+ (* (arrow cel:) 5) 50))
		)
		(if (> global179 74)
			(gEgo getPoints: 191 1)
		)
		(gTheIconBar enable: 1 2 0 3 7 8 9)
		(super dispose:)
		(DisposeScript 235)
	)
)

(instance line of Prop
	(properties
		x 33
		y 41
		view 2341
		loop 1
		signal 16417
	)

	(method (doVerb theVerb)
		(thermoInset doVerb: theVerb)
	)
)

(instance arrow of Prop
	(properties
		x 92
		y 23
		view 2341
		loop 2
		cel 8
		signal 16417
	)

	(method (doVerb theVerb)
		(thermoInset doVerb: theVerb)
	)
)

(instance imCovered of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 19 8 64 1 self) ; "The control box is in a locked cage and can't be operated."
			)
			(1
				(thermoInset dispose:)
			)
		)
	)
)

