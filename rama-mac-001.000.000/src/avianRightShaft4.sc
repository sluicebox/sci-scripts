;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6008)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	avianRightShaft4 0
)

(local
	local0
)

(instance avianRightShaft4 of Location
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
				(6600 ; avianSchool1
					(self setPicObj: faceOut)
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
		picture 6065
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(inExit init:)
		(doorBlue4_180 init:)
		(bridgeControls init:)
	)
)

(instance faceOut of CameraAngle
	(properties
		picture 6066
	)

	(method (init)
		(super init:)
		(doorRed4_0 init:)
		(ledges_0 init:)
	)
)

(instance faceUp of CameraAngle
	(properties
		picture 6067
		edgeN 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(= picture (if (IsFlag 142) 6053 else 6067))
		(super init:)
		(upExit init:)
	)
)

(instance faceDown of CameraAngle
	(properties
		picture 6068
		edgeS 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(super init:)
		(ledges_0_down init:)
	)
)

(instance upExit of ExitFeature
	(properties
		nsLeft 55
		nsTop 4
		nsRight 535
		nsBottom 172
		nextRoom 6006
	)
)

(instance inExit of ExitFeature
	(properties
		nsLeft 190
		nsTop 26
		nsRight 401
		nsBottom 287
		nextRoom 6600
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

(instance doorRed4_0 of Feature
	(properties
		noun 35
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 213 41 384 44 405 126 345 231 250 233 187 119
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
					init: 209 236 382 231 383 253 207 253
					yourself:
				)
		)
	)
)

(instance ledges_0_down of Feature
	(properties
		noun 3
		nsLeft 3
		nsTop 201
		nsRight 588
		nsBottom 286
		x 295
		y 243
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance doorBlue4_180 of Feature
	(properties
		noun 22
		nsLeft 195
		nsTop 21
		nsRight 401
		nsBottom 286
		x 298
		y 153
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

