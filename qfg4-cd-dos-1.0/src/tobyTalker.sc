;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 70)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	tobyTalker 0
)

(instance tobyTalker of GloryTalker
	(properties
		talkWidth 150
		view 647
		textX 140
		textY 15
	)

	(method (init)
		(super init: tobyMouth 0 tobyEyes tobyFrame &rest)
	)
)

(instance tobyFrame of View
	(properties
		y 13
		view 647
	)
)

(instance tobyMouth of Prop
	(properties
		x 60
		y 63
		view 647
		loop 1
	)
)

(instance tobyEyes of Prop
	(properties
		x 65
		y 47
		view 647
		loop 2
	)
)

