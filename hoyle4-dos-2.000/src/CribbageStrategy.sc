;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 570)
(include sci.sh)
(use Main)
(use Piles)
(use System)

(local
	[local0 14]
	[local14 5]
	[local19 14]
	[local33 5]
	[local38 14]
	[local52 5]
	[local57 5]
	[local62 5]
	[local67 3]
	[local70 4]
)

(class CribbageStrategy of Code
	(properties
		flushable 0
		flush 0
		flushEx 0
		handScore 0
		cribScore 0
		handNobs 0
		cribNobs 0
		myCrib 0
		ability 0
		cribRank1 0
		cribRank2 0
	)

	(method (setArrays param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4)
		(for ((= temp0 (= handNobs (= cribNobs 0)))) (< temp0 14) ((++ temp0))
			(= [local19 temp0] (= [local0 temp0] 0))
		)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(= [local33 temp0] (= [local14 temp0] 0))
		)
		(= temp1 (= temp2 (= temp0 0)))
		(while (<= temp0 5)
			(= temp4 ((param1 at: temp0) rank:))
			(= temp3 ((param1 at: temp0) suit:))
			(if (or (== temp0 param2) (== temp0 param3))
				(= [local67 temp2] temp4)
				(= [local70 temp2] (if (>= temp4 11) 10 else temp4))
				(++ [local19 temp4])
				(++ [local33 temp3])
				(if (== temp4 11)
					(+= cribNobs [local52 temp3])
				)
				(++ temp2)
			else
				(= [local57 temp1] temp4)
				(= [local62 temp1] (if (>= temp4 11) 10 else temp4))
				(++ [local0 temp4])
				(++ [local14 temp3])
				(if (== temp4 11)
					(+= handNobs [local52 temp3])
				)
				(++ temp1)
			)
			(++ temp0)
		)
		(= flush (if (and flushable (== [local14 flushable] 4)) 1 else 0))
		(= flushEx (if flush [local52 flushable] else 0))
	)

	(method (fastScore param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(= handScore (= cribScore 0))
		(= temp9 3)
		(= temp10 1)
		(if param1
			(++ temp9)
			(++ temp10)
			(++ [local0 param1])
			(++ [local19 param1])
			(= [local62 temp9]
				(if (> (= [local57 temp9] param1) 10) 10 else param1)
			)
			(= [local70 temp10]
				(if (> (= [local67 temp10] param1) 10) 10 else param1)
			)
		)
		(for ((= temp0 1)) (< temp0 14) ((++ temp0))
			(= temp1 [local0 temp0])
			(= temp2 [local19 temp0])
			(+= handScore (* temp1 (- temp1 1)))
			(+= cribScore (* temp2 (- temp2 1)))
		)
		(for ((= temp0 0)) (< temp0 temp9) ((++ temp0))
			(for ((= temp1 (+ temp0 1))) (<= temp1 temp9) ((++ temp1))
				(if (== (= temp4 (+ [local62 temp0] [local62 temp1])) 15)
					(+= handScore 2)
				)
				(if (and (< temp4 15) (!= temp1 temp9))
					(for ((= temp2 (+ temp1 1))) (<= temp2 temp9) ((++ temp2))
						(if (== (= temp5 (+ temp4 [local62 temp2])) 15)
							(+= handScore 2)
						)
						(if (and (< temp5 15) (!= temp2 temp9))
							(for
								((= temp3 (+ temp2 1)))
								(<= temp3 temp9)
								((++ temp3))
								
								(if (== (= temp6 (+ temp5 [local62 temp3])) 15)
									(+= handScore 2)
								)
								(if
									(and
										(!= temp3 temp9)
										(== (+ temp6 [local62 temp9]) 15)
									)
									(+= handScore 2)
								)
							)
						)
					)
				)
			)
		)
		(for ((= temp0 0)) (< temp0 temp10) ((++ temp0))
			(for ((= temp1 (+ temp0 1))) (<= temp1 temp10) ((++ temp1))
				(if (== (= temp4 (+ [local70 temp0] [local70 temp1])) 15)
					(+= cribScore 2)
				)
				(if (and (!= temp1 temp10) (== (+ temp4 [local70 temp10]) 15))
					(+= cribScore 2)
				)
			)
		)
		(= temp7 0)
		(= temp8 (= temp0 1))
		(while (< temp0 14)
			(cond
				((= temp1 [local0 temp0])
					(++ temp7)
					(*= temp8 temp1)
				)
				((>= temp7 3)
					(break)
				)
				(else
					(= temp7 0)
					(= temp8 1)
				)
			)
			(++ temp0)
		)
		(if (>= temp7 3)
			(+= handScore (* temp8 temp7))
		)
		(if param1
			(= temp0 [local67 0])
			(= temp1 [local67 1])
			(= temp2 [local67 2])
			(= temp3 (* (- temp1 temp0) (- temp2 temp1) (- temp0 temp2)))
			(if (== (Abs temp3) 2)
				(+= cribScore 3)
			)
		)
		(if flush
			(+= handScore 4)
		)
		(if param1
			(-- [local0 param1])
			(-- [local19 param1])
			(= [local62 temp9] (= [local57 temp9] 0))
			(= [local70 temp10] (= [local67 temp10] 0))
		)
	)

	(method (thinkCrib param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(proc0_1)
		(= ability global196)
		(= myCrib (if (== 1 ((Dealer dealer:) location:)) 1 else -1))
		(for ((= temp1 1)) (< temp1 14) ((++ temp1))
			(= [local38 temp1] 4)
		)
		(for ((= temp1 1)) (< temp1 5) ((++ temp1))
			(= [local52 temp1] 13)
		)
		(for ((= temp1 0)) (<= temp1 5) ((++ temp1))
			(-- [local38 ((param1 at: temp1) rank:)])
			(-- [local52 ((param1 at: temp1) suit:)])
		)
		(= temp6 -100)
		(= flushable 0)
		(for ((= temp1 1)) (< temp1 5) ((++ temp1))
			(if (<= [local52 temp1] 9)
				(= flushable temp1)
				(break)
			)
		)
		(for ((= temp1 0)) (<= temp1 4) ((++ temp1))
			(for ((= temp2 (+ temp1 1))) (<= temp2 5) ((++ temp2))
				(self setArrays: param1 temp1 temp2)
				(if (== ability 0)
					(self fastScore: 0)
					(= temp3 (+ handScore (* myCrib cribScore)))
				else
					(= temp4 (= temp3 0))
					(for ((= temp0 1)) (<= temp0 13) ((++ temp0))
						(self fastScore: temp0)
						(= temp5 [local38 temp0])
						(+= temp3 (* temp5 handScore))
						(+= temp4 (* temp5 cribScore))
					)
					(+= temp3 handNobs)
					(+= temp4 cribNobs)
					(= temp3 (+ (+= temp3 flushEx) (* myCrib temp4)))
				)
				(if (== ability 2)
					(+=
						temp3
						(+
							(* (Min 2 [local0 1]) 17)
							(* (Min 2 [local0 2]) 16)
							(* (Min 2 [local0 3]) 15)
							(* (Min 2 [local0 4]) 14)
						)
					)
				)
				(if (> temp3 temp6)
					(= temp6 temp3)
					(= temp7 temp1)
					(= temp8 temp2)
				)
			)
		)
		(= global483 (param1 at: temp7))
		(= global484 (param1 at: temp8))
		(= cribRank1 ((param1 at: temp7) rank:))
		(= cribRank2 ((param1 at: temp8) rank:))
	)

	(method (think param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23)
		(= ability global196)
		(= temp16 (param1 opponentMin:))
		(for ((= temp0 0)) (<= temp0 13) ((++ temp0))
			(= [local0 temp0] 0)
			(= [local38 temp0] 4)
		)
		(= temp12 (- (gTrick size:) 1))
		(-- [local38 cribRank1])
		(-- [local38 cribRank2])
		(-- [local38 ((global419 topCard:) rank:)])
		(if (!= temp12 -1)
			(for ((= temp0 0)) (<= temp0 temp12) ((++ temp0))
				(= [local19 temp0] ((gTrick at: temp0) rank:))
				(-- [local38 [local19 temp0]])
			)
		)
		(= temp3 (= temp0 0))
		(while (< temp0 (param1 size:))
			(= temp2 (param1 at: temp0))
			(-- [local38 (= temp4 (temp2 rank:))])
			(++ [local0 temp4])
			(= [local57 temp0] temp4)
			(= [local62 temp0] (if (>= temp4 11) 10 else temp4))
			(temp2 valid: (<= (+ param2 [local62 temp0]) 31))
			(if (temp2 valid:)
				(++ temp3)
				(= temp1 temp2)
			)
			(++ temp0)
		)
		(if (not temp3)
			(return 0)
		)
		(if (== temp3 1)
			(return temp1)
		)
		(= temp6 (= temp8 (= temp7 (= temp2 0))))
		(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
			(= temp2 (param1 at: temp0))
			(= temp10 0)
			(if
				(and
					((param1 at: temp0) valid:)
					(= temp10 (gTrick testPoints: temp2))
				)
				(cond
					((> temp10 temp7)
						(= temp8 1)
						(= temp7 temp10)
						(= temp11 temp2)
					)
					((== temp10 temp7)
						(++ temp8)
					)
				)
				(if (not temp6)
					(= temp9 [local57 temp0])
				)
				(if (or (!= temp6 1) (!= [local57 temp0] temp9))
					(++ temp6)
				)
			)
			(= [local14 temp0] temp10)
		)
		(if (== temp6 1)
			(return temp11)
		)
		(if (>= temp6 2)
			(if
				(or
					global492
					(>= (+ param2 temp16) 30)
					(== ((global117 at: 0) size:) 0)
				)
				(if (>= temp7 6)
					(return temp11)
				)
				(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
					(= temp2 (param1 at: temp0))
					(if
						(and
							(<= (+ param2 (* 2 [local62 temp0])) 31)
							(>= [local0 [local57 temp0]] 2)
							global493
							(== [local57 temp0] [local19 temp12])
						)
						(return temp2)
					)
				)
				(return temp11)
			else
				(if (== temp8 1)
					(return temp11)
				)
				(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
					(= temp2 (param1 at: temp0))
					(if (== temp7 [local14 temp0])
						(= temp4 [local0 (temp2 rank:)])
						(if (== temp8 temp4)
							(if (>= temp4 2)
								(return temp11)
							else
								(break)
							)
						else
							(break)
						)
					)
				)
				(= temp13 (= temp14 0))
				(= temp20 (Card new:))
				(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
					(= temp2 (param1 at: temp0))
					(= [local14 temp0]
						(if (== temp7 [local14 temp0]) 0 else -2000)
					)
					(if (not [local14 temp0])
						(if
							(>=
								(= temp15 (- 31 (+ global493 [local62 temp0])))
								10
							)
							(= temp15 13)
						)
						(if (<= temp16 temp15)
							(cond
								(
									(or
										(== [local57 temp0] temp13)
										(== [local57 temp0] temp14)
									)
									(= [local14 temp0] -2000)
								)
								(temp13
									(= temp14 [local57 temp0])
								)
								(else
									(= temp13 [local57 temp0])
								)
							)
							(if (!= [local14 temp0] -2000)
								(for
									((= temp4 temp16))
									(<= temp4 temp15)
									((++ temp4))
									
									(= temp5 (if (>= temp4 11) 10 else temp4))
									(temp20 rank: temp4)
									(if
										(= temp10
											(gTrick testPoints: temp2 temp20)
										)
										(-=
											[local14 temp0]
											(* temp10 [local38 temp4])
										)
									)
									(= temp18 0)
									(for
										((= temp17 0))
										(< temp17 (param1 size:))
										((++ temp17))
										
										(if
											(and
												(!= temp0 temp17)
												(<=
													(+
														param2
														[local62 temp0]
														temp5
														[local62 temp17]
													)
													31
												)
											)
											(= temp19 (param1 at: temp17))
											(if
												(>
													(= temp10
														(gTrick
															testPoints:
																temp2
																temp20
																temp19
														)
													)
													temp18
												)
												(= temp18 temp10)
											)
										)
									)
									(if temp18
										(+=
											[local14 temp0]
											(* temp18 [local38 temp4])
										)
									)
								)
							)
						else
							(for
								((= temp17 0))
								(< temp17 (param1 size:))
								((++ temp17))
								
								(if
									(and
										(!= temp0 temp17)
										(<=
											(+
												param2
												[local62 temp0]
												[local62 temp17]
											)
											31
										)
									)
									(= temp19 (param1 at: temp17))
									(= temp10
										(gTrick testPoints: temp2 temp19)
									)
									(+= [local14 temp0] temp10)
								)
							)
						)
					)
				)
				(temp20 dispose:)
				(= temp21 (= temp11 0))
				(= temp0 0)
				(= temp7 -2000)
				(while (< temp0 (param1 size:))
					(if (> [local14 temp0] temp7)
						(= temp21 temp11)
						(= temp7 [local14 temp0])
						(= temp11 (param1 at: temp0))
					)
					(++ temp0)
				)
				(if (and (== ability 0) (Random 0 1) temp21)
					(= temp11 temp21)
				)
				(return temp11)
			)
		)
		(= temp20 (Card new:))
		(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
			(= [local14 temp0] -200)
		)
		(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
			(= temp2 (param1 at: temp0))
			(= temp22 (+ param2 [local62 temp0]))
			(if (temp2 valid:)
				(= [local14 temp0] 0)
				(= temp4 [local57 temp0])
				(if
					(and
						(not global492)
						(!= ((global117 at: 0) size:) 0)
						(<= (+ temp22 temp16) 31)
					)
					(if (!= ability 0)
						(if (== temp4 1)
							(-= [local14 temp0] 6)
						)
						(if (== temp4 2)
							(-= [local14 temp0] 4)
						)
						(if
							(and
								(>= ((global117 at: 0) size:) 2)
								(>= temp22 17)
								(==
									(- [local0 5] (== temp4 5))
									(- (param1 size:) 1)
								)
							)
							(-= [local14 temp0] 3)
						)
						(if (and (== temp4 11) (<= temp22 21) (== myCrib 1))
							(-= [local14 temp0] 1)
						)
						(if (> temp22 21)
							(= temp1 (- 31 temp22))
							(= temp17 (if (== temp4 temp1) 1 else 0))
							(if
								(or
									(> (- [local0 temp1] temp17) 0)
									(and
										(>= [local0 temp4] 2)
										(<= (+ temp22 [local62 temp0]) 31)
									)
								)
								(+= [local14 temp0] 1)
							)
						)
					)
					(= temp23 (+ temp22 10))
					(if
						(and
							(> 31 temp23 20)
							(>
								(= temp1
									(if (== (= temp17 (- 31 temp23)) 10)
										(+
											[local0 10]
											[local0 11]
											[local0 12]
											[local0 13]
										)
									else
										[local0 temp17]
									)
								)
								(== temp17 [local62 temp0])
							)
						)
						(+= [local14 temp0] 2)
					)
					(if
						(and
							(> 15 temp23 10)
							(-
								[local0 (= temp17 (- 15 temp23))]
								(== temp17 [local57 temp0])
							)
						)
						(+= [local14 temp0] 2)
					)
					(cond
						((!= ability 0)
							(if
								(or
									(and
										(>= temp22 21)
										(<= temp16 (- 31 temp22))
									)
									(and
										(> 15 temp22 4)
										(<= temp16 (- 15 temp22))
									)
								)
								(-=
									[local14 temp0]
									(cond
										((or (== temp22 5) (== temp22 21)) 12)
										((> temp22 21) 2)
										(else 4)
									)
								)
								(if
									(or
										(==
											(= temp17
												(+ temp22 [local62 temp0])
											)
											15
										)
										(== temp17 31)
									)
									(-= [local14 temp0] 8)
								)
								(if (< temp22 15)
									(temp20 rank: (- 15 temp22))
									(if
										(>
											(= temp17
												(gTrick
													testPoints: temp2 temp20
												)
											)
											4
										)
										(-= [local14 temp0] (* 2 (- temp17 2)))
									)
									(= temp10 (= temp7 0))
									(for
										((= temp17 0))
										(< temp17 (param1 size:))
										((++ temp17))
										
										(if (!= temp0 temp17)
											(= temp19 (param1 at: temp17))
											(if
												(>
													(= temp10
														(gTrick
															testPoints:
																temp2
																temp20
																temp19
														)
													)
													temp7
												)
												(= temp7 temp10)
											)
										)
									)
									(+= [local14 temp0] (* 2 temp7))
								)
								(if (> temp22 21)
									(temp20 rank: (- 31 temp22))
									(if
										(>
											(= temp17
												(gTrick
													testPoints: temp2 temp20
												)
											)
											4
										)
										(-= [local14 temp0] (* 4 (- temp17 2)))
									)
								)
								(if (== temp22 21)
									(= temp10 (= temp7 0))
									(for
										((= temp17 10))
										(<= temp17 13)
										((++ temp17))
										
										(temp20 rank: temp17)
										(if
											(>
												(= temp10
													(gTrick
														testPoints: temp2 temp20
													)
												)
												temp7
											)
											(= temp7 temp10)
										)
									)
									(if (> temp7 4)
										(-= [local14 temp0] (- temp7 2))
									)
								)
							)
						)
						((and (== temp4 5) (== param2 0))
							(-= [local14 temp0] 5)
						)
					)
					(if (<= (= temp17 (+ temp22 [local62 temp0])) 31)
						(-=
							[local14 temp0]
							(= temp18 [local38 [local57 temp0]])
						)
						(if
							(and
								(> [local0 temp0] 1)
								(<= (+ temp17 [local62 temp0]) 31)
							)
							(+= [local14 temp0] 2)
						)
						(if (or (== temp17 5) (== temp17 21))
							(= temp1
								(+
									[local0 10]
									[local0 11]
									[local0 12]
									[local0 13]
								)
							)
							(if (== [local62 temp0] 10)
								(-- temp1)
							)
						)
						(if
							(and
								(> temp17 5)
								(< temp17 15)
								(-
									[local0 (= temp1 (- 15 temp17))]
									(== [local57 temp0] temp1)
								)
							)
							(+= [local14 temp0] temp18)
						)
						(if
							(and
								(> temp17 21)
								(!= temp17 31)
								(-
									[local0 (= temp1 (- 31 temp17))]
									(== [local57 temp0] temp1)
								)
							)
							(+= [local14 temp0] temp18)
						)
					)
				else
					(= temp10 (= temp7 0))
					(for ((= temp17 0)) (< temp17 (param1 size:)) ((++ temp17))
						(if
							(and
								(!= temp0 temp17)
								(<= (+ temp22 [local62 temp17]) 31)
							)
							(temp20 rank: [local57 temp17])
							(if
								(>
									(= temp10
										(gTrick testPoints: temp2 temp20)
									)
									temp7
								)
								(= temp7 temp10)
							)
						)
					)
					(+= [local14 temp0] temp7)
				)
			)
		)
		(temp20 dispose:)
		(= temp21 (= temp11 0))
		(= temp0 0)
		(= temp7 -2000)
		(while (< temp0 (param1 size:))
			(if (and ((param1 at: temp0) valid:) (>= [local14 temp0] temp7))
				(= temp21 temp11)
				(= temp7 [local14 temp0])
				(= temp11 (param1 at: temp0))
			)
			(++ temp0)
		)
		(if (and (== ability 0) (Random 0 1) temp21)
			(= temp11 temp21)
		)
		(return temp11)
	)
)

