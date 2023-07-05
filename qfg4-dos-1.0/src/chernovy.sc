;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 840)
(include sci.sh)
(use Main)
(use SView)
(use combat)
(use Motion)
(use System)

(public
	chernovy 0
	egoScript 1
)

(local
	local0
	local1
	local2
	local3
)

(instance chernovy of SActor
	(properties
		x 273
		y 140
		view 841
		signal 20480
		cycleSpeed 16
		explodeX 40
	)

	(method (init)
		(super init: &rest)
		(cSpell init: gPuzzleBar)
		(cBloodDrop init: gPuzzleBar)
		(= local2 0)
		(switch global439
			(1
				(= local0 30)
				(= local1 60)
			)
			(2
				(= local0 25)
				(= local1 45)
			)
			(else
				(= local0 5)
				(= local1 20)
			)
		)
		(if (!= global439 3)
			(switch gHeroType
				(2 ; Thief
					(= global176 5)
					(= global177 4)
					(= global178 7)
					(= global179 10)
				)
				(1 ; Magic User
					(= global176 0)
					(= global177 10)
					(= global178 10)
				)
				(else
					(= global176 8)
					(= global177 3)
					(= global178 5)
				)
			)
		)
		(= local3 (- 13 (/ (+ [gEgoStats 1] [gEgoStats 2]) 100))) ; intelligence, agility
		(self cue: setScript: waitCycle)
	)

	(method (cue)
		(self
			view: 841
			setLoop: 0 1
			cel: 0
			attackCode: 0
			cycleSpeed: 14
			setCycle: Fwd
		)
	)

	(method (getHurt param1)
		(switch param1
			(0
				(self setScript: hurtBySpell)
			)
			(2
				(self setScript: hurtMyself)
			)
		)
	)
)

(instance waitCycle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(client setScript: chernovyCombat)
			)
		)
	)
)

(instance chernovyCombat of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks (Random local0 local1))
			)
			(1
				(SetNowSeen gCombatEgoActor)
				(SetNowSeen chernovy)
				(cond
					((gEgoSpell active:)
						(cond
							((> global439 1)
								(switch (Random 0 4)
									(0
										(if (== global439 3)
											(self setScript: doBlock self)
										else
											(self cue:)
										)
									)
									(1
										(if (not (cSpell active:))
											(self setScript: castLSpell self)
										else
											(self setScript: doBlock self)
										)
									)
									(2
										(if (== global439 3)
											(self setScript: doBlock self)
										else
											(self setScript: castLSpell self)
										)
									)
									(3
										(if (== global439 1)
											(self cue:)
										else
											(self setScript: doBlock self)
										)
									)
									(else
										(self setScript: doBlock self)
									)
								)
							)
							((Random 0 4)
								(self cue:)
							)
							(else
								(self setScript: doBlock self)
							)
						)
					)
					(local2
						(= ticks (= ticks 20))
					)
					((> (- (chernovy nsLeft:) (gCombatEgoActor nsRight:)) 40)
						(switch (Random 0 7)
							(0
								(self setScript: moveForward self)
							)
							(1
								(self setScript: moveForward self)
							)
							(2
								(if (> global186 0)
									(self setScript: moveForward self)
								else
									(self cue:)
								)
							)
							(else
								(if (and (not (cSpell active:)) (< global186 5))
									(if (Random 0 1)
										(self setScript: castHSpell self)
									else
										(self setScript: castLSpell self)
									)
								else
									(self setScript: moveForward self)
								)
							)
						)
					)
					((< (- (chernovy nsLeft:) (gCombatEgoActor nsRight:)) 5)
						(cond
							((< (chernovy x:) 270)
								(cond
									((Random 0 3)
										(self setScript: moveBackward self)
									)
									((Random 0 1)
										(self setScript: doLSlash self)
									)
									(else
										(self setScript: doRSlash self)
									)
								)
							)
							((Random 0 1)
								(self setScript: doRSlash self)
							)
							(else
								(self setScript: doLSlash self)
							)
						)
					)
					((not (cSpell active:))
						(switch (Random 0 5)
							(0
								(self setScript: castHSpell self)
							)
							(1
								(self setScript: castLSpell self)
							)
							(2
								(if (!= global439 3)
									(self cue:)
								else
									(self setScript: castHSpell self)
								)
							)
							(3
								(if (> global439 1)
									(self setScript: castLSpell self)
								else
									(self cue:)
								)
							)
							(4
								(if (> global439 1)
									(self setScript: castHSpell self)
								else
									(self cue:)
								)
							)
							(else
								(self cue:)
							)
						)
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

(instance doBlock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chernovy
					attackCode: 23
					cycleSpeed: 1
					setLoop: 8 1
					cel: 0
					setCycle: End self
				)
				(proc810_13 1 942)
			)
			(1
				(if (gEgoSpell active:)
					(self changeState: 0)
				else
					(chernovy attackCode: 0 cue:)
					(self dispose:)
				)
			)
		)
	)
)

