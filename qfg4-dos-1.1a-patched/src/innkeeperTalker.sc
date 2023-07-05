;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 98)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	innkeeperTalker 0
)

(instance innkeeperTalker of GloryTalker
	(properties
		talkWidth 135
		textX 150
		textY 5
	)

	(method (init)
		(super init: innkeeperMouth 0 innkeeperEyes innkeeperFrame &rest)
	)
)

(instance innkeeperFrame of Prop
	(properties
		y 3
		view 326
	)
)

(instance innkeeperMouth of Prop
	(properties
		x 59
		y 51
		view 326
		loop 1
	)
)

(instance innkeeperEyes of Prop
	(properties
		x 63
		y 34
		view 326
		loop 2
	)
)

(instance pipeSmoke of Prop ; UNUSED
	(properties
		x 125
		y 9
		view 326
		loop 3
	)
)

