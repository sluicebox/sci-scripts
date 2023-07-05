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
		picture 5338
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(tetraIY init: global117)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 5339
		heading 135
		edgeN 0
		edgeS 0
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
		picture 5340
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToRoom11 init:)
		(super init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 5337
		heading 315
		edgeN 0
		edgeS 0
	)
)

(instance exitToRoom4 of ExitFeature
	(properties
		nsLeft 126
		nsTop 98
		nsRight 369
		nsBottom 241
		nextRoom 5308
	)
)

(instance exitToRoom9 of ExitFeature
	(properties
		nsLeft 388
		nsTop 103
		nsRight 563
		nsBottom 245
		nextRoom 5309
	)
)

(instance exitToRoom11 of ExitFeature
	(properties
		nsLeft 110
		nsTop 88
		nsRight 523
		nsBottom 245
		nextRoom 5311
	)
)

(instance tetraIY of View
	(properties
		x 305
		y 211
		view 5300
		cel 6
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