(instance doLSlash of Script
	(properties)

	(method (init)
		(= register 1)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(SetNowSeen chernovy)
		(if
			(and
				register
				(or
					(gCombatEgoActor
						onMe: (+ (chernovy nsLeft:) 1) (+ (chernovy nsTop:) 10)
					)
					(and
						(== state 1)
						(| (SetNowSeen gCombatEgoActor) $0001)
						(<= (chernovy nsLeft:) (gCombatEgoActor nsRight:))
					)
				)
			)
			(= register 0)
			(cBloodDrop
				x: (+ (chernovy nsLeft:) 1)
				y: (+ (chernovy nsTop:) 10)
				setPri: (+ (gCombatEgoActor priority:) 1)
				show:
				setCycle: End cBloodDrop
			)
			(gCombatEgoActor getHurt: 6 setScript: sleapFace)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chernovy setLoop: 4 1 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(= ticks 10)
			)
			(2
				(chernovy setCycle: End self)
			)
			(3
				(chernovy cue:)
				(self dispose:)
			)
		)
	)
)

(instance doRSlash of Script
	(properties)

	(method (init)
		(= register 1)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(SetNowSeen chernovy)
		(if
			(and
				register
				(or
					(gCombatEgoActor
						onMe: (+ (chernovy nsLeft:) 2) (+ (chernovy nsTop:) 29)
					)
					(and
						(== state 1)
						(| (SetNowSeen gCombatEgoActor) $0001)
						(<= (chernovy nsLeft:) (gCombatEgoActor nsRight:))
					)
				)
			)
			(= register 0)
			(cBloodDrop
				x: (+ (chernovy nsLeft:) 2)
				y: (+ (chernovy nsTop:) 29)
				setPri: (+ (gCombatEgoActor priority:) 1)
				show:
				setCycle: End cBloodDrop
			)
			(gCombatEgoActor getHurt: 6 setScript: sleapFace)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chernovy setLoop: 5 1 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(= ticks 10)
			)
			(2
				(chernovy setCycle: End self)
			)
			(3
				(chernovy cue:)
				(self dispose:)
			)
		)
	)
)

(instance castHSpell of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				(SetNowSeen chernovy)
				(proc810_13 1 842)
				(chernovy setLoop: 6 1 cel: 0)
				(cSpell
					setLoop: 1 1
					x: (- (chernovy nsLeft:) 10)
					y: (= temp0 (+ (chernovy nsTop:) 17))
					show:
					setPri: (+ (gCombatEgoActor priority:) 1)
					myTarget: gCombatEgoActor
					setCycle: Fwd
					setMotion: MoveTo -10 temp0 cSpell
				)
				(= ticks 40)
			)
			(2
				(chernovy cue:)
				(self dispose:)
			)
		)
	)
)

(instance castLSpell of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				(SetNowSeen chernovy)
				(proc810_13 1 842)
				(chernovy setLoop: 7 1 cel: 0)
				(cSpell
					setLoop: 1 1
					x: (- (chernovy nsLeft:) 10)
					y: (= temp0 (+ (chernovy nsTop:) 35))
					show:
					setPri: (+ (gCombatEgoActor priority:) 1)
					myTarget: gCombatEgoActor
					setCycle: Fwd
					setMotion: MoveTo -10 temp0 cSpell
				)
				(= ticks 40)
			)
			(2
				(chernovy cue:)
				(self dispose:)
			)
		)
	)
)

