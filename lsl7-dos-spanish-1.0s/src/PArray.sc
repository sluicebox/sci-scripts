;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64898)
(include sci.sh)
(use Array)

(class PArray of IDArray
	(properties)

	(method (add param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 argc) ((+= temp0 2))
			(self at: [param1 temp0] [param1 (+ temp0 1)])
		)
	)
)

