;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5403)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use newYorkRegion)
(use VMDMovie)
(use Polygon)
(use Feature)
(use System)

(public
	NY_Subway_3 0
)

(instance NY_Subway_3 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(proc201_1 30)
		(self setPicObj: faceRoom)
	)
)

(instance faceRoom of CameraAngle
	(properties
		heading 270
		picture 5415
		edgeW 0
		edgeE 0
		edgeS 0
		edgeN 0
	)

	(method (init)
		(startSub init:)
		(exitToCorridor init:)
		(fork_270 init:)
		(map_270 init:)
		(super init: &rest)
	)
)

(instance exitToCorridor of ExitFeature
	(properties
		nsBottom 279
		nsLeft 193
		nsRight 369
		nsTop 5
		nextRoom 5402
		exitStyle 256
	)
)

(instance startSub of Feature
	(properties
		noun 8
		x 444
		y 138
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 417 123 457 123 464 129 474 157 468 158 464 154 427 154 423 158 419 157 414 131
					yourself:
				)
			setHotspot: 2 144
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom setScript: subTransfer)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance subTransfer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(sub_Transfer play:)
				(gGame handsOn:)
				(gCurRoom newRoom: 5412) ; NY_Subway_12
			)
		)
	)
)

(instance sub_Transfer of VMDMovie
	(properties
		movieName 5401
		endPic 5423
		cacheSize 1000
	)
)

(instance fork_270 of Feature
	(properties
		noun 29
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 303 84 309 83 312 100 311 116 308 116 309 131 311 131 315 138 315 143 304 143 297 143 296 137 299 134 302 132 303 116 300 116 301 100
					yourself:
				)
		)
	)
)

(instance map_270 of Feature
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
					init: 456 196 500 220 508 252 506 258 500 261 441 260 436 255 435 249 427 226 425 220 451 198
					yourself:
				)
		)
	)
)

