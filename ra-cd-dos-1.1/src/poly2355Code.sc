;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2355)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2355Code 0
	pts2355 1
)

(local
	[local0 44] = [0 156 38 156 66 136 6 136 6 125 69 125 69 134 87 120 231 120 304 136 304 157 319 157 319 179 278 179 255 161 240 161 233 154 94 154 90 161 70 161 44 179 0 179]
	[local44 12] = [91 177 88 171 96 166 223 166 231 171 227 177]
	[local56 16] = [0 0 319 0 319 99 281 99 281 66 256 66 256 97 0 97]
)

(instance poly2355Code of Code
	(properties)

	(method (doit param1)
		(param1
			add:
				(poly2355a init: yourself:)
				(poly2355b init: yourself:)
				(poly2355c init: yourself:)
		)
	)
)

(instance poly2355a of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 22)
		(= points @local0)
	)
)

(instance poly2355b of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 6)
		(= points @local44)
	)
)

(instance poly2355c of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 8)
		(= points @local56)
	)
)

(instance pts2355 of MuseumPoints
	(properties)
)

