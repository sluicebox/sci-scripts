;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64980)
(include sci.sh)
(use Main)
(use WriteFeature)
(use System)

(class Cycle of Obj
	(properties
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
		completed 0
	)

	(method (init param1)
		(if argc
			(= client param1)
		)
		(= cycleCnt gGameTime)
		(= completed 0)
	)

	(method (doit &tmp temp0 temp1)
		(if
			(or
				(>= (= temp1 (- gGameTime cycleCnt)) (client cycleSpeed:))
				(< temp1 0)
			)
			(= cycleCnt gGameTime)
			(= temp0 (self nextCel:))
			(client setCel: temp0)
			(if completed
				(self cycleDone:)
			)
		)
	)

	(method (nextCel &tmp temp0)
		(= temp0 (client cel:))
		(cond
			((== cycleDir 1)
				(if (== temp0 (client lastCel:))
					(= completed 1)
					(-- temp0)
				)
			)
			((not temp0)
				(= temp0 (= completed 1))
			)
		)
		(return (+ temp0 cycleDir))
	)

	(method (cycleDone)
		(client cycler: 0)
		(if caller
			(Cue new: caller)
		)
		(self dispose:)
	)
)

(class Fwd of Cycle
	(properties)

	(method (nextCel &tmp temp0)
		(return
			(if (== (= temp0 (super nextCel:)) (client cel:))
				(= completed 0)
			else
				temp0
			)
		)
	)
)

(class Rev of Cycle
	(properties
		cycleDir -1
	)

	(method (nextCel &tmp temp0)
		(= temp0 (super nextCel:))
		(return
			(if (client cel:)
				temp0
			else
				(= completed 0)
				(client lastCel:)
			)
		)
	)
)

(class CT of Cycle
	(properties
		endCel 0
	)

	(method (init param1 param2 param3 param4 &tmp temp0)
		(super init: param1)
		(= cycleDir param3)
		(if (== argc 4)
			(= caller param4)
		)
		(= temp0 (client lastCel:))
		(= endCel (if (> param2 temp0) temp0 else param2))
	)

	(method (nextCel)
		(return
			(if (== endCel (client cel:))
				(= completed 1)
				endCel
			else
				(super nextCel:)
			)
		)
	)
)

(class End of CT
	(properties)

	(method (init param1 param2)
		(super init: param1 (param1 lastCel:) 1 (if (== argc 2) param2 else 0))
	)
)

(class Beg of CT
	(properties)

	(method (init param1 param2)
		(super init: param1 0 -1 (if (== argc 2) param2 else 0))
	)
)

(class RandCycle of Cycle
	(properties)

	(method (nextCel &tmp temp0 temp1)
		(if (< (client lastCel:) 1)
			(PrintDebug
				{RandCycle: View%d, Loop%d has %d cel(s)\n}
				(client view:)
				(client loop:)
				(- (client lastCel:) 1)
			)
			(SetDebug client)
		)
		(= temp1 (client cel:))
		(while (== temp1 (= temp0 (Random 0 (client lastCel:))))
		)
		(return temp0)
	)
)

