;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5314)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use Polygon)
(use Feature)
(use Actor)

(public
	NY_Octospider_Plaza_14 0
)

(instance NY_Octospider_Plaza_14 of Location
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5313 ; NY_Octospider_Plaza_13
				(self addPicObj: faceW faceE faceW)
			)
			(5328 ; NYOctospiderPlaza28
				(self addPicObj: faceW faceE faceW)
			)
			(else
				(self addPicObj: faceE faceW faceE)
			)
		)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 180
		picture 5354
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToRoom13 init:)
		(gCurRoom exitN: exitToRoom13)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 5353
		edgeS 0
		edgeN 0
	)

	(method (init)
		(mazeCard init:)
		(mazePiston init:)
		(mazeLights init:)
		(exitToMazeCtrl init:)
		(gCurRoom exitN: exitToMazeCtrl)
		(super init: &rest)
		(mazeController_0 init:)
		(mazeMap_0 init:)
	)
)

(instance exitToMazeCtrl of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
	)

	(method (init)
		(super init:)
		(self setHotspot: 2 46)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5328) ; NYOctospiderPlaza28
			)
			(46
				(gCurRoom newRoom: 5328) ; NYOctospiderPlaza28
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToRoom13 of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 5313
	)
)

(instance mazeCard of View
	(properties
		x 282
		y 230
		loop 3
		cel 5
		view 5320
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
		x 257
		y 218
		loop 2
		view 5320
	)

	(method (init)
		(= cel global256)
		(super init: global117 &rest)
	)
)

(instance mazeLights of View
	(properties
		loop 3
		view 5320
	)

	(method (init)
		(if (not (== (proc70_9 47) 5328))
			(return)
		)
		(switch (= cel global256)
			(0
				(self x: 247 y: 190)
			)
			(1
				(self x: 270 y: 190)
			)
			(2
				(self x: 288 y: 190)
			)
			(3
				(self x: 309 y: 189)
			)
			(4
				(self x: 335 y: 189)
			)
		)
		(super init: global117 &rest)
	)
)

(instance mazeController_0 of Feature
	(properties
		noun 24
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 160 290 158 269 166 250 153 232 152 214 157 195 172 195 176 187 192 188 227 150 225 134 237 126 252 124 290 119 344 126 355 135 355 150 372 170 380 187 401 187 404 196 422 196 430 214 425 236 419 257 420 290
					yourself:
				)
		)
	)
)

(instance mazeMap_0 of Feature
	(properties
		noun 25
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 222 53 249 23 338 22 367 53 337 85 249 83
					yourself:
				)
		)
	)
)

