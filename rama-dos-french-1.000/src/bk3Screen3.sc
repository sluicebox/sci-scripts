;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4211)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use Feature)

(public
	bk3Screen3 0
)

(instance bk3Screen3 of CloseupLocation
	(properties
		heading 90
	)

	(method (init)
		(super init: 4211)
		(= plane global116)
		(numericalDisp_90 init:)
		(self edgeW: 0 edgeE: 0)
		(if (proc1111_24 49)
			(proc1111_31 10)
			(SetFlag 49)
		)
	)
)

(instance numericalDisp_90 of Feature
	(properties
		noun 43
		nsBottom 254
		nsLeft 110
		nsRight 480
		nsTop 25
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

