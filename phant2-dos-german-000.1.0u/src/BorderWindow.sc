;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64936)
(include sci.sh)
(use Main)
(use WriteFeature)

(class Script of Obj
	(properties
		state -1
		client 0
		cycles 0
		seconds 0
		lastSeconds 0
		ticks 0
		lastTicks 0
		register 0
		caller 0
		startState 0
	)

	(method (init param1 param2 param3)
		(if (>= argc 1)
			(if (and (= client param1) (client respondsTo: #script))
				(param1 script: self)
			)
			(if (>= argc 2)
				(= caller param2)
				(if (>= argc 3)
					(= register param3)
				)
			)
		)
		(gCast add: self)
		(= lastTicks gGameTime)
		(= lastSeconds (GetTime 1)) ; SysTime12
		(= state (- startState 1))
		(self cue:)
	)

	(method (dispose)
		(if (and client (client respondsTo: #script))
			(client script: 0)
		)
		(if (and caller (== gNewRoomNum gCurRoomNum))
			(caller cue: register)
		)
		(gCast delete: self)
		((gUser orphans:) delete: self)
		(= seconds (= cycles (= ticks (= client (= caller 0)))))
		(super dispose:)
	)

	(method (changeState newState)
		(= state newState)
	)

	(method (cue)
		(= lastTicks gGameTime)
		(self changeState: (+ state 1) &rest)
	)

	(method (doit &tmp temp0)
		(cond
			(cycles
				(if (not (-- cycles))
					(self cue:)
				)
			)
			(seconds
				(= temp0 (GetTime 1)) ; SysTime12
				(if (!= lastSeconds temp0)
					(if (<= (-= seconds (- temp0 lastSeconds)) 0)
						(= seconds 0)
						(self cue:)
					)
					(= lastSeconds temp0)
				)
			)
			(ticks
				(if (<= (-= ticks (- gGameTime lastTicks)) 0)
					(= ticks 0)
					(= lastTicks gGameTime)
					(self cue:)
				else
					(= lastTicks gGameTime)
				)
			)
		)
	)

	(method (handleEvent)
		(return 0)
	)
)

