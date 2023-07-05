;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8050)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)

(public
	HumanMainHall4 0
)

(instance HumanMainHall4 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(8130 ; HumanBeds
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(8040 ; HumanMainHall3
				(self addPicObj: faceE faceS faceW faceN faceE)
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
		edgeS 0
		edgeN 0
	)

	(method (init)
		(theUltimateExit init:)
		(gCurRoom exitN: theUltimateExit)
		(cond
			((IsFlag 158)
				(gCurRoom drawPic: 8053)
				(spider play:)
				(= picture 8054)
				(ClearFlag 158)
			)
			((proc1111_24 154)
				(= picture 8054)
			)
			(else
				(= picture 8029)
			)
		)
		(if (proc1111_24 154)
			(spider_0 init:)
		)
		(super init: &rest)
		(CHAIRS_0 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 90
		picture 8030
		edgeS 0
		edgeN 0
	)
)

(instance faceE of CameraAngle
	(properties
		picture 8031
		edgeS 0
		edgeN 0
	)
)

(instance faceW of CameraAngle
	(properties
		heading 180
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 8040 init:)
		(if (IsFlag 154)
			(= picture 8064)
		else
			(= picture 8032)
		)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(craneBiot_270 init:)
		(mirror_270 init:)
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
				(= nextRoom 8090)
			else
				(= nextRoom 8130)
			)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance spider of VMDMovie
	(properties
		movieName 8005
		begPic 8053
		endPic 8054
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
					init: 204 215 214 180 258 161 260 92 316 95 314 159 357 174 357 219 307 272 258 270 206 213
					yourself:
				)
		)
	)
)

(instance CHAIRS_0 of Feature
	(properties
		noun 11
		nsBottom 203
		nsLeft 42
		nsRight 183
		nsTop 147
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
					init: 317 175 328 122 408 94 407 51 543 36 537 63 442 80 441 100 484 115 420 175 319 173
					yourself:
				)
		)
	)
)

(instance mirror_270 of Feature
	(properties
		noun 7
		nsBottom 170
		nsLeft 539
		nsRight 589
		nsTop 85
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

