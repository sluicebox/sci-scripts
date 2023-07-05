;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use room3)

(public
	proc19_0 0
)

(procedure (proc19_0 param1)
	(= global859 param1)
	(= global773 (localproc_13))
	(= global100 50)
	(global859 spadeDanger: (localproc_14))
	(= global869 (localproc_12))
	(= global856 (localproc_5))
	(= global100 52)
	(localproc_9)
	(= global100 53)
	(= global101 (localproc_0 global859))
	(= global100 54)
	(= global102 (localproc_1))
	(= global100 55)
	(= global865 (localproc_6))
	(= global100 56)
	(= global103 (localproc_10))
	(= global100 57)
	(= global104 (localproc_2))
	(= global100 58)
)

(procedure (localproc_0)
	(return
		(or
			(and
				(!= global859 gPlayer1)
				(== (gPlayer1 takeAllPlayer:) global859)
			)
			(and
				(!= global859 gPlayer2)
				(== (gPlayer2 takeAllPlayer:) global859)
			)
			(and
				(!= global859 gPlayer3)
				(== (gPlayer3 takeAllPlayer:) global859)
			)
		)
	)
)

(procedure (localproc_1)
	(return
		(if ((global859 spadesList:) size:)
			(((global859 spadesList:) at: (- ((global859 spadesList:) size:) 1))
				cardRank:
			)
		else
			0
		)
	)
)

(procedure (localproc_2 &tmp temp0 temp1 temp2 temp3)
	(= temp1 (= temp2 -1))
	(for ((= temp0 0)) (<= temp0 3) ((++ temp0))
		(if (> (= temp3 (localproc_3 temp0)) temp1)
			(switch temp0
				(0
					(if
						(and
							(not global265)
							(or
								(>=
									(((global859 spadesList:)
											at:
												(-
													((global859 spadesList:)
														size:
													)
													1
												)
										)
										cardRank:
									)
									12
								)
								(==
									(((global859 spadesList:)
											at:
												(-
													((global859 spadesList:)
														size:
													)
													1
												)
										)
										cardRank:
									)
									1
								)
							)
						)
						(continue)
					)
				)
				(3
					(if
						(or
							(==
								(((global859 heartsList:)
										at:
											(-
												((global859 heartsList:) size:)
												1
											)
									)
									cardRank:
								)
								1
							)
							(>=
								(((global859 heartsList:)
										at:
											(-
												((global859 heartsList:) size:)
												1
											)
									)
									cardRank:
								)
								7
							)
							(not global773)
						)
						(continue)
					)
				)
			)
			(= temp1 temp3)
			(= temp2 temp0)
		)
	)
	(return temp2)
)

(procedure (localproc_3 param1 &tmp temp0 temp1 temp2)
	(= global328 -1)
	(= temp1 ((global859 cardList:) howManyOfSuit: param1))
	(= temp0 (gDeck remaining: param1))
	(if (> (= temp2 (- global448 (localproc_4 param1))) temp0)
		(= temp2 temp0)
	)
	(if temp1
		(= global328 (- (gDeck remaining: param1) (* temp1 temp2)))
	)
	(return global328)
)

(procedure (localproc_4 param1 &tmp temp0 temp1)
	(= temp0 (= temp1 0))
	(while (< temp1 global448)
		(if
			(and
				(!= temp1 (global859 playerNum:))
				(global859 playerOutOf: param1 temp1)
				(global270 outOf: 3)
				(or (global859 queenSpades:) global265 (global270 outOf: 0))
			)
			(++ temp0)
		)
		(++ temp1)
	)
	(return temp0)
)

(procedure (localproc_5 &tmp temp0 temp1 temp2)
	(= temp0 0)
	(for
		((= temp1 (+ (gCardRoom currentPlayer:) 1)))
		(<= temp1 (+ (gCardRoom currentPlayer:) 3))
		((++ temp1))
		
		(= temp2
			(if (>= temp1 global448)
				(- temp1 global448)
			else
				temp1
			)
		)
		(if
			(and
				(not ((gPlayerList at: temp2) sittingOut:))
				((gPlayerList at: temp2) outOf: 3)
				(or
					(global859 queenSpades:)
					global265
					((gPlayerList at: temp2) outOf: 0)
				)
			)
			(++ temp0)
		)
	)
	(return temp0)
)

(procedure (localproc_6 &tmp temp0 temp1 temp2)
	(= temp0 -1)
	(= temp1 -1)
	(if (> (= temp2 (localproc_8 1)) temp1)
		(= temp1 temp2)
		(= temp0 1)
	)
	(if (> (= temp2 (localproc_8 2)) temp1)
		(= temp1 temp2)
		(= temp0 2)
	)
	(if
		(and
			(or global265 (< 1 global102 12))
			(> (= temp2 (localproc_8 0)) temp1)
		)
		(= temp1 temp2)
		(= temp0 0)
	)
	(if (and global773 (== temp0 -1) ((global859 heartsList:) size:))
		(= temp0 3)
	else
		(= temp0 global869)
	)
	(return temp0)
)

