;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 718)
(include sci.sh)
(use Main)
(use BScore)
(use n709)
(use bidBoxWindow)
(use System)

(public
	compete_tree 0
)

(local
	[local0 6]
)

(procedure (localproc_0 param1)
	(return (not [local0 param1]))
)

(procedure (localproc_1 param1)
	(return (== [local0 param1] 1))
)

(instance compete_tree of Code
	(properties)

	(method (init &tmp temp0)
		(super init: &rest)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(= [local0 temp0] 0)
		)
	)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (doit param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 [temp12 5] temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24 temp25 temp26 temp27 temp28 temp29 temp30 temp31 temp32 [temp33 3] temp36 temp37 temp38 temp39 temp40 temp41 temp42 temp43 temp44 temp45 temp46 temp47 temp48 temp49 temp50 temp51 [temp52 6] [temp58 6] [temp64 6] [temp70 5] [temp75 5] temp80 temp81 temp82)
		(for ((= temp10 0)) (< temp10 5) ((++ temp10))
			(= [temp12 temp10] 0)
			(= [temp75 temp10] 0)
			(= [temp70 temp10] 0)
		)
		(for ((= temp10 0)) (< temp10 6) ((++ temp10))
			(= [temp52 temp10] 0)
			(= [temp58 temp10] 0)
			(= [temp64 temp10] 0)
		)
		(= temp48 (param1 partner:))
		(= temp3 (param1 points:))
		(= temp4 (param1 hcp:))
		(= temp5 (param1 playingTricks:))
		(= temp6 (param1 shape:))
		(= temp7 (param1 longSuit:))
		(= temp28 (param1 combinedPts:))
		(= temp32 (param1 agreedSuit:))
		(= temp36 (param1 combinedCards:))
		(= temp29 (OneOf temp6 17203 17458 21298))
		(= temp41 (temp48 bidBranch:))
		(= temp82 (param1 bidBranch:))
		(param1 bidBranch: 0)
		(= temp81 (param1 bidsOpen:))
		(if (OneOf (param1 location:) 1 3)
			(= temp42 (BScore weGamesWon:))
			(= temp43 (BScore theyGamesWon:))
		else
			(= temp43 (BScore weGamesWon:))
			(= temp42 (BScore theyGamesWon:))
		)
		(= [temp12 0] 0)
		(= [temp12 2] (param1 diamonds:))
		(= [temp12 1] (param1 clubs:))
		(= [temp12 3] (param1 hearts:))
		(= [temp12 4] (param1 spades:))
		(= temp80 [temp12 temp7])
		(= [temp75 1] (param1 partnerClubs:))
		(= [temp75 2] (param1 partnerDiamonds:))
		(= [temp75 3] (param1 partnerHearts:))
		(= [temp75 4] (param1 partnerSpades:))
		(= temp44 (param1 location:))
		(= temp45 (temp48 location:))
		(= temp31 0)
		(= temp17 (= temp8 (= temp21 0)))
		(for ((= temp10 0)) (< temp10 6) ((++ temp10))
			(= [local0 temp10]
				(= [temp52 temp10] (= [temp64 temp10] (= [temp58 temp10] 0)))
			)
		)
		(= temp10 0)
		(= temp23 (BidBox size:))
		(while (< temp10 temp23)
			(= temp46 (BidBox at: temp10))
			(= temp24 (temp46 location:))
			(if
				(and
					(!= (temp46 bidNumber:) 0)
					(OneOf temp24 temp44 temp45)
				)
				(++ temp31)
			)
			(if
				(and
					(not (temp46 artificial:))
					(not (OneOf (temp46 bidNumber:) 0 50 99))
					(<= 1 (= temp1 (temp46 suit:)) 5)
				)
				(++ [local0 temp1])
				(if (OneOf temp24 temp44 temp45)
					(++ [temp52 temp1])
					(if (== temp24 temp44)
						(= temp17 temp1)
					else
						(++ [temp64 temp1])
						(= temp8 temp1)
					)
				else
					(++ [temp58 temp1])
					(= temp21 temp1)
				)
			)
			(++ temp10)
		)
		(for ((= temp10 1)) (<= temp10 4) ((++ temp10))
			(if (not (= [temp70 temp10] (param1 stops: temp10 1)))
				(= [temp70 temp10] [temp52 temp10])
			)
		)
		(= temp9 (+ 1 (/ (- param2 1) 5)))
		(= temp50 [temp70 temp21])
		(= temp22 (proc709_0 temp17 (param1 minLevel: temp17)))
		(= temp19 (+ 1 (mod (- global427 1) 5)))
		(= temp20 (+ 1 (/ (- global427 1) 5)))
		(= temp47 (+ 1 (/ (- (BidBox openingBidValue:) 1) 5)))
		(= temp30 (temp48 firstBidSuit:))
		(= temp39
			(switch param1
				((ScriptID 700 2) ; hand1
					(ScriptID 700 3) ; hand2
				)
				((ScriptID 700 3) ; hand2
					(ScriptID 700 4) ; hand3
				)
				((ScriptID 700 4) ; hand3
					(ScriptID 700 5) ; hand4
				)
				(else
					(ScriptID 700 2) ; hand1
				)
			)
		)
		(= temp40
			(switch param1
				((ScriptID 700 2) ; hand1
					(ScriptID 700 5) ; hand4
				)
				((ScriptID 700 3) ; hand2
					(ScriptID 700 2) ; hand1
				)
				((ScriptID 700 4) ; hand3
					(ScriptID 700 3) ; hand2
				)
				(else
					(ScriptID 700 4) ; hand3
				)
			)
		)
		(or
			(and (proc709_1 param1 4) (= temp18 4))
			(and (proc709_1 param1 3) (= temp18 3))
			(and (proc709_1 param1 2) (= temp18 2))
			(and (proc709_1 param1 1) (= temp18 1))
			(= temp18 0)
		)
		(= temp38 (+ [temp12 temp8] [temp75 temp8]))
		(= temp23 temp7)
		(= temp24 (param1 longSuit: 2))
		(= temp7
			(if (== [temp12 temp23] [temp12 temp24])
				(if (>= (param1 calcHCP: temp23) (param1 calcHCP: temp24))
					temp23
				else
					temp24
				)
			else
				temp7
			)
		)
		(= temp37 (proc709_0 temp7 (= temp23 (param1 minLevel: temp7))))
		(= temp0 0)
		(= temp24 0)
		(cond
			(
				(not
					(or
						(temp48 forcing:)
						(== temp41 17)
						(>= temp28 (+ 13 (* temp23 3)))
						(and
							(>= (+ temp4 temp80) (+ 12 temp23 temp23))
							(or
								temp31
								(>= temp80 7)
								(>= temp3 (+ 5 (* 4 temp23)))
							)
						)
					)
				)
				(= temp0 0)
			)
			((and (== param2 0) (not temp81) (== (BidBox openingBidValue:) 5))
				(cond
					((param1 directSeat:)
						(cond
							(
								(or
									(>= temp4 24)
									(<= 18 temp5 21)
									(and
										(< temp4 23)
										(or
											(and
												(>= [temp12 (= temp1 2)] 6)
												(>
													(param1 calcTricks: temp1)
													(/ temp5 2)
												)
											)
											(and
												(>= [temp12 (= temp1 1)] 6)
												(>
													(param1 calcTricks: temp1)
													(/ temp5 2)
												)
											)
										)
									)
									[temp70 4]
									[temp70 3]
									[temp70 2]
									[temp70 1]
								)
								(= temp0 15)
								(proc709_4 param1 18 27 0 8 0 8 0 7 0 7)
							)
							((and (>= temp4 15) temp29)
								(= temp0 50)
								(= global439 1)
								(param1 bidBranch: 17)
								(proc709_4 param1 15 27 0 7 0 7 0 7 0 7)
							)
							((>= temp5 6)
								(= temp0 temp37)
								(proc709_4 param1 11 20 0 6 0 6 0 6 0 6)
								(proc709_5 param1 temp7 5 11)
								(param1 bidBranch: 3)
							)
							(else
								(= temp0 0)
								(proc709_4 param1 0 16 0 7 0 7 0 7 0 7)
							)
						)
					)
					((!= global427 (BidBox openingBidValue:))
						(cond
							((>= temp5 (* (- 8 temp20) 2))
								(= temp0 50)
								(= global439 1)
								(param1 bidBranch: 17)
								(proc709_4 param1 12 25 0 7 0 7 0 7 0 7)
							)
							(
								(and
									(>= temp80 6)
									(>= temp4 11)
									(or
										(param1 canBid: (proc709_0 temp7 2))
										(>= temp5 14)
										(>= temp3 19)
									)
								)
								(= temp0 temp37)
								(proc709_4 param1 11 20 0 5 0 5 0 5 0 5)
								(proc709_5 param1 temp7 5 11)
								(param1 bidBranch: 3)
							)
							(else
								(= temp0 0)
								(proc709_4 param1 0 16 0 7 0 7 0 7 0 7)
							)
						)
					)
					((or (>= temp3 19) (and (>= temp4 11) temp18))
						(= temp0 temp37)
						(proc709_4 param1 11 20 0 6 0 6 0 6 0 6)
						(proc709_5 param1 temp7 6 11)
						(param1 bidBranch: 3)
					)
					(else
						(= temp0 0)
						(proc709_4 param1 0 16 0 7 0 7 0 7 0 7)
					)
				)
			)
			(
				(and
					(== param2 0)
					(not temp81)
					(or
						(< 0 global427 6)
						(= temp24
							(if
								(and
									(<
										6
										(= temp23 (BidBox openingBidValue:))
										10
									)
									(<= temp20 3)
									(== temp19 (+ 1 (mod (- temp23 1) 5)))
								)
								2
							else
								0
							)
						)
					)
				)
				(cond
					(
						(and
							(!= temp19 5)
							(or
								(>= temp4 21)
								(and (>= temp5 18) (>= temp4 (+ 17 temp24)))
							)
						)
						(= temp0 (+ global427 5))
						(proc709_4 param1 21 28 0 9 0 9 0 9 0 9)
						(param1 bidBranch: 1 forcing: 1)
						(= global439 1)
					)
					((and (>= temp3 19) temp18 (not [temp58 temp18]))
						(= temp0
							(proc709_0 temp18 (+ (param1 minLevel: temp18) 1))
						)
						(param1 bidBranch: 2)
						(proc709_4 param1 19 23 0 4 0 4 0 4 0 4)
						(proc709_5 param1 temp18 5 10)
					)
					(
						(and
							(<= (+ 15 temp24) temp4 (+ 18 temp24))
							(param1 directSeat:)
							temp29
							(>= temp50 2)
						)
						(cond
							((not temp24)
								(= temp0 (proc709_0 5 (param1 minLevel: 5)))
								(proc709_4 param1 15 18 2 5 2 5 2 5 2 5)
							)
							((< global427 10)
								(= temp0 10)
								(proc709_4 param1 17 20 2 5 2 5 2 5 2 5)
							)
							(
								(and
									(>= [temp12 temp21] 3)
									(>= (param1 calcHCP: temp21) 5)
								)
								(= temp0 (param1 minLevel: 5))
								(proc709_4 param1 17 20 2 5 2 5 2 5 2 5)
							)
							(else
								(= temp0 0)
							)
						)
					)
					((and (>= temp3 (+ 17 temp24)) (< (& temp6 $0f00) 1280))
						(= temp0 50)
						(= global439 1)
						(param1 bidBranch: 17)
						(proc709_4 param1 11 20 0 8 0 8 0 8 0 8)
					)
					(
						(and
							(>= temp3 (+ 15 temp24))
							(< (& temp6 $0f00) 1280)
							(or
								(and
									(>= [temp12 4] 6)
									(>= (param1 calcHCP: 4) 8)
								)
								(and
									(>= [temp12 3] 6)
									(>= (param1 calcHCP: 3) 8)
								)
								(and
									(>= [temp12 2] 6)
									(>= (param1 calcHCP: 2) 8)
								)
								(and
									(>= [temp12 1] 6)
									(>= (param1 calcHCP: 1) 8)
								)
							)
						)
						(= temp0 50)
						(= global439 1)
						(param1 bidBranch: 17)
						(proc709_4 param1 11 20 0 8 0 8 0 8 0 8)
					)
					(
						(and
							(>= temp3 (+ 13 temp24))
							(or [local0 4] (>= [temp12 4] 4))
							(or [local0 3] (>= [temp12 3] 4))
							(or [local0 2] (>= [temp12 2] 3))
							(or [local0 1] (>= [temp12 1] 3))
							(or
								(u< temp6 20480)
								(not (= temp23 (param1 calcHCP: temp7)))
								(and (!= temp7 4) (> (param1 spadeHCP:) temp23))
								(and (!= temp7 3) (> (param1 heartHCP:) temp23))
								(and
									(!= temp7 2)
									(> (param1 diamondHCP:) temp23)
								)
								(and (!= temp7 1) (> (param1 clubHCP:) temp23))
							)
						)
						(= temp0 50)
						(= global439 1)
						(param1 bidBranch: 17)
						(proc709_4 param1 11 20 0 8 0 8 0 8 0 8)
					)
					(
						(and
							(>= temp4 (+ 11 temp24))
							(or (== temp6 17473) (== temp6 21568))
							(<= [temp12 temp19] 2)
						)
						(= temp0 50)
						(= global439 1)
						(param1 bidBranch: 17)
						(proc709_4 param1 11 20 0 8 0 8 0 8 0 8)
					)
					(
						(and
							(not [temp58 temp7])
							(or
								(and
									(>= temp80 5)
									(>= (param1 calcTricks: temp7) 3)
								)
								(and
									(>= temp80 4)
									(>= (param1 calcTricks: temp7) 5)
								)
							)
							(>= temp3 7)
							(or
								(param1
									canBid: (= temp23 (proc709_0 temp7 temp20))
								)
								(not (= temp23 (proc709_0 temp7 (+ temp20 1))))
								(>= temp3 (+ 12 temp24))
								(and (>= temp3 (+ 10 temp24)) (>= temp80 5))
							)
						)
						(param1 bidBranch: 3)
						(= temp0 temp23)
						(proc709_4 param1 7 16 0 5 0 5 0 5 0 5)
						(proc709_5 param1 temp7 5 10)
					)
					((and (u>= temp6 28672) (>= temp5 11))
						(if
							(!=
								(= temp0
									(proc709_8 param1 temp7 temp5 temp20 2)
								)
								0
							)
							(temp39 preempted: 1)
							(temp40 preempted: 1)
						)
					)
					(else
						(= temp0 0)
					)
				)
				(if (== temp0 0)
					(proc709_4 param1 0 14 0 6 0 6 0 6 0 6)
				)
			)
			((== (BidBox openingBidValue:) 6)
				(if (and (u>= temp6 28672) (>= temp5 11))
					(if (!= (= temp0 (proc709_8 param1 temp7 temp5 temp20 1)) 0)
						(temp39 preempted: 1)
						(temp40 preempted: 1)
					)
				else
					(= temp0 0)
					(proc709_4 param1 0 16 0 7 0 7 0 7 0 7)
				)
			)
			((and (== (param1 preempted:) 1) (not [temp58 temp7]))
				(param1 preempted: 0)
				(temp48 preempted: 2)
				(cond
					((and (>= temp5 22) (<= temp20 3))
						(= temp0 761)
						(proc709_4 param1 15 37 0 10 0 10 0 10 0 10)
						(param1 bidTree: 761 forcing: 1)
						(= global439 1)
					)
					(
						(and
							(>= (= temp23 (param1 calcTricks:)) 9)
							(or (>= temp7 3) (>= temp23 10))
						)
						(= temp0
							(proc709_0 temp7 (param1 findGameLevel: temp7))
						)
						(proc709_4 param1 5 26 0 5 0 5 0 5 0 5)
						(proc709_5 param1 temp7 7 12)
						(param1 bidBranch: 3)
						(if (not (param1 canBid: temp0))
							(if
								(and
									(== global427 19)
									(== temp7 3)
									(>= temp3 10)
									(param1 canBid: 23)
								)
								(= temp0 23)
								(proc709_4 param1 5 26 0 5 0 5 7 11 0 5)
							else
								(= temp0 0)
								(proc709_4 param1 0 16 0 7 0 7 0 7 0 7)
								(temp48 preempted: 1)
							)
						)
					)
					(
						(and
							(or
								(and (>= temp4 22) (== temp20 4))
								(and (>= temp4 20) (<= temp20 3))
							)
							(>= temp50 2)
						)
						(= temp0 (proc709_0 5 (param1 minLevel: 5)))
						(if (== temp20 3)
							(proc709_4 param1 20 27 2 6 2 6 2 6 2 6)
						else
							(proc709_4 param1 22 27 2 6 2 6 2 6 2 6)
						)
					)
					((<= temp20 3)
						(cond
							(
								(and
									(>= temp3 15)
									(or [local0 3] (>= [temp12 3] 4))
									(or [local0 4] (>= [temp12 4] 4))
									(or [local0 2] (>= [temp12 2] 3))
									(or [local0 1] (>= [temp12 1] 3))
								)
								(= temp0 50)
								(= global439 1)
								(param1 bidBranch: 17)
								(proc709_4 param1 15 25 7 10 0 5 0 5 0 5)
							)
							((and temp18 (>= temp3 15))
								(= temp0
									(proc709_0 temp18 (param1 minLevel: temp18))
								)
								(proc709_4 param1 13 27 0 6 0 6 0 6 0 6)
								(proc709_5 param1 temp18 5 11)
								(param1 bidBranch: 3)
							)
							(else
								(= temp0 0)
								(proc709_4 param1 0 16 0 7 0 7 0 7 0 7)
								(temp48 preempted: 1)
							)
						)
					)
					(
						(>=
							(+
								(param1 quickTricks:)
								(param1 calcTricks: temp21)
							)
							(- 18 (+ temp20 temp20))
						)
						(= temp0 50)
						(proc709_4 param1 15 25 7 10 0 5 0 5 0 5)
					)
					(
						(>=
							temp5
							(*
								2
								(+
									5
									(= temp23 (param1 minLevel: temp7))
									(if (and temp43 (not temp42)) -1 else 0)
								)
							)
						)
						(= temp0 (proc709_0 temp7 temp23))
						(proc709_4 param1 13 20 0 5 0 5 0 5 0 5)
						(proc709_5 param1 temp7 3 10)
						(param1 bidBranch: 3)
					)
					(else
						(= temp0 0)
						(proc709_4 param1 0 16 0 7 0 7 0 7 0 7)
						(temp48 preempted: 1)
					)
				)
			)
			((== (param1 preempted:) 2)
				(param1 preempted: 0)
				(cond
					((== param2 20)
						(param1 bidTree: 761 forcing: 1)
						(= global439 1)
						(= temp0 761)
						(proc709_4 param1 0 20 0 6 0 6 0 6 0 6)
					)
					(
						(or
							(and (== param2 15) (>= temp4 12))
							(and
								(== param2 20)
								(!= (temp48 bidTree:) 761)
								(>= temp4 10)
							)
						)
						(= temp0 30)
						(proc709_4 param1 10 15 2 5 2 5 2 5 2 5)
					)
					(
						(and
							(or
								(>= (param1 quickTricks:) 6)
								(>= (param1 calcTricks:) 8)
							)
							(param1 supports: temp8 1)
						)
						(proc709_4 param1 11 20 0 6 0 6 0 6 0 6)
						(proc709_5 param1 temp8 3 7)
						(if (param1 canBid: 15)
							(= temp0 761)
							(param1 bidTree: 761 forcing: 1)
							(= global439 1)
						else
							(= temp0 (proc709_0 temp8 6))
						)
					)
					(
						(and
							(>= temp5 4)
							(param1 supports: temp8 1)
							(< temp20 (= temp23 (param1 findGameLevel: temp8)))
						)
						(= temp0 (proc709_0 temp8 temp23))
						(proc709_4 param1 7 15 0 6 0 6 0 6 0 6)
						(proc709_5 param1 temp8 3 7)
					)
					((and (>= temp5 4) temp18 (not (param1 supports: temp8 1)))
						(= temp0 (proc709_0 temp18 (param1 minLevel: temp18)))
						(proc709_4 param1 7 15 0 6 0 6 0 6 0 6)
						(proc709_5 param1 temp18 5 11)
					)
					(else
						(= temp0 0)
						(proc709_4 param1 0 16 0 7 0 7 0 7 0 7)
					)
				)
			)
			(
				(and
					(not temp81)
					(OneOf (BidBox openingBidValue:) 10 15)
					(== param2 0)
				)
				(cond
					(
						(>=
							temp5
							(*
								2
								(+
									5
									(param1 minLevel: temp7)
									(if (and temp43 (not temp42)) -1 else 0)
								)
							)
						)
						(if
							(and
								(>= (/ (param1 calcQTS:) 2) (- 7 temp20))
								(or (param1 directSeat:) (>= (param1 aces:) 2))
							)
							(= temp0 50)
							(proc709_4 param1 11 20 0 7 0 7 0 7 0 7)
						else
							(= temp0 (proc709_0 temp7 (param1 minLevel: temp7)))
							(proc709_4 param1 6 19 0 6 0 6 0 6 0 6)
							(proc709_5 param1 temp7 6 11)
						)
					)
					(
						(and
							(>= (/ (param1 calcQTS:) 2) (- 7 temp20))
							(or (param1 directSeat:) (>= (param1 aces:) 2))
						)
						(= temp0 50)
						(proc709_4 param1 11 20 0 9 0 9 0 9 0 9)
					)
					(else
						(= temp0 0)
						(proc709_4 param1 0 16 0 7 0 7 0 7 0 7)
					)
				)
			)
			(
				(and
					(<= 1 (BidBox openingBidValue:) 4)
					(not temp81)
					(!= param2 0)
					(!= temp41 17)
				)
				(cond
					((param1 supports: temp8 1)
						(cond
							((or (>= temp3 19) (and (>= temp3 17) (>= temp8 3)))
								(= temp0
									(proc709_0
										temp8
										(param1 findGameLevel: temp8)
									)
								)
								(proc709_4 param1 17 23 0 6 0 6 0 6 0 6)
								(proc709_5 param1 temp8 3 8)
							)
							((>= temp3 14)
								(= temp0
									(proc709_0
										temp8
										(+ (param1 minLevel: temp8) 1)
									)
								)
								(proc709_4 param1 14 18 0 6 0 6 0 6 0 6)
								(proc709_5 param1 temp8 3 8)
							)
							(
								(or
									(>= temp3 10)
									(and (>= temp23 7) (>= [temp12 temp8] 5))
								)
								(= temp0 (proc709_0 (param1 minLevel: temp8)))
								(proc709_4 param1 7 13 0 6 0 6 0 6 0 6)
								(proc709_5 param1 temp8 3 8)
							)
							(else
								(= temp0 0)
								(proc709_4 param1 0 16 0 7 0 7 0 7 0 7)
							)
						)
					)
					(
						(and
							(>= temp4 18)
							[temp70 4]
							[temp70 3]
							[temp70 2]
							[temp70 1]
							(>= [temp70 temp21] 2)
						)
						(= temp0 15)
						(proc709_4 param1 18 21 2 6 2 6 2 6 2 6)
					)
					((>= temp3 15)
						(if (not temp18)
							(= temp0
								(proc709_0 temp21 (param1 minLevel: temp21))
							)
							(proc709_4 param1 15 21 0 5 0 5 0 5 0 5)
							(param1 bidBranch: 1 forcing: 1)
							(= global439 1)
						else
							(= temp0
								(proc709_0
									temp18
									(+ (param1 minLevel: temp18) 1)
								)
							)
							(param1 bidBranch: 2)
							(proc709_4 param1 15 20 0 6 0 6 0 6 0 6)
							(proc709_5 param1 temp18 5 11)
						)
					)
					((== temp7 temp21)
						(= temp0 0)
						(proc709_4 param1 0 16 0 7 0 7 0 7 0 7)
					)
					(
						(or
							(and
								(>= temp3 12)
								(== temp20 (param1 minLevel: temp7))
								(>= (param1 calcHCP: temp7) 6)
							)
							(and (>= temp3 10) temp18)
							(and (>= temp3 7) (>= (param1 calcTricks: temp7) 5))
						)
						(= temp0 (proc709_0 temp7 (param1 minLevel: temp7)))
						(proc709_4 param1 10 14 0 6 0 6 0 6 0 6)
						(proc709_5 param1 temp7 5 11)
					)
					(else
						(= temp0 0)
						(proc709_4 param1 0 16 0 7 0 7 0 7 0 7)
					)
				)
			)
			(
				(and
					(== temp41 17)
					(<= global427 14)
					(or
						(== global427 (= temp23 (BidBox openingBidValue:)))
						(<= global427 9)
					)
					(or (<= 1 temp23 4) (<= 7 temp23 9) (<= 11 temp23 14))
				)
				(cond
					(
						(and
							(>= [temp12 temp21] 5)
							(>= (param1 calcTricks: temp21) 3)
						)
						(= temp0 0)
						(proc709_4 param1 3 16 0 7 0 7 0 7 0 7)
						(proc709_5 param1 temp21 5 10)
					)
					(
						(and
							(>= [temp70 temp21] 2)
							(<= 11 temp3 16)
							(or
								(>= [temp12 2] 5)
								(>= [temp12 1] 5)
								(>= temp3 13)
							)
						)
						(= temp0 15)
						(proc709_4 param1 11 16 2 8 2 8 2 4 2 4)
					)
					(
						(and
							(>= temp3 10)
							(or
								(and (>= [temp12 4] 4) (>= [temp12 3] 4))
								(>= temp3 13)
							)
						)
						(= temp0 (proc709_0 temp21 (param1 minLevel: temp21)))
						(proc709_4 param1 10 16 2 5 2 5 1 4 1 4)
						(param1 bidBranch: 1 forcing: 1)
						(= global439 1)
					)
					(
						(and
							(>= temp3 10)
							temp50
							(or (< [temp12 3] 4) [local0 3])
							(or (< [temp12 4] 4) [local0 4])
						)
						(= temp0 (proc709_0 5 (+ temp20 1)))
						(proc709_4 param1 10 12 2 5 2 5 2 5 2 5)
					)
					(
						(and
							(>= temp3 10)
							(or
								(!= (= temp1 temp7) temp21)
								(= temp1 (param1 longSuit: 2))
							)
							(or
								(>= [temp12 temp1] 5)
								(and (== [temp12 temp1] 4) (>= temp1 3))
							)
						)
						(= temp23 (+ (param1 minLevel: temp1) 1))
						(= temp0 (proc709_0 temp1 temp23))
						(proc709_4 param1 10 12 0 5 0 5 0 4 0 4)
						(proc709_5 param1 temp1 5 9)
						(param1 forcing: 1)
					)
					(
						(and
							(<= 6 temp3 10)
							(or (< [temp12 3] 4) [local0 3])
							(or (< [temp12 4] 4) [local0 4])
							temp50
						)
						(= temp0 (proc709_0 5 (param1 minLevel: 5)))
						(proc709_4 param1 6 10 0 4 0 4 0 3 0 3)
						(proc709_5 param1 temp21 2 6)
					)
					(else
						(if (== (= temp1 temp7) temp21)
							(= temp1 (param1 longSuit: 2))
						)
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
						(proc709_4 param1 0 9 0 4 0 4 0 4 0 4)
						(proc709_5 param1 temp1 4 9)
					)
				)
			)
			((and (== temp8 5) (not temp81))
				(if (>= temp28 26)
					(proc709_4 param1 26 18 2 5 2 5 2 5 2 5)
					(cond
						(temp29
							(= temp0 15)
						)
						((u> temp6 20480)
							(if (== (= temp1 temp7) temp21)
								(= temp1 (param1 longSuit: 2))
							)
							(= temp0
								(proc709_0 temp1 (+ (param1 minLevel: temp1) 1))
							)
							(proc709_5 param1 temp1 5 11)
							(param1 forcing: 1)
						)
						(else
							(= temp0 (+ param4 5))
							(proc709_4 param1 -1 -1 1 4 1 4 1 4 1 4)
							(param1 bidBranch: 1 forcing: 1)
							(= global439 1)
						)
					)
				else
					(proc709_4 param1 0 16 0 7 0 7 0 7 0 7)
					(if (and (u> temp6 20480) (param1 singletons:))
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
						(proc709_5 param1 temp1 5 11)
					else
						(= temp0 0)
					)
				)
			)
			((and (== temp41 1) (not temp81))
				(cond
					((>= temp3 10)
						(= temp0 (proc709_0 temp21 (param1 minLevel: temp21)))
						(proc709_4 param1 10 21 0 9 0 9 0 9 0 9)
						(param1 bidBranch: 1 forcing: 1)
						(= global439 1)
					)
					((and (>= temp4 6) temp50)
						(= temp0 (proc709_0 5 (param1 minLevel: 5)))
						(proc709_4 param1 6 9 0 5 0 5 0 5 0 5)
						(proc709_5 param1 temp21 2 6)
					)
					(else
						(if (== (= temp1 temp7) temp21)
							(= temp1 (param1 longSuit: 2))
						)
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
						(proc709_4 param1 6 9 0 5 0 5 0 5 0 5)
						(proc709_5 param1 temp1 4 11)
					)
				)
			)
			((and (== temp41 2) (not temp81))
				(cond
					((>= temp4 10)
						(= temp0 (+ param4 5))
						(proc709_4 param1 10 21 0 9 0 9 0 9 0 9)
						(param1 bidBranch: 1 forcing: 1)
						(= global439 1)
					)
					((param1 supports: temp8 1)
						(if (>= temp3 6)
							(= temp0 (proc709_0 temp8 (param1 minLevel: temp8)))
							(proc709_4 param1 6 9 0 7 0 7 0 7 0 7)
							(proc709_5 param1 temp8 4 8)
						else
							(= temp0 0)
							(proc709_4 param1 0 16 0 7 0 7 0 7 0 7)
						)
					)
					((and (>= temp3 6) temp18)
						(= temp0 (proc709_0 temp18 (param1 minLevel: temp18)))
						(proc709_4 param1 6 9 0 6 0 6 0 6 0 6)
						(proc709_5 param1 temp18 5 11)
					)
					((and (>= temp4 6) temp50)
						(= temp0 (proc709_0 5 (param1 minLevel: 5)))
						(proc709_4 param1 6 9 0 5 0 5 0 5 0 5)
						(proc709_5 param1 temp21 2 6)
					)
					(
						(and
							(>= temp3 6)
							(!= temp7 temp21)
							(proc709_3 param1 temp7)
						)
						(= temp0 temp37)
						(proc709_4 param1 6 9 0 6 0 6 0 6 0 6)
						(proc709_5 param1 temp7 5 11)
					)
					(else
						(= temp0 0)
						(proc709_4 param1 0 16 0 7 0 7 0 7 0 7)
					)
				)
			)
			(
				(and
					(not temp81)
					(!= temp8 5)
					(!= temp41 17)
					(or
						(> temp9 (+ temp47 2))
						(and (== temp9 (+ temp47 2)) (> temp8 temp21))
					)
				)
				(cond
					((>= temp5 8)
						(= temp0
							(proc709_0 temp8 (param1 findGameLevel: temp8))
						)
						(proc709_5 param1 temp8 2 6)
					)
					((and (!= temp7 temp8) (>= temp80 temp38))
						(= temp0 (proc709_0 temp7 (param1 minLevel: temp7)))
						(proc709_5 param1 temp7 8 11)
					)
					(else
						(= temp0 0)
						(proc709_4 param1 0 16 0 7 0 7 0 7 0 7)
					)
				)
			)
			((and (OneOf temp82 3 17) (== temp81 1))
				(= temp49 (param1 minPoints:))
				(cond
					((== temp41 1)
						(cond
							((> temp3 (+ 5 temp49))
								(= temp0
									(proc709_0 temp8 (param1 minLevel: temp8))
								)
								(param1 minPoints: (+ 6 temp49))
								(param1 bidBranch: 1)
							)
							(temp50
								(= temp0 (proc709_0 5 (param1 minLevel: 5)))
								(proc709_4 param1 6 9 0 6 0 6 0 6 0 6)
								(proc709_5 param1 temp21 2 6)
							)
							(
								(or
									(and
										(>= [temp12 (= temp1 2)] 5)
										(localproc_0 temp1)
									)
									(and
										(>= [temp12 (= temp1 4)] 5)
										(localproc_0 temp1)
									)
									(and
										(>= [temp12 (= temp1 3)] 5)
										(localproc_0 temp1)
									)
									(and
										(>= [temp12 (= temp1 1)] 5)
										(localproc_0 temp1)
									)
								)
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 5 11)
							)
							(
								(or
									(>= [temp12 temp17] 6)
									(and (== [temp12 temp17] 5) (>= temp4 6))
								)
								(= temp0 temp22)
								(proc709_5 param1 temp17 5 11)
							)
							((= temp1 (proc709_9 param1 temp17 temp21))
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 4 6)
							)
							((proc709_1 param1 temp17)
								(= temp0 temp22)
								(proc709_5 param1 temp17 5 11)
							)
							(
								(or
									(and
										(>= [temp12 2] 4)
										(localproc_0 (= temp1 2))
									)
									(and
										(>= [temp12 4] 4)
										(localproc_0 (= temp1 4))
									)
									(and
										(>= [temp12 3] 4)
										(localproc_0 (= temp1 3))
									)
									(and
										(>= [temp12 1] 4)
										(localproc_0 (= temp1 1))
									)
								)
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 4 6)
							)
							(
								(or
									(and
										(>= (param1 diamondHCP:) 5)
										(>= [temp12 2] 3)
										(localproc_0 (= temp1 2))
									)
									(and
										(>= (param1 spadeHCP:) 5)
										(>= [temp12 4] 3)
										(localproc_0 (= temp1 4))
									)
									(and
										(>= (param1 heartHCP:) 5)
										(>= [temp12 3] 3)
										(localproc_0 (= temp1 3))
									)
									(and
										(>= (param1 clubHCP:) 5)
										(>= [temp12 1] 3)
										(localproc_0 (= temp1 1))
									)
								)
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 4 6)
							)
							(else
								(= temp0 temp22)
								(proc709_5 param1 temp17 5 11)
							)
						)
					)
					((== param2 0)
						(if
							(and
								(>= temp3 17)
								(or
									(and
										(= temp1
											(proc709_9 param1 temp7 temp21)
										)
										(not [local0 temp1])
									)
									(and
										(>= [temp12 (= temp1 temp7)] 6)
										(>= (param1 calcHonors: temp7 5) 3)
									)
								)
							)
							(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
						else
							(= temp0 0)
						)
					)
					((param1 supports: temp8 1)
						(if
							(or
								(< temp3 (+ 3 temp49))
								(>= temp9 (param1 findGameLevel: temp8))
							)
							(= temp0 0)
						else
							(= temp0 (proc709_0 temp8 (param1 minLevel: temp8)))
							(= temp23 (if (OneOf temp8 1 2) 4 else 3))
							(proc709_5 param1 temp8 temp23 8)
							(param1 minPoints: (+ 3 temp49))
						)
					)
					((>= temp3 (+ 6 temp49))
						(if (and (== temp23 17) (u> temp6 20480))
							(= temp0 (proc709_0 temp7 (param1 minLevel: temp7)))
							(proc709_5 param1 temp7 5 11 (+ temp49 6) -1)
						else
							(= temp0
								(proc709_0 temp21 (param1 minLevel: temp21))
							)
							(param1 bidBranch: 1 forcing: 1)
							(= global439 1)
						)
					)
					((and (>= temp3 (+ 3 temp49)) temp50)
						(= temp0 (proc709_0 5 (param1 minLevel: 5)))
						(proc709_5 param1 temp21 2 5)
						(param1 minPoints: (+ 3 temp49) maxPoints: (+ 5 temp49))
					)
					(
						(or
							(>= [temp12 temp17] 6)
							(and
								(>= [temp12 temp17] 5)
								(>= (param1 calcHCP: temp17) 6)
							)
						)
						(= temp0 temp22)
						(proc709_5 param1 temp17 5 11)
					)
					((= temp1 (proc709_9 param1 temp17 temp21))
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
						(proc709_5 param1 temp1 4 6)
					)
					((and (>= [temp12 temp17] 5) (<= [temp12 temp8] 1))
						(= temp0 temp22)
						(proc709_5 param1 temp17 5 6)
						(proc709_5 param1 temp8 0 3)
					)
					(else
						(= temp0 0)
						(param1 maxPoints: (+ 5 temp49))
					)
				)
			)
			((and (== temp81 1) (OneOf temp82 3 17) (== temp41 2))
				(cond
					((>= temp3 (+ 6 temp49))
						(= temp0 (proc709_0 temp21 (param1 minLevel: temp21)))
						(param1 minPoints: (+ 6 temp49))
						(param1 bidBranch: 1 forcing: 2)
						(= global439 1)
					)
					((param1 supports: temp8 1)
						(cond
							((>= temp20 (param1 findGameLevel: temp8))
								(= temp0 0)
							)
							(
								(and
									(u> temp6 28672)
									(!= temp7 temp21)
									(not (param1 supports: temp8 0))
								)
								(= temp0 temp37)
								(proc709_5 param1 temp7 5 11)
							)
							((>= temp3 (+ 3 temp49))
								(= temp0
									(proc709_0 temp8 (param1 minLevel: temp8))
								)
								(proc709_5 param1 temp8 4 8)
							)
							(else
								(= temp0 0)
							)
						)
					)
					(temp50
						(= temp0 (proc709_0 5 (param1 minLevel: 5)))
						(proc709_5 param1 temp21 2 5)
					)
					(
						(or
							(>= [temp12 temp17] 6)
							(and
								(== [temp12 temp17] 5)
								(>= (param1 calcHCP: temp17) 6)
							)
						)
						(= temp0 temp22)
						(proc709_5 param1 temp17 5 11)
					)
					((= temp1 (proc709_9 param1 temp17 temp21))
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
						(proc709_5 param1 temp1 4 6)
					)
					((and (== [temp12 temp17] 5) (<= [temp12 temp8] 1))
						(= temp0 temp22)
						(proc709_5 param1 temp17 5 11)
					)
					(else
						(= temp0 0)
					)
				)
			)
			(
				(and
					param2
					(== temp81 1)
					(== param1 (BidBox overcaller:))
					(== ((BidBox overcaller:) bidBranch:) 2)
				)
				(cond
					((== temp41 1)
						(cond
							(
								(or
									(>= [temp12 temp17] 7)
									(and
										(== [temp12 temp17] 6)
										(>= (param1 calcHCP: temp17) 6)
									)
								)
								(= temp0 temp22)
								(proc709_5 param1 temp17 6 11)
							)
							(temp50
								(= temp0 (proc709_0 5 (param1 minLevel: 5)))
								(proc709_5 param1 temp21 2 5)
							)
							(
								(and
									(= temp1 (proc709_9 param1 temp17 temp21))
									(proc709_1 param1 temp1)
								)
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 5 6)
							)
							(
								(or
									(>= [temp12 temp17] 6)
									(and (== [temp12 temp17] 5) (>= temp4 6))
								)
								(= temp0 temp22)
								(proc709_5 param1 temp17 5 -1)
							)
							((= temp1 (proc709_9 param1 temp17 temp21))
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 4 6)
							)
							(else
								(= temp0 temp22)
								(proc709_5 param1 temp17 5 -1)
							)
						)
					)
					((== temp17 temp8)
						(cond
							((>= temp20 (param1 findGameLevel: temp17))
								(= temp0 0)
							)
							((>= temp28 26)
								(= temp0
									(proc709_0
										temp17
										(param1 findGameLevel: temp17)
									)
								)
							)
							(else
								(= temp0 0)
							)
						)
					)
					((param1 supports: temp8 1)
						(cond
							((>= global427 (param1 findGameLevel: temp19))
								(= temp0 0)
							)
							(
								(or
									(>= [temp12 temp17] 7)
									(and
										(>= [temp12 temp17] 6)
										(>= (param1 calcHCP: temp17) 6)
									)
								)
								(= temp0 temp22)
								(proc709_5 param1 temp17 5 11)
							)
							(
								(and
									(= temp1 (proc709_9 param1 temp17 temp21))
									(proc709_1 param1 temp1)
								)
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 4 6)
							)
							(else
								(= temp0
									(proc709_0 temp8 (param1 minLevel: temp8))
								)
								(= temp23 (if (OneOf temp1 1 2) 5 else 3))
								(proc709_5 param1 temp1 temp23 5)
							)
						)
					)
					(
						(or
							(>= [temp12 temp17] 7)
							(and
								(== [temp12 temp17] 6)
								(>= (param1 calcHCP: temp17) 6)
							)
						)
						(= temp0 temp22)
						(proc709_5 param1 temp17 5 11)
					)
					(temp50
						(= temp0 (proc709_0 5 (param1 minLevel: 5)))
						(proc709_5 param1 temp21 2 5)
					)
					((= temp1 (proc709_9 param1 temp17 temp21))
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
						(proc709_5 param1 temp1 4 6)
					)
					(
						(or
							(>= [temp12 temp17] 6)
							(and (== [temp12 temp17] 5) (>= temp4 6))
						)
						(= temp0 temp22)
						(proc709_5 param1 temp17 5 11)
					)
					(
						(or
							(and (>= [temp12 4] 4) (localproc_0 (= temp1 4)))
							(and (>= [temp12 3] 4) (localproc_0 (= temp1 3)))
							(and (>= [temp12 2] 4) (localproc_0 (= temp1 2)))
							(and (>= [temp12 1] 4) (localproc_0 (= temp1 1)))
						)
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
						(proc709_5 param1 temp1 4 6)
					)
					((>= [temp12 temp17] 5)
						(= temp0 temp22)
						(proc709_5 param1 temp17 5 11)
					)
					(else
						(= temp0 0)
					)
				)
			)
			((and (== temp41 3) (== temp81 1))
				(cond
					((or (= temp1 temp32) (>= [temp52 (= temp1 5)] 2))
						(cond
							((>= temp28 26)
								(= temp0
									(proc709_0
										temp1
										(param1 findGameLevel: temp1)
									)
								)
								(if (not (param1 canBid: temp0))
									(if (!= temp19 temp1)
										(= temp0
											(proc709_0
												temp1
												(param1 minLevel: temp1)
											)
										)
									else
										(= temp0 0)
									)
								)
							)
							(
								(or
									(>=
										(= temp23 (+ temp3 (temp48 maxPoints:)))
										29
									)
									(and (>= temp23 26) (>= temp1 3))
								)
								(proc709_5 param1 temp1 4 8)
								(param1 minPoints: 16 maxPoints: 20)
								(cond
									(
										(<
											(= temp24 (param1 minLevel: temp1))
											(= temp25
												(param1 findGameLevel: temp1)
											)
										)
										(= temp0 (proc709_0 temp1 temp24))
									)
									((and (not temp42) temp43)
										(= temp0 (proc709_0 temp1 temp25))
									)
									(else
										(= temp0 0)
									)
								)
							)
							((!= temp1 temp19)
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
							)
							(else
								(= temp0 0)
							)
						)
					)
					(
						(and
							(= temp1 (proc709_9 param1 temp17 temp21))
							(proc709_1 param1 temp1)
						)
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
						(proc709_5 param1 temp1 4 6)
					)
					(
						(or
							(and (>= temp80 7) (localproc_1 (= temp1 temp7)))
							(and
								(>= [temp12 (= temp1 4)] 6)
								(localproc_1 temp1)
								(>= (param1 spadeHCP:) 6)
							)
							(and
								(>= [temp12 (= temp1 3)] 6)
								(localproc_1 temp1)
								(>= (param1 heartHCP:) 6)
							)
							(and
								(>= [temp12 (= temp1 2)] 6)
								(localproc_1 temp1)
								(>= (param1 diamondHCP:) 6)
							)
							(and
								(>= [temp12 (= temp1 1)] 6)
								(localproc_1 temp1)
								(>= (param1 clubHCP:) 6)
							)
						)
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
						(proc709_5 param1 temp1 5 -1)
					)
					((= temp1 (proc709_9 param1 temp17 temp21))
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
					)
					(
						(or
							(and (localproc_1 4) (proc709_1 param1 (= temp1 4)))
							(and (localproc_1 3) (proc709_1 param1 (= temp1 3)))
							(and (localproc_1 2) (proc709_1 param1 (= temp1 2)))
							(and (localproc_1 1) (proc709_1 param1 (= temp1 1)))
						)
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
						(proc709_5 param1 temp1 5 -1)
					)
					((>= temp28 26)
						(cond
							(temp50
								(if (== temp20 3)
									(= temp0 15)
								else
									(= temp0
										(+ (proc709_0 5 (param1 minLevel: 5)) 5)
									)
								)
								(proc709_5 param1 temp21 2 6)
							)
							(
								(or
									(>= [temp12 (= temp1 temp8)] 3)
									(>= [temp12 (= temp1 temp30)] 3)
								)
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 3 6)
							)
							(
								(or
									(and
										(u> temp6 20480)
										(localproc_1 (= temp1 temp7))
									)
									(and
										(= temp1
											(proc709_9 param1 temp7 temp21)
										)
										(>= [temp12 temp1] 5)
										(localproc_1 temp1)
									)
								)
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 5 -1)
							)
							(
								(or
									(and
										(localproc_0 4)
										(or
											(>= [temp12 (= temp1 4)] 4)
											(>= (param1 spadeHCP:) 5)
										)
									)
									(and
										(localproc_0 3)
										(or
											(>= [temp12 (= temp1 3)] 4)
											(>= (param1 heartHCP:) 5)
										)
									)
									(and
										(localproc_0 2)
										(or
											(>= [temp12 (= temp1 2)] 4)
											(>= (param1 diamondHCP:) 5)
										)
									)
									(and
										(localproc_0 1)
										(or
											(>= [temp12 (= temp1 1)] 4)
											(>= (param1 clubHCP:) 5)
										)
									)
								)
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 4 6)
							)
							(
								(and
									(== [temp12 temp30] 2)
									(param1 calcHonors: temp30 4)
								)
								(= temp0
									(proc709_0 temp30 (param1 minLevel: temp30))
								)
								(proc709_5 param1 temp30 3 6)
							)
							(
								(or
									(and
										(>= (= temp23 [temp12 temp21]) 2)
										(param1 hasCard: temp21 3852)
									)
									(and
										(>= temp23 3)
										(param1 hasCard: temp21 11)
									)
									(>= temp23 4)
								)
								(if
									(or
										(== temp41 1)
										(>=
											(= temp27
												(proc709_0
													temp21
													(param1 minLevel: temp21)
												)
											)
											15
										)
									)
									(= temp0 15)
								else
									(= temp0 temp27)
									(param1 bidBranch: 1 forcing: 1)
									(= global439 1)
								)
								(proc709_5 param1 temp21 2 5)
							)
							((> [temp12 temp8] [temp12 temp30])
								(= temp0
									(proc709_0 temp8 (param1 minLevel: temp8))
								)
								(proc709_5 param1 temp8 3 6)
							)
							(else
								(= temp0
									(proc709_0 temp30 (param1 minLevel: temp30))
								)
								(proc709_5 param1 temp30 2 6)
							)
						)
					)
				)
			)
			((and (== temp82 3) (== temp81 2))
				(= temp51 (temp48 minPoints:))
				(= temp23 (+ [temp12 4] [temp75 4]))
				(= temp24 (+ [temp12 3] [temp75 3]))
				(= temp25 (+ [temp12 2] [temp75 2]))
				(= temp26 (+ [temp12 1] [temp75 1]))
				(= temp1
					(cond
						((>= temp23 8) 4)
						((>= temp24 8) 3)
						((>= temp25 8) 2)
						((>= temp26 8) 1)
						(else 0)
					)
				)
				(cond
					((>= temp28 26)
						(cond
							(temp1
								(cond
									((>= temp1 3)
										(= temp0
											(proc709_0
												temp1
												(param1 findGameLevel: temp1)
											)
										)
									)
									(
										(and
											[temp70 4]
											[temp70 3]
											[temp70 2]
											[temp70 1]
										)
										(= temp0 15)
									)
									((>= temp28 29)
										(= temp0
											(proc709_0
												temp1
												(param1 findGameLevel: temp1)
											)
										)
									)
									(
										(param1
											canBid:
												(= temp0 (proc709_0 temp1 4))
										)
										(param1
											minPoints: (- 26 temp51)
											maxPoints: (- 28 temp51)
										)
									)
									((and temp42 (== temp19 temp1))
										(= temp0 0)
									)
									(else
										(= temp0 (proc709_0 temp1 5))
										(param1 minPoints: (- 26 temp51))
									)
								)
							)
							((and [temp70 4] [temp70 3] [temp70 2] [temp70 1])
								(= temp0 15)
							)
							((or (not temp32) (< temp36 7))
								(= temp0
									(if
										(==
											(= temp1
												(cond
													((>= temp23 7) 4)
													((>= temp24 7) 3)
													((>= temp25 7) 2)
													((>= temp26 7) 1)
													(else 6)
												)
											)
											6
										)
										0
									else
										(proc709_0
											temp1
											(param1 minLevel: temp1)
										)
									)
								)
							)
							((>= temp28 28)
								(if
									(not
										(param1
											canBid:
												(= temp0
													(proc709_0
														temp32
														(param1
															findGameLevel:
																temp32
														)
													)
												)
										)
									)
									(= temp0 0)
								)
							)
							(else
								(= temp0 0)
								(param1 maxPoints: (- 25 temp51))
							)
						)
					)
					((or (== temp19 temp1) (and (not temp1) (== temp19 5)))
						(= temp0 0)
						(param1 maxPoints: (- 25 temp51))
					)
					(
						(or
							(and
								(>= temp23 8)
								(param1 canBid: (= temp27 (proc709_0 4 temp20)))
							)
							(and
								(>= temp24 8)
								(param1 canBid: (= temp27 (proc709_0 3 temp20)))
							)
							(and
								(>= temp25 8)
								(param1 canBid: (= temp27 (proc709_0 2 temp20)))
							)
							(and
								(>= temp26 8)
								(param1 canBid: (= temp27 (proc709_0 1 temp20)))
							)
							(and
								[temp70 4]
								[temp70 3]
								[temp70 2]
								[temp70 1]
								(>= temp50 2)
								(= temp27 (proc709_0 5 temp20))
							)
						)
						(= temp0 temp27)
					)
					(
						(and
							(>= temp36 7)
							(< temp23 9)
							(< temp24 9)
							(< temp25 9)
							(< temp26 9)
						)
						(= temp0 0)
						(param1 maxPoints: (- 25 temp51))
					)
					(
						(or
							(and (>= temp23 9) (= temp1 4))
							(and (>= temp24 9) (= temp1 3))
							(and (>= temp25 9) (= temp1 2))
							(and (>= temp26 9) (= temp1 1))
						)
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
					)
					(
						(and
							(< temp36 7)
							(or
								(and
									(>= temp23 7)
									(param1
										canBid: (= temp27 (proc709_0 4 temp20))
									)
								)
								(and
									(>= temp24 7)
									(param1
										canBid: (= temp27 (proc709_0 3 temp20))
									)
								)
								(and
									(>= temp25 7)
									(param1
										canBid: (= temp27 (proc709_0 2 temp20))
									)
								)
							)
						)
						(= temp0 temp27)
					)
					(
						(and
							(not [temp12 temp19])
							(or
								(and
									(>= temp25 7)
									(param1
										canBid: (proc709_0 (= temp1 2) temp20)
									)
								)
								(and
									(>= temp24 7)
									(param1
										canBid: (proc709_0 (= temp1 3) temp20)
									)
								)
								(and
									(>= temp23 7)
									(param1
										canBid: (proc709_0 (= temp1 4) temp20)
									)
								)
								(and
									(< [temp52 temp19] 2)
									(= temp1
										(cond
											((>= temp26 7) 1)
											((>= temp25 7) 2)
											((>= temp24 7) 3)
											((>= temp23 7) 4)
											(else 5)
										)
									)
								)
							)
						)
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
					)
					(else
						(= temp0 0)
					)
				)
			)
		)
		(return temp0)
	)
)

