;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3024)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Sound)

(public
	london_14 0
)

(instance london_14 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(3025 ; london_15
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(else
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 3213
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 113)
			(ClearFlag 113)
			(elevGoingDown play:)
		)
		(southExitToLondon15 init:)
		(super init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 3214
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 100)
			(= picture 3256)
		)
		(super init:)
		(pitPillars_270 init:)
		(pit_270 init:)
		(biotDispDoor_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 3212
		edgeS 0
		edgeN 0
	)
)

(instance faceN of CameraAngle
	(properties
		picture 3211
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(northExitToLondon13 init:)
		(if (proc1111_24 112)
			(SetFlag 112)
			(mantis play:)
		)
		(mantisDoor_0 init:)
		(pitPillars_0 init:)
		(elevControls_0 init:)
	)
)

(instance southExitToLondon15 of ExitFeature
	(properties
		nextRoom 3025
	)
)

(instance northExitToLondon13 of ExitFeature
	(properties
		nextRoom 3023
	)
)

(instance mantis of VMDMovie
	(properties
		movieName 3211
		frameRate 15
	)
)

(instance elevGoingDown of Sound
	(properties
		number 3224
		flags 5
	)
)

(instance mantisDoor_0 of Feature
	(properties
		noun 18
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 501 175 519 161 517 59 574 42 587 186 540 188
					yourself:
				)
		)
	)
)

(instance pitPillars_0 of Feature
	(properties
		noun 15
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 22 153 57 120 59 75 76 74 77 95 127 97 130 54 154 52 162 78 401 101 402 156 177 160 86 162 29 160
					yourself:
				)
		)
	)
)

(instance elevControls_0 of Feature
	(properties
		noun 20
		x 192
		y 159
		nsBottom 179
		nsLeft 181
		nsRight 203
		nsTop 140
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance pitPillars_270 of Feature
	(properties
		noun 15
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 431 147 463 123 465 103 476 104 479 120 512 152 510 221 467 219 434 221 434 164
					yourself:
				)
		)
	)
)

(instance pit_270 of Feature
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
					init: 0 186 106 163 252 161 431 159 435 216 392 227 329 227 287 209 195 214 143 215 134 200 26 204
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 518 166 586 168 589 235 519 218
					yourself:
				)
		)
	)
)

(instance biotDispDoor_270 of Feature
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
					init: 298 149 306 139 315 137 326 141 333 151
					yourself:
				)
		)
	)
)

