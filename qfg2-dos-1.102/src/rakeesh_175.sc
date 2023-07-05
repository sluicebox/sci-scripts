;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 175)
(include sci.sh)
(use battleSound)
(use Motion)
(use System)

(public
	rakeesh 0
)

(local
	[rakAngles 8] = [0 0 2 1 0 2 1 0]
	[rakActions 8] = [1 1 1 2 2 2 3 3]
)

(instance rakeesh of Monster
	(properties
		x 178
		y 137
		view 175
		priority 5
		strength 150
		intell 125
		agil 80
		vit 100
		luck 100
		weap 150
		parry 150
		dodge 120
		armorValue 2
		shieldValue 20
		weapValue 6
		barMessage {Rakeesh}
		battleMusic 52
		endMusic 53
	)

	(method (initCombat)
		(= combatScript rakScript)
		(super initCombat: &rest)
		(rakScript cycles: 0 seconds: 2)
	)

	(method (hurtMe amount)
		(if (> stamina 0)
			(self getTired: (+ amount amount) &rest)
		else
			(super hurtMe: amount &rest)
		)
		(return 1)
	)
)

(instance rakScript of Script
	(properties)

	(method (changeState newState &tmp opp theLoop)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= theLoop (Random 3 10))
				(client
					action: [rakActions (- theLoop 3)]
					attDirection: [rakAngles (- theLoop 3)]
					setLoop: theLoop
					cel: 0
				)
				(= cycles (Random 3 7))
			)
			(2
				(client setCycle: End self)
			)
			(3
				(= opp (client opponent:))
				(if (and (== (client action:) 1) (client tryAttack: opp 0))
					(client doDamage: opp 0 0)
				)
				(= cycles 2)
			)
			(4
				(client setCycle: Beg self)
			)
			(5
				(client action: 0 setLoop: 0)
				(self changeState: 1)
			)
		)
	)
)

