;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 99)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	tanyaVampTalker 0
)

(instance tanyaVampTalker of GloryTalker
	(properties
		x 0
		y 28
		talkWidth 150
		view 656
		textX 140
		textY 5
	)

	(method (init)
		(super init: tanyaVMouth 0 tanyaVEyes tanyaVFrame &rest)
	)
)

(instance tanyaVFrame of View
	(properties
		y 28
		view 656
	)
)

(instance tanyaVMouth of Prop
	(properties
		x 59
		y 86
		view 656
		loop 1
	)
)

(instance tanyaVEyes of Prop
	(properties
		x 54
		y 67
		view 656
		loop 2
	)
)

