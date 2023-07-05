;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1066)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	Valanice 12
)

(instance Valanice of Kq6Talker
	(properties
		x 5
		y 5
		view 8982
		talkWidth 213
		textX 78
		textY 8
		raveName {VALANICE}
	)

	(method (init)
		(super init: tBust tEyes tMouth &rest)
	)
)

(instance tBust of Prop
	(properties
		view 8982
	)
)

(instance tMouth of Prop
	(properties
		nsTop 36
		nsLeft 27
		view 8982
		loop 1
	)
)

(instance tEyes of Prop
	(properties
		nsTop 25
		nsLeft 27
		view 8982
		loop 2
	)
)

