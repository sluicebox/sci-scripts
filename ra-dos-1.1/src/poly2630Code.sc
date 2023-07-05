;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2630)
(include sci.sh)
(use Main)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2630Code 0
	pts2630 1
)

(local
	[local0 42] = [98 141 90 144 69 144 46 154 0 154 0 189 311 189 311 151 298 151 257 143 265 139 298 139 297 132 268 132 259 141 231 141 220 145 169 145 159 143 115 143 109 141]
	[local42 42] = [98 141 90 144 69 144 46 154 0 154 0 189 311 189 311 151 298 151 258 143 265 139 298 139 297 132 268 132 259 141 231 141 220 145 169 145 159 143 115 143 109 141]
)

(instance poly2630Code of Code
	(properties)

	(method (doit param1)
		(if (IsFlag 12)
			(param1 add: (poly2630b init: yourself:))
		else
			(param1 add: (poly2630a init: yourself:))
		)
	)
)

(instance poly2630a of Polygon
	(properties)

	(method (init)
		(= type 3)
		(= size 21)
		(= points @local0)
	)
)

(instance poly2630b of Polygon
	(properties)

	(method (init)
		(= type 3)
		(= size 21)
		(= points @local42)
	)
)

(instance pts2630 of MuseumPoints
	(properties
		midPtX 230
		midPtY 155
		eastPtX 1255
		eastPtY 143
	)
)

