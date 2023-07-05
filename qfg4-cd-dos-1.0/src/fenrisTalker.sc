;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 105)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	fenrisTalker 0
)

(instance fenrisTalker of GloryTalker
	(properties
		x 0
		y 2
		talkWidth 120
		view 277
		textX -130
		textY 5
	)

	(method (init)
		(super init: fenrisMouth 0 fenrisEyes fenrisFrame &rest)
	)
)

(instance fenrisFrame of View
	(properties
		x 128
		y 10
		view 277
	)
)

(instance fenrisMouth of Prop
	(properties
		x 128
		y 92
		view 277
		loop 1
	)
)

(instance fenrisEyes of Prop
	(properties
		x 196
		y 89
		view 277
		loop 2
	)
)

