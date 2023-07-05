;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 82)
(include sci.sh)
(use Approach)

(class ApproachTo of Approach
	(properties)

	(method (init actor toX toY)
		(= x toX)
		(= y toY)
		(super init: actor self &rest)
	)
)

