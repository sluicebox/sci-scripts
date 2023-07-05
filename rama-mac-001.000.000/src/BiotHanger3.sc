;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2054)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Array)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	BiotHanger3 0
)

(instance BiotHanger3 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(self addPicObj: faceS faceW faceN faceE faceS)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2178
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(defaultExit nextRoom: 2053 init:)
		(crab_0 init:)
		(centipede_0 init:)
		(mantis_0 init:)
		(crane_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 2179
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(gCurRoom setScript: showSharks)
		(sharks_90 init:)
	)

	(method (dispose)
		(if (gCurRoom script:)
			(gCurRoom setScript: 0)
		)
		(super dispose: &rest)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 2180
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 119)
			(if (== (proc70_9 46) 2054)
				(ladder init: global117)
			)
			(= picture 2190)
		)
		(super init: &rest)
		(biotDesigns_180 init:)
		(cond
			((proc1111_24 119)
				(gateClosed_180 init:)
				(gCurRoom setScript: spider_Pacing)
			)
			((== (proc70_9 46) 2054)
				(gateOpen_180 init:)
			)
		)
	)

	(method (dispose)
		(proc1111_6)
		(spider_Pacing dispose:)
		(super dispose: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 2181
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(crane_270 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance spider_Pacing of Script
	(properties)

	(method (init)
		(robotTrackFeat init:)
		(super init: &rest)
		(= register (IntArray new: 4))
	)

	(method (doit &tmp temp0)
		(if (and register gAutoRobot)
			(Robot 2 (register data:)) ; FrameInfo
			(robotTrackFeat
				nsLeft: (register at: 0)
				nsTop: (register at: 1)
				nsRight: (register at: 2)
				nsBottom: (register at: 3)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(if register
			(register dispose:)
			(= register 0)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc1111_7 2180 0 0 global161 0 1 1 self)
			)
			(1
				(= global161 0)
				(self changeState: 0)
			)
		)
	)
)

(instance ladder of View
	(properties
		noun 20
		case 1
		x 408
		y 262
		view 2020
		cel 3
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gateOpen_180 dispose:)
				(proc70_1 46 0)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance showSharks of Script
	(properties)

	(method (dispose)
		(proc1111_6)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(-- state)
				(proc1111_6)
				(proc1111_7 2179 0 113 0 0 -1 1 self)
			)
		)
	)
)

(instance biotDesigns_180 of Feature
	(properties
		noun 21
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 178 64 222 65 200 101 yourself:)
				((Polygon new:) type: PTotalAccess init: 227 62 270 64 248 103 yourself:)
				((Polygon new:) type: PTotalAccess init: 274 64 315 64 295 103 yourself:)
				((Polygon new:) type: PTotalAccess init: 322 66 363 66 344 102 yourself:)
				((Polygon new:) type: PTotalAccess init: 367 65 413 65 390 104 yourself:)
		)
	)
)

(instance sharks_90 of Feature
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
					init: 1 73 93 73 226 123 227 178 97 245 -1 242
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 318 123 367 72 510 73 509 245 359 246 316 176
					yourself:
				)
		)
	)
)

(instance crab_0 of Feature
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
					init: 0 130 64 125 159 133 191 147 182 167 30 200 -2 200
					yourself:
				)
		)
	)
)

(instance centipede_0 of Feature
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
					init: 211 145 247 144 250 157 232 166 210 163
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 342 145 365 145 385 149 384 160 353 162
					yourself:
				)
		)
	)
)

(instance mantis_0 of Feature
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
					init: 430 129 534 134 524 173 432 172
					yourself:
				)
		)
	)
)

(instance crane_0 of Feature
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
					init: 478 105 486 90 506 66 566 51 591 56 592 183 531 180 523 176 534 134
					yourself:
				)
		)
	)
)

(instance crane_270 of Feature
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
					init: 71 195 89 167 94 144 99 85 72 59 75 32 112 27 113 1 245 1 251 93 301 87 313 97 315 164 330 197 266 206 280 167 282 140 171 147 170 189 127 188 125 205
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 346 199 333 185 346 161 348 115 354 105 387 87 415 88 441 60 421 22 433 1 592 -1 592 202 557 204 489 187 481 147 403 145 403 171 416 197 408 205
					yourself:
				)
		)
	)
)

(instance robotTrackFeat of Feature
	(properties
		noun 19
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance gateClosed_180 of Feature
	(properties
		noun 20
		nsTop 100
		nsRight 591
		nsBottom 229
		x 295
		y 164
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance gateOpen_180 of Feature
	(properties
		noun 20
		case 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 98 56 96 56 80 138 98 137 226 61 270 54 230 1 229
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 454 96 506 78 517 78 522 95 590 96 590 228 522 228 519 265 507 265 451 227
					yourself:
				)
		)
	)
)

