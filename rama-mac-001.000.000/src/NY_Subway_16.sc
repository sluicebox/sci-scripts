;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5416)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use newYorkRegion)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use System)

(public
	NY_Subway_16 0
)

(instance NY_Subway_16 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(proc201_1 30)
		(self setPicObj: faceRoom)
	)
)

(instance faceRoom of CameraAngle
	(properties
		heading 45
		edgeN 0
		edgeS 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(if (and (IsFlag 242) (IsFlag 243) (IsFlag 244))
			(= picture 5430)
			(exitToCorridor init:)
			(chair init:)
		else
			(= picture 5437)
			(door init:)
		)
		(startSub init:)
		(map init:)
		(super init: &rest)
		(if
			(and
				(IsFlag 242)
				(IsFlag 243)
				(IsFlag 244)
				(not (IsFlag 257))
			)
			(SetFlag 257)
			(proc1111_31 37 10)
		)
	)
)

(instance exitToCorridor of ExitFeature
	(properties
		nsLeft 193
		nsTop 5
		nsRight 369
		nsBottom 279
		nextRoom 5413
	)
)

(instance startSub of Feature
	(properties
		noun 8
		x 444
		y 138
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 417 123 457 123 464 129 474 157 468 158 464 154 427 154 423 158 419 157 414 131
					yourself:
				)
			setHotspot: 2 144
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom setScript: subTransfer)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance subTransfer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(if (and (IsFlag 242) (IsFlag 243) (IsFlag 244))
					(sub_Transfer play:)
				else
					(sub_Transfer_DoorClosed play:)
				)
				(gGame handsOn:)
				(gCurRoom newRoom: 5406) ; NY_Subway_6
			)
		)
	)
)

(instance sub_Transfer of VMDMovie
	(properties
		movieName 5406
		endPic 5413
		cacheSize 1000
	)
)

(instance sub_Transfer_DoorClosed of VMDMovie
	(properties
		movieName 5410
		endPic 5413
		cacheSize 1000
	)
)

(instance map of Feature
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
					init: 456 196 500 220 508 252 506 258 500 261 441 260 436 255 435 249 427 226 425 220 451 198
					yourself:
				)
		)
	)
)

(instance door of Feature
	(properties
		noun 24
		nsLeft 192
		nsRight 367
		nsBottom 280
		x 279
		y 140
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance chair of Feature
	(properties
		noun 18
		case 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 254 49 308 48 310 116 320 118 320 138 308 138 308 141 329 198 328 202 315 205 311 211 309 243 252 243 253 216 232 204 232 173 234 167 246 165 257 142 257 137 245 137 244 118 257 116 255 49
					yourself:
				)
		)
	)
)

