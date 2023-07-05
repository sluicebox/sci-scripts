;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 334)
(include sci.sh)
(use battleShip1)

(public
	proc334_0 0
)

(procedure (proc334_0 param1 &tmp temp0 temp1)
	(for ((= temp0 (= temp1 0))) (< temp0 6) ((++ temp0))
		(if (not (Class_339_0 at: (+ temp0 12)))
			(Class_339_0 at: (+ temp0 12) param1)
			(Class_339_0 at: (+ temp0 18) (Class_339_0 at: (+ temp0 33)))
			(= temp0 6)
		)
	)
)

