;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 401)
(include sci.sh)
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
	local15
	local16
)

(class g of Card
	(properties
		frown 0
		startText 0
		setLen 0
		cardOnPile 0
		forceToX 0
		checkCard 0
		passTo 0
		passActor 0
		eastPass3 1
		countDeadWoodOfAKinds 0
		outOfClubs 0
		outOfDiamonds 0
		outOfHearts 0
		showPassCards 0
		passCards 0
	)
)

(class WL of List
	(properties)

	(method (setPassTo param1 &tmp temp0 temp1)
		(= temp1 (if argc param1 else self))
		(for ((= temp0 (- (temp1 size:) 1))) (>= temp0 0) ((-- temp0))
			(temp1 delete: (temp1 at: temp0))
		)
	)

	(method (addPassCards &tmp temp0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			((local13 howManyOfRank:) add: (self at: temp0))
		)
	)

	(method (westPass3 param1 param2 &tmp temp0)
		(for ((= temp0 0)) (< temp0 (self size:)) ((++ temp0))
			(if
				(and
					(== ((self at: temp0) setDeadWoodOfAKinds:) param1)
					(== ((self at: temp0) clearGroup:) param2)
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
		(= local12 (- (= local11 (self size:)) 1))
	)
)

(class GinRummyCardList of CardList
	(properties
		caller 0
		remaining 0
		setGroups 0
	)

	(method (base3GroupNum param1 &tmp [temp0 4])
		(if argc
			(= caller param1)
		)
		(Prints {arrange groups})
	)

	(procedure (localproc_0 param1 param2 param3 param4 param5)
		(setGroups opponent: param1)
		(if (>= argc 3)
			(setGroups highestDeadWood: param2 param3)
		)
		(if (>= argc 4)
			(setGroups highestDeadWood: param4 param5)
		)
		(setGroups bestDeadWood: fourOrMoreInGroup:)
		(return (not local8))
	)

	(method (base2GroupNum &tmp temp0 temp1 temp2 temp3)
		(self highestDeadWoodCard:)
		(= local8 1000)
		(self addAllToWorkingDeck:)
		(if (not local8)
			(return local8)
		)
		(= setGroups self)
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
				(self knockHand: 0)
			)
		)
		(caller carList: local8)
		(return local8)
	)

	(method (base1GroupNum &tmp [temp0 4])
		(Prints {mark runs})
	)

	(method (passedOnCard &tmp temp0 temp1)
		(= local0 0)
		(for ((= temp0 0)) (< temp0 (- size 2)) ((++ temp0))
			(if
				(and
					(==
						(= temp1 ((self at: temp0) setDeadWoodOfAKinds:))
						((self at: (+ temp0 1)) setDeadWoodOfAKinds:)
					)
					(== temp1 ((self at: (+ temp0 2)) setDeadWoodOfAKinds:))
				)
				((self at: temp0) passActor: (+ temp1 100))
				((self at: (+ temp0 1)) passActor: (+ temp1 100))
				((self at: (+ temp0 2)) passActor: (+ temp1 100))
				(= [local4 local0] 3)
				(if
					(and
						(< temp0 (- size 3))
						(== temp1 ((self at: (+ temp0 3)) setDeadWoodOfAKinds:))
					)
					((self at: (+ temp0 3))
						passActor: (+ temp1 100)
						passCards: 1
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

	(method (bonus &tmp temp0 temp1 temp2 temp3)
		(for ((= temp1 (= temp2 (= temp3 0)))) (< temp1 size) ((++ temp1))
			(= temp0 (self at: temp1))
			(temp0 eastPass3: (not (temp0 countDeadWoodOfAKinds:)))
			(temp0 outOfClubs: (temp0 countDeadWoodOfAKinds:))
			(if
				(and
					(not (temp0 outOfClubs:))
					(> (self defRating: temp1) temp2)
				)
				(= temp2 (self defRating: temp1))
				(= temp3 temp0)
			)
		)
		(caller group1List: temp2 group2List: temp3)
	)

	(method (highestDeadWood param1 param2 &tmp temp0 temp1)
		(for ((= temp0 (= temp1 0))) (< temp0 size) ((++ temp0))
			(if (== ((self at: temp0) passActor:) (+ param2 100))
				(++ temp1)
				(if (== param1 temp1)
					((self at: temp0) eastPass3: 1 countDeadWoodOfAKinds: 0)
					(return)
				)
			)
		)
	)

	(method (bestDeadWood &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp3 0)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(= temp2
				(switch temp0
					(0
						(caller numClubs:)
					)
					(1
						(caller numDiamonds:)
					)
					(2
						(caller numHearts:)
					)
					(3
						(caller heartsStrength:)
					)
				)
			)
			(if (>= (temp2 size:) 3)
				(for ((= temp1 0)) (<= temp1 (- (temp2 size:) 3)) ((++ temp1))
					(cond
						(
							(and
								((temp2 at: temp1) eastPass3:)
								((temp2 at: (+ temp1 1)) eastPass3:)
								((temp2 at: (+ temp1 2)) eastPass3:)
								(==
									(temp2 northPass2: temp1)
									(- (temp2 northPass2: (+ temp1 1)) 1)
								)
								(==
									(temp2 northPass2: temp1)
									(- (temp2 northPass2: (+ temp1 2)) 2)
								)
							)
							(= temp4 1)
							((temp2 at: temp1) eastPass3: -1)
							((temp2 at: (+ temp1 1)) eastPass3: -1)
							((temp2 at: (+ temp1 2)) eastPass3: -1)
							((temp2 at: temp1)
								countDeadWoodOfAKinds:
									(+ ((temp2 at: temp1) passTo:) temp3)
							)
							((temp2 at: (+ temp1 1))
								countDeadWoodOfAKinds:
									(+ ((temp2 at: (+ temp1 1)) passTo:) temp3)
							)
							((temp2 at: (+ temp1 2))
								countDeadWoodOfAKinds:
									(+ ((temp2 at: (+ temp1 2)) passTo:) temp3)
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
			(if (== ((self at: temp0) eastPass3:) -1)
				((self at: temp0) eastPass3: 0)
			)
		)
	)

	(method (thinkDiscard param1 param2 &tmp temp0 [temp1 2] temp3)
		(if (param2 size:)
			(cond
				((> (= temp0 ((param2 at: 0) countDeadWoodOfAKinds:)) 100)
					(if
						(and
							(==
								(param1 setDeadWoodOfAKinds:)
								((param2 at: 0) setDeadWoodOfAKinds:)
							)
							(not (param1 countDeadWoodOfAKinds:))
						)
						(param1 outOfDiamonds: param2)
					)
				)
				(
					(and
						temp0
						(== (param1 clearGroup:) ((param2 at: 0) clearGroup:))
						(not (param1 countDeadWoodOfAKinds:))
					)
					(if
						(or
							(==
								(+ (param1 setDeadWoodOfAKinds:) 1)
								((param2 at: 0) setDeadWoodOfAKinds:)
							)
							(==
								(- (param1 setDeadWoodOfAKinds:) 1)
								((param2 at: (- (param2 size:) 1))
									setDeadWoodOfAKinds:
								)
							)
						)
						(param1 outOfDiamonds: param2)
					)
					(if
						(or
							(and
								(==
									(+ (param1 setDeadWoodOfAKinds:) 2)
									((param2 at: 0) setDeadWoodOfAKinds:)
								)
								(>=
									(= temp3
										(self
											westPass3:
												(+
													(param1
														setDeadWoodOfAKinds:
													)
													1
												)
												(param1 clearGroup:)
										)
									)
									0
								)
								(< temp3 size)
								(not ((self at: temp3) countDeadWoodOfAKinds:))
							)
							(and
								(==
									(- (param1 setDeadWoodOfAKinds:) 2)
									((param2 at: (- (param2 size:) 1))
										setDeadWoodOfAKinds:
									)
								)
								(>=
									(= temp3
										(self
											westPass3:
												(-
													(param1
														setDeadWoodOfAKinds:
													)
													1
												)
												(param1 clearGroup:)
										)
									)
									0
								)
								(< temp3 size)
								(not ((self at: temp3) countDeadWoodOfAKinds:))
							)
						)
						(param1 outOfDiamonds: param2)
					)
				)
			)
		)
	)

	(method (fourOrMoreInGroup &tmp temp0 temp1 temp2 temp3)
		(self eachElementDo: #outOfDiamonds 0)
		(= remaining (if (== caller local14) local15 else local14))
		(= temp2 0)
		(for ((= temp1 0)) (< temp1 size) ((++ temp1))
			(if ((= temp0 (self at: temp1)) eastPass3:)
				(if (and local16 (!= local16 caller) (local16 carList:))
					(temp0 outOfDiamonds: 0)
					(self
						thinkDiscard: temp0 (remaining playerAcross:)
						thinkDiscard: temp0 (remaining pointsTaken:)
						thinkDiscard: temp0 (remaining passCardsX:)
					)
					(if (not (temp0 outOfDiamonds:))
						(+= temp2 (self defRating: temp1))
					)
				else
					(+= temp2 (self defRating: temp1))
				)
			)
		)
		(if (<= temp2 local8)
			(= local8 temp2)
			(self bonus:)
		)
	)

	(method (addAllToWorkingDeck &tmp temp0 temp1 temp2)
		(self handsWon:)
		(for ((= temp1 0)) (< temp1 size) ((++ temp1))
			(= temp0 (self at: temp1))
			(temp0
				eastPass3: (== (temp0 passTo:) 0)
				countDeadWoodOfAKinds: (temp0 passTo:)
			)
		)
		(self fourOrMoreInGroup:)
	)

	(method (knockHand &tmp temp0 temp1 temp2)
		(self handsWon:)
		(for ((= temp1 0)) (< temp1 size) ((++ temp1))
			(= temp0 (self at: temp1))
			(temp0
				eastPass3: (== (temp0 passActor:) 0)
				countDeadWoodOfAKinds: (temp0 passActor:)
			)
		)
		(self fourOrMoreInGroup:)
	)

	(method (opponent param1 &tmp temp0 temp1 temp2)
		(self handsWon:)
		(for ((= temp1 0)) (< temp1 size) ((++ temp1))
			((= temp0 (self at: temp1)) eastPass3: 1)
			(cond
				((== param1 0)
					(if (temp0 passActor:)
						(temp0
							eastPass3: 0
							countDeadWoodOfAKinds: (temp0 passActor:)
						)
					)
				)
				((== (temp0 passActor:) (+ param1 100))
					(temp0
						eastPass3: 0
						countDeadWoodOfAKinds: ((self at: temp1) passActor:)
					)
				)
			)
		)
	)

	(method (defRating param1 &tmp temp0)
		(if (> (= temp0 ((self at: param1) setDeadWoodOfAKinds:)) 10)
			(= temp0 10)
		)
		(return temp0)
	)

	(method (offRating)
		(self eachElementDo: #passTo 0)
	)

	(method (handsWon)
		(self
			eachElementDo: #countDeadWoodOfAKinds 0
			eachElementDo: #outOfDiamonds 0
		)
	)

	(method (highestDeadWoodCard)
		(self eachElementDo: #outOfClubs 0)
	)

	(method (northPass2 param1)
		((self at: param1) setDeadWoodOfAKinds:)
	)

	(method (northPass3 param1)
		((self at: param1) clearGroup:)
	)

	(method (eastPass1 param1 &tmp temp0 temp1)
		(if size
			(for ((= temp0 (= temp1 0))) (< temp0 size) ((++ temp0))
				(if (== (self northPass3: temp0) param1)
					(++ temp1)
				)
			)
			(return temp1)
		)
	)

	(method (atSuit param1 &tmp temp0 temp1)
		(if size
			(for ((= temp0 (= temp1 0))) (< temp0 size) ((++ temp0))
				(if (== (self northPass2: temp0) param1)
					(++ temp1)
				)
			)
			(return temp1)
		)
	)

	(method (howManyOfSuit param1 &tmp temp0 temp1 temp2)
		(= temp2 (GinRummyCardList new:))
		(for ((= temp1 1)) (< temp1 14) ((++ temp1))
			(for ((= temp0 0)) (< temp0 size) ((++ temp0))
				(if
					(and
						(== (self northPass2: temp0) temp1)
						(== (self northPass3: temp0) param1)
					)
					(temp2 add: (self at: temp0))
					(break)
				)
			)
		)
		(= local10 (- (= local9 (temp2 size:)) 1))
		(return temp2)
	)

	(method (outOf param1 param2)
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

	(method (westPass3 param1 param2 &tmp temp0)
		(if (< 0 param1 14)
			(for ((= temp0 0)) (< temp0 size) ((++ temp0))
				(if
					(and
						(== ((self at: temp0) setDeadWoodOfAKinds:) param1)
						(== ((self at: temp0) clearGroup:) param2)
					)
					(return temp0)
				)
			)
		)
		(return -1)
	)
)

