;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 425)
(include sci.sh)
(use Main)
(use Arena)
(use Monster)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	minotaurArena 0
	minotaur 1
)

(local
	local0
	local1
	local2
)

(instance minotaurArena of Arena
	(properties
		picture 400
	)

	(method (dispose)
		(minoMusic stop:)
		(gEndBattle number: (SoundFX 38) loop: 1 play:)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 427)
		(= monster minotaur)
		(super init: &rest)
		(legs init:)
		(body init:)
		(gAddToPics add: legs body doit:)
		(leftArm ignoreActors: init: setPri: 4 stopUpd:)
		(rightArm ignoreActors: init: setPri: 4 stopUpd:)
		(ball
			ignoreActors:
			setPri: 4
			cycleSpeed: (if (== gHowFast 0) 0 else 1)
			init:
		)
		(minoMusic number: (SoundFX 2) loop: -1 play:)
		(monster setScript: minotaurScript)
	)

	(method (doit)
		(if (and (IsFlag 233) (== (minotaurScript state:) 0) (not local0))
			(minotaurScript setScript: minotaurHurt)
		)
		(super doit:)
	)
)

(instance minoMusic of Sound
	(properties
		number 2
		priority 2
		loop -1
	)
)

(instance minotaur of Monster
	(properties
		y 67
		x 156
		view 427
		loop 2
		strength 80
		intell 40
		agil 60
		vit 100
		luck 50
		weap 70
		dodge 40
		armorValue 5
		weapValue 10
		attackRange 65
		warriorX 190
		flameX 165
		flameY 74
	)

	(method (die)
		(SolvePuzzle 737 5 0)
		(self canFight: 0)
	)
)

(instance minotaurScript of Script
	(properties)

	(method (doit)
		(cond
			((and global251 (== state 0) (not script))
				(+= cycles global251)
				(= global251 0)
				(ClearFlag 233)
			)
			(local0
				(= local1 (= cycles 0))
			)
			((not local1)
				(= local1 1)
				(minotaur action: 3)
				(self setScript: minotaurBlock)
			)
		)
		(super doit:)
	)

	(method (init)
		(super init: &rest)
		(= global332 425)
		(client
			view: 427
			setLoop: 2
			cel: 0
			setPri: 4
			cycleSpeed:
				(switch gHowFast
					(0 0)
					(1 1)
					(2 1)
					(3 2)
				)
			setCycle: Fwd
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client action: 0 setLoop: 2 cel: 0 setCycle: Fwd)
				(rightArm setLoop: 1 cel: 1 stopUpd:)
				(ball setLoop: 3 cel: 0 setCycle: Fwd)
				(leftArm setCel: 1)
				(cond
					((>= cycles 8))
					(local2
						(= cycles 1)
						(= local2 0)
					)
					(else
						(= cycles (Random 6 13))
					)
				)
			)
			(1
				(client action: 1)
				(rightArm hide:)
				(ball posn: 121 53 setLoop: 4 setCel: 0)
				(= cycles 2)
			)
			(2
				(ball setCel: 1)
				(= cycles 1)
				(if (client tryAttack: (client opponent:))
					(client ateEgo: 1)
				)
			)
			(3
				(if (client ateEgo:)
					(client doDamage: (client opponent:) ateEgo: 0)
				)
				(ball setCycle: End self)
			)
			(4
				(ball posn: 93 47 setLoop: 3 cel: 0 setCycle: Fwd)
				(rightArm show:)
				(self cue:)
			)
			(5
				(self changeState: 0)
			)
		)
	)
)

(instance legs of PV
	(properties
		y 189
		x 153
		view 427
		loop 1
		priority 2
	)
)

(instance body of PV
	(properties
		y 116
		x 156
		view 427
		priority 3
	)
)

(instance leftArm of Prop
	(properties
		y 57
		x 193
		view 427
		loop 5
		cel 1
	)
)

(instance rightArm of View
	(properties
		y 77
		x 104
		view 427
		loop 1
		cel 1
	)
)

(instance ball of Prop
	(properties
		y 47
		x 93
		view 427
		loop 3
	)
)

(instance minotaurHurt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(ClearFlag 233)
				(minotaur y: (- (minotaur y:) 3) setLoop: 6 setCel: 1)
				(= cycles 3)
			)
			(1
				(minotaur setCel: 0)
				(= cycles (Random 5 10))
			)
			(2
				(minotaur y: (+ (minotaur y:) 3) setLoop: 2 setCel: -1)
				(= cycles 2)
			)
			(3
				(= local0 0)
				(client changeState: 0)
				(= local2 1)
				(self dispose:)
			)
		)
	)
)

(instance minotaurBlock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(leftArm setCel: 0)
				(= cycles 8)
			)
			(2
				(leftArm setCel: 1)
				(= cycles 1)
			)
			(3
				(= local1 0)
				(self dispose:)
			)
		)
	)
)

