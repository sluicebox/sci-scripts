;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1813)
(include sci.sh)
(use LarryTalker)
(use Actor)

(public
	Art 16
)

(instance Art of LarryTalker
	(properties
		showTitle 1
		back 70
		view 98
		cel 1
		winPosn 2
	)

	(method (init)
		(super init: tMouth tBust tEyes)
	)
)

(instance tBust of Prop
	(properties
		x 2
		view 1810
		loop 1
	)
)

(instance tMouth of Prop
	(properties
		x 9
		y 16
		view 1810
	)
)

(instance tEyes of Prop
	(properties
		x 23
		y 12
		view 98
		loop 2
	)
)

