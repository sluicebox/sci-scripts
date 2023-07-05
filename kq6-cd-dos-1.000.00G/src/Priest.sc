;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1033)
(include sci.sh)
(use Kq6Talker)
(use Actor)

(public
	Priest 26
	Priest 59
	Priest 60
)

(instance Priest of Kq6Talker
	(properties
		x 245
		y 5
		view 898
		talkWidth 213
		textX -239
		textY 8
		raveName {HEADDRU}
		winPosn 0
	)

	(method (init)
		(super init: tBust tEyes tMouth &rest)
	)
)

(instance tBust of Prop
	(properties
		view 898
	)
)

(instance tEyes of Prop
	(properties
		nsTop 26
		nsLeft 25
		view 898
		loop 2
	)
)

(instance tMouth of Prop
	(properties
		nsTop 29
		nsLeft 26
		view 898
		loop 1
	)
)

