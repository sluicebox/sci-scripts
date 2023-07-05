;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6404)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	avianBackStage1 0
)

(instance avianBackStage1 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(6405 ; avianBackStage2
				(self addPicObj: faceW faceE faceW)
			)
			(else
				(self addPicObj: faceE faceW faceE)
			)
		)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 6420
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(westExitToBackStage2 init:)
		(gCurRoom exitN: westExitToBackStage2)
		(super init:)
		(doorAbove_90 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 6421
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(eastExitToTheatre init:)
		(gCurRoom exitN: eastExitToTheatre)
		(super init:)
		(doorThBk_270 init:)
	)
)

(instance westExitToBackStage2 of ExitFeature
	(properties
		nsLeft 242
		nsTop 110
		nsRight 336
		nsBottom 191
		nextRoom 6405
	)
)

(instance eastExitToTheatre of ExitFeature
	(properties
		nsLeft 187
		nsTop 34
		nsRight 442
		nsBottom 278
		nextRoom 6402
		exitStyle 13
	)
)

(instance doorThBk_270 of Feature
	(properties
		noun 30
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 227 41 365 41 416 273 396 291 194 291 171 267
					yourself:
				)
		)
	)
)

(instance doorAbove_90 of Feature
	(properties
		noun 29
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 279 17 306 19 317 64 305 69 278 69 270 67
					yourself:
				)
		)
	)
)

