;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1046)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	Dipthong 45
)

(instance Dipthong of Kq6Talker
	(properties
		x 244
		y 44
		view 890
		cel 1
		talkWidth 150
		textX -200
		textY -20
	)

	(method (init)
		(super init: 0 0 tMouth &rest)
	)
)

(instance tMouth of Prop
	(properties
		view 463
		loop 6
	)
)

