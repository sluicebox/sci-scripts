;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7908)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use newYorkRegion)
(use VMDMovie)
(use Polygon)
(use Feature)
(use System)

(public
	octoSubwaySmall 0
)

(instance octoSubwaySmall of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7906 ; octoSubStation
				(self addPicObj: faceCar faceStation faceCar)
			)
			(7907 ; octoSubwayCarLarge
				(self addPicObj: faceCar faceStation faceCar)
			)
			(7909 ; octoSubwayInsideCar
				(if (== (proc70_9 33) 7909)
					(gCurRoom setScript: sFalstaffReturns)
				)
				(self addPicObj: faceCar faceStation faceCar)
			)
			(else
				(self addPicObj: faceStation faceCar faceStation)
			)
		)
	)
)

(instance faceCar of CameraAngle
	(properties
		picture 7931
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(subwayCar init:)
	)
)

(instance faceStation of CameraAngle
	(properties
		picture 7930
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToLrgCar init:)
		(gCurRoom exitNW: exitToLrgCar)
		(exitToStation init:)
		(gCurRoom exitNE: exitToStation)
		(super init:)
		(LSUBWAY_270 init:)
	)
)

(instance exitToStation of ExitFeature
	(properties
		nsLeft 477
		nsTop 153
		nsRight 585
		nsBottom 279
		nextRoom 7906
	)
)

(instance exitToLrgCar of ExitFeature
	(properties
		nsLeft 28
		nsTop 65
		nsRight 204
		nsBottom 210
		nextRoom 7907
	)
)

(instance sFalstaffReturns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc70_14)
				(falstaffReturns play: self)
			)
			(1
				(gCurRoom drawPic: 7931 256)
				(proc70_1 33)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sFalstaffEntersSub of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc201_1 22)
				(falstaffEnters play: self)
			)
			(1
				(gCurRoom newRoom: 7909) ; octoSubwayInsideCar
				(self dispose:)
			)
		)
	)
)

(instance falstaffEnters of VMDMovie
	(properties
		movieName 38981
		begPic 38980
		endPic 38989
	)
)

(instance falstaffReturns of VMDMovie
	(properties
		movieName 38991
		begPic 38990
		endPic 38999
	)
)

(instance subwayCar of Feature
	(properties
		noun 64
		nsLeft 240
		nsTop 137
		nsRight 417
		nsBottom 206
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(if (and (!= (proc70_9 89) 7909) (!= (proc70_9 90) 7909))
			(self setHotspot: 43 82 144)
		else
			(self setHotspot: 43 144)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(82
				(= temp0 (proc70_7 (gTheCursor invItem:)))
				(proc70_3)
				(proc70_10 temp0 7909)
				(self deleteHotspot: 82)
				(self setHotspot: 43 144)
			)
			(43
				(proc70_3 33)
				(proc70_10 33 7909)
				(gCurRoom setScript: sFalstaffEntersSub)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance LSUBWAY_270 of Feature
	(properties
		noun 63
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 8 92 31 52 81 36 148 75 154 126 83 166 19 131 9 99
					yourself:
				)
		)
	)
)

