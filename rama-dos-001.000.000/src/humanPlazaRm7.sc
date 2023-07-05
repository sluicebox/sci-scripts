;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5207)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	humanPlazaRm7 0
)

(instance humanPlazaRm7 of Location
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(switch gPrevRoomNum
			(5204 ; humanPlazaRm4
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 5241
		edgeS 0
		edgeN 0
	)

	(method (init)
		(walls_180 init:)
		(super init: &rest)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5239
		edgeS 0
		edgeN 0
	)

	(method (init)
		(walls_0 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 5240
		edgeS 0
		edgeN 0
	)

	(method (init)
		(cond
			((and (IsFlag 245) (IsFlag 156))
				(= picture 5257)
			)
			((IsFlag 156)
				(= picture 5258)
			)
			((IsFlag 245)
				(= picture 5259)
			)
			(else
				(= picture 5240)
			)
		)
		(exitToHumanLair init:)
		(walls_270 init:)
		(lairDoor_270 init:)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 5238
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToHumanPlaza4 init:)
		(walls_90 init:)
		(super init: &rest)
	)
)

(instance exitToHumanPlaza4 of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 5204
	)
)

(instance exitToHumanLair of ExitFeature
	(properties
		nsBottom 226
		nsLeft 196
		nsRight 369
		nsTop 123
		nextRoom 5208
	)
)

(instance walls_0 of Feature
	(properties
		noun 32
		x 294
		y 104
		nsBottom 210
		nsLeft -1
		nsRight 590
		nsTop -1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance walls_90 of Feature
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 0 591 -1 591 180 553 179 552 182 362 182 363 183 72 185 72 197 -3 202
					yourself:
				)
		)
	)
)

(instance walls_180 of Feature
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 -1 591 0 590 200 285 197 285 192 166 189 168 180 -3 179
					yourself:
				)
		)
	)
)

(instance walls_270 of Feature
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 1 591 1 591 202 340 195 195 197 91 197 -1 202
					yourself:
				)
		)
	)
)

(instance lairDoor_270 of Feature
	(properties
		noun 10
		case 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 241 161 299 162 309 198 241 196
					yourself:
				)
		)
	)
)

