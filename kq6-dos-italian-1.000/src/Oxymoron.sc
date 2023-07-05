;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1045)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	Oxymoron 44
)

(instance Oxymoron of Kq6Talker
	(properties
		x 290
		y 54
		view 890
		cel 1
		talkWidth 150
		textX -173
		textY -16
	)

	(method (init)
		(super init: 0 0 tMouth &rest)
	)
)

(instance tMouth of Prop
	(properties
		view 460
		loop 15
	)
)

