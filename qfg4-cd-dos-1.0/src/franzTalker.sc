;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 77)
(include sci.sh)
(use GloryTalker)
(use Motion)
(use Actor)
(use System)

(public
	franzTalker 0
)

(instance franzTalker of GloryTalker
	(properties
		talkWidth 150
		textX 140
		textY 5
	)

	(method (init)
		(super init: franzMouth 0 franzEyes franzFrame &rest)
		(bulgyEyes init: setScript: sDoEyes)
	)

	(method (hide)
		(bulgyEyes hide: setScript: 0)
		(super hide:)
	)

	(method (showAgain)
		(bulgyEyes setScript: sDoEyes)
		(super showAgain:)
	)

	(method (dispose param1)
		(if (or (not argc) param1)
			(bulgyEyes dispose:)
		)
		(super dispose: param1)
	)
)

(instance franzFrame of View
	(properties
		y 2
		view 267
	)
)

(instance franzMouth of Prop
	(properties
		x 55
		y 92
		view 267
		loop 1
	)
)

(instance franzEyes of Prop
	(properties
		x 53
		y 65
		view 267
		loop 2
	)
)

(instance bulgyEyes of Prop
	(properties
		x 53
		y 65
		view 267
		loop 3
		cycleSpeed 9
	)
)

(instance sDoEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bulgyEyes hide:)
				(= cycles 1)
			)
			(1
				(= seconds (Random 2 4))
			)
			(2
				(franzEyes hide:)
				(bulgyEyes show:)
				(bulgyEyes setCel: (Random 0 1) setCycle: End)
				(= seconds 4)
			)
			(3
				(bulgyEyes hide:)
				(franzEyes show:)
				(self changeState: 1)
			)
		)
	)
)

