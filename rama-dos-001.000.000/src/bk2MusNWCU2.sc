;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4129)
(include sci.sh)
(use Main)
(use Location)
(use Feature)

(public
	bk2MusNWCU2 0
)

(instance bk2MusNWCU2 of CloseupLocation
	(properties
		heading 315
	)

	(method (init)
		(super init: 4145)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(CHAIR_315 init:)
	)
)

(instance CHAIR_315 of Feature
	(properties
		noun 35
		nsBottom 240
		nsLeft 230
		nsRight 352
		nsTop 181
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

