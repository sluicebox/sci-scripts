;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Bar)
(use Combatant)
(use n065)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	warrior 0
	spellObj 1
)

(local
	[warAngles 9] = [0 0 2 2 2 0 1 1 1]
	[warActions 9] = [2 1 1 2 3 3 3 2 1]
	[warLoops 9] = [7 4 5 8 11 10 9 6 3]
	[warAttacks 3] = [8 1 2]
	[warParries 3] = [7 0 3]
	[warDodges 3] = [6 5 4]
)

(class Warrior of Combatant
	(properties
		palette 1
		weaponView 0
		usingSword 0
		aimTime 0
		lastSeconds 0
		restSeconds 0
		oldChecker 0
		attackScript 0
		defenseScript 0
		spellScript 0
	)

	(method (initCombat &tmp warLoad)
		(ClearFlag 1)
		(= strength [gEgoStats 0]) ; strength
		(= intell [gEgoStats 1]) ; intelligence
		(= agil [gEgoStats 2]) ; agility
		(= vit [gEgoStats 3]) ; Vitality
		(= luck [gEgoStats 4]) ; luck
		(= weap [gEgoStats 5]) ; weapon-use
		(= parry [gEgoStats 6]) ; parry
		(= dodge [gEgoStats 7]) ; dodge
		(= magic [gEgoStats 12]) ; magic use
		(= stamina [gEgoStats 17]) ; stamina
		(= health [gEgoStats 16]) ; health
		(= mana [gEgoStats 18]) ; mana
		(= shieldValue 0)
		(if (gEgo has: 7) ; Shield
			(= shieldValue 10)
		)
		(= armorEnc (/ (= warLoad (WtCarried)) 2))
		(if (> warLoad (MaxLoad))
			(= armorEnc warLoad)
		)
		(= armorValue 0)
		(cond
			((gEgo has: 15) ; ChainMail
				(= armorValue 5)
			)
			((gEgo has: 6) ; Leather
				(= armorValue 3)
			)
		)
		(cond
			((and (gEgo has: 31) opponent (== (opponent view:) 345)) ; Soulforge
				(= type 52)
				(= weaponView 80)
				(= palette 2)
				(= weapValue 15)
			)
			((or (gEgo has: 24) (gEgo has: 31)) ; FineSword, Soulforge
				(= type 51)
				(= weaponView 80)
				(= palette 1)
				(= weapValue 10)
			)
			((gEgo has: 4) ; Sword
				(= type 51)
				(= weaponView 80)
				(= palette 1)
				(= weapValue 8)
			)
			((gEgo has: 56) ; SilverDagger
				(= type 50)
				(= weaponView 81)
				(= weapValue 7)
			)
			((gEgo has: 5) ; Dagger
				(= type 50)
				(= weaponView 81)
				(= weapValue 5)
			)
			(else
				(= type 50)
				(= weaponView 81)
				(= weapValue 0)
			)
		)
		(= oldChecker gSpellChecker)
		(= gSpellChecker combatChecker)
		(if (and (not shieldValue) (== weaponView 80))
			(= weaponView 81)
			(+= palette 1)
		)
		(= view weaponView)
		(= cel (= loop 0))
		(= hurtScript warriorHurt)
		(= attackScript egoAttacks)
		(= defenseScript egoDefends)
		(= spellScript egoSpells)
		(= deathScript warriorDeath)
		(super initCombat: &rest)
		(gDirectionHandler add: self)
	)

	(method (endCombat)
		(self setScript: 0)
		(= [gEgoStats 16] health) ; health
		(= [gEgoStats 17] stamina) ; stamina
		(= [gEgoStats 18] mana) ; mana
		(= gSpellChecker oldChecker)
		(SetFlag 1)
		(gDirectionHandler delete: self)
		(super endCombat: &rest)
	)

	(method (doit &tmp thisSeconds)
		(= thisSeconds (GetTime 1)) ; SysTime12
		(if (!= lastSeconds thisSeconds)
			(= lastSeconds thisSeconds)
			(if (!= action 1)
				(++ restSeconds)
			)
		)
		(if (not canFight)
			(= nextMove -1)
		)
		(if (and (== action 0) (!= nextMove -1))
			(= action nextMove)
			(if (OneOf action 23 22 21 25 27 29)
				(= nextMove -1)
				(self setScript: spellScript 0 action)
				(= action 6)
			else
				(= attDirection [warAngles nextMove])
				(= action [warActions nextMove])
				(= loop [warLoops nextMove])
				(= cel 0)
				(= nextMove -1)
				(switch action
					(1
						(self setScript: attackScript 0 restSeconds)
						(= restSeconds 0)
					)
					(2
						(self setScript: defenseScript)
					)
					(3
						(self setScript: defenseScript)
					)
					(else
						(= action 0)
					)
				)
			)
		)
		(super doit:)
	)

	(method (attackLevel bonus)
		(if (== attDirection 0)
			(+= bonus 10)
		)
		(-= bonus (* gLostSleep 10))
		(super attackLevel: bonus)
	)

	(method (defenseLevel bonus)
		(if (and (== action 1) (== attDirection 0))
			(-= bonus 5)
		)
		(-= bonus (* gLostSleep 10))
		(super defenseLevel: bonus)
	)

	(method (setHealth amount)
		(= [gEgoStats 16] amount) ; health
		(super setHealth: amount)
	)

	(method (setStamina amount)
		(= [gEgoStats 17] amount) ; stamina
		(super setStamina: amount)
		(if (<= stamina 0)
			(gCurRoom notify: 60)
		)
	)

	(method (handleEvent event &tmp temp0 [temp1 2] temp3 temp4)
		(= temp3 (event type:))
		(cond
			((super handleEvent: event))
			((not canFight)
				(event claimed: 1)
			)
			((== temp3 $0040) ; direction
				(event claimed: 1)
				(if (User controls:)
					(= nextMove (event message:))
					(while ((= temp0 (Event new:)) type:)
						(temp0 dispose:)
					)
					(temp0 dispose:)
				)
			)
			((== temp3 evSAID)
				(cls)
				(cond
					((Said 'look,look')
						(HighPrint 32 0) ; "Quit sightseeing and watch what you're doing!"
					)
					(
						(or
							(Said 'attack,kill,hit,cut')
							(Said 'use/blade,dagger,weapon')
						)
						(= nextMove [warAttacks (Random 0 2)])
					)
					((or (Said 'parry,defend,block') (Said 'use/shield'))
						(= nextMove [warParries (Random 0 2)])
					)
					((Said 'dodge,hop')
						(= nextMove [warDodges (Random 0 2)])
					)
					((Said 'throw')
						(HighPrint 32 1) ; "You're too close."
					)
					((Said 'escape,escape,(run<away)')
						(gCurRoom notify: 59)
					)
					((Said 'cast>')
						(= temp4 (SaidSpell event))
						(cond
							(shieldValue
								(HighPrint 32 2) ; "The large amount of metal in your shield makes spell-casting impossible."
							)
							((TrySpell temp4)
								(= nextMove temp4)
								(self setMana: [gEgoStats 18]) ; mana
							)
						)
					)
					(else
						(event claimed: 1)
						(HighPrint 32 3) ; "You don't have time for that."
					)
				)
			)
		)
	)

	(method (drawStatus)
		(super drawStatus: &rest)
		(if (not barMessage)
			(return)
		)
		((= barStamina (Bar new:))
			x: barX
			y: (+ barY 34)
			cel: 1
			priority: 10
			max: (self calcStamina:)
			value: stamina
			init:
		)
		(if magic
			((= barMana (Bar new:))
				x: barX
				y: (+ barY 48)
				cel: 2
				priority: 10
				max: (self calcMana:)
				value: mana
				init:
			)
		)
	)
)

