;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1807)
(include sci.sh)
(use LarryTalker)
(use Actor)

(public
	Gary_a 18
	Gary_b 27
)

(instance Gary_a of LarryTalker
	(properties
		name {Gary}
		showTitle 1
		back 63
		view 98
		cel 1
		winPosn 2
	)

	(method (init)
		(super init: tMouth tBust tEyes)
	)
)

(instance Gary_b of LarryTalker
	(properties
		name {Gary}
		showTitle 1
		back 19
		view 98
		winPosn 2
	)

	(method (init)
		(super init: 0 tBust)
	)
)

(instance tBust of View
	(properties
		x 2
		view 1311
		loop 1
	)
)

(instance tMouth of Prop
	(properties
		x 9
		y 20
		view 1311
	)
)

(instance tEyes of Prop
	(properties
		x 12
		y 16
		view 1311
		loop 2
	)
)

