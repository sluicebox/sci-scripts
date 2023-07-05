;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2420)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2420Code 0
	pts2420 1
)

(local
	[local0 38] = [2 133 2 155 6 184 236 184 255 189 0 189 0 0 319 0 319 189 244 182 261 164 313 168 314 114 281 153 234 149 228 152 107 137 24 151 6 151]
	[local38 8] = [108 142 198 151 127 174 50 161]
)

(instance poly2420Code of Code
	(properties)

	(method (doit param1)
		(param1 add: (poly2420a init: yourself:) (poly2420b init: yourself:))
	)
)

(instance poly2420a of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 19)
		(= points @local0)
	)
)

(instance poly2420b of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 4)
		(= points @local38)
	)
)

(instance pts2420 of MuseumPoints
	(properties
		midPtX 160
		midPtY 180
		northPtX 300
		northPtY 125
		eastPtX 330
		eastPtY 230
		westPtX 3
		westPtY 150
	)
)

