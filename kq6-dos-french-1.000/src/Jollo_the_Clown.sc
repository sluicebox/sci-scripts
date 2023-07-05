;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1020)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	Jollo_the_Clown 5
)

(instance Jollo_the_Clown of Kq6Talker
	(properties
		name {Jollo the Clown}
		x 5
		y 5
		view 894
		talkWidth 213
		textX 79
		textY 8
	)

	(method (init)
		(super init: tBust tEyes tMouth &rest)
	)
)

(instance tBust of Prop
	(properties
		view 894
	)
)

(instance tEyes of Prop
	(properties
		nsTop 30
		nsLeft 26
		view 894
		loop 2
	)
)

(instance tMouth of Prop
	(properties
		nsTop 36
		nsLeft 20
		view 894
		loop 1
	)
)

