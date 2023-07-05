;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 48)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	priestessTalker 0
)

(instance priestessTalker of GloryTalker
	(properties
		x 202
		y 80
		view 356
		loop 1
		talkWidth 260
		back 57
		textX -185
		textY -120
		backColor 45
	)

	(method (init)
		(super init: priestessBust priestessEyes priestessMouth &rest)
	)
)

(instance priestessMouth of Prop
	(properties
		nsTop 62
		nsLeft 50
		view 356
	)
)

(instance priestessEyes of Prop
	(properties
		nsTop 51
		nsLeft 48
		view 356
		loop 2
	)
)

(instance priestessBust of View
	(properties
		nsTop 39
		nsLeft 49
		view 356
		loop 3
	)
)

