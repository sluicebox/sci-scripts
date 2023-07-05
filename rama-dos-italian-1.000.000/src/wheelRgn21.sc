;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2036)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	wheelRgn21 0
)

(local
	local0
)

(instance wheelRgn21 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2027 ; wheelRgn18
				(self addPicObj: faceRim faceHub faceRim)
				(if (not local0)
					((ScriptID 210 0) advanceSpokes:) ; wheelRegion
					(self setScript: (ScriptID 210 1)) ; soundsOfAdvancement
				)
			)
			(else
				(self addPicObj: faceHub faceRim faceHub)
			)
		)
	)

	(method (serialize param1)
		(= local0 param1)
		(super serialize: param1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(149
				(if script
					(script dispose:)
					(= script 0)
					(gGame handsOn:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faceHub of CameraAngle
	(properties
		heading 90
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (== ((ScriptID 210) wheelPosition:) 2) ; wheelRegion
			(= picture 2504)
			(defaultExit exitStyle: 256 nextRoom: 2027 init:)
		else
			(= picture 2505)
		)
		(super init: &rest)
		(wheel_90 init:)
		(if (== picture 2504)
			(hubDoor_225 init:)
		)
	)
)

(instance faceRim of CameraAngle
	(properties
		heading 270
		picture 2295
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 2024 init:)
		(super init: &rest)
		(wheel_270 init:)
		(lights_270 init:)
		(london_270 init:)
		(sea_270 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance wheel_90 of Feature
	(properties
		noun 5
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -2 112 80 114 106 99 139 67 182 44 229 33 238 -1 352 -1 360 33 400 41 438 58 471 81 481 97 508 114 590 112 592 291 -2 292
					yourself:
				)
		)
	)
)

(instance wheel_270 of Feature
	(properties
		noun 5
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 104 330 113 592 104 593 292 0 291
					yourself:
				)
		)
	)
)

(instance lights_270 of Feature
	(properties
		noun 15
		x 318
		y 95
		nsBottom 101
		nsLeft 44
		nsRight 592
		nsTop 90
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance london_270 of Feature
	(properties
		noun 16
		x 401
		y 81
		nsBottom 90
		nsLeft 388
		nsRight 414
		nsTop 72
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance sea_270 of Feature
	(properties
		noun 20
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 535 1 591 0 593 60 567 43 547 20
					yourself:
				)
		)
	)
)

(instance hubDoor_225 of Feature
	(properties
		noun 7
		x 294
		y 157
		nsBottom 200
		nsLeft 241
		nsRight 347
		nsTop 114
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

