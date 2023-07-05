;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1061)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	Gate 58
)

(instance Gate of Kq6Talker
	(properties
		x 202
		y 59
		view 2002
		talkWidth 170
		textX -190
		textY -40
	)

	(method (init)
		(super init: 0 0 tMouth &rest)
	)
)

(instance tMouth of Prop
	(properties
		view 676
	)
)

