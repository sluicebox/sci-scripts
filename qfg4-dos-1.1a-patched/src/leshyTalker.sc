;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 79)
(include sci.sh)
(use GloryTalker)
(use Motion)
(use Actor)
(use System)

(public
	leshyTalker 0
)

(instance leshyTalker of GloryTalker
	(properties
		x 0
		y 1
		talkWidth 150
		view 577
		textX 140
		textY 5
	)

	(method (init)
		(super init: leshyMouth 0 leshyEyes leshyFrame &rest)
		(birdy init: setScript: sCuckoo)
	)

	(method (dispose param1)
		(if (or (not argc) param1)
			(birdy dispose:)
		)
		(super dispose: param1)
	)
)

(instance sCuckoo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self cue:)
			)
			(1
				(= seconds 2)
			)
			(2
				(birdy setCel: 0 setCycle: End)
				(= seconds (Random 5 8))
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance leshyFrame of Prop
	(properties
		y 1
		view 577
	)
)

(instance leshyMouth of Prop
	(properties
		x 8
		y 52
		view 577
		loop 1
	)
)

(instance leshyEyes of Prop
	(properties
		x 49
		y 48
		view 577
		loop 2
	)
)

(instance birdy of Prop
	(properties
		x 41
		y 24
		view 577
		loop 3
	)
)

