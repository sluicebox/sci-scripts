;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4116)
(include sci.sh)
(use Main)
(use Location)
(use Feature)
(use Motion)
(use Actor)

(public
	bk2MusNECU2 0
)

(instance bk2MusNECU2 of CloseupLocation
	(properties
		heading 45
	)

	(method (init)
		(super init: 4161)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(slideShow cycleSpeed: 128 init: global117 setCycle: Fwd)
		(DRAWING_45 init:)
	)
)

(instance slideShow of Prop
	(properties
		x 218
		y 60
		view 4158
	)
)

(instance DRAWING_45 of Feature
	(properties
		noun 32
		nsBottom 230
		nsLeft 212
		nsRight 390
		nsTop 54
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

