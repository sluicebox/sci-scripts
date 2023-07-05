;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7507)
(include sci.sh)
(use Main)
(use Location)
(use Feature)

(public
	octoCisLockCU 0
)

(instance octoCisLockCU of CloseupLocation
	(properties
		heading 315
	)

	(method (init)
		(super init: 7509)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
	)
)

(instance GATEDARK_315 of Feature ; UNUSED
	(properties
		noun 36
		case 6
		nsLeft 75
		nsTop 17
		nsRight 531
		nsBottom 262
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

