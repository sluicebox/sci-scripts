;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6007)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	avianLeftShaft4 0
)

(local
	local0
	local1
	[local2 8] = [6062 6052 6076 6059 6081 6087 6086 6088]
)

(instance avianLeftShaft4 of Location
	(properties)

	(method (init)
		(super init:)
		(faceUp down: faceOut)
		(faceDown up: faceOut)
		(faceOut up: faceUp)
		(faceOut down: faceDown)
		(cond
			((IsFlag 137)
				(cond
					((IsFlag 142)
						(if (IsFlag 122)
							(= local1 1)
						else
							(= local1 3)
						)
					)
					((IsFlag 122)
						(= local1 0)
					)
					(else
						(= local1 2)
					)
				)
			)
			((IsFlag 136)
				(if (IsFlag 142)
					(= local1 5)
				else
					(= local1 4)
				)
			)
			((IsFlag 142)
				(= local1 7)
			)
			(else
				(= local1 6)
			)
		)
		(if local0
			(self addPicObj: faceIn faceOut faceIn)
		else
			(switch gPrevRoomNum
				(6009 ; avianBridgeControls
					(if (== global164 90)
						(self setPicObj: faceOut)
					else
						(self setPicObj: faceIn)
					)
				)
				(6500 ; SessileRoom
					(self setPicObj: faceOut)
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
		picture 6060
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(bridgeControls init:)
		(doorRed4_0 init:)
		(bridgeCntrol_0 init:)
	)
)

(instance faceOut of CameraAngle
	(properties
		heading 180
		picture 6061
	)

	(method (init)
		(super init:)
		(doorBlue4_180 init:)
		(ledges_180 init:)
	)
)

(instance faceUp of CameraAngle
	(properties
		heading 180
		edgeW 0
		edgeE 0
		edgeN 0
	)

	(method (init)
		(= picture [local2 local1])
		(upExit init:)
		(super init:)
		(bridge_0_up init:)
		(ledges_0_up init:)
	)
)

(instance faceDown of CameraAngle
	(properties
		heading 180
		picture 6063
		edgeW 0
		edgeE 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(ledges_0_down init:)
	)
)

(instance bridgeControls of Feature
	(properties
		nsBottom 291
		nsLeft 162
		nsRight 211
		nsTop 233
	)

	(method (init)
		(super init:)
		(= plane global116)
		(self setHotspot: 2 15)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 6009) ; avianBridgeControls
				(self deleteHotspot:)
			)
			(15
				(gCurRoom newRoom: 6009) ; avianBridgeControls
				(self deleteHotspot:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance upExit of ExitFeature
	(properties
		nsBottom 172
		nsLeft 55
		nsRight 535
		nsTop 4
		nextRoom 6005
	)
)

(instance doorBlue4_180 of Feature
	(properties
		noun 34
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 216 40 386 41 409 115 376 201 344 233 249 233 204 183 186 104
					yourself:
				)
		)
	)
)

(instance ledges_180 of Feature
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
					init: 215 233 376 231 386 248 207 249
					yourself:
				)
		)
	)
)

(instance ledges_0_down of Feature
	(properties
		noun 3
		x 295
		y 245
		nsBottom 284
		nsLeft 2
		nsRight 588
		nsTop 207
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance bridge_0_up of Feature
	(properties
		noun 36
		x 294
		y 217
		nsBottom 289
		nsLeft 256
		nsRight 333
		nsTop 145
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
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
					init: 5 0 590 0 586 84 537 79 539 114 520 130 415 130 386 141 210 140 198 133 179 128 69 127 52 114 49 79 4 79
					yourself:
				)
		)
	)
)

(instance doorRed4_0 of Feature
	(properties
		noun 52
		x 297
		y 142
		nsBottom 284
		nsLeft 181
		nsRight 414
		nsTop 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance bridgeCntrol_0 of Feature
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
					init: 159 256 191 232 198 282 172 289
					yourself:
				)
		)
	)
)

