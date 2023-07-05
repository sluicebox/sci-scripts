;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
(include sci.sh)
(use battleShip1)
(use n396)

(public
	proc330_0 0
)

(procedure (proc330_0 &tmp [temp0 25])
	(if (Class_339_0 at: 29)
		(cond
			((< (Class_339_0 at: 30) 50)
				(Format @temp0 330 0 (Random 100 300)) ; "IMPACT IMMINENT AT %d YARDS"
			)
			((< (Class_339_0 at: 29) 2)
				(Format @temp0 330 1 (* (Abs (Class_339_0 at: 30)) 7)) ; "RANGE %d YARDS"
			)
			(else
				(Format @temp0 330 2 (* (Abs (Class_339_0 at: 30)) 7)) ; "NEAREST AT %d YARDS"
			)
		)
		(proc396_0 3 @temp0)
	)
	(return 4)
)

