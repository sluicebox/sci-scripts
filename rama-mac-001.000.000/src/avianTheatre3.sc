;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6402)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use Polygon)
(use Feature)
(use Actor)

(public
	avianTheatre3 0
)

(instance avianTheatre3 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(6404 ; avianBackStage1
				(self addPicObj: faceW faceE faceW)
			)
			(6403 ; avianTheatre4
				(self addPicObj: faceE faceW faceE)
			)
			(else
				(self addPicObj: faceE faceW faceE)
			)
		)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 6406
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(if (== (proc70_9 35) 6403)
			(gourdOnStage init: global117)
		)
		(eastExitMirmicatSeats init:)
		(eastExitGourd init:)
		(gCurRoom exitNW: eastExitMirmicatSeats)
		(gCurRoom exitNE: eastExitGourd)
		(stages_270 init:)
		(myrmSeats_270 init:)
		(perches_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 6407
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(westExitToBackStage init:)
		(gCurRoom exitN: westExitToBackStage)
		(doorBkstage_90 init:)
	)
)

(instance eastExitMirmicatSeats of ExitFeature
	(properties
		nsLeft 52
		nsTop 64
		nsRight 192
		nsBottom 161
		nextRoom 6401
	)
)

(instance eastExitGourd of ExitFeature
	(properties
		nsLeft 246
		nsTop 110
		nsRight 336
		nsBottom 179
		nextRoom 6403
	)
)

(instance westExitToBackStage of ExitFeature
	(properties
		nsLeft 198
		nsTop 38
		nsRight 398
		nsBottom 178
		nextRoom 6404
		exitStyle 13
	)
)

(instance gourdOnStage of View
	(properties
		x 279
		y 133
		z 10
		view 6400
		cel 2
	)
)

(instance doorBkstage_90 of Feature
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
					init: 231 44 344 42 397 229 356 275 231 277 186 232
					yourself:
				)
		)
	)
)

(instance stages_270 of Feature
	(properties
		noun 23
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 285 135 365 136 360 149 320 177 281 148
					yourself:
				)
		)
	)
)

(instance myrmSeats_270 of Feature
	(properties
		noun 24
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 83 155 85 143 108 144 117 138 184 142 186 151 138 158
					yourself:
				)
		)
	)
)

(instance perches_270 of Feature
	(properties
		noun 13
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 108 28 108 156 137 104 143 60 140
					yourself:
				)
		)
	)
)

