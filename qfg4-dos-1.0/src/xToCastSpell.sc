;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 41)
(include sci.sh)
(use Main)
(use SView)
(use combat)
(use Motion)
(use User)
(use System)

(public
	xToCastSpell 0
	xSlash 1
	xForward 2
	xBackward 3
	xDuck 4
	xdoSpell 5
	xParryLow 6
	xGoForward 7
	xGoBackward 8
)

(instance xGoForward of Script
	(properties)

	(method (init)
		(= register 0)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(SetNowSeen gCombatMonsterActor)
		(SetNowSeen gCombatEgoActor)
		(cond
			(
				(or
					(OneOf ((gPuzzleBar combatEvent:) type:) 2 8 64)
					(and
						(& ((gPuzzleBar combatEvent:) type:) $0200)
						(>= ((gPuzzleBar combatEvent:) roll:) 0)
					)
				)
				(= register 1)
			)
			((>= (gCombatEgoActor nsRight:) (gCombatMonsterActor nsLeft:))
				(if (gCombatEgoActor cel:)
					(gCombatEgoActor x: (+ (gCombatEgoActor x:) 17))
				)
				(gCombatEgoActor cue:)
				(self dispose:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(<
						(+ (gCombatEgoActor x:) (gCombatEgoActor width:))
						(- (gCombatMonsterActor x:) (gCombatMonsterActor width:))
					)
					(gCombatEgoActor
						view: (gCombatEgoActor typeView:)
						loop: 1
						cel: 0
						cycleSpeed: 6
						attackCode: 0
						setCycle: End self
					)
				else
					(gCombatEgoActor cue:)
					(self dispose:)
				)
			)
			(1
				(gCombatEgoActor setLoop: 0 x: (+ (gCombatEgoActor x:) 20))
				(if register
					(gCombatEgoActor cue:)
					(self dispose:)
				else
					(self changeState: 0)
				)
			)
		)
	)
)

(instance xGoBackward of Script
	(properties)

	(method (init)
		(= register 0)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(cond
			(
				(or
					(OneOf ((User curEvent:) type:) evMOUSERELEASE evKEYUP $0040) ; joyDown
					(and
						(& ((gPuzzleBar combatEvent:) type:) $0200)
						(<= ((gPuzzleBar combatEvent:) roll:) 0)
					)
				)
				(= register 1)
			)
			((<= (gCombatEgoActor x:) 35)
				(gCombatEgoActor cue:)
				(self dispose:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gCombatEgoActor x:) 25)
					(gCombatEgoActor
						view: (gCombatEgoActor typeView:)
						loop: 1
						cel: 4
						x: (- (gCombatEgoActor x:) 30)
						attackCode: 1
						cycleSpeed: 6
						setCycle: Beg self
					)
				else
					(self dispose:)
				)
			)
			(1
				(if register
					(gCombatEgoActor cue:)
					(self dispose:)
				else
					(self changeState: 0)
				)
			)
		)
	)
)

