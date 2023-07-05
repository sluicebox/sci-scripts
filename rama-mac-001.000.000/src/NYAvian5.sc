;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5005)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use System)

(public
	NYAvian5 0
)

(instance NYAvian5 of Location
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5006 ; NYAvian6
				(self addPicObj: faceSW faceE faceSW)
			)
			(6000 ; avianShaft
				(self addPicObj: faceSW faceE faceSW)
			)
			(else
				(self addPicObj: faceE faceSW faceE)
			)
		)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 5021
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init &tmp temp0)
		(loc6Exit init:)
		(gCurRoom exitN: loc6Exit)
		(if (and (not (IsFlag 225)) (IsFlag 230))
			(= temp0 1)
			(= showBlack 1)
			(= picture 38340)
		else
			(= picture 5021)
			(= temp0 0)
		)
		(super init: &rest)
		(if temp0
			(gCurRoom setScript: richardBombs)
		)
		(= temp0 0)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 5020
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init &tmp temp0)
		(switch global413
			(4
				(= temp0 5)
				(= picture 5922)
				(avianLairOpeningExit init:)
			)
			(2
				(= temp0 5)
				(= picture 5022)
				(avianLairOpeningExit init:)
			)
			(else
				(= temp0 4)
				(= picture 5020)
			)
		)
		(super init: &rest)
		(lairDoor_225 case: temp0 init:)
	)
)

(instance loc6Exit of ExitFeature
	(properties
		nsLeft 215
		nsTop 76
		nsRight 501
		nsBottom 231
		nextRoom 5006
	)
)

(instance avianLairOpeningExit of ExitFeature
	(properties
		nextRoom 6000
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 223 160 343 156 481 206 244 224
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 0)
			(else
				(gGame autoSave: 1 911)
			)
		)
		(super doVerb: theVerb)
	)
)

(instance richardBombs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(scene834_A play:)
				(scene834_B play:)
				(scene834_C play:)
				(proc70_1 33)
				(SetFlag 225)
				(global122 notify:)
				((ScriptID 201 0) setBombTimer:) ; newYorkRegion
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance scene834_A of VMDMovie
	(properties
		movieName 38341
		endPic 61
		cacheSize 1000
	)
)

(instance scene834_B of VMDMovie
	(properties
		movieName 38342
		x 224
		y 92
		frameRate 15
		options 1
		endPic 38340
		cacheSize 1000
	)
)

(instance scene834_C of VMDMovie
	(properties
		movieName 38343
		endPic 38349
		cacheSize 1000
	)
)

(instance lairDoor_225 of Feature
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
					init: 77 -1 63 205 215 292 400 289 589 238 591 211 538 204 509 -1
					yourself:
				)
		)
	)
)

