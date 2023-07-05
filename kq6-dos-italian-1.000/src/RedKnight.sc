;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1055)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	RedKnight 75
	WhiteKnight 76
)

(instance WhiteKnight of Kq6Talker
	(properties
		x 126
		y 83
		view 492
		loop 4
		talkWidth 213
		textX -112
		textY -73
	)

	(method (init)
		(super init: 0 0 tWhtMouth &rest)
	)
)

(instance RedKnight of Kq6Talker
	(properties
		x 174
		y 83
		view 493
		loop 4
		talkWidth 213
		textX -87
		textY -73
	)

	(method (init)
		(super init: 0 0 tRedMouth &rest)
	)
)

(instance tWhtBust of Prop ; UNUSED
	(properties
		view 492
		loop 4
	)
)

(instance tRedBust of Prop ; UNUSED
	(properties
		view 493
		loop 4
	)
)

(instance tWhtMouth of Prop
	(properties
		view 492
		loop 4
	)
)

(instance tRedMouth of Prop
	(properties
		view 493
		loop 4
	)
)

