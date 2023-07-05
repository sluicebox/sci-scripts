;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3022)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)
(use System)

(public
	london_12 0
)

(instance london_12 of Location
	(properties)

	(method (init)
		(ClearFlag 114)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(108 ; matrixPuzzle
				(if (IsFlag 35)
					(ClearFlag 35)
				)
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(3021 ; london_11
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(3025 ; london_15
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(3060 ; london_30
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(else
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 3251
		edgeS 0
		edgeN 0
	)

	(method (init)
		(southExitToLondon11 init:)
		(super init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 3252
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 100)
			(= picture 3260)
		)
		(super init:)
		(biotDispDoor_270 init:)
		(door init: setHotspot: 2)
		(if (IsFlag 100)
			(westExitToLondon30 init:)
		)
		(matrixPuzzle3 init: setHotspot: 2)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 3250
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(pit_90 init:)
		(pitPillars_90 init:)
		(mantisDoor_90 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 3249
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(gCurRoom setScript: trash_Carts)
		(pillars_0 init:)
		(carts_0 init:)
	)

	(method (dispose)
		(if (gCurRoom script:)
			((gCurRoom script:) dispose:)
		)
		(super dispose:)
	)
)

(instance southExitToLondon11 of ExitFeature
	(properties
		nextRoom 3021
	)
)

(instance westExitToLondon30 of ExitFeature
	(properties
		nsBottom 201
		nsLeft 243
		nsRight 346
		nsTop 100
		nextRoom 3060
		exitStyle 256
	)
)

(instance door of Feature
	(properties
		nsBottom 198
		nsLeft 145
		nsRight 239
		nsTop 103
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 100)
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 227 198 227 126 280 86 313 86 367 130 367 199 455 199 454 118 348 43 263 42 142 128 141 196 228 199
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
				(gCurRoom newRoom: 3030) ; london_Door_3
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance matrixPuzzle3 of Feature
	(properties
		nsBottom 199
		nsLeft 518
		nsRight 583
		nsTop 137
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

(instance trash_Carts of Script
	(properties)

	(method (dispose)
		(proc1111_6)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(switch (= temp0 (Random 1 3))
					(1
						(proc1111_7 3200 109 170 global161 0 0 1 self)
					)
					(2
						(proc1111_7 3201 79 177 global161 0 0 1 self)
					)
					(3
						(proc1111_7 3202 0 185 global161 0 0 1 self)
					)
				)
			)
			(1
				(= global161 0)
				(= state -1)
				(= seconds (Random 1 15))
			)
		)
	)
)

(instance trashCars_0 of Feature ; UNUSED
	(properties
		noun 21
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -2 176 77 164 135 167 146 177 447 176 462 165 526 168 575 172 590 195 592 219 2 214
					yourself:
				)
		)
	)
)

(instance pitPillars_0 of Feature ; UNUSED
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
					init: 225 89 350 79 356 68 381 63 388 72 443 63 452 54 486 55 490 23 517 16 531 34 527 111 591 165 474 170 414 167
					yourself:
				)
		)
	)
)

(instance biotDispDoor_270 of Feature
	(properties
		noun 12
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 75 230 74 134 146 36 228 1 358 0 439 33 490 88 509 131 506 231
					yourself:
				)
		)
	)
)

(instance pit_90 of Feature
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
					init: 38 244 38 164 73 166 77 237
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 160 167 395 163 587 173 586 217 539 223 549 239 484 243 388 231 340 232 292 253 201 259 153 238
					yourself:
				)
		)
	)
)

(instance pitPillars_90 of Feature
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
					init: 2 92 41 155 35 245 0 253
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 76 237 75 151 114 118 114 101 128 100 130 120 156 154 159 244 133 237
					yourself:
				)
		)
	)
)

(instance mantisDoor_90 of Feature
	(properties
		noun 18
		x 250
		y 141
		nsBottom 151
		nsLeft 240
		nsRight 260
		nsTop 131
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance carts_0 of Feature
	(properties
		noun 21
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 79 170 141 172 155 179 446 183 461 173 514 167 534 172 571 173 590 178 589 215 3 213 2 175 32 177 64 171
					yourself:
				)
		)
	)
)

(instance pillars_0 of Feature
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
					init: 261 86 355 75 359 62 386 64 403 75 449 66 449 58 482 56 489 54 488 20 523 14 527 99 582 159 587 169 469 166 227 163 222 161
					yourself:
				)
		)
	)
)

