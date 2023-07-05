;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use System)

(class VCycle of Obj
	(properties
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
		completed 0
		firstView 0
		lastView 0
		clientLastCel 0
	)

	(method (init param1 param2 param3)
		(if argc
			(= client param1)
			(= firstView (client view:))
			(= lastView firstView)
		)
		(if (> argc 2)
			(= firstView param2)
			(= lastView param3)
		)
		(= cycleCnt gGameTime)
		(= completed 0)
		(= clientLastCel (client lastCel:))
	)

	(method (nextCel)
		(return
			(if (< (Abs (- gGameTime cycleCnt)) (client cycleSpeed:))
				(client cel:)
			else
				(= cycleCnt gGameTime)
				(+ (client cel:) cycleDir)
			)
		)
	)

	(method (cycleDone)
		(= completed 1)
		(self motionCue:)
	)

	(method (motionCue)
		(client cycler: 0)
		(if (and completed caller)
			(caller cue:)
			(= caller 0)
		)
		(self dispose:)
	)
)

(class VFwd of VCycle
	(properties)

	(method (doit &tmp temp0 temp1 temp2)
		(if (!= (client cel:) (= temp0 (self nextCel:)))
			(if (> temp0 (client lastCel:))
				(client cel: 0)
				(if (>= (= temp1 (+ (client loop:) 1)) (NumLoops client))
					(client loop: 0)
					(if (> (= temp2 (+ (client view:) 1)) lastView)
						(self cycleDone:)
					else
						(client view: temp2)
					)
				else
					(client loop: temp1)
				)
			else
				(client cel: temp0)
			)
		)
	)

	(method (cycleDone)
		(client view: firstView)
	)
)

(class VWalk of VFwd
	(properties)

	(method (doit &tmp temp0)
		(if (not (client isStopped:))
			(super doit:)
		)
	)
)

(class VCT of VCycle
	(properties
		endCel 0
		endLoop 0
		endView 0
	)

	(method (init param1 param2 param3 param4 param5 param6 param7 param8 &tmp temp0)
		(super init: param1 param2 param3)
		(= cycleDir param7)
		(if (> argc 7)
			(= caller param8)
		)
		(= endCel (if (> param4 clientLastCel) clientLastCel else param4))
		(= endLoop param5)
		(= endView param6)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(if (!= (= temp4 (client cel:)) (= temp0 (self nextCel:)))
			(cond
				((> temp0 (client lastCel:))
					(if (>= (= temp1 (+ (client loop:) 1)) (NumLoops client))
						(client loop: 0)
						(if (> (= temp2 (+ (client view:) 1)) lastView)
							(client view: firstView)
						else
							(client view: temp2)
						)
					else
						(client loop: temp1)
					)
					(client cel: 0)
				)
				((< temp0 0)
					(if (< (= temp1 (- (client loop:) 1)) 0)
						(if (< (= temp2 (- (client view:) 1)) firstView)
							(client view: lastView)
						else
							(client view: temp2)
						)
						(client loop: (- (NumLoops client) 1))
					else
						(client loop: temp1)
					)
					(client cel: (- (NumCels client) 1))
				)
				(else
					(client cel: temp0)
				)
			)
		)
		(if
			(and
				(== gGameTime cycleCnt)
				(== endView (client view:))
				(== endLoop (client loop:))
				(== endCel (client cel:))
			)
			(self cycleDone:)
		)
	)
)

(class VEnd of VCycle
	(properties)

	(method (init param1 param2 param3 param4)
		(if (> argc 3)
			(= caller param4)
		)
		(super init: param1 param2 param3)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(if (!= (client cel:) (= temp0 (self nextCel:)))
			(if (> temp0 (client lastCel:))
				(if (>= (= temp1 (+ (client loop:) 1)) (NumLoops client))
					(if (> (= temp2 (+ (client view:) 1)) lastView)
						(self cycleDone:)
						(return)
					else
						(client view: temp2)
					)
					(client loop: 0)
				else
					(client loop: temp1)
				)
				(client cel: 0)
			else
				(client cel: temp0)
			)
		)
	)
)

(class VBeg of VCycle
	(properties
		cycleDir -1
	)

	(method (init param1 param2 param3 param4)
		(if (> argc 3)
			(= caller param4)
		)
		(super init: param1 param2 param3)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(if (!= (client cel:) (= temp0 (self nextCel:)))
			(if (< temp0 0)
				(if (< (= temp1 (- (client loop:) 1)) 0)
					(if (< (= temp2 (- (client view:) 1)) firstView)
						(self cycleDone:)
						(return)
					else
						(client view: temp2)
					)
					(client loop: (- (NumLoops client) 1))
				else
					(client loop: temp1)
				)
				(client cel: (- (NumCels client) 1))
			else
				(client cel: temp0)
			)
		)
	)
)

