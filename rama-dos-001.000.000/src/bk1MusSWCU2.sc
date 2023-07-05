;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4025)
(include sci.sh)
(use Main)
(use Location)
(use Feature)

(public
	bk1MusSWCU2 0
)

(instance bk1MusSWCU2 of CloseupLocation
	(properties
		heading 225
	)

	(method (init)
		(super init: 4047)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(drawing_225 init:)
	)
)

(instance drawing_225 of Feature
	(properties
		noun 13
		nsBottom 231
		nsLeft 210
		nsRight 396
		nsTop 50
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

