;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 870)
(include sci.sh)
(use Main)
(use Piles)
(use EScore)
(use System)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	[local10 7]
	[local17 7]
	[local24 7]
	[local31 7]
	[local38 7]
	[local45 127] = [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 14 28 30 50 0 0 0 0 0 0 0 0 0 0 0 0 16 30 30 50 0 22 22 46 24 46 46 50 27 46 46 50 46 50 50 50 0 0 0 14 0 15 16 30 0 20 21 30 22 30 30 50 16 23 24 30 25 46 46 50 28 46 46 50 46 50 50 50 20 38 38 46 38 46 46 50 38 46 46 50 46 50 50 50 38 46 46 50 46 50 50 50 46 50 50 50 50 50 50]
)

(class EuchreStrategy of Code
	(properties
		leftSuit 0
		numTrump 0
		suitTurnedDown 0
		discardedCard 0
		upCard 0
		trumpsUnknown 0
		spadesUnknown 0
		clubsUnknown 0
		diamondsUnknown 0
		heartsUnknown 0
	)

	(method (thinkDiscard param1 &tmp [temp0 4] temp4)
		(= local2 (Dealer curPlayer:))
		(local2 choice: 0)
		(= leftSuit (self findLeftSuit: (gTrick trump:)))
		(= numTrump (self haveTrump: param1))
		(cond
			((== numTrump 6)
				(local2 choice: 400)
				(= discardedCard (self lowest: (gTrick trump:) param1))
				(= suitTurnedDown (self euchreSuit: discardedCard))
				(return discardedCard)
			)
			((or (== numTrump 5) (== numTrump 4))
				(local2 choice: 401)
				(= discardedCard (self lowestNonTrump: param1))
				(= suitTurnedDown (self euchreSuit: discardedCard))
				(return discardedCard)
			)
			((== local4 0)
				(local2 choice: 405)
				(= discardedCard (self lowestNonTrump: param1))
				(= suitTurnedDown (self euchreSuit: discardedCard))
				(return discardedCard)
			)
			(
				(and
					(= temp4 (self lowestSingleton: param1))
					(<= (temp4 rank:) 12)
				)
				(local2 choice: 402)
				(= discardedCard temp4)
				(= suitTurnedDown (self euchreSuit: discardedCard))
				(return temp4)
			)
			((or (== numTrump 3) (== numTrump 2))
				(local2 choice: 403)
				(= discardedCard (self lowestNonTrump: param1))
				(= suitTurnedDown (self euchreSuit: discardedCard))
				(return discardedCard)
			)
			((== numTrump 1)
				(if
					(and
						(== local4 2)
						(= temp4 (self lowestSingleton: param1))
						(<= (temp4 rank:) 13)
					)
					(local2 choice: 404)
					(= discardedCard temp4)
					(= suitTurnedDown (self euchreSuit: discardedCard))
					(return discardedCard)
				)
				(local2 choice: 405)
				(= discardedCard (self lowestNonTrump: param1))
				(= suitTurnedDown (self euchreSuit: discardedCard))
				(return discardedCard)
			)
		)
	)

	(method (whatColor param1)
		(return
			(switch
				(if (IsObject param1)
					(param1 suit:)
				else
					param1
				)
				(0 0)
				(1 0)
				(2 1)
				(3 1)
			)
		)
	)

	(method (bid param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(= local5
			(switch
				(= local4
					(switch (param1 location:)
						(4 global196)
						(1 global197)
						(2 global198)
					)
				)
				(0 28)
				(1 23)
				(2 20)
			)
		)
		(= local6
			(switch local4
				(0 60)
				(1 50)
				(2
					(if (== ((param1 partner:) location:) 3) 41 else 39)
				)
			)
		)
		(if (== (param1 location:) 1)
			(= temp9 (EScore wePoints:))
			(= temp10 (EScore theyPoints:))
		else
			(= temp9 (EScore theyPoints:))
			(= temp10 (EScore wePoints:))
		)
		(if (and (== local4 2) (>= temp10 (+ temp9 4)))
			(= local6 38)
			(= local5 18)
		)
		(if
			(and
				global288
				(== global286 2)
				(== (Dealer dealer:) (Dealer curPlayer:))
			)
			(= local5 1)
		)
		(= upCard global549)
		(= local0 (= discardedCard 0))
		(if (== global286 1)
			(= temp2 (self rateTrump: param1 (param2 suit:) (param2 rank:) 0))
			(= temp3 (self rateSideSuits: param1 (param2 suit:) 0))
			(= temp4 (self rateTopCard: param1 (param2 rank:)))
			(= temp1 (+ temp2 temp3 temp4))
			(if (not temp2)
				(= temp1 0)
			)
			(if (>= (+ temp2 temp3) local6)
				(= global284 1)
				(cond
					((== (param1 location:) 1)
						(if (<= (- global283 (EScore wePoints:)) 2)
							(= global284 0)
						)
					)
					((<= (- global283 (EScore theyPoints:)) 2)
						(= global284 0)
					)
				)
			else
				(+= temp1 local0)
			)
			(param1 finalRating: temp1 bestSuitRated: (param2 suit:))
			(= global425 (if (>= temp1 local5) 5 else -1))
		else
			(= temp8 0)
			(if (>= local4 1)
				(switch (param2 rank:)
					(14
						(= temp8 14)
					)
					(13
						(= temp8 13)
					)
				)
			)
			(= temp0 0)
			(= temp5 0)
			(= temp6 -1)
			(while (<= temp0 3)
				(if (!= (param2 suit:) temp0)
					(= temp7 0)
					(if (>= local4 1)
						(= temp7
							(and
								(== (param2 rank:) 11)
								(==
									(self whatColor: param2)
									(self whatColor: temp0)
								)
							)
						)
					)
					(= temp2 (self rateTrump: param1 temp0 0 temp7))
					(= temp3 (self rateSideSuits: param1 temp0 temp8))
					(= temp1 (+ temp2 temp3))
					(if (not temp2)
						(= temp1 0)
					)
					(if (> temp1 temp5)
						(= temp5 temp1)
						(= temp6 temp0)
					)
				)
				(++ temp0)
			)
			(if (>= temp5 local6)
				(= global284 1)
				(cond
					((== (param1 location:) 1)
						(if (<= (- global283 (EScore wePoints:)) 2)
							(= global284 0)
						)
					)
					((<= (- global283 (EScore theyPoints:)) 2)
						(= global284 0)
					)
				)
			)
			(param1 finalRating: temp5 bestSuitRated: temp6)
			(= global425 (if (>= temp5 local5) temp6 else -1))
			(if (and (== local5 1) (== global425 -1))
				(self forcedBid: param1 (param2 suit:))
			)
		)
		(return global425)
	)

	(method (forcedBid param1 param2 &tmp temp0 temp1 [temp2 4] temp6 temp7)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(= [temp2 temp0] 0)
			(if (!= temp0 param2)
				(for ((= temp1 0)) (< temp1 5) ((++ temp1))
					(if
						(or
							(== ((param1 at: temp1) suit:) temp0)
							(and
								(== ((param1 at: temp1) rank:) 11)
								(==
									(self cardColor: (param1 at: temp1))
									(self cardColor: temp0)
								)
							)
						)
						(+= [temp2 temp0] (+ [temp2 temp0] 100))
						(if (== ((param1 at: temp1) suit:) temp0)
							(= temp6
								(switch ((param1 at: temp1) rank:)
									(9 1)
									(10 2)
									(12 3)
									(13 4)
									(14 5)
									(11 7)
								)
							)
							(+= [temp2 temp0] (+ [temp2 temp0] temp6))
						else
							(+= [temp2 temp0] (+ [temp2 temp0] 6))
						)
					)
				)
			)
		)
		(= temp0 0)
		(= temp7 0)
		(while (< temp0 4)
			(if (> [temp2 temp0] temp7)
				(= temp7 [temp2 temp0])
				(= global425 temp0)
			)
			(++ temp0)
		)
		(return global425)
	)

	(method (cardColor param1 &tmp temp0)
		(= temp0 0)
		(cond
			((IsObject param1)
				(if (>= (param1 suit:) 2)
					(= temp0 1)
				)
			)
			((>= param1 2)
				(= temp0 1)
			)
		)
		(return temp0)
	)

	(method (rateTrump param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4)
		(for ((= temp0 (= temp2 0))) (< temp0 (param1 size:)) ((++ temp0))
			(= temp1 (param1 at: temp0))
			(if (== (temp1 suit:) param2)
				(+=
					temp2
					(switch (temp1 rank:)
						(11 64)
						(14 16)
						(13 8)
						(12 4)
						(10 2)
						(9 1)
					)
				)
			)
			(if
				(and
					(== (temp1 rank:) 11)
					(== (temp1 suit:) (self findLeftSuit: param2))
				)
				(+= temp2 32)
			)
		)
		(if (and param3 (== (Dealer dealer:) param1))
			(+=
				temp2
				(switch param3
					(11 64)
					(14 16)
					(13 8)
					(12 4)
					(10 2)
					(9 1)
				)
			)
		)
		(if param4
			(= temp3 (>= temp2 64))
			(= temp2 (* (&= temp2 $001f) 2))
			(if temp3
				(+= temp2 64)
			)
		)
		(if (== param1 ((Dealer dealer:) leftOpponent:))
			(= local0 2)
			(if (or (>= temp2 96) (>= 56 temp2 63) (>= 88 temp2 95))
				(= temp0 0)
				(= temp4 0)
				(while (< temp0 (param1 size:))
					(if (!= ((param1 at: temp0) suit:) param2)
						(switch ((param1 at: temp0) rank:)
							(14
								(+= temp4 2)
							)
							(13
								(++ temp4)
							)
						)
					)
					(++ temp0)
				)
				(if (>= temp4 2)
					(+= local0 3)
				)
			)
		)
		(return [local45 temp2])
	)

	(method (rateSideSuits param1 param2 param3 &tmp temp0 temp1)
		(= temp1 0)
		(= temp0 0)
		(while (<= temp1 3)
			(if (!= temp1 param2)
				(+= temp0 (self rateSide: param1 temp1 param2 param3))
			)
			(++ temp1)
		)
		(return temp0)
	)

	(method (rateSide param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
		(for
			((= temp0 (= temp1 (= temp2 0))))
			(< temp0 (param1 size:))
			((++ temp0))
			
			(if
				(and
					(== ((param1 at: temp0) suit:) param2)
					(or
						(!= ((param1 at: temp0) rank:) 11)
						(!= param2 (self findLeftSuit: param3))
					)
				)
				(++ temp1)
				(if (> ((param1 at: temp0) rank:) temp2)
					(= temp2 ((param1 at: temp0) rank:))
				)
			)
		)
		(switch temp1
			(1
				(switch temp2
					(14
						(return 7)
					)
					(13
						(return (if (> param4 13) 7 else 5))
					)
					(12
						(return (if (> param4 13) 5 else 2))
					)
				)
			)
			(2
				(for
					((= temp0 (= temp3 0)))
					(< temp0 (param1 size:))
					((++ temp0))
					
					(if (== ((param1 at: temp0) suit:) param3)
						(++ temp3)
					)
					(if
						(and
							(== ((param1 at: temp0) rank:) 11)
							(==
								((param1 at: temp0) suit:)
								(self findLeftSuit: param3)
							)
						)
						(++ temp3)
					)
				)
				(switch temp2
					(14
						(return (if (== temp3 3) 13 else 6))
					)
					(13
						(if (> param4 13)
							(return (if (== temp3 3) 13 else 6))
						else
							(return 4)
						)
					)
				)
			)
		)
		(return 0)
	)

	(method (rateTopCard param1 param2 &tmp temp0)
		(if (== (Dealer dealer:) param1)
			(return 0)
		)
		(= temp0
			(switch param2
				(11 12)
				(14 7)
				(13 6)
				(12 5)
				(10 4)
				(9 3)
			)
		)
		(if (and (!= param2 11) (== (Dealer dealer:) (param1 rightOpponent:)))
			(-- temp0)
		)
		(if (!= ((Dealer dealer:) partner:) param1)
			(= temp0 (- 0 temp0))
		)
		(return temp0)
	)

	(method (findLeftSuit param1)
		(return
			(switch param1
				(0 1)
				(1 0)
				(2 3)
				(3 2)
			)
		)
	)

	(method (think param1 &tmp [temp0 3] temp3 temp4)
		(= local4
			(switch (param1 location:)
				(4 global196)
				(1 global197)
				(2 global198)
			)
		)
		(= local7 (== (gTrick size:) 1))
		(= local8 (== (gTrick size:) 2))
		(= local9 (== (gTrick size:) 3))
		(= upCard global549)
		(= leftSuit (self findLeftSuit: (gTrick trump:)))
		(= numTrump (self haveTrump: param1))
		(self calcRankings: 0 calcRankings: 1 calcRankings: 2 calcRankings: 3)
		(= temp3 (self numPlayed: 0 leftSuit))
		(= temp4 (self numKnown: 0 leftSuit param1 upCard))
		(if (self allOfSuitKnown: (+ temp3 temp4) 0)
			((param1 leftOpponent:) outOfSpades: 1)
			((param1 rightOpponent:) outOfSpades: 1)
			(if (== (gTrick trump:) 0)
				((param1 leftOpponent:) outOfTrump: 1)
				((param1 rightOpponent:) outOfTrump: 1)
			)
		)
		(= temp3 (self numPlayed: 1 leftSuit))
		(= temp4 (self numKnown: 1 leftSuit param1 upCard))
		(if (self allOfSuitKnown: (+ temp3 temp4) 1)
			((param1 leftOpponent:) outOfClubs: 1)
			((param1 rightOpponent:) outOfClubs: 1)
			(if (== (gTrick trump:) 1)
				((param1 leftOpponent:) outOfTrump: 1)
				((param1 rightOpponent:) outOfTrump: 1)
			)
		)
		(= temp3 (self numPlayed: 2 leftSuit))
		(= temp4 (self numKnown: 2 leftSuit param1 upCard))
		(if (self allOfSuitKnown: (+ temp3 temp4) 2)
			((param1 leftOpponent:) outOfDiamonds: 1)
			((param1 rightOpponent:) outOfDiamonds: 1)
			(if (== (gTrick trump:) 2)
				((param1 leftOpponent:) outOfTrump: 1)
				((param1 rightOpponent:) outOfTrump: 1)
			)
		)
		(= temp3 (self numPlayed: 3 leftSuit))
		(= temp4 (self numKnown: 3 leftSuit param1 upCard))
		(if (self allOfSuitKnown: (+ temp3 temp4) 3)
			((param1 leftOpponent:) outOfHearts: 1)
			((param1 rightOpponent:) outOfHearts: 1)
			(if (== (gTrick trump:) 3)
				((param1 leftOpponent:) outOfTrump: 1)
				((param1 rightOpponent:) outOfTrump: 1)
			)
		)
		(= local2 (Dealer curPlayer:))
		(local2 choice: 0 route: 0)
		(if (not (gTrick size:))
			(self thinkLead: param1)
			(return)
		else
			(self thinkFollow: param1)
			(return)
		)
	)

	(method (thinkLead param1 &tmp temp0 temp1 temp2 temp3)
		(= global200 1)
		(if (== (param1 size:) 1)
			(local2 choice: 1)
			(return (param1 at: 0))
		)
		(cond
			((== param1 global429)
				(if numTrump
					(= global200 2)
					(if (== numTrump (param1 size:))
						(local2 choice: 1)
						(return (self highest: (gTrick trump:) param1))
					)
					(= global200 3)
					(= temp0
						(+
							((param1 leftOpponent:) outOfTrump:)
							((param1 rightOpponent:) outOfTrump:)
						)
					)
					(= global200 4)
					(if
						(and
							(== (param1 size:) 2)
							(== numTrump 1)
							(== param1 global429)
						)
						(cond
							(
								(or
									(== (global429 location:) 1)
									(== (global429 location:) 3)
								)
								(if (== (EScore weTricksWon:) 3)
									(local2 choice: 1)
									(return
										(self
											highest: (gTrick trump:) param1
										)
									)
								)
							)
							((== (EScore theyTricksWon:) 3)
								(local2 choice: 1)
								(return
									(self highest: (gTrick trump:) param1)
								)
							)
						)
					)
					(if (!= temp0 2)
						(cond
							(
								(and
									(self haveCard: 0 (gTrick trump:) param1)
									(self haveCard: 1 (gTrick trump:) param1)
								)
								(local2 choice: 2)
								(if
									(and
										(>= (param1 size:) 4)
										(> trumpsUnknown 1)
										(or
											(not
												((param1 leftOpponent:)
													outOfTrump:
												)
											)
											(not
												((param1 rightOpponent:)
													outOfTrump:
												)
											)
										)
									)
									(= local1 1)
								)
								(return
									(self highest: (gTrick trump:) param1)
								)
							)
							((and trumpsUnknown local1)
								(= local1 0)
								(local2 choice: 2)
								(return
									(self highest: (gTrick trump:) param1)
								)
							)
							((= local1 0) 0)
							((not (= global200 5)) 0)
							(
								(and
									(self haveCard: 0 (gTrick trump:) param1)
									(self haveCard: 2 (gTrick trump:) param1)
									(<= trumpsUnknown (- 3 temp0))
								)
								(local2 choice: 3)
								(return
									(self highest: (gTrick trump:) param1)
								)
							)
							((not (= global200 6)) 0)
							(
								(and
									(>= local4 1)
									(>= numTrump 3)
									(not
										(self
											haveCard:
												0
												(gTrick trump:)
												param1
										)
									)
									(self haveCard: 1 (gTrick trump:) param1)
									(self haveCard: 2 (gTrick trump:) param1)
								)
								(local2 choice: 4)
								(return
									(self highest: (gTrick trump:) param1)
								)
							)
							((not (= global200 7)) 0)
							(
								(and
									(== numTrump 1)
									(self haveCard: 0 (gTrick trump:) param1)
									(<= trumpsUnknown (- 3 temp0))
								)
								(local2 choice: 5)
								(return
									(self highest: (gTrick trump:) param1)
								)
							)
							((not (= global200 8)) 0)
							((= temp1 (self getSingleton: param1 0))
								(local2 choice: 6)
								(return temp1)
							)
							((not (= global200 9)) 0)
							(
								(and
									(>= local4 1)
									(not global284)
									(not ((param1 partner:) outOfTrump:))
									(= temp1 (self haveSuitPartnerLead: param1))
								)
								(local2 choice: 7)
								(return temp1)
							)
							((not (= global200 10)) 0)
							(else
								(= temp1 (self highestNonTrump: param1))
								(local2 choice: 8)
								(return temp1)
							)
						)
					else
						(= global200 11)
						(for ((= temp2 0)) (<= temp2 3) ((++ temp2))
							(if
								(and
									(!= (gTrick trump:) temp2)
									(= temp3 (self highest: temp2 param1))
								)
								(switch temp2
									(0
										(if (== (temp3 rank:) [local17 0])
											(local2 choice: 9)
											(return temp3)
										)
									)
									(1
										(if (== (temp3 rank:) [local24 0])
											(local2 choice: 10)
											(return temp3)
										)
									)
									(2
										(if (== (temp3 rank:) [local31 0])
											(local2 choice: 11)
											(return temp3)
										)
									)
									(3
										(if (== (temp3 rank:) [local38 0])
											(local2 choice: 12)
											(return temp3)
										)
									)
								)
							)
						)
						(= global200 12)
						(if (not global284)
							(local2 choice: 13)
							(return (self lowest: (gTrick trump:) param1))
						else
							(local2 route: 1)
							(return (self dontHaveTrump: param1))
						)
					)
				else
					(= global200 13)
					(local2 route: 2)
					(return (self dontHaveTrump: param1))
				)
			)
			((== param1 (global429 partner:))
				(= global200 14)
				(if numTrump
					(cond
						((== numTrump (param1 size:))
							(local2 choice: 21)
							(return (self highest: (gTrick trump:) param1))
						)
						((not (= global200 15)) 0)
						(
							(and
								(self haveCard: 0 (gTrick trump:) param1)
								(!= temp0 2) ; UNINIT
							)
							(local2 choice: 22)
							(return (self highest: (gTrick trump:) param1))
						)
						((not (= global200 16)) 0)
						(
							(and
								(>= local4 1)
								(== global286 1)
								(== global113 (Dealer dealer:))
								(not
									(self
										isKnownOutOfPlay:
											(upCard rank:)
											(upCard suit:)
									)
								)
								(!= global429 (Dealer dealer:))
								(>= (upCard rank:) 13)
								(> [local10 0] (upCard rank:))
								(not (global429 outOfTrump:))
								(self isFinessePossible: param1)
							)
							(local2 choice: 23)
							(return (self lowest: (gTrick trump:) param1))
						)
						((not (= global200 17)) 0)
						((and (>= numTrump 2) (!= temp0 2)) ; UNINIT
							(local2 choice: 24)
							(return (self lowest: (gTrick trump:) param1))
						)
						((not (= global200 18)) 0)
						((= temp1 (self getSingleton: param1 0))
							(local2 choice: 25)
							(return temp1)
						)
						((not (= global200 19)) 0)
						((= temp1 (self getSingleton: param1))
							(local2 choice: 26)
							(return temp1)
						)
						((not (= global200 20)) 0)
						(else
							(= temp1 (self highestNonTrump: param1))
							(local2 choice: 27)
							(return temp1)
						)
					)
				else
					(= global200 21)
					(local2 route: 3)
					(return (self dontHaveTrump: param1))
				)
			)
			(else
				(if numTrump
					(= global200 22)
					(if (not ((param1 partner:) outOfTrump:))
						(if
							(and
								(>= local4 1)
								(== global286 1)
								(== (param1 partner:) (Dealer dealer:))
								(not
									(self
										isKnownOutOfPlay:
											(upCard rank:)
											(upCard suit:)
									)
								)
								(or
									(and
										(== [local10 0] 16)
										(== (upCard rank:) 11)
										(== (upCard suit:) (gTrick trump:))
									)
									(and
										(== [local10 0] 15)
										(== (upCard rank:) 11)
										(!= (upCard suit:) (gTrick trump:))
									)
									(== [local10 0] (upCard rank:))
								)
								(<= trumpsUnknown 1)
								(or
									(>= numTrump 2)
									(self
										haveWinner:
											param1
											(self
												highest:
													(gTrick trump:)
													param1
											)
									)
								)
							)
							(local2 choice: 28)
							(return (self lowest: (gTrick trump:) param1))
						)
					else
						(= global200 23)
						(if
							(= temp1
								(self haveCard: 0 (gTrick trump:) param1)
							)
							(local2 choice: 29)
							(return temp1)
						)
						(= global200 24)
						(if
							(and
								(>= numTrump 2)
								(self haveWinner: param1)
								(<= trumpsUnknown (- 2 temp0)) ; UNINIT
							)
							(local2 choice: 30)
							(return (self highest: (gTrick trump:) param1))
						)
					)
				)
				(= global200 25)
				(cond
					((= temp1 (self haveWinnerInUnplayedSuit: param1))
						(local2 choice: 31)
						(return temp1)
					)
					((= temp1 (self getBestSecondHigh: param1 0))
						(local2 choice: 32)
						(return temp1)
					)
				)
				(= global200 26)
				(if
					(and
						(>= local4 1)
						(not ((param1 partner:) outOfTrump:))
						(= temp1 (self haveSuitAnyoneLead: param1 1))
					)
					(local2 choice: 33)
					(return temp1)
				)
				(= global200 27)
				(if
					(and
						(>= local4 1)
						(= temp1 (self haveSuitAnyoneLead: param1 0))
					)
					(local2 choice: 34)
					(return temp1)
				)
				(if (= temp1 (self highestNonTrump: param1))
					(= global200 28)
					(local2 choice: 35)
					(return temp1)
				else
					(= global200 28)
					(local2 choice: 35)
					(return (self highest: (gTrick trump:) param1))
				)
			)
		)
	)

	(method (dontHaveTrump param1 &tmp temp0)
		(= global200 29)
		(cond
			((= temp0 (self haveWinnerInUnplayedSuit: param1))
				(local2 choice: 14)
				(return temp0)
			)
			((not (= global200 30)) 0)
			(
				(and
					(or
						(not ((param1 leftOpponent:) outOfTrump:))
						(not ((param1 rightOpponent:) outOfTrump:))
					)
					(>= trumpsUnknown 2)
				)
				(if (= temp0 (self haveCardInUnplayedSuit: param1))
					(local2 choice: 15)
					(return temp0)
				else
					(local2 choice: 16)
					(return (self highestNonTrump: param1))
				)
			)
			((not (= global200 31)) 0)
			((= temp0 (self getBestSecondHigh: param1 3))
				(local2 choice: 17)
				(return temp0)
			)
			((not (= global200 32)) 0)
			(
				(and
					(>= local4 1)
					(not global284)
					(not ((param1 partner:) outOfTrump:))
					(= temp0 (self haveSuitPartnerLead: param1))
				)
				(local2 choice: 18)
				(return temp0)
			)
			((not (= global200 33)) 0)
			((= temp0 (self haveCardInUnplayedSuit: param1))
				(local2 choice: 19)
				(return temp0)
			)
			((not (= global200 34)) 0)
			(else
				(local2 choice: 20)
				(return (self highestNonTrump: param1))
			)
		)
	)

	(method (cantFollowSuit param1 &tmp temp0)
		(= global200 35)
		(if (not numTrump)
			(local2 route: 100)
			(self playSideSuit: param1)
			(return)
		)
		(= global200 36)
		(if (== (gTrick highPlayer:) (param1 partner:))
			(if local9
				(local2 route: 101)
				(self playSideSuit: param1)
				(return)
			else
				(= global200 37)
				(if
					(or
						(self
							outOf: (gTrick suitLead:) (param1 leftOpponent:)
						)
						(not (self numHigher: (gTrick highCard:)))
					)
					(local2 route: 102)
					(self playSideSuit: param1)
					(return)
				)
				(= global200 38)
				(= temp0
					(self
						hasCard:
							param1
							(self rankings: 0 (gTrick suitLead:))
							(gTrick suitLead:)
					)
				)
				(= global200 39)
				(if
					(and
						(== (self numHigher: (gTrick highCard:)) 1)
						(not (self outOf: (gTrick suitLead:) global115))
						(not temp0)
					)
					(= global200 40)
					(if (== param1 global429)
						(if (and (>= local4 1) (<= (param1 finalRating:) 30))
							(local2 route: 103)
							(self playSideSuit: param1)
							(return)
						else
							(local2 choice: 300)
							(self lowest: (gTrick trump:) param1)
							(return)
						)
					else
						(= global200 41)
						(local2 route: 104)
						(self playSideSuit: param1)
						(return)
					)
				else
					(= global200 42)
					(local2 choice: 301)
					(self lowest: (gTrick trump:) param1)
					(return)
				)
			)
		else
			(= global200 43)
			(if (or local9 local8)
				(if
					(self
						sameSuit:
							(gTrick highCard:)
							(gTrick trump:)
							leftSuit
					)
					(if
						(>
							(self
								euchreRank:
									(self highest: (gTrick trump:) param1)
							)
							(self euchreRank: (gTrick highCard:))
						)
						(local2 choice: 200)
						(self
							justOver:
								(gTrick trump:)
								param1
								(self euchreRank: (gTrick highCard:))
						)
						(return)
					else
						(local2 route: 105)
						(self playSideSuit: param1)
						(return)
					)
				else
					(local2 choice: 202)
					(self lowest: (gTrick trump:) param1)
					(return)
				)
			else
				(= global200 44)
				(if
					(and
						(>= local4 1)
						(== (param1 partner:) (Dealer dealer:))
						(== global286 1)
						(not
							(self
								isKnownOutOfPlay: (upCard rank:) (upCard suit:)
							)
						)
						(==
							(self rankings: 0 (gTrick suitLead:))
							(upCard rank:)
						)
					)
					(= global200 45)
					(local2 route: 106)
					(self playSideSuit: param1)
					(return)
				else
					(= global200 46)
					(if
						(or
							(== param1 global429)
							(== param1 (global429 partner:))
						)
						(local2 choice: 302)
						(self lowest: (gTrick trump:) param1)
						(return)
					else
						(= global200 47)
						(if (self lowestTrumpIsWinner: param1)
							(local2 route: 107)
							(self playSideSuit: param1)
							(return)
						else
							(= global200 48)
							(local2 choice: 303)
							(self lowest: (gTrick trump:) param1)
							(return)
						)
					)
				)
			)
		)
	)

	(method (playSideSuit param1 &tmp temp0 [temp1 2] temp3 temp4)
		(= global200 49)
		(cond
			((== numTrump (param1 size:))
				(local2 choice: 304)
				(return (self lowest: (gTrick trump:) param1))
			)
			((not (= global200 50)) 0)
			((== (+ numTrump 1) (param1 size:))
				(if
					(and
						(!= (gTrick trump:) 0)
						(= temp0 (self lowest: 0 param1))
					)
					(= temp4 temp0)
				)
				(if
					(and
						(!= (gTrick trump:) 1)
						(= temp0 (self lowest: 1 param1))
					)
					(= temp4 temp0)
				)
				(if
					(and
						(!= (gTrick trump:) 2)
						(= temp0 (self lowest: 2 param1))
					)
					(= temp4 temp0)
				)
				(if
					(and
						(!= (gTrick trump:) 3)
						(= temp0 (self lowest: 3 param1))
					)
					(= temp4 temp0)
				)
				(local2 choice: 305)
				(return temp4)
			)
			((not (= global200 51)) 0)
			(else
				(= global200 52)
				(if
					(and
						numTrump
						(= temp4 (self lowestSingleton: param1))
						(<= (temp4 rank:) 12)
					)
					(local2 choice: 306)
					(return temp4)
				)
				(= global200 53)
				(= temp4 (self lowestNonTrump: param1))
				(if (or (<= (temp4 rank:) 12) (== local4 0))
					(local2 choice: 307)
					(return temp4)
				)
				(= global200 54)
				(for ((= temp3 0)) (<= temp3 3) ((++ temp3))
					(if
						(and
							(!= (gTrick trump:) temp3)
							(self hasCard: param1 14 temp3)
							(= temp4 (self hasCard: param1 13 temp3))
						)
						(local2 choice: 308)
						(return temp4)
					)
				)
				(= global200 55)
				(for ((= temp3 0)) (<= temp3 3) ((++ temp3))
					(if
						(and
							(!= (gTrick trump:) temp3)
							(= temp4 (self hasCard: param1 13 temp3))
							(self suitHasBeenLead: temp3)
						)
						(local2 choice: 309)
						(return temp4)
					)
				)
				(= global200 56)
				(for ((= temp3 0)) (<= temp3 3) ((++ temp3))
					(if
						(and
							(!= (gTrick trump:) temp3)
							(= temp4 (self hasCard: param1 14 temp3))
							(self suitHasBeenLead: temp3)
						)
						(local2 choice: 310)
						(return temp4)
					)
				)
				(= global200 57)
				(for ((= temp3 0)) (<= temp3 3) ((++ temp3))
					(if
						(and
							(!= (gTrick trump:) temp3)
							(= temp4 (self hasCard: param1 13 temp3))
						)
						(local2 choice: 311)
						(return temp4)
					)
				)
				(= global200 58)
				(for ((= temp3 0)) (<= temp3 3) ((++ temp3))
					(if
						(and
							(!= (gTrick trump:) temp3)
							(= temp4 (self hasCard: param1 14 temp3))
						)
						(local2 choice: 312)
						(return temp4)
					)
				)
			)
		)
	)

	(method (thinkFollow param1 &tmp temp0 [temp1 2] temp3)
		(if (== (param1 size:) 1)
			(local2 choice: 100)
			(param1 at: 0)
			(return)
		)
		(= global200 59)
		(= local3 (== (gTrick suitLead:) (gTrick trump:)))
		(= temp0 (param1 couldPlay: (gTrick suitLead:)))
		(cond
			((not (self highest: (gTrick suitLead:) param1))
				(local2 route: 108)
				(self cantFollowSuit: param1)
				(return)
			)
			((== temp0 1)
				(local2 choice: 100)
				(self highest: (gTrick suitLead:) param1)
				(return)
			)
			(else
				(= global200 60)
				(if (not (self canWinTrick: param1))
					(local2 choice: 101)
					(self lowest: (gTrick suitLead:) param1)
					(return)
				else
					(= global200 61)
					(if
						(or
							(== global429 param1)
							(== (global429 partner:) param1)
						)
						(= global200 62)
						(if (== (param1 partner:) (gTrick highPlayer:))
							(= global200 63)
							(cond
								(local9
									(local2 choice: 102)
									(self lowest: (gTrick suitLead:) param1)
									(return)
								)
								((not (= global200 64)) 0)
								((== (param1 size:) 2)
									(local2 choice: 103)
									(self highest: (gTrick suitLead:) param1)
									(return)
								)
								((not (= global200 65)) 0)
								(
									(and
										(not global284)
										(self
											outOf:
												(gTrick suitLead:)
												(param1 leftOpponent:)
										)
									)
									(local2 choice: 104)
									(self lowest: (gTrick suitLead:) param1)
									(return)
								)
								((not (= global200 66)) 0)
								(
									(and
										(>= local4 1)
										(== global286 1)
										(==
											(param1 leftOpponent:)
											(Dealer dealer:)
										)
										(not
											(self
												isKnownOutOfPlay:
													(upCard rank:)
													(upCard suit:)
											)
										)
										(==
											(upCard suit:)
											(gTrick suitLead:)
										)
										(>
											(self euchreRank: upCard)
											(self
												euchreRank:
													(self
														highest:
															(gTrick
																suitLead:
															)
															param1
													)
											)
										)
									)
									(local2 choice: 105)
									(self lowest: (gTrick suitLead:) param1)
									(return)
								)
								(else
									(local2 choice: 106)
									(self highest: (gTrick suitLead:) param1)
									(return)
								)
							)
						else
							(= global200 67)
							(if local9
								(local2 choice: 107)
								(self
									justOver:
										(gTrick suitLead:)
										param1
										(self euchreRank: (gTrick highCard:))
								)
								(return)
							else
								(local2 choice: 108)
								(self highest: (gTrick suitLead:) param1)
								(return)
							)
						)
					else
						(= global200 68)
						(cond
							((== (gTrick highPlayer:) global429)
								(= global200 69)
								(if local9
									(local2 choice: 109)
									(self
										justOver:
											(gTrick suitLead:)
											param1
											(self
												euchreRank:
													(gTrick highCard:)
											)
									)
									(return)
								else
									(= global200 70)
									(if local3
										(if
											(and
												(>= local4 1)
												(not global284)
												(not
													(self
														isKnownOutOfPlay:
															(upCard rank:)
															(upCard suit:)
													)
												)
												(==
													(Dealer dealer:)
													(global429 partner:)
												)
												(>
													(self euchreRank: upCard)
													(self
														euchreRank:
															(gTrick
																highCard:
															)
													)
												)
											)
											(= global200 71)
											(if
												(>
													(self
														euchreRank:
															(self
																highest:
																	(gTrick
																		suitLead:
																	)
																	param1
															)
													)
													(self euchreRank: upCard)
												)
												(local2 choice: 110)
												(self
													justOver:
														(gTrick suitLead:)
														param1
														(self
															euchreRank: upCard
														)
												)
												(return)
											else
												(local2 choice: 111)
												(self
													lowest:
														(gTrick suitLead:)
														param1
												)
												(return)
											)
										else
											(= global200 72)
											(local2 choice: 112)
											(self
												justOver:
													(gTrick suitLead:)
													param1
													(self
														euchreRank:
															(gTrick
																highCard:
															)
													)
											)
											(return)
										)
									else
										(= global200 73)
										(local2 choice: 113)
										(self
											highest:
												(gTrick suitLead:)
												param1
										)
										(return)
									)
								)
							)
							((== (gTrick highPlayer:) (global429 partner:))
								(= global200 74)
								(cond
									(local9
										(local2 choice: 114)
										(self
											justOver:
												(gTrick suitLead:)
												param1
												(self
													euchreRank:
														(gTrick highCard:)
												)
										)
										(return)
									)
									(local8
										(= global200 75)
										(if local3
											(if
												(or
													(==
														[local10 0]
														(self
															euchreRank:
																(self
																	highest:
																		(gTrick
																			suitLead:
																		)
																		param1
																)
														)
													)
													(and
														(>= local4 1)
														(== global286 1)
														(or
															(==
																(Dealer dealer:)
																global112
															)
															(==
																(Dealer dealer:)
																global113
															)
														)
														(= global200 76)
														(not
															(self
																isKnownOutOfPlay:
																	(upCard
																		rank:
																	)
																	(upCard
																		suit:
																	)
															)
														)
														(==
															[local10 1]
															(self
																euchreRank:
																	(self
																		highest:
																			(gTrick
																				suitLead:
																			)
																			param1
																	)
															)
														)
														(==
															[local10 0]
															(self
																euchreRank:
																	upCard
															)
														)
													)
												)
												(= global200 77)
												(local2 choice: 115)
												(self
													highest:
														(gTrick suitLead:)
														param1
												)
												(return)
											else
												(local2 choice: 116)
												(self
													justOver:
														(gTrick suitLead:)
														param1
														(self
															euchreRank:
																(gTrick
																	highCard:
																)
														)
												)
												(return)
											)
										else
											(= global200 78)
											(if
												(self
													outOf:
														(gTrick suitLead:)
														global429
												)
												(local2 choice: 117)
												(self
													justOver:
														(gTrick suitLead:)
														param1
														(self
															euchreRank:
																(gTrick
																	highCard:
																)
														)
												)
												(return)
											else
												(local2 choice: 118)
												(self
													highest:
														(gTrick suitLead:)
														param1
												)
												(return)
											)
										)
									)
									(local7
										(= global200 79)
										(if local3
											(if
												(or
													(==
														[local10 0]
														(self
															euchreRank:
																(self
																	highest:
																		(gTrick
																			suitLead:
																		)
																		param1
																)
														)
													)
													(and
														(>= local4 1)
														(== global286 1)
														(==
															(Dealer dealer:)
															global112
														)
														(= global200 80)
														(not
															(self
																isKnownOutOfPlay:
																	(upCard
																		rank:
																	)
																	(upCard
																		suit:
																	)
															)
														)
														(==
															[local10 1]
															(self
																euchreRank:
																	(self
																		highest:
																			(gTrick
																				suitLead:
																			)
																			param1
																	)
															)
														)
														(==
															[local10 0]
															(self
																euchreRank:
																	upCard
															)
														)
													)
												)
												(= global200 81)
												(= temp3 trumpsUnknown)
												(if
													(and
														(== global286 1)
														(==
															(Dealer dealer:)
															global112
														)
														(not
															(self
																isKnownOutOfPlay:
																	(upCard
																		rank:
																	)
																	(upCard
																		suit:
																	)
															)
														)
													)
													(-- temp3)
												)
												(= global200 82)
												(if (== temp3 1)
													(local2 choice: 119)
													(self
														highest:
															(gTrick
																suitLead:
															)
															param1
													)
													(return)
												else
													(local2 choice: 120)
													(self
														justOver:
															(gTrick
																suitLead:
															)
															param1
															(self
																euchreRank:
																	(gTrick
																		highCard:
																	)
															)
													)
													(return)
												)
											else
												(= global200 83)
												(if
													(or
														(==
															[local10 1]
															(self
																euchreRank:
																	(self
																		highest:
																			(gTrick
																				suitLead:
																			)
																			param1
																	)
															)
														)
														(and
															(>= local4 1)
															(== global286 1)
															(==
																(Dealer dealer:)
																global112
															)
															(= global200 84)
															(not
																(self
																	isKnownOutOfPlay:
																		(upCard
																			rank:
																		)
																		(upCard
																			suit:
																		)
																)
															)
															(==
																[local10 2]
																(self
																	euchreRank:
																		(self
																			highest:
																				(gTrick
																					suitLead:
																				)
																				param1
																		)
																)
															)
															(or
																(==
																	[local10 0]
																	(self
																		euchreRank:
																			upCard
																	)
																)
																(==
																	[local10 1]
																	(self
																		euchreRank:
																			upCard
																	)
																)
															)
														)
													)
													(local2 choice: 121)
													(self
														lowest:
															(gTrick
																suitLead:
															)
															param1
													)
													(return)
												else
													(= global200 85)
													(local2 choice: 122)
													(self
														justOver:
															(gTrick
																suitLead:
															)
															param1
															(self
																euchreRank:
																	(gTrick
																		highCard:
																	)
															)
													)
													(return)
												)
											)
										else
											(= global200 86)
											(if
												(self
													outOf:
														(gTrick suitLead:)
														global429
												)
												(local2 choice: 123)
												(self
													justOver:
														(gTrick suitLead:)
														param1
														(self
															euchreRank:
																(gTrick
																	highCard:
																)
														)
												)
												(return)
											else
												(local2 choice: 124)
												(self
													highest:
														(gTrick suitLead:)
														param1
												)
												(return)
											)
										)
									)
								)
							)
							(else
								(= global200 87)
								(if local9
									(local2 choice: 125)
									(self lowest: (gTrick suitLead:) param1)
									(return)
								else
									(= global200 88)
									(if local3
										(if (== global113 global429)
											(= global200 89)
											(if (== local4 0)
												(= global200 90)
												(local2 choice: 126)
												(self
													highest:
														(gTrick suitLead:)
														param1
												)
												(return)
											)
											(if
												(and
													(not global284)
													(== global286 1)
													(not
														(self
															isKnownOutOfPlay:
																(upCard rank:)
																(upCard suit:)
														)
													)
													(==
														(Dealer dealer:)
														(global429 partner:)
													)
													(>
														(self
															euchreRank: upCard
														)
														(self
															euchreRank:
																(gTrick
																	highCard:
																)
														)
													)
													(>
														(self
															euchreRank:
																(self
																	highest:
																		(gTrick
																			suitLead:
																		)
																		param1
																)
														)
														(self
															euchreRank: upCard
														)
													)
												)
												(local2 choice: 126)
												(self
													justOver:
														(gTrick suitLead:)
														param1
														(self
															euchreRank: upCard
														)
												)
												(return)
											else
												(= global200 90)
												(local2 choice: 127)
												(self
													lowest:
														(gTrick suitLead:)
														param1
												)
												(return)
											)
										else
											(= global200 91)
											(cond
												(
													(self
														allHigherAreKnown:
															param1
															(gTrick
																highCard:
															)
													)
													(local2 choice: 128)
													(self
														lowest:
															(gTrick
																suitLead:
															)
															param1
													)
													(return)
												)
												((not (= global200 91)) 0)
												(
													(and
														(== trumpsUnknown 1)
														(not
															(global429
																outOfTrump:
															)
														)
														(==
															[local10 0]
															(self
																euchreRank:
																	(self
																		highest:
																			(gTrick
																				suitLead:
																			)
																			param1
																	)
															)
														)
													)
													(local2 choice: 129)
													(self
														highest:
															(gTrick
																suitLead:
															)
															param1
													)
													(return)
												)
												((not (= global200 92)) 0)
												(
													(or
														(<=
															(self
																euchreRank:
																	(gTrick
																		highCard:
																	)
															)
															12
														)
														(>=
															(self
																euchreRank:
																	(self
																		highest:
																			(gTrick
																				suitLead:
																			)
																			param1
																	)
															)
															14
														)
													)
													(local2 choice: 130)
													(self
														highest:
															(gTrick
																suitLead:
															)
															param1
													)
													(return)
												)
												((not (= global200 93)) 0)
												(else
													(local2 choice: 131)
													(self
														lowest:
															(gTrick
																suitLead:
															)
															param1
													)
													(return)
												)
											)
										)
									else
										(= global200 94)
										(if (global115 outOfTrump:)
											(local2 choice: 132)
											(self
												lowest:
													(gTrick suitLead:)
													param1
											)
											(return)
										else
											(= global200 95)
											(if
												(self
													highInHandIsMuchHigher:
														param1
														(gTrick highCard:)
												)
												(local2 choice: 133)
												(self
													highest:
														(gTrick suitLead:)
														param1
												)
												(return)
											else
												(local2 choice: 134)
												(self
													lowest:
														(gTrick suitLead:)
														param1
												)
												(return)
											)
										)
									)
								)
							)
						)
					)
				)
			)
		)
	)

	(method (suitHasBeenLead param1)
		(switch param1
			(0
				(gTrick spadesLed:)
			)
			(1
				(gTrick clubsLed:)
			)
			(2
				(gTrick diamondsLed:)
			)
			(3
				(gTrick heartsLed:)
			)
		)
	)

	(method (lowestNonTrump param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp1 17)
		(= temp5 0)
		(for ((= temp0 0)) (<= temp0 3) ((++ temp0))
			(if (== temp0 (gTrick trump:))
			else
				(for ((= temp4 0)) (< temp4 (param1 size:)) ((++ temp4))
					(if (self sameSuit: (param1 at: temp4) temp0 leftSuit)
						(= temp3 (param1 at: temp4))
						(cond
							((< (temp3 rank:) temp1)
								(= temp1 (temp3 rank:))
								(= temp5 temp3)
							)
							((and (== (temp3 rank:) temp1) (Random 0 1))
								(= temp1 (temp3 rank:))
								(= temp5 temp3)
							)
						)
					)
				)
			)
		)
		(return temp5)
	)

	(method (lowestSingleton param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp1 17)
		(= temp5 0)
		(for ((= temp0 0)) (<= temp0 3) ((++ temp0))
			(if (!= temp0 (gTrick trump:))
				(= temp2 0)
				(for ((= temp4 0)) (< temp4 (param1 size:)) ((++ temp4))
					(if (self sameSuit: (param1 at: temp4) temp0 leftSuit)
						(= temp3 (param1 at: temp4))
						(++ temp2)
					)
				)
				(if (== temp2 1)
					(cond
						((< (temp3 rank:) temp1)
							(= temp1 (temp3 rank:))
							(= temp5 temp3)
						)
						((and (== (temp3 rank:) temp1) (Random 0 1))
							(= temp1 (temp3 rank:))
							(= temp5 temp3)
						)
					)
				)
			)
		)
		(return temp5)
	)

	(method (lowestTrumpIsWinner param1 &tmp temp0 temp1)
		(= temp0 (self lowest: (gTrick trump:) param1))
		(= temp1 (self numHigher: temp0))
		(return (== numTrump (+ temp1 1)))
	)

	(method (rankings param1 param2)
		(return
			(switch param2
				(0 [local17 param1])
				(1 [local24 param1])
				(2 [local31 param1])
				(3 [local38 param1])
			)
		)
	)

	(method (highInHandIsMuchHigher param1)
		(if
			(>
				(-
					(self numHigher: (gTrick highCard:))
					(self
						numHigher:
							(self
								justOver:
									(gTrick suitLead:)
									param1
									(self euchreRank: (gTrick highCard:))
							)
					)
				)
				1
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (numHigher param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 (= temp2 0))) (< temp0 7) ((++ temp0))
			(if
				(>
					(= temp1
						(switch (self euchreSuit: param1)
							(0 [local17 temp0])
							(1 [local24 temp0])
							(2 [local31 temp0])
							(3 [local38 temp0])
						)
					)
					(self euchreRank: param1)
				)
				(++ temp2)
			)
		)
		(return temp2)
	)

	(method (allHigherAreKnown param1 param2 &tmp temp0 temp1)
		(= temp0 (+ (param2 rank:) 1))
		(if
			(and
				(self sameSuit: param2 (gTrick trump:) leftSuit)
				(== temp0 11)
			)
			(++ temp0)
		)
		(while
			(<=
				temp0
				(if (self sameSuit: param2 (gTrick trump:) leftSuit)
					16
				else
					14
				)
			)
			(if
				(and
					(not (self isKnownOutOfPlay: temp0 (param2 suit:)))
					(not (self hasCard: param1 temp0 (param2 suit:)))
				)
				(= temp1 (self euchreRank: upCard))
				(if
					(and
						(== global286 1)
						(not
							(self
								isKnownOutOfPlay: (upCard rank:) (upCard suit:)
							)
						)
					)
					(if (!= (self euchreRank: upCard) temp0)
						(return 0)
					)
					(cond
						(local7
							(if (!= (Dealer dealer:) global112)
								(return 0)
							)
						)
						(local8
							(if
								(and
									(!= (Dealer dealer:) global112)
									(!= (Dealer dealer:) global113)
								)
								(return 0)
							)
						)
						(
							(and
								local9
								(!= (Dealer dealer:) global112)
								(!= (Dealer dealer:) global113)
								(!= (Dealer dealer:) global114)
							)
							(return 0)
						)
					)
				)
			)
			(++ temp0)
			(if
				(and
					(self sameSuit: param2 (gTrick trump:) leftSuit)
					(== temp0 11)
				)
				(++ temp0)
			)
		)
		(return 1)
	)

	(method (justOver param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
		(for ((= temp0 (= temp2 0))) (<= temp0 6) ((++ temp0))
			(if
				(and
					(>
						(= temp1
							(switch param1
								(0 [local17 temp0])
								(1 [local24 temp0])
								(2 [local31 temp0])
								(3 [local38 temp0])
							)
						)
						param3
					)
					(= temp3 (self hasCard: param2 temp1 param1))
				)
				(= temp2 temp3)
			)
		)
		(return temp2)
	)

	(method (euchreRank param1)
		(if
			(and
				(self sameSuit: param1 (gTrick trump:) leftSuit)
				(== (param1 rank:) 11)
			)
			(if (== (param1 suit:) (gTrick trump:))
				(return 16)
			else
				(return 15)
			)
		)
		(return (param1 rank:))
	)

	(method (euchreSuit param1)
		(if
			(and
				(self sameSuit: param1 (gTrick trump:) leftSuit)
				(== (param1 rank:) 11)
			)
			(gTrick trump:)
			(return)
		)
		(param1 suit:)
	)

	(method (outOf param1 param2)
		(switch param1
			(0
				(param2 outOfSpades:)
				(return)
			)
			(1
				(param2 outOfClubs:)
				(return)
			)
			(2
				(param2 outOfDiamonds:)
				(return)
			)
			(3
				(param2 outOfHearts:)
				(return)
			)
		)
	)

	(method (canWinTrick param1 &tmp temp0 temp1 temp2)
		(= temp0 (self highest: (gTrick suitLead:) param1))
		(cond
			((== (gTrick suitLead:) (gTrick trump:))
				(= temp1 ((gTrick highCard:) rank:))
				(if (== ((gTrick highCard:) rank:) 11)
					(if (== ((gTrick highCard:) suit:) (gTrick trump:))
						(= temp1 16)
					else
						(= temp1 15)
					)
				)
				(= temp2 (temp0 rank:))
				(if (== (temp0 rank:) 11)
					(if (== (temp0 suit:) (gTrick trump:))
						(= temp2 16)
					else
						(= temp2 15)
					)
				)
				(if (> temp2 temp1)
					(return 1)
				)
			)
			(
				(and
					(not
						(self
							sameSuit:
								(gTrick highCard:)
								(gTrick trump:)
								leftSuit
						)
					)
					(> (temp0 rank:) ((gTrick highCard:) rank:))
				)
				(return 1)
			)
		)
		(return 0)
	)

	(method (haveTrump param1 &tmp temp0 temp1)
		(for ((= temp1 (= temp0 0))) (< temp1 (param1 size:)) ((++ temp1))
			(+=
				temp0
				(or
					(== ((param1 at: temp1) suit:) (gTrick trump:))
					(and
						(== ((param1 at: temp1) suit:) leftSuit)
						(== ((param1 at: temp1) rank:) 11)
					)
				)
			)
		)
		(return temp0)
	)

	(method (calcRankings param1 &tmp temp0 temp1)
		(switch param1
			(0
				(for ((= temp1 0)) (< temp1 7) ((++ temp1))
					(= [local17 temp1] 0)
				)
			)
			(1
				(for ((= temp1 0)) (< temp1 7) ((++ temp1))
					(= [local24 temp1] 0)
				)
			)
			(2
				(for ((= temp1 0)) (< temp1 7) ((++ temp1))
					(= [local31 temp1] 0)
				)
			)
			(3
				(for ((= temp1 0)) (< temp1 7) ((++ temp1))
					(= [local38 temp1] 0)
				)
			)
		)
		(= temp0 0)
		(if (== param1 (gTrick trump:))
			(for ((= temp1 0)) (< temp1 7) ((++ temp1))
				(= [local10 temp1] 0)
			)
			(if (not (self isKnownOutOfPlay: 11 (gTrick trump:)))
				(= [local10 temp0] 16)
				(self setRanking: param1 16 temp0)
				(++ temp0)
			)
			(if (not (self isKnownOutOfPlay: 11 leftSuit))
				(= [local10 temp0] 15)
				(self setRanking: param1 15 temp0)
				(++ temp0)
			)
			(if (not (self isKnownOutOfPlay: 14 (gTrick trump:)))
				(= [local10 temp0] 14)
				(self setRanking: param1 14 temp0)
				(++ temp0)
			)
			(if (not (self isKnownOutOfPlay: 13 (gTrick trump:)))
				(= [local10 temp0] 13)
				(self setRanking: param1 13 temp0)
				(++ temp0)
			)
			(if (not (self isKnownOutOfPlay: 12 (gTrick trump:)))
				(= [local10 temp0] 12)
				(self setRanking: param1 12 temp0)
				(++ temp0)
			)
			(if (not (self isKnownOutOfPlay: 10 (gTrick trump:)))
				(= [local10 temp0] 10)
				(self setRanking: param1 10 temp0)
				(++ temp0)
			)
			(if (not (self isKnownOutOfPlay: 9 (gTrick trump:)))
				(= [local10 temp0] 9)
				(self setRanking: param1 9 temp0)
				(++ temp0)
			)
		else
			(if (not (self isKnownOutOfPlay: 14 param1))
				(self setRanking: param1 14 temp0)
				(++ temp0)
			)
			(if (not (self isKnownOutOfPlay: 13 param1))
				(self setRanking: param1 13 temp0)
				(++ temp0)
			)
			(if (not (self isKnownOutOfPlay: 12 param1))
				(self setRanking: param1 12 temp0)
				(++ temp0)
			)
			(if
				(and
					(!= leftSuit param1)
					(not (self isKnownOutOfPlay: 11 param1))
				)
				(self setRanking: param1 11 temp0)
				(++ temp0)
			)
			(if (not (self isKnownOutOfPlay: 10 param1))
				(self setRanking: param1 10 temp0)
				(++ temp0)
			)
			(if (not (self isKnownOutOfPlay: 9 param1))
				(self setRanking: param1 9 temp0)
				(++ temp0)
			)
		)
	)

	(method (haveCard param1 param2 param3 &tmp temp0 temp1)
		(if (== param2 (gTrick trump:))
			(cond
				((== [local10 param1] 16)
					(if (= temp1 (self hasCard: param3 11 (gTrick trump:)))
						(return temp1)
					)
				)
				((== [local10 param1] 15)
					(if (= temp1 (self hasCard: param3 11 leftSuit))
						(return temp1)
					)
				)
				(
					(= temp1
						(self
							hasCard: param3 [local10 param1] (gTrick trump:)
						)
					)
					(return temp1)
				)
			)
		else
			(switch param2
				(0
					(if (= temp1 (self hasCard: param3 [local17 param1] 0))
						(return temp1)
					)
				)
				(1
					(if (= temp1 (self hasCard: param3 [local24 param1] 1))
						(return temp1)
					)
				)
				(2
					(if (= temp1 (self hasCard: param3 [local31 param1] 2))
						(return temp1)
					)
				)
				(3
					(if (= temp1 (self hasCard: param3 [local38 param1] 3))
						(return temp1)
					)
				)
			)
		)
		(return 0)
	)

	(method (allOfSuitKnown param1 param2)
		(cond
			((== param2 (gTrick trump:))
				(= trumpsUnknown (- 7 param1))
				(return (== param1 7))
			)
			((== param2 leftSuit)
				(switch leftSuit
					(0
						(= spadesUnknown (- 5 param1))
					)
					(1
						(= clubsUnknown (- 5 param1))
					)
					(2
						(= diamondsUnknown (- 5 param1))
					)
					(3
						(= heartsUnknown (- 5 param1))
					)
				)
				(return (== param1 5))
			)
			(else
				(switch param2
					(0
						(= spadesUnknown (- 6 param1))
					)
					(1
						(= clubsUnknown (- 6 param1))
					)
					(2
						(= diamondsUnknown (- 6 param1))
					)
					(3
						(= heartsUnknown (- 6 param1))
					)
				)
				(return (== param1 6))
			)
		)
	)

	(method (getSingleton param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp3 0)
		(= temp4 0)
		(for ((= temp5 0)) (<= temp5 3) ((++ temp5))
			(if (== temp5 (gTrick trump:))
			else
				(= temp0 0)
				(for ((= temp6 0)) (< temp6 (param1 size:)) ((++ temp6))
					(if (self sameSuit: (param1 at: temp6) temp5 leftSuit)
						(= temp1 (param1 at: temp6))
						(++ temp0)
					)
				)
				(if
					(and
						(== temp0 1)
						(or
							(<= argc 1)
							(switch (temp1 suit:)
								(0
									(== [local17 0] (temp1 rank:))
								)
								(1
									(== [local24 0] (temp1 rank:))
								)
								(2
									(== [local31 0] (temp1 rank:))
								)
								(3
									(== [local38 0] (temp1 rank:))
								)
							)
						)
					)
					(if (>= argc 2)
						(return temp1)
					)
					(cond
						((> (temp1 rank:) temp3)
							(= temp3 (temp1 rank:))
							(= temp4 temp1)
						)
						((and (== (temp1 rank:) temp3) (Random 0 1))
							(= temp3 (temp1 rank:))
							(= temp4 temp1)
						)
					)
				)
			)
		)
		(return temp4)
	)

	(method (haveSuitAnyoneLead param1 param2 &tmp temp0 temp1)
		(= temp0 0)
		(if
			(and
				(gTrick spadesLed:)
				(!= (gTrick trump:) 0)
				(or
					(not param2)
					(not ((param1 leftOpponent:) outOfSpades:))
					((param1 leftOpponent:) outOfTrump:)
				)
				(or
					(not param2)
					(not ((param1 rightOpponent:) outOfSpades:))
					((param1 leftOpponent:) outOfTrump:)
				)
			)
			(= temp0 (= temp1 (self highest: 0 param1)))
		)
		(if
			(and
				(gTrick clubsLed:)
				(!= (gTrick trump:) 1)
				(or
					(not param2)
					(not ((param1 leftOpponent:) outOfClubs:))
					((param1 leftOpponent:) outOfTrump:)
				)
				(or
					(not param2)
					(not ((param1 rightOpponent:) outOfClubs:))
					((param1 leftOpponent:) outOfTrump:)
				)
				(= temp1 (self highest: 1 param1))
			)
			(if (not temp0)
				(= temp0 temp1)
			else
				(if (> (temp1 rank:) (temp0 rank:))
					(= temp0 temp1)
				)
				(if (and (== (temp1 rank:) (temp0 rank:)) (Random 0 1))
					(= temp0 temp1)
				)
			)
		)
		(if
			(and
				(gTrick diamondsLed:)
				(!= (gTrick trump:) 2)
				(or
					(not param2)
					(not ((param1 leftOpponent:) outOfDiamonds:))
					((param1 leftOpponent:) outOfTrump:)
				)
				(or
					(not param2)
					(not ((param1 rightOpponent:) outOfDiamonds:))
					((param1 leftOpponent:) outOfTrump:)
				)
				(= temp1 (self highest: 2 param1))
			)
			(if (not temp0)
				(= temp0 temp1)
			else
				(if (> (temp1 rank:) (temp0 rank:))
					(= temp0 temp1)
				)
				(if (and (== (temp1 rank:) (temp0 rank:)) (Random 0 1))
					(= temp0 temp1)
				)
			)
		)
		(if
			(and
				(gTrick heartsLed:)
				(!= (gTrick trump:) 3)
				(or
					(not param2)
					(not ((param1 leftOpponent:) outOfHearts:))
					((param1 leftOpponent:) outOfTrump:)
				)
				(or
					(not param2)
					(not ((param1 rightOpponent:) outOfHearts:))
					((param1 leftOpponent:) outOfTrump:)
				)
				(= temp1 (self highest: 3 param1))
			)
			(if (not temp0)
				(= temp0 temp1)
			else
				(if (> (temp1 rank:) (temp0 rank:))
					(= temp0 temp1)
				)
				(if (and (== (temp1 rank:) (temp0 rank:)) (Random 0 1))
					(= temp0 temp1)
				)
			)
		)
		(return temp0)
	)

	(method (haveSuitPartnerLead param1 &tmp temp0 temp1)
		(= temp0 0)
		(if
			(and
				(== (gTrick spadesLed:) (param1 partner:))
				(!= (gTrick trump:) 0)
			)
			(= temp0 (= temp1 (self highest: 0 param1)))
		)
		(if
			(and
				(== (gTrick clubsLed:) (param1 partner:))
				(!= (gTrick trump:) 1)
			)
			(= temp1 (self highest: 1 param1))
			(if (not temp0)
				(= temp0 temp1)
			else
				(if (> (temp1 rank:) (temp0 rank:))
					(= temp0 temp1)
				)
				(if (and (== (temp1 rank:) (temp0 rank:)) (Random 0 1))
					(= temp0 temp1)
				)
			)
		)
		(if
			(and
				(== (gTrick diamondsLed:) (param1 partner:))
				(!= (gTrick trump:) 2)
			)
			(= temp1 (self highest: 2 param1))
			(if (not temp0)
				(= temp0 temp1)
			else
				(if (> (temp1 rank:) (temp0 rank:))
					(= temp0 temp1)
				)
				(if (and (== (temp1 rank:) (temp0 rank:)) (Random 0 1))
					(= temp0 temp1)
				)
			)
		)
		(if
			(and
				(== (gTrick heartsLed:) (param1 partner:))
				(!= (gTrick trump:) 3)
			)
			(= temp1 (self highest: 3 param1))
			(if (not temp0)
				(= temp0 temp1)
			else
				(if (> (temp1 rank:) (temp0 rank:))
					(= temp0 temp1)
				)
				(if (and (== (temp1 rank:) (temp0 rank:)) (Random 0 1))
					(= temp0 temp1)
				)
			)
		)
		(return temp0)
	)

	(method (highest param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
		(= temp3 0)
		(if (>= argc 3)
			(= temp3 param3)
		)
		(= temp2 0)
		(= temp1 0)
		(for ((= temp0 0)) (< temp0 (param2 size:)) ((++ temp0))
			(cond
				((== (param2 at: temp0) temp3))
				(
					(and
						(self sameSuit: (param2 at: temp0) param1 leftSuit)
						(> (self euchreRank: (param2 at: temp0)) temp2)
					)
					(= temp2 (self euchreRank: (param2 at: temp0)))
					(= temp1 (param2 at: temp0))
				)
			)
		)
		(return temp1)
	)

	(method (lowest param1 param2 &tmp temp0 temp1 temp2)
		(= temp2 17)
		(= temp1 0)
		(for ((= temp0 0)) (< temp0 (param2 size:)) ((++ temp0))
			(if
				(and
					(self sameSuit: (param2 at: temp0) param1 leftSuit)
					(< (self euchreRank: (param2 at: temp0)) temp2)
				)
				(= temp2 (self euchreRank: (param2 at: temp0)))
				(= temp1 (param2 at: temp0))
			)
		)
		(return temp1)
	)

	(method (highestNonTrump param1 &tmp temp0 temp1 temp2)
		(= temp0 0)
		(= temp2 0)
		(for ((= temp1 0)) (< temp1 (param1 size:)) ((++ temp1))
			(if
				(and
					(not
						(self
							sameSuit:
								(param1 at: temp1)
								(gTrick trump:)
								leftSuit
						)
					)
					(or
						(> ((param1 at: temp1) rank:) temp0)
						(and (== ((param1 at: temp1) rank:) temp0) (Random 0 1))
					)
				)
				(= temp0 ((param1 at: temp1) rank:))
				(= temp2 (param1 at: temp1))
			)
		)
		(return temp2)
	)

	(method (haveWinnerInUnplayedSuit param1 param2 &tmp temp0 temp1 temp2 temp3)
		(= temp1 0)
		(= temp0 0)
		(for ((= temp2 3)) (>= temp2 0) ((-- temp2))
			(if
				(= temp3
					(self highest: temp2 param1 (if (>= argc 2) param2 else 0))
				)
				(switch temp2
					(0
						(if
							(and
								(not (gTrick spadesLed:))
								(== (temp3 rank:) [local17 0])
								(> spadesUnknown temp1)
							)
							(= temp1 spadesUnknown)
							(= temp0 temp3)
						)
					)
					(1
						(if
							(and
								(not (gTrick clubsLed:))
								(== (temp3 rank:) [local24 0])
								(> clubsUnknown temp1)
							)
							(= temp1 clubsUnknown)
							(= temp0 temp3)
						)
					)
					(2
						(if
							(and
								(not (gTrick diamondsLed:))
								(== (temp3 rank:) [local31 0])
								(> diamondsUnknown temp1)
							)
							(= temp1 diamondsUnknown)
							(= temp0 temp3)
						)
					)
					(3
						(if
							(and
								(not (gTrick heartsLed:))
								(== (temp3 rank:) [local38 0])
								(> heartsUnknown temp1)
							)
							(= temp1 heartsUnknown)
							(= temp0 temp3)
						)
					)
				)
			)
		)
		(return temp0)
	)

	(method (haveWinner param1 param2 &tmp temp0 temp1 temp2 temp3)
		(= temp0 0)
		(for ((= temp2 0)) (<= temp2 3) ((++ temp2))
			(if
				(= temp3
					(self highest: temp2 param1 (if (>= argc 2) param2 else 0))
				)
				(switch temp2
					(0
						(if
							(and
								(== (temp3 rank:) [local17 0])
								(or (not temp0) (Random 0 1))
							)
							(= temp0 temp3)
						)
					)
					(1
						(if
							(and
								(== (temp3 rank:) [local24 0])
								(or (not temp0) (Random 0 1))
							)
							(= temp0 temp3)
						)
					)
					(2
						(if
							(and
								(== (temp3 rank:) [local31 0])
								(or (not temp0) (Random 0 1))
							)
							(= temp0 temp3)
						)
					)
					(3
						(if
							(and
								(== (temp3 rank:) [local38 0])
								(or (not temp0) (Random 0 1))
							)
							(= temp0 temp3)
						)
					)
				)
			)
		)
		(return temp0)
	)

	(method (haveCardInUnplayedSuit param1 &tmp temp0 temp1 temp2)
		(= temp1 0)
		(for ((= temp0 0)) (<= temp0 3) ((++ temp0))
			(= temp2 0)
			(switch temp0
				(0
					(if (not (gTrick spadesLed:))
						(= temp2 (self highest: 0 param1))
					)
				)
				(1
					(if (not (gTrick clubsLed:))
						(= temp2 (self highest: 1 param1))
					)
				)
				(2
					(if (not (gTrick diamondsLed:))
						(= temp2 (self highest: 2 param1))
					)
				)
				(3
					(if (not (gTrick heartsLed:))
						(= temp2 (self highest: 3 param1))
					)
				)
			)
			(if temp2
				(cond
					((not temp1)
						(= temp1 temp2)
					)
					((Random 0 1)
						(= temp1 temp2)
					)
				)
			)
		)
		(return temp1)
	)

	(method (getBestSecondHigh param1 param2 &tmp temp0 temp1 temp2 temp3)
		(= temp0 0)
		(for ((= temp2 0)) (<= temp2 3) ((++ temp2))
			(if (== temp2 (gTrick trump:))
			else
				(= temp1 0)
				(= temp3 (if (== param2 3) 9 else 0))
				(switch temp2
					(0
						(= temp1 (self haveCard: 1 0 param1))
						(cond
							((== param2 3)
								(if (< spadesUnknown temp3)
									(= temp3 spadesUnknown)
									(= temp0 temp1)
								)
							)
							((> spadesUnknown temp3)
								(= temp3 spadesUnknown)
								(= temp0 temp1)
							)
						)
						(if (and (== spadesUnknown temp3) (Random 0 1))
							(= temp0 temp1)
						)
					)
					(1
						(= temp1 (self haveCard: 1 1 param1))
						(cond
							((== param2 3)
								(if (< clubsUnknown temp3)
									(= temp3 clubsUnknown)
									(= temp0 temp1)
								)
							)
							((> clubsUnknown temp3)
								(= temp3 clubsUnknown)
								(= temp0 temp1)
							)
						)
						(if (and (== clubsUnknown temp3) (Random 0 1))
							(= temp0 temp1)
						)
					)
					(2
						(= temp1 (self haveCard: 1 2 param1))
						(cond
							((== param2 3)
								(if (< diamondsUnknown temp3)
									(= temp3 diamondsUnknown)
									(= temp0 temp1)
								)
							)
							((> diamondsUnknown temp3)
								(= temp3 diamondsUnknown)
								(= temp0 temp1)
							)
						)
						(if (and (== diamondsUnknown temp3) (Random 0 1))
							(= temp0 temp1)
						)
					)
					(3
						(= temp1 (self haveCard: 1 3 param1))
						(cond
							((== param2 3)
								(if (< heartsUnknown temp3)
									(= temp3 heartsUnknown)
									(= temp0 temp1)
								)
							)
							((> heartsUnknown temp3)
								(= temp3 heartsUnknown)
								(= temp0 temp1)
							)
						)
						(if (and (== heartsUnknown temp3) (Random 0 1))
							(= temp0 temp1)
						)
					)
				)
			)
		)
		(return temp0)
	)

	(method (isFinessePossible param1 &tmp temp0 temp1 temp2 temp3)
		(= temp0 0)
		(for ((= temp3 0)) (and (< temp3 7) [local10 temp3]) ((++ temp3))
			(if (> [local10 temp3] (upCard rank:))
				(++ temp0)
			)
		)
		(= temp1 0)
		(= temp2 (self haveCard: 0 (gTrick trump:) param1))
		(if
			(or
				(== (temp2 rank:) 11)
				(and (== (temp2 rank:) 14) (== (upCard rank:) 13))
			)
			(++ temp1)
		)
		(= temp2 (self haveCard: 1 (gTrick trump:) param1))
		(if
			(or
				(== (temp2 rank:) 11)
				(and (== (temp2 rank:) 14) (== (upCard rank:) 13))
			)
			(++ temp1)
		)
		(= temp2 (self haveCard: 2 (gTrick trump:) param1))
		(if (and (== (temp2 rank:) 14) (== (upCard rank:) 13))
			(++ temp1)
		)
		(return (!= temp1 temp0))
	)

	(method (setRanking param1 param2 param3)
		(switch param1
			(0
				(= [local17 param3] param2)
			)
			(1
				(= [local24 param3] param2)
			)
			(2
				(= [local31 param3] param2)
			)
			(3
				(= [local38 param3] param2)
			)
		)
	)

	(method (sameSuit param1 param2 param3)
		(cond
			((and (== (param1 rank:) 11) (== (param1 suit:) param3))
				(if (== param2 (gTrick trump:))
					(return 1)
				)
			)
			((== (param1 suit:) param2)
				(return 1)
			)
		)
		(return 0)
	)

	(method (numPlayed param1 param2 &tmp temp0 temp1 temp2)
		(= temp1 0)
		(for ((= temp2 0)) (< temp2 ((ScriptID 15 1) size:)) ((++ temp2)) ; discardList
			(if (self sameSuit: ((ScriptID 15 1) at: temp2) param1 param2) ; discardList
				(++ temp1)
			)
		)
		(for ((= temp2 0)) (< temp2 (gTrick size:)) ((++ temp2))
			(if (self sameSuit: (gTrick at: temp2) param1 param2)
				(++ temp1)
			)
		)
		(return temp1)
	)

	(method (numKnown param1 param2 param3 param4 &tmp temp0 temp1)
		(= temp0 0)
		(for ((= temp1 0)) (< temp1 (param3 size:)) ((++ temp1))
			(if (self sameSuit: (param3 at: temp1) param1 param2)
				(++ temp0)
			)
		)
		(cond
			((== global286 1)
				(cond
					((== param3 (Dealer dealer:))
						(if (== suitTurnedDown param1)
							(++ temp0)
						)
					)
					(
						(and
							(== (param4 suit:) param1)
							(== (param3 partner:) (Dealer dealer:))
							(not
								(self
									isKnownOutOfPlay:
										(param4 rank:)
										(param4 suit:)
								)
							)
						)
						(++ temp0)
					)
				)
			)
			((self sameSuit: param4 param1 param2)
				(++ temp0)
			)
		)
		(return temp0)
	)

	(method (isKnownOutOfPlay param1 param2 &tmp temp0 temp1)
		(if (== param1 15)
			(= param1 11)
			(= param2 leftSuit)
		)
		(if (== param1 16)
			(= param1 11)
		)
		(for ((= temp0 0)) (< temp0 ((ScriptID 15 1) size:)) ((++ temp0)) ; discardList
			(if
				(and
					(== (((ScriptID 15 1) at: temp0) rank:) param1) ; discardList
					(== (((ScriptID 15 1) at: temp0) suit:) param2) ; discardList
				)
				(return 1)
			)
		)
		(for ((= temp0 0)) (< temp0 (gTrick size:)) ((++ temp0))
			(if
				(and
					(== ((gTrick at: temp0) rank:) param1)
					(== ((gTrick at: temp0) suit:) param2)
				)
				(return 1)
			)
		)
		(if
			(and
				(== global286 1)
				(== (Dealer curPlayer:) (Dealer dealer:))
				(== (discardedCard rank:) param1)
				(== (discardedCard suit:) param2)
			)
			(return 1)
		)
		(return 0)
	)

	(method (hasCard param1 param2 param3 &tmp temp0)
		(if (== param2 15)
			(= param2 11)
			(= param3 leftSuit)
		)
		(if (== param2 16)
			(= param2 11)
		)
		(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
			(if
				(and
					(== ((param1 at: temp0) rank:) param2)
					(== ((param1 at: temp0) suit:) param3)
				)
				(return (param1 at: temp0))
			)
		)
		(return 0)
	)
)

