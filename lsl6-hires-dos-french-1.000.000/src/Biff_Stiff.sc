;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1144)
(include sci.sh)
(use LarryTalker)
(use Actor)

(public
	Biff_Stiff 24
)

(instance Biff_Stiff of LarryTalker
	(properties
		name {Biff Stiff}
		showTitle 1
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
		view 1144
		loop 1
	)
)

(instance tEyes of Prop
	(properties
		x 12
		y 14
		view 1144
		loop 2
	)
)

(instance tMouth of Prop
	(properties
		x 10
		y 18
		view 1144
	)
)

