;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8040)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)

(public
	HumanMainHall3 0
)

(instance HumanMainHall3 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(8120 ; HumanBench
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(8030 ; HumanMainHall2
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(8050 ; HumanMainHall4
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
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
				(if (== gPrevRoomNum 8030) ; HumanMainHall2
					(gCurRoom drawPic: 8051)
					(spiderFromLeft play:)
					(= picture 8052)
				else
					(gCurRoom drawPic: 8049)
					(spiderFromRight play:)
					(= picture 8050)
				)
			)
			((proc1111_24 154)
				(= picture 8050)
			)
			(else
				(= picture 8034)
			)
		)
		(super init: &rest)
		(if (proc1111_24 154)
			(spider_0 init:)
		)
		(furniture_0 init:)
		(BOMB_0 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 8035
		heading 90
		edgeN 0
		edgeS 0
	)
)

(instance faceE of CameraAngle
	(properties
		picture 8036
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 8050 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 8030 init:)
		(gCurRoom exitN: defaultExit)
		(if (IsFlag 154)
			(= picture 8063)
		else
			(= picture 8037)
		)
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
				(= nextRoom 8080)
			else
				(= nextRoom 8120)
			)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance spiderFromRight of VMDMovie
	(properties
		movieName 8003
		begPic 8049
		endPic 8050
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
		movieName 8004
		begPic 8051
		endPic 8052
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
					init: 205 218 216 177 259 152 259 99 318 101 312 155 347 177 364 220 314 272 255 269 206 216 221 177 266 154
					yourself:
				)
		)
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
					init: 47 167 74 148 147 145 153 205 54 206 42 173
					yourself:
				)
		)
	)
)

(instance furniture_0 of Feature
	(properties
		noun 11
		nsLeft 429
		nsTop 107
		nsRight 570
		nsBottom 214
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
					init: 329 188 336 117 448 85 451 36 588 6 586 40 489 54 494 80 545 106 472 190 332 185
					yourself:
				)
		)
	)
)

