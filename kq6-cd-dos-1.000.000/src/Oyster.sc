;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1038)
(include sci.sh)
(use Kq6Talker)
(use n913)
(use Actor)

(public
	Oyster 37
)

(instance Oyster of Kq6Talker
	(properties
		talkWidth 213
	)

	(method (init)
		(if (IsFlag 59)
			(self view: 890 loop: 0 cel: 1 x: 255 y: 5 textX: -239 textY: 8)
			(super init: 0 0 0 &rest)
		else
			(self view: 4531 loop: 3 x: 58 y: 127 textX: -40 textY: -105)
			(super init: 0 0 tMouth &rest)
		)
	)
)

(instance tMouth of Prop
	(properties
		view 4531
		loop 3
	)
)

