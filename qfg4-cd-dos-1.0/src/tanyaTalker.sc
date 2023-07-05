;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 71)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	tanyaTalker 0
)

(instance tanyaTalker of GloryTalker
	(properties
		x 0
		y 22
		talkWidth 150
		view 658
		textX 140
		textY 5
	)

	(method (init)
		(super init: tanyaMouth 0 tanyaEyes tanyaFrame &rest)
	)
)

(instance tanyaFrame of View
	(properties
		y 22
		view 658
	)
)

(instance tanyaMouth of Prop
	(properties
		x 56
		y 85
		view 658
		loop 1
	)
)

(instance tanyaEyes of Prop
	(properties
		x 54
		y 66
		view 658
		loop 2
	)
)

