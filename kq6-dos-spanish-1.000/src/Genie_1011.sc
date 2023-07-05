;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1011)
(include sci.sh)
(use Kq6Talker)
(use n913)
(use Actor)

(public
	Genie 27
)

(instance Genie of Kq6Talker
	(properties
		x 5
		y 5
		view 893
		talkWidth 213
		textX 76
		textY 8
	)

	(method (init)
		(if (IsFlag 59)
			(= cel 1)
			(super init: 0 0 0 &rest)
		else
			(super init: tBust tEyes tMouth &rest)
		)
	)
)

(instance tBust of Prop
	(properties
		view 893
	)
)

(instance tEyes of Prop
	(properties
		nsTop 36
		nsLeft 27
		view 893
		loop 2
	)
)

(instance tMouth of Prop
	(properties
		nsTop 43
		nsLeft 25
		view 893
		loop 1
	)
)

