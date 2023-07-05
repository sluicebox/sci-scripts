;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 321)
(include sci.sh)
(use n396)
(use torpedosIn)

(public
	proc321_0 0
)

(procedure (proc321_0 param1 param2 param3 &tmp temp0)
	(for ((= temp0 0)) (and (Class_399_0 at: temp0) (< temp0 5)) ((++ temp0))
	)
	(if
		(and
			(< temp0 5)
			(or (== param2 100) (and (< (Random 0 99) param2) (< 0 param3)))
		)
		(switch (Random 0 2)
			(0
				(proc396_0 3 321 0) ; "THE ALPHA HAS FIRED A TORPEDO"
			)
			(1
				(proc396_0 3 321 1) ; "TORPEDO LAUNCHED AT US SIR"
			)
			(2
				(proc396_0 3 321 2) ; "TORPEDO LAUNCH DETECTED SIR"
			)
		)
		(Class_399_0 at: temp0 (Abs param1))
		(Class_399_0
			at:
				(+ temp0 5)
				(((Class_399_0 at: 20) new:)
					init:
					loop: 1
					cel: 10
					x: 195
					y: (+ 43 (* temp0 2))
					yourself:
				)
		)
	)
)

