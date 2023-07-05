;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2525)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2525Code 0
	pts2525 1
)

(local
	[local0 8] = [0 0 5 0 5 5 0 5]
)

(instance poly2525Code of Code
	(properties)

	(method (doit param1)
		(param1 add: (poly2525a init: yourself:))
	)
)

(instance poly2525a of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 4)
		(= points @local0)
	)
)

(instance pts2525 of MuseumPoints
	(properties)
)

