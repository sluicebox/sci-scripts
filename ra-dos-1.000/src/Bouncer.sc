;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1905)
(include sci.sh)
(use Main)
(use Talker)

(public
	Bouncer 17
)

(instance Bouncer of Narrator
	(properties
		x 100
		y 50
		talkWidth 150
		back 15
	)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)
)

