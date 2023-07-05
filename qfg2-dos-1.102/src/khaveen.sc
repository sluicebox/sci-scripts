;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 475)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TopWindow)
(use battleSound)
(use warrior)
(use n095)
(use Interface)
(use Polygon)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	khaveen 0
	rm470Warrior 1
)

(local
	[kAngles 8] = [1 0 2 1 0 2 0 2]
	[kActions 8] = [1 1 1 2 2 2 3 3]
	kGuy
	egoGuy
	[khaveenPoints 12] = [163 131 221 117 223 125 231 125 232 132 178 150]
	firstYield
	egoHurt
	egoFlipped
	oldHurt
	khaveenHurt
	khaveenDying
	egosGonnaWin
	yieldCounter
	wimpedOut
)

(procedure (KhaveenPrint)
	(LowPrint &rest 35 khaveenWindow 80 {Khaveen:})
)

(instance khaveenWindow of BotWindow
	(properties
		color 7
		back 0
	)
)

(instance khaveen of Monster
	(properties
		x 165
		y 145
		noun '/khaveen,guard,man,captain'
		description {Khaveen}
		lookStr {It is Khaveen.}
		view 475
		strength 125
		intell 125
		agil 125
		vit 125
		luck 125
		weap 125
		parry 125
		dodge 125
		armorValue 5
		armorEnc 20
		shieldValue 20
		weapValue 8
		battleMusic 0
		endMusic 0
	)

	(method (doDamage theOtherGuy)
		(if egosGonnaWin
			(theOtherGuy hurtMe: 0 self)
		else
			(super doDamage: theOtherGuy &rest)
		)
	)

	(method (initCombat)
		(= kGuy self)
		(= combatScript doBattle)
		(super initCombat: &rest)
		(= opponent rm470Warrior)
		(= deathScript doneFight)
	)

	(method (hurtMe)
		(if (== (++ khaveenHurt) 3)
			(self strength: 250 agil: 250)
		)
		(super hurtMe: &rest)
	)
)

