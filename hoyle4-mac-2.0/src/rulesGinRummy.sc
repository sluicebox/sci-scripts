;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 420)
(include sci.sh)
(use Print)
(use System)

(public
	rulesGinRummy 0
)

(instance rulesGinRummy of Code
	(properties)

	(method (init &tmp temp0)
		(for ((= temp0 1)) (<= temp0 8) ((++ temp0))
			(if (not (Print addText: 1 18 0 temp0 0 0 420 init:))
				(break)
			)
		)
		(DisposeScript 420)
	)
)

