;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5329)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use newYorkRegion)
(use Polygon)
(use Feature)
(use Actor)

(public
	NY_Octospider_Plaza_29 0
)

(local
	local0
	[local1 5] = [194 190 186 182 178]
	[local6 3] = [182 180 178]
)

(instance NY_Octospider_Plaza_29 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(proc201_1 6)
		(self addPicObj: faceE faceW faceE)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 5325) ; NY_Octospider_Plaza_25
			(= exitStyle 13)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 5382
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToRoom25 init:)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 180
		picture 5381
		edgeS 0
		edgeN 0
	)

	(method (init)
		(= local0 [global227 global216])
		(exitToWilliamsColorMatching init:)
		(redSlider init: global117)
		(greenSlider init: global117)
		(blueSlider init: global117)
		(monitorSwitch init: global117)
		(super init: &rest)
		(colorMachine_180 init:)
	)
)

(instance exitToRoom25 of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 5325
	)
)

(instance exitToWilliamsColorMatching of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 2
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 264 165 329 165 335 206 331 227 264 227 259 202
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5331) ; NY_Octospider_Plaza_31
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance redSlider of View
	(properties
		x 275
		view 5381
	)

	(method (init)
		(= y [local1 (& $000f (>> local0 $0008))])
		(super init: &rest)
	)
)

(instance greenSlider of View
	(properties
		x 284
		view 5381
	)

	(method (init)
		(= y [local1 (& $000f (>> local0 $0004))])
		(super init: &rest)
	)
)

(instance blueSlider of View
	(properties
		x 294
		view 5381
	)

	(method (init)
		(= y [local1 (& $000f local0)])
		(super init: &rest)
	)
)

(instance monitorSwitch of View
	(properties
		x 306
		cel 1
		view 5381
	)

	(method (init)
		(= y [local6 global216])
		(super init: &rest)
	)
)

(instance colorMachine_180 of Feature
	(properties
		noun 22
		x 295
		y 180
		nsBottom 236
		nsLeft 249
		nsRight 342
		nsTop 124
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

