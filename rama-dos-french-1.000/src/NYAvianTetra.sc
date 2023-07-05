;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5029)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use newYorkRegion)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)

(public
	NYAvianTetra 0
)

(instance NYAvianTetra of Location
	(properties)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(proc201_1 33)
		(self addPicObj: faceE faceW faceE)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 5152
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToRoom12 init:)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 5151
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToPuzzle init:)
		(onSwitch init:)
		(lockSwitch init:)
		(dial init:)
		(monitor init:)
		(super init: &rest)
		(machine_90 init:)
	)
)

(instance exitToPuzzle of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 5030
	)
)

(instance exitToRoom12 of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 5012
		exitStyle 13
	)
)

(instance onSwitch of View
	(properties
		x 285
		y 209
		loop 3
		view 5072
	)

	(method (init)
		(= cel (if (IsFlag 233) 1 else 0))
		(super init: global117 &rest)
	)
)

(instance lockSwitch of View
	(properties
		x 301
		y 179
		loop 4
		view 5072
	)

	(method (init)
		(= cel (if (IsFlag 231) 1 else 0))
		(super init: global117 &rest)
	)
)

(instance dial of View
	(properties
		x 280
		y 189
		loop 2
		view 5072
	)

	(method (init)
		(= cel global257)
		(super init: global117 &rest)
	)
)

(instance monitor of View
	(properties
		x 295
		y 163
		view 5072
	)

	(method (init)
		(if (IsFlag 233)
			(= cel (+ global257 1))
		)
		(if (IsFlag 231)
			(= loop 1)
		)
		(super init: global117 &rest)
	)
)

(instance machine_90 of Feature
	(properties
		noun 36
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 264 91 260 138 255 198 261 220 277 227 277 245 313 246 315 223 330 219 341 203 347 162 333 141 332 92 298 78 273 81 262 89
					yourself:
				)
		)
	)
)

