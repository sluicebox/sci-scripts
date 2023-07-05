;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5325)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)

(public
	NY_Octospider_Plaza_25 0
)

(instance NY_Octospider_Plaza_25 of Location
	(properties
		noun 2
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(5308 ; NY_Octospider_Plaza_8
				(self addPicObj: faceE faceW faceE)
			)
			(5326 ; NY_Octospider_Plaza_26
				(self addPicObj: faceE faceW faceE)
			)
			(else
				(self addPicObj: faceW faceE faceW)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 5329) ; NY_Octospider_Plaza_29
			(= exitStyle 13)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 5371
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToRoom8 init:)
		(super init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 5370
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(= showBlack 1)
		(if (IsFlag 239)
			(= picture 5380)
			(exitToRoom29 init:)
		else
			(= picture 5370)
		)
		(super init:)
		(prism init: global117)
		(prismPuzzle_180 init:)
	)
)

(instance exitToRoom8 of ExitFeature
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
		nextRoom 5308
	)
)

(instance exitToRoom26 of ExitFeature ; UNUSED
	(properties
		nsLeft 35
		nsTop 88
		nsRight 128
		nsBottom 195
		nextRoom 5326
	)
)

(instance exitToRoom29 of ExitFeature
	(properties
		nextRoom 5329
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 239 0 99 272 498 272 359 0
					yourself:
				)
		)
	)
)

(instance prism of View
	(properties
		x 69
		y 121
		view 5370
	)

	(method (init)
		(if (!= (proc70_9 113) 5326)
			(return)
		)
		(super init: &rest)
	)
)

(instance prismPuzzle_180 of Feature
	(properties
		noun 15
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144 2 117
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 74 99 109 138 115 166 99 186 73 187 50 166 47 143
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5326) ; NY_Octospider_Plaza_26
			)
			(117
				(gCurRoom newRoom: 5326) ; NY_Octospider_Plaza_26
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

