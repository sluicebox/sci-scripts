;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use Inset)
(use Actor)

(public
	forceFieldBelt 0
)

(instance forceFieldBelt of Inset
	(properties
		view 2760
		x 74
		y 20
		disposeNotOnMe 1
		modNum 45
		noun 3
	)

	(method (init)
		(gGame handsOn:)
		(gTheIconBar disable: 0 setupExit: 1 disable: 4 5 6)
		(if (not (& ((gTheIconBar at: 7) signal:) $0004))
			(gTheIconBar disable: 7)
		)
		(super init: &rest)
		(cond
			((IsFlag 63)
				(da init:)
			)
			((IsFlag 64)
				(pga init:)
			)
			(else
				(da init:)
				(pga init:)
			)
		)
	)

	(method (doit)
		(if (not ((gTheIconBar plane:) onMe: (gUser curEvent:)))
			(cond
				(
					(and
						(gUser canInput:)
						(not (self onMe: (gUser curEvent:)))
						(!= gTheCursor gTheExitCursor)
					)
					(gGame setCursor: gTheExitCursor 1)
				)
				(
					(and
						(gUser canInput:)
						(self onMe: (gUser curEvent:))
						(!= gTheCursor ((gTheIconBar curIcon:) getCursor:))
					)
					(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
				)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		((gTheIconBar at: 4) signal: (& ((gTheIconBar at: 4) signal:) $fffb) show:)
		(if (gInventory selectedInvIcon:)
			((gTheIconBar at: 7)
				signal: (& ((gTheIconBar at: 7) signal:) $fffb)
				show:
			)
		)
		((gTheIconBar at: 1) signal: (| ((gTheIconBar at: 1) signal:) $0004) show:)
		((gTheIconBar at: 2) signal: (| ((gTheIconBar at: 2) signal:) $0004) show:)
		((gTheIconBar at: 3) signal: (| ((gTheIconBar at: 3) signal:) $0004) show:)
		(cond
			((IsFlag 66)
				(if (== ((gTheIconBar at: 0) message:) 5)
					(gTheIconBar setupExit: 0)
				)
				(gTheIconBar select: (gTheIconBar at: 0))
				((gTheIconBar at: 0)
					signal: (| ((gTheIconBar at: 0) signal:) $0004)
					show:
				)
			)
			((and (IsFlag 72) (!= ((gTheIconBar at: 0) message:) 5))
				(gTheIconBar setupExit: 1)
			)
		)
		(SetFlag 65)
		(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
		(cond
			((IsFlag 63)
				(da dispose:)
			)
			((IsFlag 64)
				(pga dispose:)
			)
			(else
				(da dispose:)
				(pga dispose:)
			)
		)
		(super dispose: &rest)
		(gInventory showSelf:)
		(gTheIconBar show:)
	)
)

(instance da of Prop
	(properties
		noun 4
		modNum 45
		x 124
		y 56
		view 2760
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame points: 1 515)
				(if (IsFlag 63)
					(gEgo put: 7 get: 0) ; Belt_Da, Actuator
				else
					(SetFlag 64)
					(gEgo put: 8 get: 9 0) ; Belt_Da_Pga, Belt_Pga
				)
				(gInventory highlightedIcon: 0)
				((gInventory at: 0) select: 0 1) ; Actuator
				(gInventory curIcon: (gInventory at: 0)) ; Actuator
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
				(self hide:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pga of Prop
	(properties
		noun 5
		modNum 45
		x 53
		y 51
		view 2760
		cel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame points: 1 516)
				(if (IsFlag 64)
					(gEgo put: 9 get: 78) ; Belt_Pga, Pga_Hair
				else
					(SetFlag 63)
					(gEgo put: 8 get: 7 78) ; Belt_Da_Pga, Belt_Da
				)
				(gInventory highlightedIcon: 0)
				((gInventory at: 78) select: 0 1) ; Pga_Hair
				(gInventory curIcon: (gInventory at: 78)) ; Pga_Hair
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
				(self hide:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

