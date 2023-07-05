;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6001)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)

(public
	avianLeftShaft1 0
)

(local
	local0
)

(instance avianLeftShaft1 of Location
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
				(6101 ; avianSecurity1
					(self setPicObj: faceOut)
				)
				(6003 ; avianLeftShaft2
					(self setPicObj: faceUp)
				)
				(6009 ; avianBridgeControls
					(self addPicObj: faceIn faceOut faceIn)
				)
				(else
					(self setPicObj: faceDown)
					(if (not (IsFlag 122))
						(ledgesClosing play:)
						(proc1111_31 41 14)
					)
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
		picture 6001
		edgeN 0
		edgeS 0
	)

	(method (init)
		(inExit init:)
		(super init:)
		(bridgeControls init:)
		(hallRed1_0 init:)
		(bridgeControls_0 init:)
	)
)

(instance faceOut of CameraAngle
	(properties
		picture 6002
		heading 180
	)

	(method (init)
		(super init:)
		(doorBlue1_180 init:)
		(ledge_180 init:)
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
					(if (IsFlag 142) 6011 else 6003)
				)
				((IsFlag 142) 6054)
				(else 6071)
			)
		)
		(if (IsFlag 122)
			(upExit init:)
		)
		(super init:)
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
				((IsFlag 137) 6004)
				((IsFlag 136) 6077)
				(else 6082)
			)
		)
		(downExit init:)
		(super init:)
		(ledge_0_down init:)
	)
)

(instance downExit of ExitFeature
	(properties
		nsLeft 99
		nsTop 92
		nsRight 513
		nsBottom 258
		nextRoom 6003
	)
)

(instance upExit of ExitFeature
	(properties
		nsLeft 55
		nsTop 4
		nsRight 535
		nsBottom 172
		nextRoom 5005
	)
)

(instance inExit of ExitFeature
	(properties
		nsLeft 190
		nsTop 26
		nsRight 401
		nsBottom 287
		nextRoom 6101
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

(instance ledgesClosing of Sound
	(properties
		flags 5
		number 6001
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
					init: 214 60 400 60 381 173 398 289 206 288 226 176
					yourself:
				)
		)
	)
)

(instance doorBlue1_180 of Feature
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 212 46 382 51 406 125 378 247 208 246 184 119
					yourself:
				)
		)
	)
)

(instance ledge_180 of Feature
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
					init: 215 234 377 234 384 252 204 251
					yourself:
				)
		)
	)
)

(instance ledge_0_down of Feature
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
					init: 267 0 327 1 328 13 266 12
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 2 176 142 181 166 196 172 166 196 157 400 158 423 173 432 199 441 179 587 176
					yourself:
				)
		)
	)
)

(instance hallRed1_0 of Feature
	(properties
		noun 4
		nsLeft 205
		nsTop 28
		nsRight 391
		nsBottom 285
		x 298
		y 156
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
					init: 162 250 189 235 198 287 166 288
					yourself:
				)
		)
	)
)

