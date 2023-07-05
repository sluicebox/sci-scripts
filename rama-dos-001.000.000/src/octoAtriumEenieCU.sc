;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7003)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use n1111)
(use Feature)

(public
	octoAtriumEenieCU 0
)

(instance octoAtriumEenieCU of CloseupLocation
	(properties
		heading 315
	)

	(method (init)
		(super init: 7020)
		(eenieCU init:)
		(= plane global116)
		(eenieLock init:)
		(eenieCU init:)
		(self edgeW: 0 edgeE: 0)
	)
)

(instance eenieLock of Feature
	(properties
		nsBottom 205
		nsLeft 206
		nsRight 386
		nsTop 80
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 104)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(104
				(proc70_1 103 1)
				(SetFlag 180)
				(gCurRoom newRoom: 7002) ; octoAtriumEenie
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance eenieCU of Feature
	(properties
		noun 53
		nsBottom 277
		nsLeft 12
		nsRight 571
		nsTop 5
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

