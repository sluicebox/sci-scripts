;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1049)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	Bump 48
)

(instance Bump of Kq6Talker
	(properties
		x 28
		y 153
		view 474
		loop 1
		talkWidth 213
		textX -10
		textY -144
	)

	(method (init)
		(super init: 0 0 tMouth &rest)
	)
)

(instance tEyes of Prop ; UNUSED
	(properties
		view 474
		loop 1
	)
)

(instance tMouth of Prop
	(properties
		view 474
		loop 1
	)
)

