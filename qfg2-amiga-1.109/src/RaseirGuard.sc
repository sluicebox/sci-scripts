;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 381)
(include sci.sh)
(use battleSound)
(use Motion)
(use System)

(local
	[rasAngles 8] = [0 0 2 1 0 2 0 2]
	[rasActions 8] = [1 1 1 2 2 2 3 3]
)

(class RaseirGuard of Monster
	(properties
		view 381
		priority 10
		strength 65
		intell 40
		agil 80
		vit 60
		luck 60
		weap 70
		parry 60
		dodge 40
		armorValue 8
		armorEnc 8
		shieldValue 8
		weapValue 8
		battleMusic 52
		endMusic 53
	)

	(method (initCombat)
		(= noun '/fighter,fighter,swordsman,guard')
		(= description {the bloodthirsty guard})
		(= lookStr
			{The flailing, bloodthirsty guard looks like he means business.}
		)
		(= combatScript rasGuardScript)
		(super initCombat: &rest)
	)
)

(instance rasGuardScript of Script
	(properties)

	(method (changeState newState &tmp opp theLoop)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(= theLoop (Random 3 10))
				(client
					action: [rasActions (- theLoop 3)]
					attDirection: [rasAngles (- theLoop 3)]
					setLoop: theLoop
					cel: 0
					setCycle: End self
				)
			)
			(2
				(= opp (client opponent:))
				(if (and (== (client action:) 1) (client tryAttack: opp 0))
					(client doDamage: opp 0 1)
				)
				(= cycles 2)
			)
			(3
				(client setCycle: Beg self)
			)
			(4
				(client action: 0 setLoop: 0)
				(self changeState: 1)
			)
		)
	)
)

