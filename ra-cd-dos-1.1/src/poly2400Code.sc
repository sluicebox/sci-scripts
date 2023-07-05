;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2400)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2400Code 0
	pts2400 1
)

(local
	[local0 18] = [0 163 0 0 319 0 319 189 299 167 283 167 225 109 91 109 37 163]
	[local18 8] = [186 123 233 123 267 163 207 163]
)

(instance poly2400Code of Code
	(properties)

	(method (doit param1)
		(param1 add: (poly2400a init: yourself:) (poly2400b init: yourself:))
	)
)

(instance poly2400a of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 9)
		(= points @local0)
	)
)

(instance poly2400b of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 4)
		(= points @local18)
	)
)

(instance pts2400 of MuseumPoints
	(properties)
)

