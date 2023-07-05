;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1904)
(include sci.sh)
(use Main)
(use Talker)

(public
	Talking_Bear 20
)

(instance Talking_Bear of Talker
	(properties
		name {Talking Bear}
		x 100
		y 0
		talkWidth 150
		back 15
	)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)
)

