;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 93)
(include sci.sh)
(use Main)
(use GloryTalker)
(use Motion)
(use Actor)
(use System)

(public
	bellaTalker 0
)

(instance bellaTalker of GloryTalker
	(properties
		talkWidth 150
		textX 140
		textY 5
	)

	(method (init)
		(super init: bellaMouth 0 bellaEyes bellaFrame &rest)
		(bellaBrow init: setScript: sDoBrow)
	)

	(method (hide)
		(bellaBrow hide: setScript: 0)
		(super hide:)
	)

	(method (showAgain)
		(bellaBrow show: setScript: sDoBrow)
		(super showAgain:)
	)

	(method (dispose param1)
		(if
			(and
				(or (not argc) param1)
				(or
					(not (IsFlag 147))
					(and gTeller (!= (gTeller talker:) self))
				)
			)
			(bellaBrow dispose:)
		)
		(super dispose: param1)
	)
)

(instance bellaFrame of View
	(properties
		y 20
		view 328
	)
)

(instance bellaMouth of Prop
	(properties
		x 54
		y 66
		view 328
		loop 1
	)
)

(instance bellaEyes of Prop
	(properties
		x 63
		y 54
		view 328
		loop 2
	)
)

(instance bellaBrow of Prop
	(properties
		x 59
		y 45
		view 328
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
					(bellaBrow setCycle: End)
					(= register 0)
				else
					(bellaBrow setCycle: Beg)
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

