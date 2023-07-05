;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 888)
(include sci.sh)
(use Main)

(public
	proc888_0 0
)

(procedure (proc888_0 &tmp temp0 temp1)
	(if (not global188)
		(for ((= temp0 (= temp1 0))) (< temp0 3) ((++ temp0))
			(if [global500 temp0]
				(= [global780 temp1] [global500 temp0])
				(++ temp1)
			)
		)
		(++ global188)
	)
	(cond
		((== (- global448 1) 1)
			(if (Random 0 4)
				(= global778 108)
				(= global199
					(Format @global520 108 (= global779 (Random 20 39)))
				)
			else
				(= global778 (+ [global805 global780] 7))
				(= global199
					(Format
						@global520
						(+ [global805 global780] 7)
						(= global779 (Random 0 4))
					)
				)
			)
			(return 1)
		)
		((== global188 1)
			(++ global188)
			(if (or (>= global801 (Random 2 4)) (>= [global783 global800] 4))
				(= global801 0)
				(= [global790 global800]
					(= [global790 (+ 3 global800)]
						(= [global790 (+ 6 global800)] 0)
					)
				)
				(repeat
					(if (!= global800 (= temp0 (Random 0 (- global448 2))))
						(= global800 temp0)
						(break)
					)
				)
				(if (>= [global783 global800] 4)
					(= [global783 global800] -1)
				)
				(for ((= temp0 0)) (< temp0 (- global448 1)) ((++ temp0))
					(= [global790 (+ (* temp0 3) global800)] 0)
					(= global803 [global780 temp0])
					(= global804 [global780 global800])
					(if (!= temp0 global800)
						(cond
							(
								(and
									(or (== global803 4) (== global803 19))
									(or (== global804 2) (== global804 5))
								)
								(= [global786 temp0] 0)
							)
							(
								(or
									(localproc_0 3 17)
									(localproc_0 4 19)
									(localproc_0 10 15)
								)
								(= [global786 temp0] 1)
							)
							((== global803 2)
								(= [global786 temp0] (not (Random 0 5)))
							)
							(
								(or
									(== global804 2)
									(== global804 5)
									(== global804 11)
									(== global803 5)
									(== global803 11)
								)
								(= [global786 temp0] (if (Random 0 5) 1 else 0))
							)
							(else
								(= [global786 temp0] (not (Random 0 5)))
							)
						)
					)
				)
			)
			(= temp0 [global780 global800])
			(++ global801)
			(localproc_2
				[global780 global800]
				[global805 temp0]
				(+=
					[global783 global800]
					(+
						1
						(if (!= [global783 global800] 3)
							(not (Random 0 2))
						)
					)
				)
			)
			(return global800)
		)
		((== global188 2)
			(= global188
				(+
					1
					(*
						2
						(if (== global448 4)
							(not (Random 0 2))
						)
					)
				)
			)
			(cond
				((== global448 3)
					(= global802 (not global800))
				)
				((== (= global802 (Random 0 1)) global800)
					(= global802 2)
				)
			)
			(= global803 [global780 global802])
			(cond
				(
					(and
						(not (Random 0 3))
						(< [global790 (+ (* global802 3) global800)] 2)
					)
					(= global188 1)
					(= [global790 (+ (* global802 3) global800)]
						(+ [global790 (+ (* global802 3) global800)] 1)
					)
					(localproc_2
						global803
						(+ [global805 global803] global804)
						(+ 2 [global790 (+ (* global802 3) global800)])
					)
				)
				((Random 0 2)
					(localproc_2 global803 108 (localproc_1 10 0))
				)
				(else
					(localproc_2
						global803
						[global805 global803]
						(localproc_1 5 19)
					)
				)
			)
			(return global802)
		)
		(else
			(= global188 1)
			(= global803
				[global780 (= global802 (- 3 (+ global802 global800)))]
			)
			(if (Random 0 2)
				(localproc_2 global803 108 (localproc_1 10 0))
			else
				(localproc_2 global803 [global805 global803] (localproc_1 5 19))
			)
			(return global802)
		)
	)
)

(procedure (localproc_0 param1 param2)
	(return
		(or
			(and (== global803 param1) (== global804 param2))
			(and (== global804 param1) (== global803 param2))
		)
	)
)

(procedure (localproc_1 param1 param2)
	(return (+ param2 (Random 1 param1) (* param1 (- 1 [global786 global802]))))
)

(procedure (localproc_2 param1 param2 param3)
	(= global778 param2)
	(= global779 param3)
	(= global776 (+ [global780 global800] [global805 param1]))
	(= global199
		(Format
			@global520
			param2
			param3
			(+ [global780 global800] [global805 param1])
			(= global777 (Random 0 2))
		)
	)
)