(instance xToCastSpell of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(switch state
			(0
				(if (OneOf ((gPuzzleBar combatEvent:) type:) 2 8 64)
					(gCombatEgoActor cue:)
					(self dispose:)
				)
			)
			(1
				(cond
					((OneOf ((gPuzzleBar combatEvent:) type:) 2 8 64)
						(self cue:)
					)
					(
						(or
							(> global186 38)
							(< [gEgoStats 19] 0) ; mana
							(< [gEgoStats 18] 0) ; stamina
						)
						(self cue:)
					)
					(else
						(-- [gEgoStats 18]) ; stamina
						(= temp0 (proc810_1 18))
						(UpdateScreenItem
							((ScriptID 40 3) ; xStaminaPart
								x: (- temp0 46)
								setInsetRect: (- 80 temp0) 0 80 2
								yourself:
							)
						)
						((ScriptID 40 1) ; xLeftSpell
							x: (- ((ScriptID 40 1) x:) 3) ; xLeftSpell
							setInsetRect: 0 0 (+= global186 3) 2
						)
						((ScriptID 40 2) ; xRightSpell
							x: (+ ((ScriptID 40 2) x:) 3) ; xRightSpell
							setInsetRect: (- 40 global186) 0 40 2
						)
						(UpdateScreenItem (ScriptID 40 1)) ; xLeftSpell
						(UpdateScreenItem (ScriptID 40 2)) ; xRightSpell
					)
				)
			)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gCombatEgoActor
					view: (gCombatEgoActor typeView:)
					loop: 11
					cel: 0
					attackCode: 21
				)
				(= ticks 20)
				(= global189 0)
			)
			(1 0)
			(2
				(if (>= global186 38)
					(/= global165 3)
					(= global189 1)
				else
					(-= global165 (/ (+ global186 1) 4))
				)
				(gCombatEgoActor cue:)
				((ScriptID 40 1) x: 159 setInsetRect: 0 0 0 0) ; xLeftSpell
				((ScriptID 40 2) x: 119 setInsetRect: 0 0 0 -1) ; xRightSpell
				(UpdateScreenItem (ScriptID 40 1)) ; xLeftSpell
				(UpdateScreenItem (ScriptID 40 2)) ; xRightSpell
				(gEgoSpell
					myTarget: gCombatMonsterActor
					setLoop:
						(switch register
							((ScriptID 40 9) ; xFlameButton
								(if (>= global186 38) 8 else 3)
							)
							(else
								(if (>= global186 38) 6 else 0)
							)
						)
						1
					cel: 0
					x: (+ (gCombatEgoActor x:) 55)
					y: (= temp0 (- (gCombatEgoActor y:) 35))
					setPri: (+ (gCombatEgoActor priority:) 5)
					setCycle: Fwd
					setMotion: ShotTo 330 temp0 gEgoSpell
					show:
				)
				(= global186 0)
				(self dispose:)
			)
		)
	)
)

(instance xSlash of Script
	(properties)

	(method (doit)
		(super doit:)
		(SetNowSeen gCombatEgoActor)
		(if
			(and
				register
				(or
					(gCombatMonsterActor
						onMe:
							(+ (gCombatEgoActor nsLeft:) global182)
							(+ (gCombatEgoActor nsTop:) global183)
					)
					(and
						(== state 1)
						(| (SetNowSeen gCombatMonsterActor) $0001)
						(>= (gCombatEgoActor nsRight:) (gCombatMonsterActor nsLeft:))
					)
				)
			)
			(++ global167)
			(= register 0)
			((ScriptID 810 3) ; bloodDrop
				x: (+ (gCombatEgoActor nsLeft:) global182)
				y: (+ (gCombatEgoActor nsTop:) global183)
				cel: 0
				setCycle: End (ScriptID 810 3) ; bloodDrop
				setPri: (+ (gCombatMonsterActor priority:) 2)
				show:
			)
			(gCombatMonsterActor getHurt: 2)
			(gCombatEgoActor dedectPts: (proc810_2))
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= register 1)
				(gCombatEgoActor
					view: (gCombatEgoActor typeView:)
					setLoop: 7 1
					cel: 0
					cycleSpeed: 5
					attackCode: 4
					setCycle: CT 3 1 self
				)
				(proc810_13 0 901)
			)
			(1
				(= ticks 10)
			)
			(2
				(gCombatEgoActor setCycle: End self)
			)
			(3
				(-= [gEgoStats 18] (Random 5 15)) ; stamina
				(= temp0 (proc810_1 18))
				(UpdateScreenItem
					((ScriptID 40 3) ; xStaminaPart
						x: (- temp0 46)
						setInsetRect: (- 80 temp0) 0 80 2
						yourself:
					)
				)
				(gCombatEgoActor cue:)
				(self dispose:)
			)
		)
	)
)

