;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5313)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use Feature)
(use Actor)

(public
	NY_Octospider_Plaza_13 0
)

(instance NY_Octospider_Plaza_13 of Location
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5312 ; NY_Octospider_Plaza_12
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(5314 ; NY_Octospider_Plaza_14
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(else
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 5351
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToRoom12 init:)
		(gCurRoom exitN: exitToRoom12)
		(super init:)
		(maze_270 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5349
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 5350
		edgeN 0
		edgeS 0
	)

	(method (init)
		(mazeCard init:)
		(mazePiston init:)
		(mazeLights init:)
		(exitToMazeCtrl init:)
		(gCurRoom exitN: exitToMazeCtrl)
		(super init:)
		(mazeController_0 init:)
		(mazeMap_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 5352
		heading 180
		edgeN 0
		edgeS 0
	)
)

(instance exitToRoom12 of ExitFeature
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
		nextRoom 5312
	)
)

(instance exitToMazeCtrl of ExitFeature
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
		nextRoom 5314
	)
)

(instance mazeCard of View
	(properties
		x 288
		y 188
		view 5320
		loop 1
		cel 5
	)

	(method (init)
		(if (not (== (proc70_9 47) 5328))
			(return)
		)
		(super init: global117 &rest)
	)
)

(instance mazePiston of View
	(properties
		x 283
		y 185
		view 5320
	)

	(method (init)
		(= cel global256)
		(super init: global117 &rest)
	)
)

(instance mazeLights of View
	(properties
		x 286
		y 181
		view 5320
		loop 1
	)

	(method (init)
		(if (not (== (proc70_9 47) 5328))
			(return)
		)
		(= cel global256)
		(super init: global117 &rest)
	)
)

(instance maze_270 of Feature
	(properties
		noun 18
		nsLeft 254
		nsTop -1
		nsRight 285
		nsBottom 177
		x 269
		y 88
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance mazeController_0 of Feature
	(properties
		noun 24
		nsLeft 273
		nsTop 170
		nsRight 310
		nsBottom 208
		x 291
		y 189
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance mazeMap_0 of Feature
	(properties
		noun 25
		nsLeft 269
		nsTop 146
		nsRight 314
		nsBottom 163
		x 291
		y 154
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

