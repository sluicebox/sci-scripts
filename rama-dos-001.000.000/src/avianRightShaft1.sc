;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6002)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	avianRightShaft1 0
)

(local
	local0
)

(instance avianRightShaft1 of Location
	(properties)

	(method (init)
		(super init:)
		(faceUp down: faceOut)
		(faceDown up: faceOut)
		(faceOut up: faceUp)
		(faceOut down: faceDown)
		(if local0
			(self addPicObj: faceIn faceOut faceIn)
		else
			(switch gPrevRoomNum
				(6004 ; avianRightShaft2
					(self setPicObj: faceUp)
				)
				(6009 ; avianBridgeControls
					(if (== global164 270)
						(self setPicObj: faceOut)
					else
						(self setPicObj: faceIn)
					)
				)
				(else
					(self setPicObj: faceDown)
				)
			)
			(self addPicObj: faceIn faceOut faceIn)
		)
	)

	(method (serialize param1)
		(= local0 param1)
		(super serialize: param1)
	)
)

(instance faceIn of CameraAngle
	(properties
		heading 180
		picture 6006
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(doorBlue1_180 init:)
		(bridgeControls init:)
	)
)

(instance faceOut of CameraAngle
	(properties)

	(method (init)
		(= picture (if (IsFlag 122) 6007 else 6070))
		(super init:)
		(doorRed1_0 init:)
		(ledge_0 init:)
	)
)

(instance faceUp of CameraAngle
	(properties
		edgeW 0
		edgeE 0
		edgeN 0
	)

	(method (init)
		(= picture (if (IsFlag 142) 6012 else 6008))
		(super init:)
		(sea_0_up init:)
	)
)

(instance faceDown of CameraAngle
	(properties
		picture 6009
		edgeW 0
		edgeE 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(downExit init:)
		(bridge_0_down init:)
		(ledges_0_down init:)
	)
)

(instance downExit of ExitFeature
	(properties
		nsBottom 258
		nsLeft 99
		nsRight 513
		nsTop 92
		nextRoom 6004
	)
)

(instance bridgeControls of Feature
	(properties
		noun 5
		nsBottom 293
		nsLeft 381
		nsRight 434
		nsTop 238
	)

	(method (init)
		(super init:)
		(= plane global116)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 6009) ; avianBridgeControls
				(self deleteHotspot:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorRed1_0 of Feature
	(properties
		noun 10
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 211 46 381 51 402 124 399 157 341 234 249 235 186 147 189 109
					yourself:
				)
		)
	)
)

(instance ledge_0 of Feature
	(properties
		noun 3
		x 299
		y 243
		nsBottom 253
		nsLeft 211
		nsRight 387
		nsTop 233
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance sea_0_up of Feature
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 194 65 379 63 366 132 366 211 384 286 190 287 210 218 209 143
					yourself:
				)
		)
	)
)

(instance bridge_0_down of Feature
	(properties
		noun 36
		x 294
		y 77
		nsBottom 155
		nsLeft 276
		nsRight 313
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance ledges_0_down of Feature
	(properties
		noun 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 6 178 169 182 186 159 396 161 428 182 589 178 588 288 1 289
					yourself:
				)
		)
	)
)

(instance doorBlue1_180 of Feature
	(properties
		noun 52
		x 303
		y 143
		nsBottom 284
		nsLeft 167
		nsRight 440
		nsTop 3
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

