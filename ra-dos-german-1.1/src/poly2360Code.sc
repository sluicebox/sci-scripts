;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2360)
(include sci.sh)
(use Main)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2360Code 0
	pts2360 1
)

(local
	[local0 24] = [0 0 319 0 319 95 247 95 200 100 155 113 89 137 75 146 52 146 22 168 17 189 0 189]
	[local24 30] = [0 0 319 0 319 95 247 95 247 120 200 120 200 100 155 113 152 136 89 137 75 146 52 146 22 168 17 189 0 189]
	[local54 10] = [258 164 420 164 420 179 245 179 241 168]
	[local64 8] = [128 152 128 181 59 181 59 152]
	[local72 8] = [148 176 191 176 191 189 148 189]
)

(instance poly2360Code of Code
	(properties)

	(method (doit param1)
		(param1
			add:
				(poly2360a init: yourself:)
				(poly2360b init: yourself:)
				(and (== gAct 2) (poly2360c init: yourself:))
				(and
					(OneOf global128 2 3 10 11 12)
					(poly2360d init: yourself:)
				)
		)
	)
)

(instance poly2360a of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size (if (> gAct 2) 12 else 15))
		(= points (if (> gAct 2) @local0 else @local24))
	)
)

(instance poly2360b of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 5)
		(= points @local54)
	)
)

(instance poly2360c of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 4)
		(= points @local64)
	)
)

(instance poly2360d of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 4)
		(= points @local72)
	)
)

(instance pts2360 of MuseumPoints
	(properties
		midPtX 220
		midPtY 130
		eastPtX 330
		eastPtY 120
	)
)

