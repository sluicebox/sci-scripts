;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 830)
(include sci.sh)
(use Main)
(use SView)
(use combat)
(use Motion)
(use System)

(public
	revenant 0
	egoScript 1
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance revenant of SActor
	(properties
		x 273
		y 140
		view 831
		signal 16384
		cycleSpeed 16
		xStep 6
		moveSpeed 1
		explodeX 20
	)

	(method (init)
		(super init: &rest)
		(rBloodDrop init: gPuzzleBar)
		(switch global439
			(1
				(= local0 40)
				(= local1 60)
			)
			(2
				(= local0 25)
				(= local1 40)
			)
			(else
				(= local0 5)
				(= local1 25)
			)
		)
		(if (!= global439 3)
			(switch gHeroType
				(2 ; Thief
					(= global176 0)
					(= global177 5)
					(= global178 7)
					(= global179 8)
				)
				(1 ; Magic User
					(= global176 0)
					(= global178 9)
					(= global177 10)
				)
				(else
					(= global176 0)
					(= global177 3)
					(= global178 5)
				)
			)
		)
		(= local3
			(if (not (gEgo has: 37)) ; theAmulet
				(not global449)
			)
		)
		(= local4 (- 13 (/ (+ [gEgoStats 1] [gEgoStats 2]) 100))) ; intelligence, agility
		(self cue: setScript: revenantCombat)
	)

	(method (cue)
		(self view: 831 setLoop: 0 1 cel: 0 cycleSpeed: 16 setCycle: Fwd)
	)

	(method (getHurt param1)
		(switch param1
			(0
				(if (or global189 (!= (revenant attackCode:) 23))
					(self setScript: hurtBySpell)
				)
			)
			(2
				(self setScript: hurtMyself)
			)
		)
	)
)

(instance revenantCombat of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks (Random local0 local1))
			)
			(1
				(SetNowSeen revenant)
				(SetNowSeen gCombatEgoActor)
				(= temp0 (- (revenant nsLeft:) (gCombatEgoActor nsRight:)))
				(cond
					((gEgoSpell active:)
						(self setScript: coverUp self)
					)
					((> temp0 15)
						(self setScript: revenantForward self)
					)
					(else
						(switch (Random 0 5)
							(0
								(if (< temp0 5)
									(self setScript: headButt self)
								else
									(self setScript: attackHigh self)
								)
							)
							(1
								(if (> global439 1)
									(self setScript: attackHigh self)
								else
									(self cue:)
								)
							)
							(2
								(if (< temp0 5)
									(self setScript: headButt self)
								else
									(self setScript: attackHigh self)
								)
							)
							(3
								(if (> global439 1)
									(self setScript: attackLow self)
								else
									(self cue:)
								)
							)
							(4
								(self setScript: attackLow self)
							)
							(else
								(self setScript: attackHigh self)
							)
						)
					)
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance revenantForward of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(or
				(and (gEgoSpell active:) (not state))
				(and
					(not state)
					(| (SetNowSeen gCombatEgoActor) $0001)
					(| (SetNowSeen revenant) $0001)
					(<= (revenant nsLeft:) (gCombatEgoActor nsRight:))
				)
			)
			(switch (revenant cel:)
				(1
					(revenant x: (- (revenant x:) 16))
				)
				(2
					(revenant x: (- (revenant x:) 16))
				)
				(3
					(revenant x: (- (revenant x:) 18))
				)
				(else
					(revenant x: (- (revenant x:) 19))
				)
			)
			(revenant cue:)
			(self dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(revenant cycleSpeed: 8 setLoop: 1 1 cel: 0 setCycle: End self)
			)
			(1
				(revenant x: (- (revenant x:) 20) cue:)
				(self changeState: 0)
			)
		)
	)
)

(instance coverUp of Script
	(properties)

	(method (init)
		(= local2 (= register 1))
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(if (and register (not (gEgoSpell active:)))
			(= register 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(revenant setLoop: 8 1 cel: 0 attackCode: 23)
			)
			(1
				(revenant attackCode: 0 cue:)
				(= local2 0)
				(self dispose:)
			)
		)
	)
)

(instance moveBackward of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(revenant
					x: (+ (revenant x:) 12)
					setLoop: 1 1
					cel: 5
					setCycle: Beg self
				)
			)
			(1
				(revenant cue:)
				(self dispose:)
			)
		)
	)
)

