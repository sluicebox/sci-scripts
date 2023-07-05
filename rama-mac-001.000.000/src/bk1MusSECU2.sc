;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4020)
(include sci.sh)
(use Main)
(use Location)
(use Feature)

(public
	bk1MusSECU2 0
)

(instance bk1MusSECU2 of CloseupLocation
	(properties
		heading 135
	)

	(method (init)
		(super init: 4043)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(CHAIR_135 init:)
	)
)

(instance CHAIR_135 of Feature
	(properties
		noun 16
		nsLeft 240
		nsTop 135
		nsRight 341
		nsBottom 241
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

