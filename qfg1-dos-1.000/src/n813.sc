;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 813)
(include sci.sh)
(use Main)

(public
	AdvanceTime 0
)

(procedure (AdvanceTime addHours addMinutes &tmp newTime)
	(switch argc
		(1
			(= newTime (+ gClock (* 150 addHours)))
		)
		(2
			(= newTime (+ gClock (* 150 addHours) (/ (* 150 addMinutes) 60)))
		)
	)
	(^= newTime $0001)
	(if
		(or
			(and (< gClock 1100) (>= newTime 1100))
			(and (< gClock 2500) (or (>= newTime 2500) (< newTime gClock)))
		)
		(EatMeal)
	)
	(while (>= newTime 3600)
		(-= newTime 3600)
		(NextDay)
	)
	(FixTime (/ newTime 150) (/ (* (mod newTime 150) 60) 150))
	(DisposeScript 813)
)

