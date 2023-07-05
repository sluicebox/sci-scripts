;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 332)
(include sci.sh)
(use battleShip1)
(use n396)

(public
	proc332_0 0
)

(procedure (proc332_0 &tmp temp0 [temp1 25])
	(= temp0 0)
	(Class_339_0 at: 25 0)
	(Class_339_0 at: 26 0)
	(while (< temp0 6)
		(if (Class_339_0 at: (+ temp0 0))
			(Class_339_0 at: 25 (+ (Class_339_0 at: 25) 1))
			(if
				(or
					(== (Class_339_0 at: 26) 0)
					(< (Class_339_0 at: (+ temp0 0)) (Class_339_0 at: 26))
				)
				(Class_339_0 at: 26 (Class_339_0 at: (+ temp0 0)))
			)
		)
		(++ temp0)
	)
	(cond
		((< 1 (Class_339_0 at: 25))
			(switch (Random 0 2)
				(0
					(Format @temp1 332 0 (Class_339_0 at: 25)) ; "SIR %d TORPEDOS INCOMING"
				)
				(1
					(Format @temp1 332 1 (Class_339_0 at: 25)) ; "SIR I MAKE %d FISH ON THE WAY"
				)
				(2
					(Format @temp1 332 2 (Class_339_0 at: 25)) ; "%d TORPEDOS TARGETED ON US SIR"
				)
			)
			(proc396_0 3 @temp1)
			(return 4)
		)
		((Class_339_0 at: 25)
			(switch (Random 0 2)
				(0
					(proc396_0 3 332 3) ; "TORPEDO IN THE WATER SIR"
				)
				(1
					(proc396_0 3 332 4) ; "ENEMY TORPEDO INBOUND SIR"
				)
				(2
					(proc396_0 3 332 5) ; "SINGLE FISH COMING AT US SIR"
				)
			)
			(return 4)
		)
		(else
			(return 1)
		)
	)
)

