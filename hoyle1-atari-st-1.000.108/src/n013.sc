;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use Interface)

(public
	proc13_0 0
)

(procedure (proc13_0 param1)
	(= global859 param1)
	(cond
		(global860
			(cond
				((== global860 1)
					(= global100 1)
					(global859 getSuitList: global170)
					(localproc_0 1)
				)
				((== global860 global875)
					(cond
						((== (global859 takeAllPlayer:) global859)
							(if global169
								(if
									(and
										(== global170 0)
										(global859 queenSpades:)
									)
									(= global100 2)
									(localproc_0 7)
								else
									(= global100 3)
									(localproc_0 1)
								)
							else
								(= global100 4)
								(localproc_0 2 9 1)
							)
						)
						((global859 takeAllPlayer:)
							(cond
								(global169
									(cond
										(
											(==
												global172
												((global859 takeAllPlayer:)
													playerNum:
												)
											)
											(= global100 5)
											(localproc_0 8 2 1)
										)
										(
											(and
												(== global170 0)
												(global859 queenSpades:)
											)
											(= global100 6)
											(localproc_0 7)
										)
										(else
											(= global100 7)
											(localproc_0 1)
										)
									)
								)
								(
									(!=
										((global859 takeAllPlayer:) playerNum:)
										global172
									)
									(cond
										(
											(and
												(== global170 0)
												(global859 queenSpades:)
											)
											(= global100 8)
											(localproc_0 7)
										)
										((== global170 3)
											(= global100 208)
											(localproc_0 1)
										)
										(else
											(= global100 209)
											(localproc_0 8 1 1)
										)
									)
								)
								(
									(and
										(== global170 0)
										(global859 queenSpades:)
										(global859 spadeDanger:)
									)
									(= global100 210)
									(localproc_0 7)
								)
								(else
									(= global100 211)
									(localproc_0 8 1 1)
								)
							)
						)
						((and (== global170 0) (global859 queenSpades:))
							(= global100 9)
							(localproc_0 7)
						)
						(else
							(= global100 10)
							(localproc_0 1)
						)
					)
				)
				((== global860 global863)
					(cond
						((== (global859 takeAllPlayer:) global859)
							(cond
								((or global870 global871)
									(= global100 13)
									(localproc_0 2 9 1)
								)
								(global868
									(if global169
										(= global100 14)
										(localproc_0 13 1)
									else
										(= global100 15)
										(localproc_0 2 9 1)
									)
								)
								(else
									(= global100 16)
									(localproc_0 13 1)
								)
							)
						)
						((global859 takeAllPlayer:)
							(cond
								(global873
									(cond
										(global169
											(if (or global870 global871)
												(= global100 17)
												(localproc_0 1 8 1)
											else
												(= global100 18)
												(localproc_0 2 9 1)
											)
										)
										(global868
											(if (== global170 0)
												(= global100 19)
												(localproc_0 2 9 1)
											else
												(= global100 20)
												(localproc_0 1)
											)
										)
										(else
											(= global100 21)
											(localproc_0 2 9 1)
										)
									)
								)
								(global169
									(if global874
										(cond
											((>= global169 13)
												(if
													(>=
														((global859
																takeAllPlayer:
															)
															handPoints:
														)
														10
													)
													(= global100 22)
													(localproc_0 1)
												else
													(= global100 23)
													(localproc_0 2)
												)
											)
											((> global449 18)
												(= global100 24)
												(localproc_0 1)
											)
											(else
												(= global100 25)
												(localproc_0 2 9 1)
											)
										)
									else
										(= global100 26)
										(localproc_0 8 1 1)
									)
								)
								(global874
									(cond
										((== global170 0)
											(cond
												(global265
													(= global100 27)
													(localproc_0 1)
												)
												((global859 queenSpades:)
													(= global100 28)
													(localproc_0 13 1 1)
												)
												(else
													(= global100 29)
													(localproc_0 4 2)
												)
											)
										)
										(global868
											(= global100 30)
											(localproc_0 8)
										)
										((or global265 (global859 queenSpades:))
											(= global100 31)
											(localproc_0 1)
										)
										(else
											(= global100 32)
											(localproc_0 2)
										)
									)
								)
								(else
									(= global100 33)
									(localproc_0 8 1 1)
								)
							)
						)
						(global169
							(cond
								((or global870 global871)
									(= global100 34)
									(localproc_0 1 8 1)
								)
								((or global876 global871)
									(= global100 35)
									(localproc_0 1 8 1)
								)
								(else
									(= global100 36)
									(localproc_0 2 9 1)
								)
							)
						)
						((or global870 global871)
							(= global100 37)
							(localproc_0 1 8 1)
						)
						(global868
							(if (== global170 0)
								(= global100 38)
								(localproc_0 4 1 1)
							else
								(= global100 39)
								(localproc_0 1 8 1)
							)
						)
						(else
							(= global100 40)
							(localproc_0 2 9 1)
						)
					)
				)
				((== (global859 takeAllPlayer:) global859)
					(cond
						(global169
							(if (or global870 global871)
								(= global100 41)
								(localproc_0 11)
							else
								(= global100 42)
								(localproc_0 13 1 1)
							)
						)
						(global868
							(= global100 43)
							(localproc_0 2 9 1)
						)
						(else
							(= global100 44)
							(localproc_0 11 1 1)
						)
					)
				)
				((global859 takeAllPlayer:)
					(cond
						(global873
							(cond
								(global169
									(cond
										((>= global169 13)
											(if (== global449 26)
												(= global100 45)
												(localproc_0 11)
											else
												(= global100 46)
												(localproc_0 12)
											)
										)
										(
											(and
												(==
													((global859 takeAllPlayer:)
														playerNum:
													)
													global172
												)
												(or
													(>= global449 14)
													(< global169 13)
												)
											)
											(= global100 47)
											(localproc_0 11)
										)
										(else
											(= global100 48)
											(localproc_0 12)
										)
									)
								)
								(
									(==
										((global859 takeAllPlayer:) playerNum:)
										global172
									)
									(= global100 49)
									(localproc_0 11 12 1)
								)
								(else
									(= global100 50)
									(localproc_0 12 11 1)
								)
							)
						)
						(global169
							(cond
								((> global449 23)
									(= global100 51)
									(localproc_0 1)
								)
								((< global169 13)
									(if global874
										(= global100 52)
										(localproc_0 13 1 1)
									else
										(= global100 53)
										(localproc_0 8 1 1)
									)
								)
								((>= global449 25)
									(= global100 54)
									(localproc_0 1)
								)
								(else
									(= global100 55)
									(localproc_0 12)
								)
							)
						)
						(else
							(= global100 56)
							(localproc_0 12 2 1)
						)
					)
				)
				(global169
					(if
						(and
							(== global170 0)
							global870
							(or (global859 kingSpades:) (global859 aceSpades:))
							(not global265)
						)
						(= global100 257)
						(localproc_0 1 8 1)
					else
						(= global100 57)
						(localproc_0 12)
					)
				)
				(global868
					(cond
						((or global870 global871)
							(if
								(and
									(== global170 0)
									(> global171 12)
									(global859 queenSpades:)
								)
								(= global100 258)
								(localproc_0 7)
							else
								(= global100 58)
								(localproc_0 1 8 1)
							)
						)
						((== global170 0)
							(if (> global171 12)
								(if (global859 queenSpades:)
									(= global100 59)
									(localproc_0 7)
								else
									(= global100 259)
									(localproc_0 12)
								)
							else
								(= global100 260)
								(localproc_0 4 1 1)
							)
						)
						(else
							(= global100 60)
							(localproc_0 1 8 1)
						)
					)
				)
				(else
					(= global100 61)
					(localproc_0 12)
				)
			)
		)
		(
			(and
				(== (global859 takeAllPlayer:) global859)
				(not global169)
				global872
			)
			(cond
				((>= global864 0)
					(= global100 62)
					(global859 getSuitList: global864)
					(localproc_0 2)
				)
				(global872
					(= global100 63)
					(localproc_0 5)
				)
				(else
					(= global100 64)
					(localproc_0 6)
				)
			)
		)
		((global859 takeAllPlayer:)
			(cond
				(global873
					(cond
						((== ((global859 takeAllPlayer:) playerNum:) global172)
							(global859 getSuitList: global869)
							(if
								(and
									(not global265)
									(== global306 1)
									(== global869 0)
									(==
										((global859 takeAllPlayer:) handPoints:)
										13
									)
								)
								(= global100 265)
								(localproc_0 14)
							else
								(= global100 65)
								(if (and (== global869 3) (>= global145 0))
									(global859 getSuitList: global145)
								)
								(localproc_0 8 1 1)
							)
						)
						((global859 spadeDanger:)
							(= global100 66)
							(localproc_0 10)
						)
						([global877 3]
							(= global100 67)
							(localproc_0 3)
						)
						((global859 queenSpades:)
							(= global100 268)
							(localproc_0 7)
						)
						(else
							(= global100 68)
							(global859 getSuitList: global865)
							(localproc_0 1)
						)
					)
				)
				((not global867)
					(if (global859 queenSpades:)
						(= global100 69)
						(localproc_0 7)
					)
					(if [global877 3]
						(= global100 70)
						(localproc_0 3)
					)
				)
				(else
					(= global100 71)
					(global859 getSuitList: global869)
					(localproc_0 8)
				)
			)
		)
		((global859 spadeDanger:)
			(= global100 72)
			(localproc_0 10)
		)
		((global859 heartDanger:)
			(if
				(and
					global858
					(!= global269 global859)
					(> ((global859 heartsList:) size:) 2)
				)
				(global859 getSuitList: 3)
				(= global100 73)
				(localproc_0 8 3)
			else
				(= global100 74)
				(localproc_0 3)
			)
		)
		(else
			(global859 getSuitList: global864)
			(cond
				((and (== global864 3) global858 (!= global269 global859))
					(if
						(>
							(global859
								howManyHigher:
									3
									(((global859 heartsList:)
											at:
												(-
													((global859 heartsList:)
														size:
													)
													1
												)
										)
										cardRank:
									)
							)
							4
						)
						(= global100 275)
						(localproc_0 1)
					else
						(= global100 75)
						(localproc_0 8 1)
					)
				)
				(
					(and
						global269
						(!= (global269 playerNum:) global172)
						(or [global877 3] (global859 queenSpades:))
					)
					(if (global859 queenSpades:)
						(= global100 76)
						(localproc_0 7)
					else
						(= global100 77)
						(localproc_0 3)
					)
				)
				((and (not global269) (global859 queenSpades:))
					(= global100 78)
					(localproc_0 7)
				)
				(else
					(= global100 79)
					(localproc_0 1)
				)
			)
		)
	)
	(return global861)
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(if gDebugOn
		(Printf 13 0 global100) ; "In PlayCard from %d"
	)
	(if
		(and
			(= temp0 (localproc_1 param1))
			(or (!= argc 3) (!= (temp0 cardRank:) 12) (!= (temp0 cardSuit:) 0))
		)
		(= global861 temp0)
		(return temp0)
	)
	(return (= global861 (= temp0 (localproc_1 param2))))
)

