;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 585)
(include sci.sh)
(use Main)
(use combatRm)
(use Motion)
(use System)

(public
	crocodilemanMonster 0
)

(instance crocodilemanMonster of Monster
	(properties
		x 174
		y 136
		view 581
		loop 4
		roar 907
		primDamage 10
		secDamage 8
		tertDamage 8
		armorValue 7
		monHP 200
		spellHitX 174
		spellHitY 86
	)

	(method (init)
		(gCurRoom picture: 560)
		(super init: &rest)
		(self hide: setScript: sFight)
		(torso init:)
		(gLongSong setLoop: -1 changeTo: 154)
	)

	(method (defenseLevel)
		(return 160)
	)

	(method (getHurt)
		(self setScript: sReact)
		(super getHurt:)
	)
)

(instance torso of MonsterProp
	(properties
		x 174
		y 136
		view 581
		loop 1
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
			(gWarriorObj getHurt: (gMonster primDamage:))
		else
			(gLongSong2 number: 940 play:)
		)
	)
)

(instance sFight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (Random 0 2))
					(crocodilemanMonster setCycle: End torso)
					(torso setLoop: 3 setCycle: End)
				)
				(= ticks (/ (Random 90 180) global209))
			)
			(1
				(torso setLoop: (Random 2 3) setCycle: End self)
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
					(if (== (torso loop:) 2)
						(gWarriorObj getHurt: (gMonster secDamage:))
					else
						(gWarriorObj getHurt: (gMonster tertDamage:))
					)
				else
					(gLongSong2 number: 940 play:)
				)
				(torso setCel: 0)
				(= ticks (/ (Random 90 180) global209))
			)
			(3
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
				(torso setLoop: 1 setCel: 0 setCycle: End self)
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

