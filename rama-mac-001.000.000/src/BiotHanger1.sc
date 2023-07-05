;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2052)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	BiotHanger1 0
)

(instance BiotHanger1 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2053 ; BiotHanger2
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(else
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2170
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(defaultExit nextRoom: 2047 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 2171
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(centipede_90 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 2172
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (proc1111_24 119)
			(gCurRoom setScript: spider_Pacing)
		else
			(if (== (proc70_9 46) 2054)
				(ladder init: global117)
			)
			(= picture 2186)
		)
		(super init: &rest)
		(defaultExit nextRoom: 2053 init:)
		(if (and (IsFlag 119) (not (SetFlag 69)))
			(proc1111_31 5 3 144)
		)
		(crab_180 init:)
		(crane_180 init:)
		(sharks_180 init:)
		(if (== (proc70_9 46) 2054)
			(spider_180 init:)
		)
		(biotdesigns_180 init:)
	)

	(method (dispose)
		(if (proc1111_24 119)
			(= global161
				(if gAutoRobot
					(Robot 11) ; FrameNum
				else
					0
				)
			)
			(proc1111_6)
			(spider_Pacing dispose:)
		)
		(super dispose: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 2173
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(centipede_270 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance spider_Pacing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(proc1111_7 2172 229 123 global161 0 -1 1 self)
			)
			(2
				(= global161 0)
				(self changeState: 1)
			)
		)
	)
)

(instance ladder of View
	(properties
		x 314
		y 159
		view 2020
		cel 1
	)
)

(instance centipede_270 of Feature
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
					init: 37 169 497 163 561 154 582 172 493 242 32 239
					yourself:
				)
		)
	)
)

(instance crab_180 of Feature
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
					init: 414 155 452 137 473 137 538 133 584 148 587 196 497 199 482 199 444 189 424 178
					yourself:
				)
		)
	)
)

(instance crane_180 of Feature
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
					init: 1 90 39 88 37 50 51 39 190 35 210 50 197 57 60 57 60 80 97 75 119 82 126 99 147 105 147 118 93 142 99 175 59 175 64 146 50 135 44 122 45 102 28 101 24 126 2 134
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 470 164 416 168 397 162 400 150 394 141 363 128 364 120 378 108 393 105 397 96 336 95 336 86 352 67 383 68
					yourself:
				)
		)
	)
)

(instance sharks_180 of Feature
	(properties
		noun 18
		nsLeft 121
		nsTop 127
		nsRight 238
		nsBottom 169
		x 179
		y 148
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance spider_180 of Feature
	(properties
		noun 19
		nsLeft 239
		nsTop 134
		nsRight 381
		nsBottom 162
		x 310
		y 148
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 119)
			(= noun 20)
			(= case 1)
		)
		(self setHotspot: 144)
	)
)

(instance biotdesigns_180 of Feature
	(properties
		noun 21
		nsLeft 253
		nsTop 114
		nsRight 338
		nsBottom 125
		x 295
		y 119
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance centipede_90 of Feature
	(properties
		noun 14
		nsLeft 21
		nsTop 163
		nsRight 547
		nsBottom 235
		x 284
		y 199
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

