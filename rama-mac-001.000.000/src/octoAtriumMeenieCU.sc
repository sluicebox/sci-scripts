;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7005)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Feature)

(public
	octoAtriumMeenieCU 0
)

(instance octoAtriumMeenieCU of CloseupLocation
	(properties
		heading 45
	)

	(method (init)
		(super init: 7025)
		(ClearFlag 181)
		(meenieLock init:)
		(meenieCU init:)
		(self edgeW: 0 edgeE: 0)
	)
)

(instance exitToMeenie of ExitFeature ; UNUSED
	(properties
		nsLeft 109
		nsTop 37
		nsRight 466
		nsBottom 261
		nextRoom 7200
	)
)

(instance meenieLock of Feature
	(properties
		nsLeft 206
		nsTop 80
		nsRight 386
		nsBottom 205
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 91)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(91
				(proc70_1 99 1)
				(SetFlag 181)
				(gCurRoom newRoom: 7004) ; octoAtriumMeenie
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance meenieCU of Feature
	(properties
		noun 53
		nsLeft 12
		nsTop 5
		nsRight 571
		nsBottom 277
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

