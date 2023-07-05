;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8030)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)

(public
	HumanMainHall2 0
)

(instance HumanMainHall2 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(8110 ; HumanBombShop
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(8020 ; HumanMainHall1
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(8040 ; HumanMainHall3
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(8010 ; HumanWheelRm
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
		(if (proc1111_24 176)
			(proc1111_31 38)
			(SetFlag 176)
		)
	)

	(method (dispose)
		(if (proc1111_24 154)
			(SetFlag 158)
		)
		(super dispose: &rest)
	)
)

(instance faceN of CameraAngle
	(properties
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(theUltimateExit init:)
		(gCurRoom exitN: theUltimateExit)
		(cond
			((IsFlag 158)
				(ClearFlag 158)
				(if (== gPrevRoomNum 8020) ; HumanMainHall1
					(gCurRoom drawPic: 8047)
					(spiderFromLeft play:)
					(= picture 8048)
				else
					(gCurRoom drawPic: 8045)
					(spiderFromRight play:)
					(= picture 8046)
				)
			)
			((proc1111_24 154)
				(spider_0 init:)
				(= picture 8046)
			)
			(else
				(= picture 8039)
				(BOMB_0 init:)
			)
		)
		(super init: &rest)
		(CHAIRS_0 init:)
		(MIRROR_0 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 8040
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 8010 exitStyle: 256 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(EXIT_180 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 8041
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 8040 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 8042
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 8020 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(craneBiot_270 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance theUltimateExit of ExitFeature
	(properties)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 9)
			(if (not (IsFlag 154))
				(gGame autoSave: 1)
				(= nextRoom 8070)
			else
				(= nextRoom 8110)
			)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance spiderFromRight of VMDMovie
	(properties
		movieName 8001
		begPic 8045
		endPic 8046
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3
				(spider_0 init:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance spiderFromLeft of VMDMovie
	(properties
		movieName 8002
		begPic 8047
		endPic 8048
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3
				(spider_0 init:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance spider_0 of Feature
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
					init: 298 89 320 178 406 202 426 266 186 263 201 196 300 89
					yourself:
				)
		)
	)
)

(instance MIRROR_0 of Feature
	(properties
		noun 7
		nsLeft 1
		nsTop 64
		nsRight 103
		nsBottom 176
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance craneBiot_270 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 154)
			(= case 3)
		)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 377 101 336 204 560 228 561 4 511 4 502 70 349 103
					yourself:
				)
		)
	)
)

(instance EXIT_180 of Feature
	(properties
		noun 1
		nsLeft 256
		nsTop 91
		nsRight 333
		nsBottom 212
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance BOMB_0 of Feature
	(properties
		noun 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 230 168 272 145 332 145 340 202 259 201 231 173
					yourself:
				)
		)
	)
)

(instance CHAIRS_0 of Feature
	(properties
		noun 11
		nsLeft 407
		nsTop 149
		nsRight 559
		nsBottom 203
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

