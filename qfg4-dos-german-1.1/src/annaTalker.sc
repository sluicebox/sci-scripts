;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 75)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	annaTalker 0
)

(instance annaTalker of GloryTalker
	(properties
		x 0
		y 1
		talkWidth 150
		view 289
		textX 160
		textY 5
	)

	(method (init)
		(super init: annaMouth 0 annaEyes annaFrame &rest)
	)
)

(instance annaFrame of View
	(properties
		y 1
		view 289
	)
)

(instance annaMouth of Prop
	(properties
		x 72
		y 56
		view 289
		loop 1
	)
)

(instance annaEyes of Prop
	(properties
		x 72
		y 36
		view 289
		loop 2
	)
)

