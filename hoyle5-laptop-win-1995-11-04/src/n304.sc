;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 304)
(include sci.sh)
(use Main)

(public
	proc304_0 0
)

(procedure (proc304_0 param1 &tmp temp0 temp1 temp2)
	(= global501 param1)
	(cond
		(global536
			(cond
				((== global536 1)
					(= global500 1)
					(global501 getSuitList: global528)
					(localproc_0 1)
				)
				((== global536 global537)
					(cond
						((== (global501 takeAllPlayer:) (global501 cardList:))
							(if global530
								(if
									(and
										(== global528 0)
										(global501 queenSpades:)
									)
									(= global500 2)
									(localproc_0 7)
								else
									(= global500 3)
									(localproc_0 1)
								)
							else
								(= global500 4)
								(localproc_0 2 9 1)
							)
						)
						((global501 takeAllPlayer:)
							(cond
								(global530
									(cond
										(
											(==
												global525
												(global117
													indexOf:
														(global501
															takeAllPlayer:
														)
												)
											)
											(= global500 5)
											(localproc_0 8 2 1)
										)
										(
											(and
												(== global528 0)
												(global501 queenSpades:)
											)
											(= global500 6)
											(localproc_0 7)
										)
										(else
											(= global500 7)
											(localproc_0 1)
										)
									)
								)
								(
									(!=
										(global117
											indexOf: (global501 takeAllPlayer:)
										)
										global525
									)
									(cond
										(
											(and
												(== global528 0)
												(global501 queenSpades:)
											)
											(= global500 8)
											(localproc_0 7)
										)
										((== global528 3)
											(= global500 208)
											(localproc_0 1)
										)
										(else
											(= global500 209)
											(localproc_0 8 1 1)
										)
									)
								)
								(
									(and
										(== global528 0)
										(global501 queenSpades:)
										(global501 spadeDanger:)
									)
									(= global500 210)
									(localproc_0 7)
								)
								(else
									(= global500 211)
									(localproc_0 8 1 1)
								)
							)
						)
						((and (== global528 0) (global501 queenSpades:))
							(= global500 9)
							(localproc_0 7)
						)
						(else
							(= global500 10)
							(localproc_0 1)
						)
					)
				)
				((== global536 global497)
					(cond
						((== (global501 takeAllPlayer:) (global501 cardList:))
							(cond
								((or global496 global495)
									(= global500 13)
									(localproc_0 2 9 1)
								)
								(global494
									(if global530
										(= global500 14)
										(localproc_0 13 1)
									else
										(= global500 15)
										(localproc_0 2 9 1)
									)
								)
								(else
									(= global500 16)
									(localproc_0 13 1)
								)
							)
						)
						((global501 takeAllPlayer:)
							(cond
								(global539
									(cond
										(global530
											(if (or global496 global495)
												(= global500 17)
												(localproc_0 1 8 1)
											else
												(= global500 18)
												(localproc_0 2 9 1)
											)
										)
										(global494
											(if (== global528 0)
												(= global500 19)
												(localproc_0 2 9 1)
											else
												(= global500 20)
												(localproc_0 1)
											)
										)
										(else
											(= global500 21)
											(localproc_0 2 9 1)
										)
									)
								)
								(global530
									(if global238
										(cond
											((>= global530 13)
												(if
													(>=
														((global501
																takeAllPlayer:
															)
															tempTotal:
														)
														10
													)
													(= global500 22)
													(localproc_0 1)
												else
													(= global500 23)
													(localproc_0 2)
												)
											)
											((> global237 18)
												(= global500 24)
												(localproc_0 1)
											)
											(else
												(= global500 25)
												(localproc_0 2 9 1)
											)
										)
									else
										(= global500 26)
										(localproc_0 8 1 1)
									)
								)
								(global238
									(cond
										((== global528 0)
											(cond
												(global503
													(= global500 27)
													(localproc_0 1)
												)
												((global501 queenSpades:)
													(= global500 28)
													(localproc_0 13 1 1)
												)
												(else
													(= global500 29)
													(localproc_0 4 2)
												)
											)
										)
										(global494
											(= global500 30)
											(localproc_0 8)
										)
										((or global503 (global501 queenSpades:))
											(= global500 31)
											(localproc_0 1)
										)
										(else
											(= global500 32)
											(localproc_0 2)
										)
									)
								)
								(else
									(= global500 33)
									(localproc_0 8 1 1)
								)
							)
						)
						(global530
							(cond
								((or global496 global495)
									(= global500 34)
									(localproc_0 1 8 1)
								)
								((or global499 global495)
									(= global500 35)
									(localproc_0 1 8 1)
								)
								(else
									(= global500 36)
									(localproc_0 2 9 1)
								)
							)
						)
						((or global496 global495)
							(= global500 37)
							(localproc_0 1 8 1)
						)
						(global494
							(if (== global528 0)
								(= global500 38)
								(localproc_0 4 1 1)
							else
								(= global500 39)
								(localproc_0 1 8 1)
							)
						)
						(else
							(= global500 40)
							(localproc_0 2 9 1)
						)
					)
				)
				((== (global501 takeAllPlayer:) (global501 cardList:))
					(cond
						(global530
							(if (or global496 global495)
								(= global500 41)
								(localproc_0 11)
							else
								(= global500 42)
								(localproc_0 13 1 1)
							)
						)
						(global494
							(= global500 43)
							(localproc_0 2 9 1)
						)
						(else
							(= global500 44)
							(localproc_0 11 1 1)
						)
					)
				)
				((global501 takeAllPlayer:)
					(cond
						(global539
							(cond
								(global530
									(cond
										((>= global530 13)
											(if (== global237 26)
												(= global500 45)
												(localproc_0 11)
											else
												(= global500 46)
												(localproc_0 12)
											)
										)
										(
											(and
												(==
													(global117
														indexOf:
															(global501
																takeAllPlayer:
															)
													)
													global525
												)
												(or
													(>= global237 14)
													(< global530 13)
												)
											)
											(= global500 47)
											(localproc_0 11)
										)
										(else
											(= global500 48)
											(localproc_0 12)
										)
									)
								)
								(
									(==
										(global117
											indexOf: (global501 takeAllPlayer:)
										)
										global525
									)
									(= global500 49)
									(localproc_0 11 12 1)
								)
								(else
									(= global500 50)
									(localproc_0 12 11 1)
								)
							)
						)
						(global530
							(cond
								((> global237 23)
									(= global500 51)
									(localproc_0 1)
								)
								((< global530 13)
									(if global238
										(= global500 52)
										(localproc_0 13 1 1)
									else
										(= global500 53)
										(localproc_0 8 1 1)
									)
								)
								((>= global237 25)
									(= global500 54)
									(localproc_0 1)
								)
								(else
									(= global500 55)
									(localproc_0 12)
								)
							)
						)
						(else
							(= global500 56)
							(localproc_0 12 2 1)
						)
					)
				)
				(global530
					(if
						(and
							(== global528 0)
							global496
							(or (global501 kingSpades:) (global501 aceSpades:))
							(not global503)
						)
						(= global500 257)
						(localproc_0 1 8 1)
					else
						(= global500 57)
						(localproc_0 12)
					)
				)
				(global494
					(cond
						((or global496 global495)
							(if
								(and
									(== global528 0)
									(> global529 12)
									(global501 queenSpades:)
								)
								(= global500 258)
								(localproc_0 7)
							else
								(= global500 58)
								(localproc_0 1 8 1)
							)
						)
						((== global528 0)
							(if (> global529 12)
								(if (global501 queenSpades:)
									(= global500 59)
									(localproc_0 7)
								else
									(= global500 259)
									(localproc_0 12)
								)
							else
								(= global500 260)
								(localproc_0 4 1 1)
							)
						)
						(else
							(= global500 60)
							(localproc_0 1 8 1)
						)
					)
				)
				(else
					(= global500 61)
					(localproc_0 12)
				)
			)
		)
		(
			(and
				(== (global501 takeAllPlayer:) (global501 cardList:))
				(not global530)
				global239
			)
			(cond
				((>= global245 0)
					(= global500 62)
					(global501 getSuitList: global245)
					(localproc_0 2)
				)
				(global239
					(= global500 63)
					(localproc_0 5)
				)
				(else
					(= global500 64)
					(localproc_0 6)
				)
			)
		)
		((global501 takeAllPlayer:)
			(cond
				(global539
					(cond
						(
							(==
								(global117 indexOf: (global501 takeAllPlayer:))
								global525
							)
							(global501 getSuitList: global522)
							(if
								(and
									(not global503)
									(== global504 1)
									(== global522 0)
									(==
										((global501 takeAllPlayer:) tempTotal:)
										13
									)
								)
								(= global500 265)
								(localproc_0 14)
							else
								(= global500 65)
								(if (and (== global522 3) (>= global479 0))
									(global501 getSuitList: global479)
								)
								(localproc_0 8 1 1)
							)
						)
						((global501 spadeDanger:)
							(= global500 66)
							(localproc_0 10)
						)
						([global531 3]
							(= global500 67)
							(localproc_0 3)
						)
						((global501 queenSpades:)
							(= global500 268)
							(localproc_0 7)
						)
						(else
							(= global500 68)
							(global501 getSuitList: global524)
							(localproc_0 1)
						)
					)
				)
				((not global246)
					(if (global501 queenSpades:)
						(= global500 69)
						(localproc_0 7)
					)
					(if [global531 3]
						(= global500 70)
						(localproc_0 3)
					)
				)
				(else
					(= global500 71)
					(global501 getSuitList: global522)
					(localproc_0 8)
				)
			)
		)
		((and (== global236 1) (not (gTrick tricksPlayed:)))
			(= global500 80)
			(= temp2 (= temp1 -1))
			(for ((= temp0 0)) (< temp0 3) ((++ temp0))
				(global501 getSuitList: temp0)
				(if (and global507 (> global504 temp1))
					(= temp2 temp1)
					(= temp1 temp0)
				)
			)
			(global501 getSuitList: temp1)
			(if (and (== temp1 0) (> global504 1))
				(localproc_0 1 8 1)
			else
				(localproc_0 2)
			)
		)
		((global501 spadeDanger:)
			(= global500 72)
			(localproc_0 10)
		)
		((global501 heartDanger:)
			(if
				(and
					global540
					(!= global498 (global501 cardList:))
					(> ((global501 heartsList:) size:) 2)
				)
				(global501 getSuitList: 3)
				(= global500 73)
				(localproc_0 8 3)
			else
				(= global500 74)
				(localproc_0 3)
			)
		)
		(else
			(global501 getSuitList: global245)
			(cond
				(
					(and
						(== global245 3)
						global540
						(!= global498 (global501 cardList:))
					)
					(if
						(>
							(global501
								howManyHigher:
									3
									(((global501 heartsList:)
											at:
												(-
													((global501 heartsList:)
														size:
													)
													1
												)
										)
										rank:
									)
							)
							4
						)
						(= global500 275)
						(localproc_0 1)
					else
						(= global500 75)
						(localproc_0 8 1)
					)
				)
				(
					(and
						global498
						(!= (global117 indexOf: global498) global525)
						(or [global531 3] (global501 queenSpades:))
					)
					(if (global501 queenSpades:)
						(= global500 76)
						(localproc_0 7)
					else
						(= global500 77)
						(localproc_0 3)
					)
				)
				((and (not global498) (global501 queenSpades:))
					(= global500 78)
					(localproc_0 7)
				)
				(else
					(= global500 79)
					(localproc_0 1)
				)
			)
		)
	)
	(return global502)
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(if
		(and
			(= temp0 (localproc_1 param1))
			(or (!= argc 3) (!= (temp0 rank:) 12) (!= (temp0 suit:) 0))
		)
		(= global502 temp0)
		(return temp0)
	)
	(return (= global502 (= temp0 (localproc_1 param2))))
)

