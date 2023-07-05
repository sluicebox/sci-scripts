;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64016)
(include sci.sh)
(use Main)
(use System)

(class TimePauser of Obj
	(properties
		bIsPaused 0
		oldTimers 0
		nTimeFrozen 0
	)

	(method (init)
		(if (not bIsPaused)
			(= bIsPaused 1)
			(= nTimeFrozen gGameTime)
			(= oldTimers gTimers)
			((= gTimers (Set new:)) name: {pausedTimers} add:)
		)
	)

	(method (dispose)
		(if bIsPaused
			(= bIsPaused 0)
			(= gTickOffset (- (= gGameTime nTimeFrozen) (GetTime)))
			(gTimers dispose:)
			(= gTimers oldTimers)
		)
	)
)

