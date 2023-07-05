;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 97)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	katrinaBlackTalker 0
)

(instance katrinaBlackTalker of GloryTalker
	(properties
		x 0
		y 0
		talkWidth 150
		view 883
		textX 140
		textY 15
	)

	(method (init)
		(super init: kBlackMouth 0 kBlackEyes kBlackFrame &rest)
	)
)

(instance kBlackFrame of View
	(properties
		view 883
	)
)

(instance kBlackMouth of Prop
	(properties
		x 42
		y 91
		view 883
		loop 1
	)
)

(instance kBlackEyes of Prop
	(properties
		x 47
		y 78
		view 883
		loop 2
	)
)

