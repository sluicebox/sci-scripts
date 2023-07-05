;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2521)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2521Code 0
	pts2521 1
)

(local
	[local0 8] = [0 0 5 0 5 5 0 5]
)

(instance poly2521Code of Code
	(properties)

	(method (doit param1)
		(param1 add: (poly2521a init: yourself:))
	)
)

(instance poly2521a of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 4)
		(= points @local0)
	)
)

(instance pts2521 of MuseumPoints
	(properties)
)

