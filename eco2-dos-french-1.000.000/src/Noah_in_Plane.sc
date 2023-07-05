;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1880)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Noah_in_Plane 0
)

(instance Noah_in_Plane of Eco2Talker
	(properties
		name {Noah in Plane}
		x 5
		y 31
		view 98
		loop 1
		talkWidth 120
		back 13
		textX 170
		textY 10
		dftBack 13
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
		nsLeft 73
		view 97
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
		nsTop 25
		nsLeft 79
		view 97
		loop 2
	)
)