(instance doBattle of Script
	(properties)

	(method (changeState newState &tmp opp theLoop)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(if (and egoHurt (not egoFlipped) (!= (rm470Warrior loop:) 1))
					(= egoFlipped 1)
					(= egoHurt 0)
					(rm470Warrior endCombat: setScript: egoFlips)
					(khaveen
						endCombat:
						setScript: 0
						strength: 125
						intell: 125
						agil: 125
						vit: 125
						luck: 125
						weap: 125
						parry: 125
						dodge: 125
						magic: 0
					)
				else
					(switch gArcadeLevel
						(1
							(= cycles (Random 12 15))
						)
						(2
							(= cycles (Random 8 11))
						)
						(3
							(= cycles (Random 4 7))
						)
					)
				)
			)
			(2
				(= theLoop
					(switch ((khaveen opponent:) loop:)
						(0
							(Random 3 5)
						)
						(1 0)
						(2 0)
						(3 6)
						(4 10)
						(5 9)
						(6 3)
						(7 4)
						(8 4)
						(9 3)
						(10 5)
					)
				)
				(client
					action: [kActions (- theLoop 3)]
					attDirection: [kAngles (- theLoop 3)]
					setLoop: theLoop
					cel: 0
					setCycle: End self
				)
			)
			(3
				(= opp (client opponent:))
				(if (and (== (client action:) 1) (client tryAttack: opp 0))
					(client doDamage: opp 0 1)
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

(instance rm470Warrior of Warrior
	(properties)

	(method (hurtMe)
		(if (not egoFlipped)
			(++ egoHurt)
		)
		(super hurtMe: &rest)
	)

	(method (die)
		(= egoFlipped 1)
		(gMiscSound number: 55 loop: 1 play:)
		(super die:)
	)

	(method (initCombat)
		(= egoGuy self)
		(super initCombat: &rest)
		(= deathScript dropDead)
		(= attackScript rm470Attacks)
		(= opponent khaveen)
	)
)

(instance doneFight of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(HandsOn)
		(NormalEgo)
		(gEgo
			x: (+ (gEgo x:) 8)
			y: (+ (gEgo y:) 2)
			illegalBits: (| (gEgo illegalBits:) $4000)
			setHeading: 45
		)
		(khaveenPoly points: @khaveenPoints size: 6)
		(gCurRoom addObstacle: khaveenPoly)
		(gCurRoom notify: 58)
	)

	(method (changeState newState &tmp EGOX EGOY)
		(switch (= state newState)
			(0
				(gMiscSound number: 55 loop: 1 play:)
				(if khaveenDying
					(kGuy view: 474 setLoop: 5 setCel: 0)
				else
					(kGuy view: 475 setLoop: 2 setCel: 0)
				)
				(= cycles 2)
			)
			(1
				(kGuy setCycle: End self)
			)
			(2
				(HighPrint 475 0) ; "Khaveen receives his mortal wound at your hands."
				(kGuy setPri: 9 stopUpd:)
				(= EGOX (egoGuy x:))
				(= EGOY (egoGuy y:))
				(egoGuy endCombat: dispose:)
				(gEgo
					view: 83
					setLoop: 0
					setCel: 6
					x: EGOX
					y: EGOY
					init:
					cycleSpeed: 1
					setCycle: Beg self
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance dropDead of HandsOffScript
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(egoGuy loop: 2 cel: 0)
				(= cycles 2)
			)
			(1
				(egoGuy setCycle: End self)
			)
			(2
				(LowPrint 475 1) ; "For all the fighting you have done before, you have finally met your match. You collapse to the ground."
				(gCurRoom setScript: (ScriptID 470 1)) ; youBlewIt
				(self dispose:)
			)
		)
	)
)

(instance khaveenFlips of HandsOffScript
	(properties)

	(method (init)
		(gDirectionHandler addToFront: self)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (== state 6)
			(cond
				(
					(or
						(Said 'give,get,get,(lockpick<up)/blade,weapon')
						(Said
							'let,give/khaveen,man,captain,fighter,swordsman[/blade,weapon]'
						)
					)
					(self changeState: 7)
					(gDirectionHandler delete: self)
					(= seconds 0)
				)
				(
					(Said
						'kill,attack,cut,hit[/man,khaveen,captain,fighter,swordsman]'
					)
					(= seconds 0)
					(gDirectionHandler delete: self)
					(self changeState: 11)
				)
				((Said 'resign,resign,(give<up)')
					(switch (++ yieldCounter)
						(1
							(KhaveenPrint 475 2) ; "Never!"
						)
						(2
							(KhaveenPrint 475 3) ; "I shall not yield!"
						)
						(3
							(= global75 0)
							(self changeState: 8)
						)
					)
				)
				(
					(or
						(== (event message:) JOY_UP)
						(== (event message:) JOY_UPRIGHT)
						(== (event message:) JOY_UPLEFT)
					)
					(self changeState: 11)
					(gDirectionHandler delete: self)
				)
				((Said 'throw')
					(HighPrint 475 4) ; "You're too close."
				)
				((Said 'cast')
					(HighPrint 475 5) ; "The large amount of metal in your shield makes spell-casting impossible."
				)
				((Said 'look,look')
					(HighPrint 475 6) ; "Quit sightseeing and watch what you're doing!"
				)
				(else
					(djinniPrint 475 7) ; "You don't have time for that, Master."
					(event claimed: 1)
				)
			)
		else
			(event claimed: 1)
		)
	)

	(method (dispose)
		(super dispose:)
		(if (not khaveenDying)
			(rm470Warrior canFight: 1 initCombat:)
			(khaveen view: 475 loop: 0 canFight: 1 initCombat:)
			(= egosGonnaWin 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(= khaveenHurt 50)
				(rm470Warrior canFight: 0 view: 473 setLoop: 0 cel: 0)
				(= cycles 1)
			)
			(1
				1
				(rm470Warrior setCycle: End)
				(khaveen view: 474 setLoop: 1 cel: 0 setCycle: End self)
			)
			(2
				2
				(rm470Warrior setCel: 3)
				(sword
					view: 474
					setLoop: 2
					x: 165
					y: 80
					yStep: 10
					init:
					setPri: 15
					setCycle: Fwd
					setMotion: MoveTo 169 10 self
				)
			)
			(3
				3
				(sword setMotion: MoveTo 172 100 self)
			)
			(4
				4
				(sword setMotion: MoveTo 174 149 self)
				(khaveen setLoop: 3 cel: 0 setCycle: End)
			)
			(5
				5
				(sword setCel: 3 setCycle: 0 setPri: -1)
				(= cycles 2)
			)
			(6
				6
				(HighPrint 475 8) ; "Khaveen's sword lies on the ground at his feet."
				(= global75 self)
				(rm470Warrior view: 80 loop: 0 setCel: -1)
				(HandsOn)
				(= seconds 10)
			)
			(7
				7
				(gDirectionHandler delete: self)
				(SkillUsed 14 200) ; honor
				(SolvePuzzle 680 7 3)
				(= global75 0)
				(rm470Warrior view: 473 setLoop: 6 cel: 0 setCycle: End)
				(= cycles 15)
			)
			(8
				8
				(if (< yieldCounter 3)
					(rm470Warrior setCycle: Beg)
				)
				(khaveen setLoop: 4 cel: 0 setCycle: CT 4 1 self)
			)
			(9
				9
				(rm470Warrior view: 80 loop: 0 setCel: -1)
				(sword dispose:)
				(khaveen setCycle: End self)
			)
			(10
				10
				(self dispose:)
			)
			(11
				11
				(CantBePaladin)
				(= global75 0)
				(rm470Warrior setLoop: 4 setCycle: End self)
			)
			(12
				12
				(= khaveenDying 1)
				(khaveen die:)
			)
		)
	)
)

(instance egoFlips of Script
	(properties)

	(method (handleEvent event &tmp index)
		(if (== state 8)
			(cond
				((or (Said 'get,get,(lockpick<up)/blade,weapon') (Said 'no'))
					(self changeState: 9)
					(= seconds 0)
					(yieldTimer dispose:)
				)
				((Said 'throw')
					(HighPrint 475 4) ; "You're too close."
				)
				(
					(Said
						'kill,attack,cut,hit[/man,khaveen,captain,fighter,swordsman]'
					)
					(HighPrint 475 9 25 4) ; "Your sword lies by your feet."
				)
				((Said 'yes,resign,resign,(give<up)')
					(= seconds 0)
					(yieldTimer dispose:)
					(self changeState: 13)
				)
				((Said 'cast')
					(HighPrint 475 5) ; "The large amount of metal in your shield makes spell-casting impossible."
				)
				((Said 'look,look')
					(HighPrint 475 6) ; "Quit sightseeing and watch what you're doing!"
				)
				(
					(or
						(Said 'attack,kill,hit,cut')
						(Said 'use/blade,dagger,weapon')
						(Said 'parry,defend,block')
						(Said 'use/shield')
					)
					(HighPrint 475 10) ; "That's it. Beat him over the head with your shield."
				)
				((or (Said 'escape,escape,(run<away)') (Said 'dodge,hop'))
					(HighPrint 475 11) ; "You try to dodge, but Khaveen's skill prevents you from getting past."
				)
				(else
					(djinniPrint 475 7) ; "You don't have time for that, Master."
					(event claimed: 1)
				)
			)
		else
			(event claimed: 1)
		)
	)

	(method (dispose)
		(super dispose:)
		(if (not wimpedOut)
			(rm470Warrior view: 80 loop: 0 canFight: 1 initCombat:)
			(khaveen view: 475 loop: 0 canFight: 1 initCombat:)
			(= oldHurt khaveenHurt)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(khaveen canFight: 0 view: 474 setLoop: 0 setCel: 0)
				(= cycles 1)
			)
			(1
				(khaveen setCel: 1)
				(rm470Warrior view: 473 setLoop: 4 setCel: 0)
				(= cycles 1)
			)
			(2
				(khaveen setCel: 2)
				(rm470Warrior setCel: 1)
				(= cycles 1)
			)
			(3
				(khaveen setCel: 3)
				(rm470Warrior setCel: 2)
				(= cycles 1)
				(sword
					view: 473
					setLoop: 5
					x: 152
					y: 99
					setPri: 15
					yStep: 10
					init:
					setCycle: Fwd
					setMotion: MoveTo 152 10 self
				)
			)
			(4
				(khaveen setCel: 4)
				(rm470Warrior setCycle: End)
			)
			(5
				(sword setMotion: MoveTo 150 90 self)
			)
			(6
				(sword setPri: 5 setMotion: MoveTo 147 148 self)
			)
			(7
				(sword setCel: 3 setPri: 2 setCycle: 0)
				(= cycles 2)
			)
			(8
				(HighPrint 475 12) ; "Your sword lies on the ground at your feet."
				(KhaveenPrint 475 13) ; "That was easy. Too easy. And Ad Avis called you a hero! I'm disappointed."
				(KhaveenPrint 475 14) ; "Now yield to me and grovel on the floor. I might consider sparing your life. Yield!!"
				(yieldTimer setReal: yieldTimer 6)
				(= global75 self)
			)
			(9
				(= global75 0)
				(rm470Warrior setLoop: 7 setCel: 0 setCycle: CT 3 1 self)
			)
			(10
				(sword dispose:)
				(rm470Warrior setCycle: End self)
				(khaveen view: 475 setLoop: 3 setCel: 0 setCycle: End)
			)
			(11
				(djinniPrint 475 15) ; "Good for you, Master!"
				(= cycles 8)
			)
			(12
				(self dispose:)
			)
			(13
				(= wimpedOut 1)
				(gMiscSound number: 55 loop: 1 play:)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 2)
				(= cycles 2)
			)
			(14
				(Print 475 16) ; "As you grovel upon the floor in front of Khaveen, he takes the opportunity to kick you. "Fool!" he says, "I will enjoy dealing with you later." He calls for his guards to drag you away."
				(gCurRoom setScript: (ScriptID 470 1)) ; youBlewIt
			)
		)
	)
)

