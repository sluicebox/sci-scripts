;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
(use n008)
(use n814)
(use Print)
(use System)

(public
	EgoSleeps 0
	CanSleep 1
	PromptSleep 2
)

(local
	local0
)

(procedure (PromptSleep &tmp temp0)
	(= local0 ((gTheIconBar curIcon:) cursor:))
	(gGame setCursor: 999)
	(switch
		(Print
			addText: 1 0 1 1 0 0 7 ; "How long, Hero?"
			addButton: 1 1 0 0 1 0 20 7 ; "10 minute rest"
			addButton: 2 1 0 0 2 0 40 7 ; "30 minute rest"
			addButton: 3 1 0 0 3 0 60 7 ; "60 minute rest"
			addButton: 4 1 0 0 4 0 80 7 ; "Sleep all night"
			addButton: 5 1 0 0 5 0 100 7 ; "Stay awake"
			init:
		)
		(1
			(EgoRests 10 1)
		)
		(2
			(EgoRests 30 1)
		)
		(3
			(EgoRests 60 1)
		)
		(4
			(cond
				((not (CanSleep))
					(gMessager say: 1 0 0 6 0 7) ; "You just can't sleep during the daytime."
				)
				(
					(OneOf
						gCurRoomNum
						10
						13
						29
						30
						31
						38
						39
						40
						41
						76
						83
						93
						94
						141
						300
						301
						310
						311
						320
						321
						330
						332
					)
					((= temp0 (Event new:)) type: evMOUSEBUTTON message: KEY_4)
					(if (not (gMouseDownHandler handleEvent: temp0))
						(gRegions handleEvent: temp0)
					)
					(temp0 dispose:)
					(return 1)
				)
				(else
					(EgoSleeps 5 0)
				)
			)
		)
		(5
			(return 1)
		)
	)
	(Platform 0 4 2 -1)
	(return (gGame setCursor: local0))
)

(procedure (CanSleep)
	(return (or (>= gTimeOfDay 4) global247))
)

(procedure (EgoSleeps param1 param2 &tmp temp0 temp1)
	(if (not (CanSleep))
		(gMessager say: 1 0 0 6 0 7) ; "You just can't sleep during the daytime."
	else
		(Platform 0 4 3 -1)
		(= global247 0)
		(= temp1 gClock)
		(if (OneOf gCurRoomNum 10 40 141 76 83 302 300 310 320 330)
			(switch argc
				(0
					(FixTime 5)
				)
				(1
					(FixTime param1)
				)
				(else
					(FixTime param1 param2)
				)
			)
			(= temp0 (/ (mod (- (+ gClock 3600) temp1) 3600) 150))
			(= [gEgoStats 15] (MaxStamina)) ; stamina
			(if (== gCurRoomNum 10)
				(= [gEgoStats 14] (MaxHealth)) ; health
				(= [gEgoStats 16] (MaxMana)) ; mana
			else
				(TakeDamage (- (* temp0 2)))
				(UseMana (- (* temp0 2)))
			)
			(if (> temp1 gClock)
				(NextDay)
			)
			(if (not (OneOf gCurRoomNum 300 302 310 320 330))
				(Print addText: 1 0 0 7 0 0 7 ticks: -1 y: 10 init:) ; "You awake as the sun begins to rise."
			)
		else
			(EgoDead 122 123) ; "While you were asleep, something decided to make a meal of you. You're not sure what it was, but you don't really care at this point. You shouldn't go to sleep where the creatures of the night can get you."
		)
	)
	(Platform 0 4 2 -1)
)

