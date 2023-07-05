;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1000)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	Aeriel 21
)

(instance Aeriel of Kq6Talker
	(properties
		x 202
		y 45
		view 370
		loop 5
		talkWidth 213
		textX -116
		textY 74
	)

	(method (init)
		(super init: 0 tEyes tMouth &rest)
	)
)

(instance tBust of Prop ; UNUSED
	(properties
		view 370
		loop 5
	)
)

(instance tMouth of Prop
	(properties
		view 370
		loop 5
	)
)

(instance tEyes of Prop
	(properties
		nsTop -3
		nsLeft -1
		view 370
		loop 7
	)
)

