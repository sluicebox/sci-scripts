;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1048)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	Stick 47
)

(instance Stick of Kq6Talker
	(properties
		x 274
		y 83
		view 475
		loop 12
		talkWidth 213
		textX -193
		textY -70
	)

	(method (init)
		(super init: 0 0 tMouth &rest)
	)
)

(instance tMouth of Prop
	(properties
		view 475
		loop 12
	)
)

