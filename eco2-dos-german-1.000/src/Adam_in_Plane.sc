;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1881)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Adam_in_Plane 0
)

(instance Adam_in_Plane of Eco2Talker
	(properties
		name {Adam in Plane}
		x 5
		y 31
		view 98
		loop 1
		talkWidth 120
		back 67
		textX 170
		textY 15
		dftBack 67
		textSpacer 20
	)

	(method (init)
		(= font gUserFont)
		(super init: theBust theEyes theMouth &rest)
	)
)

(instance theMouth of Prop
	(properties
		nsTop 60
		nsLeft 43
		view 98
	)
)

(instance theBust of Prop
	(properties
		view 98
		loop 1
	)
)

(instance theEyes of Prop
	(properties
		nsTop 49
		nsLeft 45
		view 98
		loop 2
	)
)

