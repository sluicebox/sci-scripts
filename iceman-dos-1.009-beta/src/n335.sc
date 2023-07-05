;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 335)
(include sci.sh)
(use battleShip1)
(use n396)

(public
	proc335_0 0
)

(procedure (proc335_0 &tmp temp0 temp1)
	(for ((= temp0 (= temp1 0))) (< temp0 6) ((++ temp0))
		(if
			(and
				(Class_339_0 at: (+ temp0 0))
				(or
					(== temp1 0)
					(<
						(Class_339_0 at: (+ temp0 0))
						(Class_339_0 at: (+ temp1 0))
					)
				)
			)
			(= temp1 temp0)
		)
	)
	(if (Class_339_0 at: (+ temp1 0))
		(Class_339_0 at: (+ temp1 0) 0)
		((Class_339_0 at: (+ temp1 6)) setCel: 10)
		(Class_339_0 at: (+ temp1 6) 0)
		(switch (Random 0 1)
			(0
				(proc396_0 3 335 0) ; "TORPEDO FOLLOWING OUR DECOY SIR"
			)
			(1
				(proc396_0 3 335 1) ; "DECOY PULLING AWAY ONE TORPEDO SIR"
			)
		)
		(return 1)
	else
		(return 0)
	)
)

