;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 66)
(include sci.sh)
(use GloryTalker)
(use Motion)
(use Actor)

(public
	keeperTalker 0
)

(instance keeperTalker of GloryTalker
	(properties
		x 0
		y 2
		talkWidth 150
		view 606
		textX 140
		textY 15
	)

	(method (init)
		(super init: keeperMouth 0 keeperEyes keeperFrame &rest)
		(keeperHand init: setPri: 255 cycleSpeed: 12 setCycle: Fwd)
	)

	(method (hide)
		(keeperHand hide:)
		(super hide:)
	)

	(method (showAgain)
		(keeperHand show:)
		(super showAgain:)
	)

	(method (dispose param1)
		(if (or (not argc) param1)
			(keeperHand dispose:)
		)
		(super dispose: param1)
	)
)

(instance keeperFrame of View
	(properties
		y 2
		view 606
	)
)

(instance keeperMouth of Prop
	(properties
		x 44
		y 74
		view 606
		loop 1
	)
)

(instance keeperEyes of Prop
	(properties
		x 41
		y 53
		view 606
		loop 2
	)
)

(instance keeperHand of Prop
	(properties
		x 34
		y 149
		view 606
		loop 3
	)
)

