;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1883)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Intro_bat_2 0
)

(instance Intro_bat_2 of Eco2Talker
	(properties
		name {Intro bat 2}
		x 19
		y 24
		view 96
		talkWidth 120
		back 56
		textX 166
		textY 12
		dftBack 56
		textSpacer 20
	)

	(method (init)
		(= font gUserFont)
		(super init: theBust theEyes theMouth &rest)
	)
)

(instance theMouth of Prop
	(properties
		nsTop 39
		nsLeft 95
		view 96
		loop 2
	)
)

(instance theBust of Prop
	(properties
		view 96
	)
)

(instance theEyes of Prop
	(properties
		nsTop 32
		nsLeft 99
		view 96
		loop 1
	)
)

