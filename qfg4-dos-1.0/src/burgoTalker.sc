;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 65)
(include sci.sh)
(use GloryTalker)
(use Actor)
(use System)

(public
	burgoTalker 0
)

(instance burgoTalker of GloryTalker
	(properties
		talkWidth 150
		textX 140
		textY 5
	)

	(method (init)
		(super init: burgoMouth 0 burgoEyes burgoFrame &rest)
		(burgoBrow init: hide: setScript: sMoveBrow)
	)

	(method (hide)
		(burgoBrow hide: setScript: 0)
		(super hide:)
	)

	(method (showAgain)
		(burgoBrow setScript: sMoveBrow)
		(super showAgain:)
	)

	(method (dispose param1)
		(if (or (not argc) param1)
			(burgoBrow dispose:)
		)
		(super dispose: param1)
	)
)

(instance burgoFrame of View
	(properties
		y 1
		view 306
	)
)

(instance burgoMouth of Prop
	(properties
		x 61
		y 44
		view 306
		loop 1
	)
)

(instance burgoEyes of Prop
	(properties
		x 64
		y 36
		view 306
		loop 2
	)
)

(instance burgoBrow of Prop
	(properties
		x 62
		y 30
		view 306
		loop 3
	)
)

(instance sMoveBrow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 4))
			)
			(1
				(if register
					(burgoBrow show: setCel: 0)
					(= register 0)
				else
					(burgoBrow show: setCel: 1)
					(= register 1)
				)
				(= seconds 2)
			)
			(2
				(burgoBrow hide:)
				(self changeState: 0)
			)
		)
	)
)

