;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4225)
(include sci.sh)
(use Main)
(use Location)
(use Feature)

(public
	bk3MusSWCU2 0
)

(instance bk3MusSWCU2 of CloseupLocation
	(properties
		heading 225
	)

	(method (init)
		(super init: 4243)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(PICTURE_225 init:)
	)
)

(instance PICTURE_225 of Feature
	(properties
		noun 48
		nsLeft 212
		nsTop 54
		nsRight 391
		nsBottom 227
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

