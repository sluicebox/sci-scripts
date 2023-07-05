;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 171)
(include sci.sh)
(use battleSound)
(use Motion)
(use System)

(public
	uhura 0
)

(local
	[uhuAngles 8] = [0 0 2 1 0 2 1 2]
	[uhuActions 8] = [1 1 1 2 2 2 3 3]
)

(instance uhura of Monster
	(properties
		x 178
		y 137
		view 171
		priority 5
		strength 120
		intell 120
		agil 150
		vit 100
		luck 100
		weap 130
		parry 50
		dodge 120
		armorValue 2
		shieldValue 20
		weapValue 6
		battleMusic 171
	)

	(method (initCombat)
		(= combatScript uhuScript)
		(super initCombat: &rest)
		(uhuScript cycles: 0 seconds: 2)
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

(instance uhuScript of Script
	(properties)

	(method (changeState newState &tmp opp theLoop)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= theLoop (Random 3 10))
				(client
					action: [uhuActions (- theLoop 3)]
					attDirection: [uhuAngles (- theLoop 3)]
					setLoop: theLoop
					cel: 0
				)
				(= cycles (Random 5 15))
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

