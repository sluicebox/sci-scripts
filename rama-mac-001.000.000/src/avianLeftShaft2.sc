;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6003)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	avianLeftShaft2 0
)

(local
	local0
)

(instance avianLeftShaft2 of Location
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
				(6200 ; avianGreatHall1
					(self setPicObj: faceOut)
				)
				(6005 ; avianLeftShaft3
					(self setPicObj: faceUp)
				)
				(6009 ; avianBridgeControls
					(if (== global164 90)
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
		picture 6020
		edgeN 0
		edgeS 0
	)

	(method (init)
		(inExit init:)
		(super init:)
		(bridgeControls init:)
		(doorRed2_0 init:)
		(bridgeControls_0 init:)
	)
)

(instance faceOut of CameraAngle
	(properties
		picture 6021
		heading 180
	)

	(method (init)
		(super init:)
		(doorBlue2_180 init:)
	)
)

(instance faceUp of CameraAngle
	(properties
		heading 180
		edgeN 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(= picture
			(cond
				((IsFlag 122)
					(if (IsFlag 142) 6030 else 6022)
				)
				((IsFlag 142) 6055)
				(else 6072)
			)
		)
		(upExit init:)
		(super init:)
		(ledges_0_up init:)
		(sea_0_up init:)
	)
)

(instance faceDown of CameraAngle
	(properties
		heading 180
		edgeS 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(= picture
			(cond
				((IsFlag 137) 6023)
				((IsFlag 136) 6078)
				(else 6083)
			)
		)
		(super init:)
		(downExit init:)
		(ledges_0_down init:)
	)
)

(instance downExit of ExitFeature
	(properties
		nsLeft 99
		nsTop 92
		nsRight 513
		nsBottom 258
		nextRoom 6005
	)
)

(instance upExit of ExitFeature
	(properties
		nsLeft 55
		nsTop 4
		nsRight 535
		nsBottom 172
		nextRoom 6001
	)
)

(instance inExit of ExitFeature
	(properties
		nsLeft 190
		nsTop 26
		nsRight 401
		nsBottom 287
		nextRoom 6200
		exitStyle 13
	)
)

(instance bridgeControls of Feature
	(properties
		nsLeft 162
		nsTop 233
		nsRight 211
		nsBottom 291
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
					init: -1 2 590 5 589 78 539 81 538 111 521 127 66 123 56 112 57 82 2 79
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
					init: 222 135 382 136 382 176 387 231 389 287 205 292 222 222 223 138
					yourself:
				)
		)
	)
)

(instance doorBlue2_180 of Feature
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
					init: 209 40 386 43 409 122 360 225 387 246 377 253 214 256 205 244 208 236 250 234 184 125
					yourself:
				)
		)
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
					init: 2 176 137 179 163 199 169 172 180 163 399 163 419 174 423 200 438 182 590 176 588 289 0 284
					yourself:
				)
		)
	)
)

(instance doorRed2_0 of Feature
	(properties
		noun 11
		nsLeft 204
		nsTop 31
		nsRight 396
		nsBottom 286
		x 300
		y 158
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance bridgeControls_0 of Feature
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
					init: 162 255 182 241 205 288 163 290
					yourself:
				)
		)
	)
)

