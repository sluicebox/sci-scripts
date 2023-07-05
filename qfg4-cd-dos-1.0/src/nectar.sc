;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 870)
(include sci.sh)
(use Main)
(use SView)
(use combat)
(use Motion)
(use System)

(public
	nectar 0
	egoScript 1
)

(local
	local0
	local1
	local2
	local3
)

(instance nectar of SActor
	(properties
		x 273
		y 138
		view 871
		signal 16384
		cycleSpeed 16
		explodeX 60
	)

	(method (init)
		(super init: &rest)
		(rBloodDrop init: gPuzzleBar)
		(switch global439
			(1
				(= local1 50)
				(= local2 80)
			)
			(2
				(= local1 35)
				(= local2 55)
			)
			(else
				(= local1 5)
				(= local2 25)
			)
		)
		(if (!= global439 3)
			(switch gHeroType
				(2 ; Thief
					(= global176 1)
					(= global177 7)
					(= global178 7)
					(= global179 1)
				)
				(1 ; Magic User
					(= global176 0)
					(= global177 10)
					(= global178 10)
				)
				(else
					(= global176 0)
					(= global177 5)
					(= global178 10)
				)
			)
		)
		(= local3 (- 13 (/ (+ [gEgoStats 1] [gEgoStats 2]) 100))) ; intelligence, agility
		(self setPri: (+ (gCombatEgoActor priority:) 1) cue: setScript: nectarCombat)
	)

	(method (cue)
		(self view: 871 y: 138 setLoop: 0 1 cel: 0 cycleSpeed: 14 setCycle: Fwd)
	)

	(method (setScript)
		(= local0 0)
		(super setScript: &rest)
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

(instance nectarCombat of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks (Random local1 local2))
			)
			(1
				(SetNowSeen nectar)
				(SetNowSeen gCombatEgoActor)
				(cond
					((> (= temp0 (- (nectar nsLeft:) (gCombatEgoActor nsRight:))) 45)
						(self setScript: leapForward self)
					)
					(local0
						(= local0 0)
						(if (Random 0 3)
							(self setScript: leapForward self)
						else
							(self setScript: stepBack self)
						)
					)
					((and (< global156 50) (< (nectar nsRight:) 320))
						(self setScript: stepBack self)
					)
					(else
						(switch (Random 0 9)
							(0
								(self cue:)
							)
							(1
								(self setScript: stepBack self)
							)
							(2
								(self setScript: headAttack self)
							)
							(3
								(self setScript: headAttack self)
							)
							(4
								(self setScript: attackLeft self)
							)
							(5
								(self setScript: attackLeft self)
							)
							(6
								(self setScript: attackLeft self)
							)
							(else
								(self setScript: attackRight self)
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

(instance attackLeft of Script
	(properties)

	(method (doit)
		(super doit:)
		(SetNowSeen nectar)
		(if
			(and
				register
				(or
					(gCombatEgoActor
						onMe: (+ (nectar nsLeft:) 3) (+ (nectar nsTop:) 19)
					)
					(and
						(== state 1)
						(| (SetNowSeen gCombatEgoActor) $0001)
						(<= (nectar nsLeft:) (gCombatEgoActor nsRight:))
					)
				)
			)
			(= register 0)
			(rBloodDrop
				x: (+ (nectar nsLeft:) 3)
				y: (+ (nectar nsTop:) 19)
				show:
				setPri: (+ (nectar priority:) 1)
				cel: 0
				setCycle: End rBloodDrop
			)
			(gCombatEgoActor getHurt: 12 setScript: egoFall 0 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 1)
				(nectar cycleSpeed: 3 setLoop: 6 1 cel: 0 setCycle: CT 2 1 self)
				(proc810_13 1 872)
			)
			(1
				(= ticks 10)
			)
			(2
				(nectar cycleSpeed: 10 setCycle: End self)
			)
			(3
				(if register
					(= local0 1)
				)
				(nectar cue:)
				(self dispose:)
			)
		)
	)
)

(instance attackRight of Script
	(properties)

	(method (doit)
		(super doit:)
		(SetNowSeen nectar)
		(if
			(and
				register
				(or
					(gCombatEgoActor
						onMe: (+ (nectar nsLeft:) 2) (+ (nectar nsTop:) 38)
					)
					(and
						(== state 1)
						(| (SetNowSeen gCombatEgoActor) $0001)
						(<= (nectar nsLeft:) (gCombatEgoActor nsRight:))
					)
				)
			)
			(= register 0)
			(rBloodDrop
				x: (+ (nectar nsLeft:) 2)
				y: (+ (nectar nsTop:) 38)
				show:
				setPri: (+ (nectar priority:) 1)
				cel: 0
				setCycle: End rBloodDrop
			)
			(gCombatEgoActor getHurt: 12 setScript: egoFall 0 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 1)
				(nectar cycleSpeed: 7 setLoop: 3 1 cel: 0 setCycle: CT 2 1 self)
				(proc810_13 1 872)
			)
			(1
				(= ticks 5)
			)
			(2
				(nectar cycleSpeed: 10 setCycle: End self)
			)
			(3
				(if register
					(= local0 1)
				)
				(nectar cue:)
				(self dispose:)
			)
		)
	)
)

(instance headAttack of Script
	(properties)

	(method (doit)
		(super doit:)
		(SetNowSeen nectar)
		(if
			(and
				register
				(or
					(gCombatEgoActor
						onMe: (+ (nectar nsLeft:) 3) (+ (nectar nsTop:) 11)
					)
					(and
						(== state 1)
						(| (SetNowSeen gCombatEgoActor) $0001)
						(<= (nectar nsLeft:) (gCombatEgoActor nsRight:))
					)
				)
			)
			(= register 0)
			(rBloodDrop
				x: (+ (nectar nsLeft:) 3)
				y: (+ (nectar nsTop:) 11)
				show:
				setPri: (+ (nectar priority:) 1)
				cel: 0
				setCycle: End rBloodDrop
			)
			(gCombatEgoActor getHurt: 20 setScript: egoFall)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 1)
				(nectar cycleSpeed: 6 setLoop: 4 1 cel: 0 setCycle: CT 3 1 self)
			)
			(1
				(= ticks 10)
			)
			(2
				(nectar setCycle: End self)
			)
			(3
				(if register
					(= local0 1)
				)
				(nectar cue:)
				(self dispose:)
			)
		)
	)
)

(instance stepBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(nectar cycleSpeed: 2 setLoop: 2 0 cel: 0 setCycle: End self)
			)
			(1
				(nectar x: (+ (nectar x:) 38))
				(if (< (nectar x:) 230)
					(self changeState: 0)
				else
					(nectar cue:)
					(self dispose:)
				)
			)
		)
	)
)