(instance xForward of Script
	(properties)

	(method (init)
		(= register 0)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(SetNowSeen gCombatMonsterActor)
		(SetNowSeen gCombatEgoActor)
		(if
			(or
				(< global176 1)
				(>= (gCombatEgoActor nsRight:) (gCombatMonsterActor nsLeft:))
				(and
					global193
					(global193 active:)
					(< (- (global193 x:) (gCombatEgoActor nsRight:)) 45)
					(> (global193 x:) (gCombatEgoActor nsLeft:))
				)
			)
			(if (gCombatEgoActor cel:)
				(gCombatEgoActor x: (+ (gCombatEgoActor x:) 17))
			)
			(gCombatEgoActor cue:)
			(self dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCombatEgoActor
					view: (gCombatEgoActor typeView:)
					loop: 1
					cel: 0
					cycleSpeed: 6
					attackCode: 0
					setCycle: End self
				)
			)
			(1
				(gCombatEgoActor setLoop: 0 x: (+ (gCombatEgoActor x:) 20))
				(if register
					(gCombatEgoActor cue:)
					(self dispose:)
				else
					(self changeState: 0)
				)
			)
		)
	)
)

(instance xBackward of Script
	(properties)

	(method (init)
		(= register 0)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(if (<= (gCombatEgoActor x:) 40)
			(gCombatEgoActor cue:)
			(self dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gCombatEgoActor x:) 25)
					(gCombatEgoActor
						view: (gCombatEgoActor typeView:)
						loop: 1
						cel: 4
						x: (- (gCombatEgoActor x:) 30)
						attackCode: 1
						cycleSpeed: 6
						setCycle: Beg self
					)
				else
					(self dispose:)
				)
			)
			(1
				(if register
					(gCombatEgoActor cue:)
					(self dispose:)
				else
					(self changeState: 0)
				)
			)
		)
	)
)

(instance xDuck of Script
	(properties)

	(method (init)
		(= register 1)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				global193
				register
				(| (SetNowSeen gCombatEgoActor) $0001)
				(or
					(not (global193 active:))
					(< (global193 x:) (gCombatEgoActor nsLeft:))
				)
			)
			(= register 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCombatEgoActor
					view: (+ (gCombatEgoActor typeView:) 1)
					setLoop: 6 1
					cel: 0
					attackCode: 6
				)
				(++ global168)
			)
			(1
				(gCombatEgoActor cue:)
				(self dispose:)
			)
		)
	)
)

(instance xParryLow of Script
	(properties)

	(method (init)
		(= register 1)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				register
				(or
					(and global193 (not (global193 active:)))
					(and
						global193
						(| (SetNowSeen gCombatEgoActor) $0001)
						(< (global193 x:) (gCombatEgoActor nsLeft:))
					)
				)
			)
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
				(++ global169)
			)
			(1
				(gCombatEgoActor cue:)
				(&= global192 $fffd)
				(self dispose:)
			)
		)
	)
)

