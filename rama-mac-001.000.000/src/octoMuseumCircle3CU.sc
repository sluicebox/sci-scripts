;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7608)
(include sci.sh)
(use Main)
(use Location)
(use Feature)

(public
	octoMuseumCircle3CU 0
)

(instance octoMuseumCircle3CU of CloseupLocation
	(properties
		picture 7617
		heading 180
	)

	(method (init)
		(super init: 7617)
		(self edgeW: 0 edgeE: 0)
		(closeUpPic init:)
	)

	(method (pitch)
		(self newRoom: 7600) ; octoMuseum
	)
)

(instance closeUpPic of Feature
	(properties
		noun 51
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
				(gCurRoom newRoom: 7614) ; octoCircle3CU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

