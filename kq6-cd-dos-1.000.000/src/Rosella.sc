;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1067)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	Rosella 95
)

(instance Rosella of Kq6Talker
	(properties
		x 5
		y 5
		view 8983
		talkWidth 213
		textX 78
		textY 8
		raveName {ROSELLA}
	)

	(method (init)
		(super init: tBust tEyes tMouth &rest)
	)
)

(instance tBust of Prop
	(properties
		view 8983
	)
)

(instance tMouth of Prop
	(properties
		nsTop 36
		nsLeft 27
		view 8983
		loop 1
	)
)

(instance tEyes of Prop
	(properties
		nsTop 26
		nsLeft 26
		view 8983
		loop 2
	)
)

