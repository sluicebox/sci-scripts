;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 620)
(include sci.sh)
(use Print)
(use System)

(public
	rulesKlondike 0
)

(instance rulesKlondike of Code
	(properties)

	(method (init &tmp temp0)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(if (not (Print addText: 1 18 0 temp0 0 0 620 init:))
				(break)
			)
		)
		(DisposeScript 620)
	)
)

