;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 91)
(include sci.sh)
(use System)

(class StateMachine of Script
	(properties
		cueState 0
	)

	(method (doit &tmp thisSeconds)
		(cond
			(script
				(script doit:)
			)
			(cycles
				(if (not (-- cycles))
					(self cue:)
				)
			)
			(seconds
				(= thisSeconds (GetTime 1)) ; SysTime12
				(if (!= lastSeconds thisSeconds)
					(= lastSeconds thisSeconds)
					(if (not (-- seconds))
						(self cue:)
					)
				)
			)
			(cueState)
			(else
				(self cue:)
			)
		)
	)

	(method (changeState newState)
		(= state newState)
		(= cycles 1)
	)

	(method (doState))

	(method (cue theSignal &tmp aSignal)
		(if (not client)
			(return)
		)
		(= aSignal (if argc theSignal else 0))
		(if cueState
			(= state cueState)
			(= cueState 0)
		)
		(self doState: aSignal)
	)
)

