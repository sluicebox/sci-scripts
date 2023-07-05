;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 322)
(include sci.sh)
(use torpedosIn)

(public
	proc322_0 0
)

(procedure (proc322_0 param1 &tmp temp0 temp1)
	(for ((= temp0 (= temp1 0))) (< temp0 5) ((++ temp0))
		(if (not (Class_399_0 at: (+ temp0 10)))
			(Class_399_0 at: (+ temp0 10) (Abs param1))
			(Class_399_0
				at:
					(+ temp0 15)
					(((Class_399_0 at: 20) new:)
						init:
						loop: 0
						cel: 10
						x: 119
						y: (+ 66 (* temp0 2))
						yourself:
					)
			)
			(= temp0 5)
		)
	)
)

