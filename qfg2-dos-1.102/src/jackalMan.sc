;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 695)
(include sci.sh)
(use Main)
(use battleSound)
(use Motion)
(use Actor)
(use System)

(public
	jackalMan 0
)

(local
	jackalsLeft
	[jackAngles 8] = [0 0 2 1 0 2 1 0]
	[jackActions 8] = [1 1 1 2 2 2 3 3]
	[jackal 15] = [0 0 0 0 200 90 0 262 122 0 241 88 0 159 55]
)

(instance jackalMan of Monster
	(properties
		x 173
		y 106
		noun '/jackal,jackal,(man<jackal),monster,creature'
		description {the Jackalman.}
		lookStr {Jackalmen travel in packs, and prefer attacking things previously wounded.}
		yStep 3
		view 695
		priority 5
		xStep 5
		strength 70
		intell 70
		agil 70
		vit 70
		luck 70
		weap 70
		parry 60
		dodge 80
		armorValue 3
		weapValue 4
		barMessage {Jackalman}
		chaseDelay 6
		attackRange 50
	)

	(method (dispose)
		(if (not (lilHelpers isEmpty:))
			(lilHelpers dispose: release:)
		)
		(super dispose:)
	)

	(method (endCombat)
		(if gJackalsKilled
			(-= gNumJackals gJackalsKilled)
			(= gBattleResult 58)
			(if (not gNumJackals)
				(= health 0)
			)
		)
		(super endCombat:)
	)

	(method (initAmbush &tmp i theX theY moveX theJackal)
		(super initAmbush:)
		(= i gNumJackals)
		(= theX (if (< (gEgo x:) 160) 355 else -35))
		(= theY 165)
		(= moveX (if (== theX 355) -80 else 80))
		(while (> (-- i) 0)
			((= theJackal (Actor new:))
				view: 696
				x:
					(switch i
						(4
							(-= theX 20)
						)
						(3
							(-= theX 15)
						)
						(2
							(-= theX 10)
						)
						(1
							(-= theX 5)
						)
					)
				y:
					(switch i
						(4
							(+= theY 17)
						)
						(3
							(+= theY 12)
						)
						(2
							(+= theY 7)
						)
						(1
							(-= theY 7)
						)
					)
				init:
				ignoreActors: 1
				setCycle: Walk
				setMotion: (MoveToStop new:) (+ theX moveX) theY
			)
			(lilHelpers addToEnd: theJackal)
		)
	)

	(method (initCombat &tmp i index theJack theX theY r)
		(= i gNumJackals)
		(while (> (-- i) 0)
			(= index (* i 3))
			(= [jackal index] (Actor new:))
			(= theJack [jackal index])
			(= theX [jackal (++ index)])
			(= theY [jackal (++ index)])
			(= r (Random 1 10))
			(theJack
				view: 698
				loop: (if (> r 5) 1 else 0)
				posn: theX theY
				init:
				setCycle: (if (> r 5) Bay else Fwd)
			)
			(if (or (== gHowFast 0) (and (== gHowFast 1) (> i 2)))
				(theJack stopUpd:)
			)
		)
		(= combatScript jackalCombatS)
		(= jackalsLeft (- gNumJackals 1))
		(= gJackalsKilled 0)
		(super initCombat: &rest)
		(jackalCombatS cycles: 0 seconds: 2)
	)

	(method (die)
		(cond
			((< jackalsLeft 0)
				(super die:)
				(return)
			)
			((not jackalsLeft))
			(else
				([jackal (* jackalsLeft 3)] setScript: takeOverS)
			)
		)
		(jackalMan setScript: jackalDeathS)
		(= health (self calcHealth:))
		(= stamina (self calcStamina:))
		(self setHealth: health)
		(self setStamina: stamina)
	)
)

(instance jackalCombatS of Script
	(properties)

	(method (changeState newState &tmp opp theLoop)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= theLoop (Random 3 10))
				(client
					action: [jackActions (- theLoop 3)]
					attDirection: [jackAngles (- theLoop 3)]
					setLoop: theLoop
					cel: 0
				)
				(= cycles (Random 5 15))
			)
			(2
				(client setCycle: End self)
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

(instance jackalDeathS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					canFight: 0
					action: 0
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(switch (++ gJackalsKilled)
					(1
						(bodyPile setLoop: 2 setCel: 3 init:)
					)
					(2
						(bodyPile setLoop: 12 setCel: 0)
					)
					(3
						(bodyPile setLoop: 13 setCel: 0)
					)
					(4
						(InitAddToPics picPile)
						(bodyPile
							x: (- (bodyPile x:) 5)
							y: (+ (bodyPile y:) 5)
							setLoop: 2
							setCel: 3
						)
					)
					(5
						(bodyPile setLoop: 12 setCel: 0)
					)
				)
				(client hide:)
				(if (< (-- jackalsLeft) 0)
					(client die:)
				)
				(self dispose:)
			)
		)
	)
)

(instance takeOverS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((jackalMan opponent:) canFight: 0)
				(client setLoop: 2 setCel: 0 setCycle: End self)
			)
			(1
				(client
					view: 696
					setLoop: -1
					illegalBits: 0
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 173 106 self
				)
			)
			(2
				(jackalMan loop: 0 show:)
				(client hide: dispose:)
				((jackalMan opponent:) canFight: 1)
			)
		)
	)
)

(instance bodyPile of View
	(properties
		x 178
		y 111
		view 695
	)
)

(instance picPile of PicView
	(properties
		x 178
		y 111
		view 695
		loop 13
	)
)

(class Bay of Cycle
	(properties
		waitCnt 0
		howlCnt 0
		done 0
	)

	(method (doit &tmp curCel newCel)
		(= curCel (client cel:))
		(= newCel (self nextCel:))
		(cond
			(howlCnt
				(if (not (-- howlCnt))
					(= cycleDir -1)
				)
			)
			(done
				(if (not (-- waitCnt))
					(= cycleDir 1)
					(= done 0)
				)
			)
			((== curCel newCel))
			((> newCel (client lastCel:))
				(= howlCnt (Random 10 20))
			)
			((< newCel 1)
				(self cycleDone:)
			)
			(else
				(client cel: newCel)
			)
		)
	)

	(method (cycleDone)
		(= waitCnt (Random 20 30))
		(= done 1)
	)
)

(instance MoveToStop of MoveTo
	(properties)

	(method (moveDone)
		(client stopUpd:)
		(super moveDone:)
	)
)

(instance lilHelpers of List
	(properties)
)

