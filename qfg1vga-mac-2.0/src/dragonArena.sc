;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 460)
(include sci.sh)
(use Main)
(use Arena)
(use Monster)
(use n814)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	dragonArena 0
	dragon 1
	dragonScript 2
)

(local
	local0
	local1
	[local2 5] = [0 1 5 6 7]
)

(instance dragonArena of Arena
	(properties
		picture 430
	)

	(method (dispose)
		(dragMusic stop:)
		(gLongSong2 number: 38 loop: 1 play:)
		(super dispose:)
	)

	(method (init &tmp [temp0 9])
		(= monster dragon)
		(= global279 460)
		(super init: &rest)
		(monster drawStatus:)
		(Load rsVIEW 462)
		(dragonTail init:)
		(if (== gHowFast 0)
			(dragonTail addToPic:)
		else
			(dragonTail setScript: drTailScript)
		)
		(dragMusic number: 2 loop: -1 play:)
		(monster init: setScript: dragonScript)
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
		x 168
		y 141
		view 462
		priority 10
		strength 80
		intell 40
		agil 50
		vit 100
		luck 50
		weap 90
		dodge 40
		armorValue 5
		weapValue 8
		attackRange 65
		warriorX 100
		warriorY 158
		flameX 159
		flameY 88
		lowBlow 1
	)

	(method (init)
		(self ignoreActors:)
		(super init: &rest)
	)

	(method (die)
		(SolvePuzzle 613 4 0)
		(self canFight: 0)
	)
)

(instance dragonScript of Script
	(properties)

	(method (doit)
		(if (and (== state 0) global230 (== state 0))
			(self changeState: 7)
			(ClearFlag 233)
		)
		(super doit:)
	)

	(method (init)
		(super init: &rest)
		(client view: 462 setLoop: 0 setPri: 10 setCel: 0)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 284)
				(client
					action: 0
					ateEgo: 0
					setCel: [local2 (Random 0 4)]
					cycleSpeed: 16
					stopUpd:
				)
				(= ticks (Random 12 15))
				(if (IsFlag 285)
					(ClearFlag 285)
					(= state 1)
				)
			)
			(1
				(if (Random 0 3)
					(= state -1)
					(client setCel: [local2 (Random 0 4)] stopUpd:)
					(= ticks (Random 12 15))
				else
					(client setCel: 1 stopUpd:)
					(= ticks 40)
				)
			)
			(2
				(ClearFlag 284)
				(= local1 0)
				(client action: 1 setCel: 0 setCycle: CT 4 1 self)
				(if (client tryAttack: (client opponent:))
					(client ateEgo: 1)
				)
			)
			(3
				(if (client ateEgo:)
					(= ticks 1)
				else
					(= ticks 12)
				)
			)
			(4
				(if (client ateEgo:)
					(client
						doDamage: (client opponent:)
						ateEgo: 0
						setCycle: CT 1 1 self
					)
				else
					(client setCycle: End self)
				)
			)
			(5
				(client stopUpd:)
				(SetFlag 284)
				(= ticks 20)
			)
			(6
				(self changeState: 0)
			)
			(7
				(client action: 0)
				(client setCycle: 0 stopUpd:)
				(= state -1)
				(= ticks (* global230 3))
				(= global230 0)
			)
		)
	)
)

(instance dragonTail of Prop
	(properties
		x 183
		y 95
		view 462
		loop 2
		priority 8
	)
)

(instance drTailScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (client cel:))
				(if (< register 2)
					(client setCel: (++ register) stopUpd:)
				else
					(client setCel: 0 stopUpd:)
				)
				(= state -1)
				(= ticks 42)
			)
		)
	)
)

