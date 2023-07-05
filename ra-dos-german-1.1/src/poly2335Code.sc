;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2335)
(include sci.sh)
(use Main)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2335Code 0
	pts2335 1
)

(local
	[local0 28] = [85 179 85 189 0 189 0 0 319 0 319 189 284 189 284 158 178 170 161 167 161 134 150 134 150 168 143 179]
	[local28 26] = [85 179 85 189 0 189 0 0 319 0 319 189 284 189 284 158 178 170 161 167 161 134 150 134 150 168]
)

(instance poly2335Code of Code
	(properties)

	(method (doit param1)
		(if (and (== gAct 2) (not (IsFlag 25)))
			(param1 add: (poly2335a init: yourself:))
		else
			(param1 add: (poly2335b init: yourself:))
		)
	)
)

(instance poly2335a of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 14)
		(= points @local0)
	)
)

(instance poly2335b of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 13)
		(= points @local28)
	)
)

(instance pts2335 of MuseumPoints
	(properties)
)

