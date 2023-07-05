;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 575)
(include sci.sh)
(use Main)
(use combatRm)
(use Motion)
(use System)

(public
	apemanMonster 0
)

(instance apemanMonster of Monster
	(properties
		x 165
		y 135
		view 571
		roar 905
		primDamage 12
		secDamage 6
		armorValue 4
		monHP 180
		spellHitX 155
		spellHitY 85
	)

	(method (init)
		(if (or (== gPrevRoomNum 800) (== gPrevRoomNum 810))
			(= mustFight 1)
		)
		(gCurRoom picture: 555)
		(super init: &rest)
		(self setScript: sFight)
		(gLongSong setLoop: -1 changeTo: 151)
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

(instance sFight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (/ (Random 90 360) global209))
			)
			(1
				(apemanMonster
					setCel: 0
					setLoop: (Random 0 1)
					setCycle: End self
				)
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
					(gWarriorObj
						getHurt:
							(if (gWarriorObj loop:)
								(gMonster secDamage:)
							else
								(gMonster primDamage:)
							)
					)
				else
					(gLongSong2 number: 940 play:)
				)
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
				(gMonster setCel: 0 setLoop: 2 setCycle: End self)
				(= ticks 60)
			)
			(1
				(gMonster whimper:)
				(= ticks (- (/ 120 global209) 39))
			)
			(2
				(gMonster setScript: sFight)
			)
		)
	)
)

