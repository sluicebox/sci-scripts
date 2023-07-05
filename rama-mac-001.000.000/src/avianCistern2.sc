;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6112)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Sound)
(use Actor)

(public
	avianCistern2 0
)

(instance avianCistern2 of Location
	(properties)

	(method (init)
		(super init:)
		(Load rsAUDIO 6112)
		(self addPicObj: faceS faceNE faceS)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 6307
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(doorExit init:)
		(gCurRoom exitN: doorExit)
		(super init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 6305
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(cisternSwitch init: global117)
	)
)

(instance cisternSwitch of View
	(properties
		noun 9
		x 269
		y 60
		view 6300
	)

	(method (init)
		(if (IsFlag 134)
			(= cel 1)
		)
		(super init: &rest)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(switchSound play:)
				(switch cel
					(0
						(SetFlag 134)
						(= cel 1)
						((ScriptID 202 0) setScript: (ScriptID 103 0)) ; AvianRegion, drippingAvianCisternScr
					)
					(1
						(= cel 0)
						(ClearFlag 134)
						((ScriptID 202 0) setScript: 0) ; AvianRegion
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorExit of ExitFeature
	(properties
		nsLeft 188
		nsTop 7
		nsRight 431
		nsBottom 289
		nextRoom 6111
	)
)

(instance switchSound of Sound
	(properties
		flags 5
		number 6112
	)
)

