;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 324)
(include sci.sh)
(use n396)
(use torpedosIn)

(public
	proc324_0 0
	proc324_1 1
)

(procedure (proc324_0 &tmp temp0 [temp1 25])
	(= temp0 0)
	(Class_399_0 at: 27 0)
	(Class_399_0 at: 28 0)
	(while (< temp0 5)
		(if (Class_399_0 at: temp0)
			(Class_399_0 at: 27 (+ (Class_399_0 at: 27) 1))
			(if
				(or
					(== (Class_399_0 at: 28) 0)
					(< (Class_399_0 at: temp0) (Class_399_0 at: 28))
				)
				(Class_399_0 at: 28 (Class_399_0 at: temp0))
			)
		)
		(++ temp0)
	)
	(cond
		((< 1 (Class_399_0 at: 27))
			(switch (Random 0 2)
				(0
					(Format @temp1 324 0 (Class_399_0 at: 27)) ; "SIR %d TORPEDOS INCOMING"
				)
				(1
					(Format @temp1 324 1 (Class_399_0 at: 27)) ; "SIR I MAKE %d FISH ON THE WAY"
				)
				(2
					(Format @temp1 324 2 (Class_399_0 at: 27)) ; "%d TORPEDOS TARGETED ON US SIR"
				)
			)
			(proc396_0 4 @temp1)
			(return 5)
		)
		((Class_399_0 at: 27)
			(switch (Random 0 2)
				(0
					(proc396_0 4 324 3) ; "TORPEDO IN THE WATER SIR"
				)
				(1
					(proc396_0 4 324 4) ; "ENEMY TORPEDO INBOUND, SIR"
				)
				(2
					(proc396_0 4 324 5) ; "SINGLE FISH COMING AT US, SIR"
				)
			)
			(return 5)
		)
		(else
			(return 1)
		)
	)
)

(procedure (proc324_1 &tmp [temp0 25])
	(if (Class_399_0 at: 27)
		(cond
			((< (Class_399_0 at: 28) 100)
				(Format @temp0 324 6 (Random 5 15)) ; "TIME TO IMPACT WITH US %d SECONDS"
				(proc396_0 3 @temp0)
			)
			((< (Class_399_0 at: 27) 2)
				(Format @temp0 324 7 (* (Class_399_0 at: 28) 7)) ; "AT %d YARDS"
				(proc396_0 3 @temp0)
			)
			(else
				(Format @temp0 324 8 (* (Class_399_0 at: 28) 7)) ; "NEAREST AT %d YARDS"
				(proc396_0 3 @temp0)
			)
		)
		(return 4)
	else
		(return 1)
	)
)

