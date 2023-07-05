;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2620)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2620Code 0
	pts2620 1
)

(local
	[local0 8] = [0 0 5 0 5 5 0 5]
)

(instance poly2620Code of Code
	(properties)

	(method (doit param1)
		(param1 add: (poly2620a init: yourself:))
	)
)

(instance poly2620a of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 4)
		(= points @local0)
	)
)

(instance pts2620 of MuseumPoints
	(properties)
)

