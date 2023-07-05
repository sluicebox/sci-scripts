;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use Interface)

(public
	proc15_0 0
)

(procedure (proc15_0 param1)
	(= global859 param1)
	(cond
		((== (global859 takeAllPlayer:) global859)
			(cond
				((localproc_2)
					(= global100 201)
					(localproc_0 3 3)
				)
				(global101
					(cond
						((localproc_3 global107)
							(cond
								((!= global107 3)
									(= global100 1)
									(localproc_0 global107 1)
								)
								((localproc_3 global108)
									(= global100 2)
									(localproc_0 global108 1)
								)
								(else
									(= global100 3)
									(localproc_0 3 3)
								)
							)
						)
						((localproc_3 global108)
							(cond
								((!= global108 3)
									(= global100 4)
									(localproc_0 global108 1)
								)
								((localproc_3 global109)
									(= global100 5)
									(localproc_0 global109 1)
								)
								(else
									(= global100 6)
									(localproc_0 3 3)
								)
							)
						)
						((localproc_3 global109)
							(cond
								((!= global109 3)
									(= global100 7)
									(localproc_0 global109 1)
								)
								((localproc_3 global110)
									(= global100 8)
									(localproc_0 global110 1)
								)
								(else
									(= global100 9)
									(localproc_0 3 3)
								)
							)
						)
						((localproc_3 global110)
							(if (!= global110 3)
								(= global100 10)
								(localproc_0 global110 1)
							else
								(= global100 11)
								(localproc_0 3 3)
							)
						)
						(else
							(= global100 12)
							(localproc_0 global110 3)
						)
					)
				)
				((== global105 3)
					(if (and (!= global106 -1) (localproc_3 global106))
						(= global100 13)
						(localproc_0 global106 1 2 6)
					else
						(= global100 14)
						(localproc_0 3 4)
					)
				)
				((localproc_3 global105)
					(= global100 15)
					(localproc_0 global105 1 2 6)
				)
				(else
					(= global100 16)
					(localproc_0 global105 3 4 6)
				)
			)
		)
		((global859 takeAllPlayer:)
			(cond
				((>= global103 0)
					(if global265
						(= global100 17)
						(localproc_0 global103 3)
					else
						(= global100 18)
						(localproc_0 global103 4 3)
					)
				)
				((>= global104 0)
					(if (localproc_3 global104)
						(= global100 19)
						(localproc_0 global104 3)
					else
						(= global100 20)
						(localproc_0 global104 1)
					)
				)
				((== global865 3)
					(if
						(==
							((global859 heartsList:) size:)
							((global859 cardList:) size:)
						)
						(= global100 21)
						(localproc_0 global865 1)
					else
						(= global100 22)
						(localproc_0 0 5)
					)
				)
				((and (== global865 0) (or (>= global102 12) (== global102 1)))
					(= global100 23)
					(localproc_0 global865 1 1 6)
				)
				((localproc_3 global865)
					(= global100 24)
					(localproc_0 global865 3)
				)
				(else
					(= global100 25)
					(localproc_0 0 5)
				)
			)
		)
		((>= global104 0)
			(if (localproc_3 global104)
				(if (!= global104 3)
					(= global100 26)
					(localproc_0 global104 3)
				else
					(= global100 27)
					(localproc_0 global104 1)
				)
			else
				(= global100 28)
				(localproc_0 global104 1)
			)
		)
		((== global865 3)
			(if
				(==
					((global859 heartsList:) size:)
					((global859 cardList:) size:)
				)
				(= global100 29)
				(localproc_0 global865 1)
			else
				(= global100 30)
				(localproc_0 0 5)
			)
		)
		((and (== global865 0) (or (>= global102 12) (== global102 1)))
			(= global100 31)
			(localproc_0 global865 1 1 6)
		)
		((localproc_3 global865)
			(= global100 32)
			(localproc_0 global865 3)
		)
		(else
			(= global100 33)
			(localproc_0 0 5)
		)
	)
	(return global861)
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0)
	(global859 getSuitList: param1)
	(if gDebugOn
		(Printf 15 0 global100 param1) ; "In PlayCard from %d The suit is %d"
	)
	(if
		(and
			(= temp0 (localproc_1 param2))
			(or (!= argc 4) (!= (temp0 cardRank:) 12) (!= (temp0 cardSuit:) 0))
		)
		(= global861 temp0)
		(return temp0)
	)
	(return (= global861 (= temp0 (localproc_1 param3))))
)

(procedure (localproc_1 param1)
	(switch param1
		(3
			(return (global310 at: global307))
		)
		(1
			(return (global310 at: 0))
		)
		(4
			(if (>= global306 2)
				(return (global310 at: (- global306 2)))
			else
				(return (global310 at: 0))
			)
		)
		(2
			(if (>= global306 2)
				(return (global310 at: 1))
			else
				(return (global310 at: 0))
			)
		)
		(5
			(return (localproc_6))
		)
		(else
			(return 0)
		)
	)
)