(instance sword of Actor
	(properties
		priority 15
		signal 26640
		illegalBits 0
	)
)

(instance rm470Attacks of HandsOffScript
	(properties)

	(method (changeState newState &tmp opp attBonus)
		(switch (= state newState)
			(0
				(if (and (== khaveenHurt (+ oldHurt 2)) egoFlipped)
					(++ khaveenHurt)
					(rm470Warrior setScript: 0 endCombat:)
					(khaveen endCombat: setScript: khaveenFlips)
				else
					(client forceUpd:)
					(= cycles 1)
				)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(= opp (client opponent:))
				(client getTired: 5)
				(if (> register 5)
					(= register 5)
				)
				(= attBonus (- (* register 30) 50))
				(TrySkill 5 0 attBonus) ; weapon-use
				(if (and client (client tryAttack: opp attBonus))
					(client doDamage: opp)
				)
				(= cycles 2)
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

(instance yieldTimer of Timer
	(properties)

	(method (cue)
		(if firstYield
			(KhaveenPrint 475 17) ; "When I say yield, I mean yield!!"
			(EgoDead 1 475 18 #title {Khaveen skewers you}) ; "Ask not what you can do for your sword... Ask what your sword can do for you!"
		else
			(KhaveenPrint 475 19) ; "I said YIELD!!"
			(= firstYield 1)
			(self setReal: self 6)
		)
		(super cue:)
	)
)

(instance khaveenPoly of Polygon
	(properties
		type PBarredAccess
	)
)