(instance sleapFace of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gPuzzleBar noHands: 1)
				(VibrateMouse 2 1 1)
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
				(= ticks 10)
			)
			(2
				(gCombatEgoActor setMotion: 0)
				(gPuzzleBar noHands: 0)
				(if (IsFlag 386)
					(gPuzzleBar state: (& (gPuzzleBar state:) $ffdf))
				else
					(gCombatEgoActor cue:)
				)
				(self dispose:)
			)
		)
	)
)

(instance moveBackward of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chernovy
					setLoop: 2 1
					cel: 0
					moveSpeed: 1
					xStep: 6
					setMotion:
						ShotTo
						(+ (chernovy x:) (Random 12 36))
						(chernovy y:)
						self
				)
			)
			(1
				(chernovy cue:)
				(self dispose:)
			)
		)
	)
)

(instance moveForward of Script
	(properties)

	(method (init)
		(= register 1)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(SetNowSeen chernovy)
		(SetNowSeen gCombatEgoActor)
		(if (and register (<= (chernovy nsLeft:) (gCombatEgoActor nsRight:)))
			(= register 0)
			(chernovy setMotion: 0)
			(self dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chernovy
					setLoop: 1 1
					moveSpeed: 1
					xStep: 6
					cel: 0
					setMotion:
						ShotTo
						(- (chernovy x:) (Random 12 36))
						(chernovy y:)
						self
				)
			)
			(1
				(chernovy cue:)
				(self dispose:)
			)
		)
	)
)

(instance hurtMyself of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chernovy cycleSpeed: 6 setLoop: 3 1 cel: 0)
				(if (< (chernovy x:) 270)
					(chernovy
						setCycle: End
						setMotion:
							MoveTo
							(+ (chernovy x:) 15)
							(chernovy y:)
							self
					)
				else
					(chernovy setCycle: End self)
				)
				(proc810_13 1 843)
			)
			(1
				(cond
					((IsFlag 386)
						(gPuzzleBar state: (& (gPuzzleBar state:) $ffdf))
						(self dispose:)
					)
					((> global439 1)
						(switch (Random 0 4)
							(0
								(if (and (Random 0 2) (not (cSpell active:)))
									(self setScript: castHSpell self)
								else
									(self setScript: doLSlash self)
								)
							)
							(1
								(if (and (Random 0 2) (not (cSpell active:)))
									(self setScript: castHSpell self)
								else
									(self setScript: doRSlash self)
								)
							)
							(2
								(if (== global439 3)
									(if (not (cSpell active:))
										(self setScript: castHSpell self)
									else
										(self setScript: doRSlash self)
									)
								else
									(self cue:)
								)
							)
							(3
								(if (== global439 3)
									(if (not (cSpell active:))
										(self setScript: castLSpell self)
									else
										(self setScript: doLSlash self)
									)
								else
									(self cue:)
								)
							)
							(else
								(cond
									((Random 0 2)
										(self setScript: castHSpell self)
									)
									((Random 0 1)
										(self setScript: doLSlash self)
									)
									(else
										(self setScript: doRSlash self)
									)
								)
							)
						)
					)
					((Random 0 4)
						(self cue:)
					)
					((Random 0 2)
						(self setScript: castLSpell self)
					)
					((Random 0 1)
						(self setScript: doLSlash self)
					)
					(else
						(self setScript: doRSlash self)
					)
				)
			)
			(2
				(chernovy cue:)
				(client setScript: chernovyCombat)
			)
		)
	)
)

(instance hurtBySpell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chernovy cycleSpeed: 6 setLoop: 9 1 cel: 0 setCycle: End self)
				(if (< (chernovy x:) 270)
					(chernovy
						setMotion: MoveTo (+ (chernovy x:) 15) (chernovy y:)
					)
				)
				(proc810_13 1 843)
			)
			(1
				(if (IsFlag 386)
					(gPuzzleBar state: (& (gPuzzleBar state:) $ffdf))
				else
					(chernovy cue:)
				)
				(client setScript: chernovyCombat)
			)
		)
	)
)

