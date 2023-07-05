;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2640)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2640Code 0
	pts2640 1
)

(local
	[local0 46] = [213 138 121 138 106 147 47 147 38 147 6 129 2 140 29 153 32 157 36 161 16 173 4 173 4 183 23 183 23 189 165 189 210 165 279 185 293 175 260 160 231 159 226 153 228 146]
)

(instance poly2640Code of Code
	(properties)

	(method (doit param1)
		(param1 add: (poly2640 init: yourself:))
	)
)

(instance poly2640 of Polygon
	(properties)

	(method (init)
		(= type 3)
		(= size 23)
		(= points @local0)
	)
)

(instance pts2640 of MuseumPoints
	(properties
		midPtX 145
		midPtY 155
		westPtX 1045
		westPtY 150
	)
)

