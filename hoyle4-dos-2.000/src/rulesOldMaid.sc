;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Print)
(use System)

(public
	rulesOldMaid 0
)

(instance rulesOldMaid of Code
	(properties)

	(method (init &tmp temp0)
		(for ((= temp0 1)) (<= temp0 2) ((++ temp0))
			(if (not (Print addText: 1 18 0 temp0 0 0 220 init:))
				(break)
			)
		)
		(DisposeScript 220)
	)
)

