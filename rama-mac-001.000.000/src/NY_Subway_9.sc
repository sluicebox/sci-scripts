;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5409)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use newYorkRegion)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use System)

(public
	NY_Subway_9 0
)

(instance NY_Subway_9 of Location
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
		picture 5416
		heading 135
		edgeN 0
		edgeS 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(startSub init:)
		(exitToCorridor init:)
		(door init:)
		(map init:)
		(super init: &rest)
	)
)

(instance exitToCorridor of ExitFeature
	(properties
		nsLeft 193
		nsTop 5
		nsRight 369
		nsBottom 279
		nextRoom 5408
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
				(if (and (IsFlag 242) (IsFlag 243) (IsFlag 244))
					(sub_Transfer play:)
				else
					(sub_Transfer_DoorClosed play:)
				)
				(gGame handsOn:)
				(gCurRoom newRoom: 5416) ; NY_Subway_16
			)
		)
	)
)

(instance sub_Transfer of VMDMovie
	(properties
		movieName 5403
		endPic 5430
		cacheSize 1000
	)
)

(instance sub_Transfer_DoorClosed of VMDMovie
	(properties
		movieName 5409
		endPic 5430
		cacheSize 1000
	)
)

(instance map of Feature
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

(instance door of Feature
	(properties
		noun 21
		nsLeft 192
		nsRight 367
		nsBottom 280
		x 279
		y 140
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

