;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1065)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	Graham 94
)

(instance Graham of Kq6Talker
	(properties
		x 5
		y 5
		view 8981
		talkWidth 213
		textX 78
		textY 8
		raveName {GRAHAM}
	)

	(method (init)
		(super init: tBust tEyes tMouth &rest)
	)
)

(instance tBust of Prop
	(properties
		view 8981
	)
)

(instance tMouth of Prop
	(properties
		nsTop 37
		nsLeft 26
		view 8981
		loop 1
	)
)

(instance tEyes of Prop
	(properties
		nsTop 26
		nsLeft 26
		view 8981
		loop 2
	)
)

