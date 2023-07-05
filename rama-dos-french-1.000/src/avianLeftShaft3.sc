;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6005)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)

(public
	avianLeftShaft3 0
)

(local
	local0
)

(instance avianLeftShaft3 of Location
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
				(6400 ; avianTheatre1
					(self setPicObj: faceOut)
				)
				(6007 ; avianLeftShaft4
					(self setPicObj: faceUp)
				)
				(6006 ; avianRightShaft3
					(self setPicObj: faceIn)
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
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 127)
			(= picture 6040)
			(doorRed3_0 init:)
		else
			(= picture 6013)
			(avianGuard_0 init:)
		)
		(super init:)
		(inExit init:)
		(bridgeControls init:)
		(if (proc1111_24 138)
			(bridgeControls_0 init:)
		)
	)
)

(instance faceOut of CameraAngle
	(properties
		heading 180
	)

	(method (init)
		(= picture
			(cond
				((IsFlag 137) 6041)
				((IsFlag 136) 6080)
				(else 6085)
			)
		)
		(super init:)
		(if (IsFlag 137)
			(bridge_180 init:)
			(exitToOtherSide init:)
		)
		(if (IsFlag 136)
			(exitToOtherSide init:)
		)
		(doorBlue3_180 init:)
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
		(= picture
			(cond
				((IsFlag 122)
					(if (IsFlag 142) 6050 else 6042)
				)
				((IsFlag 142) 6057)
				(else 6074)
			)
		)
		(super init:)
		(upExit init:)
		(sea_0_up init:)
		(ledges_0_up init:)
	)
)

(instance faceDown of CameraAngle
	(properties
		heading 180
		edgeW 0
		edgeE 0
		edgeS 0
	)

	(method (init)
		(= picture
			(cond
				((IsFlag 137)
					(bridge_180_down init:)
					6043
				)
				((IsFlag 136) 6079)
				(else 6084)
			)
		)
		(super init:)
		(downExit init:)
		(ledges_0_down init:)
	)
)

(instance downExit of ExitFeature
	(properties
		nsBottom 258
		nsLeft 99
		nsRight 513
		nsTop 92
		nextRoom 6007
	)
)

(instance upExit of ExitFeature
	(properties
		nsBottom 172
		nsLeft 55
		nsRight 535
		nsTop 4
		nextRoom 6003
	)
)

(instance inExit of ExitFeature
	(properties
		nsBottom 287
		nsLeft 190
		nsRight 401
		nsTop 26
		nextRoom 6400
		exitStyle 13
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9
				(if (and (== nextRoom 6400) (not (IsFlag 127)))
					(theatreGuard play:)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToOtherSide of ExitFeature
	(properties
		nsBottom 289
		nsLeft 205
		nsRight 396
		nsTop 44
		nextRoom 6006
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9
				(if (not (IsFlag 137))
					(gGame autoSave: 1)
					((gCurRoom picObj:) showBlack: 0)
					(gCurRoom setScript: (ScriptID 97 0)) ; shiftToRed
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
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

(instance theatreGuard of VMDMovie
	(properties
		movieName 6005
		endPic 6014
	)
)

(instance doorBlue3_180 of Feature
	(properties
		noun 21
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 208 38 385 46 407 119 385 195 384 248 248 233 187 130 193 98
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
					init: 212 237 360 231 382 247 379 251 207 251
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
		nsBottom 288
		nsLeft 235
		nsRight 355
		nsTop 143
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
					init: 3 3 588 1 590 73 540 77 541 114 517 127 392 132 385 141 213 142 201 135 173 127 72 124 53 110 53 82 9 76
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
					init: 2 177 182 161 369 164 589 178 588 291 3 286
					yourself:
				)
		)
	)
)

(instance doorRed3_0 of Feature
	(properties
		noun 22
		x 298
		y 157
		nsBottom 287
		nsLeft 203
		nsRight 394
		nsTop 28
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
					init: 160 253 183 237 201 281 183 289 167 287
					yourself:
				)
		)
	)
)

(instance avianGuard_0 of Feature
	(properties
		noun 17
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 214 129 242 76 275 106 289 53 302 52 315 92 320 136 332 120 343 73 360 78 358 118 378 165 342 239 333 286 256 287 252 259 211 259 225 166 208 155 211 143 233 102
					yourself:
				)
		)
	)
)

(instance bridge_180 of Feature
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
					init: 272 245 256 290 338 292 320 245
					yourself:
				)
		)
	)
)

(instance bridge_180_down of Feature
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
					init: 157 0 156 291 431 290 429 1
					yourself:
				)
		)
	)
)

