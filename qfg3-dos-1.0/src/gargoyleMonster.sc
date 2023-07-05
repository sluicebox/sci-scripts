;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 855)
(include sci.sh)
(use Main)
(use combatRm)
(use Motion)
(use System)

(public
	gargoyleMonster 0
)

(instance gargoyleMonster of Monster
	(properties
		x 174
		y 136
		view 851
		roar 933
		primDamage 25
		secDamage 15
		armorValue 17
		monHP 280
		spellHitX 164
		spellHitY 61
		mustFight 1
	)

	(method (init)
		(= global156 280)
		(gCurRoom picture: 550)
		(super init: &rest)
		(self setScript: sFight)
	)

	(method (defenseLevel)
		(return 150)
	)

	(method (getHurt)
		(self setScript: sReact)
		(super getHurt:)
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
				(if (== (= register (Random 2 3)) 2)
					(gMonster x: 154 setLoop: 2 setCycle: CT 1 1 self)
				else
					(gMonster setLoop: 3 setCycle: End self)
				)
			)
			(2
				(gWarriorObj autoDodge:)
				(cond
					(
						(not
							(or
								(== (gWarriorObj view:) 26)
								(== (gWarriorObj view:) 27)
								(== (gWarriorObj view:) 555)
							)
						)
						(if (== register 2)
							(gWarriorObj getHurt: (gMonster primDamage:))
						else
							(gWarriorObj getHurt: (gMonster secDamage:))
						)
					)
					((== register 3)
						(gLongSong2 number: 940 play:)
					)
				)
				(if (== register 2)
					(gMonster x: 174 y: 136 whimper: setCycle: End self)
				else
					(= cycles (+ (/ 3 global209) 1))
				)
			)
			(3
				(gMonster x: 174 y: 136 setLoop: 0 setCel: 0 stopUpd:)
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
				(gMonster setLoop: 1 setCel: 0 setCycle: End)
				(= ticks 35)
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

