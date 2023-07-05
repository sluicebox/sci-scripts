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
		data 0
		columns 1
		rows 32767
	)

	(method (at param1 param2)
		(if (and (< -1 param1 rows) (< -1 param2 columns))
			(localproc_0 data (* 2 (+ param2 (* columns param1))))
		else
			(Printf 893 0 name param1 param2 name param1 param2) ; "(%s at: %d %d ) out of bounds error"
			(SetDebug)
		)
	)
)

