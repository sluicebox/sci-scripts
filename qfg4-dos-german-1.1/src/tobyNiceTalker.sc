;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 101)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	tobyNiceTalker 0
)

(instance tobyNiceTalker of GloryTalker
	(properties
		talkWidth 150
		view 647
		textX 140
		textY 15
	)

	(method (init)
		(super init: tobyNMouth 0 tobyNEyes tobyNFrame &rest)
	)
)

(instance tobyNFrame of View
	(properties
		y 13
		view 647
	)
)

(instance tobyNMouth of Prop
	(properties
		x 60
		y 63
		view 647
		loop 1
	)
)

(instance tobyNEyes of Prop
	(properties
		x 65
		y 47
		view 647
		loop 3
	)
)

