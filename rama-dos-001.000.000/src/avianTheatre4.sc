;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6403)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use Polygon)
(use Feature)
(use Actor)

(public
	avianTheatre4 0
)

(instance avianTheatre4 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(6401 ; avianTheatre2
				(self addPicObj: faceN faceE faceW faceN)
			)
			(else
				(self addPicObj: faceW faceN faceE faceW)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6409
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(gourdOnStage init:)
		(stage_0 init:)
		(lights_0 init:)
		(lightsBurnedOut_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 6408
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(westExitMirmicatStand init:)
		(westExitDoorToBackStage init:)
		(gCurRoom exitNE: westExitMirmicatStand)
		(gCurRoom exitNW: westExitDoorToBackStage)
		(stages_90 init:)
		(banner_90 init:)
		(doorToBkStage_90 init:)
		(myrmSeats_90 init:)
		(perches_90 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 6410
		edgeS 0
		edgeN 0
	)
)

(instance westExitMirmicatStand of ExitFeature
	(properties
		nsBottom 154
		nsLeft 370
		nsRight 548
		nsTop 63
		nextRoom 6401
	)
)

(instance westExitDoorToBackStage of ExitFeature
	(properties
		nsBottom 180
		nsLeft 233
		nsRight 283
		nsTop 123
		nextRoom 6402
	)
)

(instance gourdOnStage of View
	(properties
		x 446
		y 116
		cel 3
		view 6400
		z 10
	)

	(method (init)
		(if (== (proc70_9 35) 6403)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 35)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stage_0 of Feature
	(properties
		noun 23
		x 293
		y 176
		nsBottom 212
		nsLeft 2
		nsRight 584
		nsTop 140
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance lights_0 of Feature
	(properties
		noun 25
		x 292
		y 126
		nsBottom 145
		nsLeft 272
		nsRight 312
		nsTop 108
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance lightsBurnedOut_0 of Feature
	(properties
		noun 26
		x 470
		y 131
		nsBottom 147
		nsLeft 451
		nsRight 490
		nsTop 116
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance stages_90 of Feature
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
					init: 112 2 214 2 237 52 218 89 185 90 178 65 104 9
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 6 60 176 113 162 138 11 130
					yourself:
				)
		)
	)
)

(instance banner_90 of Feature
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
					init: 55 19 77 22 104 50 100 88 66 81
					yourself:
				)
		)
	)
)

(instance doorToBkStage_90 of Feature
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
					init: 229 123 254 123 267 165 256 178 231 176 218 163
					yourself:
				)
		)
	)
)

(instance myrmSeats_90 of Feature
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
					init: 341 147 341 140 388 129 399 133 407 140 437 139 440 151 383 151
					yourself:
				)
		)
	)
)

(instance perches_90 of Feature
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
					init: 402 132 588 88 587 108 440 143
					yourself:
				)
		)
	)
)

