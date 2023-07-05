;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 73)
(include sci.sh)
(use GloryTalker)
(use Motion)
(use Actor)
(use System)

(public
	igorTalker 0
)

(instance igorTalker of GloryTalker
	(properties
		talkWidth 150
		textX 140
		textY 5
	)

	(method (init)
		(super init: igorMouth 0 igorEyes igorFrame &rest)
		(igorBrow init: setScript: sDoBrow)
	)

	(method (hide)
		(igorBrow dispose:)
		(super hide:)
	)

	(method (showAgain)
		(igorBrow dispose:)
		(super showAgain:)
	)

	(method (dispose param1)
		(if (or (not argc) param1)
			(igorBrow dispose:)
		)
		(super dispose: param1)
	)
)

(instance igorFrame of View
	(properties
		y 37
		view 256
	)
)

(instance igorMouth of Prop
	(properties
		x 77
		y 86
		view 256
		loop 1
	)
)

(instance igorEyes of Prop
	(properties
		x 84
		y 81
		view 256
		loop 2
	)
)

(instance igorBrow of Prop
	(properties
		x 80
		y 77
		view 256
		loop 3
	)
)

(instance sDoBrow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 4))
			)
			(1
				(if register
					(igorBrow setCycle: End)
					(= register 0)
				else
					(igorBrow setCycle: Beg)
					(= register 1)
				)
				(= seconds 4)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

