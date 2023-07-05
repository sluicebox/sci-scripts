;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7611)
(include sci.sh)
(use Main)
(use Location)
(use Feature)

(public
	octoMuseumCircle6CU 0
)

(instance octoMuseumCircle6CU of CloseupLocation
	(properties
		heading 315
	)

	(method (init)
		(super init: 7620)
		(self edgeW: 0 edgeE: 0)
		(closeUpPic init:)
	)

	(method (pitch)
		(self newRoom: 7600) ; octoMuseum
	)
)

(instance closeUpPic of Feature
	(properties
		noun 50
		nsLeft 236
		nsTop 83
		nsRight 355
		nsBottom 205
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 7617) ; octoCircle6CU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

