;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6809)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Actor)

(public
	avianHatchery09 0
)

(instance avianHatchery09 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(self addPicObj: faceS faceW faceN faceE faceS)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25
				(switch picObj
					(faceW
						(eastMural init: global117)
					)
					(faceN
						(southMural1 init: global117)
						(southMural2 init: global117)
					)
				)
			)
			(26
				(switch picObj
					(faceW
						(eastMural dispose:)
					)
					(faceN
						(southMural1 dispose:)
						(southMural2 dispose:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 6850
		heading 180
		edgeN 0
		edgeS 0
	)
)

(instance faceW of CameraAngle
	(properties
		picture 6851
		heading 270
		edgeN 0
		edgeS 0
	)
)

(instance faceE of CameraAngle
	(properties
		picture 6853
		heading 90
		edgeN 0
		edgeS 0
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6852
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 6810 init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
	)
)

(instance defaultExit of ExitFeature
	(properties
		nsLeft 101
		nsTop 61
		nsRight 523
		nsBottom 245
	)
)

(instance eastMural of View
	(properties
		x 187
		y 47
		view 6809
		cel 1
	)
)

(instance southMural1 of View
	(properties
		x 456
		y 130
		view 6809
	)
)

(instance southMural2 of View
	(properties
		x 456
		y 130
		view 6809
	)
)

