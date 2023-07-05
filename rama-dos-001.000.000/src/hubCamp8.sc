;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1008)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	hubCamp8 0
)

(instance hubCamp8 of Location
	(properties
		noun 20
	)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(1005 ; hubCamp5
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(else
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
		)
	)

	(method (pitch)
		(gCurRoom newRoom: 1005) ; hubCamp5
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 1081
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1181)
		)
		(super init: &rest)
		(ladder init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 1083
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1183)
		)
		(super init: &rest)
		(if (proc1111_24 80)
			(darkSky_0 init:)
		else
			(sea_0 init:)
			(lights_0 init:)
		)
		(fence_0 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 1082
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1182)
		)
		(super init: &rest)
		(if (proc1111_24 80)
			(darkSky_270 init:)
		)
		(fence_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 1084
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1184)
		)
		(super init: &rest)
		(exitToBomb init:)
		(gCurRoom exitN: exitToBomb)
		(gCurRoom setScript: blinking_Light)
		(if (proc1111_24 80)
			(darkSky_90 init:)
		)
		(fence_90 init:)
		(bomb_90 init:)
	)

	(method (dispose)
		(blinking_Light dispose:)
		(super dispose: &rest)
	)
)

(instance exitToBomb of ExitFeature
	(properties
		nsBottom 185
		nsLeft 226
		nsRight 340
		nsTop 133
		nextRoom 1009
	)
)

(instance ladder of Feature
	(properties
		noun 9
		x 270
		y 128
		nsBottom 254
		nsLeft 246
		nsRight 294
		nsTop 3
		case 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom exitStyle: 13)
				(gCurRoom newRoom: 1005) ; hubCamp5
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bombLight of View
	(properties
		view 1082
	)

	(method (init)
		(if (IsFlag 80)
			(self x: 283 y: 154 cel: 0)
			(super init: global117)
		else
			(self x: 287 y: 157 cel: 3)
			(super init: global117)
		)
	)
)

(instance blinking_Light of Script
	(properties)

	(method (init)
		(bombLight init:)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bombLight show:)
				(= seconds 1)
			)
			(1
				(bombLight hide:)
				(= state -1)
				(= seconds 1)
			)
		)
	)
)

(instance darkSky_0 of Feature
	(properties
		noun 1
		x 294
		y 35
		nsBottom 70
		nsRight 589
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance fence_0 of Feature
	(properties
		noun 10
		x 294
		y 171
		nsBottom 271
		nsLeft -2
		nsRight 590
		nsTop 71
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance fence_270 of Feature
	(properties
		noun 10
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 198 107 381 105 586 65 584 289 364 171 207 170
					yourself:
				)
		)
	)
)

(instance darkSky_270 of Feature
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 367 4 587 2 588 59 360 100
					yourself:
				)
		)
	)
)

(instance darkSky_90 of Feature
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 4 1 241 0 244 117 6 80 yourself:)
		)
	)
)

(instance fence_90 of Feature
	(properties
		noun 10
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -3 88 297 120 446 117 436 179 243 170 1 262
					yourself:
				)
		)
	)
)

(instance bomb_90 of Feature
	(properties
		noun 11
		x 299
		y 162
		nsBottom 180
		nsLeft 261
		nsRight 338
		nsTop 144
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance lights_0 of Feature
	(properties
		noun 18
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 63 2 167 64 144 66 33 4 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 416 67 523 0 557 1 444 66
					yourself:
				)
		)
	)
)

(instance sea_0 of Feature
	(properties
		noun 16
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 207 63 275 28 326 30 383 67 297 64
					yourself:
				)
		)
	)
)

