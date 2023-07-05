;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7901)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Feature)
(use Actor)

(public
	octoSubAbacus 0
)

(instance octoSubAbacus of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(self addPicObj: faceAbacus facePit faceAbacus)
		(switch gPrevRoomNum
			(7900 ; octoSubPad
				(self setScript: (ScriptID 7903 1)) ; sPadUp
			)
		)
	)
)

(instance facePit of CameraAngle
	(properties
		heading 180
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (== global259 global260)
			(self picture: 7912)
		else
			(self picture: 7913)
		)
		(exitToPit init:)
		(gCurRoom exitN: exitToPit)
		(super init:)
	)
)

(instance faceAbacus of CameraAngle
	(properties
		picture 7911
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToAbacus init:)
		(spikes init: global117)
		(super init:)
	)
)

(instance exitToPit of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 7900
	)
)

(instance exitToAbacus of Feature
	(properties
		nsBottom 289
		nsLeft 112
		nsRight 508
		nsTop 57
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 7016) ; octoAbacusCU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance spikes of View
	(properties
		x 253
		y 130
		view 7915
	)
)

