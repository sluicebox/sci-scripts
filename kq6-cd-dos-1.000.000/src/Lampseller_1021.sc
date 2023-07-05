;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1021)
(include sci.sh)
(use Kq6Talker)
(use n913)
(use Actor)

(public
	Lampseller 16
)

(instance Lampseller of Kq6Talker
	(properties
		x 5
		y 5
		view 8973
		talkWidth 213
		textX 76
		textY 8
		raveName {LAMPSELL}
		winPosn 0
	)

	(method (init)
		(if (IsFlag 59)
			(tBust cel: 1)
			(= cel 1)
			(super init: tBust 0 0 &rest)
			(= textY (= textX 0))
			(= y (= x 10))
		else
			(tBust cel: 0)
			(= cel 1)
			(= textX 76)
			(= textY 8)
			(= y (= x 5))
			(super init: tBust tEyes tMouth &rest)
		)
	)
)

(instance tBust of Prop
	(properties
		view 8973
	)
)

(instance tEyes of Prop
	(properties
		nsTop 32
		nsLeft 31
		view 8973
		loop 2
	)
)

(instance tMouth of Prop
	(properties
		nsTop 44
		nsLeft 31
		view 8973
		loop 1
	)
)

