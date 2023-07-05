;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 813)
(include sci.sh)
(use Main)
(use n814)

(public
	AdvanceTime 0
)

(procedure (AdvanceTime param1 param2 &tmp temp0 temp1)
	(= temp0 (<= gClock 2850 900))
	(switch argc
		(1
			(= temp1 (+ gClock (* 150 param1)))
		)
		(2
			(= temp1 (+ gClock (* 150 param1) (/ (* 150 param2) 60)))
		)
	)
	(^= temp1 $0001)
	(if
		(or
			(and (< gClock 1050) (>= temp1 1050))
			(and (< gClock 2400) (or (>= temp1 2400) (< temp1 gClock)))
		)
		(EatMeal)
	)
	(while (>= temp1 3600)
		(-= temp1 3600)
		(NextDay)
	)
	(FixTime (/ temp1 150) (/ (* (mod temp1 150) 60) 150))
)

