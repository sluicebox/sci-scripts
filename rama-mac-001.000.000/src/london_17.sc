;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3027)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	london_17 0
)

(instance london_17 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(faceN down: faceDownN)
		(faceDownN up: faceN)
		(switch gPrevRoomNum
			(3020 ; london_10
				(self addPicObj: faceN faceS faceN)
			)
			(else
				(self addPicObj: faceS faceN faceS)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 3255
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(southExitToLondon7 init:)
		(super init:)
		(door4Out_180 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 3205
		edgeN 0
	)

	(method (init)
		(super init:)
		(pitPillars_0 init:)
	)
)

(instance faceDownN of CameraAngle
	(properties
		picture 3206
		edgeS 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(super init:)
		(pitPillars_0_down init:)
		(walkway_0_down init:)
		(elevator_0_down init:)
	)
)

(instance southExitToLondon7 of ExitFeature
	(properties
		nextRoom 3020
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
					init: -2 148 50 92 95 152 96 285 0 289
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 350 151 390 101 433 152 429 285 353 288
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 476 151 503 90 585 116 588 157 560 159 559 283 470 289
					yourself:
				)
		)
	)
)

(instance door4Out_180 of Feature
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
					init: 226 183 239 53 281 53 285 23 300 22 305 53 346 54 359 189
					yourself:
				)
		)
	)
)

(instance pitPillars_0_down of Feature
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
					init: 84 111 34 2 127 1 149 67 145 106
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 339 27 338 -3 426 2 416 41 360 59
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 431 92 426 41 446 4 534 -2 482 102
					yourself:
				)
		)
	)
)

(instance walkway_0_down of Feature
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
					init: 150 288 278 173 231 36 251 33 304 169 535 217 531 141 545 153 553 241 301 191 192 290
					yourself:
				)
		)
	)
)

(instance elevator_0_down of Feature
	(properties
		noun 17
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 496 146 545 129 555 160 548 184 502 181
					yourself:
				)
		)
	)
)