(instance warrior of Warrior
	(properties
		x 120
		y 110
		barMessage {Hero}
	)
)

(instance egoAttacks of HandsOffScript
	(properties)

	(method (changeState newState &tmp opp attBonus)
		(switch (= state newState)
			(0
				(client forceUpd:)
				(= cycles 1)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(= cycles 2)
				(= opp (client opponent:))
				(if (> register 5)
					(= register 5)
				)
				(= attBonus (- (* register 30) 50))
				(TrySkill 5 0 attBonus) ; weapon-use
				(client getTired: 5)
				(if (and client (client tryAttack: opp attBonus))
					(client doDamage: opp)
				)
			)
			(3
				(client setCycle: Beg self)
			)
			(4
				(client action: 0 setLoop: 0)
				(self dispose:)
			)
		)
	)
)

(instance egoDefends of HandsOffScript
	(properties)

	(method (doit &tmp waitingMove)
		(= waitingMove (client nextMove:))
		(cond
			((or (!= state 2) (== waitingMove -1))
				(super doit:)
			)
			(
				(and
					(== [warActions waitingMove] (client action:))
					(== [warLoops waitingMove] (client loop:))
				)
				(= cycles 7)
				(client nextMove: -1)
			)
			(else
				(= seconds 0)
				(self cue:)
			)
		)
	)

	(method (changeState newState &tmp opp)
		(switch (= state newState)
			(0
				(client forceUpd:)
				(= cycles 1)
			)
			(1
				(TrySkill (if (== (client action:) 2) 6 else 7) 0 20)
				(client setCycle: End self getTired: 2)
			)
			(2
				(= cycles 7)
			)
			(3
				(client setCycle: Beg self)
			)
			(4
				(client action: 0 setLoop: 0)
				(self dispose:)
			)
		)
	)
)

