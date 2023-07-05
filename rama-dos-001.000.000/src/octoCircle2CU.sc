;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7613)
(include sci.sh)
(use Location)
(use Feature)

(public
	octoCircle2CU 0
)

(instance octoCircle2CU of CloseupLocation
	(properties
		heading 90
	)

	(method (init)
		(super init: 7623)
		(self edgeW: 0 edgeE: 0)
		(QOCTO_90 init:)
	)
)

(instance QOCTO_90 of Feature
	(properties
		noun 49
		nsBottom 271
		nsLeft 63
		nsRight 530
		nsTop 42
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