(instance getSpellHit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gPuzzleBar noHands: 1)
				(= local2 1)
				(cSpell setLoop: 2 1 cel: 0 setCycle: End cSpell)
				(= ticks 5)
			)
			(1
				(VibrateMouse 3 1 1)
				(gCombatEgoActor
					view: (gCombatEgoActor typeView:)
					moveSpeed: 0
					xStep: 4
					setLoop: 3 1
					cel: 0
					setCycle: End self
				)
				(if (> (gCombatEgoActor x:) 45)
					(gCombatEgoActor
						setMotion: ShotTo (- (gCombatEgoActor x:) 20) (gCombatEgoActor y:)
					)
				)
				(proc810_13 0 911)
			)
			(2
				(= ticks 20)
			)
			(3
				(= local2 0)
				(gCombatEgoActor setMotion: 0)
				(if (IsFlag 386)
					(gPuzzleBar state: (& (gPuzzleBar state:) $ffdf))
				else
					(gPuzzleBar noHands: 0)
					(gCombatEgoActor cue:)
				)
				(self dispose:)
			)
		)
	)
)

(instance cSpell of CombatSpell
	(properties
		signal 16384
		xStep 10
		moveSpeed 0
	)

	(method (init)
		(= global193 self)
		(super init: &rest)
		(self cue:)
	)

	(method (cue)
		(self hide:)
	)

	(method (toDamage &tmp temp0 temp1 temp2)
		(= temp1 0)
		(self setMotion: 0)
		(if
			(or
				(and (< y 100) (& global192 $0001))
				(and (> y 100) (& global192 $0002))
			)
			(= temp1 1)
		)
		(= temp2
			(if (and (== (gCombatEgoActor view:) 45) (== (gCombatEgoActor loop:) 9))
				(if (< (= temp0 (/ [gEgoStats 17] 4)) 15) 15 else temp0) ; health
			else
				10
			)
		)
		(if global454
			(= temp2 (/ (* temp2 [gEgoStats 39]) 400)) ; resistanceSpell
		)
		(if temp1
			(gCombatEgoActor getHurt: (/ temp2 5))
			(self setLoop: 2 1 cel: 0 setCycle: End self)
		else
			(gCombatEgoActor getHurt: temp2 setScript: getSpellHit)
		)
	)
)

