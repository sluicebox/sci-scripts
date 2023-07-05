;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 333)
(include sci.sh)
(use battleShip1)

(public
	proc333_0 0
)

(procedure (proc333_0 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		(if (Class_339_0 at: (+ temp0 12))
			((Class_339_0 at: (+ temp0 20)) setCel: 10)
			(Class_339_0 at: (+ temp0 20) 0)
		)
	)
)

