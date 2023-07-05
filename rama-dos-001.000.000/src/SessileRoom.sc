;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6500)
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

(public
	SessileRoom 0
)

(instance SessileRoom of Location
	(properties
		noun 47
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self addPicObj: faceN faceS faceN)
	)

	(method (pitch)
		(upScan play:)
	)
)

(instance faceN of CameraAngle
	(properties
		heading 45
		picture 6500
		edgeS 0
	)

	(method (init)
		(self up: 1)
		(super init: &rest)
		(steps_45 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 225
		picture 6501
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit init:)
		(gCurRoom exitN: defaultExit)
		(alienCup init:)
		(super init: &rest)
		(if (not (IsFlag 142))
			(SetFlag 142)
		)
		(steps_225 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties
		nsBottom 289
		nsLeft 205
		nsRight 396
		nsTop 44
		nextRoom 6512
		exitStyle 256
	)
)

(instance upScan of VMDMovie
	(properties
		movieName 6500
		frameRate 10
		options 256
		cacheSize 1000
		preLoadPCT 50
	)
)

(instance alienCup of View
	(properties
		x 440
		y 255
		view 6500
	)

	(method (init)
		(if (== (proc70_9 0) 6500)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance steps_45 of Feature
	(properties
		noun 48
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -7 153 91 156 106 284 183 267 181 212 325 202 325 162 348 160 346 138 432 137 432 159 509 160 506 114 590 100 583 285 0 293
					yourself:
				)
		)
	)
)

(instance steps_225 of Feature
	(properties
		noun 48
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 4 101 31 102 35 233 130 204 156 211 157 287 3 292
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 418 237 455 245 461 223 583 246 589 290 475 293 428 293 411 293
					yourself:
				)
		)
	)
)

