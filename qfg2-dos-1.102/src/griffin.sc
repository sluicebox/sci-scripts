;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 655)
(include sci.sh)
(use Main)
(use n001)
(use HandsOffScript)
(use battleSound)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	griffin 0
)

(procedure (FindPri startX startY whichPri)
	(while (< startY 190)
		(if (& (OnControl PRIORITY startX startY) whichPri)
			(break)
		)
		(++ startY)
	)
	(if (== startY 190)
		(= startY 0)
	)
	(return startY)
)

(instance griffin of Monster
	(properties
		x -100
		y -100
		noun '/griffin'
		description {the Griffin}
		lookStr {It is a mean, nasty, agitated, about-to-rip-your-head-off Griffin.}
		yStep 6
		view 655
		signal 10240
		xStep 9
		strength 150
		intell 70
		agil 120
		vit 130
		luck 100
		weap 120
		parry 50
		dodge 80
		armorValue 2
		weapValue 6
		barMessage {Griffin}
		battleMusic 54
		endMusic 55
	)

	(method (init)
		(= battleMusic 54)
		(Load rsVIEW 810)
		(Load rsSCRIPT 32 24)
		(= gMonsterHealth gGriffinHealth)
		(super init:)
		(leftWing x: x y: (- y 25) cycleSpeed: 1 setCycle: Fwd init:)
		(rightWing x: (+ x 3) y: (- y 25) cycleSpeed: 1 setCycle: Fwd init:)
	)

	(method (dispose)
		(leftWing dispose:)
		(rightWing dispose:)
		(griffinSound dispose:)
		(super dispose:)
		(= gGriffinHealth gMonsterHealth)
	)

	(method (initCombat)
		(= combatScript griffinCombatS)
		(= hurtScript griffinHurtS)
		(= deathScript griffinDeathS)
		((ScriptID 32 1) x: (griffin x:) y: (- (griffin y:) 20)) ; spellObj
		(super initCombat: &rest)
	)

	(method (initAmbush)
		(= ambushScript griffinAmbushS)
		(super initAmbush: &rest)
	)

	(method (hurtMe)
		(if (!= script griffinCombatS)
			(return 0)
		else
			(super hurtMe: &rest)
		)
	)

	(method (doit)
		(if ((leftWing cycler:) cycleCnt:)
			(switch (leftWing cel:)
				(0
					(= z 2)
					(leftWing z: 2)
					(rightWing z: 2)
				)
				(1
					(= z 4)
					(leftWing z: 4)
					(rightWing z: 4)
				)
				(2
					(= z 0)
					(leftWing z: 0)
					(rightWing z: 0)
				)
			)
		)
		(super doit:)
	)
)

(instance leftWing of Prop
	(properties
		view 655
		loop 1
		signal 24576
	)

	(method (doit)
		(= x (griffin x:))
		(= y (- (griffin y:) 25))
		(super doit:)
	)
)

(instance rightWing of Prop
	(properties
		view 655
		loop 2
		signal 24576
	)

	(method (doit)
		(= x (+ (griffin x:) 3))
		(= y (- (griffin y:) 25))
		(super doit:)
	)
)

(instance griffinCombatS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(griffin setLoop: (Random 3 4) setCel: 0)
				(= cycles (Random 5 15))
			)
			(1
				(griffin setCycle: End self)
			)
			(2
				(if (griffin tryAttack: (ScriptID 32 0) 0) ; warrior
					(griffin doDamage: (ScriptID 32 0)) ; warrior
				)
				(= cycles 2)
			)
			(3
				(griffin setCycle: Beg self)
			)
			(4
				(if (and ((ScriptID 32 0) barHealth:) (Random 0 3)) ; warrior
					(self changeState: 0)
				else
					((ScriptID 32 0) canFight: 0) ; warrior
					(griffin setScript: flyAwayS 0 0)
				)
			)
		)
	)
)

