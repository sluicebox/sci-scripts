;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 820)
(include sci.sh)
(use Main)
(use SView)
(use combat)
(use Motion)
(use System)

(public
	rabbit 0
	egoScript 1
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0)
	(if (gCombatEgoActor script:)
		(if (OneOf (gCombatEgoActor attackCode:) 0 1 6 18 21)
			(return 1)
		else
			(return 0)
		)
	else
		(return 1)
	)
)

(instance rabbit of SActor
	(properties
		x 258
		y 135
		view 821
		signal 20480
		cycleSpeed 20
		xStep 6
		moveSpeed 5
		explodeX 3
	)

	(method (init)
		(super init: &rest)
		(if (!= global439 3)
			(= global176 0)
			(= global177 0)
			(= global178 0)
			(= global179 0)
		)
		(rBloodDrop init: gPuzzleBar)
		(switch global439
			(1
				(= local1 30)
				(= local2 60)
			)
			(2
				(= local1 25)
				(= local2 50)
			)
			(else
				(= local1 15)
				(= local2 30)
			)
		)
		(= local3 (- 13 (/ (+ [gEgoStats 1] [gEgoStats 2]) 100))) ; intelligence, agility
		(self setPri: (+ (gCombatEgoActor priority:) 1) cue: setScript: rabbitCombat)
	)

	(method (cue)
		(self view: 821 y: 135 setLoop: 0 cycleSpeed: 20 setCycle: Fwd)
	)

	(method (getHurt param1)
		(rabbit setMotion: 0)
		(switch param1
			(0
				(self setScript: hurtBySpell)
			)
			(2
				(self setScript: hurtByDagger)
			)
		)
	)
)

(instance hurtBySpell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rabbit cycleSpeed: 1 setLoop: 12 1 cel: 0 setCycle: End self)
				(if (< (rabbit x:) 280)
					(rabbit
						xStep: 2
						moveSpeed: 1
						setMotion: MoveTo (+ (rabbit x:) 6) (rabbit y:)
					)
					(proc810_13 1 827)
				)
			)
			(1
				(if (IsFlag 386)
					(gPuzzleBar state: (& (gPuzzleBar state:) $ffdf))
				else
					(rabbit cue:)
				)
				(client setScript: rabbitCombat)
			)
		)
	)
)

(instance hurtByDagger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rabbit setLoop: 5 1 cel: 0 setCycle: End self)
				(proc810_13 1 827)
			)
			(1
				(if (IsFlag 386)
					(gPuzzleBar state: (& (gPuzzleBar state:) $ffdf))
					(self dispose:)
				else
					(switch (Random 0 3)
						(0
							(rabbit cue:)
							(client setScript: rabbitCombat)
						)
						(else
							(SetNowSeen rabbit)
							(if (< (rabbit nsLeft:) 280)
								(self setScript: rabbitBackward self)
							else
								(self setScript: rabbitAttack self)
							)
						)
					)
				)
			)
			(2
				(rabbit cue:)
				(client setScript: rabbitCombat)
			)
		)
	)
)

