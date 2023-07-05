;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 343)
(include sci.sh)
(use n396)
(use Submarine_806)

(public
	proc343_0 0
)

(procedure (proc343_0 param1 param2 param3)
	(switch param1
		(0
			(if (and (< param2 0) (< 1100 (Submarine depth:)))
				(proc396_0 4 343 0) ; "SIR, THE ENEMY SUB IS BELOW THE INVERSION LAYER."
				(return 1)
			else
				(return 0)
			)
		)
		(1
			(if
				(and
					(<= 2282 (Submarine depth:))
					(< (Submarine hSpeed:) 5)
					(not (& (Submarine flags:) $0080))
					(& (Submarine flags:) $0040)
				)
				(proc396_0 4 343 1) ; "THE ALPHA CAN'T FIND US DOWN HERE, SIR."
				(return 1)
			else
				(return 0)
			)
		)
		(2
			(if
				(and
					(<= 2282 (Submarine depth:))
					(< (Submarine hSpeed:) 5)
					(not (& (Submarine flags:) $0080))
					(& (Submarine flags:) $0040)
					(< param3 -10)
				)
				(proc396_0 4 343 2) ; "THE ALPHA IS PASSING OVER US, SIR."
				(return 1)
			else
				(return 0)
			)
		)
		(3
			(if
				(and
					(<= 2282 (Submarine depth:))
					(< (Submarine hSpeed:) 5)
					(not (& (Submarine flags:) $0080))
					(& (Submarine flags:) $0040)
					(< param3 -400)
				)
				(proc396_0 4 343 3) ; "THE ALPHA IS LEAVING, SIR."
				(return 1)
			else
				(return 0)
			)
		)
		(else
			(return 0)
		)
	)
)

