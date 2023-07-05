;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4109)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use Feature)

(public
	bk2Screen1 0
)

(instance bk2Screen1 of CloseupLocation
	(properties
		heading 270
	)

	(method (init)
		(super init: 4109)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(ARITHDISP_270 init:)
		(if (proc1111_24 47)
			(proc1111_31 9)
			(SetFlag 47)
		)
	)
)

(instance ARITHDISP_270 of Feature
	(properties
		noun 23
		nsBottom 271
		nsLeft 82
		nsRight 502
		nsTop 10
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

