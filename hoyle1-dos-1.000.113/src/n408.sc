;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 408)
(include sci.sh)
(use Main)
(use g)

(public
	proc408_0 0
)

(procedure (proc408_0 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
	(if (== (gDeck upCardView:) (param1 passedOnCard:))
		(param1 passedOnCard: 0)
		(return 0)
	)
	(= temp7 ((gDeck upCardView:) cardRank:))
	(for
		((= temp2 (= temp4 0)))
		(< temp2 ((param1 cardList:) size:))
		((++ temp2))
		
		(= temp0 ((param1 cardList:) at: temp2))
		(if
			(and
				(== (temp0 cardRank:) temp7)
				(or (not (temp0 bestGroup:)) (> (temp0 bestGroup:) 100))
			)
			(++ temp4)
		)
	)
	(if (>= temp4 2)
		(return 1)
	else
		(= temp5
			((param1 cardList:)
				makeSuitList: ((gDeck upCardView:) cardSuit:)
			)
		)
		(for ((= temp2 0)) (< temp2 ((param1 cardList:) size:)) ((++ temp2))
			(= temp0 ((param1 cardList:) at: temp2))
			(if
				(and
					(== (temp0 cardSuit:) ((gDeck upCardView:) cardSuit:))
					(> (temp0 bestGroup:) 100)
				)
				(temp5 delete: temp0)
			)
		)
		(for ((= temp2 (= temp6 0))) (< temp2 (temp5 size:)) ((++ temp2))
			(if (> ((temp5 at: temp2) cardRank:) temp7)
				(if temp2
					(temp5
						addAfter:
							(temp5 at: (- temp2 1))
							(gDeck upCardView:)
					)
				else
					(temp5 addToFront: (gDeck upCardView:))
				)
				(break)
			)
		)
		(if (not temp6)
			(temp5 add: (gDeck upCardView:))
		)
		(temp5 eachElementDo: #rating 0)
		(for ((= temp2 0)) (< temp2 (- (temp5 size:) 2)) ((++ temp2))
			(= temp0 (temp5 at: temp2))
			(if
				(and
					(==
						(+ (temp0 cardRank:) 1)
						((temp5 at: (+ temp2 1)) cardRank:)
					)
					(==
						(+ (temp0 cardRank:) 2)
						((temp5 at: (+ temp2 2)) cardRank:)
					)
				)
				(temp0 rating: 1)
				((temp5 at: (+ temp2 1)) rating: 1)
				((temp5 at: (+ temp2 2)) rating: 1)
			)
		)
		(temp5 empty: dispose:)
		(if ((gDeck upCardView:) rating:)
			(return 1)
		)
	)
	(if (and (== global428 1) (!= (gPlayerList at: 0) param1))
		(param1 calcGroups:)
		(if (= temp4 ((param1 cardList:) howManyOfRank: temp7))
			(for ((= temp1 0)) (< temp1 ((param1 cardList:) size:)) ((++ temp1))
				(if
					(and
						(== (((param1 cardList:) at: temp1) cardRank:) temp7)
						(((param1 cardList:) at: temp1) bestGroup:)
					)
					(-- temp4)
				)
			)
		)
		(if (<= temp7 3)
			(return (Random 0 (- 4 temp7)))
		)
		(if
			(and
				(<= temp7 8)
				(or
					temp4
					(and
						(>
							(= temp1
								((param1 cardList:)
									hasCard:
										(- temp7 1)
										((gDeck upCardView:) cardSuit:)
								)
							)
							-1
						)
						(not (((param1 cardList:) at: temp1) bestGroup:))
					)
					(and
						(>
							(= temp1
								((param1 cardList:)
									hasCard:
										(+ temp7 1)
										((gDeck upCardView:) cardSuit:)
								)
							)
							-1
						)
						(not (((param1 cardList:) at: temp1) bestGroup:))
					)
				)
			)
			(return 1)
		)
	)
	(if
		(and
			(< temp7 8)
			(<=
				(- (param1 bestDeadWood:) (- (param1 highestDeadWood:) temp7))
				param2
			)
		)
		(return 1)
	)
	(if (>= global428 3)
		(param1 deadWoodList: (GinRummyCardList new:))
		(for ((= temp1 0)) (< temp1 ((param1 cardList:) size:)) ((++ temp1))
			(if (not (((param1 cardList:) at: temp1) bestGroup:))
				((param1 deadWoodList:) add: ((param1 cardList:) at: temp1))
			)
		)
		(if
			(and
				(== ((param1 deadWoodList:) size:) 2)
				((param1 deadWoodList:) howManyOfRank: temp7)
				(<=
					(+
						(gDeck numInWorkingDeck: temp7)
						(gKnownCards howManyOfRank: temp7)
					)
					2
				)
			)
			((param1 deadWoodList:) empty: dispose:)
			(return 1)
		)
		((param1 deadWoodList:) empty: dispose:)
	)
	(param1 deadWoodList: 0)
	(return 0)
)

