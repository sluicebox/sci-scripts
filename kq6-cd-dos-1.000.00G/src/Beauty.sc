;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1003)
(include sci.sh)
(use Kq6Talker)
(use n913)
(use Actor)

(public
	Beauty 17
)

(instance Beauty of Kq6Talker
	(properties
		x 248
		y 5
		view 895
		talkWidth 213
		textX -239
		textY 8
		raveName {BEAUTPEA}
	)

	(method (init)
		(cond
			((IsFlag 59)
				(tBust cel: 1)
				(= cel 1)
				(super init: tBust 0 0 &rest)
			)
			((IsFlag 43)
				(= view 8951)
				(tBust view: 8951)
				(tMouth view: 8951 nsTop: 33 nsLeft: 28)
				(tEyes view: 8951 nsTop: 26 nsLeft: 28)
				(= raveName {BEAUTESS})
				(super init: tBust tEyes tMouth &rest)
			)
			(else
				(super init: tBust tEyes tMouth &rest)
			)
		)
	)
)

(instance tBust of Prop
	(properties
		view 895
	)
)

(instance tEyes of Prop
	(properties
		nsTop 25
		nsLeft 27
		view 895
		loop 2
	)
)

(instance tMouth of Prop
	(properties
		nsTop 32
		nsLeft 27
		view 895
		loop 1
	)
)

