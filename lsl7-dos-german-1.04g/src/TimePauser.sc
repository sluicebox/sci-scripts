;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64016)
(include sci.sh)
(use Main)
(use System)

(class TimePauser of Obj
	(properties
		oldTimers 0
		bIsPaused 0
		nTimeFrozen 0
	)

	(method (init)
		(if (not bIsPaused)
			(= bIsPaused 1)
			(= nTimeFrozen gGameTime)
		)
	)

	(method (dispose)
		(if bIsPaused
			(= bIsPaused 0)
			(= gTickOffset (- (= gGameTime nTimeFrozen) (GetTime)))
		)
	)
)

