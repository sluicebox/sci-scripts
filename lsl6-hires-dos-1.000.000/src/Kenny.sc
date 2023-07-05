;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1808)
(include sci.sh)
(use LarryTalker)
(use Actor)

(public
	Kenny 15
)

(instance Kenny of LarryTalker
	(properties
		x 10
		y 10
		talkWidth 120
		showTitle 1
		back 68
		view 98
		cel 1
		textX 105
		textY 10
		winPosn 2
	)

	(method (init)
		(super init: tMouth tBust tEyes)
	)
)

(instance tBust of View
	(properties
		x 2
		view 1241
		loop 1
	)
)

(instance tEyes of Prop
	(properties
		x 10
		y 14
		view 1241
		loop 3
	)
)

(instance tMouth of Prop
	(properties
		x 10
		y 18
		view 1241
	)
)

