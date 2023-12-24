;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 670)
(include sci.sh)
(use Main)
(use n001)
(use HandsOffScript)
(use battleSound)
(use Motion)
(use Actor)
(use System)

(public
	scorpion 0
)

(local
	sting
	pincLoop
)

(instance scorpion of Monster
	(properties
		x 145
		y 86
		noun '/scorpion,monster,creature'
		description {the Scorpion}
		lookStr {The desert Scorpion is one of the deadliest creatures, with claws and a poisonous stinger for a tail.}
		view 670
		priority 5
		strength 150
		intell 50
		agil 100
		vit 100
		luck 80
		weap 150
		dodge 80
		armorValue 9
		weapValue 6
		barMessage {Scorpion}
		chaseDelay 5
		battleMusic 54
		endMusic 55
	)

	(method (initCombat)
		(= combatScript scorpScript)
		(= hurtScript scorpOuch)
		(= deathScript scorpDeath)
		(leftPincer init:)
		(rightPincer init:)
		(super initCombat: &rest)
	)
)

(instance leftPincer of Prop
	(properties
		x 140
		y 87
		view 670
		loop 4
		priority 5
	)
)

(instance rightPincer of Prop
	(properties
		x 161
		y 89
		view 670
		loop 1
		priority 5
	)
)

(instance stinger of Prop
	(properties
		x 164
		y 64
		view 671
		loop 6
	)
)

(instance scorpLegs of Prop
	(properties
		view 670
		loop 8
		signal 16384
	)
)

(instance noTailBod of View
	(properties
		x 150
		y 104
		view 671
		loop 4
	)
)