(instance leapForward of Script
	(properties)

	(method (init)
		(= register 1)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(SetNowSeen nectar)
		(SetNowSeen gCombatEgoActor)
		(if (and register (<= (nectar nsLeft:) (gCombatEgoActor nsRight:)))
			(= register 1)
			(rBloodDrop
				x: (+ (nectar nsLeft:) 3)
				y: (+ (nectar nsTop:) 11)
				show:
				setPri: (+ (gCombatEgoActor priority:) 1)
				cel: 0
				setCycle: End rBloodDrop
			)
			(gCombatEgoActor getHurt: 20 setScript: egoFall)
			(nectar x: (+ (gCombatEgoActor nsRight:) 35) cue:)
			(self dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(nectar cycleSpeed: 3 setLoop: 1 1 cel: 0 setCycle: End self)
			)
			(1
				(nectar x: (- (nectar x:) 62))
				(self changeState: 0)
			)
		)
	)
)

(instance hurtMyself of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(nectar cycleSpeed: 6 setLoop: 3 1 cel: 0 setCycle: End self)
				(proc810_13 1 873)
			)
			(1
				(if (< (nectar x:) 240)
					(nectar x: (+ (nectar x:) 16))
				)
				(cond
					((IsFlag 386)
						(gPuzzleBar state: (& (gPuzzleBar state:) $ffdf))
						(self dispose:)
					)
					(
						(and
							(> global439 1)
							(| (SetNowSeen nectar) $0001)
							(| (SetNowSeen gCombatEgoActor) $0001)
							(< (- (nectar nsRight:) (gCombatEgoActor nsLeft:)) 15)
						)
						(if (Random 0 1)
							(self setScript: attackLeft self)
						else
							(self setScript: attackRight self)
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(nectar cue:)
				(client setScript: nectarCombat)
			)
		)
	)
)

(instance hurtBySpell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(nectar cycleSpeed: 6 setLoop: 9 1 cel: 0 setCycle: End self)
				(proc810_13 1 873)
			)
			(1
				(if (< (nectar x:) 240)
					(nectar x: (+ (nectar x:) 16))
				)
				(if (IsFlag 386)
					(gPuzzleBar state: (& (gPuzzleBar state:) $ffdf))
				else
					(nectar cue:)
				)
				(client setScript: nectarCombat)
			)
		)
	)
)

(instance egoFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gPuzzleBar noHands: 1)
				(if register
					(VibrateMouse 3 1 1)
				else
					(VibrateMouse 4 2 2)
				)
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
				(proc810_13 0 904)
			)
			(1
				(= ticks 10)
			)
			(2
				(ShakeScreen 2)
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
				(= ticks (Random 2 local3))
			)
			(1
				(SetNowSeen gCombatEgoActor)
				(SetNowSeen nectar)
				(= temp0 (- (nectar nsLeft:) (gCombatEgoActor nsRight:)))
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
						(if (> [gEgoStats 18] 7) ; stamina
							(self setScript: (ScriptID 41 1) self) ; xSlash
						else
							(self cue:)
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
					((and (proc810_12 global176) (< global178 3))
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

(instance magicScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks (Random 2 local3))
			)
			(1
				(SetNowSeen gCombatEgoActor)
				(SetNowSeen nectar)
				(= temp0 (- (nectar nsLeft:) (gCombatEgoActor nsRight:)))
				(cond
					(
						(and
							(proc810_12 global178)
							(or (< [gEgoStats 18] 2) (== global176 0)) ; stamina
							(> (gCombatEgoActor nsLeft:) 20)
						)
						(self setScript: (ScriptID 41 3) self) ; xBackward
					)
					((< [gEgoStats 19] 1) ; mana
						(client setScript: fighterScript)
					)
					((< temp0 10)
						(if (> [gEgoStats 18] 7) ; stamina
							(if (and (> global176 9) (Random 0 4))
								(self setScript: (ScriptID 810 7) self) ; jumpVAttack
							else
								(self setScript: (ScriptID 41 1) self) ; xSlash
							)
						else
							(self cue:)
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
					((and (proc810_12 global176) (< global178 2))
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
				(SetNowSeen nectar)
				(= temp0 (- (nectar nsLeft:) (gCombatEgoActor nsRight:)))
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
								(self setScript: (ScriptID 810 7) self) ; jumpVAttack
							else
								(self setScript: (ScriptID 41 1) self) ; xSlash
							)
						else
							(self cue:)
						)
					)
					(
						(and
							(> [gEgoStats 18] 100) ; stamina
							(> temp0 40)
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
					((and (proc810_12 global176) (< global178 2))
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

