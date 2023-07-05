;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2037)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	wheelRgn22 0
)

(local
	local0
)

(instance wheelRgn22 of Location
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
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (== ((ScriptID 210) wheelPosition:) 3) ; wheelRegion
			(= picture 2506)
			(defaultExit exitStyle: 256 nextRoom: 2027 init:)
		else
			(= picture 2507)
		)
		(super init: &rest)
		(wheel_0 init:)
		(sea_0 init:)
		(newyork_0 init:)
		(if (== picture 2506)
			(hubDoor_225 init:)
		)
	)
)

(instance faceRim of CameraAngle
	(properties
		heading 180
		picture 2296
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 2025 init:)
		(super init: &rest)
		(hubcamp_180 init:)
		(wheel_180 init:)
		(lights_180 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
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
					init: -2 111 80 114 107 98 127 76 158 54 193 40 228 33 237 -1 352 -2 360 34 399 41 437 58 468 81 479 97 509 114 590 112 592 291 -2 291
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
					init: -1 -1 20 0 33 40 60 79 88 107 80 113 31 112 -2 99
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 382 38 395 -1 450 -1 421 48 401 42
					yourself:
				)
		)
	)
)

(instance newyork_0 of Feature
	(properties
		noun 18
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 353 -1 395 -1 390 18 382 37 361 34
					yourself:
				)
		)
	)
)

(instance hubcamp_180 of Feature
	(properties
		noun 25
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 185 9 197 2 226 3 236 18 236 41 227 53 213 58 196 52 185 45
					yourself:
				)
		)
	)
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
					init: -1 103 262 113 592 104 592 292 -1 293
					yourself:
				)
		)
	)
)

(instance lights_180 of Feature
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
					init: 454 107 592 52 592 72 486 107
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

