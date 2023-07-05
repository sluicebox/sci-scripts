;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7502)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use Polygon)
(use Feature)

(public
	octoCisternGate 0
)

(instance octoCisternGate of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(gateDark_270 init:)
		(switch gPrevRoomNum
			(7500 ; octoCistern
				(self addPicObj: faceGate faceMo faceGate)
			)
			(else
				(self addPicObj: faceGate faceMo faceGate)
			)
		)
	)
)

(instance faceGate of CameraAngle
	(properties
		heading 270
		picture 7507
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToBar init:)
		(gCurRoom exitNE: exitToBar)
		(exitToLock init:)
		(gCurRoom exitNW: exitToLock)
		(super init:)
	)
)

(instance faceMo of CameraAngle
	(properties
		heading 90
		picture 7508
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToMoDir init:)
		(gCurRoom exitN: exitToMoDir)
		(super init:)
	)
)

(instance exitToMoDir of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 7500
	)
)

(instance exitToBar of Feature
	(properties
		nsBottom 243
		nsLeft 163
		nsRight 247
		nsTop 208
	)

	(method (init)
		(super init: &rest)
		(if (== (proc70_9 92) 7508)
			(self setHotspot: 2 43)
		else
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(43
				(gCurRoom newRoom: 7508) ; octoCisBarsCU
			)
			(2
				(gCurRoom newRoom: 7508) ; octoCisBarsCU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToLock of Feature
	(properties
		nsBottom 198
		nsLeft 286
		nsRight 325
		nsTop 174
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 7507) ; octoCisLockCU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gateDark_270 of Feature
	(properties
		noun 36
	)

	(method (init)
		(super init: &rest)
		(if (== (proc70_9 92) 7508)
			(= case 5)
		else
			(= case 6)
		)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 152 107 446 107 561 269 42 264 158 102
					yourself:
				)
		)
	)
)