(instance scorpScript of Script
	(properties)

	(method (changeState newState &tmp opp theAttack)
		(switch (= state newState)
			(0
				(switch gArcadeLevel
					(1
						(= cycles 12)
					)
					(2
						(= cycles 9)
					)
					(3
						(= cycles 6)
					)
				)
			)
			(1
				(if (== (Random 1 5) 3)
					(self setScript: scorpCharge self)
				else
					(self cue:)
				)
			)
			(2
				(if (< sting 6)
					(++ sting)
				else
					(= sting 0)
				)
				(if (Random 0 1)
					(= theAttack 2)
					(= register rightPincer)
					(= pincLoop 1)
				else
					(= theAttack 1)
					(= register leftPincer)
					(= pincLoop 2)
				)
				(client action: 1 attDirection: theAttack)
				(register setCel: 0)
				(= cycles (+ (Random 5 12) (* (- 3 gArcadeLevel) 3)))
			)
			(3
				(if (== sting (Random 2 6))
					(= register 0)
					(scorpion setScript: stingWhip)
				else
					(register loop: pincLoop setCycle: End self)
				)
			)
			(4
				(if register
					(= opp (client opponent:))
					(if (client tryAttack: opp 0)
						(client doDamage: opp 0 1)
					)
					(= cycles 2)
				else
					(self cue:)
				)
			)
			(5
				(if register
					(register setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(6
				(client action: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance stingWhip of Script
	(properties)

	(method (dispose)
		(if (< state 2)
			((ScriptID 32 0) canFight: 1) ; warrior
			(noTailBod dispose:)
			(stinger setCycle: 0 dispose:)
			(scorpion show:)
			(leftPincer show:)
			(rightPincer show:)
		)
		(super dispose:)
	)

	(method (changeState newState &tmp combScr)
		(switch (= state newState)
			(0
				(if (scorpion respondsTo: #nextMove)
					(scorpion nextMove: 0)
				)
				(scorpion canFight: 0 hide:)
				(leftPincer hide:)
				(rightPincer hide:)
				(stinger init:)
				(noTailBod init:)
				(= cycles 2)
			)
			(1
				(stinger setCycle: Fwd)
				(= seconds (- 5 gArcadeLevel))
			)
			(2
				((ScriptID 32 0) canFight: 0) ; warrior
				(noTailBod dispose:)
				(stinger setCycle: 0 dispose:)
				(scorpion show:)
				(leftPincer show:)
				(rightPincer show:)
				(= cycles 10)
			)
			(3
				(cond
					((== ((ScriptID 32 0) action:) 3) ; warrior
						(scorpion setCycle: End self)
					)
					((IsFlag 121) ; fAntidote
						(ClearFlag 121) ; fAntidote
						(LowPrint 670 0) ; "The antidote has lost its strength."
						(scorpion setCycle: End self)
					)
					(else
						(scorpion setScript: shishKaBob)
					)
				)
			)
			(4
				(scorpion setCycle: Beg self)
			)
			(5
				(scorpion action: 0 setLoop: 0)
				((ScriptID 32 0) canFight: 1) ; warrior
				(if (= combScr (scorpion combatScript:))
					(scorpion setScript: combScr)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance shishKaBob of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rightPincer loop: 1 setCycle: End self)
			)
			(1
				((ScriptID 32 0) hide:) ; warrior
				(rightPincer
					view: (if (gEgo has: 7) 673 else 674) ; Shield
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(rightPincer loop: 1 setCycle: Fwd)
				(= seconds 3)
			)
			(3
				(scorpion setCycle: End self)
			)
			(4
				(scorpion setCycle: Beg)
				(rightPincer loop: 2 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(5
				(= seconds 3)
			)
			(6
				(EgoDead 0 670 1 #title {Get the point?} #icon 672 0 0) ; "You just became scorpion shish-ka-bob."
			)
		)
	)
)

(instance scorpOuch of Script
	(properties)

	(method (changeState newState &tmp combScr)
		(switch (= state newState)
			(0
				(client canFight: 0 action: 7 setCycle: 0 setLoop: 0 setCel: 0)
				(if (client respondsTo: #nextMove)
					(client nextMove: 0)
				)
				(if (gCast contains: scorpLegs)
					(scorpLegs dispose:)
				)
				(= cycles 1)
			)
			(1
				(leftPincer hide:)
				(rightPincer hide:)
				(scorpion
					view: 670
					setLoop: 10
					cel: 0
					cycleSpeed: 2
					posn: 145 86
					setCycle: End self
				)
			)
			(2
				(scorpion view: 670 loop: 0 cel: 0)
				(leftPincer cel: 0 show:)
				(rightPincer cel: 0 show:)
				(= cycles 1)
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

(instance scorpDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leftPincer hide:)
				(rightPincer hide:)
				(client
					canFight: 0
					action: 0
					view: 671
					setLoop: 7
					setCel: 0
					posn: (+ (scorpion x:) 5) (+ (scorpion y:) 17)
					setCycle: End self
				)
			)
			(1
				(gCurRoom notify: 58)
				(self dispose:)
			)
		)
	)
)

(instance scorpCharge of Script
	(properties)

	(method (changeState newState &tmp combScr opp)
		(switch (= state newState)
			(0
				(scorpion canFight: 0)
				(if (scorpion respondsTo: #nextMove)
					(scorpion nextMove: 0)
				)
				(leftPincer hide:)
				(rightPincer hide:)
				(scorpLegs posn: (scorpion x:) (+ (scorpion y:) 4) init:)
				(scorpion
					ignoreActors: 1
					posn: (scorpion x:) (+ (scorpion y:) 4)
					loop: 7
				)
				(= cycles 1)
			)
			(1
				(scorpion posn: (- (scorpion x:) 1) (+ (scorpion y:) 1))
				(scorpLegs setCycle: End self)
			)
			(2
				(= cycles 2)
			)
			(3
				(scorpion posn: (+ (scorpion x:) 1) (- (scorpion y:) 1))
				(scorpLegs setCycle: Beg self)
			)
			(4
				(scorpion posn: 145 86 loop: 0 cel: 0)
				(leftPincer show:)
				(rightPincer show:)
				(scorpLegs dispose:)
				(= cycles 2)
			)
			(5
				(scorpion canFight: 1 action: 0 setLoop: 0)
				(if (= combScr (scorpion combatScript:))
					(scorpion setScript: combScr)
				else
					(self dispose:)
				)
			)
		)
	)
)

