;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2730)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2730Code 0
	pts2730 1
)

(local
	[local0 10] = [0 189 0 0 319 0 319 22 38 189]
	[local10 6] = [51 189 319 30 319 189]
)

(instance poly2730Code of Code
	(properties)

	(method (doit param1)
		(param1 add: (poly2730a init: yourself:) (poly2730b init: yourself:))
	)
)

(instance poly2730a of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 5)
		(= points @local0)
	)
)

(instance poly2730b of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 3)
		(= points @local10)
	)
)

(instance pts2730 of MuseumPoints
	(properties
		midPtX 200
		midPtY 164
		northPtX 298
		northPtY 140
		eastPtX 319
		eastPtY 189
		westPtY 153
	)
)

