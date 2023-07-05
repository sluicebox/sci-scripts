;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1810)
(include sci.sh)
(use LarryTalker)
(use Actor)

(public
	Bartender 22
)

(instance Bartender of LarryTalker
	(properties
		showTitle 1
		back 46
		view 98
		cel 1
		winPosn 2
	)

	(method (init)
		(super init: tMouth tBust tEyes)
	)
)

(instance tBust of View
	(properties
		x 2
		view 1513
		loop 1
	)
)

(instance tEyes of Prop
	(properties
		x 13
		y 15
		view 1513
		loop 2
	)
)

(instance tMouth of Prop
	(properties
		x 11
		y 19
		view 1513
	)
)

