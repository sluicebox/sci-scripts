;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 680)
(include sci.sh)
(use battleSound)
(use Motion)
(use System)

(public
	brigand 0
)

(local
	[brigAngles 8] = [0 0 2 1 0 2 1 0]
	[brigActions 8] = [1 1 1 2 2 2 3 3]
)

(instance brigand of Monster
	(properties
		x 164
		y 117
		noun '/bandit,monster,creature'
		description {the Brigand.}
		lookStr {Tough fighting Brigands roam the desert in search for unwary travelers to waylay.}
		yStep 3
		view 680
		priority 5
		xStep 5
		strength 80
		intell 80
		agil 80
		vit 60
		luck 80
		weap 80
		parry 60
		dodge 50
		armorValue 2
		weapValue 5
		barMessage {Brigand}
	)

	(method (initCombat)
		(= combatScript brigandScript)
		(super initCombat: &rest)
	)
)

(instance brigandScript of Script
	(properties)

	(method (changeState newState &tmp opp theLoop)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(= theLoop (Random 3 10))
				(client
					action: [brigActions (- theLoop 3)]
					attDirection: [brigAngles (- theLoop 3)]
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
					(client doDamage: opp 0 1)
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

