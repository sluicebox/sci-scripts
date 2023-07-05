;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1049)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Gonzales 0
)

(instance Gonzales of Eco2Talker
	(properties
		x 5
		y 5
		view 1049
		loop 3
		priority 15
		signal 16
		talkWidth 150
		back 19
		textX 115
		textY 12
		dftBack 19
	)

	(method (init)
		(= font gUserFont)
		(super init: gonzalesBust gonzalesEyes gonzalesMouth &rest)
	)
)

(instance gonzalesBust of Prop
	(properties
		view 1049
		loop 1
		priority 15
		signal 16
	)
)

(instance gonzalesMouth of Prop
	(properties
		nsTop 38
		nsLeft 19
		view 1049
		priority 15
		signal 16
	)
)

(instance gonzalesEyes of Prop
	(properties
		nsTop 18
		nsLeft 26
		view 1049
		loop 2
		priority 15
		signal 16
	)
)

