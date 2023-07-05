;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1339)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Hag3 0
)

(instance Hag3 of Eco2Talker
	(properties
		x 5
		y 5
		view 1339
		loop 3
		talkWidth 150
		back 62
		textX 115
		textY 12
		dftBack 62
	)

	(method (init)
		(= font gUserFont)
		(super init: hagsBust hagsEyes hagsMouth &rest)
	)
)

(instance hagsMouth of Prop
	(properties
		nsTop 54
		nsLeft 25
		view 1339
	)
)

(instance hagsBust of Prop
	(properties
		view 1339
		loop 1
	)
)

(instance hagsEyes of Prop
	(properties
		nsTop 26
		nsLeft 29
		view 1339
		loop 2
	)
)

