;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 860)
(include sci.sh)
(use Main)
(use combatRm)
(use Motion)
(use Actor)
(use System)

(public
	egoMonster 0
)

(procedure (localproc_0)
	(cond
		((>= [gEgoStats 16] 55) ; health
			(gWarriorObj getHurt: 30)
		)
		((not (gCast contains: haramiMan))
			(haramiMan init:)
		)
	)
)

(instance egoMonster of Monster
	(properties
		x 174
		y 136
		roar 901
		secDamage 30
		armorValue 10
		spellHitX 164
		spellHitY 96
		mustFight 1
	)

	(method (init)
		(gCurRoom picture: 0)
		(self
			primDamage: (* (gWarriorObj weapValue:) 2)
			monHP: [gEgoStats 16] ; health
			view: (if (gEgo has: 1) 844 else 843) ; theSword
		)
		(super init: &rest)
		(self setScript: sFight)
		(gLongSong setLoop: -1 changeTo: 845)
	)

	(method (getHurt)
		(self setScript: sReact)
		(cond
			((> (- global156 [gEgoStats 16]) 60) ; health
				(-= global156 5)
			)
			((> (- global156 [gEgoStats 16]) 30) ; health
				(-= global156 2)
			)
		)
		((ScriptID 550 3) update:) ; monsterHPStat
	)

	(method (defenseLevel)
		(return 250)
	)
)

(instance sFight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (/ (Random 45 180) global209))
			)
			(1
				(self start: 1)
				(if (== global419 1)
					(client setScript: sCast)
				else
					(gMonster
						setLoop:
							(if (gEgo has: 1) ; theSword
								(Random 0 2)
							else
								0
							)
						setCycle: End self
					)
				)
			)
			(2
				(if
					(not
						(or
							(== (gWarriorObj view:) 26)
							(== (gWarriorObj view:) 27)
							(== (gWarriorObj view:) 555)
						)
					)
					(localproc_0 (gMonster primDamage:))
				else
					(gLongSong2 number: 940 play:)
				)
				(= cycles (+ (/ 3 global209) 1))
			)
			(3
				(gMonster setLoop: 0 setCel: 0 stopUpd:)
				(= ticks (/ (Random 45 180) global209))
			)
			(4
				(self init:)
			)
		)
	)
)

(instance sCast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMonster setLoop: 1 setCel: 0 setCycle: End self)
			)
			(1
				(monSpell
					setLoop:
						(switch ((ScriptID 550 2) approachDist:) ; combatSpell
							(27 1)
							(32 2)
							(else 0)
						)
					init:
					x: 180
					y: 100
					setMotion:
						MoveTo
						(gWarriorObj x:)
						(- (gWarriorObj y:) 45)
						monSpell
				)
				(gLongSong2
					number:
						(switch ((ScriptID 550 2) approachDist:) ; combatSpell
							(27 11)
							(32 11)
							(else 13)
						)
					play:
				)
				(= ticks (/ (Random 45 180) global209))
			)
			(2
				(if (== global419 1)
					(self init:)
				else
					(client setScript: sFight)
				)
			)
		)
	)
)

(instance sReact of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMonster setLoop: 0 setCel: 2)
				(= ticks 60)
			)
			(1
				(gMonster whimper:)
				(= ticks (- (/ (Random 45 180) global209) 14))
			)
			(2
				(if (== global419 1)
					(gMonster setScript: sCast)
				else
					(gMonster setScript: sFight)
				)
			)
		)
	)
)

(instance monSpell of Actor
	(properties
		x 180
		y 100
		yStep 15
		view 22
		priority 11
		signal 18448
		cycleSpeed 5
		xStep 15
		moveSpeed 0
	)

	(method (cue &tmp temp0)
		(if (and (< loop 3) (> x 10))
			(if
				(not
					(or
						(== (gWarriorObj view:) 26)
						(== (gWarriorObj view:) 27)
						(== (gWarriorObj view:) 555)
					)
				)
				(= temp0 0)
				(switch ((ScriptID 550 2) approachDist:) ; combatSpell
					(27
						(= temp0 (* (+ 10 (/ [gEgoStats 27] 20)) 2)) ; forceBoltSpell
					)
					(32
						(= temp0 (* (+ 12 (/ [gEgoStats 32] 20)) 2)) ; lightningBallSpell
					)
					(else
						(= temp0 (* (+ 10 (/ [gEgoStats 25] 20)) 2)) ; flameDartSpell
					)
				)
				(localproc_0 temp0)
				(gLongSong2 number: 930 play:)
				(self setCel: 0 setLoop: (+ loop 3) setCycle: End self)
			else
				(self setMotion: MoveTo -30 y self)
			)
		else
			(self dispose:)
		)
	)
)

(instance haramiMan of Actor
	(properties
		x 245
		y 66
		view 847
		signal 16400
		cycleSpeed 40
		xStep 1
		moveSpeed 4
	)

	(method (init)
		(super init: &rest)
		(self setCycle: CT 1 1 self)
	)

	(method (cue)
		(if (not loop)
			(switch cel
				(1
					(self setMotion: MoveTo (- x 10) y setCycle: CT 2 1 self)
				)
				(2
					(self setMotion: MoveTo (- x 10) y setCycle: CT 3 1 self)
				)
				(3
					(self setMotion: MoveTo (- x 10) y setCycle: CT 4 1 self)
				)
				(4
					(self setLoop: 1 setCel: 0 cycleSpeed: 6 setCycle: End self)
				)
			)
		else
			(gMonster setCycle: 0 setScript: 0)
			(HandsOff)
			(gWarriorObj setCycle: 0 setScript: sMonsterDie)
		)
	)
)

(instance sMonsterDie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 40)
			)
			(1
				(= global156 0)
				(= global155 -1)
				((ScriptID 550 3) cue:) ; monsterHPStat
			)
		)
	)
)

