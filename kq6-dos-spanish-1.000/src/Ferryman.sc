;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1008)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	Ferryman 23
)

(instance Ferryman of Kq6Talker
	(properties
		x 5
		y 5
		view 8972
		talkWidth 213
		textX 76
		textY 8
		raveName {FERRYM}
		winPosn 0
	)

	(method (init)
		(super init: tBust tEyes tMouth &rest)
	)
)

(instance tBust of Prop
	(properties
		view 8972
	)
)

(instance tEyes of Prop
	(properties
		nsTop 27
		nsLeft 26
		view 8972
		loop 2
	)
)

(instance tMouth of Prop
	(properties
		nsTop 37
		nsLeft 29
		view 8972
		loop 1
	)
)

