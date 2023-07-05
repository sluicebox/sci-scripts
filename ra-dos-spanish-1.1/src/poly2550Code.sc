;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2550)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2550Code 0
	pts2550 1
)

(local
	[local0 38] = [0 0 319 0 319 189 236 189 210 143 252 143 246 137 272 137 272 132 242 132 233 124 226 124 223 128 162 128 156 128 147 124 97 122 33 164 0 189]
	[local38 10] = [131 125 157 131 157 159 53 159 99 125]
)

(instance poly2550Code of Code
	(properties)

	(method (doit param1)
		(param1 add: (poly2550a init: yourself:) (poly2550b init: yourself:))
	)
)

(instance poly2550a of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 19)
		(= points @local0)
	)
)

(instance poly2550b of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 5)
		(= points @local38)
	)
)

(instance pts2550 of MuseumPoints
	(properties
		midPtX 140
		midPtY 160
		southPtX 140
		southPtY 250
		eastPtX 1245
		eastPtY 135
	)
)

