;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6004)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	avianRightShaft2 0
)

(local
	local0
)

(instance avianRightShaft2 of Location
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
				(6802 ; avianHatchery02
					(self setPicObj: faceOut)
				)
				(6006 ; avianRightShaft3
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
		picture 6025
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(inExit init:)
		(doorBlue2_180 init:)
		(bridgeControls init:)
	)
)

(instance faceOut of CameraAngle
	(properties
		picture 6026
	)

	(method (init)
		(super init:)
		(doorRed2_0 init:)
		(ledges_0 init:)
	)
)

(instance faceUp of CameraAngle
	(properties
		edgeN 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(= picture (if (IsFlag 142) 6031 else 6027))
		(super init:)
		(upExit init:)
		(sea_0_up init:)
		(ledges_0_up init:)
	)
)

(instance faceDown of CameraAngle
	(properties
		picture 6028
		edgeS 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(super init:)
		(downExit init:)
		(bridge_0_down init:)
	)
)

(instance downExit of ExitFeature
	(properties
		nsLeft 99
		nsTop 92
		nsRight 513
		nsBottom 258
		nextRoom 6006
	)
)

(instance upExit of ExitFeature
	(properties
		nsLeft 55
		nsTop 4
		nsRight 535
		nsBottom 172
		nextRoom 6002
	)
)

(instance inExit of ExitFeature
	(properties
		nsLeft 190
		nsTop 26
		nsRight 401
		nsBottom 287
		nextRoom 6802
		exitStyle 13
	)
)

(instance bridgeControls of Feature
	(properties
		noun 5
		nsLeft 381
		nsTop 238
		nsRight 434
		nsBottom 293
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

(instance doorRed2_0 of Feature
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
					init: 209 42 382 43 404 127 346 236 242 231 185 118
					yourself:
				)
		)
	)
)

(instance ledges_0 of Feature
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
					init: 210 235 384 233 387 254 209 258
					yourself:
				)
		)
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
					init: 210 134 369 132 366 203 382 289 199 287
					yourself:
				)
		)
	)
)

(instance ledges_0_up of Feature
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
					init: 4 1 590 2 587 81 540 76 537 112 521 127 70 126 53 113 54 80 -1 73
					yourself:
				)
		)
	)
)

(instance doorBlue2_180 of Feature
	(properties
		noun 11
		nsLeft 201
		nsTop 33
		nsRight 397
		nsBottom 289
		x 299
		y 161
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance bridge_0_down of Feature
	(properties
		noun 36
		nsLeft 268
		nsTop 2
		nsRight 321
		nsBottom 158
		x 294
		y 80
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

