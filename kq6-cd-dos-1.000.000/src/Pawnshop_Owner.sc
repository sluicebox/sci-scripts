;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1036)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	Pawnshop_Owner 35
)

(instance Pawnshop_Owner of Kq6Talker
	(properties
		name {Pawnshop Owner}
		x 5
		y 5
		view 8971
		talkWidth 213
		textX 76
		textY 8
		raveName {PAWNSHOP}
	)

	(method (init)
		(super init: tBust tEyes tMouth &rest)
	)
)

(instance tBust of Prop
	(properties
		view 8971
	)
)

(instance tEyes of Prop
	(properties
		nsTop 25
		nsLeft 25
		view 8971
		loop 2
	)
)

(instance tMouth of Prop
	(properties
		nsTop 36
		nsLeft 29
		view 8971
		loop 1
	)
)

