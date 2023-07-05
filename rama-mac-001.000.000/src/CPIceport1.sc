;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2100)
(include sci.sh)
(use Main)
(use Location)
(use VidmailChoices)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)
(use System)

(public
	CPIceport1 0
)

(instance CPIceport1 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2000 ; cplains
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(2101 ; CPIceport2
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 2000) ; cplains
			(= exitStyle 13)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2401
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(sea_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 2402
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(sea_90 init:)
		(lights_90 init:)
		(if (IsFlag 77)
			(gGame handsOff:)
			(gCurRoom setScript: yourFiredForLeaving)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 2403
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 2000 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(hubSite_180 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 2404
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 2101 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(lights_270 init:)
		(sea_270 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance sea_0 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 -1 73 -1 97 44 42 71 -2 133
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 509 12 518 -1 540 -1 514 13
					yourself:
				)
		)
	)
)

(instance lights_270 of Feature
	(properties
		noun 5
		nsLeft 124
		nsTop 19
		nsRight 472
		nsBottom 31
		x 298
		y 25
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance sea_270 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 461 1 592 0 592 88 548 76 513 59 485 39 470 20
					yourself:
				)
		)
	)
)

(instance hubSite_180 of Feature
	(properties
		noun 3
		nsLeft 258
		nsTop -1
		nsRight 338
		nsBottom 61
		x 298
		y 30
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance sea_90 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 22 -2 132 -2 118 26 88 29 55 9
					yourself:
				)
		)
	)
)

(instance lights_90 of Feature
	(properties
		noun 5
		nsLeft 166
		nsTop 21
		nsRight 469
		nsBottom 32
		x 317
		y 26
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance yourFiredForLeaving of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(proc55_3 40)
			)
		)
	)
)

