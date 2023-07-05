;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2011)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use cplainRegion)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	wheelRgn2 0
)

(instance wheelRgn2 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2010 ; wheelRgn1
				(self addPicObj: faceSE faceSW faceW faceNW faceN faceSE)
			)
			(2012 ; wheelRgn3
				(self addPicObj: faceW faceNW faceN faceSE faceSW faceW)
			)
			(2016 ; wheelRgn7
				(self addPicObj: faceN faceSE faceSW faceW faceNW faceN)
			)
			(else
				(self addPicObj: faceNW faceN faceSE faceSW faceW faceNW)
			)
		)
		((ScriptID 200 0) addMigrant: 49) ; cplainRegion
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2197
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(sea_0 init:)
		(newyork_0 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 2206
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(lights_270 init:)
		(london_270 init:)
		(sea_270 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		heading 315
		picture 2203
		edgeS 0
		edgeN 0
	)

	(method (init)
		(oneExit_315 init:)
		(super init: &rest)
		(if (and (== global200 0) (not (OneOf (proc70_9 79) -3 -2)))
			(mechCorn init: global117)
		)
		(corn_315 init:)
		(london_315 init:)
		(lights_315 init:)
		(sea_315 init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		heading 135
		picture 2205
		edgeS 0
		edgeN 0
	)

	(method (init)
		(threeExit_135 init:)
		(super init: &rest)
		(matrixB11x init: global117)
		(trashBiot_135 init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		heading 225
		picture 2204
		edgeS 0
		edgeN 0
	)

	(method (init)
		(sevenExit_225 init:)
		(super init: &rest)
		(laser_225 init:)
		(wheel_225 init:)
		(lights_225 init:)
		(london_225 init:)
	)
)

(instance mechCorn of View
	(properties
		view 2203
	)

	(method (init &tmp [temp0 2])
		(= loop (>> ((ScriptID 200 0) curCornDispenser:) $0008)) ; cplainRegion
		(= cel (& $00ff ((ScriptID 200 0) curCornDispenser:))) ; cplainRegion
		(switch loop
			(0
				(self posn: 392 256)
			)
			(1
				(self posn: 481 268)
			)
			(2
				(self posn: 520 259)
			)
		)
		(super init: &rest)
		(if (>= cel 2)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 79 0)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance matrixB11x of MigratingView
	(properties
		x 416
		y 339
		loop 6
		cel 2
		view 2203
		invItemID 49
	)
)

(instance lights_270 of Feature
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
					init: 88 -1 435 58 452 73 -1 2 -1 -2
					yourself:
				)
		)
	)
)

(instance london_270 of Feature
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
					init: 255 12 274 13 282 33 262 30
					yourself:
				)
		)
	)
)

(instance sea_270 of Feature
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
					init: 395 -1 545 -1 558 41 591 78 589 110 538 99 499 96 451 71 419 41
					yourself:
				)
		)
	)
)

(instance corn_315 of Feature
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
					init: 2 210 34 202 49 207 60 222 -1 232
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 117 232 133 212 140 211 152 232
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 313 207 319 193 366 199 383 212 360 219
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 398 223 412 203 420 203 431 222
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 374 278 395 253 408 253 432 274 420 283 393 284
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 464 289 486 265 526 253 536 253 562 277 526 291
					yourself:
				)
		)
	)
)

(instance london_315 of Feature
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
					init: 144 19 168 23 178 44 152 40
					yourself:
				)
		)
	)
)

(instance lights_315 of Feature
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
					init: 1 11 361 78 381 93 -1 31
					yourself:
				)
		)
	)
)

(instance sea_315 of Feature
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
					init: 304 0 433 1 441 41 464 77 419 83 397 100 358 77 324 40
					yourself:
				)
		)
	)
)

(instance sea_0 of Feature
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
					init: 129 67 142 32 138 -1 258 -1 247 40 204 55 179 54
					yourself:
				)
		)
	)
)

(instance newyork_0 of Feature
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
					init: 164 57 171 -1 208 -1 206 27 192 54
					yourself:
				)
		)
	)
)

(instance trashBiot_135 of Feature
	(properties
		noun 22
		x 97
		y 172
		nsBottom 180
		nsLeft 75
		nsRight 119
		nsTop 165
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance laser_225 of Feature
	(properties
		noun 2
		x 45
		y 173
		nsBottom 192
		nsLeft 17
		nsRight 74
		nsTop 154
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance wheel_225 of Feature
	(properties
		noun 5
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 105 144 194 145 192 124 203 97 218 126 219 149 311 150 277 170 171 177 158 176 130 172
					yourself:
				)
		)
	)
)

(instance lights_225 of Feature
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
					init: 200 98 590 38 545 67 195 106
					yourself:
				)
		)
	)
)

(instance london_225 of Feature
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
					init: 455 45 478 40 489 55 462 59
					yourself:
				)
		)
	)
)

(instance sevenExit_225 of ExitFeature
	(properties
		x 181
		y 157
		nsBottom 212
		nsLeft 14
		nsRight 348
		nsTop 102
		nextRoom 2016
	)
)

(instance threeExit_135 of ExitFeature
	(properties
		x 153
		y 170
		nsBottom 261
		nsLeft 17
		nsRight 289
		nsTop 80
		nextRoom 2012
	)
)

(instance oneExit_315 of ExitFeature
	(properties
		x 254
		y 140
		nsBottom 207
		nsRight 421
		nsTop 73
		nextRoom 2010
	)
)

