;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2055)
(include sci.sh)
(use Main)
(use Location)
(use cplainRegion)

(public
	trashBin 0
)

(instance trashBin of CloseupLocation
	(properties
		picture 2191
	)

	(method (init)
		(super init: picture)
		(CPMapPiece_2 init: global117)
		(NYMapPiece_3 init: global117)
		(matrixL11z init: global117)
		(matrixL22z init: global117)
		(matrixL31x init: global117)
		(matrixL32y init: global117)
	)
)

(instance CPMapPiece_2 of MigratingView
	(properties
		x 134
		y 185
		view 2191
		cel 1
		invItemID 11
	)

	(method (checkLocation param1)
		(return (== (param1 owner:) 2042))
	)
)

(instance NYMapPiece_3 of MigratingView
	(properties
		x 404
		y 130
		view 2191
		cel 3
		invItemID 85
	)

	(method (checkLocation param1)
		(return (== (param1 owner:) 2042))
	)
)

(instance matrixL11z of MigratingView
	(properties
		x 197
		y 241
		view 2191
		invItemID 66
	)

	(method (checkLocation param1)
		(return (== (param1 owner:) 2042))
	)
)

(instance matrixL22z of MigratingView
	(properties
		x 263
		y 109
		view 2191
		cel 2
		invItemID 72
	)

	(method (checkLocation param1)
		(return (== (param1 owner:) 2042))
	)
)

(instance matrixL31x of MigratingView
	(properties
		x 317
		y 110
		view 2191
		cel 5
		invItemID 73
	)

	(method (checkLocation param1)
		(return (== (param1 owner:) 2042))
	)
)

(instance matrixL32y of MigratingView
	(properties
		x 283
		y 166
		view 2191
		loop 1
		invItemID 77
	)

	(method (checkLocation param1)
		(return (== (param1 owner:) 2042))
	)
)

