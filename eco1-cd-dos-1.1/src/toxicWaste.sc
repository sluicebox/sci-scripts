;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 124)
(include sci.sh)
(use Main)
(use EcoFeature)
(use Talker)
(use DPath)
(use Motion)
(use System)

(public
	toxicWaste 0
)

(local
	local0
)

(instance toxicWaste of Script
	(properties)

	(method (dispose)
		(waft1 setCycle: 0 setMotion: 0 dispose: delete:)
		(if (> gHowFast 1)
			(waft2 setCycle: 0 setMotion: 0 dispose: delete:)
		)
		(super dispose:)
		(DisposeScript 124)
	)

	(method (doit)
		(super doit: &rest)
		(if (or (and (<= gHowFast 1) (== local0 1)) (== local0 2))
			(= local0 0)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(waft1 init: setCycle: Walk setMotion: DPath 77 60 -50 50 waft1)
				(if (> gHowFast 1)
					(waft2
						init:
						setCycle: Walk
						setMotion: DPath 82 64 -50 50 waft2
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance waft1 of EcoActor
	(properties
		x 291
		y 148
		view 820
		loop 1
		priority 2
		signal 18448
		cycleSpeed 12
		moveSpeed 8
		lookStr 35
	)

	(method (cue)
		(++ local0)
		(self hide:)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (OneOf theVerb 44 4 6) ; Inventory, Do, Recycle
			(EcoNarrator init: 3 0 0 36) ; "If Adam wants to stop the oogy green stuff, he'll have to find the source."
		else
			(super doVerb: theVerb temp0 &rest) ; UNINIT
		)
	)
)

(instance waft2 of EcoActor
	(properties
		x 291
		y 153
		view 820
		priority 2
		signal 18448
		cycleSpeed 12
		moveSpeed 8
		lookStr 35
	)

	(method (cue)
		(++ local0)
		(self hide:)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (OneOf theVerb 44 4 6) ; Inventory, Do, Recycle
			(EcoNarrator init: 3 0 0 36) ; "If Adam wants to stop the oogy green stuff, he'll have to find the source."
		else
			(super doVerb: theVerb temp0 &rest) ; UNINIT
		)
	)
)