(procedure (localproc_1 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(switch param1
		(1
			(return (global310 at: global307))
		)
		(2
			(return (global310 at: 0))
		)
		(3
			(return
				((global859 heartsList:)
					at: (- ((global859 heartsList:) size:) 1)
				)
			)
		)
		(4
			(if (== global310 (global859 spadesList:))
				(for ((= temp0 global307)) (>= temp0 0) ((-- temp0))
					(if (< 1 ((global310 at: temp0) cardRank:) 12)
						(return (global310 at: temp0))
					)
				)
				(return 0)
			)
			(return (global310 at: global307))
		)
		(5
			(= temp3 15)
			(if ((global859 spadesList:) size:)
				(= temp4 ((global859 spadesList:) at: 0))
				(cond
					((!= (temp4 cardRank:) 12)
						(= temp3 (temp4 cardRank:))
					)
					((>= ((global859 spadesList:) size:) 2)
						(= temp4 ((global859 spadesList:) at: 1))
						(= temp3 (temp4 cardRank:))
					)
				)
			)
			(if (== temp3 1)
				(= temp3 14)
			)
			(if ((global859 clubsList:) size:)
				(if (== (= temp0 (((global859 clubsList:) at: 0) cardRank:)) 1)
					(= temp0 14)
				)
				(if (<= temp0 temp3)
					(= temp3 temp0)
					(= temp4 ((global859 clubsList:) at: 0))
				)
			)
			(if ((global859 diamondsList:) size:)
				(if
					(==
						(= temp0 (((global859 diamondsList:) at: 0) cardRank:))
						1
					)
					(= temp0 14)
				)
				(if (<= temp0 temp3)
					(= temp3 temp0)
					(= temp4 ((global859 diamondsList:) at: 0))
				)
			)
			(return temp4)
		)
		(6
			(if (global859 queenSpades:)
				(return (localproc_1 7))
			else
				(return
					((global859 heartsList:)
						at: (- ((global859 heartsList:) size:) 1)
					)
				)
			)
		)
		(7
			(for
				((= temp0 0))
				(< temp0 ((global859 cardList:) size:))
				((++ temp0))
				
				(if
					(and
						(== (((global859 cardList:) at: temp0) cardRank:) 12)
						(== (((global859 cardList:) at: temp0) cardSuit:) 0)
					)
					(return ((global859 cardList:) at: temp0))
				)
			)
		)
		(8
			(if (>= global306 2)
				(return (global310 at: (- global306 2)))
			else
				(return (global310 at: global307))
			)
		)
		(9
			(if (>= global306 2)
				(return (global310 at: 1))
			else
				(return (global310 at: 0))
			)
		)
		(10
			(if (global859 queenSpades:)
				(return (localproc_1 7))
			else
				(return
					((global859 spadesList:)
						at: (- ((global859 spadesList:) size:) 1)
					)
				)
			)
		)
		(11
			(for ((= temp0 0)) (< temp0 global306) ((++ temp0))
				(if
					(or
						(> ((global310 at: temp0) cardRank:) global171)
						(== ((global310 at: temp0) cardRank:) 1)
					)
					(return (global310 at: temp0))
				)
			)
		)
		(12
			(for ((= temp0 global307)) (>= temp0 0) ((-- temp0))
				(if (< 1 ((global310 at: temp0) cardRank:) global171)
					(return (global310 at: temp0))
				)
			)
		)
		(13
			(= temp2 0)
			(for ((= temp0 global307)) (>= temp0 0) ((-- temp0))
				(if (== ((global310 at: temp0) cardRank:) 1)
					(= temp2 (global310 at: temp0))
				else
					(for
						((= temp1 (+ ((global310 at: temp0) cardRank:) 1)))
						(< temp1 15)
						((++ temp1))
						
						(= temp5 (if (== temp1 14) 1 else temp1))
						(if
							(and
								(not (gDeck playedCard: temp5 global170))
								(==
									((global859 cardList:)
										hasCard: temp5 global170
									)
									-1
								)
							)
							(return temp2)
						)
					)
					(= temp2 (global310 at: temp0))
				)
			)
			(return temp2)
		)
		(14
			(= global310 (global859 cardList:))
			(= temp3 99)
			(for ((= temp0 0)) (< temp0 (global310 size:)) ((++ temp0))
				(if (== (= temp5 ((global310 at: temp0) cardRank:)) 1)
					(= temp5 14)
				)
				(if (< temp5 temp3)
					(= temp3 temp5)
					(= temp4 (global310 at: temp0))
				)
			)
			(return temp4)
		)
	)
)

