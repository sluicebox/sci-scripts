;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1002)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	Azure 20
)

(instance Azure of Kq6Talker
	(properties
		x 109
		y 41
		view 370
		loop 4
		talkWidth 213
		textX -99
		textY 70
		winPosn 0
	)

	(method (init)
		(super init: 0 tEyes tMouth &rest)
	)
)

(instance tBust of Prop ; UNUSED
	(properties
		view 370
		loop 4
		signal 24576
	)
)

(instance tMouth of Prop
	(properties
		view 370
		loop 4
		signal 24576
	)
)

(instance tEyes of Prop
	(properties
		nsTop -5
		nsLeft -1
		view 370
		loop 6
		signal 24576
	)
)

