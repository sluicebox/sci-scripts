;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2460)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2460Code 0
	pts2460 1
)

(local
	[local0 26] = [0 0 319 0 319 162 284 150 265 140 186 139 151 145 111 143 97 89 90 145 78 146 72 169 0 168]
	[local26 8] = [192 144 222 144 222 155 193 155]
)

(instance poly2460Code of Code
	(properties)

	(method (doit param1)
		(param1 add: (poly2460a init: yourself:) (poly2460b init: yourself:))
	)
)

(instance poly2460a of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 13)
		(= points @local0)
	)
)

(instance poly2460b of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 4)
		(= points @local26)
	)
)

(instance pts2460 of MuseumPoints
	(properties)
)

