;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 401)
(include sci.sh)
(use Main)
(use Piles)
(use Print)
(use System)

(local
	local0
	[local1 3]
	[local4 4]
	local8
	local9
	local10
	local11
	local12
	local13
	local14
)

(class g of Card
	(properties
		inARun 0
		ofAKind 0
		rating 1
		group 0
		bestGroup 0
		playOff 0
		offRating 0
		defRating 0
		fourOrMoreInGroup 0
	)
)

(class WL of List
	(properties)

	(method (empty param1 &tmp temp0 temp1)
		(= temp1 (if argc param1 else self))
		(for ((= temp0 (- (temp1 size:) 1))) (>= temp0 0) ((-- temp0))
			(temp1 delete: (temp1 at: temp0))
		)
	)

	(method (addAllToWorkingDeck &tmp temp0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			((local11 workingDeck:) add: (self at: temp0))
		)
	)

	(method (hasCard param1 param2 &tmp temp0)
		(for ((= temp0 0)) (< temp0 (self size:)) ((++ temp0))
			(if
				(and
					(== ((self at: temp0) cardRank:) param1)
					(== ((self at: temp0) cardSuit:) param2)
				)
				(return temp0)
			)
		)
		(return -1)
	)
)

(class CardList of WL
	(properties)

	(method (setSize)
		(Prints {setSize})
		(= local10 (- (= local9 (self size:)) 1))
	)
)

