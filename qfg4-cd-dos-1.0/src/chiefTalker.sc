;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 103)
(include sci.sh)
(use Main)
(use GloryTalker)
(use Motion)
(use Actor)
(use System)

(public
	chiefTalker 0
	chiefAntennae 1
)

(instance chiefTalker of GloryTalker
	(properties
		talkWidth 150
		textX 140
		textY 5
	)

	(method (init)
		(super init: chiefMouth 0 chiefEyes chiefFrame &rest)
		(chiefRolls init: setScript: sMoveEyes)
		(if (not (IsFlag 307))
			(UpdateScreenItem
				(chiefAntennae
					init:
					setPri: 15
					cycleSpeed: 6
					setCycle: Fwd
					yourself:
				)
			)
		)
	)

	(method (dispose param1)
		(if (or (not argc) param1)
			(if (not (and gTeller (gTeller talker:)))
				(chiefAntennae dispose:)
			)
			(chiefRolls dispose:)
		)
		(super dispose: param1)
	)
)

(instance chiefFrame of View
	(properties
		priority 10
		fixPriority 1
	)

	(method (init)
		(= view (if (IsFlag 307) 349 else 348))
		(= y (if (IsFlag 307) 12 else 2))
		(super init: &rest)
	)
)

(instance chiefMouth of Prop
	(properties
		loop 1
	)

	(method (init)
		(= view (if (IsFlag 307) 349 else 348))
		(= x (if (IsFlag 307) 38 else 29))
		(= y (if (IsFlag 307) 77 else 110))
		(super init: &rest)
	)
)

(instance chiefEyes of Prop
	(properties
		loop 2
	)

	(method (init)
		(= view (if (IsFlag 307) 349 else 348))
		(= x (if (IsFlag 307) 43 else 38))
		(= y (if (IsFlag 307) 61 else 93))
		(super init: &rest)
	)
)

(instance chiefAntennae of Prop
	(properties
		x 1
		y 202
		z 200
		view 348
		loop 3
	)
)

(instance chiefRolls of Prop
	(properties
		view 348
		loop 4
	)

	(method (init)
		(= view (if (IsFlag 307) 349 else 348))
		(= x (if (IsFlag 307) 43 else 38))
		(= y (if (IsFlag 307) 61 else 93))
		(super init: &rest)
	)
)

(instance sMoveEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 6))
			)
			(1
				(chiefEyes hide:)
				(chiefRolls show:)
				(if register
					(chiefRolls setCel: 0 cycleSpeed: 8 setCycle: End)
					(= register 0)
				else
					(chiefRolls setCel: 8 cycleSpeed: 8 setCycle: Beg)
					(= register 1)
				)
				(= seconds 5)
			)
			(2
				(chiefEyes show:)
				(chiefRolls hide:)
				(self changeState: 0)
			)
		)
	)
)

