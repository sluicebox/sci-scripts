;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 850)
(include sci.sh)
(use Main)
(use SView)
(use combat)
(use Motion)
(use System)

(public
	wraith 0
	egoScript 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance wraith of SActor
	(properties
		x 273
		y 158
		view 851
		signal 16384
		cycleSpeed 16
		explodeX 20
	)

	(method (init)
		(super init: &rest)
		(wSpell init: gPuzzleBar)
		(if (IsFlag 381)
			(= local3 3)
		else
			(= local3 (/ 30 global439))
		)
		(if
			(OneOf
				gPrevRoomNum
				551
				552
				553
				554
				555
				556
				557
				558
				559
				560
				561
				562
				563
				564
				565
				566
				567
				568
				569
				570
				571
				572
				573
				574
				575
				576
				577
				578
				579
				580
				581
				582
				583
				584
				585
				586
				587
				588
				589
				590
				591
				592
				593
			)
			(cRocks init: gPuzzleBar)
		)
		(switch global439
			(1
				(= local0 60)
				(= local1 80)
			)
			(2
				(= local0 25)
				(= local1 45)
			)
			(else
				(= local0 15)
				(= local1 30)
			)
		)
		(if (!= global439 3)
			(switch gHeroType
				(2 ; Thief
					(= global176 3)
					(= global177 4)
					(= global178 7)
					(= global179 5)
				)
				(1 ; Magic User
					(= global176 0)
					(= global177 10)
					(= global178 10)
				)
				(else
					(= global176 7)
					(= global177 2)
					(= global178 5)
				)
			)
		)
		(= local5 (- 13 (/ (+ [gEgoStats 1] [gEgoStats 2]) 100))) ; intelligence, agility
		(= local4
			(if (not (gEgo has: 37)) ; theAmulet
				(not global449)
			)
		)
		(self cue: setScript: wraithCombat)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (and local4 (not (-- local3)))
			(if (IsFlag 381)
				(= local3 3)
			else
				(= local3 (/ 30 global439))
			)
			(if (>= (-= [gEgoStats 17] global439) 0) ; health
				(= temp0 (proc810_1 17))
				(UpdateScreenItem
					((ScriptID 40 5) ; xHealthPart
						x: (- temp0 94)
						setInsetRect: (- 104 temp0) 0 104 2
						yourself:
					)
				)
			else
				(= gCombatResult 1)
				(gPuzzleBar state: (& (gPuzzleBar state:) $ffdf))
			)
		)
	)

	(method (cue)
		(self view: 851 y: 148 setLoop: 0 1 cel: 0 cycleSpeed: 16 setCycle: Fwd)
	)

	(method (getHurt param1)
		(switch param1
			(0
				(if (or (!= (wraith attackCode:) 23) global189)
					(self setScript: hurtBySpell)
				)
			)
			(2
				(self setScript: hurtByDagger)
			)
		)
	)
)

(instance cRocks of SView
	(properties
		x 280
		y 140
		view 851
		loop 9
	)

	(method (doVerb)
		(gCombatMonsterActor doVerb:)
	)
)

(instance hurtByDagger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wraith setLoop: 1 1 cel: 0 setCycle: End self)
				(proc810_13 1 853)
			)
			(1
				(if (IsFlag 386)
					(gPuzzleBar state: (& (gPuzzleBar state:) $ffdf))
					(self dispose:)
				else
					(wraith cue:)
					(client setScript: wraithCombat)
				)
			)
		)
	)
)

(instance hurtBySpell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wraith cycleSpeed: 3 setLoop: 7 1 cel: 0 setCycle: End self)
				(proc810_13 1 853)
			)
			(1
				(if (IsFlag 386)
					(gPuzzleBar state: (& (gPuzzleBar state:) $ffdf))
					(self dispose:)
				else
					(wraith cue:)
					(client setScript: wraithCombat)
				)
			)
		)
	)
)

(instance blockIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wraith
					attackCode: 23
					cycleSpeed: 1
					setLoop: 2 1
					cel: 0
					setCycle: End self
				)
				(proc810_13 1 942)
			)
			(1
				(if (gEgoSpell active:)
					(self changeState: 0)
				else
					(wraith attackCode: 0 cue:)
					(self dispose:)
				)
			)
		)
	)
)

