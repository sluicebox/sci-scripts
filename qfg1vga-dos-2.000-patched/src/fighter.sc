;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 218)
(include sci.sh)
(use Main)
(use SkilledActor)
(use n814)

(public
	fighter 0
)

(class Fighter of SkilledActor
	(properties
		fighterView 501
		endFight 0
		baseX 187
		baseY 135
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
		(= baseY 135)
		(if (gEgo has: 5) ; shield
			(= shieldValue 10)
		)
		(= armorEnc (/ (WtCarried) 2))
		(= armorValue 0)
		(cond
			((gEgo has: 3) ; chainMail
				(= armorValue 5)
			)
			((gEgo has: 4) ; leather
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

	(method (attackLevel &tmp temp0 [temp1 20])
		(= temp0 (/ (+ (* weap 8) (* agil 4) strength strength intell luck) 16))
		(if (<= stamina 30)
			(-= temp0 10)
			(if (<= stamina 10)
				(-= temp0 20)
			)
		)
		(-= temp0 (* global247 10))
		(if (== action 1)
			(+= temp0 10)
		)
		(return temp0)
	)

	(method (getHit)
		(if fightLeft
			(self x: (+ (self x:) 3) forceUpd:)
			((self opponent:)
				posn: (+ ((self opponent:) x:) 3) ((self opponent:) y:)
			)
		else
			(self x: (- (self x:) 3) forceUpd:)
			((self opponent:)
				posn: (- ((self opponent:) x:) 3) ((self opponent:) y:)
			)
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

