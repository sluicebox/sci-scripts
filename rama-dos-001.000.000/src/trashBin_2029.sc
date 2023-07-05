;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2029)
(include sci.sh)
(use Main)
(use Location)
(use cplainRegion)
(use Polygon)
(use Feature)

(public
	trashBin 0
)

(instance trashBin of CloseupLocation
	(properties
		heading 225
		picture 2191
	)

	(method (init)
		(super init: picture)
		(matrixB11z init: global117)
		(matrixB31z init: global117)
		(trashBin_225 init:)
	)
)

(instance matrixB11z of MigratingView
	(properties
		x 283
		y 166
		loop 1
		view 2191
		invItemID 51
	)

	(method (checkLocation param1)
		(return (== (param1 owner:) 2013))
	)
)

(instance matrixB31z of MigratingView
	(properties
		x 233
		y 225
		loop 1
		cel 1
		view 2191
		invItemID 60
	)

	(method (checkLocation param1)
		(return (== (param1 owner:) 2013))
	)
)

(instance trashBin_225 of Feature
	(properties
		noun 22
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 7 133 28 111 332 -1 381 -1 525 144 243 291 59 291
					yourself:
				)
		)
	)
)

