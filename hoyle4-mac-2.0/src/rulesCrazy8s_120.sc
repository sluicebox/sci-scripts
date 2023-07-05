;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Print)
(use System)

(public
	rulesCrazy8s 0
)

(instance rulesCrazy8s of Code
	(properties)

	(method (init &tmp temp0)
		(for ((= temp0 1)) (<= temp0 5) ((++ temp0))
			(if (not (Print addText: 1 18 0 temp0 0 0 120 init:))
				(break)
			)
		)
		(DisposeScript 120)
	)
)