(class GinRummyCardList of CardList
	(properties
		caller 0
		opponent 0
		whoItIs 0
	)

	(method (arrangeGroups param1 &tmp [temp0 4])
		(if argc
			(= caller param1)
		)
		(Prints {arrange groups})
	)

	(procedure (localproc_0 param1 param2 param3 param4 param5)
		(whoItIs setDeadWoodOfAKinds: param1)
		(if (>= argc 3)
			(whoItIs setCardRating: param2 param3)
		)
		(if (>= argc 4)
			(whoItIs setCardRating: param4 param5)
		)
		(whoItIs calcRuns: countDeadWood:)
		(return (not local8))
	)

	(method (findBestGroup &tmp temp0 temp1 temp2 temp3)
		(self clearBestGroup:)
		(= local8 1000)
		(self countDeadWoodRuns:)
		(if (not local8)
			(return local8)
		)
		(= whoItIs self)
		(switch local0
			(1
				(if (== local4 3)
					(if (localproc_0 0)
						(return local8)
					)
				else
					(for ((= temp1 1)) (< temp1 5) ((++ temp1))
						(if (localproc_0 0 temp1 local1)
							(return local8)
						)
					)
					(if (localproc_0 0)
						(return local8)
					)
				)
			)
			(2
				(for ((= temp0 0)) (< temp0 2) ((++ temp0))
					(if (== [local4 temp0] 3)
						(if (localproc_0 [local1 temp0])
							(return local8)
						)
					else
						(for ((= temp1 1)) (< temp1 5) ((++ temp1))
							(if
								(localproc_0
									[local1 temp0]
									temp1
									[local1 temp0]
								)
								(return local8)
							)
						)
						(if (localproc_0 [local1 temp0])
							(return local8)
						)
					)
				)
				(cond
					((== (+ local4 [local4 1]) 7)
						(= temp3 (if (== local4 4) 0 else 1))
						(for ((= temp1 1)) (< temp1 5) ((++ temp1))
							(if (localproc_0 0 temp1 [local1 temp3])
								(return local8)
							)
						)
					)
					((== (+ local4 [local4 1]) 8)
						(for ((= temp1 1)) (< temp1 5) ((++ temp1))
							(for ((= temp2 1)) (< temp2 5) ((++ temp2))
								(if
									(localproc_0
										0
										temp1
										local1
										temp2
										[local1 1]
									)
									(return local8)
								)
							)
						)
						(for ((= temp0 0)) (< temp0 2) ((++ temp0))
							(for ((= temp1 1)) (< temp1 5) ((++ temp1))
								(if (localproc_0 0 temp1 [local1 temp0])
									(return local8)
								)
							)
						)
					)
				)
				(if (localproc_0 0)
					(return local8)
				)
			)
			(3
				(self countDeadWoodOfAKinds: 0)
			)
		)
		(caller bestDeadWood: local8)
		(return local8)
	)

	(method (markRuns &tmp [temp0 4])
		(Prints {mark runs})
	)

	(method (findAllOfAKinds &tmp temp0 temp1)
		(= local0 0)
		(for ((= temp0 0)) (< temp0 (- size 2)) ((++ temp0))
			(if
				(and
					(==
						(= temp1 ((self at: temp0) cardRank:))
						((self at: (+ temp0 1)) cardRank:)
					)
					(== temp1 ((self at: (+ temp0 2)) cardRank:))
				)
				((self at: temp0) ofAKind: (+ temp1 100))
				((self at: (+ temp0 1)) ofAKind: (+ temp1 100))
				((self at: (+ temp0 2)) ofAKind: (+ temp1 100))
				(= [local4 local0] 3)
				(if
					(and
						(< temp0 (- size 3))
						(== temp1 ((self at: (+ temp0 3)) cardRank:))
					)
					((self at: (+ temp0 3))
						ofAKind: (+ temp1 100)
						fourOrMoreInGroup: 1
					)
					(++ temp0)
					(= [local4 local0] 4)
				)
				(+= temp0 2)
				(= [local1 local0] temp1)
				(++ local0)
			)
		)
	)

	(method (setGroups &tmp temp0 temp1 temp2 temp3)
		(for ((= temp1 (= temp2 (= temp3 0)))) (< temp1 size) ((++ temp1))
			(= temp0 (self at: temp1))
			(temp0 rating: (not (temp0 group:)))
			(temp0 bestGroup: (temp0 group:))
			(if (and (not (temp0 bestGroup:)) (> (self atValue: temp1) temp2))
				(= temp2 (self atValue: temp1))
				(= temp3 temp0)
			)
		)
		(caller highestDeadWood: temp2 highestDeadWoodCard: temp3)
	)

	(method (setCardRating param1 param2 &tmp temp0 temp1)
		(for ((= temp0 (= temp1 0))) (< temp0 size) ((++ temp0))
			(if (== ((self at: temp0) ofAKind:) (+ param2 100))
				(++ temp1)
				(if (== param1 temp1)
					((self at: temp0) rating: 1 group: 0)
					(return)
				)
			)
		)
	)

	(method (calcRuns &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp3 0)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(= temp2
				(switch temp0
					(0
						(caller spadesList:)
					)
					(1
						(caller clubsList:)
					)
					(2
						(caller diamondsList:)
					)
					(3
						(caller heartsList:)
					)
				)
			)
			(if (>= (temp2 size:) 3)
				(for ((= temp1 0)) (<= temp1 (- (temp2 size:) 3)) ((++ temp1))
					(cond
						(
							(and
								((temp2 at: temp1) rating:)
								((temp2 at: (+ temp1 1)) rating:)
								((temp2 at: (+ temp1 2)) rating:)
								(==
									(temp2 atRank: temp1)
									(- (temp2 atRank: (+ temp1 1)) 1)
								)
								(==
									(temp2 atRank: temp1)
									(- (temp2 atRank: (+ temp1 2)) 2)
								)
							)
							(= temp4 1)
							((temp2 at: temp1) rating: -1)
							((temp2 at: (+ temp1 1)) rating: -1)
							((temp2 at: (+ temp1 2)) rating: -1)
							((temp2 at: temp1)
								group: (+ ((temp2 at: temp1) inARun:) temp3)
							)
							((temp2 at: (+ temp1 1))
								group:
									(+ ((temp2 at: (+ temp1 1)) inARun:) temp3)
							)
							((temp2 at: (+ temp1 2))
								group:
									(+ ((temp2 at: (+ temp1 2)) inARun:) temp3)
							)
						)
						(temp4 ; UNINIT
							(+= temp3 10)
							(= temp4 0)
						)
					)
				)
			)
		)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if (== ((self at: temp0) rating:) -1)
				((self at: temp0) rating: 0)
			)
		)
	)

	(method (tryToPlayOffCard param1 param2 &tmp temp0 [temp1 2] temp3)
		(if (param2 size:)
			(cond
				((> (= temp0 ((param2 at: 0) group:)) 100)
					(if
						(and
							(== (param1 cardRank:) ((param2 at: 0) cardRank:))
							(not (param1 group:))
						)
						(param1 playOff: param2)
					)
				)
				(
					(and
						temp0
						(== (param1 cardSuit:) ((param2 at: 0) cardSuit:))
						(not (param1 group:))
					)
					(if
						(or
							(==
								(+ (param1 cardRank:) 1)
								((param2 at: 0) cardRank:)
							)
							(==
								(- (param1 cardRank:) 1)
								((param2 at: (- (param2 size:) 1)) cardRank:)
							)
						)
						(param1 playOff: param2)
					)
					(if
						(or
							(and
								(==
									(+ (param1 cardRank:) 2)
									((param2 at: 0) cardRank:)
								)
								(>=
									(= temp3
										(self
											hasCard:
												(+ (param1 cardRank:) 1)
												(param1 cardSuit:)
										)
									)
									0
								)
								(< temp3 size)
								(not ((self at: temp3) group:))
							)
							(and
								(==
									(- (param1 cardRank:) 2)
									((param2 at: (- (param2 size:) 1))
										cardRank:
									)
								)
								(>=
									(= temp3
										(self
											hasCard:
												(- (param1 cardRank:) 1)
												(param1 cardSuit:)
										)
									)
									0
								)
								(< temp3 size)
								(not ((self at: temp3) group:))
							)
						)
						(param1 playOff: param2)
					)
				)
			)
		)
	)

	(method (countDeadWood &tmp temp0 temp1 temp2 temp3)
		(self eachElementDo: #playOff 0)
		(= opponent (if (== caller local12) local13 else local12))
		(= temp2 0)
		(for ((= temp1 0)) (< temp1 size) ((++ temp1))
			(if ((= temp0 (self at: temp1)) rating:)
				(if (and local14 (!= local14 caller) (local14 bestDeadWood:))
					(temp0 playOff: 0)
					(self
						tryToPlayOffCard: temp0 (opponent group1List:)
						tryToPlayOffCard: temp0 (opponent group2List:)
						tryToPlayOffCard: temp0 (opponent group3List:)
					)
					(if (not (temp0 playOff:))
						(+= temp2 (self atValue: temp1))
					)
				else
					(+= temp2 (self atValue: temp1))
				)
			)
		)
		(if (<= temp2 local8)
			(= local8 temp2)
			(self setGroups:)
		)
	)

	(method (countDeadWoodRuns &tmp temp0 temp1 temp2)
		(self clearGroup:)
		(for ((= temp1 0)) (< temp1 size) ((++ temp1))
			(= temp0 (self at: temp1))
			(temp0 rating: (== (temp0 inARun:) 0) group: (temp0 inARun:))
		)
		(self countDeadWood:)
	)

	(method (countDeadWoodOfAKinds &tmp temp0 temp1 temp2)
		(self clearGroup:)
		(for ((= temp1 0)) (< temp1 size) ((++ temp1))
			(= temp0 (self at: temp1))
			(temp0 rating: (== (temp0 ofAKind:) 0) group: (temp0 ofAKind:))
		)
		(self countDeadWood:)
	)

	(method (setDeadWoodOfAKinds param1 &tmp temp0 temp1 temp2)
		(self clearGroup:)
		(for ((= temp1 0)) (< temp1 size) ((++ temp1))
			((= temp0 (self at: temp1)) rating: 1)
			(cond
				((== param1 0)
					(if (temp0 ofAKind:)
						(temp0 rating: 0 group: (temp0 ofAKind:))
					)
				)
				((== (temp0 ofAKind:) (+ param1 100))
					(temp0 rating: 0 group: ((self at: temp1) ofAKind:))
				)
			)
		)
	)

	(method (atValue param1 &tmp temp0)
		(if (> (= temp0 ((self at: param1) cardRank:)) 10)
			(= temp0 10)
		)
		(return temp0)
	)

	(method (clearMarks)
		(self eachElementDo: #inARun 0)
	)

	(method (clearGroup)
		(self eachElementDo: #group 0 eachElementDo: #playOff 0)
	)

	(method (clearBestGroup)
		(self eachElementDo: #bestGroup 0)
	)

	(method (atRank param1)
		((self at: param1) cardRank:)
	)

	(method (atSuit param1)
		((self at: param1) cardSuit:)
	)

	(method (howManyOfSuit param1 &tmp temp0 temp1)
		(if size
			(for ((= temp0 (= temp1 0))) (< temp0 size) ((++ temp0))
				(if (== (self atSuit: temp0) param1)
					(++ temp1)
				)
			)
			(return temp1)
		)
	)

	(method (howManyOfRank param1 &tmp temp0 temp1)
		(if size
			(for ((= temp0 (= temp1 0))) (< temp0 size) ((++ temp0))
				(if (== (self atRank: temp0) param1)
					(++ temp1)
				)
			)
			(return temp1)
		)
	)

	(method (makeSuitList param1 &tmp temp0 temp1 temp2)
		(= temp2 (GinRummyCardList new:))
		(for ((= temp1 1)) (< temp1 14) ((++ temp1))
			(for ((= temp0 0)) (< temp0 size) ((++ temp0))
				(if
					(and
						(== (self atRank: temp0) temp1)
						(== (self atSuit: temp0) param1)
					)
					(temp2 add: (self at: temp0))
					(break)
				)
			)
		)
		(= global505 (- (= global504 (temp2 size:)) 1))
		(return temp2)
	)

	(method (adjustList param1 param2)
		(if (not param1)
			(self addToFront: (self at: (- param2 1)))
		else
			(self addAfter: (self at: (- param1 1)) (self at: (- param2 1)))
		)
		(self
			delete:
				(self
					at:
						(if (< param1 param2)
							param2
						else
							(- param2 1)
						)
				)
		)
	)

	(method (hasCard param1 param2 &tmp temp0)
		(if (< 0 param1 14)
			(for ((= temp0 0)) (< temp0 size) ((++ temp0))
				(if
					(and
						(== ((self at: temp0) cardRank:) param1)
						(== ((self at: temp0) cardSuit:) param2)
					)
					(return temp0)
				)
			)
		)
		(return -1)
	)
)

