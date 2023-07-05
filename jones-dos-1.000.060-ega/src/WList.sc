;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 102)
(include sci.sh)
(use System)

(class WList of List
	(properties
		registerX 0
		registerY 0
	)

	(method (empty &tmp temp0)
		(if size
			(for ((= temp0 (- size 1))) (>= temp0 0) ((-- temp0))
				(self delete: (self at: temp0))
			)
		)
	)
)