(instance wraithCombat of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks (Random local0 local1))
			)
			(1
				(SetNowSeen wraith)
				(SetNowSeen gCombatEgoActor)
				(= temp0 (- (wraith nsLeft:) (gCombatEgoActor nsRight:)))
				(cond
					((gEgoSpell active:)
						(cond
							((> global439 1)
								(switch (Random 0 4)
									(0
										(if (== global439 3)
											(self setScript: blockIt self)
										else
											(self cue:)
										)
									)
									(1
										(self setScript: blockIt self)
									)
									(2
										(if (== global439 3)
											(self setScript: blockIt self)
										else
											(self cue:)
										)
									)
									(3
										(self cue:)
									)
									(else
										(self setScript: blockIt self)
									)
								)
							)
							((Random 0 4)
								(self cue:)
							)
							(else
								(self setScript: blockIt self)
							)
						)
					)
					(local2
						(self cue:)
					)
					((not (wSpell active:))
						(if (< temp0 5)
							(if (Random 0 global439)
								(self setScript: throwEgo self)
							else
								(self cue:)
							)
						else
							(switch (Random 0 4)
								(0
									(self cue:)
								)
								(1
									(self setScript: castLSpell self)
								)
								(2
									(self setScript: castLSpell self)
								)
								(else
									(self setScript: castHSpell self)
								)
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

(instance throwEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wraith cycleSpeed: 6 setLoop: 5 1 cel: 0 setCycle: End self)
			)
			(1
				(wraith cue:)
				(gPuzzleBar noHands: 1)
				(gCombatEgoActor
					setScript: 0
					getHurt: 12
					view: (gCombatEgoActor typeView:)
					moveSpeed: 0
					xStep: 10
					setLoop: 2 1
					cel: 0
					setCycle: End
				)
				(if (> (gCombatEgoActor x:) 45)
					(gCombatEgoActor
						setMotion:
							ShotTo
							(- (gCombatEgoActor x:) 45)
							(gCombatEgoActor y:)
							self
					)
				)
				(proc810_13 0 904)
			)
			(2
				(ShakeScreen 3)
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

(instance castHSpell of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(wraith cycleSpeed: 8 setLoop: 3 1 cel: 0 setCycle: End self)
				(proc810_13 1 852)
			)
			(1
				(wSpell
					setLoop: 1 1
					cel: 0
					myTarget: gCombatEgoActor
					x: (- (wraith x:) 50)
					y: (= temp0 (- (wraith y:) 35))
					setPri: (+ (wraith priority:) 5)
					setCycle: Fwd
					setMotion: MoveTo 0 temp0 wSpell
					show:
				)
				(wraith cue:)
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
				(wraith cycleSpeed: 8 setLoop: 4 1 cel: 0 setCycle: End self)
				(proc810_13 1 852)
			)
			(1
				(wSpell
					cycleSpeed: 3
					setLoop: 1 1
					cel: 0
					myTarget: gCombatEgoActor
					x: (- (wraith x:) 50)
					y: (= temp0 (- (wraith y:) 60))
					setPri: (+ (wraith priority:) 5)
					setCycle: Fwd
					setMotion: MoveTo 0 temp0 wSpell
					show:
				)
				(wraith cue:)
				(self dispose:)
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
				(wSpell setLoop: 2 1 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(VibrateMouse 4 1 1)
				(wSpell setCycle: End wSpell)
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
				(gCombatEgoActor setMotion: 0)
				(= local2 0)
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

(instance wSpell of CombatSpell
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
				(and (< y 110) (& global192 $0001))
				(and (> y 110) (& global192 $0002))
			)
			(= temp1 1)
		)
		(= temp2
			(if (and (== (gCombatEgoActor view:) 45) (== (gCombatEgoActor loop:) 9))
				(if (< (= temp0 (/ [gEgoStats 17] 4)) 15) 15 else temp0) ; health
			else
				8
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
				(= ticks (Random 2 local5))
			)
			(1
				(SetNowSeen gCombatEgoActor)
				(SetNowSeen wraith)
				(= temp0 (- (wraith nsLeft:) (gCombatEgoActor nsRight:)))
				(cond
					(
						(and
							(proc810_12 global178)
							(or (< [gEgoStats 18] 2) (== global176 0)) ; stamina
							(> (gCombatEgoActor nsLeft:) 20)
						)
						(self setScript: (ScriptID 41 3) self) ; xBackward
					)
					(
						(and
							(> global178 1)
							(wSpell active:)
							(< (- (wSpell x:) (gCombatEgoActor nsRight:)) 40)
							(> (wSpell x:) (gCombatEgoActor nsLeft:))
						)
						(cond
							((< temp0 25)
								(cond
									((> (wSpell y:) 100)
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
													setScript:
														(ScriptID 41 6) ; xParryLow
														self
												)
											)
											(else
												(self cue:)
											)
										)
									)
									((proc810_12 global178)
										(self setScript: (ScriptID 41 4) self) ; xDuck
									)
									(else
										(self cue:)
									)
								)
							)
							(
								(and
									(proc810_12 global176)
									(< temp0 5)
									(> [gEgoStats 18] 7) ; stamina
									(> (wSpell y:) 100)
								)
								(self setScript: (ScriptID 810 7) self) ; jumpVAttack
							)
							((> (wSpell y:) 100)
								(cond
									((> [gEgoStats 18] 7) ; stamina
										(self setScript: (ScriptID 810 5) self) ; jumpForward
									)
									((proc810_12 global178)
										(self setScript: (ScriptID 41 6) self) ; xParryLow
									)
									(else
										(self cue:)
									)
								)
							)
							(else
								(self setScript: (ScriptID 41 4) self) ; xDuck
							)
						)
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
									(> [gEgoStats 19] 5) ; mana
									(proc810_12 global177)
									(> temp0 40)
									(> [gEgoStats 18] 5) ; stamina
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
							(> [gEgoStats 19] 5) ; mana
							(proc810_12 global177)
							(> temp0 40)
							(> [gEgoStats 18] 5) ; stamina
							(not (gEgoSpell active:))
						)
						(if (or [gEgoStats 28] [gEgoStats 33] [gEgoStats 34]) ; forceSpell, lightningSpell, frostSpell
							(self setScript: (ScriptID 41 5) self (Random 0 1)) ; xdoSpell
						else
							(self setScript: (ScriptID 41 5) self 0) ; xdoSpell
						)
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
									(wSpell active:)
									(< (- (wSpell x:) (gCombatEgoActor nsRight:)) 40)
									(> (wSpell x:) (gCombatEgoActor nsLeft:))
								)
								(if (> (wSpell y:) 100)
									(cond
										((> [gEgoStats 18] 7) ; stamina
											(self
												setScript: (ScriptID 810 5) self ; jumpForward
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
				(= ticks (Random 2 local5))
			)
			(1
				(SetNowSeen gCombatEgoActor)
				(SetNowSeen wraith)
				(= temp0 (- (wraith nsLeft:) (gCombatEgoActor nsRight:)))
				(cond
					((or (< [gEgoStats 19] 1) (< [gEgoStats 17] 50)) ; mana, health
						(client setScript: fighterScript)
					)
					(
						(and
							(proc810_12 global178)
							(or (< [gEgoStats 18] 2) (== global176 0)) ; stamina
							(> (gCombatEgoActor nsLeft:) 20)
						)
						(self setScript: (ScriptID 41 3) self) ; xBackward
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
									(wSpell active:)
									(< (- (wSpell x:) (gCombatEgoActor nsRight:)) 40)
									(> (wSpell x:) (gCombatEgoActor nsLeft:))
								)
								(if (> (wSpell y:) 100)
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
							(else
								(self cue:)
							)
						)
					)
					(
						(and
							(> global178 1)
							(wSpell active:)
							(< (- (wSpell x:) (gCombatEgoActor nsRight:)) 40)
							(> (wSpell x:) (gCombatEgoActor nsLeft:))
						)
						(if (> (wSpell y:) 100)
							(cond
								((> [gEgoStats 18] 7) ; stamina
									(if (> global178 9)
										(self setScript: (ScriptID 41 6) self) ; xParryLow
									else
										(self setScript: (ScriptID 810 4) self) ; jumpUp
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
				(= ticks (Random 2 local5))
			)
			(1
				(SetNowSeen gCombatEgoActor)
				(SetNowSeen wraith)
				(= temp0 (- (wraith nsLeft:) (gCombatEgoActor nsRight:)))
				(cond
					(
						(and
							(proc810_12 global178)
							(or (< [gEgoStats 18] 2) (== global176 0)) ; stamina
							(> (gCombatEgoActor nsLeft:) 20)
						)
						(self setScript: (ScriptID 41 3) self) ; xBackward
					)
					(
						(and
							(> global178 1)
							(wSpell active:)
							(< (- (wSpell x:) (gCombatEgoActor nsRight:)) 40)
							(> (wSpell x:) (gCombatEgoActor nsLeft:))
						)
						(if (> (wSpell y:) 100)
							(cond
								((> [gEgoStats 18] 7) ; stamina
									(if (> global178 9)
										(self setScript: (ScriptID 41 6) self) ; xParryLow
									else
										(self setScript: (ScriptID 810 4) self) ; jumpUp
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
						(if (> [gEgoStats 18] 7) ; stamina
							(if (or (proc810_12 global176) (> temp0 5))
								(self setScript: (ScriptID 41 1) self) ; xSlash
							else
								(self setScript: (ScriptID 810 7) self) ; jumpVAttack
							)
						else
							(self cue:)
						)
					)
					(
						(and
							(> [gEgoStats 18] 100) ; stamina
							(> temp0 30)
							(proc810_12 global179)
							(proc810_12 global176)
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

