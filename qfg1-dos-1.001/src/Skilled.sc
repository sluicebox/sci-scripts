;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 212)
(include sci.sh)
(use Main)
(use Actor)

(class Skilled of Act
	(properties
		strength 0
		intell 0
		agil 0
		vit 0
		luck 0
		weap 0
		parry 0
		dodge 0
		magic 0
		stamina 0
		health 0
		mana 0
		armorValue 0
		armorEnc 0
		shieldValue 0
		weapValue 0
		canFight 0
		action 0
		opponent 0
		fightLeft 0
	)

	(method (init)
		(= canFight (= action 0))
		(super init: &rest)
	)

	(method (calcHealth &tmp temp0)
		(return (* 2 (= temp0 (/ (+ strength vit vit) 3))))
	)

	(method (calcStamina)
		(return (* (+ agil vit) 2))
	)

	(method (calcMana)
		(if magic
			(return (/ (+ intell magic magic) 3))
		else
			(return 0)
		)
	)

	(method (attackLevel &tmp temp0)
		(= temp0 (/ (+ (* weap 8) (* agil 4) strength strength intell luck) 16))
		(if (<= stamina 30)
			(-= temp0 10)
			(if (<= stamina 10)
				(-= temp0 20)
			)
		)
		(-= temp0 (* global268 10))
		(if (== action 1)
			(+= temp0 10)
		)
		(return temp0)
	)

	(method (defenseLevel &tmp temp0 temp1 temp2)
		(= temp0 (- (/ (+ (* agil 5) intell intell luck) 8) armorEnc))
		(if (<= stamina 30)
			(-= temp0 5)
			(if (<= stamina 10)
				(-= temp0 10)
			)
		)
		(-= temp0 (* global268 10))
		(= temp1 (= temp2 0))
		(if parry
			(= temp1 (+ parry shieldValue (/ agil 10)))
		)
		(if dodge
			(= temp2 (+ dodge (/ agil 5)))
		)
		(switch action
			(1
				(-= temp0 5)
			)
			(3
				(+= temp0 temp1)
			)
			(4
				(+= temp0 temp1)
			)
			(5
				(+= temp0 temp2)
			)
			(6
				(+= temp0 temp2)
			)
		)
		(return temp0)
	)

	(method (tryAttack param1 &tmp temp0)
		(cond
			(
				(>
					(= temp0
						(+ (- (self attackLevel:) (param1 defenseLevel:)) 50)
					)
					95
				)
				(= temp0 95)
			)
			((< temp0 5)
				(= temp0 5)
			)
		)
		(if (>= temp0 (Random100))
			(return 1)
		else
			(return 0)
		)
	)

	(method (doDamage param1 param2 &tmp temp0)
		(= temp0
			(+
				(- (+ weapValue (/ strength 10)) (param1 armorValue:))
				(Random 1 6)
			)
		)
		(if (>= argc 2)
			(+= temp0 param2)
		)
		(if (< temp0 0)
			(= temp0 0)
		else
			(param1 getHurt: temp0)
		)
		(return temp0)
	)

	(method (getHurt param1)
		(if (< (-= health param1) 0)
			(= health 0)
		)
		(if (> health (self calcHealth:))
			(= health (self calcHealth:))
		)
		(if (== health 0)
			(self die:)
		)
	)

	(method (getTired param1)
		(if (< (-= stamina param1) 0)
			(self getHurt: (/ (- 0 stamina) 2))
			(= stamina 0)
		)
	)

	(method (die)
		(opponent canFight: 0)
		(self setScript: 0)
		(= canFight 0)
		(= action 10)
	)
)

