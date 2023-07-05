;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 213)
(include sci.sh)
(use Main)
(use StatusBar)
(use Skilled)
(use Inventory)
(use Actor)

(public
	warrior 0
)

(class Warrior of Skilled
	(properties
		yStep 10
		xStep 16
		heroTitle 0
		egoHP 0
		egoSP 0
		egoMP 0
		weaponView 540
		egosBack 0
		egoShield 0
		egoHand 0
		usingSword 0
		noWeapon 0
		baseX 190
		baseY 190
	)

	(method (dispose)
		(if egoMP
			(egoMP dispose:)
			(= egoMP 0)
		)
		(if heroTitle
			(egoSP dispose:)
			(egoHP dispose:)
			(Display 213 0 dsRESTOREPIXELS heroTitle)
			(= heroTitle (= egoHP (= egoSP 0)))
		)
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
		(= stamina [gEgoStats 15]) ; stamina
		(= health [gEgoStats 14]) ; health
		(= mana [gEgoStats 16]) ; mana
		(super init: &rest)
	)

	(method (drawStatus)
		(= heroTitle
			(Display 213 1 dsWIDTH 80 dsCOORD 13 13 dsALIGN alLEFT dsFONT 300 dsCOLOR global303 dsSAVEPIXELS) ; "Hero Status"
		)
		((= egoHP (StatusBar new:))
			x: 25
			y: 33
			titleCel: 0
			priority: 1
			max: (MaxHealth)
			value: health
			init:
		)
		((= egoSP (StatusBar new:))
			x: 25
			y: 47
			titleCel: 1
			priority: 1
			max: (MaxStamina)
			value: [gEgoStats 15] ; stamina
			init:
		)
		(if [gEgoStats 12] ; magic
			((= egoMP (StatusBar new:))
				x: 25
				y: 61
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
		(= shieldValue (= egoShield 0))
		(if (gEgo has: 9) ; shield
			(= shieldValue 10)
			((= egoShield aShield)
				setLoop: 1
				setCel: 0
				setPri: 14
				x: (- baseX 74)
				y: baseY
				ignoreActors: 1
				init:
				stopUpd:
			)
		else
			(= shieldValue 0)
			((= egoHand aHand)
				setLoop: 1
				setCel: 0
				setPri: 14
				x: (- baseX 73)
				y: baseY
				ignoreActors: 1
				init:
				stopUpd:
			)
		)
		((= egosBack closeupEgo)
			setLoop: 0
			setCel: 0
			setPri: 15
			x: (- baseX 41)
			y: baseY
			ignoreActors: 1
			init:
			stopUpd:
		)
		(= armorEnc (/ (= temp0 (WtCarried)) 2))
		(if (> temp0 (MaxLoad))
			(= armorEnc temp0)
		)
		(= armorValue 0)
		(cond
			((gEgo has: 33) ; chainmail
				(= armorValue 5)
			)
			((gEgo has: 8) ; leather
				(= armorValue 3)
			)
		)
		(cond
			((gEgo has: 6) ; blade
				(= weaponView 540)
				(self weapValue: 8)
			)
			((gEgo has: 7) ; dagger
				(= weaponView 535)
				(self weapValue: 5)
			)
			(else
				(= weaponView 535)
				(= noWeapon 1)
			)
		)
		(self
			illegalBits: 0
			ignoreActors: 1
			view: weaponView
			setLoop: (if noWeapon 0 else 2)
			cel: 0
			setPri: 11
			posn: baseX baseY
			stopUpd:
		)
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
		(self setEgoHP: health)
		(cond
			((not (script script:))
				(script setScript: (ScriptID 155 0)) ; painReaction
			)
			((or (IsFlag 248) (<= health 0))
				(Animate (gCast elements:) 0)
				(EgoDead 213 2 80 {What a monster!} 82 516 0 9) ; "It was a tough battle, and you lost. Never fear! All you have to do is restore your game, and... What do you mean, "Restore WHAT game?""
			)
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

(instance aShield of View
	(properties
		view 540
	)
)

(instance aHand of Prop
	(properties
		view 535
	)
)

(instance closeupEgo of View
	(properties
		view 540
	)
)

