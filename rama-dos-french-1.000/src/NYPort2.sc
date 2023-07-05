;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5701)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	NYPort2 0
)

(instance NYPort2 of Location
	(properties
		noun 14
	)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5500 ; NYMazeA
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(2000 ; cplains
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(else
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5707
		edgeS 0
		edgeN 0
	)

	(method (init)
		(ice_0 init:)
		(frame_0 init:)
		(if (IsFlag 71)
			(invMedallion init:)
		)
		(medallionFeat init:)
		(gCurRoom noun: 14 case: 0)
		(super init: &rest)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 5705
		edgeS 0
		edgeN 0
	)

	(method (init)
		(ice_180 init:)
		(frame_180 init:)
		(gCurRoom noun: 14 case: 0)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 71)
			(= picture 5708)
			(newYorkExit init:)
		else
			(= picture 5709)
		)
		(newYorkGate init:)
		(gCurRoom noun: 8 case: 0)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 5706
		edgeS 0
		edgeN 0
	)

	(method (init)
		(port1Exit init:)
		(tracks_270 init:)
		(stairs_270 init:)
		(gCurRoom noun: 4 case: 2)
		(super init: &rest)
	)
)

(instance port1Exit of ExitFeature
	(properties
		nsBottom 179
		nsLeft 232
		nsRight 355
		nsTop 78
		nextRoom 5700
	)
)

(instance newYorkExit of ExitFeature
	(properties
		nextRoom 5500
		exitStyle 256
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 145 1 446 1 498 258 498 290 96 290 95 254
					yourself:
				)
		)
	)
)

(instance medallionFeat of Feature
	(properties
		noun 6
		nsBottom 289
		nsLeft 307
		nsRight 450
		nsTop 115
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 71)
			(self setHotspot: 144)
		else
			(self setHotspot: 61 144)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 61)
			(SetFlag 71)
			(proc70_3 40)
			(gCurRoom setScript: doorOpens)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance newYorkGate of Feature
	(properties
		noun 2
		case 2
	)

	(method (init)
		(if (IsFlag 71)
			(= case (= noun 1))
		)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 145 1 446 1 498 258 498 290 96 290 95 254
					yourself:
				)
			setHotspot: 144
		)
	)
)

(instance device_0 of Feature ; UNUSED
	(properties
		noun 6
		x 378
		y 202
		nsBottom 289
		nsLeft 307
		nsRight 450
		nsTop 115
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance frame_0 of Feature
	(properties
		noun 8
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 172 1 590 0 589 287 153 290 170 265
					yourself:
				)
		)
	)
)

(instance ice_0 of Feature
	(properties
		noun 4
		case 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 77 55 100 102 117 172 133 172 266 154 290 1 290
					yourself:
				)
		)
	)
)

(instance frame_180 of Feature
	(properties
		noun 8
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 421 1 420 265 439 289 0 289 -1 1
					yourself:
				)
		)
	)
)

(instance ice_180 of Feature
	(properties
		noun 4
		case 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 590 59 591 289 438 288 421 264 422 126 487 107 545 85
					yourself:
				)
		)
	)
)

(instance tracks_270 of Feature
	(properties
		noun 12
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 108 58 115 134 129 193 137 293 139 371 140 429 137 482 122 528 102 591 56 590 82 538 119 476 147 427 158 357 160 340 156 251 156 237 159 159 150 90 139 28 129 1 124
					yourself:
				)
		)
	)
)

(instance stairs_270 of Feature
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
					init: 62 292 246 177 252 155 339 154 343 175 531 292
					yourself:
				)
		)
	)
)

(instance invMedallion of View
	(properties
		x 338
		y 228
		view 5701
	)

	(method (init)
		(super init: global117 &rest)
	)
)

(instance doorOpens of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(invMedallion init:)
				(medalClick setVol: 127 play: self)
			)
			(2
				(doorSnd number: 5701 setVol: 127 play: self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance doorSnd of Sound
	(properties
		flags 5
	)
)

(instance medalClick of Sound
	(properties
		number 5028
		flags 5
	)
)

