;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1815)
(include sci.sh)
(use LarryTalker)
(use Actor)

(public
	Mark 23
)

(instance Mark of LarryTalker
	(properties
		talkWidth 150
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

(instance tBust of View
	(properties
		x 2
		view 1619
		loop 1
	)
)

(instance tEyes of Prop
	(properties
		x 11
		y 15
		view 1619
		loop 2
	)
)

(instance tMouth of Prop
	(properties
		x 8
		y 18
		view 1619
	)
)

