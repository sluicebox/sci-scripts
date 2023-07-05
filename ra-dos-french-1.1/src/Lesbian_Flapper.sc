;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1906)
(include sci.sh)
(use Main)
(use Talker)

(public
	Lesbian_Flapper 8
)

(instance Lesbian_Flapper of Narrator
	(properties
		name {Lesbian Flapper}
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

