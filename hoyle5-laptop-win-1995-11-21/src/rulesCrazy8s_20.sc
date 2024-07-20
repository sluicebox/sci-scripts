;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Print)
(use System)

(public
	rulesCrazy8s 0
)

(instance rulesCrazy8s of Code
	(properties)

	(method (init &tmp temp0)
		(for ((= temp0 1)) (<= temp0 7) ((++ temp0))
			(if (not (Print addText: 1 18 0 temp0 0 0 20 init:))
				(break)
			)
		)
		(DisposeScript 20)
	)
)

