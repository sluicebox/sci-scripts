;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 898)
(include sci.sh)
(use Main)
(use System)

(class Tmrs of Obj
	(properties
		cycles 0
		seconds 1000
		lastSeconds 0
	)

	(method (done)
		(return (and (not seconds) (not cycles)))
	)

	(method (setCycles param1)
		(= cycles param1)
		(= seconds 0)
	)

	(method (setSeconds param1)
		(= seconds param1)
		(= cycles 0)
	)

	(method (doit &tmp temp0)
		(cond
			(seconds
				(= temp0 (GetTime 1)) ; SysTime12
				(if (!= lastSeconds temp0)
					(= lastSeconds temp0)
					(if (not (-- seconds))
						(self dispose:)
					)
				)
			)
			(cycles
				(-- cycles)
			)
		)
	)
)

(class Dly of Tmrs
	(properties
		seconds 0
		aCue 0
	)

	(method (setCycles param1 param2)
		(super setCycles: param1)
		(= aCue (if (== argc 2) param2 else 1))
	)

	(method (setSeconds param1 param2)
		(if (global300 seconds:)
			(if aCue
				(gCardRoom cue:)
			)
		else
			(super setSeconds: param1)
			(= aCue (if (== argc 2) param2 else 1))
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (and aCue (self done:))
			(gCardRoom cue:)
		)
	)
)

