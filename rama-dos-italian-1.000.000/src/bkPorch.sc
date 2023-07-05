;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4000)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	bkPorch 0
)

(instance bkPorch of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(4002 ; bkPorchDoor
				(self addPicObj: facePuzzle facePorch facePuzzle)
			)
			(4004 ; bk1CountRm
				(facePorch showBlack: 1)
				(self addPicObj: facePorch facePuzzle facePorch)
			)
			(else
				(facePuzzle showBlack: 1)
				(self addPicObj: facePuzzle facePorch facePuzzle)
			)
		)
		(if (and (== gPrevRoomNum 108) (IsFlag 35)) ; matrixPuzzle
			(ClearFlag 35)
		)
		(= global266 -1)
		(= global267 -1)
		(= global268 -1)
		(= global245 0)
		(= global246 0)
		(= global247 0)
		(= global248 0)
		(= global249 0)
		(= global207 0)
	)

	(method (yaw)
		(picObj showBlack: 1)
		(super yaw: &rest)
	)
)

(instance facePorch of CameraAngle
	(properties
		heading 180
		picture 4012
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(exitToOutside init:)
		(gCurRoom exitN: exitToOutside)
		(hubsite_180 init:)
		(lights_180 init:)
	)
)

(instance facePuzzle of CameraAngle
	(properties
		edgeS 0
		edgeN 0
	)

	(method (init)
		(cond
			((IsFlag 39)
				(exitToCountRm init:)
				(= picture 4063)
			)
			((IsFlag 34)
				(exitToCountRm init:)
				(= picture 4007)
			)
			(else
				(= picture 4013)
			)
		)
		(super init: &rest)
		(exitToDoor init:)
		(exitToMatrix init:)
		(door_0 init:)
	)
)

(instance exitToDoor of Feature
	(properties
		nsBottom 179
		nsLeft 192
		nsRight 248
		nsTop 66
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
		(if (IsFlag 34)
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 261 179 260 139 283 107 310 107 332 139 332 181 398 181 397 138 336 82 264 81 200 131 199 179 261 179
						yourself:
					)
			)
		else
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 232 115 281 90 312 90 353 112 385 153 385 180 207 184 209 146 231 115
						yourself:
					)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4002) ; bkPorchDoor
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToCountRm of ExitFeature
	(properties
		nsBottom 183
		nsLeft 259
		nsRight 345
		nsTop 78
		nextRoom 4004
		exitStyle 256
	)
)

(instance exitToMatrix of Feature
	(properties
		nsBottom 201
		nsLeft 398
		nsRight 460
		nsTop 128
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 108) ; matrixPuzzle
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToOutside of ExitFeature
	(properties
		nsBottom 300
		nsLeft 200
		nsRight 400
		nsTop 100
		nextRoom 2081
	)
)

(instance door_0 of Feature
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
					init: 203 182 203 153 228 119 246 104 268 95 295 90 317 94 340 102 358 120 373 137 376 146 376 181
					yourself:
				)
		)
	)
)

(instance hubsite_180 of Feature
	(properties
		noun 10
		x 298
		y 29
		nsBottom 59
		nsLeft 258
		nsRight 339
		nsTop -1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance lights_180 of Feature
	(properties
		noun 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -2 105 182 130 126 131 0 118
					yourself:
				)
		)
	)
)

