;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 820)
(include sci.sh)
(use Print)
(use System)

(public
	rulesSpades 0
)

(instance rulesSpades of Code
	(properties)

	(method (init &tmp temp0)
		(for ((= temp0 1)) (<= temp0 7) ((++ temp0))
			(if (not (Print addText: 1 18 0 temp0 0 0 820 init:))
				(break)
			)
		)
		(DisposeScript 820)
	)
)

