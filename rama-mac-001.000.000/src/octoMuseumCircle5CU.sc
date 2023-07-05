;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7610)
(include sci.sh)
(use Main)
(use Location)
(use Feature)

(public
	octoMuseumCircle5CU 0
)

(instance octoMuseumCircle5CU of CloseupLocation
	(properties
		heading 315
	)

	(method (init)
		(super init: 7619)
		(self edgeW: 0 edgeE: 0)
		(closeUpPic init:)
	)

	(method (pitch)
		(self newRoom: 7600) ; octoMuseum
	)
)

(instance closeUpPic of Feature
	(properties
		noun 47
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
				(gCurRoom newRoom: 7616) ; octoCircle5CU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

