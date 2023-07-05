;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1018)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	Genie 1
)

(instance Genie of Kq6Talker
	(properties
		x 80
		y 111
		view 890
		cel 1
		talkWidth 213
		textX -10
		textY -100
	)

	(method (init)
		(super init: 0 0 tMouth &rest)
	)
)

(instance tMouth of Prop
	(properties
		view 425
	)
)