(procedure (localproc_7 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(if (== (= temp3 param2) 1)
		(= temp3 14)
	)
	(for ((= temp0 (= temp1 0))) (< temp0 global306) ((++ temp0))
		(if (== (= temp2 ((global310 at: temp0) cardRank:)) 1)
			(= temp2 14)
		)
		(if (< temp2 temp3)
			(++ temp1)
		)
	)
	(return temp1)
)

(procedure (localproc_8 param1 &tmp temp0 temp1 temp2 [temp3 4])
	(= global100 520)
	(global859 getSuitList: param1)
	(= global100 521)
	(if global306
		(= global100 522)
		(= temp0
			(-
				(gDeck remaining: param1)
				((global859 cardList:) howManyOfSuit: param1)
			)
		)
		(= global100 523)
		(= temp1 (/ temp0 (- global448 global856)))
		(= global100 524)
		(if (== temp1 0)
			(= temp1 1)
		)
		(if (> temp1 global306)
			(return 0)
		)
		(= global100 525)
		(= temp2
			(-
				(global859
					howManyLower: param1 ((global310 at: (- temp1 1)) cardRank:)
				)
				(localproc_7 param1 ((global310 at: (- temp1 1)) cardRank:))
			)
		)
		(= global100 526)
		(return temp2)
	else
		(= global100 527)
		(return -1)
	)
)

(procedure (localproc_9 &tmp temp0 temp1 temp2 [temp3 4] temp7)
	(= [temp3 0]
		(if (== (global859 spadesStrength:) 11)
			-99
		else
			(global859 spadesStrength:)
		)
	)
	(= [temp3 1]
		(if (== (global859 clubsStrength:) 11)
			-99
		else
			(global859 clubsStrength:)
		)
	)
	(= [temp3 2]
		(if (== (global859 diamondsStrength:) 11)
			-99
		else
			(global859 diamondsStrength:)
		)
	)
	(= [temp3 3]
		(if (== (global859 heartsStrength:) 11)
			-99
		else
			(global859 heartsStrength:)
		)
	)
	(if (not global773)
		(= [temp3 3] -99)
	)
	(= [global107 0] 0)
	(= [global107 1] 1)
	(= [global107 2] 2)
	(= [global107 3] 3)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		(for ((= temp1 (+ temp0 1))) (< temp1 4) ((++ temp1))
			(if (> [temp3 temp0] [temp3 temp1])
				(= global264 [temp3 temp1])
				(= [temp3 temp1] [temp3 temp0])
				(= [temp3 temp0] global264)
				(= temp7 [global107 temp1])
				(= [global107 temp1] [global107 temp0])
				(= [global107 temp0] temp7)
			)
		)
	)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(if (!= [temp3 temp0] -99)
			(= global105 [global107 temp0])
			(= global106 (if (== temp0 3) -1 else [global107 (+ temp0 1)]))
			(break)
		)
	)
)

(procedure (localproc_10)
	(if (and (or (< 1 global102 12) global265) (localproc_11 0))
		(return 0)
	)
	(if (localproc_11 1)
		(return 1)
	)
	(if (localproc_11 2)
		(return 2)
	)
	(return -1)
)

(procedure (localproc_11 param1)
	(global859 getSuitList: param1)
	(return
		(if global306
			(not
				(global859
					howManyHigher: param1 ((global310 at: global307) cardRank:)
				)
			)
		else
			0
		)
	)
)

(procedure (localproc_12 &tmp temp0 temp1 temp2 temp3)
	(= global145 -1)
	(= temp1 ((global859 spadesList:) size:))
	(= temp2 0)
	(for ((= temp0 1)) (<= temp0 (if global773 3 else 2)) ((++ temp0))
		(if
			(>
				(= temp3
					(switch temp0
						(1
							((global859 clubsList:) size:)
						)
						(2
							((global859 diamondsList:) size:)
						)
						(3
							((global859 heartsList:) size:)
						)
					)
				)
				temp1
			)
			(= global145 temp2)
			(= temp2 temp0)
			(= temp1 temp3)
		)
	)
	(if (not global145)
		(= global145 -1)
	)
	(return temp2)
)

(procedure (localproc_13)
	(return
		(or
			(!= (gDeck remaining: 3) 13)
			(== ((global859 heartsList:) size:) ((global859 cardList:) size:))
		)
	)
)

(procedure (localproc_14 &tmp temp0 temp1)
	(if
		(or
			global265
			(and
				(not (global859 queenSpades:))
				(not (global859 kingSpades:))
				(not (global859 aceSpades:))
			)
		)
		(return 0)
	)
	(= global165 1)
	(for ((= global264 0)) (< global264 global448) ((++ global264))
		(proc3_1 global264)
		(if (and (!= global270 global859) global270 (not (global270 outOf: 0)))
			(++ global165)
		)
	)
	(= temp1 (- (gDeck remaining: 0) ((global859 spadesList:) size:)))
	(if (> (- global165 1) temp1)
		(= global165 (+ temp1 1))
	)
	(= temp0 0)
	(if (global859 queenSpades:)
		(= temp0 (+ (global859 kingSpades:) (global859 aceSpades:)))
	)
	(if
		(>
			(+ (global859 lowSpades:) temp0)
			(/ (gDeck remaining: 0) global165)
		)
		(return 0)
	else
		(return 1)
	)
)

