;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7616)
(include sci.sh)
(use Location)
(use Feature)

(public
	octoCircle5CU 0
)

(instance octoCircle5CU of CloseupLocation
	(properties
		heading 315
	)

	(method (init)
		(super init: 7626)
		(self edgeW: 0 edgeE: 0)
		(QMYRMICATS_315 init:)
	)
)

(instance QMYRMICATS_315 of Feature
	(properties
		noun 47
		nsLeft 56
		nsTop 57
		nsRight 525
		nsBottom 267
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

