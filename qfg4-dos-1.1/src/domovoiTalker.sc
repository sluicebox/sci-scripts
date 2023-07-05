;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 72)
(include sci.sh)
(use Main)
(use GloryTalker)
(use Motion)
(use Actor)
(use System)

(public
	domovoiTalker 0
)

(instance domovoiTalker of GloryTalker
	(properties
		talkWidth 150
		textX 140
		textY 5
	)

	(method (init)
		(super init: domoMouth 0 domoEyes domoFrame &rest)
		(domoBrow init: setScript: sDoBrow)
	)

	(method (hide)
		(domoBrow hide: setScript: 0)
		(super hide:)
	)

	(method (showAgain)
		(domoBrow show: setScript: sDoBrow)
		(super showAgain:)
	)

	(method (dispose param1)
		(if (or (not argc) param1)
			(domoBrow dispose:)
		)
		(super dispose: param1)
	)
)

(instance domoFrame of View
	(properties)

	(method (init)
		(= view (if (== gCurRoomNum 360) 367 else 336))
		(super init: &rest)
	)
)

(instance domoMouth of Prop
	(properties
		x 47
		y 55
		loop 1
	)

	(method (init)
		(= view (if (== gCurRoomNum 360) 367 else 336))
		(super init: &rest)
	)
)

(instance domoEyes of Prop
	(properties
		x 51
		y 38
		loop 2
	)

	(method (init)
		(= view (if (== gCurRoomNum 360) 367 else 336))
		(super init: &rest)
	)
)

(instance domoBrow of Prop
	(properties
		x 44
		y 25
		loop 3
	)

	(method (init)
		(= view (if (== gCurRoomNum 360) 367 else 336))
		(super init: &rest)
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
					(domoBrow setCycle: End)
					(= register 0)
				else
					(domoBrow setCycle: Beg)
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