(instance griffinAmbushS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 4)
			)
			(1
				(if (gEgo script:)
					((gEgo script:) caller: self)
				else
					(= cycles 1)
				)
			)
			(2
				(if (Random 0 1)
					(littleGriffin
						setLoop: 0
						x: -30
						setCycle: Fwd
						setMotion: MoveTo 35 40 self
						init:
					)
				else
					(littleGriffin
						setLoop: 1
						x: 350
						setCycle: Fwd
						setMotion: MoveTo 285 40 self
						init:
					)
				)
			)
			(3
				(gEgo setMotion: 0 setHeading: 0)
				(if (> (littleGriffin x:) 160)
					(littleGriffin setMotion: MoveTo -30 40 self)
				else
					(littleGriffin setMotion: MoveTo 350 40 self)
				)
			)
			(4
				(cond
					((< (gEgo x:) 70)
						(gEgo setMotion: MoveTo 70 (gEgo y:) self)
					)
					((> (gEgo x:) 220)
						(gEgo setMotion: MoveTo 220 (gEgo y:) self)
					)
					(else
						(= cycles 8)
					)
				)
				(littleGriffin dispose:)
			)
			(5
				(griffinSound number: (griffin battleMusic:) play:)
				(= register (> (gEgo x:) 160))
				(griffin
					battleMusic: 0
					setCel: register
					posn: (if register 40 else 260) -150
					setMotion: MoveTo (+ (gEgo x:) 30) (- (gEgo y:) 20)
				)
				(= cycles 12)
			)
			(6
				(gEgo setMotion: 0 hide:)
				((ScriptID 32 0) ; warrior
					posn: (gEgo x:) (gEgo y:)
					opponent: griffin
					initCombat:
				)
				(griffin
					setMotion:
						MoveTo
						(+ (gEgo x:) 30)
						(- (gEgo y:) 20)
						self
				)
			)
			(7
				(if (and gDebugging (gEgo mover:))
					(InspectObj (gEgo mover:))
				)
				(client initCombat:)
			)
		)
	)
)

(instance griffinHurtS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(griffin setLoop: 5 setCel: 0)
				(= cycles 2)
			)
			(1
				(griffin setCycle: End self)
			)
			(2
				(if (Random 0 2)
					(client setScript: griffinCombatS)
				else
					(client setScript: flyAwayS 0 0)
				)
			)
		)
	)
)

(instance griffinDeathS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: flyAwayS self 1)
			)
			(1
				(= cycles 10)
			)
			(2
				(griffinSound number: (griffin endMusic:) play:)
				(gEgo setHeading: 0)
				(littleGriffin
					loop: 2
					posn: 150 -50
					setPri: 1
					yStep: 6
					init:
					setCycle: Fwd
					setMotion: MoveTo 150 150 self
				)
			)
			(3
				(littleGriffin dispose:)
				(gMiscSound number: 12 priority: 10 loop: 0 play:)
				(shroomCloud
					y: (FindPri 150 1 8)
					init:
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(4
				(shroomCloud dispose:)
				(gEgo setHeading: 180 self)
			)
			(5
				(gEgo view: 50 setLoop: 0 setCycle: End self)
			)
			(6
				(= cycles 20)
			)
			(7
				(NormalEgo)
				(griffin endCombat: dispose:)
			)
		)
	)
)

(instance flyAwayS of Script
	(properties)

	(method (changeState newState &tmp onRight)
		(switch (= state newState)
			(0
				(griffinSound number: 23 play:)
				(leftWing cycleSpeed: 0)
				(rightWing cycleSpeed: 0)
				(griffin setLoop: 0 setCel: 0 setMotion: MoveTo 40 -50 self)
			)
			(1
				(if (not register)
					(griffin endCombat: dispose:)
				)
				(= gMonsterNum 0)
				((ScriptID 32 0) endCombat: dispose:) ; warrior
				(gEgo show:)
				(SetFlag 143)
				(self dispose:)
			)
		)
	)
)

(instance littleGriffin of Actor
	(properties
		y 40
		noun '/griffin,bird'
		description {the Griffin}
		lookStr {Uh-oh, looks like trouble...}
		view 654
		signal 24576
		illegalBits 0
		xStep 7
	)
)

(instance shroomCloud of Prop
	(properties
		x 145
		y 107
		view 654
		loop 3
		priority 1
		signal 24592
	)
)

(instance griffinSound of Sound
	(properties
		priority 6
		loop 0
	)
)

