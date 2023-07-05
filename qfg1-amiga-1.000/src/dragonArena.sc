;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 460)
(include sci.sh)
(use Main)
(use Arena)
(use Monster)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	dragonArena 0
	dragon 1
)

(local
	local0
	local1
)

(instance dragonArena of Arena
	(properties
		picture 460
	)

	(method (dispose)
		(dragMusic stop:)
		(gEndBattle number: (SoundFX 38) loop: 1 play:)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 462)
		(= monster dragon)
		(= global332 460)
		(super init: &rest)
		(dragonTail init:)
		(dragMusic number: (SoundFX 2) loop: -1 play:)
		(monster setScript: dragonScript)
	)
)

(instance dragMusic of Sound
	(properties
		number 2
		priority 2
		loop -1
	)
)

(instance dragon of Monster
	(properties
		y 118
		x 170
		view 462
		priority 10
		strength 80
		intell 40
		agil 40
		vit 100
		luck 50
		weap 50
		dodge 40
		armorValue 5
		weapValue 8
		attackRange 65
		warriorX 185
		warriorY 210
		flameX 163
		flameY 112
	)

	(method (die)
		(SolvePuzzle 613 4 0)
		(self canFight: 0)
	)
)

(instance dragonScript of Script
	(properties)

	(method (doit)
		(if (== state 0)
			(cond
				(global251
					(= cycles (+ (Random 10 25) global251))
					(= global251 0)
					(ClearFlag 233)
				)
				((IsFlag 233)
					(= cycles 0)
					(self setScript: dragonHurt)
				)
			)
		)
		(super doit:)
	)

	(method (init)
		(super init: &rest)
		(client view: 462 setLoop: 0 setPri: 10 cel: 8)
		(if (== gHowFast 0)
			(dragonTail addToPic:)
		else
			(dragonTail cycleSpeed: 6 setScript: drTailScript)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					action: 0
					cycleSpeed: 0
					setCycle: 0
					posn: 170 118
					stopUpd:
				)
				(= cycles
					(if local1
						1
					else
						(Random 10 25)
					)
				)
			)
			(1
				(= local1 0)
				(client action: 1 setCycle: CT 5 1 self)
				(if (client tryAttack: (client opponent:))
					(client ateEgo: 1)
				)
			)
			(2
				(if (client ateEgo:)
					(client doDamage: (client opponent:) ateEgo: 0)
				)
				(client cycleSpeed: 1 setCycle: CT 1 1 self)
			)
			(3
				(if (= local0 (- 1 local0))
					(client setCycle: CT 8 1 self)
				else
					(self cue:)
				)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance dragonTail of Prop
	(properties
		y 121
		x 86
		view 462
		loop 1
		priority 8
	)
)

(instance drTailScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(= state -1)
				(client setCycle: Beg self)
			)
		)
	)
)

(instance dragonHurt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 233)
				(dragonTail cycleSpeed: 0)
				(dragon setLoop: 2 setCel: 0)
				(= cycles 6)
			)
			(1
				(dragon setLoop: 0 setCel: -1)
				(dragonTail cycleSpeed: 6)
				(= cycles 2)
			)
			(2
				(= local1 1)
				(client changeState: 0)
				(self dispose:)
			)
		)
	)
)

