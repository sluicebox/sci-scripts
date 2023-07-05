;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	oldmanTalker 0
)

(instance oldmanTalker of GloryTalker
	(properties
		talkWidth 150
		textX 140
		textY 5
	)

	(method (init)
		(super init: oldmanMouth 0 oldmanEyes oldmanFrame &rest)
	)
)

(instance oldmanFrame of Prop
	(properties
		y 20
		view 286
	)
)

(instance oldmanMouth of Prop
	(properties
		x 59
		y 78
		view 286
		loop 1
	)
)

(instance oldmanEyes of Prop
	(properties
		x 79
		y 56
		view 286
		loop 2
	)
)

