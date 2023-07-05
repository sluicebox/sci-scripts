;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 825)
(include sci.sh)
(use Main)
(use SView)
(use combat)
(use Motion)
(use System)

(public
	badder 0
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

(procedure (localproc_0)
	(switch local2
		(4
			(if (<= global156 150)
				(return 1)
			else
				(return 0)
			)
		)
		(3
			(if (<= global156 100)
				(return 1)
			else
				(return 0)
			)
		)
		(2
			(if (<= global156 50)
				(return 1)
			else
				(return 0)
			)
		)
	)
)

(instance badder of SActor
	(properties
		x 258
		y 75
		view 826
		signal 16384
		cycleSpeed 20
		xStep 6
		moveSpeed 5
		explodeX 5
	)

	(method (init)
		(super init: &rest)
		(= local2 1)
		(if (!= global439 3)
			(= global176 0)
			(= global177 0)
			(= global178 0)
			(= global179 0)
		)
		(rBloodDrop init: gPuzzleBar)
		(if (> global462 0)
			(++ local2)
			(extraBadder1 init: gPuzzleBar)
		)
		(if (> global463 0)
			(++ local2)
			(extraBadder2 init: gPuzzleBar)
		)
		(if (> global464 0)
			(++ local2)
			(extraBadder3 init: gPuzzleBar)
		)
		(= local3 local2)
		(switch global439
			(1
				(= local0 30)
				(= local1 50)
			)
			(else
				(= local0 15)
				(= local1 25)
			)
		)
		(= local4 (- 13 (/ (+ [gEgoStats 1] [gEgoStats 2]) 100))) ; intelligence, agility
		(= local5 0)
		(self setPri: (+ (gCombatEgoActor priority:) 1) cue: setScript: badderCombat)
	)

	(method (cue)
		(self x: 258 y: 75 setLoop: 0 cycleSpeed: 6 setCycle: Fwd)
	)

	(method (getHurt param1)
		(if (and (> local2 1) (localproc_0))
			(self setScript: fallDie)
		else
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
)

(instance extraBadder1 of SActor
	(properties
		x 248
		y 45
		view 826
		signal 16384
		xStep 6
		moveSpeed 5
		explodeX 5
	)

	(method (init)
		(super init: &rest)
		(self
			x: 258
			y: 75
			setLoop: 0
			cycleSpeed: 3
			setCycle: End self
			setPri: (+ (gCombatEgoActor priority:) 1)
			cue:
		)
	)

	(method (cue)
		(if (> local2 1)
			(cond
				((< 200 x 320)
					(+= x (- 20 (Random 0 40)))
				)
				((< x 200)
					(+= x (Random 10 23))
				)
				((> x 320)
					(-= x (Random 10 23))
				)
			)
			(cond
				((< 10 y 55)
					(+= y (- 20 (Random 0 40)))
				)
				((< y 30)
					(+= y (Random 10 23))
				)
				((> y 55)
					(-= y (Random 10 23))
				)
			)
			(self setCel: 0 setCycle: End self)
		)
	)
)

(instance extraBadder2 of SActor
	(properties
		x 288
		y 65
		view 826
		signal 16384
		xStep 6
		moveSpeed 5
		explodeX 5
	)

	(method (init)
		(super init: &rest)
		(self
			x: 288
			y: 85
			setLoop: 0
			cycleSpeed: 4
			setCycle: End self
			setPri: (+ (gCombatEgoActor priority:) 1)
			cue:
		)
	)

	(method (cue)
		(if (> local2 2)
			(cond
				((< 200 x 320)
					(+= x (- 10 (Random 0 20)))
				)
				((< x 200)
					(+= x (Random 5 13))
				)
				((> x 320)
					(-= x (Random 5 13))
				)
			)
			(cond
				((< 10 y 55)
					(+= y (- 10 (Random 0 20)))
				)
				((< y 30)
					(+= y (Random 5 13))
				)
				((> y 55)
					(-= y (Random 5 13))
				)
			)
			(self setCel: 0 setCycle: End self)
		)
	)
)

(instance extraBadder3 of SActor
	(properties
		x 308
		y 35
		view 826
		signal 16384
		xStep 6
		moveSpeed 5
		explodeX 5
	)

	(method (init)
		(super init: &rest)
		(self
			x: 288
			y: 85
			setLoop: 0
			cycleSpeed: 4
			setCycle: End self
			setPri: (+ (gCombatEgoActor priority:) 1)
			cue:
		)
	)

	(method (cue)
		(if (> local2 3)
			(cond
				((< 200 x 320)
					(+= x (- 10 (Random 0 20)))
				)
				((< x 200)
					(+= x (Random 5 13))
				)
				((> x 320)
					(-= x (Random 5 13))
				)
			)
			(cond
				((< 10 y 55)
					(+= y (- 10 (Random 0 20)))
				)
				((< y 30)
					(+= y (Random 5 13))
				)
				((> y 55)
					(-= y (Random 5 13))
				)
			)
			(self setCel: 0 setCycle: End self)
		)
	)
)

(instance fallDie of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(gCombatMonsterActor
					setLoop: 3 1
					cel: 0
					xStep: (+ global190 1)
					moveSpeed: 0
					yStep:
						(if (<= (= temp0 (/ (* global190 3) 2)) 0)
							1
						else
							(+ temp0 1)
						)
					setCycle: End
					setMotion:
						MoveTo
						(+ (gCombatMonsterActor x:) (Random 20 45))
						(Random 135 140)
						self
				)
			)
			(1
				(= temp0
					(switch (-- local2)
						(1 extraBadder1)
						(2 extraBadder2)
						(3 extraBadder3)
					)
				)
				(= temp1 (gCombatMonsterActor x:))
				(= temp2 (gCombatMonsterActor y:))
				(gCombatMonsterActor
					x: (temp0 x:)
					y: (temp0 y:)
					setLoop: (temp0 loop:) 1
					cel: (temp0 cel:)
					setCycle: Fwd
				)
				(temp0
					x: temp1
					y: temp2
					cel: 0
					setPri: 2
					setLoop: 6 1
					setCycle: 0
					setMotion: 0
				)
				(= cycles 1)
			)
			(2
				(gCombatMonsterActor cue:)
				(client setScript: badderCombat)
			)
		)
	)
)

