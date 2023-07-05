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
		view 1830
		talkWidth 120
		showTitle 1
		back 68
		textX 105
		textY 10
		winPosn 2
	)

	(method (init)
		(= winPosn 2)
		(super init: tBust tEyes tMouth)
	)
)

(instance tBust of View
	(properties
		nsTop 4
		nsLeft 4
		view 1241
		loop 1
	)
)

(instance tMouth of Prop
	(properties
		nsTop 48
		nsLeft 19
		view 1241
	)
)

(instance tEyes of Prop
	(properties
		nsTop 38
		nsLeft 19
		view 1241
		loop 3
	)
)

