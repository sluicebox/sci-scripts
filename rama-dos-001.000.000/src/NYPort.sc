;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5700)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Sound)
(use System)

(public
	NYPort 0
)

(instance NYPort of Location
	(properties
		noun 14
	)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5701 ; NYPort2
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
		picture 5703
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(walls_0 init:)
		(ice_0 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 5702
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(walls_180 init:)
		(ice_180 init:)
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
			(= picture 5701)
		else
			(= picture 5710)
		)
		(super init: &rest)
		(walls_90 init:)
		(port2Exit init:)
		(stairs_90 init:)
		(gate_90 init:)
		(seaArch_90 init:)
		(if (not (IsFlag 75))
			(SetFlag 75)
			(nicole_blabs endPic: (self picture:))
			(gCurRoom setScript: iceMobileArrives)
		)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 5704
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(ice_270 init:)
	)
)

(instance port2Exit of ExitFeature
	(properties
		nextRoom 5701
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 274 124 319 124 333 140 348 207 243 207 258 138
					yourself:
				)
		)
	)
)

(instance iceMobileArrives of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(nicole_blabs play:)
				(gGame handsOff:)
				(iceMobileLeaves setVol: 127 play: self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance nicole_blabs of VMDMovie
	(properties
		movieName 38191
	)
)

(instance iceMobileLeaves of Sound
	(properties
		number 5029
		flags 5
	)
)

(instance walls_0 of Feature
	(properties
		noun 3
		case 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 303 83 315 1 590 0 590 170 303 145
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
					init: 0 79 79 112 160 132 242 144 300 144 590 172 591 289 0 289
					yourself:
				)
		)
	)
)

(instance stairs_90 of Feature
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
					init: 168 290 240 203 349 204 422 290
					yourself:
				)
		)
	)
)

(instance gate_90 of Feature
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
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 274 124 319 124 333 140 348 207 243 207 258 138
					yourself:
				)
		)
	)
)

(instance walls_90 of Feature
	(properties
		noun 3
		case 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 317 0 591 0 593 290 1 291 1 -1 276 -1 279 61 314 59
					yourself:
				)
		)
	)
)

(instance seaArch_90 of Feature
	(properties
		noun 4
		case 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 275 0 315 0 314 60 276 60
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
					init: 0 170 287 145 386 135 491 105 547 82 591 58 590 289 0 289
					yourself:
				)
		)
	)
)

(instance walls_180 of Feature
	(properties
		noun 3
		case 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 288 82 288 144 0 171 1 -1 274 -1
					yourself:
				)
		)
	)
)

(instance ice_270 of Feature
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
					init: 157 0 432 0 445 30 460 48 484 67 524 85 559 96 589 103 590 290 0 289 -1 101 37 91 72 79 110 59 137 37 152 17 158 0
					yourself:
				)
		)
	)
)

