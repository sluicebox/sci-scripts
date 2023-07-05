;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 560)
(include sci.sh)
(use Main)
(use combatRm)
(use Motion)
(use System)

(public
	dinosaurMonster 0
)

(instance dinosaurMonster of Monster
	(properties
		x 152
		y 44
		view 559
		loop 3
		priority 4
		roar 903
		primDamage 15
		secDamage 8
		tertDamage 15
		armorValue 8
		monHP 320
		spellHitX 152
		spellHitY 69
	)

	(method (init)
		(gCurRoom picture: 555)
		(armLeft init:)
		(armRight init:)
		(theTail init: setPri: 0 stopUpd:)
		(super init: &rest)
		(self restart:)
		(gLongSong setLoop: -1 changeTo: 157)
	)

	(method (defenseLevel)
		(return 200)
	)

	(method (getHurt)
		(self setScript: sReact)
		(super getHurt:)
	)

	(method (restart)
		(self setScript: sFight)
	)
)

(instance armLeft of MonsterProp
	(properties
		x 164
		y 55
		view 559
		loop 2
		priority 6
	)

	(method (cue)
		(self setCel: 0 stopUpd:)
	)
)

(instance armRight of MonsterProp
	(properties
		x 158
		y 63
		view 559
		priority 2
	)

	(method (cue)
		(self setCel: 0 stopUpd:)
	)
)

(instance theTail of MonsterProp
	(properties
		x 218
		y 86
		view 559
		loop 5
	)

	(method (cue)
		(if cel
			(gWarriorObj autoDodge:)
			(if
				(not
					(or
						(== (gWarriorObj view:) 26)
						(== (gWarriorObj view:) 27)
						(== (gWarriorObj view:) 555)
					)
				)
				(gWarriorObj getHurt: (gMonster tertDamage:))
			else
				(gLongSong2 number: 940 play:)
			)
			(self setCycle: Beg self)
		else
			(self setPri: 0)
			(super cue:)
		)
	)
)

(instance sFight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (/ 180 global209))
				(gMonster x: 152 y: 44)
			)
			(1
				(gMonster setCel: 0 setCycle: CT 2 1 self)
			)
			(2
				(gMonster setCycle: End gMonster)
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
				(= ticks (/ (Random 180 270) global209))
			)
			(3
				(armLeft setCycle: CT 3 1 self)
				(armRight setCycle: CT 3 1 self)
			)
			(4
				(armLeft setCycle: End armLeft)
				(armRight setCycle: End armRight)
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
				(= ticks (/ (Random 270 360) global209))
			)
			(5
				(theTail setPri: 6 setCycle: End theTail)
				(gMonster setCycle: End self)
			)
			(6
				(gMonster cue:)
				(= ticks (/ (Random 180 270) global209))
			)
			(7
				(armRight setCycle: CT 3 1 self)
				(armLeft setCycle: CT 3 1 self)
			)
			(8
				(armLeft setCycle: End self)
				(armRight setCycle: End self)
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
			)
			(9
				(armLeft cue:)
				(armRight cue:)
				(= ticks (/ (Random 180 270) global209))
			)
			(10
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
				(gMonster whimper: setCel: 1 x: 172 y: 39)
				(armLeft setCel: 4)
				(armRight setCel: 4)
				(= ticks 30)
			)
			(1
				(armLeft setCel: 1)
				(armRight setCel: 1)
				(= ticks 30)
			)
			(2
				(gMonster whimper:)
				(armLeft setCel: 5)
				(armRight setCel: 5)
				(= ticks (/ 30 global209))
			)
			(3
				(armLeft setCel: 0)
				(armRight setCel: 0)
				(gMonster x: 152 y: 44 setCel: 0 setScript: sFight)
			)
		)
	)
)

