;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1592)
(include sci.sh)
(use LarryTalker)
(use Actor)

(public
	Carlos_the_Concierge 9
)

(instance Carlos_the_Concierge of LarryTalker
	(properties
		name {Carlos the Concierge}
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
		view 1592
		loop 1
	)
)

(instance tEyes of Prop
	(properties
		x 11
		y 15
		view 1592
		loop 2
	)
)

(instance tMouth of Prop
	(properties
		x 7
		y 20
		view 1592
	)
)

