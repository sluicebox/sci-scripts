;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 208)
(include sci.sh)
(use Main)
(use System)

(public
	countCombos 0
)

(class CountCombinations of Obj
	(properties
		listSize 0
		numScores 0
		cribHand 0
		rankOfPairRoyal 0
		starterPoints 0
		style 0
		aStarter 0
		total 0
		theList 0
	)

	(method (setStyle param1)
		(= style param1)
	)

	(method (doit)
		(= starterPoints (= total 0))
		(self set: &rest fifteens: runs: pairs: flushes: nobs:)
		(return total)
	)

	(method (set param1 param2 &tmp temp0)
		(= theList param1)
		(= aStarter (>= argc 2))
		(= listSize (+ (param1 size:) aStarter))
		(if aStarter
			(if (IsObject param2)
				(= [global146 0] (param2 cardRank:))
				(= [global160 0] (param2 cardSuit:))
			else
				(= [global146 0] param2)
				(= [global160 0] -1)
			)
			(= [global151 0] (if (< [global146 0] 11) [global146 0] else 10))
		)
		(for
			((= temp0 aStarter))
			(< temp0 (+ (param1 size:) aStarter))
			((++ temp0))
			
			(= [global146 temp0] ((param1 at: (- temp0 aStarter)) cardRank:))
			(= [global160 temp0] ((param1 at: (- temp0 aStarter)) cardSuit:))
			(= [global151 temp0]
				(if (< [global146 temp0] 11) [global146 temp0] else 10)
			)
		)
		(= rankOfPairRoyal (= numScores 0))
		(= cribHand (== argc 3))
	)

	(method (next param1 param2 &tmp temp0 temp1)
		(++ numScores)
		(= [global330 numScores] param1)
		(+=
			total
			(switch param1
				(1000 2)
				(1006 2)
				(1007 6)
				(1008 12)
				(1009 3)
				(1010 4)
				(1011 5)
				(1016 1)
				(1014 4)
				(1015 5)
				(else 0)
			)
		)
		(if (> (gCardRoom state:) 10)
			(= temp1 0)
			(= temp0 (* (- numScores 1) 5))
			(while (< temp1 5)
				(= [global449 (+ temp0 temp1)]
					(if (< temp1 (- argc 1))
						(if (not [param2 temp1])
							(gDeck upCardView:)
						else
							(theList at: (- [param2 temp1] 1))
						)
					else
						0
					)
				)
				(++ temp1)
			)
		)
	)

	(method (order param1 &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 (- argc 1)) ((++ temp0))
			(if (> [param1 temp0] [param1 (+ temp0 1)])
				(= temp1 [param1 (+ temp0 1)])
				(= [param1 (+ temp0 1)] [param1 temp0])
				(= [param1 temp0] temp1)
			)
			(= [global341 temp0] [param1 temp0])
		)
		(= [global341 temp0] [param1 temp0])
	)

	(method (nobs &tmp temp0)
		(if (== listSize 5)
			(for ((= temp0 1)) (< temp0 5) ((++ temp0))
				(if
					(and
						(== [global146 temp0] 11)
						(== [global160 temp0] [global160 0])
					)
					(self next: 1016 temp0 0)
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
							(== [global160 1] [global160 2])
							(== [global160 2] [global160 3])
							(== [global160 3] [global160 4])
						)
						(cond
							((== [global160 0] [global160 1])
								(self next: 1015 0 1 2 3 4)
							)
							((not cribHand)
								(self next: 1014 1 2 3 4)
							)
						)
					)
				)
				(
					(and
						(== [global160 0] [global160 1])
						(== [global160 1] [global160 2])
						(== [global160 2] [global160 3])
						(not cribHand)
					)
					(self next: 1014 1 2 3 4)
				)
			)
		)
	)

	(method (cards2 param1 &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 (- listSize 1)) ((++ temp0))
			(if (and temp0 (!= style 0))
				(return)
			)
			(for ((= temp1 (+ temp0 1))) (< temp1 listSize) ((++ temp1))
				(switch param1
					(1000
						(if (== (+ [global151 temp0] [global151 temp1]) 15)
							(self next: 1000 temp0 temp1)
							(if (and aStarter (not temp0))
								(+= starterPoints 2)
							)
						)
					)
					(1006
						(if
							(and
								(== [global146 temp0] [global146 temp1])
								(!= rankOfPairRoyal [global146 temp0])
							)
							(self next: 1006 temp0 temp1)
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
		(for ((= temp0 0)) (< temp0 (- listSize 2)) ((++ temp0))
			(if (and temp0 (!= style 0))
				(return)
			)
			(for ((= temp1 (+ temp0 1))) (< temp1 (- listSize 1)) ((++ temp1))
				(for ((= temp2 (+ temp1 1))) (< temp2 listSize) ((++ temp2))
					(switch param1
						(1000
							(if
								(==
									(+
										[global151 temp0]
										[global151 temp1]
										[global151 temp2]
									)
									15
								)
								(self next: 1000 temp0 temp1 temp2)
								(if (and aStarter (not temp0))
									(+= starterPoints 2)
								)
							)
						)
						(1007
							(if
								(and
									(== [global146 temp0] [global146 temp1])
									(== [global146 temp1] [global146 temp2])
								)
								(= rankOfPairRoyal [global146 temp0])
								(self next: 1007 temp0 temp1 temp2)
								(if (and aStarter (not temp0))
									(+= starterPoints 6)
								)
							)
						)
						(1009
							(if
								(and
									(==
										(mod
											(+
												[global146 temp0]
												[global146 temp1]
												[global146 temp2]
											)
											3
										)
										0
									)
									(!= [global146 temp0] [global146 temp1])
									(!= [global146 temp0] [global146 temp2])
									(!= [global146 temp1] [global146 temp2])
								)
								(self
									order:
										[global146 temp0]
										[global146 temp1]
										[global146 temp2]
								)
								(if
									(and
										(== (+ [global341 0] 1) [global341 1])
										(== (+ [global341 1] 1) [global341 2])
									)
									(self next: 1009 temp0 temp1 temp2)
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
			(if (and temp0 (!= style 0))
				(return)
			)
			(for ((= temp1 (+ temp0 1))) (< temp1 (- listSize 2)) ((++ temp1))
				(for
					((= temp2 (+ temp1 1)))
					(< temp2 (- listSize 1))
					((++ temp2))
					
					(for ((= temp3 (+ temp2 1))) (< temp3 listSize) ((++ temp3))
						(switch param1
							(1000
								(if
									(==
										(+
											[global151 temp0]
											[global151 temp1]
											[global151 temp2]
											[global151 temp3]
										)
										15
									)
									(self next: 1000 temp0 temp1 temp2 temp3)
									(if (and aStarter (not temp0))
										(+= starterPoints 2)
									)
								)
							)
							(1008
								(= temp4 0)
								(if
									(and
										aStarter
										(== [global146 1] [global146 2])
										(== [global146 2] [global146 3])
										(== [global146 3] [global146 4])
									)
									(= temp4 [global146 1])
								)
								(if
									(and
										(== [global146 temp0] [global146 temp1])
										(== [global146 temp1] [global146 temp2])
										(== [global146 temp2] [global146 temp3])
									)
									(if (== temp4 [global146 0])
										(return)
									else
										(self
											next: 1008 temp0 temp1 temp2 temp3
										)
										(if (and aStarter (not temp0))
											(+= starterPoints 12)
										)
									)
								)
							)
							(1010
								(if
									(==
										(mod
											(+
												[global146 temp0]
												[global146 temp1]
												[global146 temp2]
												[global146 temp3]
											)
											4
										)
										2
									)
									(self
										order:
											[global146 temp0]
											[global146 temp1]
											[global146 temp2]
											[global146 temp3]
									)
									(if
										(and
											(==
												(+ [global341 0] 1)
												[global341 1]
											)
											(==
												(+ [global341 1] 1)
												[global341 2]
											)
											(==
												(+ [global341 2] 1)
												[global341 3]
											)
										)
										(self
											next: 1010 temp0 temp1 temp2 temp3
										)
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
			(1000
				(if
					(==
						(+
							[global151 0]
							[global151 1]
							[global151 2]
							[global151 3]
							[global151 4]
						)
						15
					)
					(self next: 1000 0 1 2 3 4)
					(+= starterPoints 2)
				)
			)
			(1011
				(if
					(==
						(mod
							(+
								[global146 0]
								[global146 1]
								[global146 2]
								[global146 3]
								[global146 4]
							)
							5
						)
						0
					)
					(self
						order:
							[global146 0]
							[global146 1]
							[global146 2]
							[global146 3]
							[global146 4]
					)
					(if
						(and
							(== (+ [global341 0] 1) [global341 1])
							(== (+ [global341 1] 1) [global341 2])
							(== (+ [global341 2] 1) [global341 3])
							(== (+ [global341 3] 1) [global341 4])
						)
						(self next: 1011 0 1 2 3 4)
						(+= starterPoints 5)
					)
				)
			)
		)
	)

	(method (fifteens)
		(self cards2: 1000)
		(self cards3: 1000)
		(self cards4: 1000)
		(self cards5: 1000)
	)

	(method (pairs &tmp temp0)
		(self cards4: 1008)
		(if (== [global330 numScores] 1008)
			(return)
		)
		(self cards3: 1007)
		(self cards2: 1006)
	)

	(method (runs &tmp temp0)
		(self cards5: 1011)
		(if (== [global330 numScores] 1011)
			(return)
		)
		(self cards4: 1010)
		(if (== [global330 numScores] 1010)
			(return)
		)
		(self cards3: 1009)
	)
)

(instance countCombos of CountCombinations
	(properties)
)

