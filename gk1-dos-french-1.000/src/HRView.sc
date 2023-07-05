;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use IconBar)
(use Actor)

(class HRView of View
	(properties)

	(method (init)
		(if (and (< view 10000) (IsHiRes))
			(= view (+ 10000 view))
		)
		(super init: &rest)
	)
)

(class HRProp of Prop
	(properties)

	(method (init)
		(if (and (< view 10000) (IsHiRes))
			(= view (+ 10000 view))
		)
		(super init: &rest)
	)
)

(class HRIconItem of IconI
	(properties)

	(method (init)
		(if (and (< mainView 10000) (IsHiRes))
			(= mainView (+ 10000 mainView))
			(= view (+ 10000 view))
		)
		(super init: &rest)
	)
)

