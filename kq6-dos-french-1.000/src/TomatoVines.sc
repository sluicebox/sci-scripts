;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1052)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	TomatoVines 51
)

(instance TomatoVines of Kq6Talker
	(properties
		x 119
		y 118
		view 4802
		talkWidth 183
		textX -108
		textY -107
	)

	(method (init)
		(super init: 0 0 tMouth &rest)
	)
)

(instance tMouth of Prop
	(properties
		view 4802
	)
)

