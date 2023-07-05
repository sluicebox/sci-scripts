;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 666)
(include sci.sh)
(use Main)
(use n001)
(use Game)

(public
	rmCombat 0
)

(local
	theMonster
)

(instance rmCombat of Rm
	(properties
		picture 680
	)

	(method (init)
		(super init: &rest)
		(= theMonster (ScriptID gMonsterNum 0))
		(if (not gMonsterHealth)
			(= gMonsterHealth -1)
		)
		(theMonster opponent: (ScriptID 32 0) setHealth: gMonsterHealth initCombat:) ; warrior
		((ScriptID 32 0) posn: 140 120 setPri: 10 opponent: theMonster initCombat:) ; warrior
		(if (<= gMonsterHealth 0)
			(theMonster die:)
		)
	)

	(method (notify which)
		(= gBattleResult which)
		(switch which
			(59
				(HighPrint 666 0) ; "You wisely demonstrate your inborn self-preservation skills."
			)
			(61
				(= gBattleResult 0)
				(EgoDead ; "It might have been a glorious battle... but ones in which the Hero dies rarely make the front page."
					0
					666
					1
					#title
					{No Glory in this Story}
					#icon
					(theMonster view:)
					1
					1
				)
				(return 1)
			)
			(58
				(switch gMonsterNum
					(670
						(HighPrint 666 2) ; "You have dealt the Scorpion your own deadly sting."
					)
					(680
						(HighPrint 666 3) ; "You have triumphed gloriously over the Brigand."
					)
					(675
						(HighPrint 666 4) ; "You have killed the mighty Terrorsaurus."
					)
					(695
						(HighPrint 666 5) ; "You have bested the Jackalmen."
					)
					(685
						(HighPrint 666 6) ; "The Ghoul's body clatters to the sand."
					)
				)
			)
			(60
				(= gBattleResult 0)
				(if (== gMonsterNum 685)
					(EgoDead ; "The Ghoul's poisonous claws have made you too weak to continue. Drained of energy, you fall, and the Ghoul quickly finishes killing you."
						0
						666
						7
						#title
						{Too Tired To Stand}
						#icon
						(theMonster view:)
						1
						1
					)
					(return 1)
				)
			)
			(else
				(= gBattleResult 0)
			)
		)
		(if gBattleResult
			(self newRoom: 665) ; desert
		else
			(return 0)
		)
	)
)

