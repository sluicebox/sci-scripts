;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5417)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use newYorkRegion)
(use VMDMovie)
(use Polygon)
(use Feature)
(use System)

(public
	NY_Subway_17 0
)

(instance NY_Subway_17 of Location
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
		heading 225
		picture 5435
		edgeW 0
		edgeE 0
		edgeS 0
		edgeN 0
	)

	(method (init)
		(startSub init:)
		(exitToCorridor init:)
		(chair init:)
		(super init: &rest)
	)
)

(instance exitToCorridor of ExitFeature
	(properties
		nsBottom 279
		nsLeft 193
		nsRight 369
		nsTop 5
		nextRoom 5414
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
				(sub_Transfer play:)
				(gGame handsOn:)
				(gCurRoom newRoom: 5418) ; NY_Subway_18
			)
		)
	)
)

(instance sub_Transfer of VMDMovie
	(properties
		movieName 5404
		endPic 5436
		cacheSize 1000
	)
)

(instance chair of Feature
	(properties
		noun 18
		case 8
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

