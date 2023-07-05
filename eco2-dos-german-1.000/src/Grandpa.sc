;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1139)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Grandpa 0
)

(instance Grandpa of Eco2Talker
	(properties
		x 5
		y 5
		view 1139
		loop 3
		talkWidth 150
		back 90
		textX 115
		textY 12
		dftBack 90
	)

	(method (init)
		(= font gUserFont)
		(super init: grandpaBust grandpaEyes grandpaMouth &rest)
	)
)

(instance grandpaMouth of Prop
	(properties
		nsTop 43
		nsLeft 5
		view 1139
	)
)

(instance grandpaBust of Prop
	(properties
		view 1139
		loop 1
	)
)

(instance grandpaEyes of Prop
	(properties
		nsTop 16
		nsLeft 24
		view 1139
		loop 2
	)
)

