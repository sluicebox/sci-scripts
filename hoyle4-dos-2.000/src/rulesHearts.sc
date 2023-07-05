;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Print)
(use System)

(public
	rulesHearts 0
)

(instance rulesHearts of Code
	(properties)

	(method (init &tmp temp0)
		(for ((= temp0 1)) (<= temp0 5) ((++ temp0))
			(if (not (Print addText: 1 18 0 temp0 0 0 320 init:))
				(break)
			)
		)
		(DisposeScript 320)
	)
)

