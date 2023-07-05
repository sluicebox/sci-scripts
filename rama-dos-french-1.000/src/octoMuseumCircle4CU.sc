;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7609)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use Feature)

(public
	octoMuseumCircle4CU 0
)

(instance octoMuseumCircle4CU of CloseupLocation
	(properties
		heading 180
		picture 7618
	)

	(method (init)
		(super init: 7618)
		(self edgeW: 0 edgeE: 0)
		(closeUpPic init:)
	)

	(method (pitch)
		(self newRoom: 7600) ; octoMuseum
	)
)

(instance closeUpPic of Feature
	(properties
		noun 46
		nsBottom 205
		nsLeft 236
		nsRight 355
		nsTop 83
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 144)
		(if (IsFlag 155)
			(= case 16)
		else
			(= case 15)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 7615) ; octoCircle4CU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

