;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1016)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	Dogwood 69
)

(instance Dogwood of Kq6Talker
	(properties
		x 11
		y 16
		view 470
		loop 2
		talkWidth 200
		textX 76
		textY 8
	)

	(method (init)
		(super init: tBust 0 tMouth &rest)
	)
)

(instance tBust of Prop
	(properties
		view 470
		loop 2
	)
)

(instance tEyes of Prop ; UNUSED
	(properties
		view 470
		loop 2
	)
)

(instance tMouth of Prop
	(properties
		view 470
		loop 2
	)
)

