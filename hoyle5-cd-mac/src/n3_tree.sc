;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 714)
(include sci.sh)
(use n709)
(use System)

(public
	n3_tree 0
)

(instance n3_tree of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(if (not (param1 bidsOpen:))
			(= temp1 0)
			(if (param1 hasCard: 3 3853)
				(++ temp1)
			)
			(if (param1 hasCard: 4 3853)
				(++ temp1)
			)
			(if (param1 hasCard: 2 3853)
				(++ temp1)
			)
			(if (param1 hasCard: 1 3853)
				(++ temp1)
			)
			(if (and (>= (param1 quickTricks:) 3) (>= temp1 3))
				(= temp0 722)
				(proc709_4 param1 12 21 1 7 1 7 1 7 1 7)
			else
				(= temp0 0)
				(proc709_4 param1 0 15 0 10 0 10 0 10 0 10)
			)
		)
	)
)

