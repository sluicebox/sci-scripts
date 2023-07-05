;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1902)
(include sci.sh)
(use Main)
(use Talker)

(public
	Rocco 13
)

(instance Rocco of Narrator
	(properties
		x 15
		y 120
		talkWidth 275
		modeless 1
		back 15
	)

	(method (init)
		(= font gUserFont)
		(= showTitle 1)
		(super init: &rest)
	)
)

