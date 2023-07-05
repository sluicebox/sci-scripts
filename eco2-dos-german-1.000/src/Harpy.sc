;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1749)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Harpy 0
)

(instance Harpy of Eco2Talker
	(properties
		x 5
		y 5
		view 1749
		loop 3
		talkWidth 150
		back 26
		textX 115
		textY 12
		dftBack 26
	)

	(method (init)
		(= font gUserFont)
		(super init: harpyBust harpyEyes harpyMouth &rest)
	)
)

(instance harpyMouth of Prop
	(properties
		nsTop 41
		nsLeft 14
		view 1749
	)
)

(instance harpyBust of Prop
	(properties
		view 1749
		loop 1
	)
)

(instance harpyEyes of Prop
	(properties
		nsTop 35
		nsLeft 15
		view 1749
		loop 2
	)
)

