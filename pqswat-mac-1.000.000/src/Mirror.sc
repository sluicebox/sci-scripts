;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36)
(include sci.sh)
(use Actor)
(use System)

(public
	Mirror 0
)

(class Mirror of View
	(properties
		x 11
		y 347
		priority 501
		fixPriority 1
		view 15
		objList 0
	)

	(method (init)
		(super init: &rest)
		(= objList (Set new:))
	)

	(method (dispose)
		(objList dispose:)
		(super dispose: &rest)
	)

	(method (add param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(objList add: [param1 temp0])
		)
	)
)

