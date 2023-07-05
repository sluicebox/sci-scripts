;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5415)
(include sci.sh)
(use Main)
(use Location)
(use newYorkRegion)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use System)

(public
	NY_Subway_15 0
)

(local
	local0
)

(instance NY_Subway_15 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(faceN up: faceUpN)
		(faceUpN down: faceN)
		(switch gPrevRoomNum
			(5418 ; NY_Subway_18
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
		picture 5441
		edgeS 0
	)

	(method (init)
		(if (IsFlag 245)
			(= picture 5447)
		)
		(moatPuz init:)
		(controls_0 init:)
		(bridgeMech_0 init:)
		(super init: &rest)
	)
)

(instance faceUpN of CameraAngle
	(properties
		picture 5445
		edgeW 0
		edgeE 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 245)
			(= picture 5446)
			(bridge_0_up init:)
		)
		(= local0 (gCurRoom noun:))
		(gCurRoom noun: 27)
		(super init: &rest)
	)

	(method (dispose)
		(gCurRoom noun: local0)
		(super dispose: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 5442
		edgeS 0
		edgeN 0
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 5444
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToSubway init:)
		(gCurRoom exitN: exitToSubway)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 5443
		edgeS 0
		edgeN 0
	)
)

(instance exitToSubway of Feature
	(properties
		noun 18
		case 9
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 270 58 328 58 325 128 339 129 339 153 324 152 363 272 324 279 267 279 230 266 245 219 246 181 263 180 271 154 257 155 257 133 271 130
					yourself:
				)
			setHotspot: 2 144
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom exitStyle: 256 newRoom: 5418) ; NY_Subway_18
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance moatPuz of Feature
	(properties
		nsBottom 208
		nsLeft 215
		nsRight 257
		nsTop 177
	)

	(method (init)
		(if (not (IsFlag 245))
			(super init: &rest)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc201_1 32)
				(SetFlag 245)
				(gCurRoom setScript: bridgeUp)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bridgeUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(bridge_Up play:)
				(gCurRoom picture: 5447)
				(bridgeMech_0 case: 16)
				(bridge_0_up init:)
				(gGame handsOn:)
			)
		)
	)
)

(instance bridge_Up of VMDMovie
	(properties
		movieName 5408
		endPic 5447
		cacheSize 1000
	)
)

(instance controls_0 of Feature
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
					init: 214 175 283 179 283 234 282 243 309 291 177 290 201 253 202 245 192 244 193 183
					yourself:
				)
		)
	)
)

(instance bridgeMech_0 of Feature
	(properties
		noun 35
	)

	(method (init)
		(= case (if (IsFlag 245) 16 else 15))
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 324 0 495 1 484 21 464 25 466 53 479 67 490 67 495 76 509 80 509 255 498 257 484 262 432 256 387 256 366 263 344 264 323 256
					yourself:
				)
		)
	)
)

(instance bridge_0_up of Feature
	(properties
		noun 35
		case 16
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 316 207 393 206 395 247 424 292 331 292
					yourself:
				)
		)
	)
)

