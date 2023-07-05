;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64946)
(include sci.sh)
(use Array)
(use WriteFeature)

(class Polygon of Obj
	(properties
		size 0
		points 0
	)

	(method (init)
		(= size (>> argc $0001))
		(= points (IntArray with: &rest))
	)

	(method (dispose)
		(points dispose:)
		(= points 0)
		(super dispose:)
	)

	(method (onMe oX oY &tmp temp0 temp1)
		(if (== argc 2)
			(= temp0 oX)
			(= temp1 oY)
		else
			(= temp0 (oX x:))
			(= temp1 (oX y:))
		)
		(return (InPolygon temp0 temp1 self))
	)
)

