;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 96)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	katrinaRedTalker 0
)

(instance katrinaRedTalker of GloryTalker
	(properties
		x 0
		y 0
		talkWidth 150
		view 882
		textX 140
		textY 5
	)

	(method (init)
		(super init: kRedMouth 0 kRedEyes kRedFrame &rest)
	)
)

(instance kRedFrame of View
	(properties
		view 882
	)
)

(instance kRedMouth of Prop
	(properties
		x 42
		y 91
		view 882
		loop 1
	)
)

(instance kRedEyes of Prop
	(properties
		x 47
		y 78
		view 882
		loop 2
	)
)

