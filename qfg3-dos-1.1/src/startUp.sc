;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 704)
(include sci.sh)
(use TargFeature)
(use OccasionalCycle)
(use Motion)
(use System)

(public
	startUp 0
)

(instance flee of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(monkey1
					setCycle: Walk
					setLoop: 5
					cycleSpeed: 0
					moveSpeed: 0
					setMotion: MoveTo 330 210
				)
				(monkey2
					setCycle: Walk
					setLoop: 6
					cycleSpeed: 0
					moveSpeed: 0
					setMotion: MoveTo -30 90
				)
				(monkey3
					setCycle: Walk
					setLoop: 5
					cycleSpeed: 0
					moveSpeed: 0
					setMotion: MoveTo 350 30
				)
				(self dispose:)
			)
		)
	)
)

(instance startUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(monkey1
					loop: 7
					cel: 3
					x: 251
					y: 178
					cycleSpeed: 10
					priority: 15
					setCycle: OccasionalCycle monkey1 1 30 45
					init:
				)
				(monkey2
					loop: 8
					cel: 0
					x: 22
					y: 98
					cycleSpeed: 10
					moveSpeed: 0
					priority: 8
					setCycle: OccasionalCycle monkey2 1 30 45
					init:
				)
				(monkey3
					loop: 1
					cel: 1
					x: 274
					y: 50
					cycleSpeed: 11
					moveSpeed: 0
					priority: 15
					setCycle: OccasionalCycle monkey3 1 30 45
					init:
				)
				(= cycles 5)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance monkey1 of TargActor
	(properties
		noun 1
		view 987
		signal 24592
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 20 78 12 13 81 83 16 88 56 33 11) ; theDaggers, dazzleSpell, theFineDagger, theFineSpear, flameDartSpell, forceBoltSpell, theGrapnel, lightningBallSpell, theMagicSpear, theRocks, theSword
			(self setScript: flee)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance monkey2 of TargActor
	(properties
		noun 1
		view 987
		signal 24592
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 20 78 12 13 81 83 16 88 56 33 11) ; theDaggers, dazzleSpell, theFineDagger, theFineSpear, flameDartSpell, forceBoltSpell, theGrapnel, lightningBallSpell, theMagicSpear, theRocks, theSword
			(self setScript: flee)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance monkey3 of TargActor
	(properties
		noun 1
		view 987
		signal 24592
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 20 78 12 13 81 83 16 88 56 33 11) ; theDaggers, dazzleSpell, theFineDagger, theFineSpear, flameDartSpell, forceBoltSpell, theGrapnel, lightningBallSpell, theMagicSpear, theRocks, theSword
			(self setScript: flee)
		)
		(super doVerb: theVerb &rest)
	)
)

