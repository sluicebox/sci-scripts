;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 717)
(include sci.sh)
(use Main)
(use n709)
(use bidBoxWindow)
(use System)

(public
	weak2_tree 0
)

(instance weak2_tree of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 [temp14 5] temp19 temp20 temp21 temp22 temp23 temp24 temp25 [temp26 5])
		(for ((= temp11 0)) (< temp11 5) ((++ temp11))
			(= [temp26 temp11] 0)
			(= [temp14 temp11] 0)
		)
		(= temp0 (param1 partner:))
		(= temp4 (param1 hcp:))
		(= temp5 (param1 playingTricks:))
		(= temp25 (temp0 playingTricks:))
		(= temp6 (param1 singletons:))
		(= temp7 (param1 voids:))
		(= temp8 (param1 longSuit:))
		(= temp24 (temp0 longSuit:))
		(= temp9 (BidBox openingBidder:))
		(= temp10 (param1 bidsOpen:))
		(= [temp14 0] 0)
		(= [temp14 2] (param1 diamonds:))
		(= [temp14 1] (param1 clubs:))
		(= [temp14 3] (param1 hearts:))
		(= [temp14 4] (param1 spades:))
		(= temp19 [temp14 temp24])
		(= temp13 [temp14 temp8])
		(= temp22 (if (== temp9 param1) temp8 else temp24))
		(= [temp26 1] (if (or (== temp24 1) (param1 stops: 1)) 1))
		(= [temp26 2] (if (or (== temp24 2) (param1 stops: 2)) 1))
		(= [temp26 3] (if (or (== temp24 3) (param1 stops: 3)) 1))
		(= [temp26 4] (if (or (== temp24 4) (param1 stops: 4)) 1))
		(= temp3
			(-
				(param1 points:)
				(if (>= temp19 3)
					0
				else
					(- 3 temp19)
				)
			)
		)
		(= temp1 0)
		(cond
			((and (== temp9 temp0) (not temp10))
				(cond
					(
						(and
							(or
								(>= temp19 4)
								(and
									(== temp19 3)
									(param1 hasCard: temp24 3851)
								)
							)
							(or
								(and (!= temp24 1) (<= [temp14 1] 2))
								(and (!= temp24 2) (<= [temp14 2] 2))
								(and (!= temp24 3) (<= [temp14 3] 2))
								(and (!= temp24 4) (<= [temp14 4] 2))
							)
						)
						(cond
							((or (>= temp3 20) (>= temp5 14))
								(= temp1 761)
							)
							((and (>= temp3 17) (>= temp5 10) (== temp24 2))
								(= temp1 22)
							)
							(
								(or
									(and
										(>= temp24 3)
										(or (>= temp3 14) (>= temp5 10))
									)
									(and (>= temp19 5) (<= temp4 6))
								)
								(= temp1 (proc709_0 temp24 4))
							)
							((or (>= temp3 10) (and (>= temp3 7) (>= temp19 4)))
								(= temp1 (proc709_0 temp24 3))
							)
							(else
								(= temp1 0)
							)
						)
					)
					((>= temp19 2)
						(cond
							((>= temp3 22)
								(= temp1 10)
								(param1 forcing: 1)
								(= global439 1)
							)
							((>= temp4 17)
								(= temp1 10)
								(param1 forcing: 1)
								(= global439 1)
							)
							(
								(or
									(and
										(== temp24 2)
										(>= temp5 5)
										(>= temp3 18)
									)
									(and
										(>= temp24 3)
										(or (>= temp5 5) (>= temp3 15))
									)
								)
								(= temp1
									(proc709_0
										temp24
										(param1 findGameLevel: temp24)
									)
								)
							)
							((or (>= temp3 10) (and (>= temp3 7) (>= temp5 6)))
								(= temp1 (proc709_0 temp24 3))
							)
							(else
								(= temp1 0)
							)
						)
					)
					((or (>= temp3 24) (>= temp5 18))
						(= temp1 10)
						(param1 forcing: 1)
						(= global439 1)
					)
					((and (>= temp3 18) (not temp7) (== temp6 1))
						(= temp1 10)
						(param1 forcing: 1)
						(= global439 1)
					)
					(
						(or
							(>= [temp14 temp8] 7)
							(and
								(== [temp14 temp8] 6)
								(>= (param1 calcHonors: temp8 5) 3)
							)
						)
						(cond
							((or (>= temp5 18) (and (>= temp5 16) (>= temp8 3)))
								(= temp1
									(proc709_0
										temp8
										(param1 findGameLevel: temp8)
									)
								)
							)
							(
								(and
									(>= (param1 calcTricks: temp8) 11)
									(or
										(and
											(>=
												(= temp20
													(+
														[temp26 1]
														[temp26 2]
														[temp26 3]
														[temp26 4]
													)
												)
												3
											)
											(= temp21
												(or
													(>=
														(param1
															hasCard: temp8 3851
														)
														4
													)
													(and
														(>= [temp14 temp8] 7)
														(>=
															(param1
																hasCard:
																	temp8
																	3852
															)
															3
														)
													)
												)
											)
										)
										(== temp20 4)
									)
									(if (and temp21 (== temp20 4))
										(= temp1 15)
									else
										(= temp1 10)
										(param1 forcing: 1)
										(= global439 1)
									)
								))
							(else
								(= temp1
									(proc709_0 temp8 (param1 minLevel: temp8))
								)
								(proc709_5 param1 temp8 6 11)
							)
						)
					)
					((>= temp4 14)
						(= temp1 (proc709_0 temp24 3))
					)
					(else
						(= temp1 0)
					)
				)
			)
			(
				(and
					(== temp9 param1)
					(== temp10 1)
					(== ((proc709_6 2) bidNumber:) 10)
				)
				(if
					(or
						(and (!= temp8 1) (param1 hasCard: (= temp2 1) 3853))
						(and (!= temp8 2) (param1 hasCard: (= temp2 2) 3853))
						(and (!= temp8 3) (param1 hasCard: (= temp2 3) 3853))
						(and (!= temp8 4) (param1 hasCard: (= temp2 4) 3853))
					)
					(= temp1 (proc709_0 temp2 3))
					(param1 forcing: 1)
					(= global439 1)
					(proc709_5 param1 temp2 1 -1)
				else
					(= temp1 (proc709_0 temp8 3))
				)
			)
			(
				(and
					(== temp9 temp0)
					(== temp10 1)
					(== ((proc709_6 2) bidNumber:) 10)
				)
				(= temp23 (+ 1 (mod (- param2 1) 5)))
				(= temp20 (param1 findGameLevel: temp24))
				(cond
					((>= (+ temp5 temp25) 23)
						(if (< temp19 2)
							(= temp22 5)
						)
						(param1 agreedSuit: temp22)
						(temp0 agreedSuit: temp22)
						(= temp1 761)
					)
					((== temp23 temp24)
						(if (>= (+ temp5 temp25) (+ 12 temp20 temp20))
							(= temp1 (proc709_0 temp24 temp20))
						else
							(= temp1
								(proc709_0 temp24 (param1 minLevel: temp24))
							)
						)
					)
					(
						(and
							(or (== temp23 1) [temp26 1])
							(or (== temp23 2) [temp26 2])
							(or (== temp23 3) [temp26 3])
							(or (== temp23 4) [temp26 4])
						)
						(= temp1 15)
					)
					((>= (+ temp5 temp25) (+ 12 temp20 temp20))
						(= temp1 (proc709_0 temp24 temp20))
					)
					(else
						(= temp1 (proc709_0 temp24 (param1 minLevel: temp24)))
					)
				)
			)
		)
		(return temp1)
	)
)

