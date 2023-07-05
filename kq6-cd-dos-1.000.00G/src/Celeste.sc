;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1006)
(include sci.sh)
(use Kq6Talker)
(use n913)
(use Actor)

(public
	Celeste 4
)

(instance Celeste of Kq6Talker
	(properties
		x 245
		y 5
		view 8941
		talkWidth 213
		textX -232
		textY 6
		raveName {CELESTE}
	)

	(method (init)
		(if (IsFlag 161)
			(= cel 1)
			(super init: 0 0 0 &rest)
		else
			(super init: tBust tEyes tMouth &rest)
		)
	)
)

(instance tBust of Prop
	(properties
		view 8941
	)
)

(instance tEyes of Prop
	(properties
		nsTop 31
		nsLeft 27
		view 8941
		loop 2
	)
)

(instance tMouth of Prop
	(properties
		nsTop 39
		nsLeft 32
		view 8941
		loop 1
	)
)

