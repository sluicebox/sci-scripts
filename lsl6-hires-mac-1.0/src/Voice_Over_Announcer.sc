;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1823)
(include sci.sh)
(use LarryTalker)
(use Actor)

(public
	Voice_Over_Announcer 33
)

(instance Voice_Over_Announcer of LarryTalker
	(properties
		name {Voice-Over Announcer}
		showTitle 1
		view 98
		winPosn 2
	)

	(method (init)
		(super init: tMouth tBust tEyes)
	)
)

(instance tBust of View
	(properties
		view 98
	)
)

(instance tEyes of Prop
	(properties
		view 98
	)
)

(instance tMouth of Prop
	(properties
		view 98
	)
)

