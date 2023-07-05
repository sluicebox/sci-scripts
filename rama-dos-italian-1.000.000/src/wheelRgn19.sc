;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2034)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	wheelRgn19 0
)

(local
	local0
)

(instance wheelRgn19 of Location
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
		heading 225
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (== ((ScriptID 210) wheelPosition:) 0) ; wheelRegion
			(= picture 2500)
			(defaultExit exitStyle: 256 nextRoom: 2027 init:)
		else
			(= picture 2501)
		)
		(super init: &rest)
		(wheel_225 init:)
		(lights_225 init:)
		(if (== picture 2500)
			(hubDoor_225 init:)
		)
	)
)

(instance faceRim of CameraAngle
	(properties
		heading 45
		picture 2293
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 2022 init:)
		(super init: &rest)
		(sea_45 init:)
		(lights_45 init:)
		(newyork_45 init:)
		(wheelExit_45 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance wheel_225 of Feature
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
					init: 0 112 81 114 106 98 140 67 166 51 209 37 230 33 239 -1 355 -2 364 35 410 43 440 58 472 81 481 97 505 108 512 114 593 112 593 292 1 291
					yourself:
				)
		)
	)
)

(instance lights_225 of Feature
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
					init: 360 28 482 -1 579 -1 396 40
					yourself:
				)
		)
	)
)

(instance sea_45 of Feature
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
					init: 131 109 141 83 144 56 142 30 132 -1 271 -1 269 32 261 64 248 90 234 110
					yourself:
				)
		)
	)
)

(instance lights_45 of Feature
	(properties
		noun 15
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 80 108 137 85 126 111 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 271 28 332 0 394 0 265 58
					yourself:
				)
		)
	)
)

(instance newyork_45 of Feature
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
					init: 160 111 174 75 182 36 186 0 204 0 215 33 212 62 200 94 187 111
					yourself:
				)
		)
	)
)

(instance wheelExit_45 of Feature
	(properties
		noun 23
		x 296
		y 131
		nsBottom 155
		nsLeft 275
		nsRight 317
		nsTop 108
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
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