(instance rabbitCombat of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and register global184)
			(= ticks (= register 0))
			(self cue:)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= register 1)
				(= ticks (Random local1 local2))
			)
			(1
				(= register 0)
				(SetNowSeen rabbit)
				(SetNowSeen gCombatEgoActor)
				(cond
					(
						(and
							(<
								(= temp0
									(- (rabbit nsLeft:) (gCombatEgoActor nsRight:))
								)
								10
							)
							global184
						)
						(= global184 0)
						(self setScript: rabbitJump self)
					)
					((<= temp0 5)
						(cond
							((< (rabbit nsLeft:) 280)
								(self setScript: rabbitBackward self)
							)
							((Random 0 global439)
								(self setScript: rabbitAttack)
							)
							(else
								(self cue:)
							)
						)
					)
					((< global156 30)
						(cond
							((< (rabbit nsLeft:) 280)
								(if (localproc_0)
									(switch (Random 0 3)
										(0
											(self
												setScript: rabbitBackward self
											)
										)
										(else
											(cond
												((< temp0 20)
													(self
														setScript:
															rabbitAttack
															self
													)
												)
												((Random 0 2)
													(self cue:)
												)
												(else
													(self
														setScript:
															rabbitForward
															self
													)
												)
											)
										)
									)
								else
									(self cue:)
								)
							)
							((Random 0 (* global439 2))
								(self setScript: rabbitAttack self)
							)
							(else
								(self cue:)
							)
						)
					)
					((< temp0 20)
						(switch (Random 0 3)
							(0
								(if (< (rabbit nsLeft:) 280)
									(self setScript: rabbitBackward self)
								else
									(self cue:)
								)
							)
							(else
								(self setScript: rabbitAttack self)
							)
						)
					)
					((Random 0 5)
						(self setScript: rabbitForward self)
					)
					((< (rabbit nsLeft:) 280)
						(self setScript: rabbitBackward self)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance rabbitBackward of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rabbit
					setLoop: 4
					setCycle: End
					cycleSpeed: 1
					moveSpeed: 1
					setMotion:
						MoveTo
						(+ (rabbit x:) (Random 6 12))
						(rabbit y:)
						self
				)
			)
			(1
				(rabbit cue:)
				(self dispose:)
			)
		)
	)
)

(instance rabbitForward of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rabbit setCycle: 0 setLoop: 2 cel: 0)
				(= ticks 15)
			)
			(1
				(rabbit
					x: (- (rabbit x:) 1)
					setLoop: 2
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(2
				(rabbit x: (- (rabbit x:) 17) cue:)
				(self dispose:)
			)
		)
	)
)

(instance rabbitAttack of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(SetNowSeen rabbit)
		(if
			(and
				register
				(not (& global192 $0002))
				(gCombatEgoActor onMe: (+ (rabbit nsLeft:) 1) (+ (rabbit nsTop:) 5))
			)
			(= register 0)
			(rBloodDrop
				x: (- (rabbit x:) 60)
				y: (- (rabbit y:) 30)
				cel: 0
				setPri: (+ (gCombatEgoActor priority:) 1)
				setCycle: End rBloodDrop
				show:
			)
			(gCombatEgoActor getHurt: 5 setScript: getBitHit)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 1)
				(rabbit
					cycleSpeed: 4
					setLoop: 3 1
					cel: 0
					moveSpeed: 0
					xStep: 6
					setMotion:
						bitTo
						(+ (gCombatEgoActor x:) (gCombatEgoActor width:) 35)
						(rabbit y:)
						self
					setCycle: CT 2 1
				)
				(proc810_13 1 823)
			)
			(1
				(if local0
					(rabbit setLoop: 7 1 cel: 0 setCycle: End self)
				else
					(rabbit setCycle: End self)
				)
			)
			(2
				(rabbit x: (+ (rabbit x:) 15) setMotion: 0 cue:)
				(self dispose:)
			)
		)
	)
)

(instance rabbitJump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rabbit cycleSpeed: 3 setLoop: 8 1 cel: 0 setCycle: CT 3 1 self)
			)
			(1
				(= ticks 25)
			)
			(2
				(rabbit setCycle: End self)
			)
			(3
				(rabbit cue:)
				(self dispose:)
			)
		)
	)
)

(instance getBitHit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gPuzzleBar noHands: 1)
				(VibrateMouse 1 1 1)
				(gCombatEgoActor
					view: (gCombatEgoActor typeView:)
					moveSpeed: 0
					xStep: 4
					setLoop: 2 1
					cel: 0
					setCycle: End self
				)
				(proc810_13 0 911)
				(if (> (gCombatEgoActor x:) 45)
					(gCombatEgoActor
						setMotion: ShotTo (- (gCombatEgoActor x:) 8) (gCombatEgoActor y:)
					)
				)
			)
			(1
				(= ticks 5)
			)
			(2
				(gCombatEgoActor setMotion: 0 cue:)
				(gPuzzleBar noHands: 0)
				(if (IsFlag 386)
					(gPuzzleBar state: (& (gPuzzleBar state:) $ffdf))
				)
				(self dispose:)
			)
		)
	)
)