(instance hurtByDagger of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gCombatMonsterActor
					setLoop: 3 1
					cel: 0
					xStep: (+ global190 1)
					moveSpeed: 0
					yStep:
						(if (<= (= temp0 (/ (* global190 3) 2)) 0)
							1
						else
							(+ temp0 1)
						)
					setCycle: End
					setMotion: MoveTo (+ (gCombatMonsterActor x:) 20) 135 self
				)
				(proc810_13 1 828)
			)
			(1
				(if (IsFlag 386)
					(gCombatMonsterActor setLoop: 6 1)
					(= ticks 20)
				else
					(self cue:)
				)
			)
			(2
				(if (IsFlag 386)
					(gPuzzleBar state: (& (gPuzzleBar state:) $ffdf))
					(self dispose:)
				else
					(gCombatMonsterActor
						setLoop: 1 1
						cel: 0
						setCycle: Fwd
						setMotion: MoveTo 340 10 self
					)
				)
			)
			(3
				(= ticks 50)
			)
			(4
				(gCombatMonsterActor
					cel: 3
					setCycle: 0
					x: 330
					y: -10
					setMotion: MoveTo 258 75 self
				)
			)
			(5
				(gCombatMonsterActor cue:)
				(client setScript: badderCombat)
			)
		)
	)
)

(instance badderCombat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random local0 local1))
			)
			(1
				(self setScript: badderAttack self)
			)
			(2
				(= ticks (Random 60 120))
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance badderAttack of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(SetNowSeen gCombatEgoActor)
				(gCombatMonsterActor
					setLoop: 0 1
					cel: 2
					setCycle: 0
					xStep: (+ global190 1)
					moveSpeed: 0
					yStep:
						(if (<= (= temp0 (/ (* global190 3) 2)) 0)
							1
						else
							(+ temp0 1)
						)
					setMotion:
						MoveTo
						(gCombatEgoActor nsRight:)
						(+ (gCombatEgoActor nsTop:) 10)
						self
				)
			)
			(1
				(gCombatMonsterActor setLoop: 2 1 cel: 0 cycleSpeed: 6 setCycle: End self)
				(proc810_13 1 826)
			)
			(2
				(if (ObjectIntersect gCombatEgoActor gCombatMonsterActor)
					(if (not local5)
						(= local5 1)
						(+= global479 10)
						(SetFlag 14)
						(UpdateScreenItem ((ScriptID 40 5) cel: 1 yourself:)) ; xHealthPart
					)
					(gCombatEgoActor getHurt: 4 setScript: getBitHit)
					(rBloodDrop
						x: (- (gCombatMonsterActor x:) 20)
						y: (gCombatMonsterActor y:)
						show:
						cel: 0
						setCycle: End rBloodDrop
					)
				)
				(gCombatMonsterActor
					setLoop: 0 1
					cel: 0
					cycleSpeed: 6
					setCycle: Fwd
					setMotion: MoveTo 20 -10 self
				)
			)
			(3
				(= ticks 30)
			)
			(4
				(gCombatMonsterActor
					cel: 3
					setCycle: 0
					x: 330
					y: -10
					setMotion: MoveTo 258 75 self
				)
			)
			(5
				(gCombatMonsterActor cue:)
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

(instance hurtBySpell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCombatMonsterActor cycleSpeed: 1 setLoop: 5 1 cel: 0 setCycle: End self)
				(if (< (gCombatMonsterActor x:) 280)
					(gCombatMonsterActor
						xStep: 2
						moveSpeed: 1
						setMotion: MoveTo (+ (gCombatMonsterActor x:) 6) (gCombatMonsterActor y:)
					)
				)
			)
			(1
				(gCombatMonsterActor cue:)
				(if (IsFlag 386)
					(gPuzzleBar state: (& (gPuzzleBar state:) $ffdf))
				)
				(client setScript: badderCombat)
			)
		)
	)
)

(instance rBloodDrop of SActor
	(properties
		view 826
		loop 4
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

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks (Random 2 local4))
			)
			(1
				(SetNowSeen gCombatEgoActor)
				(SetNowSeen badder)
				(= temp0 (- (badder nsLeft:) (gCombatEgoActor nsRight:)))
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
							(if (Random 0 (- 15 global176))
								(self setScript: (ScriptID 810 10) self) ; highSlash
							else
								(self setScript: (ScriptID 810 7) self) ; jumpVAttack
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