(instance attackHigh of Script
	(properties)

	(method (init)
		(= register 1)
		(super init: &rest)
	)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(SetNowSeen revenant)
		(SetNowSeen gCombatEgoActor)
		(if
			(and
				register
				(or
					(gCombatEgoActor
						onMe: (+ (revenant nsLeft:) 3) (+ (revenant nsTop:) 37)
					)
					(and
						(== state 1)
						(< (revenant nsLeft:) (gCombatEgoActor nsRight:))
					)
				)
			)
			(= register 0)
			(if (and local3 (> [gEgoStats 18] (= temp1 (* global439 3)))) ; stamina
				(-= [gEgoStats 18] temp1) ; stamina
				(= temp0 (proc810_1 18))
				(UpdateScreenItem
					((ScriptID 40 3) ; xStaminaPart
						x: (- temp0 46)
						setInsetRect: (- 80 temp0) 0 80 2
						yourself:
					)
				)
			)
			(gCombatEgoActor getHurt: 8 setScript: punchFace)
			(rBloodDrop
				x: (+ (revenant nsLeft:) 3)
				y: (+ (revenant nsTop:) 37)
				show:
				cel: 0
				setCycle: End rBloodDrop
			)
			(if (< (+ global156 temp1) 250)
				(+= global156 temp1)
				(= temp0 (proc810_1 -1))
				(UpdateScreenItem
					((ScriptID 40 6) ; xMonsterPart
						x: (+ 100 temp0)
						setInsetRect: (- 104 temp0) 0 104 2
						yourself:
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(revenant
					setLoop: 4 1
					cel: 0
					cycleSpeed: 6
					setCycle: CT 2 1 self
				)
			)
			(1
				(= ticks 10)
			)
			(2
				(revenant setCycle: End self)
			)
			(3
				(revenant cue:)
				(self dispose:)
			)
		)
	)
)

(instance attackLow of Script
	(properties)

	(method (init)
		(= register 1)
		(super init: &rest)
	)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(SetNowSeen revenant)
		(SetNowSeen gCombatEgoActor)
		(if
			(and
				register
				(or
					(gCombatEgoActor
						onMe: (+ (revenant nsLeft:) 1) (+ (revenant nsTop:) 20)
					)
					(and
						(== state 1)
						(< (revenant nsLeft:) (gCombatEgoActor nsRight:))
					)
				)
			)
			(= register 0)
			(if (and local3 (> [gEgoStats 18] (= temp1 (* global439 3)))) ; stamina
				(-= [gEgoStats 18] temp1) ; stamina
				(= temp0 (proc810_1 18))
				(UpdateScreenItem
					((ScriptID 40 3) ; xStaminaPart
						x: (- temp0 46)
						setInsetRect: (- 80 temp0) 0 80 2
						yourself:
					)
				)
			)
			(gCombatEgoActor getHurt: 8 setScript: punchFace)
			(rBloodDrop
				x: (+ (revenant nsLeft:) 1)
				y: (+ (revenant nsTop:) 20)
				show:
				cel: 0
				setCycle: End rBloodDrop
			)
			(if (< (+ global156 temp1) 250)
				(+= global156 temp1)
				(= temp0 (proc810_1 -1))
				(UpdateScreenItem
					((ScriptID 40 6) ; xMonsterPart
						x: (+ 100 temp0)
						setInsetRect: (- 104 temp0) 0 104 2
						yourself:
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(revenant
					setLoop: 5 1
					cel: 0
					cycleSpeed: 6
					setCycle: CT 3 1 self
				)
			)
			(1
				(= ticks 10)
			)
			(2
				(revenant setCycle: End self)
			)
			(3
				(revenant cue:)
				(self dispose:)
			)
		)
	)
)

(instance headButt of Script
	(properties)

	(method (init)
		(= register 1)
		(super init: &rest)
	)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(SetNowSeen revenant)
		(SetNowSeen gCombatEgoActor)
		(if
			(and
				register
				(or
					(gCombatEgoActor
						onMe: (+ (revenant nsLeft:) 6) (+ (revenant nsTop:) 22)
					)
					(gCombatEgoActor
						onMe: (+ (revenant nsLeft:) 0) (+ (revenant nsTop:) 20)
					)
				)
			)
			(= register 0)
			(if (and local3 (> [gEgoStats 18] (= temp1 (* global439 3)))) ; stamina
				(-= [gEgoStats 18] temp1) ; stamina
				(= temp0 (proc810_1 18))
				(UpdateScreenItem
					((ScriptID 40 3) ; xStaminaPart
						x: (- temp0 46)
						setInsetRect: (- 80 temp0) 0 80 2
						yourself:
					)
				)
			)
			(gCombatEgoActor getHurt: 8 setScript: punchFace)
			(rBloodDrop
				x: (+ (revenant nsLeft:) 0)
				y: (+ (revenant nsTop:) 20)
				show:
				cel: 0
				setCycle: End rBloodDrop
			)
			(if (< (+ global156 temp1) 250)
				(+= global156 temp1)
				(= temp0 (proc810_1 -1))
				(UpdateScreenItem
					((ScriptID 40 6) ; xMonsterPart
						x: (+ 100 temp0)
						setInsetRect: (- 104 temp0) 0 104 2
						yourself:
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(revenant
					cycleSpeed: 6
					setLoop: 6 1
					cel: 0
					setCycle: CT 2 1 self
				)
			)
			(1
				(= ticks 10)
			)
			(2
				(revenant setCycle: End self)
			)
			(3
				(revenant cue:)
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
				(revenant attackCode: 0 setLoop: 2 1 cel: 0 setCycle: End self)
				(if (< (revenant nsRight:) 290)
					(revenant
						setMotion: MoveTo (+ (revenant x:) 15) (revenant y:)
					)
				)
				(proc810_13 1 837)
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
								(if (== global439 2)
									(self cue:)
								else
									(self setScript: attackHigh self)
								)
							)
							(1
								(self setScript: attackLow self)
							)
							(2
								(self cue:)
							)
							(3
								(if (== global439 2)
									(self cue:)
								else
									(self setScript: attackLow self)
								)
							)
							(else
								(self setScript: attackHigh self)
							)
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(revenant cue:)
				(client setScript: revenantCombat)
			)
		)
	)
)

(instance hurtBySpell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetNowSeen revenant)
				(revenant setLoop: 11 1 cel: 0 cycleSpeed: 3 setCycle: End self)
				(if (< (revenant nsRight:) 290)
					(revenant
						setMotion: MoveTo (+ (revenant x:) 15) (revenant y:)
					)
				)
				(proc810_13 1 837)
			)
			(1
				(if (IsFlag 386)
					(gPuzzleBar state: (& (gPuzzleBar state:) $ffdf))
					(self dispose:)
				else
					(revenant cue:)
					(client setScript: revenantCombat)
				)
			)
		)
	)
)

