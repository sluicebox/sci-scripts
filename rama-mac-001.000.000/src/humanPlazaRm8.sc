;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5208)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	humanPlazaRm8 0
)

(instance humanPlazaRm8 of Location
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(if (not (IsFlag 245))
			(faceW down: faceDownW)
			(faceDownW up: faceW)
		)
		(switch gPrevRoomNum
			(5207 ; humanPlazaRm7
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
		picture 5242
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(walls_180 init:)
		(moat_180 init:)
		(super init: &rest)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5244
		edgeN 0
		edgeS 0
	)

	(method (init)
		(walls_0 init:)
		(moat_0 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 5245
		heading 270
		edgeN 0
	)

	(method (init)
		(if (IsFlag 245)
			(= edgeS 0)
		)
		(cond
			((and (IsFlag 245) (IsFlag 156))
				(= picture 5260)
				(exitToHumanLair init:)
			)
			((IsFlag 156)
				(= picture 5261)
			)
			((IsFlag 245)
				(= picture 5262)
				(exitToHumanLair init:)
			)
			(else
				(= picture 5245)
			)
		)
		(walls_270 init:)
		(lairDoor_270 init:)
		(moat_270 init:)
		(bridge_270 init:)
		(super init: &rest)
	)
)

(instance faceDownW of CameraAngle
	(properties
		picture 5246
		heading 270
		edgeS 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(moat_270_down init:)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 5243
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToHumanPlaza7 init:)
		(walls_90 init:)
		(super init: &rest)
	)
)

(instance exitToHumanPlaza7 of ExitFeature
	(properties
		nsLeft 371
		nsTop 89
		nsRight 499
		nsBottom 209
		nextRoom 5207
	)
)

(instance exitToHumanLair of ExitFeature
	(properties
		nsLeft 185
		nsTop 7
		nsRight 425
		nsBottom 144
		nextRoom 5209
	)
)

(instance walls_0 of Feature
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
					init: -1 0 590 0 590 206 372 204 -1 233
					yourself:
				)
		)
	)
)

(instance moat_0 of Feature
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
					init: -1 273 220 265 221 290 -1 291
					yourself:
				)
		)
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
					init: 0 -2 590 0 591 182 371 183 263 182 264 186 -2 206
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
					init: -1 -1 590 1 590 250 433 219 101 195 101 188 95 188 95 179 -1 178
					yourself:
				)
		)
	)
)

(instance moat_180 of Feature
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
					init: 260 273 590 258 591 291 265 291
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
					init: -1 0 591 1 590 137 545 142 55 142 -3 135
					yourself:
				)
		)
	)
)

(instance lairDoor_270 of Feature
	(properties
		noun 10
		case 5
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 229 6 261 50 248 67 199 64 200 53 197 50 192 41 191 33 192 27 189 24 190 19 193 17 199 19 201 14 218 10 220 13
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 373 4 380 11 385 7 390 12 395 8 405 18 409 15 412 21 410 28 412 36 405 45 401 48 404 64 353 67 340 48
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 285 12 317 12 344 80 353 80 357 86 386 109 385 116 391 117 390 129 380 132 381 135 397 135 400 141 400 147 202 145 201 141 206 135 220 134 221 132 210 127 210 116 216 115 215 108 245 87 248 80 258 80
					yourself:
				)
		)
	)
)

(instance moat_270 of Feature
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
					init: 56 140 185 142 125 183 142 188 190 188 369 189 418 191 463 188 481 184 417 144 547 141 592 149 590 272 -2 276 0 156
					yourself:
				)
		)
	)
)

(instance bridge_270 of Feature
	(properties
		noun 14
	)

	(method (init)
		(if (IsFlag 245)
			(super init: &rest)
			(self
				setHotspot: 144
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 256 190 350 189 383 273 221 275
						yourself:
					)
			)
		)
	)
)

(instance moat_270_down of Feature
	(properties
		noun 15
		nsLeft 1
		nsTop 1
		nsRight 589
		nsBottom 268
		x 295
		y 134
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

