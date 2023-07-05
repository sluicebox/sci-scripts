;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2480)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2480Code 0
	pts2480 1
)

(local
	[local0 24] = [0 0 319 0 319 77 181 121 159 108 124 108 128 114 155 114 177 124 3 160 3 188 0 189]
	[local24 8] = [80 250 -4 175 114 158 231 240]
	[local32 10] = [289 102 345 100 319 189 310 198 133 150]
)

(instance poly2480Code of Code
	(properties)

	(method (doit param1)
		(param1
			add:
				(poly2480a init: yourself:)
				(poly2480b init: yourself:)
				(poly2480c init: yourself:)
		)
	)
)

(instance poly2480a of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 12)
		(= points @local0)
	)
)

(instance poly2480b of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 4)
		(= points @local24)
	)
)

(instance poly2480c of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 5)
		(= points @local32)
	)
)

(instance pts2480 of MuseumPoints
	(properties
		midPtX 115
		midPtY 150
		northPtX 150
		northPtY 110
	)
)

