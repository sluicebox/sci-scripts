;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1338)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Hag2 0
)

(instance Hag2 of Eco2Talker
	(properties
		x 5
		y 5
		view 1337
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
		nsTop 46
		nsLeft 19
		view 1337
	)
)

(instance hagsBust of Prop
	(properties
		view 1337
		loop 1
	)
)

(instance hagsEyes of Prop
	(properties
		nsTop 21
		nsLeft 19
		view 1337
		loop 2
	)
)

