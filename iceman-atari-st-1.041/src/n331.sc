;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 331)
(include sci.sh)
(use battleShip1)
(use n396)
(use Submarine_806)

(public
	proc331_0 0
)

(procedure (proc331_0 param1 param2 &tmp temp0)
	(for
		((= temp0 0))
		(and (Class_339_0 at: (+ temp0 0)) (< temp0 6))
		((++ temp0))
	)
	(if
		(and
			(< temp0 6)
			(< 50 param1)
			(or (& (Submarine flags:) $0080) (< (Random 0 99) 40) (not param2))
		)
		(if param2
			(switch (Random 0 2)
				(0
					(proc396_0 2 331 0) ; "THE DESTROYER HAS FIRED A TORPEDO."
				)
				(1
					(proc396_0 2 331 1) ; "TORPEDO HAS BEEN LAUNCHED AT US, SIR."
				)
				(2
					(proc396_0 2 331 2) ; "DETECTING TORPEDO LAUNCH, SIR."
				)
			)
		)
		(Class_339_0 at: (+ temp0 0) param1)
		(Class_339_0 at: (+ temp0 6) (Class_339_0 at: (+ temp0 27)))
	)
)

