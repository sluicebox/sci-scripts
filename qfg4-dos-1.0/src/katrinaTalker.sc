;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 68)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	katrinaTalker 0
)

(instance katrinaTalker of GloryTalker
	(properties
		x 0
		y 4
		talkWidth 150
		view 880
		textX 140
		textY 5
	)

	(method (init)
		(super init: kMouth 0 kEyes kFrame &rest)
	)
)

(instance kFrame of View
	(properties
		y 4
		view 880
	)
)

(instance kMouth of Prop
	(properties
		x 44
		y 52
		view 880
		loop 1
	)
)

(instance kEyes of Prop
	(properties
		x 51
		y 39
		view 880
		loop 2
	)
)

(instance kBrow of Prop ; UNUSED
	(properties
		x 69
		y 36
		view 880
		loop 3
		cel 1
	)
)

