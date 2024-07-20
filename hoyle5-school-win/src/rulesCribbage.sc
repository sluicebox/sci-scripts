;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 520)
(include sci.sh)
(use Print)
(use System)

(public
	rulesCribbage 0
)

(instance rulesCribbage of Code
	(properties)

	(method (init &tmp temp0)
		(for ((= temp0 1)) (<= temp0 10) ((++ temp0))
			(if (not (Print addText: 1 18 0 temp0 0 0 520 init:))
				(break)
			)
		)
		(DisposeScript 520)
	)
)

