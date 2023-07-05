;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7603)
(include sci.sh)
(use Location)
(use n1111)
(use Feature)

(public
	octoMuseumManCU 0
)

(instance octoMuseumManCU of CloseupLocation
	(properties
		heading 270
	)

	(method (init)
		(super init: 7612)
		(self edgeW: 0 edgeE: 0)
		(TAKAGISHI_90 init:)
		(if (proc1111_24 219)
			(proc1111_31 25)
			(SetFlag 219)
		)
	)
)

(instance TAKAGISHI_90 of Feature
	(properties
		noun 44
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

