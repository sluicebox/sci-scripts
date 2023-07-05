;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Plane)

(class InvisibleWindow of Plane
	(properties)

	(method (open)
		(self init: &rest)
	)

	(method (init)
		(super init: &rest)
	)
)

(class HoyleWindow of Plane
	(properties
		brTop 0
		brLeft 0
		brBottom 200
		brRight 320
	)

	(method (open &tmp [temp0 12])
		(self init: &rest)
	)
)

