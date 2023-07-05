;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8020)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use System)

(public
	HumanMainHall1 0
)

(instance HumanMainHall1 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(8100 ; HumanCistern
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(8030 ; HumanMainHall2
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
		(mirror init:)
		(if (proc1111_24 154)
			(if (IsFlag 158)
				(gCurRoom drawPic: 8043)
				(spider play:)
				(ClearFlag 158)
			)
			(= picture 8065)
		else
			(= picture 8066)
		)
		(super init: &rest)
		(bomb_0 init:)
		(reflection_0 init:)
		(if (proc1111_24 154)
			(spider_0 init:)
			(craneBiot_0 init:)
		else
			(craneWSpider init:)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 8007
		heading 90
		edgeN 0
		edgeS 0
	)
)

(instance faceE of CameraAngle
	(properties
		picture 8008
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 8030 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 8009
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(craneBiot_270 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance theUltimateExit of ExitFeature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 185 264 200 200 275 157 278 101 326 98 330 164 378 196 409 191 440 268 180 268
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 9)
			(if (not (IsFlag 154))
				(gGame autoSave: 1)
				(= nextRoom 8060)
			else
				(= nextRoom 8100)
			)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance sCraneGetsSpider of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 154)
				(= seconds 1)
			)
			(1
				(craneGetsSpider play: self)
			)
			(2
				(craneBiot_0 dispose:)
				(craneWSpider init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCraneDropsSpider of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 154)
				(= seconds 1)
			)
			(1
				(craneDropsSpider play: self)
			)
			(2
				(gCurRoom drawPic: 8065)
				(craneBiot_0 init:)
				(craneWSpider dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mirror of Feature
	(properties
		nsLeft 151
		nsTop 66
		nsRight 248
		nsBottom 165
	)

	(method (init)
		(= plane global116)
		(super init: &rest)
		(self setHotspot: 54)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(54
				(if (IsFlag 154)
					(gCurRoom setScript: sCraneDropsSpider)
				else
					(gCurRoom setScript: sCraneGetsSpider)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance spider of VMDMovie
	(properties
		movieName 8000
		begPic 8043
		endPic 8065
	)
)

(instance craneGetsSpider of VMDMovie
	(properties
		movieName 8010
		begPic 8065
		endPic 8066
	)
)

(instance craneDropsSpider of VMDMovie
	(properties
		movieName 8011
		begPic 8066
		endPic 8065
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
					init: 589 0 439 108 428 225 449 291 592 289 590 1
					yourself:
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
					init: 206 201 279 164 280 99 320 98 323 161 369 201 399 196 433 268 183 265 204 197
					yourself:
				)
		)
	)
)

(instance reflection_0 of Feature
	(properties
		noun 8
		nsLeft 145
		nsTop 66
		nsRight 249
		nsBottom 171
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance bomb_0 of Feature
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
					init: 398 170 439 146 484 146 501 201 416 198 397 172
					yourself:
				)
		)
	)
)

(instance craneBiot_0 of Feature
	(properties
		noun 9
		nsLeft 1
		nsTop 1
		nsRight 76
		nsBottom 278
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance craneWSpider of Feature
	(properties
		noun 9
		case 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -2 2 99 0 151 49 150 75 45 118 65 269 54 275 64 292 2 290
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 294 19 315 49 307 80 325 109 335 149 354 171 349 225 257 219 250 156 263 96 272 76 268 43 294 11
					yourself:
				)
		)
	)
)

