;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 214)
(include sci.sh)
(use Main)
(use StatusBar)
(use Skilled)
(use FileSelector)

(class Monster of Skilled
	(properties
		attackRange 50
		ateEgo 0
		monsterTitle 0
		monsterHP 0
		warriorX 160
		warriorY 190
		flameX 0
		flameY 0
	)

	(method (dispose)
		(if monsterTitle
			(monsterHP dispose:)
			(Display 214 0 dsRESTOREPIXELS monsterTitle)
			(= monsterTitle (= monsterHP 0))
		)
		(super dispose:)
	)

	(method (drawStatus)
		(SaveSubLang)
		(= opponent (ScriptID 213 0)) ; warrior
		(if (not (= health global333))
			(= health (self calcHealth:))
		)
		(= stamina (self calcStamina:))
		(= mana (self calcMana:))
		(= monsterTitle
			(Display ; "Enemy Status"
				214
				1
				dsWIDTH
				100
				dsCOORD
				(LangSwitch 267 215)
				13
				dsALIGN
				alLEFT
				dsFONT
				300
				dsCOLOR
				global303
				dsSAVEPIXELS
			)
		)
		((= monsterHP (StatusBar new:))
			x: 240
			y: 33
			titleCel: 0
			priority: 1
			max: (self calcHealth:)
			value: health
			init:
		)
		(RestoreSubLang)
	)

	(method (getHurt param1)
		(super getHurt: param1)
		(if (> param1 0)
			(SetFlag 233)
		)
		(self setMonsterHP: health)
	)

	(method (setMonsterHP param1)
		(monsterHP value: param1 draw:)
	)
)

