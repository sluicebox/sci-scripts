;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5310)
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
	NY_Octospider_Plaza_10 0
)

(instance NY_Octospider_Plaza_10 of Location
	(properties
		noun 1
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(5308 ; NY_Octospider_Plaza_8
				(self addPicObj: faceSW faceNW faceNE faceSE faceSW)
			)
			(5309 ; NY_Octospider_Plaza_9
				(self addPicObj: faceSW faceNW faceNE faceSE faceSW)
			)
			(5311 ; NY_Octospider_Plaza_11
				(self addPicObj: faceSE faceSW faceNW faceNE faceSE)
			)
			(else
				(self addPicObj: faceSE faceSW faceNW faceNE faceSE)
			)
		)
	)
)

(instance faceSE of CameraAngle
	(properties
		heading 225
		picture 5338
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(tetraIY init: global117)
	)
)

(instance faceNE of CameraAngle
	(properties
		heading 135
		picture 5339
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 239)
			(= picture 5391)
		)
		(exitToRoom4 init:)
		(exitToRoom9 init:)
		(super init:)
		(octohedron_135 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		heading 45
		picture 5340
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToRoom11 init:)
		(super init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		heading 315
		picture 5337
		edgeS 0
		edgeN 0
	)
)

(instance exitToRoom4 of ExitFeature
	(properties
		nsBottom 241
		nsLeft 126
		nsRight 369
		nsTop 98
		nextRoom 5308
	)
)

(instance exitToRoom9 of ExitFeature
	(properties
		nsBottom 245
		nsLeft 388
		nsRight 563
		nsTop 103
		nextRoom 5309
	)
)

(instance exitToRoom11 of ExitFeature
	(properties
		nsBottom 245
		nsLeft 110
		nsRight 523
		nsTop 88
		nextRoom 5311
	)
)

(instance tetraIY of View
	(properties
		x 305
		y 211
		cel 6
		view 5300
	)

	(method (init)
		(if (!= (proc70_9 100) gCurRoomNum)
			(return)
		)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 100 0)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance octohedron_135 of Feature
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
					init: 278 151 309 151 310 176 298 180 266 181 279 175
					yourself:
				)
		)
	)
)

