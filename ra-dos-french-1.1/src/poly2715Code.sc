;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2715)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2715Code 0
	pts2715 1
)

(local
	[local0 14] = [168 170 217 170 217 167 161 167 203 152 152 152 30 170]
	[local14 8] = [93 167 123 162 169 162 148 167]
)

(instance poly2715Code of Code
	(properties)

	(method (doit param1)
		(param1 add: (poly2715a init: yourself:) (poly2715b init: yourself:))
	)
)

(instance poly2715a of Polygon
	(properties)

	(method (init)
		(= type 3)
		(= size 7)
		(= points @local0)
	)
)

(instance poly2715b of Polygon
	(properties)

	(method (init)
		(= type 2)
		(= size 4)
		(= points @local14)
	)
)

(instance pts2715 of MuseumPoints
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

