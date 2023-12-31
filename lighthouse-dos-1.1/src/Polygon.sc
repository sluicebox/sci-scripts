;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64946)
(include sci.sh)
(use Array)
(use System)

(class Polygon of Obj
	(properties
		points 0
		dynamic 0
		size 0
		type PNearestAccess
	)

	(method (init thePoints &tmp [temp0 2])
		(= size (/ argc 2))
		(= points (IntArray with: thePoints &rest))
		(= dynamic 1)
	)

	(method (dispose)
		(if (and dynamic points)
			(points dispose:)
		)
		(super dispose:)
	)

	(method (onMe oX oY)
		(return (InPolygon oX oY self))
	)
)

