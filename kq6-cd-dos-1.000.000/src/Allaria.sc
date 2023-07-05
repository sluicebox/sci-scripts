;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1063)
(include sci.sh)
(use Kq6Talker)
(use n913)
(use Actor)

(public
	Allaria 62
)

(instance Allaria of Kq6Talker
	(properties
		x 5
		y 5
		view 8992
		talkWidth 213
		textX 78
		textY 8
		raveName {ALLARIA}
		winPosn 0
	)

	(method (init)
		(if (IsFlag 91)
			(self view: 8993)
			(tBust view: 8993)
			(tEyes view: 8993)
			(= raveName {ALLARIAD})
			(tMouth view: 8993)
		else
			(self view: 8992)
			(tBust view: 8992)
			(tEyes view: 8992)
			(tMouth view: 8992)
			(= raveName {ALLARIA})
		)
		(super init: tBust tEyes tMouth &rest)
	)
)

(instance tBust of Prop
	(properties)
)

(instance tEyes of Prop
	(properties
		nsTop 29
		nsLeft 24
		loop 2
	)
)

(instance tMouth of Prop
	(properties
		nsTop 38
		nsLeft 27
		loop 1
	)
)

