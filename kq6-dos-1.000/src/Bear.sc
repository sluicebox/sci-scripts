;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1059)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	Bear 25
)

(instance Bear of Kq6Talker
	(properties
		x 5
		y 5
		view 2002
		loop 1
		talkWidth 213
		textX 76
		textY 8
	)

	(method (init)
		(super init: tBust tEyes tMouth &rest)
	)
)

(instance tBust of Prop
	(properties
		view 2002
		loop 1
	)
)

(instance tEyes of Prop
	(properties
		nsTop 19
		nsLeft 13
		view 2002
		loop 2
	)
)

(instance tMouth of Prop
	(properties
		nsTop 33
		nsLeft 15
		view 2002
	)
)

