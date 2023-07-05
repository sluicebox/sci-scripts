;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 312)
(include sci.sh)
(use Main)
(use System)

(class CountCombinations of Obj
	(properties
		listSize 0
		numScores 0
		rankOfPairRoyal 0
		starterPoints 0
		style 0
		aStarter 0
		total 0
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(for ((= temp2 (= temp3 0))) (< temp2 16) ((++ temp2))
			(+= temp3 ((gTheColumns at: temp2) size:))
		)
		(= temp1 0)
		(for ((= temp2 0)) (< temp2 4) ((++ temp2))
			(= total 0)
			(if ((gTheColumns at: (* temp2 4)) size:)
				(gATempList add: ((gTheColumns at: (* temp2 4)) at: 0))
			)
			(if ((gTheColumns at: (+ (* temp2 4) 1)) size:)
				(gATempList add: ((gTheColumns at: (+ (* temp2 4) 1)) at: 0))
			)
			(if ((gTheColumns at: (+ (* temp2 4) 2)) size:)
				(gATempList add: ((gTheColumns at: (+ (* temp2 4) 2)) at: 0))
			)
			(if ((gTheColumns at: (+ (* temp2 4) 3)) size:)
				(gATempList add: ((gTheColumns at: (+ (* temp2 4) 3)) at: 0))
			)
			(if (>= (gATempList size:) 2)
				(+=
					temp1
					(self
						doit:
							(if (== temp3 16)
								((gTheWastePiles at: 0) at: 0)
							else
								0
							)
							temp3
					)
				)
			)
			(gATempList empty:)
		)
		(for ((= temp2 0)) (< temp2 4) ((++ temp2))
			(= total 0)
			(if ((gTheColumns at: temp2) size:)
				(gATempList add: ((gTheColumns at: temp2) at: 0))
			)
			(if ((gTheColumns at: (+ temp2 4)) size:)
				(gATempList add: ((gTheColumns at: (+ temp2 4)) at: 0))
			)
			(if ((gTheColumns at: (+ temp2 8)) size:)
				(gATempList add: ((gTheColumns at: (+ temp2 8)) at: 0))
			)
			(if ((gTheColumns at: (+ temp2 12)) size:)
				(gATempList add: ((gTheColumns at: (+ temp2 12)) at: 0))
			)
			(if (>= (gATempList size:) 2)
				(+=
					temp1
					(self
						doit:
							(if (== temp3 16)
								((gTheWastePiles at: 0) at: 0)
							else
								0
							)
							temp3
					)
				)
			)
			(gATempList empty:)
		)
		(gATempList dispose:)
		(if (and (== temp3 16) (== [global600 0] 11))
			(+= temp1 2)
		)
		(return temp1)
	)

	(method (doit)
		(= total (= starterPoints 0))
		(self set: &rest fifteens: runs: pairs: flushes: nobs:)
		(return total)
	)

	(method (set param1 &tmp temp0)
		(= aStarter (if (and (>= argc 1) param1) 1 else 0))
		(= listSize (+ (gATempList size:) aStarter))
		(if aStarter
			(if (IsObject param1)
				(= [global600 0] (param1 rank:))
				(= [global605 0] (param1 suit:))
			else
				(= [global600 0] param1)
				(= [global605 0] -1)
			)
			(= [global610 0] (if (< [global600 0] 11) [global600 0] else 10))
		)
		(for ((= temp0 aStarter)) (< temp0 listSize) ((++ temp0))
			(= [global600 temp0] ((gATempList at: (- temp0 aStarter)) rank:))
			(= [global605 temp0] ((gATempList at: (- temp0 aStarter)) suit:))
			(= [global610 temp0]
				(if (< [global600 temp0] 11) [global600 temp0] else 10)
			)
		)
		(= numScores (= rankOfPairRoyal 0))
	)

	(method (next param1)
		(++ numScores)
		(= [global615 numScores] param1)
		(+=
			total
			(switch param1
				(1 2)
				(2 2)
				(3 6)
				(4 12)
				(5 3)
				(6 4)
				(7 5)
				(8 1)
				(9 4)
				(10 5)
				(else 0)
			)
		)
	)

	(method (order param1 &tmp temp0 temp1 temp2 [temp3 5])
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(= [temp3 temp0] [param1 temp0])
		)
		(for ((= temp0 0)) (< temp0 (- argc 1)) ((++ temp0))
			(for ((= temp1 0)) (< temp1 (- argc 1)) ((++ temp1))
				(if (> [temp3 temp1] [temp3 (+ temp1 1)])
					(= temp2 [temp3 (+ temp1 1)])
					(= [temp3 (+ temp1 1)] [temp3 temp1])
					(= [temp3 temp1] temp2)
				)
			)
		)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(= [global625 temp0] [temp3 temp0])
		)
	)

	(method (nobs &tmp temp0)
		(if (== listSize 5)
			(for ((= temp0 1)) (< temp0 5) ((++ temp0))
				(if
					(and
						(== [global600 temp0] 11)
						(== [global605 temp0] [global605 0])
					)
					(self next: 8)
				)
			)
		)
	)

	(method (flushes)
		(if (>= listSize 4)
			(cond
				(aStarter
					(if
						(and
							(== [global605 1] [global605 2])
							(== [global605 2] [global605 3])
							(== [global605 3] [global605 4])
						)
						(if (== [global605 0] [global605 1])
							(self next: 10)
						else
							(self next: 9)
						)
					)
				)
				(
					(and
						(== [global605 0] [global605 1])
						(== [global605 1] [global605 2])
						(== [global605 2] [global605 3])
					)
					(self next: 9)
				)
			)
		)
	)

	(method (cards2 param1 &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 (- listSize 1)) ((++ temp0))
			(for ((= temp1 (+ temp0 1))) (< temp1 listSize) ((++ temp1))
				(switch param1
					(1
						(if (== (+ [global610 temp0] [global610 temp1]) 15)
							(self next: 1)
							(if (and aStarter (not temp0))
								(+= starterPoints 2)
							)
						)
					)
					(2
						(if
							(and
								(== [global600 temp0] [global600 temp1])
								(!= rankOfPairRoyal [global600 temp0])
							)
							(self next: 2)
							(if (and aStarter (not temp0))
								(+= starterPoints 2)
							)
						)
					)
				)
			)
		)
	)

	(method (cards3 param1 &tmp temp0 temp1 temp2)
		(if (< listSize 3)
			(return)
		)
		(for ((= temp0 0)) (< temp0 (- listSize 2)) ((++ temp0))
			(for ((= temp1 (+ temp0 1))) (< temp1 (- listSize 1)) ((++ temp1))
				(for ((= temp2 (+ temp1 1))) (< temp2 listSize) ((++ temp2))
					(switch param1
						(1
							(if
								(==
									(+
										[global610 temp0]
										[global610 temp1]
										[global610 temp2]
									)
									15
								)
								(self next: 1)
								(if (and aStarter (not temp0))
									(+= starterPoints 2)
								)
							)
						)
						(3
							(if
								(and
									(== [global600 temp0] [global600 temp1])
									(== [global600 temp1] [global600 temp2])
								)
								(= rankOfPairRoyal [global600 temp0])
								(self next: 3)
								(if (and aStarter (not temp0))
									(+= starterPoints 6)
								)
							)
						)
						(5
							(if
								(and
									(==
										(mod
											(+
												[global600 temp0]
												[global600 temp1]
												[global600 temp2]
											)
											3
										)
										0
									)
									(!= [global600 temp0] [global600 temp1])
									(!= [global600 temp0] [global600 temp2])
									(!= [global600 temp1] [global600 temp2])
								)
								(self
									order:
										[global600 temp0]
										[global600 temp1]
										[global600 temp2]
								)
								(if
									(and
										(== (+ [global625 0] 1) [global625 1])
										(== (+ [global625 1] 1) [global625 2])
									)
									(self next: 5)
									(if (and aStarter (not temp0))
										(+= starterPoints 3)
									)
								)
							)
						)
					)
				)
			)
		)
	)

	(method (cards4 param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (< listSize 4)
			(return)
		)
		(for ((= temp0 0)) (< temp0 (- listSize 3)) ((++ temp0))
			(for ((= temp1 (+ temp0 1))) (< temp1 (- listSize 2)) ((++ temp1))
				(for
					((= temp2 (+ temp1 1)))
					(< temp2 (- listSize 1))
					((++ temp2))
					
					(for ((= temp3 (+ temp2 1))) (< temp3 listSize) ((++ temp3))
						(switch param1
							(1
								(if
									(==
										(+
											[global610 temp0]
											[global610 temp1]
											[global610 temp2]
											[global610 temp3]
										)
										15
									)
									(self next: 1)
									(if (and aStarter (not temp0))
										(+= starterPoints 2)
									)
								)
							)
							(4
								(= temp4 0)
								(if
									(and
										aStarter
										(== [global600 1] [global600 2])
										(== [global600 2] [global600 3])
										(== [global600 3] [global600 4])
									)
									(= temp4 [global600 1])
								)
								(if
									(and
										(== [global600 temp0] [global600 temp1])
										(== [global600 temp1] [global600 temp2])
										(== [global600 temp2] [global600 temp3])
									)
									(if (== temp4 [global600 0])
										(return)
									else
										(self next: 4)
										(if (and aStarter (not temp0))
											(+= starterPoints 12)
										)
									)
								)
							)
							(6
								(if
									(==
										(mod
											(+
												[global600 temp0]
												[global600 temp1]
												[global600 temp2]
												[global600 temp3]
											)
											4
										)
										2
									)
									(self
										order:
											[global600 temp0]
											[global600 temp1]
											[global600 temp2]
											[global600 temp3]
									)
									(if
										(and
											(==
												(+ [global625 0] 1)
												[global625 1]
											)
											(==
												(+ [global625 1] 1)
												[global625 2]
											)
											(==
												(+ [global625 2] 1)
												[global625 3]
											)
										)
										(self next: 6)
										(if (and aStarter (not temp0))
											(+= starterPoints 4)
										)
									)
								)
							)
						)
					)
				)
			)
		)
	)

	(method (cards5 param1)
		(if (< listSize 5)
			(return)
		)
		(switch param1
			(1
				(if
					(==
						(+
							[global610 0]
							[global610 1]
							[global610 2]
							[global610 3]
							[global610 4]
						)
						15
					)
					(self next: 1)
					(+= starterPoints 2)
				)
			)
			(7
				(if
					(==
						(mod
							(+
								[global600 0]
								[global600 1]
								[global600 2]
								[global600 3]
								[global600 4]
							)
							5
						)
						0
					)
					(self
						order:
							[global600 0]
							[global600 1]
							[global600 2]
							[global600 3]
							[global600 4]
					)
					(if
						(and
							(== (+ [global625 0] 1) [global625 1])
							(== (+ [global625 1] 1) [global625 2])
							(== (+ [global625 2] 1) [global625 3])
							(== (+ [global625 3] 1) [global625 4])
						)
						(self next: 7)
						(+= starterPoints 5)
					)
				)
			)
		)
	)

	(method (fifteens)
		(self cards2: 1)
		(self cards3: 1)
		(self cards4: 1)
		(self cards5: 1)
	)

	(method (pairs)
		(self cards4: 4)
		(if (== [global615 numScores] 4)
			(return)
		)
		(self cards3: 3)
		(self cards2: 2)
	)

	(method (runs)
		(self cards5: 7)
		(if (== [global615 numScores] 7)
			(return)
		)
		(self cards4: 6)
		(if (== [global615 numScores] 6)
			(return)
		)
		(self cards3: 5)
	)
)

