;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64041)
(include sci.sh)
(use Array)
(use Motion)
(use System)

(class CycleCueList of Cycle
	(properties
		endCel 0
		oCueArray 0
		nCurCue 0
		nCues 0
	)

	(method (init param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2)
		(super init: param1)
		(= cycleDir param3)
		(if (>= argc 4)
			(= caller param4)
		)
		(= nCues (Max 0 (- argc 4)))
		(= nCurCue 0)
		(= oCueArray (IntArray new:))
		(for ((= temp2 0)) (< temp2 nCues) ((++ temp2))
			(if (> (= temp1 [param5 temp2]) clientLastCel)
				(= temp1 clientLastCel)
			)
			(if (< temp1 0)
				(= temp1 0)
			)
			(oCueArray at: temp2 temp1)
		)
		(= endCel (Max 0 (Min param2 clientLastCel)))
	)

	(method (doit &tmp temp0 temp1)
		(if (!= (= temp1 (client cel:)) (= temp0 (self nextCel:)))
			(if (== temp1 endCel)
				(self cycleDone:)
			else
				(client cel: temp0)
				(if (and (< nCurCue nCues) (== temp0 (oCueArray at: nCurCue)))
					(++ nCurCue)
					(if caller
						(caller cue:)
					)
				)
			)
		)
	)

	(method (cycleDone)
		(= completed 1)
		(= caller 0)
		(self motionCue:)
	)

	(method (dispose)
		(if oCueArray
			(oCueArray dispose:)
			(= oCueArray 0)
		)
		(super dispose: &rest)
	)
)

(class End of CycleCueList
	(properties)

	(method (init param1)
		(super init: param1 (param1 lastCel:) 1 &rest)
	)
)

(class Beg of CycleCueList
	(properties)

	(method (init param1)
		(super init: param1 0 -1 &rest)
	)
)

