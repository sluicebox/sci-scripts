;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 104)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	erasmusTalker 0
)

(instance erasmusTalker of GloryTalker
	(properties
		x 0
		y 2
		talkWidth 140
		view 276
		textX 150
		textY 15
	)

	(method (init)
		(super init: erasmusMouth 0 erasmusEyes erasmusFrame &rest)
	)
)

(instance erasmusFrame of View
	(properties
		view 276
	)
)

(instance erasmusMouth of Prop
	(properties
		x 46
		y 87
		view 276
		loop 1
	)
)

(instance erasmusEyes of Prop
	(properties
		x 63
		y 66
		view 276
		loop 2
	)
)

