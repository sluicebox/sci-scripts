;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7602)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use n1111)
(use Feature)
(use Actor)

(public
	octoMusDoorCU 0
)

(instance octoMusDoorCU of CloseupLocation
	(properties
		heading 225
	)

	(method (init)
		(super init: 7611)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(gateLock init:)
	)
)

(instance gateLock of Feature
	(properties
		noun 52
		case 2
		nsLeft 206
		nsTop 80
		nsRight 386
		nsBottom 205
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(if (IsFlag 195)
			(self setHotspot: 96 144)
		else
			(greyLock init: global117)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(96
				(proc70_1)
				(SetFlag 185)
				(gCurRoom newRoom: 7601) ; octoMusTeaDoor
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance greyLock of View
	(properties
		noun 52
		case 1
		x 199
		y 77
		view 7603
	)

	(method (init)
		(if (not (IsFlag 195))
			(super init: global117 &rest)
			(self setHotspot: 144)
		)
	)
)