(instance rBloodDrop of SActor
	(properties
		view 821
		loop 10
	)

	(method (init)
		(super init: &rest)
		(self cue:)
	)

	(method (cue)
		(self hide:)
	)
)

(instance bitTo of ShotTo
	(properties)

	(method (init)
		(= local0 0)
		(super init: &rest)
		(= dx (Abs dx))
	)

	(method (doit)
		(SetNowSeen client)
		(if (>= (Abs (- gGameTime b-moveCnt)) (client moveSpeed:))
			(cond
				((< (+ (client nsLeft:) 1) (+ (gCombatEgoActor x:) 5))
					(= local0 1)
					(self moveDone:)
				)
				((gCombatEgoActor onMe: (+ (client nsLeft:) 1) (+ (client nsTop:) 5))
					(self moveDone:)
				)
				(else
					(client x: (- (client x:) dx))
				)
			)
		)
	)
)

(instance egoScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks (Random 2 local3))
			)
			(1
				(SetNowSeen gCombatEgoActor)
				(SetNowSeen rabbit)
				(= temp0 (- (rabbit nsLeft:) (gCombatEgoActor nsRight:)))
				(cond
					(
						(and
							(proc810_12 global178)
							(or (< [gEgoStats 18] 2) (== global176 0)) ; stamina
							(> (gCombatEgoActor nsLeft:) 20)
						)
						(self setScript: (ScriptID 41 3) self) ; xBackward
					)
					((< temp0 15)
						(cond
							((> [gEgoStats 18] 7) ; stamina
								(if (Random 0 (- 15 global176))
									(self setScript: (ScriptID 810 11) self) ; lowSlash
								else
									(self setScript: (ScriptID 810 7) self) ; jumpVAttack
								)
							)
							((proc810_12 global178)
								(self setScript: blockLow self)
							)
							(else
								(self cue:)
							)
						)
					)
					((and (> temp0 20) (proc810_12 global176))
						(self setScript: (ScriptID 41 2) self) ; xForward
					)
					(
						(and
							(proc810_12 global177)
							(> [gEgoStats 18] 5) ; stamina
							(> [gEgoStats 19] 5) ; mana
							(not (gEgoSpell active:))
						)
						(if (or [gEgoStats 28] [gEgoStats 33] [gEgoStats 34]) ; forceSpell, lightningSpell, frostSpell
							(self setScript: (ScriptID 41 5) self (Random 0 1)) ; xdoSpell
						else
							(self setScript: (ScriptID 41 5) self 0) ; xdoSpell
						)
					)
					(
						(and
							(< [gEgoStats 17] 50) ; health
							(proc810_12 global178)
							(> (gEgo x:) 25)
						)
						(self setScript: (ScriptID 41 3) self) ; xBackward
					)
					(
						(and
							(== gHeroType 2) ; Thief
							(> [gEgoStats 18] 35) ; stamina
							(proc810_12 global179)
							(proc810_12 global176)
						)
						(self setScript: (ScriptID 810 9) self) ; toBomb
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance blockLow of Script
	(properties)

	(method (init)
		(= register 0)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(if (and register (!= (rabbit loop:) 3))
			(&= global192 $fffd)
			(= register 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(|= global192 $0002)
				(gCombatEgoActor
					view: (+ (gCombatEgoActor typeView:) 1)
					setLoop: (if (== (gCombatEgoActor typeView:) 44) 3 else 1) 1
					cel: 0
					attackCode: 20
				)
				(= ticks 10)
			)
			(1
				(= register 1)
			)
			(2
				(gCombatEgoActor cue:)
				(&= global192 $fffd)
				(self dispose:)
			)
		)
	)
)

