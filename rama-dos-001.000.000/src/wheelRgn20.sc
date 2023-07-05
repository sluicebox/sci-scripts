;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2035)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	wheelRgn20 0
)

(local
	local0
)

(instance wheelRgn20 of Location
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
		heading 180
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (== ((ScriptID 210) wheelPosition:) 1) ; wheelRegion
			(= picture 2502)
			(defaultExit exitStyle: 256 nextRoom: 2027 init:)
		else
			(= picture 2503)
		)
		(super init: &rest)
		(wheel_180 init:)
		(if (== picture 2502)
			(hubDoor_225 init:)
		)
	)
)

(instance faceRim of CameraAngle
	(properties
		picture 2294
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 2023 init:)
		(super init: &rest)
		(sea_0 init:)
		(lights_0 init:)
		(wheel_0 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance wheel_180 of Feature
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
					init: -2 112 79 114 105 99 141 66 181 44 229 34 238 0 352 -1 360 34 406 45 446 64 479 98 509 115 590 112 592 291 -2 292
					yourself:
				)
		)
	)
)

(instance sea_0 of Feature
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
					init: 139 -1 297 -2 276 25 263 56 259 86 262 109 173 109 156 81 142 35
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 549 104 556 76 554 43 544 16 534 -1 592 -1 592 83 584 102
					yourself:
				)
		)
	)
)

(instance lights_0 of Feature
	(properties
		noun 15
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 49 150 109 99 110 0 77
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 362 1 372 57 357 61 338 1
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 495 107 547 64 543 101 527 106
					yourself:
				)
		)
	)
)

(instance wheel_0 of Feature
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
					init: -3 106 38 108 397 113 593 103 594 294 -1 293
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

