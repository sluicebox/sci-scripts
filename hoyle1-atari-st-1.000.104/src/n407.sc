;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 407)
(include sci.sh)
(use Main)

(public
	proc407_0 0
)

(procedure (proc407_0 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13)
	(= temp0 (param1 cardList:))
	(for ((= temp1 0)) (< temp1 (gGinRummyCardList size:)) ((++ temp1))
		(= temp6 0)
		(= temp4 ((= temp2 (gGinRummyCardList at: temp1)) cardRank:))
		(= temp5 (temp2 cardSuit:))
		(= temp7 0)
		(if
			(and
				(!= temp4 13)
				(== (temp0 hasCard: (+ temp4 1) temp5) -1)
				(not (gDeck isCardInWorkingDeck: (+ temp4 1) temp5))
			)
			(= temp7 1)
			(++ temp6)
		)
		(= temp8 0)
		(if
			(and
				(!= temp4 1)
				(== (temp0 hasCard: (- temp4 1) temp5) -1)
				(not (gDeck isCardInWorkingDeck: (- temp4 1) temp5))
			)
			(= temp8 1)
			(++ temp6)
		)
		(if
			(==
				(= temp3
					(-
						(= temp3 (- (= temp3 4) (temp0 howManyOfRank: temp4)))
						(gDeck numInWorkingDeck: (temp2 cardRank:))
					)
				)
				3
			)
			(+= temp6 2)
		)
		(if (== temp3 2)
			(++ temp6)
		)
		(if (<= temp4 3)
			(+= temp6 (- 4 temp4))
		)
		(if (>= temp4 8)
			(-- temp6)
		)
		(= temp3 (gKnownCards howManyOfRank: temp4 1))
		(= temp10 (gKnownCards hasCard: (- temp4 1) temp5))
		(= temp12 (gKnownCards hasCard: (- temp4 2) temp5))
		(= temp11 (gKnownCards hasCard: (+ temp4 1) temp5))
		(= temp13 (gKnownCards hasCard: (+ temp4 2) temp5))
		(= temp9
			(+ (gDeck numInWorkingDeck: temp4) (temp0 howManyOfRank: temp4))
		)
		(if (and (== temp3 1) (< (gKnownCards size:) 10))
			(if (== temp9 2)
				(+= temp6 2)
			else
				(+= temp6 4)
			)
		)
		(if (>= temp3 2)
			(= temp6 16)
		)
		(if (== global775 2)
			(if (>= temp10 0)
				(cond
					((>= temp12 0)
						(= temp6 16)
					)
					((>= temp11 0)
						(= temp6 16)
					)
					(else
						(if
							(and
								(not
									(gDeck
										isCardInWorkingDeck: (- temp4 2) temp5
									)
								)
								(== (temp0 hasCard: (- temp4 2) temp5) -1)
							)
							(+= temp6 2)
						)
						(if temp7
							(+= temp6 2)
						)
					)
				)
			)
			(if (>= temp11 0)
				(cond
					((>= temp13 0)
						(= temp6 16)
					)
					((>= temp10 0)
						(= temp6 16)
					)
					(else
						(if
							(and
								(not
									(gDeck
										isCardInWorkingDeck: (+ temp4 2) temp5
									)
								)
								(== (temp0 hasCard: (+ temp4 2) temp5) -1)
							)
							(+= temp6 2)
						)
						(if temp8
							(+= temp6 2)
						)
					)
				)
			)
			(if (!= temp6 16)
				(if (>= temp12 0)
					(+= temp6 1)
					(if temp8
						(+= temp6 1)
					)
				)
				(if (>= temp13 0)
					(+= temp6 1)
					(if temp7
						(+= temp6 1)
					)
				)
			)
		)
		(if (== temp1 (- (temp0 size:) 1))
			(temp2 defRating: 15)
		)
		(temp2 offRating: (+ (temp2 offRating:) (/ temp6 5)) defRating: temp6)
	)
)

