;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8)
(include sci.sh)
(use Main)
(use Interface)
(use n813)

(public
	EgoRests 0
)

(procedure (EgoRests restTime mess)
	(if
		(and
			(<= gDay global116)
			(<= gClock (+ global115 150))
			(> [gEgoStats 15] (/ (MaxStamina) 2)) ; stamina
		)
		(HighPrint 8 0) ; "You're too impatient to rest right now."
	else
		(= global116 gDay)
		(= global115 gClock)
		(UseStamina (- restTime))
		(UseMana (- (/ restTime 5)))
		(TakeDamage (- (/ (+ restTime 5) 15)))
		(if mess
			(Printf 8 1 restTime) ; "After %d minutes rest, you feel better."
		)
		(AdvanceTime 0 restTime)
	)
	(DisposeScript 8)
)

