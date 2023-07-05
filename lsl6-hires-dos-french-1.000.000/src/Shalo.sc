;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1146)
(include sci.sh)
(use LarryTalker)
(use Actor)

(public
	Shalo 25
)

(instance Shalo of LarryTalker
	(properties
		showTitle 1
		back 50
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
		view 1146
		loop 1
	)
)

(instance tMouth of Prop
	(properties
		x 8
		y 18
		view 1146
	)
)

(instance tEyes of Prop
	(properties
		x 9
		y 13
		view 1146
		loop 2
	)
)

