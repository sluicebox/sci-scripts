;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use Inventory)

(public
	DrinkPotion 0
)

(procedure (DrinkPotion event index &tmp wPotion)
	(if index
		(= wPotion index)
	else
		(= wPotion (SaidInv event))
	)
	(cond
		((not wPotion)
			(event claimed: 0)
			(cond
				((Said '/water')
					(if (gEgo has: 29) ; water
						(gEgo use: 29 1) ; water
						(gEgo get: 26) ; empty bottle
						(cond
							((not (gEgo has: 29)) ; water
								(ClearFlag 330)
								(ClearFlag 329)
							)
							((IsFlag 330)
								(ClearFlag 330)
							)
							((IsFlag 329)
								(ClearFlag 329)
							)
						)
						(HighPrint 5 0) ; "You drink a flask of water. It tastes great."
						(HighPrint 5 1) ; "(Less filling, too!)"
					)
				)
				((Said '/potion')
					(= wPotion 0)
					(for ((= index 34)) (<= index 39) ((++ index))
						(cond
							((and [gInvNum index] (not wPotion))
								(= wPotion index)
							)
							((and wPotion [gInvNum index])
								(= wPotion -1)
								(break)
							)
						)
					)
					(switch wPotion
						(-1
							(HighPrint 5 2) ; "Perhaps you could tell me which potion you want to drink."
						)
						(0
							(HighPrint 5 3) ; "You have no potions."
						)
						(else
							(DrinkPotion event wPotion)
						)
					)
				)
				(else
					(event claimed: 1)
					(HighPrint 5 4) ; "You don't see any here."
				)
			)
		)
		((or (< wPotion 34) (> wPotion 39))
			(event claimed: 0)
			(if (Said 'drink')
				(HighPrint 5 5) ; "That isn't drinkable."
			else
				(HighPrint 5 6) ; "It's not clear how you want to use that."
			)
			(event claimed: 1)
		)
		((not [gInvNum wPotion])
			(HighPrint 5 7) ; "You don't have any of those."
		)
		((== wPotion 34)
			(HighPrint 5 8) ; "The drink soothes as it goes down."
			(TakeDamage (- (/ (MaxHealth) 2)))
			(gEgo use: 34) ; healing
			(gEgo get: 26) ; empty bottle
		)
		((== wPotion 35)
			(HighPrint 5 9) ; "The drink burns as it goes down."
			(UseMana (- (/ (MaxMana) 2)))
			(gEgo use: 35) ; mana potion
			(gEgo get: 26) ; empty bottle
		)
		((== wPotion 36)
			(HighPrint 5 10) ; "The drink is invigorating."
			(UseStamina (- (MaxStamina)))
			(gEgo use: 36) ; vigor potion
			(gEgo get: 26) ; empty bottle
		)
		((== wPotion 38)
			(HighPrint 5 11) ; "You don't feel anything. Perhaps this was not the correct way to use this potion."
			(gEgo use: 38) ; disenchant potion
			(gEgo get: 26) ; empty bottle
			(event claimed: 1)
		)
		((== wPotion 39)
			(if (gEgo has: 39) ; grease
				(HighPrint 5 12) ; "You feel a tingling sensation as you rub the unguent all over your body."
				(SetFlag 168)
				(= global220 150)
				(gEgo use: 39) ; grease
				(gEgo get: 26) ; empty bottle
			else
				(HighPrint 5 13) ; "You can't. You don't have any."
			)
		)
	)
	(DisposeScript 5)
)

