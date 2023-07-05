;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6813)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Actor)

(public
	avianHatchery13 0
)

(instance avianHatchery13 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(faceE up: faceUpE)
		(faceUpE down: faceE)
		(switch gPrevRoomNum
			(6814 ; avianHatchery14
				(self addPicObj: faceN faceE faceN)
			)
			(else
				(self addPicObj: faceE faceN faceE)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25
				(switch picObj
					(faceE
						(westMural1 init: global117)
						(westMural2 init: global117)
					)
					(faceUpE
						(westUpMural init: global117)
					)
				)
			)
			(26
				(switch picObj
					(faceE
						(westMural1 dispose:)
						(westMural2 dispose:)
					)
					(faceUpE
						(westUpMural dispose:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 6880
		heading 90
		edgeS 0
	)

	(method (init)
		(super init:)
		(murals_90 init:)
		(jungleGym_90 init:)
	)
)

(instance faceUpE of CameraAngle
	(properties
		picture 6881
		heading 90
		edgeN 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(jungleGymBar init: setHotspot: 2)
		(super init:)
		(murals_90_up init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6882
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 6807 init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
	)
)

(instance jungleGymClimb of VMDMovie
	(properties
		movieName 6802
		frameRate 10
		endPic 6890
	)
)

(instance jungleGymBar of Feature
	(properties
		noun 39
		nsLeft 102
		nsTop 20
		nsRight 489
		nsBottom 174
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(jungleGymClimb play:)
				(gCurRoom newRoom: 6814) ; avianHatchery14
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance defaultExit of ExitFeature
	(properties
		nsLeft 101
		nsTop 61
		nsRight 523
		nsBottom 245
	)
)

(instance westMural1 of View
	(properties
		x 68
		y 253
		view 6813
	)
)

(instance westMural2 of View
	(properties
		x 307
		y 74
		view 6813
		cel 1
	)
)

(instance westUpMural of View
	(properties
		x 305
		y 254
		view 6813
		cel 2
	)
)

(instance murals_90 of Feature
	(properties
		noun 14
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 73 207 111 213 109 229 71 228
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 137 209 167 208 164 228 133 228
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 299 99 338 0 360 0 361 109 303 178
					yourself:
				)
		)
	)
)

(instance jungleGym_90 of Feature
	(properties
		noun 39
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 247 47 302 72 319 50 330 22 309 2 276 -1 265 15
					yourself:
				)
		)
	)
)

(instance murals_90_up of Feature
	(properties
		noun 14
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 313 291 350 181 369 294 yourself:)
		)
	)
)

