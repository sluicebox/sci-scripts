;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3007)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)

(public
	london_7 0
)

(instance london_7 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(108 ; matrixPuzzle
				(if (IsFlag 35)
					(ClearFlag 35)
				)
				(self addPicObj: faceN faceS faceN)
			)
			(3008 ; london_8
				(self addPicObj: faceS faceN faceS)
			)
			(else
				(self addPicObj: faceN faceS faceN)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 3111
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(southExitToLondon4 init:)
		(door2Out_180 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 3110
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(door init: setHotspot: 2)
		(if (IsFlag 99)
			(northExitToLondon8 init:)
			(gCurRoom drawPic: 3119)
		)
		(matrixPuzzle2 init: setHotspot: 2)
		(CP_Map_Piece_F init:)
		(NY_Map_Piece_E init:)
		(door3_0 init:)
	)
)

(instance CP_Map_Piece_F of View
	(properties
		x 551
		y 219
		loop 4
		view 3100
	)

	(method (init)
		(if (== (proc70_9 15) 3007)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (onMe param1)
		(return (and (<= 537 (param1 x:) 584) (<= 205 (param1 y:) 233)))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 15)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance NY_Map_Piece_E of View
	(properties
		x 494
		y 184
		loop 4
		cel 1
		view 3100
	)

	(method (init)
		(if (== (proc70_9 87) 3007)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (onMe param1)
		(return (and (<= 485 (param1 x:) 507) (<= 169 (param1 y:) 188)))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 87)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance southExitToLondon4 of ExitFeature
	(properties
		nextRoom 3004
	)
)

(instance northExitToLondon8 of ExitFeature
	(properties
		nsBottom 191
		nsLeft 244
		nsRight 339
		nsTop 101
		nextRoom 3008
		exitStyle 256
	)
)

(instance door of Feature
	(properties
		nsBottom 196
		nsLeft 169
		nsRight 249
		nsTop 109
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 99)
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 251 180 251 120 283 73 313 73 345 115 345 178 450 178 449 89 344 28 253 29 166 104 166 180 251 180
						yourself:
					)
			)
		else
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 164 182 447 181 444 117 357 40 253 35 169 98 164 180
						yourself:
					)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 3010) ; london_Door_2
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance matrixPuzzle2 of Feature
	(properties
		nsBottom 199
		nsLeft 517
		nsRight 583
		nsTop 134
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 108) ; matrixPuzzle
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door3_0 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 104 184 162 62 250 17 340 15 422 71 474 179
					yourself:
				)
		)
	)
)

(instance door2Out_180 of Feature
	(properties
		noun 7
		x 292
		y 134
		nsBottom 155
		nsLeft 273
		nsRight 312
		nsTop 113
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

