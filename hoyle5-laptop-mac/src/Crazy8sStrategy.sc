;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 170)
(include sci.sh)
(use Main)
(use Piles)
(use System)

(local
	[local0 4]
	[local4 14]
	[local18 31]
)

(class Crazy8sStrategy of Code
	(properties
		skill 2
		totalPlayable 0
		numEights 0
		numRanks 0
		numSuits 0
		eightPlayed 0
		newSuitChosen 0
		fewestCount 0
		nextPlayer 0
		prePlayer 0
		numTwos 0
		numKings 0
		safetyDraw 0
		cardList 0
	)

	(method (think param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= cardList param1)
		(= skill [global195 (- (global117 at: cardList) 1)])
		(= safetyDraw (cardList tookCard:))
		(= temp0
			(= numKings
				(= numTwos (= fewestCount (= prePlayer (= nextPlayer 0))))
			)
		)
		(= temp3 (Piles at: 0))
		(= temp8 0)
		(if (== global223 1)
			(= temp8 (OneOf (temp3 condition:) 2 4 6 8))
		)
		(self setUpArrays:)
		(= temp6 0)
		(= temp2 0)
		(= temp4 1)
		(while (< temp2 (cardList size:))
			(= temp7 (cardList at: temp2))
			(temp7 valid: (temp3 isValid: temp7))
			(if (and temp4 (temp7 valid:))
				(= temp4 0)
				(= temp6 temp7)
			)
			(++ temp2)
		)
		(self countCards:)
		(if (not totalPlayable)
			(cardList tookCard: 0)
			(return 0)
		)
		(if (== numEights totalPlayable)
			(return (self chooseEights:))
		)
		(if temp4
			(return 0)
		else
			(self findNext:)
			(self findPrev:)
			(if (and numEights (== skill 2) (self doEightCode:))
				(return (self chooseEights:))
			)
			(if (and (not temp8) (== global223 1))
				(= temp7 0)
				(if (= temp7 (self checkForValid: 12 0))
					(= temp0 (self doQueenCode: temp7))
				)
				(if (and (not temp0) (= temp7 (self checkForValid: 2 -1)))
					(= temp0 (self doTwoCode: temp7))
				)
				(if (and (not temp0) (= temp7 (self checkForValid: 11)))
					(= temp0 (self doJackCode: temp7))
				)
				(if (and (not temp0) (= temp7 (self checkForValid: 13)))
					(= temp0 (self doKingCode: temp7))
				)
				(if (not totalPlayable)
					(return 0)
				)
				(if (and (not temp0) (== numEights totalPlayable))
					(return (self chooseEights:))
				)
			)
			(if temp0
				(return temp0)
			)
			(= temp5 0)
			(cond
				((== skill 0)
					(while
						(not
							((= temp0
									(cardList
										at: (Random 0 (- (cardList size:) 1))
									)
								)
								valid:
							)
						)
						(if (> (++ temp5) 200)
							(= temp0 temp6)
							(break)
						)
					)
				)
				((== skill 1)
					(cond
						((and (> numRanks 0) (== (Random 0 1) 1))
							(= temp0 (self chooseRanks:))
						)
						((and (> numSuits 0) (== (Random 0 1) 1))
							(= temp0 (self chooseSuits:))
						)
						(else
							(while
								(not
									((= temp0
											(cardList
												at:
													(Random
														0
														(- (cardList size:) 1)
													)
											)
										)
										valid:
									)
								)
								(if (> (++ temp5) 200)
									(= temp0 temp6)
									(break)
								)
							)
						)
					)
				)
				(else
					(if (>= numRanks numSuits)
						(= temp0 (self chooseRanks:))
					)
					(if (> numSuits numRanks)
						(= temp0 (self chooseSuits:))
					)
				)
			)
			(if (and temp0 (== (temp0 rank:) 8))
				(= eightPlayed 1)
				(self choose8Suit:)
			else
				(= eightPlayed 0)
			)
			(return temp0)
		)
	)

	(method (countCards &tmp temp0 temp1 temp2 temp3)
		(= totalPlayable (= numEights (= numSuits (= numRanks 0))))
		(= temp3 ((Piles at: 0) upCard:))
		(for ((= temp0 0)) (< temp0 (cardList size:)) ((++ temp0))
			(= [local18 temp0] 0)
			(if ((= temp2 (cardList at: temp0)) valid:)
				(if (== (temp2 rank:) 8)
					(++ totalPlayable)
					(++ numEights)
					(= [local18 temp0] 1)
				else
					(if (== (temp2 rank:) (temp3 rank:))
						(++ totalPlayable)
						(++ numRanks)
						(= [local18 temp0] 2)
					)
					(if
						(or
							(== (temp2 suit:) (temp3 suit:))
							(and
								(== (temp3 rank:) 8)
								(== (temp2 suit:) global420)
							)
						)
						(++ totalPlayable)
						(++ numSuits)
						(= [local18 temp0] 3)
					)
				)
			)
		)
	)

	(method (setUpArrays &tmp temp0 temp1)
		(for ((= temp1 0)) (<= temp1 14) ((++ temp1))
			(= [local4 temp1] 0)
			(if (< temp1 4)
				(= [local0 temp1] 0)
			)
		)
		(for ((= temp1 0)) (< temp1 (cardList size:)) ((++ temp1))
			(if ((= temp0 (cardList at: temp1)) rank:)
				(++ [local0 (temp0 suit:)])
				(++ [local4 (temp0 rank:)])
			)
		)
	)

	(method (chooseSuits &tmp temp0 temp1)
		(= temp1 -1)
		(for ((= temp0 0)) (< temp0 (cardList size:)) ((++ temp0))
			(if (== [local18 temp0] 3)
				(cond
					((== temp1 -1)
						(= temp1 temp0)
					)
					(
						(>
							[local4 ((cardList at: temp0) rank:)]
							[local4 ((cardList at: temp1) rank:)]
						)
						(= temp1 temp0)
					)
				)
			)
		)
		(cardList at: temp1)
	)

	(method (chooseRanks &tmp temp0 temp1)
		(= temp1 -1)
		(for ((= temp0 0)) (< temp0 (cardList size:)) ((++ temp0))
			(if (== [local18 temp0] 2)
				(cond
					((== temp1 -1)
						(= temp1 temp0)
					)
					(
						(>
							[local0 ((cardList at: temp0) suit:)]
							[local0 ((cardList at: temp1) suit:)]
						)
						(= temp1 temp0)
					)
				)
			)
		)
		(cardList at: temp1)
	)

	(method (chooseEights &tmp temp0 temp1 temp2 temp3)
		(= temp0 0)
		(= temp1 0)
		(= temp2 (Random 1 numEights))
		(while (!= temp1 temp2)
			(if (== [local18 temp0] 1)
				(++ temp1)
				(= temp3 temp0)
			)
			(++ temp0)
		)
		(= eightPlayed 1)
		(self choose8Suit:)
		(cardList at: temp3)
	)

	(method (choose8Suit &tmp temp0 temp1 temp2 temp3 temp4)
		(if (> skill 0)
			(for ((= temp2 0)) (< temp2 (cardList size:)) ((++ temp2))
				(if (== ((= temp4 (cardList at: temp2)) rank:) 8)
					(-- [local0 (temp4 suit:)])
				)
			)
			(= temp3 (= temp1 0))
			(= temp1 0)
			(for ((= temp0 1)) (< temp0 4) ((++ temp0))
				(if (> [local0 temp0] [local0 temp1])
					(= temp3 temp1)
					(= temp1 temp0)
				)
			)
			(if
				(and
					(== skill 2)
					temp3
					(Random 0 1)
					(> [local0 temp3] 0)
					(<= (cardList size:) 3)
				)
				(= temp1 temp3)
			)
		else
			(= temp1 (Random 0 3))
		)
		(= newSuitChosen temp1)
	)

	(method (checkForValid param1 param2 &tmp temp0 temp1 temp2 temp3)
		(= temp3 0)
		(= temp0 (((Piles at: 0) upCard:) suit:))
		(if (>= argc 2)
			(= temp0 param2)
		)
		(for ((= temp1 0)) (< temp1 (cardList size:)) ((++ temp1))
			(= temp2 (cardList at: temp1))
			(if
				(and
					(== (temp2 rank:) param1)
					(temp2 valid:)
					(or (== (temp2 suit:) temp0) (== (temp2 suit:) -1))
				)
				(= temp3 temp2)
				(break)
			)
		)
		(return temp3)
	)

	(method (doEightCode &tmp temp0)
		(return (> (self checkSize: 2) 1))
	)

	(method (doTwoCode param1 &tmp temp0)
		(if (> (global117 size:) 2)
			(= temp0 (self find2ndToNextSize:))
		)
		(if
			(or
				(and (OneOf skill 0 1) (<= (nextPlayer size:) 2))
				(== (cardList size:) 1)
				(and
					(== totalPlayable 1)
					(or
						(== (global419 size:) -1)
						(>= (self checkHand: 2) 2)
						safetyDraw
					)
				)
			)
			(return param1)
		)
		(switch skill
			(1
				(self unvalidate: param1 -1)
			)
			(else
				(if
					(and
						(or (self checkSize: 2) (== totalPlayable 1))
						(or
							(> temp0 1)
							(and
								(>= (prePlayer size:) 5)
								(<= (self checkDiscardPile: 2) 2)
							)
						)
						(<= (prePlayer size:) 2)
						(> (self checkDiscardPile: 2) 2)
						(< (self checkDiscardPile: 13) 4)
						(>= (nextPlayer size:) (prePlayer size:))
					)
					(return param1)
				else
					(self unvalidate: param1 -1)
				)
			)
		)
		(return 0)
	)

	(method (doJackCode param1 &tmp temp0 temp1)
		(if (== skill 0)
			(return 0)
		)
		(if (== (cardList size:) 1)
			(return param1)
		)
		(switch skill
			(1
				(if (or (== totalPlayable 1) (<= (prePlayer size:) 2))
					(return param1)
				else
					(self unvalidate: param1 -1)
				)
			)
			(else
				(if (> (global117 size:) 2)
					(= temp0 (self find2ndToNextSize:))
				)
				(if
					(or
						(<= (global117 size:) 2)
						(and
							(<= (prePlayer size:) 2)
							(>= (prePlayer size:) temp0)
						)
						(and
							(== totalPlayable 1)
							(not
								(self
									checkHighScore:
										(if
											(>
												(= temp1
													(global117
														indexOf: cardList
													)
												)
												2
											)
											(global117 at: (- temp1 2))
										else
											(global117 at: (+ temp1 2))
										)
								)
							)
							(or
								(== (global419 size:) -1)
								(not (self checkSize: 2))
								safetyDraw
								(and
									(<= (prePlayer size:) 3)
									(> temp0 (prePlayer size:))
								)
							)
						)
					)
					(return param1)
				else
					(self unvalidate: param1 -1)
				)
			)
		)
		(return 0)
	)

	(method (doQueenCode param1 &tmp temp0)
		(if
			(or
				(== (cardList size:) 1)
				(and (OneOf skill 0 1) (<= (nextPlayer size:) 2))
				(>= safetyDraw 2)
			)
			(return param1)
		)
		(= temp0 (self checkCardCount:))
		(switch skill
			(1
				(self unvalidate: param1 0)
			)
			(else
				(if
					(or
						(and (<= (global117 size:) 2) (<= (prePlayer size:) 2))
						(and
							(== temp0 1)
							(or
								(and
									(==
										(self
											returnHand:
												(not (Dealer playDirection:))
										)
										fewestCount
									)
									(> (self checkDiscardPile: 13) 2)
								)
								(== (self returnHand:) fewestCount)
							)
						)
					)
					(return param1)
				else
					(self unvalidate: param1 0)
				)
			)
		)
		(return 0)
	)

	(method (doKingCode param1 &tmp temp0)
		(if (== skill 0)
			(return 0)
		)
		(if
			(or
				(== (cardList size:) 1)
				(and
					(<= (prePlayer size:) 2)
					(or
						(and
							(> (global117 size:) 2)
							(>= (nextPlayer size:) (prePlayer size:))
						)
						(and (<= (global117 size:) 2) 1)
					)
				)
				(and
					(== totalPlayable 1)
					(or
						safetyDraw
						(== (global419 size:) -1)
						(>= (self checkHand: 13) 2)
						(not (self checkSize: 3))
					)
				)
				(and
					(<= 2 (nextPlayer size:) 3)
					(= temp0 (self checkCardCount:))
					(<= 0 temp0 1)
					(or (self checkForValid: 12 0) (self checkForValid: 2 -1))
				)
			)
			(return param1)
		else
			(self unvalidate: param1 -1)
		)
		(return 0)
	)

	(method (findNext)
		(if (not nextPlayer)
			(= nextPlayer (self returnHand:))
		)
	)

	(method (findPrev)
		(if (not prePlayer)
			(= prePlayer (self returnHand: (not (Dealer playDirection:))))
		)
	)

	(method (returnHand param1 &tmp temp0 temp1)
		(if (< argc 1)
			(= temp1 (Dealer playDirection:))
		else
			(= temp1 param1)
		)
		(if
			(and
				(>
					(= temp0
						(+
							(= temp0 (global117 indexOf: (Dealer curPlayer:)))
							(* temp1 -2)
							1
						)
					)
					(- (global117 size:) 1)
				)
				(== temp1 0)
			)
			(= temp0 0)
		)
		(if (and (< temp0 0) (== temp1 1))
			(= temp0 (- (global117 size:) 1))
		)
		(global117 at: temp0)
	)

	(method (find2ndToNextSize &tmp temp0 temp1)
		(if (<= (= temp0 (global117 indexOf: (Dealer curPlayer:))) 1)
			(= temp1 ((global117 at: (+ temp0 2)) size:))
		else
			(= temp1 ((global117 at: (- temp0 2)) size:))
		)
		(return temp1)
	)

	(method (unvalidate param1 param2 &tmp temp0 temp1 temp2)
		(= temp1 (param1 rank:))
		(for ((= temp0 0)) (< temp0 (cardList size:)) ((++ temp0))
			(= temp2 (cardList at: temp0))
			(if
				(and
					(== (temp2 rank:) temp1)
					(or (== param2 -1) (== (temp2 suit:) param2))
				)
				(temp2 valid: 0)
			)
		)
		(self countCards:)
	)

	(method (checkDiscardPile param1 &tmp temp0 temp1 temp2)
		(if
			(or
				(and (== param1 2) (not (= temp2 numTwos)))
				(and (== param1 13) (not (= temp2 numKings)))
			)
			(= temp1 (ScriptID 15 1)) ; discardList
			(= temp2 (= temp0 0))
			(while (< temp0 (temp1 size:))
				(if (== ((temp1 at: temp0) rank:) param1)
					(++ temp2)
				)
				(++ temp0)
			)
		)
		(return temp2)
	)

	(method (checkHand param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 [param1 0])
		(= temp0 -1)
		(if (>= argc 2)
			(= temp0 [param1 1])
		)
		(= temp4 (= temp2 0))
		(while (< temp2 (cardList size:))
			(= temp3 (cardList at: temp2))
			(if
				(and
					(== (temp3 rank:) temp1)
					(or (== temp0 -1) (== (temp3 suit:) temp0))
				)
				(++ temp4)
			)
			(++ temp2)
		)
		(return temp4)
	)

	(method (checkCardCount &tmp temp0 temp1 temp2 temp3)
		(= fewestCount (= temp2 (= temp3 (= temp0 0))))
		(while (< temp0 (global117 size:))
			(if
				(and
					(!= (= temp1 (global117 at: temp0)) cardList)
					(<= (temp1 size:) 2)
				)
				(++ temp3)
				(if (or (not temp2) (< (temp1 size:) temp2))
					(= fewestCount temp1)
					(= temp2 (fewestCount size:))
				)
			)
			(++ temp0)
		)
		(return temp3)
	)

	(method (checkHighScore param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 -1)
		(for ((= temp0 0)) (< temp0 (global117 size:)) ((++ temp0))
			(if (== temp1 -1)
				((= temp1 (global117 at: 0)) tempTotal:)
			)
			(if
				(>
					((= temp3 (global117 at: temp0)) tempTotal:)
					(temp1 tempTotal:)
				)
				(= temp1 temp3)
			)
		)
		(if (!= param1 temp1)
			(return 1)
		else
			(return 0)
		)
	)

	(method (checkSize param1 &tmp temp0 temp1)
		(= temp1 0)
		(for ((= temp0 0)) (< temp0 (global117 size:)) ((++ temp0))
			(if (<= ((global117 at: temp0) size:) param1)
				(++ temp1)
			)
		)
		(return temp1)
	)
)

