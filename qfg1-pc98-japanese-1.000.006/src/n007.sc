;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)

(public
	EgoSleeps 0
	CanSleep 1
)

(procedure (CanSleep)
	(return (or (>= gTimeOfDay 4) global268))
)

(procedure (EgoSleeps theHour theMin &tmp sleptHours oldTime)
	(if (not (CanSleep))
		(HighPrint 7 0) ; "You just can't sleep during the daytime."
	else
		(= global268 0)
		(= oldTime gClock)
		(switch argc
			(0
				(FixTime 5)
			)
			(1
				(FixTime theHour)
			)
			(else
				(FixTime theHour theMin)
			)
		)
		(if
			(or
				(== gCurRoomNum 10)
				(== gCurRoomNum 40)
				(== gCurRoomNum 141)
				(== gCurRoomNum 76)
				(== gCurRoomNum 83)
				(== gCurRoomNum 302)
				(== gCurRoomNum 300)
				(== gCurRoomNum 310)
				(== gCurRoomNum 320)
				(== gCurRoomNum 330)
			)
			(= sleptHours (/ (mod (- (+ gClock 3600) oldTime) 3600) 150))
			(= [gEgoStats 15] (MaxStamina)) ; stamina
			(if (== gCurRoomNum 10)
				(= [gEgoStats 14] (MaxHealth)) ; health
				(= [gEgoStats 16] (MaxMana)) ; mana
			else
				(TakeDamage (- (* sleptHours 2)))
				(UseMana (- (* sleptHours 2)))
			)
			(if (> oldTime gClock)
				(NextDay)
			)
			(if
				(not
					(or
						(== gCurRoomNum 300)
						(== gCurRoomNum 302)
						(== gCurRoomNum 310)
						(== gCurRoomNum 320)
						(== gCurRoomNum 330)
					)
				)
				(HighPrint 7 1) ; "You awake as the sun begins to rise."
			)
		else
			(EgoDead ; "While you were asleep, something decided to make a meal of you. You're not sure what it was, but you don't really care at this point. You shouldn't go to sleep where the creatures of the night can get you."
				7
				2
				82
				800
				1
				0
				80
				{Night Gaunt Got ya.%j\c5\b2\c4 \ba\de\b0\dd\c4 \b6\de \b7\d0\a6 \c0\cd\de\af\c1\cf\af\c0\d6}
			)
		)
	)
)

