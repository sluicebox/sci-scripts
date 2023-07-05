;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 213)
(include sci.sh)
(use Main)
(use StatusBar)
(use SkilledActor)
(use n814)

(public
	warrior 0
)

(class Warrior of SkilledActor
	(properties
		yStep 10
		view 109
		xStep 16
		heroTitle 0
		egoHP 0
		egoSP 0
		egoMP 0
		usingSword 0
		noWeapon 0
		baseX 0
		baseY 0
	)

	(method (dispose)
		(ClearFlag 248)
		(gGame setCursor: gNormalCursor 1)
		(ClearFlag 284)
		(if egoMP
			(egoMP dispose:)
			(= egoMP 0)
		)
		(egoSP dispose:)
		(egoHP dispose:)
		(= heroTitle (= egoHP (= egoSP 0)))
		(super dispose:)
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
		(self ignoreActors:)
		(= stamina [gEgoStats 15]) ; stamina
		(= health [gEgoStats 14]) ; health
		(= mana [gEgoStats 16]) ; mana
		(super init: &rest)
	)

	(method (drawStatus)
		((= egoHP (StatusBar new:))
			x: 34
			y: 28
			titleCel: 0
			priority: 1
			max: (MaxHealth)
			value: health
			init:
		)
		((= egoSP (StatusBar new:))
			x: 34
			y: 39
			titleCel: 1
			priority: 1
			max: (MaxStamina)
			value: [gEgoStats 15] ; stamina
			init:
		)
		(if [gEgoStats 12] ; magic
			((= egoMP (StatusBar new:))
				x: 34
				y: 50
				titleCel: 2
				priority: 1
				max: (MaxMana)
				value: [gEgoStats 16] ; mana
				init:
			)
		)
	)

	(method (drawWeapons &tmp temp0)
		(= baseX (opponent warriorX:))
		(= baseY (opponent warriorY:))
		(if (gEgo has: 5) ; shield
			(= shieldValue 10)
		else
			(= shieldValue 0)
		)
		(= armorEnc (/ (= temp0 (WtCarried)) 2))
		(if (> temp0 (MaxLoad))
			(= armorEnc temp0)
		)
		(= armorValue 0)
		(cond
			((gEgo has: 3) ; chainMail
				(= armorValue 5)
			)
			((gEgo has: 4) ; leather
				(= armorValue 3)
			)
		)
		(cond
			((gEgo has: 2) ; sword
				(self view: 109 weapValue: 8)
			)
			((gEgo has: 6) ; dagger
				(switch global279
					(440 1)
					(435 1)
					(420
						(+= baseY 8)
					)
					(430
						(+= baseX 8)
						(+= baseY 5)
					)
					(450
						(+= baseX 12)
					)
					(455
						(+= baseY 4)
						(+= baseX 8)
					)
					(480
						(+= baseX 7)
					)
					(445
						(+= baseX 6)
						(-= baseY 7)
					)
					(465
						(+= baseX 12)
						(+= baseY 2)
					)
					(460
						(+= baseX 8)
						(+= baseY 10)
					)
					(else
						(+= baseX 20)
						(+= baseY 10)
					)
				)
				(self view: 102 weapValue: 5)
			)
			(else
				(= noWeapon 1)
				(self view: 117 loop: 0 cel: 0 forceUpd:)
			)
		)
		(self ignoreActors: 1 cel: 0 setPri: 13 posn: baseX baseY stopUpd:)
	)

	(method (startCombat param1)
		(self setScript: (ScriptID param1 0))
	)

	(method (setEgoHP param1)
		(= [gEgoStats 14] param1) ; health
		(if egoHP
			(egoHP value: param1 draw:)
		)
	)

	(method (setEgoSP param1)
		(= [gEgoStats 15] param1) ; stamina
		(if egoSP
			(egoSP value: param1 draw:)
		)
	)

	(method (setEgoMP param1)
		(= mana param1)
		(if egoMP
			(egoMP value: param1 draw:)
		)
	)

	(method (getHurt param1)
		(TakeDamage param1)
		(super getHurt: param1)
		(if (> stamina 0)
			(if (script script:)
				((script script:) dispose:)
			)
			((ScriptID 215 1) dispose:) ; aSpell
			((ScriptID 215 3) dispose:) ; blood
			((ScriptID 215 4) dispose:) ; zapCrap
			(script setScript: (ScriptID 155 0)) ; painReaction
		else
			(self setEgoHP: health)
		)
	)

	(method (getTired param1)
		(UseStamina param1)
		(super getTired: param1)
		(self setEgoSP: stamina)
	)

	(method (die)
		(SetFlag 248)
	)
)

(instance warrior of Warrior
	(properties)
)

