;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1907)
(include sci.sh)
(use Main)
(use Talker)

(public
	Luigi 24
)

(instance Luigi of Narrator
	(properties
		x 100
		y 70
		talkWidth 150
		back 15
	)

	(method (init)
		(= font gUserFont)
		(= showTitle 1)
		(super init: &rest)
	)
)