(instance egoSpells of HandsOffScript
	(properties)

	(method (dispose)
		(client view: (client weaponView:))
		(super dispose:)
	)

	(method (changeState newState &tmp theSound wpnType)
		(switch (= state newState)
			(0
				(client
					view: 82
					setLoop: 0
					setCel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1
				(= cycles 3)
				(switch register
					(23
						(= theSound 31)
					)
					(22
						(= theSound 22)
					)
					(21
						(= theSound 31)
					)
					(25
						(spellObj
							loop: 5
							cel: 0
							setPri: (+ ((client opponent:) priority:) 1)
							init:
							setCycle: End self
						)
						(= cycles 0)
						(= theSound 14)
					)
					(27
						(spellObj
							loop: 7
							cel: 0
							setPri: (+ ((client opponent:) priority:) 1)
							init:
							setCycle: End self
						)
						(= cycles 0)
						(= theSound 16)
					)
					(29
						(= theSound 34)
					)
					(else
						(= theSound 0)
					)
				)
				(if theSound
					(gMiscSound number: theSound loop: 1 priority: 12 play:)
				)
			)
			(2
				(switch register
					(23
						(= gZapPower (+ 5 (/ [gEgoStats 23] 10))) ; zapSpell
						(= theSound 31)
						(HighPrint 32 4) ; "Your weapon is now magically charged."
					)
					(22
						(if (not ((client opponent:) dazzleMe:))
							(HighPrint 32 5) ; "Your Dazzle spell doesn't seem to have had any effect on your opponent."
						)
					)
					(21
						(if (not ((client opponent:) triggerMe:))
							(HighPrint 32 6) ; "That doesn't seem to have done much of anything. There must not have been a spell to Trigger."
						)
					)
					(25
						(spellObj dispose:)
						(= wpnType (client type:))
						(client type: 25)
						((client opponent:)
							hurtMe: (+ 5 (/ [gEgoStats 25] 3)) client ; flameDartSpell
						)
						(client type: wpnType)
					)
					(27
						(spellObj dispose:)
						(= wpnType (client type:))
						(client type: 27)
						((client opponent:)
							hurtMe: (+ 3 (/ [gEgoStats 27] 4)) client ; forceBoltSpell
						)
						(client type: wpnType)
					)
					(29
						(SetFlag 86)
						(= gReversalTimer [gEgoStats 29]) ; invisibility
						(HighPrint 32 7) ; "You are now protected by the power of Reversal."
					)
				)
				(if client
					(client cycleSpeed: (- 3 gArcadeLevel) setCycle: Beg self)
				else
					(= caller 0)
					(self dispose:)
				)
			)
			(3
				(client
					view: (client weaponView:)
					setLoop: 0
					cel: 0
					action: 0
					canFight: 1
				)
				(self dispose:)
			)
		)
	)
)

(instance spellObj of Prop
	(properties
		x 160
		y 80
		z 1
		view 32
		signal 26640
	)
)

(instance combatChecker of Code
	(properties)

	(method (doit spellNum)
		(if (OneOf spellNum 22 23 21 25 27 29)
			(return 1)
		else
			(HighPrint 32 8) ; "As you know, that spell is not usable in combat. Casting it would leave you open to attack."
			(return 0)
		)
	)
)

(instance warriorHurt of HandsOffScript
	(properties)

	(method (changeState newState &tmp combScr)
		(switch (= state newState)
			(0
				(client
					canFight: 0
					action: 7
					nextMove: 0
					setCycle: 0
					setLoop: 1
					setCel: 0
				)
				(= cycles 2)
			)
			(1
				(client setCel: 1)
				(= cycles
					(switch gArcadeLevel
						(1 2)
						(2 4)
						(3 6)
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

(instance warriorDeath of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					canFight: 0
					action: 0
					setLoop: 2
					setCel: 0
					cycleSpeed: 0
				)
				(= cycles 2)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(if (not (gCurRoom notify: 61))
					(EgoDead 0 32 9 #title {What a monster!} #icon 999 1 5) ; "It was a tough battle, and you lost. Never fear! All you have to do is restore your game, and... What do you mean, "Restore WHAT game?""
				)
				(self dispose:)
			)
		)
	)
)

