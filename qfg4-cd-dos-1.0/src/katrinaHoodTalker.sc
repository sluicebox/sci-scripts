;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 95)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	katrinaHoodTalker 0
)

(instance katrinaHoodTalker of GloryTalker
	(properties
		x 0
		y 10
		talkWidth 150
		view 881
		textX 140
		textY 5
	)

	(method (init)
		(super init: kHoodMouth 0 kHoodEyes kHoodFrame &rest)
	)
)

(instance kHoodFrame of View
	(properties
		y 10
		view 881
	)
)

(instance kHoodMouth of Prop
	(properties
		x 45
		y 52
		view 881
		loop 1
	)
)

(instance kHoodEyes of Prop
	(properties
		x 53
		y 40
		view 881
		loop 2
	)
)

