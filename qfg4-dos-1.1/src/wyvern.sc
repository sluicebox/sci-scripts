;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 835)
(include sci.sh)
(use Main)
(use SView)
(use combat)
(use Motion)
(use System)

(public
	wyvern 0
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

(instance wyvern of SActor
	(properties
		x 273
		y 148
		view 836
		signal 16384
		cycleSpeed 16
		explodeX 40
	)

	(method (init)
		(super init: &rest)
		(switch global439
			(1
				(= local1 40)
				(= local2 65)
			)
			(2
				(= local1 20)
				(= local2 60)
			)
			(else
				(= local1 5)
				(= local2 30)
			)
		)
		(if (!= global439 3)
			(switch gHeroType
				(2 ; Thief
					(= global176 7)
					(= global177 3)
					(= global178 5)
					(= global179 7)
				)
				(1 ; Magic User
					(= global176 1)
					(= global177 9)
					(= global178 1)
				)
				(else
					(= global176 10)
					(= global177 3)
					(= global178 5)
				)
			)
		)
		(= local4 (- 13 (/ (+ [gEgoStats 1] [gEgoStats 2]) 100))) ; intelligence, agility
		(= local5 0)
		(wSpell init: gPuzzleBar)
		(wBloodDrop init: gPuzzleBar)
		(self cue: setScript: wyvernCombat)
	)

	(method (cue)
		(self setLoop: 0 1 cel: 0 cycleSpeed: 16 setCycle: Fwd)
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

(instance wyvernCombat of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks (Random local1 local2))
			)
			(1
				(SetNowSeen wyvern)
				(SetNowSeen gCombatEgoActor)
				(cond
					((<= (= temp0 (- (wyvern nsLeft:) (gCombatEgoActor nsRight:))) 0)
						(cond
							((< (wyvern nsRight:) 340)
								(self setScript: moveBack self)
							)
							((Random 0 1)
								(self setScript: doLSlash self)
							)
							(else
								(self setScript: doRSlash self)
							)
						)
					)
					(local0
						(= ticks (/ 25 global439))
					)
					((< global156 80)
						(cond
							((< (wyvern nsRight:) 340)
								(self setScript: moveBack self)
							)
							((< temp0 16)
								(switch (Random 0 5)
									(0
										(self setScript: tailAttack self)
									)
									(1
										(self setScript: doRSlash self)
									)
									(2
										(if (not (wSpell active:))
											(self setScript: castLSpell self)
										else
											(self setScript: doRSlash self)
										)
									)
									(3
										(self setScript: doRSlash self)
									)
									(else
										(self setScript: doLSlash self)
									)
								)
							)
							((and (Random 0 global439) (not (wSpell active:)))
								(self setScript: castLSpell self)
							)
							(else
								(self cue:)
							)
						)
					)
					((< (wyvern nsRight:) 340)
						(if (< temp0 16)
							(switch (Random 0 3)
								(0
									(self setScript: doLSlash self)
								)
								(1
									(self setScript: doRSlash self)
								)
								(else
									(self setScript: tailAttack self)
								)
							)
						else
							(switch (Random 0 5)
								(0
									(self cue:)
								)
								(1
									(if (not (wSpell active:))
										(self setScript: castLSpell self)
									else
										(self cue:)
									)
								)
								(2
									(if (not (wSpell active:))
										(self setScript: castLSpell self)
									else
										(self cue:)
									)
								)
								(3
									(if (> global439 1)
										(self setScript: castLSpell self)
									else
										(self
											setScript:
												moveForward
												self
												(gCombatEgoActor nsLeft:)
										)
									)
								)
								(4
									(if (> global439 2)
										(self setScript: castLSpell self)
									else
										(self
											setScript:
												moveForward
												self
												(gCombatEgoActor nsLeft:)
										)
									)
								)
								(else
									(self
										setScript:
											moveForward
											self
											(gCombatEgoActor nsLeft:)
									)
								)
							)
						)
					)
					((< temp0 16)
						(switch (Random 0 4)
							(0
								(self setScript: tailAttack self)
							)
							(1
								(self setScript: doLSlash self)
							)
							(2
								(self setScript: doLSlash self)
							)
							(else
								(self setScript: doRSlash self)
							)
						)
					)
					(else
						(switch (Random 0 3)
							(0
								(self
									setScript:
										moveForward
										self
										(gCombatEgoActor nsLeft:)
								)
							)
							(else
								(if (not (wSpell active:))
									(self setScript: castLSpell self)
								else
									(self cue:)
								)
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

(instance moveForward of Script
	(properties)

	(method (doit)
		(super doit:)
		(SetNowSeen wyvern)
		(SetNowSeen gCombatEgoActor)
		(if (and (wyvern mover:) (<= (wyvern nsLeft:) (gCombatEgoActor nsRight:)))
			(= local3 1)
			(wyvern setMotion: 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 0)
				(wyvern
					setLoop: 9 1
					cycleSpeed: 2
					moveSpeed: 1
					xStep: 7
					setLoop: 0 1
					setMotion: ShotTo register (wyvern y:) self
				)
			)
			(1
				(if (and (> global439 1) local3 (Random 0 global439))
					(switch (Random 0 3)
						(0
							(self setScript: tailAttack self)
						)
						(1
							(self setScript: doLSlash self)
						)
						(2
							(self setScript: doLSlash self)
						)
						(else
							(self setScript: doRSlash self)
						)
					)
				else
					(wyvern cue:)
					(self dispose:)
				)
			)
			(2
				(wyvern cue:)
				(self dispose:)
			)
		)
	)
)

(instance moveBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wyvern
					setLoop: 9 1
					cycleSpeed: 2
					moveSpeed: 1
					xStep: 7
					setLoop: 0 1
					setMotion: ShotTo (+ (wyvern x:) 14) (wyvern y:) self
				)
			)
			(1
				(wyvern cue:)
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
		(SetNowSeen wyvern)
		(if
			(and
				register
				(or
					(gCombatEgoActor
						onMe: (+ (wyvern nsLeft:) 1) (+ (wyvern nsTop:) 29)
					)
					(and
						(== state 1)
						(| (SetNowSeen gCombatEgoActor) $0001)
						(<= (wyvern nsLeft:) (gCombatEgoActor nsRight:))
					)
				)
			)
			(= register 0)
			(wBloodDrop
				x: (+ (wyvern nsLeft:) 1)
				y: (+ (wyvern nsTop:) 19)
				setPri: (+ (gCombatEgoActor priority:) 1)
				show:
				setCycle: End wBloodDrop
			)
			(gCombatEgoActor getHurt: 8 setScript: sleapFace)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wyvern cycleSpeed: 6 setLoop: 2 1 cel: 0 setCycle: CT 3 1 self)
			)
			(1
				(= ticks 10)
			)
			(2
				(wyvern setCycle: End self)
			)
			(3
				(wyvern cue:)
				(self dispose:)
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
		(SetNowSeen wyvern)
		(if
			(and
				register
				(or
					(gCombatEgoActor
						onMe: (+ (wyvern nsLeft:) 1) (+ (wyvern nsTop:) 22)
					)
					(gCombatEgoActor
						onMe: (+ (wyvern nsLeft:) 2) (+ (wyvern nsTop:) 35)
					)
					(and
						(== state 1)
						(| (SetNowSeen gCombatEgoActor) $0001)
						(<= (wyvern nsLeft:) (gCombatEgoActor nsRight:))
					)
				)
			)
			(= register 0)
			(wBloodDrop
				x: (+ (wyvern nsLeft:) 1)
				y: (+ (wyvern nsTop:) 22)
				setPri: (+ (gCombatEgoActor priority:) 1)
				show:
				setCycle: End wBloodDrop
			)
			(gCombatEgoActor getHurt: 6 setScript: sleapFace)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wyvern cycleSpeed: 6 setLoop: 3 1 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(= ticks 10)
			)
			(2
				(wyvern setCycle: End self)
			)
			(3
				(wyvern cue:)
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
				(wyvern cycleSpeed: 6 setLoop: 5 1 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(SetNowSeen gCombatEgoActor)
				(SetNowSeen wyvern)
				(if
					(and
						(not (& global192 $0002))
						(or
							(gCombatEgoActor
								onMe:
									(+ (wyvern nsLeft:) 1)
									(+ (wyvern nsTop:) 49)
							)
							(gCombatEgoActor
								onMe:
									(+ (wyvern nsLeft:) 18)
									(+ (wyvern nsTop:) 47)
							)
						)
					)
					(gCombatEgoActor setScript: burnEgo getHurt: 6)
					(wyvern cue:)
					(self dispose:)
				else
					(wSpell
						x: (- (wyvern nsLeft:) 20)
						y: (= temp0 (+ (wyvern nsTop:) 49))
						setLoop: 4 1
						myTarget: gCombatEgoActor
						setCycle: Fwd
						setPri: (+ (gCombatEgoActor priority:) 1)
						show:
						setMotion: ShotTo -5 temp0 wSpell
					)
					(wyvern setCycle: End)
				)
				(= ticks 45)
			)
			(2
				(wyvern cue:)
				(self dispose:)
			)
		)
	)
)

(instance tailAttack of Script
	(properties)

	(method (init)
		(= register 1)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(SetNowSeen wyvern)
		(if
			(and
				register
				(not (& global192 $0002))
				(or
					(gCombatEgoActor
						onMe: (+ (wyvern nsLeft:) 1) (+ (wyvern nsTop:) 102)
					)
					(and
						(== state 1)
						(| (SetNowSeen gCombatEgoActor) $0001)
						(<= (wyvern nsLeft:) (gCombatEgoActor nsRight:))
					)
				)
			)
			(= register 0)
			(if (not local5)
				(SetFlag 14)
				(= local5 1)
				(+= global479 50)
				(UpdateScreenItem ((ScriptID 40 5) cel: 1 yourself:)) ; xHealthPart
			)
			(wBloodDrop
				x: (+ (wyvern nsLeft:) 1)
				y: (+ (wyvern nsTop:) 102)
				setPri: (+ (gCombatEgoActor priority:) 1)
				show:
				setCycle: End wBloodDrop
			)
			(gCombatEgoActor getHurt: 4 setScript: sleapFace)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wyvern cycleSpeed: 6 setLoop: 6 1 cel: 0 setCycle: CT 2 1 self)
				(proc810_13 1 986)
			)
			(1
				(= ticks 10)
			)
			(2
				(wyvern setCycle: End self)
			)
			(3
				(wyvern cue:)
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
				(wyvern cycleSpeed: 6 setLoop: 1 1 cel: 0)
				(if (< (wyvern x:) 250)
					(wyvern
						setCycle: End
						setMotion: ShotTo (+ (wyvern x:) 15) (wyvern y:) self
					)
				else
					(wyvern setCycle: End self)
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
						(if (Random 0 global439)
							(switch (Random 0 4)
								(0
									(self setScript: tailAttack self)
								)
								(1
									(self setScript: doLSlash self)
								)
								(2
									(self setScript: doLSlash self)
								)
								(else
									(self setScript: doRSlash self)
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
				(wyvern cue:)
				(client setScript: wyvernCombat)
			)
		)
	)
)

(instance hurtBySpell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wyvern cycleSpeed: 6 setLoop: 8 1 cel: 0 setCycle: End self)
				(proc810_13 1 837)
			)
			(1
				(if (IsFlag 386)
					(gPuzzleBar state: (& (gPuzzleBar state:) $ffdf))
				else
					(wyvern cue:)
				)
				(client setScript: wyvernCombat)
			)
		)
	)
)

(instance burnEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(gPuzzleBar noHands: 1)
				(VibrateMouse 2 1 1)
				(gCombatEgoActor
					view: (gCombatEgoActor typeView:)
					moveSpeed: 0
					xStep: 4
					setLoop: 3 1
					cel: 0
					setCycle: End self
				)
				(proc810_13 0 911)
				(if (> (gCombatEgoActor x:) 45)
					(gCombatEgoActor
						setMotion: ShotTo (- (gCombatEgoActor x:) 20) (gCombatEgoActor y:)
					)
				)
			)
			(1
				(= ticks 20)
			)
			(2
				(gCombatEgoActor setMotion: 0)
				(= local0 0)
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

(instance getSpellHit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(gPuzzleBar noHands: 1)
				(wSpell setLoop: 5 1 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(VibrateMouse 2 1 1)
				(wSpell setCycle: End wSpell)
				(gCombatEgoActor
					view: (gCombatEgoActor typeView:)
					moveSpeed: 0
					xStep: 4
					setLoop: 3 1
					cel: 0
					setCycle: End self
				)
				(proc810_13 0 911)
				(if (> (gCombatEgoActor x:) 45)
					(gCombatEgoActor
						setMotion: MoveTo (- (gCombatEgoActor x:) 20) (gCombatEgoActor y:)
					)
				)
			)
			(2
				(= ticks 20)
			)
			(3
				(= local0 0)
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

(instance sleapFace of Script
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
				(proc810_13 0 911)
				(if (> (gCombatEgoActor x:) 45)
					(gCombatEgoActor
						setMotion: ShotTo (- (gCombatEgoActor x:) 12) (gCombatEgoActor y:)
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
				6
			)
		)
		(if global454
			(= temp2 (/ (* temp2 [gEgoStats 39]) 400)) ; resistanceSpell
		)
		(if temp1
			(gCombatEgoActor getHurt: (/ temp2 5))
			(self setLoop: 5 1 cel: 0 setCycle: End self)
		else
			(gCombatEgoActor getHurt: temp2 setScript: getSpellHit)
		)
	)
)

(instance wBloodDrop of SActor
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
				(SetNowSeen wyvern)
				(= temp0 (- (wyvern nsLeft:) (gCombatEgoActor nsRight:)))
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
							(wSpell active:)
							(< (- (wSpell x:) (gCombatEgoActor nsRight:)) 40)
							(> (wSpell x:) (gCombatEgoActor nsLeft:))
						)
						(cond
							((> [gEgoStats 18] 7) ; stamina
								(cond
									((< temp0 25)
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
									((< temp0 30)
										(cond
											((proc810_12 global176)
												(self
													setScript:
														(ScriptID 810 7) ; jumpVAttack
														self
												)
											)
											((not global178)
												(self cue:)
											)
											((> global178 7)
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
									((proc810_12 global176)
										(self setScript: (ScriptID 810 5) self) ; jumpForward
									)
									((not global178)
										(self cue:)
									)
									((> global178 9)
										(self setScript: (ScriptID 41 6) self) ; xParryLow
									)
									(else
										(self setScript: (ScriptID 810 4) self) ; jumpUp
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
					)
					((> temp0 20)
						(cond
							((and (< temp0 25) (> [gEgoStats 18] 7)) ; stamina
								(self setScript: (ScriptID 810 7) self) ; jumpVAttack
							)
							((and (< temp0 40) (> [gEgoStats 18] 7)) ; stamina
								(self setScript: (ScriptID 810 6) self) ; jumpAttack
							)
							((proc810_12 global176)
								(self setScript: (ScriptID 41 2) self) ; xForward
							)
							(
								(and
									(proc810_12 global177)
									(> temp0 50)
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
							(> temp0 50)
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
						(if (Random 0 2)
							(self setScript: (ScriptID 41 1) self) ; xSlash
						else
							(self setScript: (ScriptID 810 7) self) ; jumpVAttack
						)
					)
					((proc810_12 global178)
						(self setScript: (ScriptID 41 6) self) ; xParryLow
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
				(SetNowSeen wyvern)
				(= temp0 (- (wyvern nsLeft:) (gCombatEgoActor nsRight:)))
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
							(wSpell active:)
							(< (- (wSpell x:) (gCombatEgoActor nsRight:)) 40)
							(> (wSpell x:) (gCombatEgoActor nsLeft:))
							(proc810_12 global178)
							(> [gEgoStats 18] 7) ; stamina
						)
						(if (> global178 9)
							(self setScript: (ScriptID 41 6) self) ; xParryLow
						else
							(self setScript: (ScriptID 810 4) self) ; jumpUp
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
				(= ticks (Random 2 local4))
			)
			(1
				(SetNowSeen gCombatEgoActor)
				(SetNowSeen wyvern)
				(= temp0 (- (wyvern nsLeft:) (gCombatEgoActor nsRight:)))
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
							(proc810_12 global178)
							(wSpell active:)
							(< (- (wSpell x:) (gCombatEgoActor nsRight:)) 40)
							(> (wSpell x:) (gCombatEgoActor nsLeft:))
						)
						(if (> [gEgoStats 18] 7) ; stamina
							(cond
								((not global178)
									(self cue:)
								)
								((> global178 9)
									(self setScript: (ScriptID 41 6) self) ; xParryLow
								)
								(else
									(self setScript: (ScriptID 810 4) self) ; jumpUp
								)
							)
						else
							(self setScript: (ScriptID 41 6) self) ; xParryLow
						)
					)
					((< temp0 10)
						(cond
							((> [gEgoStats 18] 7) ; stamina
								(if (or (proc810_12 global176) (> global178 8))
									(self setScript: (ScriptID 41 1) self) ; xSlash
								else
									(self setScript: (ScriptID 810 7) self) ; jumpVAttack
								)
							)
							((proc810_12 global178)
								(self setScript: (ScriptID 41 6) self) ; xParryLow
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
							(> temp0 30)
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

