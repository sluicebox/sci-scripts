;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use Talker)

(public
	KQNarrator 0
)

(class KQNarrator of Narrator
	(properties
		talkWidth 314
		modeless 2
	)

	(method (init)
		(self fore: 6 back: 1 font: gUserFont y: 0)
		(super init: &rest)
	)
)

