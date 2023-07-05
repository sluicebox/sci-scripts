;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 74)
(include sci.sh)
(use GloryTalker)
(use Motion)
(use Actor)
(use System)

(public
	avisTalker 0
)

(instance avisTalker of GloryTalker
	(properties
		x 0
		y 23
		talkWidth 150
		view 676
		textX 140
		textY 5
	)

	(method (init)
		(super init: avisMouth 0 avisEyes avisFrame &rest)
		(avisChin init: cycleSpeed: 12 setScript: sDoChin)
	)

	(method (hide)
		(avisChin hide:)
		(super hide:)
	)

	(method (showAgain)
		(avisChin show:)
		(super showAgain:)
	)

	(method (dispose param1)
		(if (or (not argc) param1)
			(avisChin dispose:)
		)
		(super dispose: param1)
	)
)

(instance avisFrame of View
	(properties
		y 23
		view 676
	)
)

(instance avisMouth of Prop
	(properties
		x 58
		y 78
		view 676
		loop 1
	)
)

(instance avisEyes of Prop
	(properties
		x 66
		y 61
		view 676
		loop 2
	)
)

(instance avisChin of Prop
	(properties
		x 57
		y 51
		view 676
		loop 3
	)
)

(instance sDoChin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 6))
			)
			(1
				(= seconds (Random 3 6))
			)
			(2
				(avisChin setLoop: 3 setCel: 0 setCycle: End)
				(= seconds 1)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

