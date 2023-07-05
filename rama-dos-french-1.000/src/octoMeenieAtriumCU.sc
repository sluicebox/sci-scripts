;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7212)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use n1111)
(use Feature)

(public
	octoMeenieAtriumCU 0
)

(instance octoMeenieAtriumCU of CloseupLocation
	(properties)

	(method (init)
		(super init: 7225)
		(= plane global116)
		(= picture 7225)
		(self edgeW: 0 edgeE: 0)
		(meenieLock init:)
		(lockedGate init:)
	)
)

(instance meenieLock of Feature
	(properties
		nsBottom 205
		nsLeft 206
		nsRight 386
		nsTop 80
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 91)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(91
				(proc70_1)
				(SetFlag 181)
				(gCurRoom newRoom: 7200) ; octoMeenieAtrium
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lockedGate of Feature
	(properties
		noun 27
		nsBottom 305
		nsLeft 106
		nsRight 386
		nsTop 80
		case 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

