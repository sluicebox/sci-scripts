;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1230)
(include sci.sh)
(use LarryTalker)
(use Actor)

(public
	Billy_Dee 17
)

(instance Billy_Dee of LarryTalker
	(properties
		name {Billy Dee}
		showTitle 1
		back 46
		view 98
		cel 1
		textX -195
		textY 10
		winPosn 2
	)

	(method (init)
		(super init: tMouth tBust tEyes)
	)
)

(instance tBust of Prop
	(properties
		x 2
		view 1230
		loop 1
	)
)

(instance tMouth of Prop
	(properties
		x 10
		y 21
		view 1230
	)
)

(instance tEyes of Prop
	(properties
		x 11
		y 18
		view 1230
		loop 2
	)
)

