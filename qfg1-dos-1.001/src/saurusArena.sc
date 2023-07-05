;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 430)
(include sci.sh)
(use Main)
(use Arena)
(use Monster)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	saurusArena 0
	saurus 1
)

(local
	local0
	local1
)

(instance saurusArena of Arena
	(properties
		picture 430
	)

	(method (dispose)
		(saurMusic stop:)
		(gEndBattle number: (SoundFX 7) loop: 1 play:)
		(super dispose:)
	)

	(method (init)
		(= monster saurus)
		(= global332 430)
		(Load rsVIEW 432)
		(super init: &rest)
		(monster setScript: saurusScript)
	)
)

(instance saurMusic of Sound
	(properties
		number 3
		priority 2
		loop -1
	)
)

(instance saurus of Monster
	(properties
		y 131
		x 153
		view 432
		priority 11
		strength 30
		intell 5
		agil 20
		vit 25
		luck 10
		weap 30
		dodge 10
		armorValue 3
		weapValue 5
		attackRange 55
		warriorX 170
		warriorY 205
		flameX 153
		flameY 107
	)

	(method (die)
		(SolvePuzzle 741 1 0)
		(= local1 1)
	)
)

(instance saurusScript of Script
	(properties)

	(method (doit)
		(cond
			(local1
				(= local1 (= cycles 0))
			)
			((and global251 (== state 1))
				(+= cycles global251)
				(= global251 0)
				(ClearFlag 233)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client view: 432 setLoop: 0 setPri: 10 cel: 0 posn: 147 91)
				(saurusTail init: addToPic:)
				(leftClaw init: addToPic:)
				(rightClaw init: addToPic:)
				(saurMusic number: (SoundFX 3) init: play:)
				(= cycles 1)
			)
			(1
				(client action: 0 setLoop: 0 cel: 0 posn: 147 91)
				(if (!= gHowFast 0)
					(client cycleSpeed: 1 setCycle: Fwd)
				)
				(= cycles (Random 10 25))
			)
			(2
				(client
					action: 1
					setLoop: 1
					cel: 0
					cycleSpeed: 0
					setCycle: CT 5 1 self
				)
				(if (client tryAttack: (client opponent:))
					(client ateEgo: 1)
				)
			)
			(3
				(if (client ateEgo:)
					(client doDamage: (client opponent:) ateEgo: 0)
				)
				(client cycleSpeed: 1 setCycle: CT 1 1 self)
			)
			(4
				(= state 0)
				(if (= local0 (- 1 local0))
					(client setCycle: CT 8 1 self)
				else
					(self cue:)
				)
			)
		)
	)
)

(class BackForth of Script
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

(instance saurusTail of Prop
	(properties
		y 139
		x 189
		view 432
		loop 2
		priority 8
	)
)

(instance leftClaw of Prop
	(properties
		y 111
		x 131
		view 432
		loop 3
	)
)

(instance rightClaw of Prop
	(properties
		y 98
		x 175
		view 432
		loop 4
		priority 8
	)
)

(instance saTailScript of BackForth ; UNUSED
	(properties)
)

(instance lfClawScript of BackForth ; UNUSED
	(properties)
)

(instance rtClawScript of BackForth ; UNUSED
	(properties)
)

