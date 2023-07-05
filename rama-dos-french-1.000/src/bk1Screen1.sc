;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4009)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use Feature)

(public
	bk1Screen1 0
)

(instance bk1Screen1 of CloseupLocation
	(properties
		heading 90
	)

	(method (init)
		(super init: 4009)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(hArithDisp_90 init:)
		(if (proc1111_24 46)
			(proc1111_31 4)
			(SetFlag 46)
		)
	)
)

(instance hArithDisp_90 of Feature
	(properties
		noun 4
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

