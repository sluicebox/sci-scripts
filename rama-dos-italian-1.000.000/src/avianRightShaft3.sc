;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6006)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	avianRightShaft3 0
)

(local
	local0
)

(instance avianRightShaft3 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(faceUp down: faceOut)
		(faceDown up: faceOut)
		(faceOut up: faceUp)
		(faceOut down: faceDown)
		(if local0
			(self addPicObj: faceIn faceOut faceIn)
		else
			(switch gPrevRoomNum
				(6005 ; avianLeftShaft3
					(self setPicObj: faceIn)
				)
				(6008 ; avianRightShaft4
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
		picture 6045
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(bridgeControls init:)
		(doorBlue3_180 init:)
		(bridgeControl_180 init:)
	)
)

(instance faceOut of CameraAngle
	(properties
		picture 6046
	)

	(method (init)
		(super init:)
		(outExit init:)
		(doorRed3_0 init:)
		(ledges_0 init:)
		(bridge_0 init:)
	)
)

(instance faceUp of CameraAngle
	(properties
		picture 6047
		edgeW 0
		edgeE 0
		edgeN 0
	)

	(method (init)
		(= picture (if (IsFlag 142) 6051 else 6047))
		(super init:)
		(upExit init:)
		(ledges_0_up init:)
		(sea_0_up init:)
	)
)

(instance faceDown of CameraAngle
	(properties
		picture 6048
		edgeW 0
		edgeE 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(downExit init:)
		(ledges_0_down init:)
		(bridge_0_down init:)
	)
)

(instance downExit of ExitFeature
	(properties
		nsBottom 258
		nsLeft 99
		nsRight 513
		nsTop 92
		nextRoom 6008
	)
)

(instance upExit of ExitFeature
	(properties
		nsBottom 172
		nsLeft 55
		nsRight 535
		nsTop 4
		nextRoom 6004
	)
)

(instance outExit of ExitFeature
	(properties
		nsBottom 241
		nsLeft 215
		nsRight 374
		nsTop 91
		nextRoom 6005
	)
)

(instance bridgeControls of Feature
	(properties
		nsBottom 293
		nsLeft 381
		nsRight 434
		nsTop 238
	)

	(method (init)
		(super init:)
		(= plane global116)
		(self setHotspot: 2)
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

(instance doorRed3_0 of Feature
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
					init: 219 43 394 40 409 121 351 229 256 228 194 122
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
					init: 212 236 378 236 381 251 385 249 207 253
					yourself:
				)
		)
	)
)

(instance bridge_0 of Feature
	(properties
		noun 36
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 269 250 325 251 328 287 265 288
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
					init: -1 1 589 0 589 77 540 78 540 113 520 124 411 128 377 144 220 146 177 131 75 129 59 113 58 77 0 75
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
					init: 1 180 134 180 163 201 430 203 457 181 586 176 588 287 2 285
					yourself:
				)
		)
	)
)

(instance bridge_0_down of Feature
	(properties
		noun 36
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 165 2 429 2 430 203 162 203
					yourself:
				)
		)
	)
)

(instance doorBlue3_180 of Feature
	(properties
		noun 52
		x 301
		y 144
		nsBottom 284
		nsLeft 169
		nsRight 433
		nsTop 5
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance bridgeControl_180 of Feature
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
					init: 403 235 433 240 434 285 420 291 398 286 388 270 406 247
					yourself:
				)
		)
	)
)

(instance sea_0_up of Feature
	(properties
		noun 1
		x 295
		y 215
		nsBottom 289
		nsLeft 234
		nsRight 356
		nsTop 141
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

