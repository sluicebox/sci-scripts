;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5024)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)

(public
	NYAvian24 0
)

(instance NYAvian24 of CloseupLocation
	(properties
		noun 2
	)

	(method (init)
		(= heading 2)
		(if (IsFlag 224)
			(super init: 5113)
		else
			(super init: 5080)
		)
		(jack init:)
		(balcony_0 init:)
		(perches_0 init:)
		(pillar_0 init:)
		(stool init:)
	)
)

(instance jack of View
	(properties
		x 80
		y 267
		loop 9
		view 5002
	)

	(method (init)
		(if (== (proc70_9 38) 5018)
			(if (IsFlag 224)
				(= cel 1)
			else
				(= cel 2)
			)
			(super init: global117)
		)
	)
)

(instance stool of View
	(properties
		noun 28
		x 378
		y 191
		loop 9
		view 5002
	)

	(method (init)
		(if (== (proc70_9 111) 5022)
			(super init: global117)
			(self setHotspot: 144)
		)
	)
)

(instance perches_0 of Feature
	(properties
		noun 19
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 297 147 313 148 331 205 309 206
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 379 175 393 167 410 169 411 187 386 186
					yourself:
				)
		)
	)
)

(instance loosePerch_0 of Feature ; UNUSED
	(properties
		noun 28
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 380 178 392 169 412 170 412 186 390 186
					yourself:
				)
		)
	)
)

(instance balcony_0 of Feature
	(properties
		noun 20
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 294 149 293 223 593 225 426 175 378 169 355 157
					yourself:
				)
		)
	)
)

(instance pillar_0 of Feature
	(properties
		noun 18
		x 175
		y 137
		nsBottom 276
		nsLeft 67
		nsRight 284
		nsTop -2
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

