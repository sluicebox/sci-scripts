;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1832)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Man 6
)

(instance Man of Talker
	(properties
		x 5
		y 5
		view 1832
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(super init: manBust manEyes manMouth &rest)
	)
)

(instance manBust of Prop
	(properties
		view 1832
		loop 1
	)
)

(instance manEyes of Prop
	(properties
		nsTop 33
		nsLeft 54
		view 1832
		loop 2
	)
)

(instance manMouth of Prop
	(properties
		nsTop 56
		nsLeft 7
		view 1832
	)
)

