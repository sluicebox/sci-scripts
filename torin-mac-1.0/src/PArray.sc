;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64898)
(include sci.sh)
(use Array)

(class PArray of IDArray
	(properties)

	(method (add list &tmp i)
		(for ((= i 0)) (< i argc) ((+= i 2))
			(self at: [list i] [list (+ i 1)])
		)
	)
)

