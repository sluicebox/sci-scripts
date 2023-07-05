;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7606)
(include sci.sh)
(use Main)
(use Location)
(use Feature)

(public
	octoMuseumCircle1CU 0
)

(instance octoMuseumCircle1CU of CloseupLocation
	(properties
		heading 90
	)

	(method (init)
		(super init: 7615)
		(self edgeW: 0 edgeE: 0)
		(closeUpPic init:)
	)

	(method (pitch)
		(self newRoom: 7600) ; octoMuseum
	)
)

(instance closeUpPic of Feature
	(properties
		noun 48
		nsBottom 205
		nsLeft 236
		nsRight 355
		nsTop 83
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 7612) ; octoCircle1CU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

