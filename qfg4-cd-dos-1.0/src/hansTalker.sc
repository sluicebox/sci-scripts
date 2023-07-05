;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 76)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	hansTalker 0
)

(instance hansTalker of GloryTalker
	(properties
		talkWidth 150
		textX 140
		textY 5
	)

	(method (init)
		(super init: hansMouth 0 hansEyes hansFrame &rest)
	)
)

(instance hansFrame of View
	(properties
		y 3
		view 266
	)
)

(instance hansMouth of Prop
	(properties
		x 36
		y 94
		view 266
		loop 1
	)
)

(instance hansEyes of Prop
	(properties
		x 50
		y 84
		view 266
		loop 2
	)
)

