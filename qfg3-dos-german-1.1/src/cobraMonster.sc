;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 580)
(include sci.sh)
(use Main)
(use combatRm)
(use Motion)
(use Actor)
(use System)

(public
	cobraMonster 0
)

(instance cobraMonster of Monster
	(properties
		x 185
		y 125
		view 576
		roar 906
		primDamage 8
		secDamage 15
		armorValue 3
		monHP 150
		spellHitX 185
		spellHitY 97
	)

	(method (init)
		(gCurRoom picture: 560)
		(super init: &rest)
		(self setScript: sFight)
		(spit init: hide:)
		(gLongSong setLoop: -1 changeTo: 151)
	)

	(method (getHurt)
		(self setScript: sReact)
		(super getHurt:)
	)

	(method (defenseLevel)
		(return 220)
	)

	(method (cue)
		(gWarriorObj autoDodge:)
		(if
			(not
				(or
					(== (gWarriorObj view:) 26)
					(== (gWarriorObj view:) 27)
					(== (gWarriorObj view:) 555)
				)
			)
			(gWarriorObj getHurt: (gMonster secDamage:))
			(spit setCycle: End spit)
			(SetFlag 115)
		else
			(spit setMotion: MoveTo -58 119 spit)
		)
	)
)

(instance spit of Actor
	(properties
		x 162
		y 119
		yStep 15
		view 576
		loop 4
		priority 11
		signal 18448
		cycleSpeed 5
		xStep 15
		moveSpeed 0
	)

	(method (cue)
		(self hide:)
	)
)

(instance sFight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (/ (Random 90 360) global209))
			)
			(1
				(gMonster
					setCel: 0
					setLoop: (if (Random 0 1) 1 else 2)
					setCycle: End self
				)
			)
			(2
				(if (== (gMonster loop:) 1)
					(gMonster setCycle: Beg self)
				else
					(= ticks (/ 180 global209))
				)
			)
			(3
				(gMonster setLoop: 3 setCel: 0 setCycle: CT 1 1 self)
			)
			(4
				(if (Random 0 1)
					(spit
						show:
						x: 162
						y: 119
						setCel: 0
						setMotion: MoveTo 102 119 gMonster
					)
				else
					(gMonster x: 150)
					(gWarriorObj autoDodge:)
					(if
						(not
							(or
								(== (gWarriorObj view:) 26)
								(== (gWarriorObj view:) 27)
								(== (gWarriorObj view:) 555)
							)
						)
						(gWarriorObj getHurt: (gMonster primDamage:))
					)
				)
				(gMonster setCycle: End self)
			)
			(5
				(gMonster x: 185 y: 125)
				(self init:)
			)
		)
	)
)

(instance sReact of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMonster setLoop: 0 setCel: 0 setCycle: End self)
				(= ticks 60)
			)
			(1
				(gMonster whimper:)
				(= ticks (- (/ (Random 45 180) global209) 14))
			)
			(2
				(gMonster setScript: sFight)
			)
		)
	)
)

