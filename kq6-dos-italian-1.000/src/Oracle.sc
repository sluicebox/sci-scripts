;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1023)
(include sci.sh)
(use Kq6Talker)
(use n913)
(use Actor)

(public
	Oracle 19
)

(instance Oracle of Kq6Talker
	(properties
		x 153
		y 57
		view 382
		talkWidth 253
		textX -124
		textY 77
	)

	(method (init)
		(self
			textX: (proc913_5 -124 -124 -124 -143 -124)
			talkWidth: (proc913_5 253 253 253 290 253)
		)
		(super init: 0 tEyes tMouth &rest)
	)
)

(instance tMouth of Prop
	(properties
		view 382
	)
)

(instance tEyes of Prop
	(properties
		nsTop -10
		nsLeft -6
		view 382
		loop 1
	)
)

