;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3062)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	london_32 0
)

(instance london_32 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(3069 ; london_Centipede_Display
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(3060 ; london_30
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 3304
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(southExitToLondon33 init:)
		(super init:)
		(monitor_180 init:)
		(if (proc1111_24 114)
			(gCurRoom setScript: spider_Pacing)
			(spider_180 init:)
			(if (not (SetFlag 120))
				(proc1111_31 5 8)
			)
		)
		(crane_180 init:)
		(inventroy_Medallion init:)
		(monitorSwitch init:)
		(monitorPic init:)
	)

	(method (dispose)
		(proc1111_6)
		(spider_Pacing dispose:)
		(super dispose: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 3301
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(centDisplay_270 init:)
		(centipede init: setHotspot: 2)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 3303
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(eastExitToLondon30 init:)
		(biotDDoor2Out_90 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 3302
		edgeN 0
		edgeS 0
	)

	(method (init &tmp temp0)
		(if
			(= temp0
				(if (OneOf (proc70_9 40) -2 -3)
					(not (SetFlag 121))
				)
			)
			(self showBlack: 1)
			(= picture 38130)
		else
			(= picture 3302)
		)
		(super init:)
		(mantisDisplay_0 init:)
		(crabDisplay_0 init:)
		(if temp0
			(nicoleTellsOfReggiesDeath play:)
			(proc70_1 19)
		)
		(crab init: setHotspot: 2)
		(mantis init: setHotspot: 2)
	)
)

(instance southExitToLondon33 of ExitFeature
	(properties
		nsTop 59
		nsRight 468
		nsBottom 231
		nextRoom 3063
	)
)

(instance eastExitToLondon30 of ExitFeature
	(properties
		nsLeft 224
		nsTop 37
		nsRight 383
		nsBottom 202
		nextRoom 3060
		exitStyle 256
	)
)

(instance crab of Feature
	(properties
		nsLeft 99
		nsTop 146
		nsRight 158
		nsBottom 224
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 3067) ; london_Crab_Display
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance centipede of Feature
	(properties
		nsLeft 277
		nsTop 161
		nsRight 336
		nsBottom 255
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 3069) ; london_Centipede_Display
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mantis of Feature
	(properties
		nsLeft 424
		nsTop 153
		nsRight 477
		nsBottom 240
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 3068) ; london_Mantis_Display
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inventroy_Medallion of View
	(properties
		noun 38
		x 223
		y 178
		view 3301
		cel 2
	)

	(method (init)
		(if (== (proc70_9 40) 3063)
			(self setPri: 0)
			(super init: global117)
			(self setHotspot: 144)
		)
	)
)

(instance monitorSwitch of View
	(properties
		x 250
		y 160
		view 3301
	)

	(method (init)
		(= cel global297)
		(self setPri: 0)
		(super init: global117)
	)
)

(instance monitorPic of View
	(properties
		x 256
		y 149
		view 3301
		cel 3
	)

	(method (init)
		(if global297
			(self setPri: 0)
			(super init: global117)
		)
	)
)

(instance spider_Pacing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 3334)
				(proc1111_7 3332 257 117 global161 0 1 1 self)
			)
			(1
				(= global161 0)
				(self changeState: 0)
			)
		)
	)
)

(instance nicoleTellsOfReggiesDeath of VMDMovie
	(properties
		movieName 38131
		endPic 38139
	)

	(method (play)
		(if (<= global188 3)
			(= cacheSize 1000)
			(= preLoadPCT 100)
		)
		(super play: &rest)
	)
)

(instance biotDDoor2Out_90 of Feature
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
					init: 201 188 226 39 225 18 373 15 367 43 382 76 391 201 340 204 328 196 263 193 244 207
					yourself:
				)
		)
	)
)

(instance mantisDisplay_0 of Feature
	(properties
		noun 25
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 365 121 425 119 452 76 481 81 503 132 535 148 533 168 528 230 489 233 408 228 405 148 364 146
					yourself:
				)
		)
	)
)

(instance crabDisplay_0 of Feature
	(properties
		noun 26
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 88 94 110 129 127 182 106 210 112 176 223 85 232 59 223 5 133
					yourself:
				)
		)
	)
)

(instance centDisplay_270 of Feature
	(properties
		noun 27
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 145 151 262 147 233 102 329 28 425 105 390 127 392 172 359 257 253 258 222 241 140 187
					yourself:
				)
		)
	)
)

(instance spider_180 of Feature
	(properties
		noun 31
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 282 125 268 147 245 159 238 184 256 193 302 193 344 193 356 192 356 176 355 155 323 152 321 127 303 116
					yourself:
				)
		)
	)
)

(instance crane_180 of Feature
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
					init: 233 2 233 27 292 27 336 26 413 25 430 25 427 57 427 69 381 52 350 51 324 81 319 111 377 134 392 135 391 180 424 197 473 197 555 197 580 197 579 101 545 83 482 81 452 78 457 6
					yourself:
				)
		)
	)
)

(instance monitor_180 of Feature
	(properties
		noun 30
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 248 123 246 152 269 155 271 141 273 123
					yourself:
				)
		)
	)
)

