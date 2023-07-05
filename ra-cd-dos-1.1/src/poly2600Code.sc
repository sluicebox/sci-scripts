;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2600)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2600Code 0
	pts2600 1
)

(local
	[local0 34] = [49 189 0 189 0 0 319 0 319 184 282 174 282 165 312 159 310 156 271 163 271 171 232 164 153 167 146 137 123 137 123 169 73 170]
	[local34 12] = [212 189 202 182 244 172 263 181 262 189 211 189]
)

(instance poly2600Code of Code
	(properties)

	(method (doit param1)
		(param1 add: (poly2600a init: yourself:) (poly2600b init: yourself:))
	)
)

(instance poly2600a of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 17)
		(= points @local0)
	)
)

(instance poly2600b of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 6)
		(= points @local34)
	)
)

(instance pts2600 of MuseumPoints
	(properties
		midPtX 120
		midPtY 180
		northPtX 1135
		northPtY 165
		southPtX 120
		southPtY 250
		eastPtX 1285
		eastPtY 165
	)
)

