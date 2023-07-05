;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1044)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	BookWorm 43
)

(instance BookWorm of Kq6Talker
	(properties
		x 5
		y 5
		view 8936
		talkWidth 213
		textX 76
		textY 8
		raveName {BOOKWORM}
	)

	(method (init)
		(super init: tBust tEyes tMouth &rest)
	)
)

(instance tBust of Prop
	(properties
		view 8936
	)
)

(instance tEyes of Prop
	(properties
		nsTop 26
		nsLeft 27
		view 8936
		loop 2
	)
)

(instance tMouth of Prop
	(properties
		nsTop 41
		nsLeft 22
		view 8936
		loop 1
	)
)

