;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7113)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Feature)

(public
	octoEenieAtriumCU 0
)

(instance octoEenieAtriumCU of CloseupLocation
	(properties)

	(method (init)
		(= plane global116)
		(= picture 7107)
		(= heading 135)
		(self edgeW: 0 edgeE: 0)
		(super init: 7107)
		(eenieLock init:)
	)
)

(instance exitToAtrium of ExitFeature ; UNUSED
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 7002
	)
)

(instance eenieLock of Feature
	(properties
		noun 27
		nsBottom 205
		nsLeft 206
		nsRight 386
		nsTop 80
		case 1
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 104 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(104
				(proc70_1)
				(SetFlag 180)
				(gCurRoom newRoom: 7100) ; octoEenieAtrium
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