(procedure (localproc_1 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(switch param1
		(1
			(return (global507 at: global505))
		)
		(2
			(return (global507 at: 0))
		)
		(3
			(return
				((global501 heartsList:)
					at: (- ((global501 heartsList:) size:) 1)
				)
			)
		)
		(4
			(if (== global507 (global501 spadesList:))
				(for ((= temp0 global505)) (>= temp0 0) ((-- temp0))
					(if (< ((= temp4 (global507 at: temp0)) rank:) 12)
						(return temp4)
					)
				)
				(return 0)
			)
			(return (global507 at: global505))
		)
		(5
			(= temp3 15)
			(if ((global501 spadesList:) size:)
				(= temp4 ((global501 spadesList:) at: 0))
				(cond
					((!= (temp4 rank:) 12)
						(= temp3 (temp4 rank:))
					)
					((>= ((global501 spadesList:) size:) 2)
						(= temp4 ((global501 spadesList:) at: 1))
						(= temp3 (temp4 rank:))
					)
				)
			)
			(if
				(and
					((global501 clubsList:) size:)
					(<= (= temp0 (((global501 clubsList:) at: 0) rank:)) temp3)
				)
				(= temp3 temp0)
				(= temp4 ((global501 clubsList:) at: 0))
			)
			(if
				(and
					((global501 diamondsList:) size:)
					(<=
						(= temp0 (((global501 diamondsList:) at: 0) rank:))
						temp3
					)
				)
				(= temp3 temp0)
				(= temp4 ((global501 diamondsList:) at: 0))
			)
			(return temp4)
		)
		(6
			(if (global501 queenSpades:)
				(return (localproc_1 7))
			else
				(return
					((global501 heartsList:)
						at: (- ((global501 heartsList:) size:) 1)
					)
				)
			)
		)
		(7
			(for
				((= temp0 0))
				(< temp0 ((global501 cardList:) size:))
				((++ temp0))
				
				(if
					(and
						(== (((global501 cardList:) at: temp0) rank:) 12)
						(== (((global501 cardList:) at: temp0) suit:) 0)
					)
					(return ((global501 cardList:) at: temp0))
				)
			)
		)
		(8
			(if (>= global504 2)
				(return (global507 at: (- global504 2)))
			else
				(return (global507 at: global505))
			)
		)
		(9
			(if (>= global504 2)
				(return (global507 at: 1))
			else
				(return (global507 at: 0))
			)
		)
		(10
			(if (global501 queenSpades:)
				(return (localproc_1 7))
			else
				(return
					((global501 spadesList:)
						at: (- ((global501 spadesList:) size:) 1)
					)
				)
			)
		)
		(11
			(for ((= temp0 0)) (< temp0 global504) ((++ temp0))
				(if (> ((global507 at: temp0) rank:) global529)
					(return (global507 at: temp0))
				)
			)
		)
		(12
			(for ((= temp0 global505)) (>= temp0 0) ((-- temp0))
				(if (< ((global507 at: temp0) rank:) global529)
					(return (global507 at: temp0))
				)
			)
		)
		(13
			(= temp2 0)
			(for ((= temp0 global505)) (>= temp0 0) ((-- temp0))
				(if (== ((global507 at: temp0) rank:) 14)
					(= temp2 (global507 at: temp0))
				else
					(for
						((= temp1 (+ ((global507 at: temp0) rank:) 1)))
						(<= temp1 14)
						((++ temp1))
						
						(= temp5 temp1)
						(if
							(and
								(not (gTrick playedCard: temp5 global528))
								(not
									((global501 cardList:)
										hasCard: temp5 global528
									)
								)
							)
							(return temp2)
						)
					)
					(= temp2 (global507 at: temp0))
				)
			)
			(return temp2)
		)
		(14
			(= global507 (global501 cardList:))
			(= temp3 99)
			(for ((= temp0 0)) (< temp0 (global507 size:)) ((++ temp0))
				(if (< (= temp5 ((global507 at: temp0) rank:)) temp3)
					(= temp3 temp5)
					(= temp4 (global507 at: temp0))
				)
			)
			(return temp4)
		)
	)
)

