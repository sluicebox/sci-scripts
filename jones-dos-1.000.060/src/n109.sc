;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 109)
(include sci.sh)

(public
	proc109_0 0
)

(procedure (proc109_0 param1 param2 &tmp temp0 temp1 temp2)
	(if
		(<
			(= temp0
				(if (< param1 100)
					(- param1 (/ (* (- 100 param1) 2) 3))
				else
					(+ param1 (/ (* (- param1 100) 2) 3))
				)
			)
			50
		)
		(= temp0 50)
	)
	(if
		(<
			(= temp1
				(+
					(/
						(= temp2
							(if (< (* param2 (/ temp0 10)) 0)
								32767
							else
								(* param2 (/ temp0 10))
							)
						)
						10
					)
					(/ (* param2 (mod temp0 10)) 100)
				)
			)
			1
		)
		(= temp1 1)
	)
	(return temp1)
)

