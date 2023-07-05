;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64973)
(include sci.sh)
(use Main)
(use System)

(class Timer of Cue
	(properties
		type -1
		cycles -1
		seconds -1
		ticks -1
		lastTime -1
	)

	(method (new param1 param2 param3 &tmp temp0)
		(if (not argc)
			(PrintDebug {Timers now require caller. See timer.sc\n})
			(Empty self)
		)
		(= temp0 (super new: param1))
		(if (>= argc 3)
			(temp0 set: param2 param3 &rest)
		)
	)

	(method (dispose)
		(= cycles (= seconds (= ticks (= lastTime -1))))
		(super dispose: &rest)
	)

	(method (doit &tmp theTime)
		(switch type
			(1
				(if (not (-- cycles))
					(super doit:)
				)
			)
			(3
				(if (!= lastTime (= theTime (GetTime 1))) ; SysTime12
					(= lastTime theTime)
					(if (not (-- seconds))
						(super doit:)
					)
				)
			)
			(2
				(if (> (- gGameTime ticks) 0)
					(super doit:)
				)
			)
			(else
				(PrintDebug {Unknown Timer type: %d\n} type)
				(Empty self)
			)
		)
	)

	(method (set param1 param2)
		(switch param1
			(1
				(self setCycle: param2)
			)
			(2
				(self setTicks: param2)
			)
			(3
				(self setReal: param2 &rest)
			)
			(else
				(PrintDebug {Unknown Timer type: %d\n} param1)
				(Empty self)
			)
		)
	)

	(method (setCycle param1)
		(= type 1)
		(= cycles param1)
	)

	(method (setReal param1 param2 param3)
		(= type 3)
		(++ param1)
		(if (> argc 2)
			(+= param1 (* param2 60))
		)
		(if (> argc 3)
			(+= param1 (* param3 3600))
		)
		(= seconds param1)
	)

	(method (setTicks param1)
		(= type 2)
		(= ticks (+ (GetTime) param1 gTickOffset))
	)
)

