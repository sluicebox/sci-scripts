;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1022)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	Minotaur 3
)

(instance Minotaur of Kq6Talker
	(properties
		x 5
		y 5
		view 890
		cel 1
		talkWidth 213
		textX 76
		textY 8
	)

	(method (init)
		(super init: 0 0 0 &rest)
	)
)

(instance tBust of Prop ; UNUSED
	(properties
		view 896
	)
)

(instance tEyes of Prop ; UNUSED
	(properties
		nsTop 25
		nsLeft 26
		view 896
		loop 1
	)
)

(instance tMouth of Prop ; UNUSED
	(properties
		nsTop 21
		nsLeft 24
		view 896
		loop 2
	)
)