(instance punchFace of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gPuzzleBar noHands: 1)
				(VibrateMouse 3 1 1)
				(gCombatEgoActor
					view: (gCombatEgoActor typeView:)
					moveSpeed: 0
					xStep: 4
					setLoop: 2 1
					cel: 0
					setCycle: End self
				)
				(if (> (gCombatEgoActor x:) 45)
					(gCombatEgoActor
						setMotion: ShotTo (- (gCombatEgoActor x:) 8) (gCombatEgoActor y:)
					)
				)
				(proc810_13 0 911)
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

(instance rBloodDrop of SActor
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
				(= ticks (Random 2 local4))
			)
			(1
				(SetNowSeen gCombatEgoActor)
				(SetNowSeen revenant)
				(= temp0 (- (revenant nsLeft:) (gCombatEgoActor nsRight:)))
				(cond
					(
						(and
							(proc810_12 global178)
							(or (< [gEgoStats 18] 2) (== global176 0)) ; stamina
							(> (gCombatEgoActor nsLeft:) 20)
						)
						(self setScript: (ScriptID 41 3) self) ; xBackward
					)
					((> temp0 20)
						(cond
							((and (> [gEgoStats 18] 10) (proc810_12 global176)) ; stamina
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
								(= global187 8)
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
					((> [gEgoStats 18] 7) ; stamina
						(self setScript: (ScriptID 41 1) self) ; xSlash
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
				(= ticks (Random 2 local4))
			)
			(1
				(SetNowSeen gCombatEgoActor)
				(SetNowSeen revenant)
				(= temp0 (- (revenant nsLeft:) (gCombatEgoActor nsRight:)))
				(cond
					((< [gEgoStats 19] 1) ; mana
						(client setScript: fighterScript)
					)
					((< temp0 10)
						(if (> [gEgoStats 18] 7) ; stamina
							(if (proc810_12 global176)
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
							(proc810_12 global178)
							(or (< [gEgoStats 18] 2) (== global176 0)) ; stamina
							(> (gCombatEgoActor nsLeft:) 20)
						)
						(self setScript: (ScriptID 41 3) self) ; xBackward
					)
					(
						(and
							(proc810_12 global177)
							(> [gEgoStats 18] 5) ; stamina
							(> [gEgoStats 19] 5) ; mana
							(not (gEgoSpell active:))
						)
						(= global187 8)
						(if (or [gEgoStats 28] [gEgoStats 33] [gEgoStats 34]) ; forceSpell, lightningSpell, frostSpell
							(self setScript: (ScriptID 41 5) self (Random 0 1)) ; xdoSpell
						else
							(self setScript: (ScriptID 41 5) self 0) ; xdoSpell
						)
					)
					((and (proc810_12 global176) (not (proc810_12 global178)))
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
				(= ticks (Random 2 local4))
			)
			(1
				(SetNowSeen gCombatEgoActor)
				(SetNowSeen revenant)
				(= temp0 (- (revenant nsLeft:) (gCombatEgoActor nsRight:)))
				(cond
					(
						(and
							(proc810_12 global178)
							(or (< [gEgoStats 18] 2) (== global176 0)) ; stamina
							(> (gCombatEgoActor nsLeft:) 20)
						)
						(self setScript: (ScriptID 41 3) self) ; xBackward
					)
					((< temp0 10)
						(if (> [gEgoStats 18] 7) ; stamina
							(if (proc810_12 global176)
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
						(= global187 8)
						(if (or [gEgoStats 28] [gEgoStats 33] [gEgoStats 34]) ; forceSpell, lightningSpell, frostSpell
							(self setScript: (ScriptID 41 5) self (Random 0 1)) ; xdoSpell
						else
							(self setScript: (ScriptID 41 5) self 0) ; xdoSpell
						)
					)
					((proc810_12 global176)
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

