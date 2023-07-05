;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use Bar)
(use TargActor)
(use Motion)
(use System)

(class Combatant of TargActor
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
		mana 0
		armorValue 0
		armorEnc 0
		shieldValue 0
		weapValue 0
		canFight 0
		action 0
		nextMove -1
		attDirection 0
		opponent 0
		barX 25
		barY 8
		barTitle 0
		barHealth 0
		barStamina 0
		barMana 0
		barMessage 0
		type 53
		mode 55
		combatScript 0
		hurtScript 0
		deathScript 0
	)

	(method (init)
		(= canFight 1)
		(super init: &rest)
	)

	(method (initCombat)
		(= illegalBits (= attDirection (= action 0)))
		(self ignoreActors: drawStatus:)
		(if (not hurtScript)
			(= hurtScript dftHurt)
		)
		(self init: &rest)
		(if combatScript
			(self setScript: combatScript)
		)
	)

	(method (dispose)
		(if (== mode 55)
			(self endCombat:)
		)
		(= opponent 0)
		(super dispose:)
	)

	(method (drawStatus)
		(if (not barMessage)
			(return)
		)
		(= barTitle
			(Display
				barMessage
				dsWIDTH
				80
				dsCOORD
				(- barX 12)
				barY
				dsALIGN
				alLEFT
				dsFONT
				300
				dsCOLOR
				gCombatColor
				dsSAVEPIXELS
			)
		)
		((= barHealth (Bar new:))
			x: barX
			y: (+ barY 20)
			cel: 0
			priority: 10
			max: (self calcHealth:)
			value: health
			init:
		)
	)

	(method (calcHealth &tmp tmpHealth)
		(return (* 2 (= tmpHealth (/ (+ strength vit vit) 3))))
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

	(method (setHealth newValue)
		(= health newValue)
		(if barHealth
			(barHealth value: newValue draw:)
		)
	)

	(method (setStamina newValue)
		(= stamina newValue)
		(if barStamina
			(barStamina value: newValue draw:)
		)
	)

	(method (setMana newValue)
		(= mana newValue)
		(if barMana
			(barMana value: newValue draw:)
		)
	)

	(method (attackLevel bonus &tmp theLevel)
		(= theLevel (/ (+ (* weap 8) (* agil 4) strength strength intell luck) 16))
		(if (<= stamina 50)
			(-= theLevel 10)
			(if (<= stamina 25)
				(-= theLevel 20)
			)
		)
		(+= theLevel bonus)
	)

	(method (defenseLevel bonus &tmp theLevel parryBonus dodgeBonus)
		(= theLevel (- (/ (+ (* agil 5) intell intell luck) 8) armorEnc))
		(if (<= stamina 50)
			(-= theLevel 5)
			(if (<= stamina 25)
				(-= theLevel 10)
			)
		)
		(+= theLevel bonus)
		(= parryBonus (= dodgeBonus 0))
		(if parry
			(= parryBonus (+ parry shieldValue (/ agil 10)))
		)
		(if dodge
			(= dodgeBonus (+ dodge (/ agil 5)))
		)
		(switch action
			(2
				(+= theLevel parryBonus)
			)
			(3
				(+= theLevel dodgeBonus)
			)
			(4
				(+= theLevel dodgeBonus)
			)
		)
		(return theLevel)
	)

	(method (tryAttack monster bonus &tmp toHit)
		(cond
			(
				(>
					(= toHit
						(+
							(-
								(self attackLevel: bonus)
								(monster defenseLevel: 0)
							)
							50
						)
					)
					80
				)
				(= toHit 80)
			)
			((< toHit 20)
				(= toHit 20)
			)
		)
		(if (>= toHit (Random 1 100))
			(return 1)
		else
			(return 0)
		)
	)

	(method (doDamage monster addit realDamage &tmp damage)
		(= damage
			(+
				(- (+ weapValue (/ strength 10)) (monster armorValue:))
				(Random 1 10)
			)
		)
		(if (>= argc 2)
			(+= damage addit)
		)
		(cond
			((< damage 0)
				(= damage 0)
			)
			((or (< argc 3) realDamage)
				(monster hurtMe: damage self)
			)
			(else
				(monster getTired: (+ damage damage) self)
			)
		)
		(return damage)
	)

	(method (hurtMe damage whatHurt)
		(= calmTimer 0)
		(if (< (-= health damage) 0)
			(= health 0)
		)
		(if (> health (self calcHealth:))
			(= health (self calcHealth:))
		)
		(self setHealth: health)
		(cond
			((== health 0)
				(self die:)
			)
			((and (or (< argc 2) (!= whatHurt self)) hurtScript)
				(self setScript: (hurtScript new:))
			)
		)
		(return 1)
	)

	(method (getTired amount whoDunIt &tmp whoHurt)
		(= whoHurt (if (< argc 2) self else whoDunIt))
		(cond
			((< (-= stamina amount) 0)
				(self hurtMe: (/ (- 0 stamina) 2) whoHurt)
				(= stamina 0)
			)
			((and (!= whoHurt self) hurtScript)
				(self setScript: (hurtScript new:))
			)
		)
		(self setStamina: stamina)
	)

	(method (die)
		(self endCombat: setScript: deathScript)
	)

	(method (endCombat)
		(if opponent
			(opponent canFight: 0)
		)
		(self setScript: 0 setCycle: 0 setMotion: 0)
		(= canFight 0)
		(= action 5)
		(if barMana
			(barMana dispose:)
			(= barMana 0)
		)
		(if barStamina
			(barStamina dispose:)
			(= barStamina 0)
		)
		(if barTitle
			(barHealth dispose:)
			(Display 30 0 dsRESTOREPIXELS barTitle)
			(= barHealth (= barStamina (= barTitle 0)))
		)
	)
)

(instance dftHurt of Script
	(properties)

	(method (changeState newState &tmp combScr)
		(switch (= state newState)
			(0
				(client canFight: 0 action: 7 setCycle: 0 setLoop: 1 setCel: 0)
				(= cycles 2)
			)
			(1
				(client setCel: 1)
				(= cycles
					(switch gHowFast
						(0 2)
						(1 4)
						(2 6)
						(3 8)
					)
				)
			)
			(2
				(if (<= (NumCels client) 2)
					(self cue:)
				else
					(client setCycle: End self)
				)
			)
			(3
				(client canFight: 1 action: 0 setLoop: 0)
				(if (= combScr (client combatScript:))
					(client setScript: combScr)
				else
					(self dispose:)
				)
			)
		)
	)
)

