;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7617)
(include sci.sh)
(use Location)
(use Feature)

(public
	octoCircle6CU 0
)

(instance octoCircle6CU of CloseupLocation
	(properties
		heading 315
	)

	(method (init)
		(super init: 7627)
		(self edgeW: 0 edgeE: 0)
		(QAVIAN_315 init:)
	)
)

(instance QAVIAN_315 of Feature
	(properties
		noun 50
		nsLeft 66
		nsTop 50
		nsRight 516
		nsBottom 270
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