(procedure (localproc_2 &tmp temp0 temp1 temp2 temp3 temp4)
	(= global100 60)
	(if (and ((global859 heartsList:) size:) global773)
		(= global100 61)
		(if
			(and
				(not global265)
				((global859 spadesList:) size:)
				(!=
					(global859
						howManyLower:
							0
							(((global859 spadesList:) at: 0) cardRank:)
					)
					(- (gDeck remaining: 0) ((global859 spadesList:) size:))
				)
			)
			(return 0)
		)
		(= global100 62)
		(= temp0 (- (gDeck remaining: 3) ((global859 heartsList:) size:)))
		(= global100 63)
		(= temp1 (localproc_5 3))
		(= global100 64)
		(if
			(= temp2
				(if (- (- global448 temp1) 1)
					(+ (/ temp0 (- (- global448 temp1) 1)) 1)
				else
					0
				)
			)
			(= global100 65)
			(if (> temp2 ((global859 heartsList:) size:))
				(= temp2 ((global859 heartsList:) size:))
			)
			(= global100 66)
			(= temp4
				(global859
					howManyHigher:
						3
						(((global859 heartsList:)
								at: (- ((global859 heartsList:) size:) temp2)
							)
							cardRank:
						)
				)
			)
			(= global100 67)
			(= temp3
				(global859
					howManyHigherInHand:
						3
						(((global859 heartsList:)
								at: (- ((global859 heartsList:) size:) temp2)
							)
							cardRank:
						)
				)
			)
			(= global100 68)
			(if (== temp4 temp3)
				(return 1)
			)
		else
			(return 1)
		)
	)
	(= global100 69)
	(return 0)
)

(procedure (localproc_3 param1 &tmp [temp0 2] temp2)
	(if
		(or
			(not
				(= temp2
					(switch param1
						(0
							((global859 spadesList:) size:)
						)
						(1
							((global859 clubsList:) size:)
						)
						(2
							((global859 diamondsList:) size:)
						)
						(3
							((global859 heartsList:) size:)
						)
						(else 0)
					)
				)
			)
			(and (== param1 3) (not global773))
		)
		(return 0)
	)
	(if
		(and
			(>=
				(-
					(gDeck remaining: param1)
					((global859 cardList:) howManyOfSuit: param1)
				)
				(+ (- (- global448 global856) global276) 1)
			)
			(localproc_4 param1)
		)
		(return 1)
	)
	(return 0)
)

(procedure (localproc_4 param1 &tmp temp0 temp1 temp2)
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
				((gPlayerList at: temp2) outOf: param1)
				(or
					(not ((gPlayerList at: temp2) outOf: 3))
					(and
						(not (global859 queenSpades:))
						(not global265)
						(not ((gPlayerList at: temp2) outOf: 0))
					)
				)
			)
			(return 0)
		)
	)
	(return 1)
)

(procedure (localproc_5 param1 &tmp temp0 temp1)
	(= temp0 (= temp1 0))
	(while (< temp1 global448)
		(if (global859 playerOutOf: param1 temp1)
			(++ temp0)
		)
		(++ temp1)
	)
	(return temp0)
)

(procedure (localproc_6 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
	(= temp4 -1)
	(= temp0 -99)
	(for ((= temp6 0)) (<= temp6 (if global773 3 else 2)) ((++ temp6))
		(global859 getSuitList: temp6)
		(cond
			(
				(or
					(== (gDeck remaining: temp6) global306)
					(and
						global306
						(== temp6 0)
						(not global265)
						(global859 spadeDanger:)
					)
				))
			(global306
				(= temp1
					(-
						(global859
							howManyLower: temp6 ((global310 at: 0) cardRank:)
						)
						(localproc_7 temp6 ((global310 at: 0) cardRank:))
					)
				)
				(= temp2 (- global448 1))
				(for
					((= temp7 (+ (gCardRoom currentPlayer:) 1)))
					(<= temp7 (+ (gCardRoom currentPlayer:) 3))
					((++ temp7))
					
					(= temp3
						(if (>= temp7 global448)
							(- temp7 global448)
						else
							temp7
						)
					)
					(if
						(and
							(not ((gPlayerList at: temp3) sittingOut:))
							((gPlayerList at: temp3) outOf: temp6)
						)
						(-- temp2)
					)
				)
				(if (> temp2 temp1)
					(= temp2 temp1)
				)
				(if (> (= temp5 (- temp2 temp1)) temp0)
					(= temp0 temp5)
					(= temp4 temp6)
				)
			)
		)
	)
	(if (== temp4 -1)
		(= global310 (global859 cardList:))
		(= temp0 99)
		(for ((= temp6 0)) (< temp6 (global310 size:)) ((++ temp6))
			(if (== (= temp9 ((global310 at: temp6) cardRank:)) 1)
				(= temp9 14)
			)
			(cond
				(global773
					(if (< temp9 temp0)
						(= temp0 temp9)
						(= temp8 (global310 at: temp6))
					)
				)
				((and (!= ((global310 at: temp6) cardSuit:) 3) (< temp9 temp0))
					(= temp0 temp9)
					(= temp8 (global310 at: temp6))
				)
			)
		)
		(if (== temp0 99)
			(for ((= temp6 0)) (< temp6 (global310 size:)) ((++ temp6))
				(if (== (= temp9 ((global310 at: temp6) cardRank:)) 1)
					(= temp9 14)
				)
				(if (< temp9 temp0)
					(= temp0 temp9)
					(= temp8 (global310 at: temp6))
				)
			)
		)
		(= temp4 (temp8 cardSuit:))
	)
	(global859 getSuitList: temp4)
	(global310 at: 0)
)

(procedure (localproc_7 param1 param2 &tmp temp0 temp1 temp2)
	(if (== param2 1)
		(= param2 14)
	)
	(for ((= temp0 (= temp1 0))) (< temp0 global306) ((++ temp0))
		(if (== (= temp2 ((global310 at: temp0) cardRank:)) 1)
			(= temp2 14)
		)
		(if (< temp2 param2)
			(++ temp1)
		)
	)
	(return temp1)
)

