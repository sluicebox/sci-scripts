;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 218)
(include sci.sh)
(use Main)
(use Skilled_J_X_L_________________________B)
(use Inventory)

(public
	fighter 0
)

(class Fighter of Skilled_J_X_L_________________________B
	(properties
		fighterView 501
		endFight 0
		baseX 187
		baseY 150
	)

	(method (init)
		(= strength [gEgoStats 0]) ; strength
		(= intell [gEgoStats 1]) ; intelligence
		(= agil [gEgoStats 2]) ; agility
		(= vit [gEgoStats 3]) ; vitality
		(= luck [gEgoStats 4]) ; luck
		(= weap [gEgoStats 5]) ; weapon-use
		(= parry [gEgoStats 6]) ; parry
		(= dodge [gEgoStats 7]) ; dodge
		(= magic [gEgoStats 12]) ; magic
		(= stamina [gEgoStats 15]) ; stamina
		(= health [gEgoStats 14]) ; health
		(= mana [gEgoStats 16]) ; mana
		(super init: &rest)
	)

	(method (drawWeapons)
		(= baseX (opponent warriorX:))
		(= baseY (opponent warriorY:))
		(if (gEgo has: 9) ; shield
			(= shieldValue 10)
		)
		(= armorEnc (/ (WtCarried) 2))
		(= armorValue 0)
		(cond
			((gEgo has: 33) ; chainmail
				(= armorValue 5)
			)
			((gEgo has: 8) ; leather
				(= armorValue 3)
			)
		)
		(self weapValue: 8)
		(self ignoreActors: 1 view: fighterView posn: baseX baseY stopUpd:)
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

	(method (getHit)
		(if fightLeft
			(self x: (+ (self x:) 3))
			((self opponent:) x: (+ ((self opponent:) x:) 3))
		else
			(self x: (- (self x:) 3))
			((self opponent:) x: (- ((self opponent:) x:) 3))
		)
	)

	(method (gotBeat param1)
		(self endFight: 1)
		(self setScript: param1)
	)

	(method (getTired param1 param2)
		(if (<= (-= stamina param1) 0)
			(= stamina 0)
			(self endFight: 1)
			(self setScript: param2)
		)
		(= [gEgoStats 15] stamina) ; stamina
	)
)

(instance fighter of Fighter
	(properties)
)

