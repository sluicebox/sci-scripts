;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 106)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	oldGhostTalker 0
)

(instance oldGhostTalker of GloryTalker
	(properties
		talkWidth 150
		textX 140
		textY 5
	)

	(method (init)
		(super init: oldghostMouth 0 oldghostEyes oldghostFrame &rest)
	)
)

(instance oldghostFrame of Prop
	(properties
		y 20
		view 287
	)
)

(instance oldghostMouth of Prop
	(properties
		x 59
		y 78
		view 287
		loop 1
	)
)

(instance oldghostEyes of Prop
	(properties
		x 79
		y 56
		view 287
		loop 2
	)
)

