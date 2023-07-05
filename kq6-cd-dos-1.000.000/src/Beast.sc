;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1057)
(include sci.sh)
(use Kq6Talker)
(use n913)
(use Actor)

(public
	Beast 56
)

(instance Beast of Kq6Talker
	(properties
		x 5
		y 5
		view 896
		talkWidth 213
		textX 78
		textY 8
		raveName {BEAST}
		winPosn 0
	)

	(method (init)
		(if (IsFlag 113)
			(= view 8961)
			(tBust view: 8961)
			(tMouth view: 8961 nsTop: 32 nsLeft: 30)
			(tEyes view: 8961 nsTop: 21 nsLeft: 30)
			(= raveName {PRINCE})
		)
		(super init: tBust tEyes tMouth &rest)
	)
)

(instance tBust of Prop
	(properties
		view 896
	)
)

(instance tMouth of Prop
	(properties
		nsTop 31
		nsLeft 34
		view 896
		loop 1
	)
)

(instance tEyes of Prop
	(properties
		nsTop 27
		nsLeft 32
		view 896
		loop 2
	)
)

