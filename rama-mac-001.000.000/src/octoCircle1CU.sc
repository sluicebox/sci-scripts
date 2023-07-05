;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7612)
(include sci.sh)
(use Location)
(use Feature)

(public
	octoCircle1CU 0
)

(instance octoCircle1CU of CloseupLocation
	(properties
		heading 90
	)

	(method (init)
		(super init: 7622)
		(self edgeW: 0 edgeE: 0)
		(QTAKAGISHI_90 init:)
	)
)

(instance QTAKAGISHI_90 of Feature
	(properties
		noun 48
		nsLeft 74
		nsTop 96
		nsRight 546
		nsBottom 254
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

