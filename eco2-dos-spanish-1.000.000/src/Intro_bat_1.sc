;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1882)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Intro_bat_1 0
)

(instance Intro_bat_1 of Eco2Talker
	(properties
		name {Intro bat 1}
		x 19
		y 24
		view 96
		talkWidth 120
		back 5
		textX 166
		textY 12
		dftBack 5
		textSpacer 20
	)

	(method (init)
		(= font gUserFont)
		(super init: theBust theEyes theMouth &rest)
	)
)

(instance theMouth of Prop
	(properties
		nsTop 32
		nsLeft 45
		view 96
		loop 4
	)
)

(instance theBust of Prop
	(properties
		view 96
	)
)

(instance theEyes of Prop
	(properties
		nsTop 28
		nsLeft 48
		view 96
		loop 3
	)
)

