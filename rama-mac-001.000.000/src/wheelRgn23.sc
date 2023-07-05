;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2038)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	wheelRgn23 0
)

(local
	local0
)

(instance wheelRgn23 of Location
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
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (== ((ScriptID 210) wheelPosition:) 4) ; wheelRegion
			(= picture 2508)
			(defaultExit exitStyle: 256 nextRoom: 2027 init:)
		else
			(= picture 2509)
		)
		(super init: &rest)
		(wheel_90 init:)
		(lights_90 init:)
		(london_90 init:)
		(if (== picture 2508)
			(hubDoor_225 init:)
		)
	)
)

(instance faceRim of CameraAngle
	(properties
		picture 2297
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 2026 init:)
		(super init: &rest)
		(lights_270 init:)
		(wheel_270 init:)
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
					init: -1 112 80 114 106 99 134 71 173 49 214 35 229 34 238 -1 351 -2 361 34 409 44 447 65 480 99 508 114 590 111 590 292 -1 292
					yourself:
				)
		)
	)
)

(instance lights_90 of Feature
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
					init: 109 -1 229 31 229 34 197 40 25 -1
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 506 91 579 111 556 113 522 105
					yourself:
				)
		)
	)
)

(instance london_90 of Feature
	(properties
		noun 16
		nsLeft 206
		nsTop 11
		nsRight 224
		nsBottom 32
		x 215
		y 21
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance lights_270 of Feature
	(properties
		noun 15
		nsLeft 217
		nsTop -1
		nsRight 275
		nsBottom 25
		x 246
		y 12
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance wheel_270 of Feature
	(properties
		noun 5
		nsLeft -1
		nsTop 104
		nsRight 593
		nsBottom 294
		x 296
		y 199
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance hubDoor_225 of Feature
	(properties
		noun 7
		nsLeft 241
		nsTop 114
		nsRight 347
		nsBottom 200
		x 294
		y 157
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