(instance xdoSpell of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(if (== state 1)
			(SetNowSeen gCombatEgoActor)
			(SetNowSeen gCombatMonsterActor)
			(if
				(or
					(> global186 38)
					(< [gEgoStats 19] 0) ; mana
					(< [gEgoStats 18] 0) ; stamina
					(< (- (gCombatMonsterActor nsLeft:) (gCombatEgoActor nsRight:)) 25)
					(< global177 1)
					(and
						global193
						(global193 active:)
						(< (- (global193 x:) (gCombatEgoActor nsRight:)) 45)
						(> (global193 x:) (gCombatEgoActor nsLeft:))
					)
				)
				(self cue:)
			else
				(-- [gEgoStats 18]) ; stamina
				(= temp0 (proc810_1 18))
				(UpdateScreenItem
					((ScriptID 40 3) ; xStaminaPart
						x: (- temp0 46)
						setInsetRect: (- 80 temp0) 0 80 2
						yourself:
					)
				)
				((ScriptID 40 1) ; xLeftSpell
					x: (- ((ScriptID 40 1) x:) 3) ; xLeftSpell
					setInsetRect: 0 0 (+= global186 3) 2
				)
				((ScriptID 40 2) ; xRightSpell
					x: (+ ((ScriptID 40 2) x:) 3) ; xRightSpell
					setInsetRect: (- 40 global186) 0 40 2
				)
				(UpdateScreenItem (ScriptID 40 1)) ; xLeftSpell
				(UpdateScreenItem (ScriptID 40 2)) ; xRightSpell
			)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gCombatEgoActor
					view: (gCombatEgoActor typeView:)
					loop: 11
					cel: 0
					attackCode: 21
				)
				(= ticks 20)
				(= global189 0)
			)
			(1
				(SetNowSeen gCombatEgoActor)
				(SetNowSeen gCombatMonsterActor)
				(if (> (- (gCombatMonsterActor nsLeft:) (gCombatEgoActor nsLeft:)) 80)
					(if (proc810_12 global179)
						(= cycles 15)
					else
						(= cycles (Random 3 6))
					)
				else
					(= cycles (Random 2 4))
				)
			)
			(2
				(gCombatEgoActor cue:)
				((ScriptID 40 1) x: 159 setInsetRect: 0 0 0 0) ; xLeftSpell
				((ScriptID 40 2) x: 119 setInsetRect: 0 0 0 -1) ; xRightSpell
				(UpdateScreenItem (ScriptID 40 1)) ; xLeftSpell
				(UpdateScreenItem (ScriptID 40 2)) ; xRightSpell
				(gEgoSpell
					myTarget: gCombatMonsterActor
					setLoop:
						(if register
							(= global367 10)
							(++ global172)
							(= global165 20)
							(gEgoSpell type: 26)
							(if (>= global186 38) 8 else 3)
						else
							(switch (Random 0 2)
								(0
									(cond
										([gEgoStats 28] ; forceSpell
											(= global367 12)
											(= global165 30)
											(gEgoSpell type: 28)
											(++ global173)
										)
										([gEgoStats 33] ; lightningSpell
											(= global367 8)
											(= global165 16)
											(gEgoSpell type: 33)
											(++ global174)
										)
										([gEgoStats 34] ; frostSpell
											(= global367 8)
											(= global165 16)
											(gEgoSpell type: 34)
											(++ global175)
										)
									)
								)
								(1
									(cond
										([gEgoStats 33] ; lightningSpell
											(= global367 8)
											(= global165 16)
											(gEgoSpell type: 33)
											(++ global174)
										)
										([gEgoStats 28] ; forceSpell
											(= global367 12)
											(= global165 30)
											(gEgoSpell type: 28)
											(++ global173)
										)
										([gEgoStats 34] ; frostSpell
											(= global367 8)
											(= global165 16)
											(gEgoSpell type: 34)
											(++ global175)
										)
									)
								)
								(else
									(cond
										([gEgoStats 34] ; frostSpell
											(= global367 8)
											(= global165 16)
											(gEgoSpell type: 34)
											(++ global175)
										)
										([gEgoStats 33] ; lightningSpell
											(= global367 8)
											(= global165 16)
											(gEgoSpell type: 33)
											(++ global174)
										)
										([gEgoStats 28] ; forceSpell
											(= global367 12)
											(= global165 30)
											(gEgoSpell type: 28)
											(++ global173)
										)
									)
								)
							)
							(if (>= global186 38) 6 else 0)
						)
						1
					cel: 0
					x: (+ (gCombatEgoActor x:) 55)
					y: (= temp0 (- (gCombatEgoActor y:) 35))
					setPri: (+ (gCombatEgoActor priority:) 5)
					setCycle: Fwd
					setMotion: ShotTo 330 temp0 gEgoSpell
					show:
				)
				(if (>= global186 38)
					(/= global165 3)
					(= global189 1)
				else
					(-= global165 (/ (+ global186 1) 4))
				)
				(= global186 0)
				(self dispose:)
			)
		)
	)
)

