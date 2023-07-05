;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 213)
(include sci.sh)
(use Main)
(use C)

(public
	proc213_0 0
)

(procedure (proc213_0 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24 temp25 temp26)
	(= temp25 (param1 cardList:))
	(= temp6 (global390 count:))
	(param1 clearRatings:)
	(for
		((= temp0 (= temp4 (= temp5 (= temp8 (= temp10 (= temp9 0)))))))
		(< temp0 (temp25 size:))
		((++ temp0))
		
		(= temp9 (temp25 at: temp0))
		(if (<= (+ temp6 (param1 value: temp9)) 31)
			(temp9 rating: 1)
			(if (= temp7 (global390 testPoints: temp9))
				(cond
					((> temp7 temp8)
						(= temp10 1)
						(= temp8 temp7)
						(= temp5 temp9)
					)
					((== temp7 temp8)
						(++ temp10)
					)
				)
				(if (not temp4)
					(= temp19 (temp9 cardRank:))
				)
				(if (== temp4 1)
					(if (!= (temp9 cardRank:) temp19)
						(++ temp4)
						(temp9 rating: temp7)
					)
				else
					(temp9 rating: temp7)
					(++ temp4)
				)
			)
		)
	)
	(if (== temp4 1)
		(return temp5)
	)
	(param1 setRanks: temp25)
	(if (>= temp4 2)
		(if
			(or
				(not ((gPlayer0 cardList:) size:))
				(== (global390 playerWhoGaveGo:) gPlayer0)
				(> (+ temp6 (param1 opponentLowest:)) 31)
			)
			(if (>= temp8 6)
				(return temp5)
			)
			(for ((= temp0 0)) (< temp0 (temp25 size:)) ((++ temp0))
				(= temp9 (temp25 at: temp0))
				(if
					(and
						(<= (+ temp6 (* 2 (temp9 cardRank:))) 31)
						(>= [global390 (temp9 cardRank:)] 2)
						(or
							(== (temp9 points1:) 1006)
							(== (temp9 points2:) 1006)
						)
					)
					(return temp9)
				)
			)
			(return temp5)
		else
			(if (== temp10 1)
				(return temp5)
			)
			(for ((= temp0 0)) (< temp0 (temp25 size:)) ((++ temp0))
				(= temp9 (temp25 at: temp0))
				(if (temp9 rating:)
					(if
						(or
							(and
								(== temp4 2)
								(== [global390 (temp9 cardRank:)] 2)
							)
							(and
								(== temp4 3)
								(== [global390 (temp9 cardRank:)] 3)
							)
							(and
								(== temp4 4)
								(== [global390 (temp9 cardRank:)] 4)
							)
						)
						(return temp5)
					else
						(break)
					)
				)
			)
			(= temp14 (= temp15 0))
			(= temp13 (Clone C))
			(for ((= temp0 0)) (< temp0 (temp25 size:)) ((++ temp0))
				(= temp9 (temp25 at: temp0))
				(= temp23 (param1 value: temp9))
				(temp9 rating: (if (== (temp9 rating:) temp8) 0 else -200))
				(if (not (temp9 rating:))
					(if (<= (+ temp6 temp23 (param1 opponentLowest:)) 31)
						(cond
							(
								(or
									(== (temp9 cardRank:) temp14)
									(== (temp9 cardRank:) temp15)
								)
								(temp9 rating: -200)
							)
							(temp14
								(= temp15 (temp9 cardRank:))
							)
							(else
								(= temp14 (temp9 cardRank:))
							)
						)
						(if (!= (temp9 rating:) -200)
							(global390 add: temp9)
							(for
								((= temp2 (param1 opponentLowest:)))
								(< temp2 14)
								((++ temp2))
								
								(if (<= (+ (global390 count:) temp23) 31)
									(temp13 cardRank: temp2)
									(if (= temp7 (global390 testPoints: temp13))
										(temp9
											rating:
												(-
													(temp9 rating:)
													(*
														(-
															4
															(+
																(-
																	[global390
																		temp2
																	]
																	1
																)
																(global390
																	howMany:
																		temp2
																)
																(==
																	((gDeck
																			upCardView:
																		)
																		cardRank:
																	)
																	temp2
																)
															)
														)
														temp7
													)
												)
										)
										(global390 add: temp13)
										(for
											((= temp3 0))
											(< temp3 (temp25 size:))
											((++ temp3))
											
											(if
												(and
													(!= temp0 temp3)
													(<=
														(+
															temp6
															temp23
															temp2
															(param1
																value:
																	(temp25
																		at:
																			temp3
																	)
															)
														)
														31
													)
													(= temp7
														(global390
															testPoints:
																(temp25
																	at: temp3
																)
														)
													)
												)
												(temp9
													rating:
														(+
															(temp9 rating:)
															(* 4 temp7)
														)
												)
											)
										)
										(global390 delete: temp13)
									)
								)
							)
							(global390 delete: temp9)
						)
					else
						(global390 add: temp9)
						(for ((= temp3 0)) (< temp3 (temp25 size:)) ((++ temp3))
							(if
								(and
									(!= temp0 temp3)
									(<=
										(+
											temp6
											temp23
											(param1 value: (temp25 at: temp3))
										)
										31
									)
									(= temp7
										(global390
											testPoints: (temp25 at: temp3)
										)
									)
								)
								(temp9 rating: (+ (temp9 rating:) (* 4 temp7)))
							)
						)
						(global390 delete: temp9)
					)
				)
			)
			(DisposeClone temp13)
			(= temp26 0)
			(= temp0 (= temp5 0))
			(= temp8 -200)
			(while (< temp0 (temp25 size:))
				(if (> ((= temp9 (temp25 at: temp0)) rating:) temp8)
					(= temp26 temp5)
					(= temp8 (temp9 rating:))
					(= temp5 temp9)
				)
				(temp9 rating: 0)
				(++ temp0)
			)
			(if
				(and
					(== global775 0)
					temp26
					(== (Random 0) 1)
					(> (temp26 rating:) 0)
				)
				(= temp5 temp26)
			)
			(return temp5)
		)
	else
		(param1 clearRatings: -200)
		(= temp13 (Clone C))
		(for ((= temp0 0)) (< temp0 (temp25 size:)) ((++ temp0))
			(= temp23 (param1 value: (= temp9 (temp25 at: temp0))))
			(if (< (= temp12 (+ (global390 count:) temp23)) 31)
				(temp9 rating: 0)
				(if
					(and
						((gPlayer0 cardList:) size:)
						(!= (global390 playerWhoGaveGo:) gPlayer0)
						(<= (+ temp12 (param1 opponentLowest:)) 31)
					)
					(if (!= global775 0)
						(if (== (temp9 cardRank:) 1)
							(temp9 rating: -6)
						)
						(if (== (temp9 cardRank:) 2)
							(temp9 rating: -4)
						)
						(if
							(and
								(==
									(- [global390 5] (== (temp9 cardRank:) 5))
									(- (temp25 size:) 1)
								)
								(>= temp12 17)
								(>= ((gPlayer0 cardList:) size:) 2)
							)
							(temp9 rating: (+ (temp9 rating:) -3))
						)
						(if (and (== (temp9 cardRank:) 11) (<= temp12 21))
							(temp9 rating: (+ (temp9 rating:) -1))
						)
						(if
							(and
								(> temp12 21)
								(or
									[global390 (- 31 temp12)]
									(and
										(>= [global390 (temp9 cardRank:)] 2)
										(<= (+ temp12 temp23) 31)
									)
								)
							)
							(temp9 rating: (+ (temp9 rating:) 1))
						)
					)
					(= temp20 (+ temp12 10))
					(if (> 31 temp20 20)
						(= temp16 (== (= temp22 (- 31 temp20)) temp23))
						(if
							(or
								(- [global390 temp22] temp16)
								(and
									(== temp22 10)
									(or
										(- [global390 10] temp16)
										(- [global390 11] temp16)
										(- [global390 12] temp16)
										(- [global390 13] temp16)
									)
								)
							)
							(temp9 rating: (+ (temp9 rating:) 2))
						)
					)
					(if
						(and
							(> 15 temp20 10)
							(-
								[global390 (= temp22 (- 15 temp20))]
								(== temp22 temp23)
							)
						)
						(temp9 rating: (+ (temp9 rating:) 2))
					)
					(if
						(and
							(!= global775 0)
							(or
								(and
									(>= temp12 21)
									(<= (param1 opponentLowest:) (- 31 temp12))
								)
								(and
									(>= temp12 5)
									(< temp12 15)
									(<= (param1 opponentLowest:) (- 15 temp12))
								)
							)
						)
						(temp9
							rating:
								(+
									(temp9 rating:)
									(cond
										((or (== temp12 5) (== temp12 21)) -12)
										((> temp12 20) -2)
										(else -4)
									)
								)
						)
						(if
							(or
								(== (+ temp12 temp23) 15)
								(== (+ temp12 temp23) 31)
							)
							(temp9 rating: (- (temp9 rating:) 8))
						)
						(if (< temp12 21)
							(global390 add: temp9)
							(temp13 cardRank: (- 15 temp12))
							(global390 add: temp13 points2: 0)
							(= temp7 (global390 checkRuns:))
							(global390 delete: temp13)
							(if (> temp7 3)
								(temp9 rating: (- (temp9 rating:) (* 4 temp7)))
							)
							(global390 delete: temp9)
						)
						(if (> 15 temp12 5)
							(global390 add: temp9 add: temp13)
							(temp13 cardRank: (- 15 temp12))
							(for
								((= temp3 (= temp8 0)))
								(< temp3 (temp25 size:))
								((++ temp3))
								
								(if
									(and
										(!= temp0 temp3)
										(>
											(= temp7
												(global390
													testPoints:
														(temp25 at: temp3)
												)
											)
											temp8
										)
									)
									(= temp8 temp7)
								)
							)
							(temp9 rating: (+ (temp9 rating:) (* 4 temp8)))
							(global390 delete: temp13 delete: temp9)
						)
					)
					(if
						(and
							(<= (param1 opponentLowest:) (- 31 temp12))
							(<= (+ temp12 temp23) 31)
						)
						(= temp4
							(+
								(= temp4
									(+
										(= temp4 [global390 (temp9 cardRank:)])
										(==
											((gDeck upCardView:) cardRank:)
											(temp9 cardRank:)
										)
									)
								)
								(global390 howMany: (temp9 cardRank:))
							)
						)
						(= temp4 (- 4 temp4))
						(temp9 rating: (- (temp9 rating:) temp4))
						(if
							(and
								(<= (+ temp12 (* 2 temp23)) 31)
								(>= [global390 temp23] 2)
							)
							(temp9 rating: (+ (temp9 rating:) 2))
						)
						(if
							(and
								(or
									(== (= temp1 (+ temp12 temp23)) 5)
									(== temp1 21)
								)
								(or
									[global390 10]
									[global390 11]
									[global390 12]
									[global390 13]
								)
							)
							(temp9 rating: (+ (temp9 rating:) temp4))
						)
						(if
							(and
								(> temp1 5)
								(< temp1 15)
								(or
									(>= [global390 (- 15 temp1)] 2)
									(and
										[global390 (- 15 temp1)]
										(!= temp23 (- 15 temp1))
									)
								)
							)
							(temp9 rating: (+ (temp9 rating:) temp4))
						)
						(if
							(and
								(> temp1 21)
								(or
									(>= [global390 (- 31 temp1)] 2)
									(and
										[global390 (- 31 temp1)]
										(!= temp23 (- 31 temp1))
									)
								)
							)
							(temp9 rating: (+ (temp9 rating:) temp4))
						)
					)
					(if (== global775 2)
						(global390 add: temp9)
						(= temp2 (param1 opponentLowest:))
						(= temp17 (= temp18 (= temp8 0)))
						(while (< temp2 14)
							(if (param1 conditionsOK: temp12 temp2)
								(temp13 cardRank: temp2)
								(global390 add: temp13 points2: 0)
								(if (= temp7 (global390 checkRuns:))
									(++ temp17)
									(if (> temp7 temp8)
										(= temp8 temp7)
									)
									(for
										((= temp3 0))
										(< temp3 (temp25 size:))
										((++ temp3))
										
										(= temp24 (temp25 at: temp3))
										(if
											(and
												(!= temp0 temp3)
												(<=
													(+
														(global390 count:)
														(param1 value: temp24)
													)
													31
												)
												(param1
													conditionsOK:
														(global390 count:)
														(temp24 cardRank:)
												)
											)
											(global390 add: temp24 points2: 0)
											(= temp7 (global390 checkRuns:))
											(global390 delete: temp24)
											(if temp7
												(++ temp18)
												(break)
											)
										)
									)
								)
								(global390 delete: temp13)
							)
							(++ temp2)
						)
						(temp9
							rating:
								(+
									(temp9 rating:)
									(switch (- temp17 temp18)
										(0
											(if (param1 encourageScoring:)
												8
											else
												0
											)
										)
										(1
											(if (param1 encourageScoring:)
												2
											else
												-2
											)
										)
										(2
											(if (param1 encourageScoring:)
												-6
											else
												-12
											)
										)
										(3
											(if (param1 encourageScoring:)
												-12
											else
												-20
											)
										)
										(else
											(if (param1 encourageScoring:)
												-20
											else
												-28
											)
										)
									)
								)
						)
						(global390 delete: temp9)
					)
				else
					(param1 clearRatings:)
					(= temp4 (= temp21 0))
					(for ((= temp0 0)) (< temp0 (temp25 size:)) ((++ temp0))
						(= temp23 (param1 value: (= temp9 (temp25 at: temp0))))
						(if (<= (+ (global390 count:) temp23) 31)
							(++ temp4)
							(temp9 rating: 1)
							(+= temp21 temp23)
						)
					)
					(if (> temp4 1)
						(cond
							((> (+ temp21 (global390 count:)) 31)
								(cond
									((== temp4 2)
										(param1 findPrecedence:)
									)
									((== temp4 3)
										(param1
											test2: 0 1
											test2: 0 2
											test2: 1 2
										)
										(for
											((= temp0 (= temp1 0)))
											(< temp0 (temp25 size:))
											((++ temp0))
											
											(if
												(>=
													((temp25 at: temp0) rating:)
													2
												)
												(++ temp1)
											)
										)
										(if (not temp1)
											(param1 findPrecedence:)
										)
									)
								)
							)
							((== temp4 3)
								(param1 test2: 0 1 test2: 0 2 test2: 1 2)
							)
						)
					)
				)
			)
		)
		(= temp26 0)
		(= temp0 0)
		(= temp8 -201)
		(while (< temp0 (temp25 size:))
			(= temp9 (temp25 at: temp0))
			(if (> (temp9 rating:) temp8)
				(= temp26 temp5)
				(= temp8 (temp9 rating:))
				(= temp5 temp9)
			)
			(++ temp0)
		)
		(if (and (== global775 0) temp26 (Random 0 1) (> (temp26 rating:) 0))
			(= temp5 temp26)
		)
		(DisposeClone temp13)
		(return temp5)
	)
)

