;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2510)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2510Code 0
	pts2510 1
)

(local
	[local0 46] = [45 162 4 169 4 189 0 189 0 0 319 0 319 189 313 189 313 133 309 133 309 168 284 168 252 161 256 154 286 154 286 139 207 151 89 151 84 148 40 148 5 137 5 153 36 153]
	[local46 8] = [125 175 188 175 188 183 125 183]
)

(instance poly2510Code of Code
	(properties)

	(method (doit param1)
		(param1 add: (poly2510a init: yourself:) (poly2510b init: yourself:))
	)
)

(instance poly2510a of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 23)
		(= points @local0)
	)
)

(instance poly2510b of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 4)
		(= points @local46)
	)
)

(instance pts2510 of MuseumPoints
	(properties
		midPtX 230
		midPtY 160
		northPtX 280
		northPtY 140
		southPtX 100
		southPtY 250
		eastPtX 1305
		eastPtY 163
		westPtX 15
		westPtY 150
	)
)

