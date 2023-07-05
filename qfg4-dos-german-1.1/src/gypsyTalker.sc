;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 92)
(include sci.sh)
(use GloryTalker)
(use Motion)
(use Actor)
(use System)

(public
	gypsyTalker 0
)

(local
	local0
)

(instance gypsyTalker of GloryTalker
	(properties
		x 0
		y 17
		talkWidth 150
		view 466
		textX 140
		textY 15
	)

	(method (init)
		(super init: gypsyMouth 0 0 gypsyFrame &rest)
		(gypsyEyes init: setScript: sGlintingEyes)
	)

	(method (hide)
		(gypsyEyes hide:)
		(super hide:)
	)

	(method (showAgain)
		(gypsyEyes show:)
		(super showAgain:)
	)

	(method (dispose param1)
		(if (or (not argc) param1)
			(gypsyEyes dispose:)
		)
		(super dispose: param1)
	)
)

(instance gypsyFrame of View
	(properties
		y 17
		view 466
	)
)

(instance gypsyMouth of Prop
	(properties
		x 29
		y 58
		view 466
		loop 1
	)
)

(instance gypsyEyes of Prop
	(properties
		x 29
		y 45
		view 466
		loop 2
	)
)

(instance sGlintingEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(= cycles 1)
			)
			(1
				(if (== (= local0 (Random 0 2)) 2)
					(gypsyEyes setCel: 0 setLoop: 2 setCycle: End)
					(= seconds 1)
				else
					(gypsyEyes setCel: 0 setLoop: 3 setCycle: End)
					(= seconds (Random 3 7))
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

