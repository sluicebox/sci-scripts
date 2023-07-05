;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 675)
(include sci.sh)
(use Main)
(use battleSound)
(use Motion)
(use System)

(public
	tSaurus 0
)

(local
	prevRExit
)

(instance tSaurus of Monster
	(properties
		x 173
		y 110
		noun '/saurii,dinosaur,monster,creature'
		description {the TerrorSaurus}
		lookStr {The Terrorsaurus are extremely quick-footed creatures.}
		yStep 3
		view 675
		priority 5
		xStep 5
		strength 150
		intell 50
		agil 120
		vit 150
		luck 100
		weap 180
		armorValue 5
		weapValue 8
		barX 235
		barMessage {TerrorSaurus}
		chaseDelay 3
		attackRange 100
		battleMusic 54
		endMusic 55
	)

	(method (initCombat)
		(= combatScript saurScript)
		(= weap (+ [gEgoStats 5] 40)) ; weapon-use
		(super initCombat: &rest)
	)
)

(instance saurScript of Script
	(properties)

	(method (changeState newState &tmp opp theLoop)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(= theLoop (Random 4 5))
				(client
					action: 1
					attDirection: (if (== theLoop 4) 1 else 0)
					setLoop: theLoop
					cel: 0
				)
				(= cycles (Random 5 15))
			)
			(2
				(client cycleSpeed: 1 setCycle: End self)
			)
			(3
				(= opp (client opponent:))
				(if (client tryAttack: opp 0)
					(client doDamage: opp 0 1)
				)
				(= cycles 2)
			)
			(4
				(client cycleSpeed: 1 setCycle: Beg self)
			)
			(5
				(client action: 0 setLoop: 0)
				(self changeState: 1)
			)
		)
	)
)

