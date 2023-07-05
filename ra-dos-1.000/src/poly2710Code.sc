;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2710)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2710Code 0
	pts2710 1
)

(local
	[local0 40] = [0 189 0 0 319 0 319 159 269 159 258 168 222 168 202 160 142 160 129 168 114 167 91 161 91 142 78 142 59 142 59 155 83 155 81 163 66 172 11 172]
	[local40 8] = [100 189 118 179 275 179 299 189]
)

(instance poly2710Code of Code
	(properties)

	(method (doit param1)
		(param1 add: (poly2710a init: yourself:) (poly2710b init: yourself:))
	)
)

(instance poly2710a of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 20)
		(= points @local0)
	)
)

(instance poly2710b of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 4)
		(= points @local40)
	)
)

(instance pts2710 of MuseumPoints
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

