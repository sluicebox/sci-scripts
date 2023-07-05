;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 590)
(include sci.sh)
(use Main)
(use combatRm)
(use Motion)
(use System)

(public
	dewormMonster 0
)

(instance dewormMonster of Monster
	(properties
		x 166
		y 128
		view 586
		loop 1
		roar 908
		primDamage 30
		secDamage 20
		armorValue 10
		monHP 200
		spellHitX 166
		spellHitY 78
	)

	(method (init)
		(gCurRoom picture: 550)
		(super init: &rest)
		(self setScript: sFight)
		(armFront init:)
		(armBack init: hide:)
		(gLongSong setLoop: -1 changeTo: 154)
	)

	(method (defenseLevel)
		(return 200)
	)

	(method (getHurt)
		(self setScript: sReact)
		(super getHurt:)
	)
)

(instance armFront of MonsterProp
	(properties
		x 195
		y 130
		view 586
		priority 11
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
		else
			(gLongSong2 number: 940 play:)
		)
		(self setCycle: Beg)
	)
)

(instance armBack of MonsterProp
	(properties
		x 143
		y 105
		view 586
		priority 4
	)

	(method (cue)
		(if (> cel 2)
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
			else
				(gLongSong2 number: 940 play:)
			)
			(self setCycle: CT (Random 0 2) -1 self)
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
				(= ticks (/ (Random 45 180) global209))
			)
			(1
				(gMonster setCel: 0 x: 166 y: 128 setCycle: End self)
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
				)
				(dewormMonster setCycle: CT (Random 0 3) -1 self)
			)
			(3
				(if (Random 0 1)
					(armFront setCycle: End armFront)
					(= ticks (/ 180 global209))
				)
				(if (Random 0 1)
					(armBack show: setCycle: End armBack)
					(= ticks (/ 180 global209))
				)
				(if (not ticks)
					(= ticks (/ 18 global209))
				)
			)
			(4
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
				(gMonster setCel: 0 setCycle: CT 2 1)
				(= ticks 60)
			)
			(1
				(gMonster whimper:)
				(= ticks (- (/ (Random 180 360) global209) 59))
			)
			(2
				(gMonster setScript: sFight)
			)
		)
	)
)

