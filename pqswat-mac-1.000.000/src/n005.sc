;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)

(public
	proc5_0 0
	proc5_1 1
	proc5_2 2
)

(procedure (proc5_2) ; UNUSED
	(return 0)
)

(procedure (proc5_1) ; UNUSED
	(return 0)
)

(procedure (proc5_0 param1 param2 param3 &tmp temp0) ; UNUSED
	(= temp0 (+ gGameTime param2))
	(while (< gGameTime temp0)
		(= gGameTime (+ gTickOffset (GetTime)))
		(if (not param1)
			(gTimers eachElementDo: #doit)
			(gCast doit:)
			(FrameOut)
			(if gCuees
				(gCuees eachElementDo: #doit)
			)
			(gTheDoits doit:)
		)
		(if (gUser curEvent:)
			((gUser curEvent:) dispose:)
		)
	)
	(if (and param3 (> argc 2))
		(param3 cue:)
	)
)

