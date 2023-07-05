;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 685)
(include sci.sh)
(use Main)
(use battleSound)
(use Motion)
(use System)

(public
	ghoul 0
)

(local
	[ghoulAngles 3] = [0 0 2]
)

(instance ghoul of Monster
	(properties
		x 169
		y 116
		noun '/ghoul,monster,creature'
		description {the Ghoul}
		lookStr {Supernatural creatures of the undead which prey upon the living.}
		yStep 3
		view 685
		priority 5
		xStep 5
		strength 60
		intell 50
		agil 120
		vit 80
		luck 50
		weap 70
		dodge 80
		armorValue 4
		weapValue 5
		barMessage {Ghoul}
		battleMusic 52
		endMusic 53
	)

	(method (initCombat)
		(= combatScript ghoulScript)
		(= deathScript ghoulDeath)
		(super initCombat: &rest)
	)
)

(instance ghoulScript of Script
	(properties)

	(method (changeState newState &tmp opp theLoop)
		(switch (= state newState)
			(0
				(= cycles 4)
			)
			(1
				(= theLoop (Random 3 5))
				(client
					action: 1
					attDirection: [ghoulAngles (- theLoop 3)]
					setLoop: theLoop
					cel: 0
				)
				(= cycles (+ (* 3 (- 3 gArcadeLevel)) (Random 5 15)))
			)
			(2
				(client setCycle: End self)
			)
			(3
				(= opp (client opponent:))
				(if (and (== (client action:) 1) (client tryAttack: opp 0))
					(client doDamage: opp 5 0)
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

(instance ghoulDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					canFight: 0
					action: 0
					setLoop: (if (== 0 (Random 0 3)) 6 else 2)
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(self dispose:)
				(gCurRoom notify: 58)
			)
		)
	)
)

