;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 893)
(include sci.sh)
(use Interface)
(use System)

(procedure (localproc_0 param1 param2 param3 &tmp temp0)
	(= temp0 param2)
	(if (< argc 3)
		(Memory memPEEK (+ param1 temp0))
	else
		(Memory memPOKE (+ param1 temp0) param3)
	)
)

(class Table of Obj
	(properties
		sel_20 {Table}
		sel_608 0
		sel_609 1
		sel_610 32767
	)

	(method (sel_64 param1 param2)
		(if (and (< -1 param1 sel_610) (< -1 param2 sel_609))
			(localproc_0 sel_608 (* 2 (+ param2 (* sel_609 param1))))
		else
			(Printf 893 0 sel_20 param1 param2) ; "(%s at: %d %d ) out of bounds error"
			(SetDebug)
		)
	)
)

