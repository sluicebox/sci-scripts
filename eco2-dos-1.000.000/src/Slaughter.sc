;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1039)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Slaughter 0
)

(instance Slaughter of Eco2Talker
	(properties
		x 5
		y 5
		view 1039
		loop 3
		talkWidth 150
		back 5
		textX 115
		textY 12
		dftBack 5
	)

	(method (init)
		(= font gUserFont)
		(super init: slaughterBust slaughterEyes slaughterMouth &rest)
	)
)

(instance slaughterMouth of Prop
	(properties
		nsTop 38
		nsLeft 29
		view 1039
	)
)

(instance slaughterBust of Prop
	(properties
		view 1039
		loop 1
	)
)

(instance slaughterEyes of Prop
	(properties
		nsTop 28
		nsLeft 29
		view 1039
		loop 2
	)
)

