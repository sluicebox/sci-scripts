;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2430)
(include sci.sh)
(use Main)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2430Code 0
	pts2430 1
)

(local
	[local0 32] = [11 185 307 185 307 139 292 129 319 129 319 125 270 125 270 114 120 114 110 70 108 114 92 114 85 123 24 116 76 129 11 163]
	[local32 30] = [34 156 307 156 307 139 292 129 319 129 319 125 270 125 270 114 120 114 110 70 102 114 92 114 85 123 24 116 76 129]
)

(instance poly2430Code of Code
	(properties)

	(method (doit param1)
		(param1
			add:
				(if
					(or
						(> gAct 3)
						(and (== gAct 3) (TimeCheck $b102 1)) ; can 11:15 pm occur?
					)
					(poly2430b init: yourself:)
				else
					(poly2430a init: yourself:)
				)
		)
	)
)

(instance poly2430a of Polygon
	(properties)

	(method (init)
		(= type 3)
		(= size 16)
		(= points @local0)
	)
)

(instance poly2430b of Polygon
	(properties)

	(method (init)
		(= type 3)
		(= size 15)
		(= points @local32)
	)
)

(instance pts2430 of MuseumPoints
	(properties
		midPtX 150
		midPtY 130
		northPtX 115
		northPtY 95
		eastPtX 315
		eastPtY 127
		westPtX 44
		westPtY 119
	)
)

