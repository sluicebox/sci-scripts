;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 273)
(include sci.sh)
(use Main)
(use battleSound)
(use Motion)
(use System)

(public
	badGuy 0
)

(local
	[eofAngles 6] = [0 0 2 1 0 2]
	[eofActions 6] = [1 1 1 2 2 2]
)

(instance badGuy of Monster
	(properties
		x 178
		y 137
		noun '/fighter,fighter,swordsman'
		description {the bloodthirsty swordsman}
		lookStr {The flailing, bloodthirsty swordsman looks like he means business.}
		view 273
		loop 9
		priority 5
		strength 130
		intell 60
		agil 140
		vit 140
		luck 80
		weap 100
		parry 80
		dodge 20
		armorValue 2
		weapValue 8
		battleMusic 52
		endMusic 53
	)

	(method (initCombat)
		(= combatScript eofScript)
		(super initCombat: &rest)
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

(instance eofScript of Script
	(properties)

	(method (changeState newState &tmp opp act energy theLoop)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(client action: 0 setLoop: 0 setCel: 0)
				(= cycles (Random 4 10))
			)
			(2
				(if (<= (Random 1 100) 80)
					(= theLoop (Random 3 5))
				else
					(= theLoop (Random 6 8))
				)
				(client
					action: [eofActions (- theLoop 3)]
					attDirection: [eofAngles (- theLoop 3)]
					setLoop: theLoop
					setCel: 0
				)
				(= cycles (+ (Random 4 10) (* 4 (- 3 gArcadeLevel))))
			)
			(3
				(client setCycle: End self)
			)
			(4
				(if (== (= act (client action:)) 1)
					(= energy 15)
				else
					(= energy 8)
				)
				(= opp (client opponent:))
				(if (and (== act 1) (client tryAttack: opp 0))
					(client doDamage: opp 0 0)
				)
				(client getTired: energy client)
				(= cycles 1)
			)
			(5
				(self changeState: 1)
			)
		)
	)
)

