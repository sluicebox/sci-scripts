;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4011)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use Feature)

(public
	bk1Screen3 0
)

(instance bk1Screen3 of CloseupLocation
	(properties
		heading 90
	)

	(method (init)
		(super init: 4011)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(countBrd_90 init:)
		(if (proc1111_24 46)
			(proc1111_31 4)
			(SetFlag 46)
		)
	)
)

(instance countBrd_90 of Feature
	(properties
		noun 6
		nsBottom 249
		nsRight 576
		nsTop 25
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

