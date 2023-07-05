;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1034)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	Bookshop_Owner 33
)

(instance Bookshop_Owner of Kq6Talker
	(properties
		name {Bookshop Owner}
		x 5
		y 5
		view 897
		talkWidth 213
		textX 76
		textY 8
		raveName {BOOKSH}
	)

	(method (init)
		(super init: tBust tEyes tMouth &rest)
	)
)

(instance tBust of Prop
	(properties
		view 897
	)
)

(instance tEyes of Prop
	(properties
		nsTop 31
		nsLeft 28
		view 897
		loop 2
	)
)

(instance tMouth of Prop
	(properties
		nsTop 42
		nsLeft 31
		view 897
		loop 1
	)
)

