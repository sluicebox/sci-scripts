;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1806)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Chastity 44
)

(instance Chastity of Talker
	(properties
		x 5
		y 5
		view 1822
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(super init: chastityBust chastityEyes chastityMouth &rest)
	)
)

(instance chastityBust of Prop
	(properties
		view 1822
		loop 1
	)
)

(instance chastityEyes of Prop
	(properties
		nsTop 47
		nsLeft 39
		view 1822
		loop 2
	)
)

(instance chastityMouth of Prop
	(properties
		nsTop 56
		nsLeft 38
		view 1822
	)
)