(instance cBloodDrop of SActor
	(properties
		view 26
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

(instance egoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch gHeroType
					(2 ; Thief
						(client setScript: thiefScript)
					)
					(1 ; Magic User
						(client setScript: magicScript)
					)
					(else
						(client setScript: fighterScript)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance fighterScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks (Random 2 local3))
			)
			(1
				(SetNowSeen gCombatEgoActor)
				(SetNowSeen chernovy)
				(= temp0 (- (chernovy nsLeft:) (gCombatEgoActor nsRight:)))
				(cond
					(
						(and
							(cSpell active:)
							(< (- (cSpell x:) (gCombatEgoActor nsRight:)) 40)
							(> (cSpell x:) (gCombatEgoActor nsLeft:))
						)
						(cond
							((and (< temp0 25) (> global178 3))
								(if (> (cSpell y:) 100)
									(cond
										((> [gEgoStats 18] 7) ; stamina
											(cond
												((not global178)
													(self cue:)
												)
												((> global178 9)
													(self
														setScript:
															(ScriptID 41 6) ; xParryLow
															self
													)
												)
												(else
													(self
														setScript:
															(ScriptID 810 4) ; jumpUp
															self
													)
												)
											)
										)
										((proc810_12 global178)
											(self
												setScript: (ScriptID 41 6) self ; xParryLow
											)
										)
										(else
											(self cue:)
										)
									)
								else
									(self setScript: (ScriptID 41 4) self) ; xDuck
								)
							)
							(
								(and
									(< temp0 30)
									(proc810_12 global176)
									(> [gEgoStats 18] 7) ; stamina
								)
								(self setScript: (ScriptID 810 6) self) ; jumpAttack
							)
							((> [gEgoStats 18] 7) ; stamina
								(self setScript: (ScriptID 810 5) self) ; jumpForward
							)
							((> (cSpell y:) 100)
								(if (proc810_12 global178)
									(self setScript: (ScriptID 41 6) self) ; xParryLow
								else
									(self cue:)
								)
							)
							(else
								(self setScript: (ScriptID 41 4) self) ; xDuck
							)
						)
					)
					(
						(and
							(proc810_12 global178)
							(or (< [gEgoStats 18] 2) (== global176 0)) ; stamina
							(> (gCombatEgoActor nsLeft:) 20)
						)
						(self setScript: (ScriptID 41 3) self) ; xBackward
					)
					((and (> temp0 20) (proc810_12 global176))
						(cond
							((and (< temp0 5) (> [gEgoStats 18] 7)) ; stamina
								(self setScript: (ScriptID 810 7) self) ; jumpVAttack
							)
							((and (< temp0 40) (> [gEgoStats 18] 7)) ; stamina
								(self setScript: (ScriptID 810 6) self) ; jumpAttack
							)
							((> [gEgoStats 18] 10) ; stamina
								(self setScript: (ScriptID 41 2) self) ; xForward
							)
							(
								(and
									(proc810_12 global177)
									(> temp0 40)
									(> [gEgoStats 18] 5) ; stamina
									(> [gEgoStats 19] 5) ; mana
									(not (gEgoSpell active:))
								)
								(if
									(or
										[gEgoStats 28] ; forceSpell
										[gEgoStats 33] ; lightningSpell
										[gEgoStats 34] ; frostSpell
									)
									(self
										setScript:
											(ScriptID 41 5) ; xdoSpell
											self
											(Random 0 1)
									)
								else
									(self setScript: (ScriptID 41 5) self 0) ; xdoSpell
								)
							)
							(else
								(self cue:)
							)
						)
					)
					(
						(and
							(proc810_12 global177)
							(> temp0 40)
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
					((< temp0 10)
						(if (> [gEgoStats 18] 7) ; stamina
							(cond
								((not (proc810_12 global176))
									(self setScript: (ScriptID 41 1) self) ; xSlash
								)
								((< temp0 5)
									(self setScript: (ScriptID 810 7) self) ; jumpVAttack
								)
								(else
									(self setScript: (ScriptID 41 1) self) ; xSlash
								)
							)
						else
							(self cue:)
						)
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

(instance magicScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks (Random 2 local3))
			)
			(1
				(SetNowSeen gCombatEgoActor)
				(SetNowSeen chernovy)
				(= temp0 (- (chernovy nsLeft:) (gCombatEgoActor nsRight:)))
				(cond
					((< [gEgoStats 19] 1) ; mana
						(client setScript: fighterScript)
					)
					((< temp0 10)
						(cond
							((> [gEgoStats 18] 7) ; stamina
								(if (or (proc810_12 global176) (> temp0 5))
									(self setScript: (ScriptID 41 1) self) ; xSlash
								else
									(self setScript: (ScriptID 810 7) self) ; jumpVAttack
								)
							)
							(
								(and
									(cSpell active:)
									(< (- (cSpell x:) (gCombatEgoActor nsRight:)) 40)
									(> (cSpell x:) (gCombatEgoActor nsLeft:))
								)
								(if (> (cSpell y:) 100)
									(cond
										((> [gEgoStats 18] 7) ; stamina
											(self
												setScript: (ScriptID 810 4) self ; jumpUp
											)
										)
										((proc810_12 global178)
											(self
												setScript: (ScriptID 41 6) self ; xParryLow
											)
										)
										(else
											(self cue:)
										)
									)
								else
									(self setScript: (ScriptID 41 4) self) ; xDuck
								)
							)
							(else
								(self cue:)
							)
						)
					)
					(
						(and
							(cSpell active:)
							(< (- (cSpell x:) (gCombatEgoActor nsRight:)) 40)
							(> (cSpell x:) (gCombatEgoActor nsLeft:))
						)
						(if (> (cSpell y:) 100)
							(cond
								((> [gEgoStats 18] 7) ; stamina
									(cond
										((not global178)
											(self cue:)
										)
										((> global178 9)
											(self
												setScript: (ScriptID 41 6) self ; xParryLow
											)
										)
										(else
											(self
												setScript: (ScriptID 810 4) self ; jumpUp
											)
										)
									)
								)
								((proc810_12 global178)
									(self setScript: (ScriptID 41 6) self) ; xParryLow
								)
								(else
									(self cue:)
								)
							)
						else
							(self setScript: (ScriptID 41 4) self) ; xDuck
						)
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
					((and (proc810_12 global176) (> temp0 20))
						(self setScript: (ScriptID 41 2) self) ; xForward
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

(instance thiefScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= ticks (Random 2 local3))
			)
			(1
				(SetNowSeen gCombatEgoActor)
				(SetNowSeen chernovy)
				(= temp0 (- (chernovy nsLeft:) (gCombatEgoActor nsRight:)))
				(cond
					(
						(and
							(cSpell active:)
							(< (- (cSpell x:) (gCombatEgoActor nsRight:)) 40)
							(> (cSpell x:) (gCombatEgoActor nsLeft:))
							(> global178 1)
						)
						(if (> (cSpell y:) 100)
							(cond
								((> [gEgoStats 18] 7) ; stamina
									(cond
										((not global178)
											(self cue:)
										)
										((> global178 9)
											(self
												setScript: (ScriptID 41 6) self ; xParryLow
											)
										)
										(else
											(self
												setScript: (ScriptID 810 4) self ; jumpUp
											)
										)
									)
								)
								((proc810_12 global178)
									(self setScript: (ScriptID 41 6) self) ; xParryLow
								)
								(else
									(self cue:)
								)
							)
						else
							(self setScript: (ScriptID 41 4) self) ; xDuck
						)
					)
					((< temp0 10)
						(cond
							((> [gEgoStats 18] 7) ; stamina
								(if (or (proc810_12 global176) (> temp0 3))
									(self setScript: (ScriptID 41 1) self) ; xSlash
								else
									(self setScript: (ScriptID 810 7) self) ; jumpVAttack
								)
							)
							(
								(and
									(cSpell active:)
									(< (- (cSpell x:) (gCombatEgoActor nsRight:)) 40)
									(> (cSpell x:) (gCombatEgoActor nsLeft:))
									(> global178 1)
								)
								(if (> (cSpell y:) 100)
									(cond
										((> [gEgoStats 18] 7) ; stamina
											(self
												setScript: (ScriptID 810 4) self ; jumpUp
											)
										)
										((proc810_12 global178)
											(self
												setScript: (ScriptID 41 6) self ; xParryLow
											)
										)
										(else
											(self cue:)
										)
									)
								else
									(self setScript: (ScriptID 41 4) self) ; xDuck
								)
							)
							(else
								(self cue:)
							)
						)
					)
					(
						(and
							(> [gEgoStats 18] 100) ; stamina
							(> temp0 30)
							(proc810_12 global176)
							(proc810_12 global179)
						)
						(-= [gEgoStats 18] 35) ; stamina
						(= temp1 (proc810_1 18))
						(UpdateScreenItem
							((ScriptID 40 3) ; xStaminaPart
								x: (- temp1 46)
								setInsetRect: (- 80 temp1) 0 80 2
								yourself:
							)
						)
						(self setScript: (ScriptID 810 9) self) ; toBomb
					)
					(
						(and
							(> ((gInventory at: 5) amount:) 1) ; theThrowdagger
							(not (gDagger active:))
						)
						(= global187 16)
						(self setScript: (ScriptID 810 8) self) ; throwDagger
					)
					(
						(and
							(proc810_12 global177)
							(> [gEgoStats 18] 5) ; stamina
							(> [gEgoStats 19] 5) ; mana
							(> temp0 30)
							(not (gEgoSpell active:))
						)
						(if (or [gEgoStats 28] [gEgoStats 33] [gEgoStats 34]) ; forceSpell, lightningSpell, frostSpell
							(self setScript: (ScriptID 41 5) self (Random 0 1)) ; xdoSpell
						else
							(self setScript: (ScriptID 41 5) self 0) ; xdoSpell
						)
					)
					((and (proc810_12 global176) (> temp0 20))
						(self setScript: (ScriptID 41 2) self) ; xForward
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

