;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 78)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	ivanTalker 0
)

(instance ivanTalker of GloryTalker
	(properties
		talkWidth 150
		textX 140
		textY 5
	)

	(method (init)
		(super init: ivanMouth 0 ivanEyes ivanFrame &rest)
	)
)

(instance ivanFrame of View
	(properties
		y 2
		view 268
	)
)

(instance ivanMouth of Prop
	(properties
		x 69
		y 84
		view 268
		loop 1
	)
)

(instance ivanEyes of Prop
	(properties
		x 71
		y 63
		view 268
		loop 2
	)
)

