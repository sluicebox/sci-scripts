;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1017)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	PussyWillows 42
)

(instance PussyWillows of Kq6Talker
	(properties
		x 255
		y 5
		view 470
		loop 1
		talkWidth 213
		textX -239
		textY 8
	)

	(method (init)
		(super init: 0 0 0 &rest)
	)
)

(instance tBust of Prop ; UNUSED
	(properties
		view 2004
		loop 1
	)
)

(instance tEyes of Prop ; UNUSED
	(properties
		nsTop 21
		nsLeft 25
		view 2004
		loop 2
	)
)

(instance tMouth of Prop ; UNUSED
	(properties
		nsTop 30
		nsLeft 25
		view 2004
	)
)

