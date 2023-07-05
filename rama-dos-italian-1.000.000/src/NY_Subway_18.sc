;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5418)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use VMDMovie)
(use Polygon)
(use Feature)
(use System)

(public
	NY_Subway_18 0
)

(instance NY_Subway_18 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setPicObj: faceRoom)
	)
)

(instance faceRoom of CameraAngle
	(properties
		picture 5436
		edgeW 0
		edgeE 0
		edgeS 0
		edgeN 0
	)

	(method (init)
		(startSub init:)
		(exitToMoatRoom init:)
		(door init:)
		(super init: &rest)
	)
)

(instance exitToMoatRoom of ExitFeature
	(properties
		nsBottom 279
		nsLeft 193
		nsRight 369
		nsTop 5
		nextRoom 5415
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
				(gCurRoom newRoom: 5417) ; NY_Subway_17
			)
		)
	)
)

(instance sub_Transfer of VMDMovie
	(properties
		movieName 5405
		endPic 5435
		cacheSize 1000
	)
)

(instance door of Feature
	(properties
		noun 25
		x 279
		y 140
		nsBottom 280
		nsLeft 192
		nsRight 367
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

