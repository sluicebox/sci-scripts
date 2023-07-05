;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 214)
(include sci.sh)
(use Main)
(use StatusBar)
(use SkilledActor)

(class Monster of SkilledActor
	(properties
		view 445
		attackRange 50
		ateEgo 0
		monsterTitle 0
		monsterHP 0
		warriorX 160
		warriorY 190
		flameX 0
		flameY 0
		lowBlow 0
	)

	(method (dispose)
		(monsterHP dispose:)
		(= monsterTitle (= monsterHP 0))
		(super dispose:)
	)

	(method (drawStatus)
		(= opponent (ScriptID 213 0)) ; warrior
		(if (not (= health global280))
			(= health (self calcHealth:))
		)
		(= stamina (self calcStamina:))
		(= mana (self calcMana:))
		((= monsterHP (StatusBar new:))
			x: 255
			y: 28
			titleCel: 0
			priority: 1
			max: (self calcHealth:)
			value: health
			init:
		)
	)

	(method (getHurt param1)
		(super getHurt: param1)
		(if (> param1 0)
			(SetFlag 233)
		)
	)

	(method (setMonsterHP param1)
		(monsterHP value: param1 draw:)
		(return 1)
	)
)

