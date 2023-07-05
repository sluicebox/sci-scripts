;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7614)
(include sci.sh)
(use Location)
(use n1111)
(use Feature)

(public
	octoCircle3CU 0
)

(instance octoCircle3CU of CloseupLocation
	(properties
		picture 7624
		heading 180
	)

	(method (init)
		(super init: 7624)
		(self edgeW: 0 edgeE: 0)
		(QRICHARD_180 init:)
		(if (proc1111_24 217)
			(proc1111_31 32)
			(SetFlag 217)
		)
	)
)

(instance QRICHARD_180 of Feature
	(properties
		noun 51
		nsLeft 52
		nsTop 49
		nsRight 466
		nsBottom 270
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

