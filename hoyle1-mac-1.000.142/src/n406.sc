;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 406)
(include sci.sh)
(use Main)

(public
	proc406_0 0
)

(procedure (proc406_0 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
	(= temp0 (param1 cardList:))
	(gGinRummyCardList eachElementDo: #offRating 0)
	(for ((= temp5 0)) (< temp5 (gGinRummyCardList size:)) ((++ temp5))
		(= temp3 ((= temp2 (gGinRummyCardList at: temp5)) cardRank:))
		(= temp4 (temp2 cardSuit:))
		(if (temp2 rating:)
			(for
				((= temp6 (= temp1 0)))
				(< temp6 (gGinRummyCardList size:))
				((++ temp6))
				
				(if (== ((gGinRummyCardList at: temp6) cardRank:) temp3)
					(++ temp1)
				)
			)
			(if (== temp1 2)
				(temp2
					offRating:
						(+
							(temp2 offRating:)
							(- 2 (gDeck numInWorkingDeck: temp3))
						)
				)
			)
			(if
				(and
					(> temp3 2)
					(> (= temp9 (temp0 hasCard: (- temp3 1) temp4)) -1)
					(or
						(not ((temp0 at: temp9) bestGroup:))
						(==
							(temp0 howManyOfRank: ((temp0 at: temp9) cardRank:))
							4
						)
					)
				)
				(temp2
					offRating:
						(+
							(temp2 offRating:)
							(= temp8
								(-
									1
									(gDeck
										isCardInWorkingDeck: (- temp3 2) temp4
									)
								)
							)
						)
				)
				(if (< temp3 13)
					(temp2
						offRating:
							(+
								(temp2 offRating:)
								(= temp8
									(-
										1
										(gDeck
											isCardInWorkingDeck:
												(+ temp3 1)
												temp4
										)
									)
								)
							)
					)
				)
			)
			(if
				(and
					(< temp3 12)
					(> (= temp9 (temp0 hasCard: (+ temp3 1) temp4)) -1)
					(or
						(not ((temp0 at: temp9) bestGroup:))
						(==
							(temp0 howManyOfRank: ((temp0 at: temp9) cardRank:))
							4
						)
					)
				)
				(temp2
					offRating:
						(+
							(temp2 offRating:)
							(= temp8
								(-
									1
									(gDeck
										isCardInWorkingDeck: (+ temp3 2) temp4
									)
								)
							)
						)
				)
				(if (> temp3 1)
					(temp2
						offRating:
							(+
								(temp2 offRating:)
								(= temp8
									(-
										1
										(gDeck
											isCardInWorkingDeck:
												(- temp3 1)
												temp4
										)
									)
								)
							)
					)
				)
			)
			(if (== global775 0)
				(return)
			)
			(if
				(and
					(> temp3 2)
					(> (= temp9 (temp0 hasCard: (- temp3 2) temp4)) -1)
					(or
						(not ((temp0 at: temp9) bestGroup:))
						(==
							(temp0 howManyOfRank: ((temp0 at: temp9) cardRank:))
							4
						)
					)
				)
				(temp2
					offRating:
						(+
							(temp2 offRating:)
							(= temp8
								(-
									1
									(gDeck
										isCardInWorkingDeck: (- temp3 1) temp4
									)
								)
							)
						)
				)
			)
			(if
				(and
					(< temp3 12)
					(> (= temp9 (temp0 hasCard: (+ temp3 2) temp4)) -1)
					(or
						(not ((temp0 at: temp9) bestGroup:))
						(==
							(temp0 howManyOfRank: ((temp0 at: temp9) cardRank:))
							4
						)
					)
				)
				(temp2
					offRating:
						(+
							(temp2 offRating:)
							(= temp8
								(-
									1
									(gDeck
										isCardInWorkingDeck: (+ temp3 1) temp4
									)
								)
							)
						)
				)
			)
			(if (<= temp3 3)
				(temp2 offRating: (+ (temp2 offRating:) (- 4 temp3)))
			)
			(if
				(or
					(and (> global428 4) (>= temp3 10))
					(and (> global428 5) (>= temp3 9))
					(and (> global428 6) (>= temp3 8))
					(and (> global428 7) (>= temp3 7))
				)
				(temp2 offRating: (- (temp2 offRating:) (- global428 4)))
			)
		)
	)
)

