;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1894)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Sam 3
)

(instance Sam of Talker
	(properties
		x 5
		y 5
		view 1894
		loop 3
		talkWidth 150
		back 15
		textX 105
		textY 12
	)

	(method (init)
		(= font gUserFont)
		(super init: samBust samEyes samMouth &rest)
	)
)

(instance samBust of Prop
	(properties
		view 1894
		loop 1
	)
)

(instance samEyes of Prop
	(properties
		nsTop 35
		nsLeft 31
		view 1894
		loop 2
	)
)

(instance samMouth of Prop
	(properties
		nsTop 54
		nsLeft 17
		view 1894
	)
)

