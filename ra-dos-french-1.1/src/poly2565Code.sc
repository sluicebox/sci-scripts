;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2565)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2565Code 0
	pts2565 1
)

(local
	[local0 20] = [3 131 3 185 314 184 310 158 280 148 258 147 172 129 91 139 50 150 14 152]
)

(instance poly2565Code of Code
	(properties)

	(method (doit param1)
		(param1 add: (poly2565a init: yourself:))
	)
)

(instance poly2565a of Polygon
	(properties)

	(method (init)
		(= type 3)
		(= size 10)
		(= points @local0)
	)
)

(instance pts2565 of MuseumPoints
	(properties)
)

