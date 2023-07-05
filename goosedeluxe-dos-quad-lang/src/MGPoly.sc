;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 406)
(include sci.sh)
(use Array)
(use Polygon)

(class MGPoly of Polygon
	(properties)

	(method (setPoints param1)
		(if points
			(points dispose:)
		)
		(= size (/ argc 2))
		(= points (IntArray with: param1 &rest))
		(= dynamic 1)
	)
)

