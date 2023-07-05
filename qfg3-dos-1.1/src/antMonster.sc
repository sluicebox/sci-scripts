;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 565)
(include sci.sh)
(use Main)
(use combatRm)
(use Motion)
(use Actor)
(use System)

(public
	antMonster 0
)

(instance antMonster of Monster
	(properties
		x 170
		y 142
		view 562
		roar 904
		primDamage 8
		secDamage 10
		armorValue 6
		monHP 150
		spellHitX 162
		spellHitY 98
	)

	(method (init)
		(gCurRoom picture: 560)
		(self setScript: sFight)
		(abdomen init:)
		(theHead init:)
		(splat init: hide:)
		(super init: &rest)
		(gLongSong setLoop: -1 changeTo: 151)
	)

	(method (defenseLevel)
		(return 120)
	)

	(method (getHurt)
		(self setScript: sReact)
		(super getHurt:)
	)

	(method (restart)
		(self setScript: sFight)
	)
)

(instance abdomen of MonsterProp
	(properties
		x 180
		y 124
		view 562
		loop 1
		signal 16384
	)

	(method (cue)
		(self setCycle: Beg)
		(splat x: 188 y: 95 setCel: 0 show: setMotion: MoveTo 128 95 splat)
	)
)

(instance theHead of MonsterProp
	(properties
		x 152
		y 126
		view 562
		loop 3
		cel 2
		signal 16384
	)
)

(instance splat of Actor
	(properties
		x 188
		y 95
		yStep 15
		view 562
		loop 2
		priority 11
		signal 18448
		cycleSpeed 5
		xStep 15
		moveSpeed 0
	)

	(method (cue)
		(if (< cel 2)
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
				(self setCycle: End self)
			else
				(self setMotion: MoveTo (- x 160) y)
			)
		else
			(self hide:)
		)
	)
)

(instance sFight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (/ 90 global209))
			)
			(1
				(theHead x: 152 y: 126 setCycle: CT 2 1 self)
			)
			(2
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
				else
					(gLongSong2 number: 940 play:)
				)
				(if (Random 0 1)
					(theHead setCel: 3)
				)
				(= ticks 60)
			)
			(3
				(theHead y: 120 setCycle: CT 2 1 self)
			)
			(4
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
				else
					(gLongSong2 number: 940 play:)
				)
				(if (Random 0 1)
					(theHead setCel: 3)
				)
				(= ticks 60)
			)
			(5
				(theHead y: 126 setCycle: CT 2 1 self)
			)
			(6
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
				else
					(gLongSong2 number: 940 play:)
				)
				(if (Random 0 1)
					(theHead setCel: 3)
				)
				(= ticks (/ 180 global209))
			)
			(7
				(abdomen setCycle: End abdomen)
				(= ticks (/ 90 global209))
			)
			(8
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
				(theHead x: 174 y: 110 setCycle: CT 0 1)
				(= ticks 60)
			)
			(1
				(gMonster whimper:)
				(= ticks (- (/ 180 global209) 59))
			)
			(2
				(gMonster setScript: sFight)
			)
		)
	)
)

