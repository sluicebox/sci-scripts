;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 731)
(include sci.sh)
(use Main)
(use BScore)
(use n709)
(use Bid)
(use System)

(public
	compwe_tree 0
)

(local
	[local0 6]
	[local6 6]
)

(procedure (localproc_0 param1)
	(return (not [local0 param1]))
)

(procedure (localproc_1 param1)
	(return (<= [local6 param1] 1))
)

(instance compwe_tree of Code
	(properties)

	(method (doit param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 [temp11 5] temp16 temp17 [temp18 5] temp23 temp24 temp25 temp26 temp27 temp28 temp29 temp30 temp31 [temp32 2] temp34 temp35 temp36 temp37 temp38 temp39 [temp40 3] temp43 temp44 temp45 temp46 temp47 temp48 temp49 temp50 temp51 temp52 temp53 temp54 temp55 temp56 temp57 temp58 temp59 [temp60 5] [temp65 6] [temp71 6] [temp77 6] temp83 temp84 temp85 temp86 temp87)
		(= temp53 (param1 location:))
		(= temp54 ((= temp52 (param1 partner:)) location:))
		(= temp3 (param1 points:))
		(= temp4 (param1 hcp:))
		(= temp5 (param1 playingTricks:))
		(= temp6 (param1 quickTricks:))
		(= temp7 (param1 shape:))
		(= temp8 (param1 longSuit:))
		(= temp35 (param1 combinedHCP:))
		(= temp36 (param1 combinedPts:))
		(= temp39 (param1 agreedSuit:))
		(= temp43 (param1 combinedCards:))
		(= temp37 (OneOf temp7 17203 17458 21298))
		(= temp50 (temp52 bidBranch:))
		(= temp87 (param1 bidsOpen:))
		(if (OneOf (param1 location:) 1 3)
			(= temp84 (BScore weGamesWon:))
			(= temp85 (BScore theyGamesWon:))
		else
			(= temp85 (BScore weGamesWon:))
			(= temp84 (BScore theyGamesWon:))
		)
		(= [temp18 0] 0)
		(= [temp18 2] (param1 diamonds:))
		(= [temp18 1] (param1 clubs:))
		(= [temp18 3] (param1 hearts:))
		(= [temp18 4] (param1 spades:))
		(= [temp11 2] (param1 partnerDiamonds:))
		(= [temp11 1] (param1 partnerClubs:))
		(= [temp11 3] (param1 partnerHearts:))
		(= [temp11 4] (param1 partnerSpades:))
		(= temp38 (= temp23 (= temp9 0)))
		(= temp58 0)
		(for ((= temp16 0)) (< temp16 6) ((++ temp16))
			(= [local0 temp16]
				(= [temp65 temp16]
					(= [temp77 temp16]
						(= [temp71 temp16] (= [local6 temp16] 0))
					)
				)
			)
		)
		(= temp16 0)
		(= temp30 (BidBox size:))
		(while (< temp16 temp30)
			(= temp56 (BidBox at: temp16))
			(= temp31 (temp56 location:))
			(if
				(and
					(!= (temp56 bidNumber:) 0)
					(OneOf temp31 temp53 temp54)
				)
				(++ temp58)
			)
			(if
				(and
					(not (temp56 artificial:))
					(not (OneOf (temp56 bidNumber:) 0 50 99))
					(<= 1 (= temp1 (temp56 suit:)) 5)
				)
				(++ [local0 temp1])
				(if (OneOf temp31 temp53 temp54)
					(++ [temp65 temp1])
					(if (== temp31 temp53)
						(= temp23 temp1)
						(++ [local6 temp1])
					else
						(++ [temp77 temp1])
						(= temp9 temp1)
						(if (not temp38)
							(= temp38 temp1)
						)
					)
				else
					(++ [temp71 temp1])
					(= temp27 temp1)
				)
			)
			(++ temp16)
		)
		(= temp51 [temp18 temp9])
		(for ((= temp16 1)) (<= temp16 4) ((++ temp16))
			(if (not (= [temp60 temp16] (param1 stops: temp16 1)))
				(= [temp60 temp16] [temp65 temp16])
			)
		)
		(= temp86
			(if [temp60 temp27]
				(or (>= [temp60 temp27] 2) (>= (param1 calcHonors: temp27 6) 3))
			)
		)
		(= temp10 (+ 1 (/ (- param2 1) 5)))
		(= temp28 (proc709_0 temp8 (param1 minLevel: temp8)))
		(= temp29 (proc709_0 temp27 (param1 minLevel: temp27)))
		(= temp25 (+ 1 (mod (- global427 1) 5)))
		(= temp26 (+ 1 (/ (- global427 1) 5)))
		(= temp45 (+ 1 (mod (- (BidBox openingBidValue:) 1) 5)))
		(= temp46 (not (OneOf (BidBox openingBidder:) param1 temp52)))
		(= temp48
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
		(= temp49
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
			(and (proc709_1 param1 4) (= temp24 4))
			(and (proc709_1 param1 3) (= temp24 3))
			(and (proc709_1 param1 2) (= temp24 2))
			(and (proc709_1 param1 1) (= temp24 1))
			(= temp24 0)
		)
		(= temp47 (+ temp51 [temp11 temp9]))
		(= temp30 temp8)
		(= temp31 (param1 longSuit: 2))
		(= temp1
			(if (== [temp18 temp30] [temp18 temp31])
				(if (== temp30 (param1 strongSuit:)) temp30 else temp31)
			else
				temp8
			)
		)
		(= temp59 (temp52 forcing:))
		(if
			(or
				(>= temp26 6)
				(and (== temp59 2) (or (== global427 15) (>= global427 19)))
			)
			(= temp59 0)
		)
		(= temp44
			(proc709_0 (= temp8 temp1) (= temp30 (param1 minLevel: temp1)))
		)
		(= temp57 [temp18 temp8])
		(= temp0 0)
		(= temp31 0)
		(param1 bidBranch: 0)
		(cond
			(
				(not
					(or
						temp59
						(OneOf param2 50 99)
						(>= temp36 (+ 13 (* temp30 3)))
						(and
							(>= (+ temp4 temp57) (+ 12 temp30 temp30))
							(or
								temp58
								(>= temp57 7)
								(>= temp3 (+ 5 (* 4 temp30)))
							)
						)
					)
				)
				(= temp0 0)
			)
			((and (not temp46) (<= 1 param4 12) (== temp87 0))
				(cond
					((and (or (u< temp7 28672) (== temp8 temp27)) (<= temp4 5))
						(= temp0 0)
						(proc709_4 param1 0 5 0 6 0 6 0 6 0 6)
					)
					((and (u> temp7 28672) (!= temp8 temp27) (< temp4 10))
						(= temp0
							(proc709_0 temp8 (= temp30 (- [temp18 temp8] 4)))
						)
						(= temp31 5)
						(if (> temp30 (param1 minLevel: temp8))
							(= temp31 (- [temp18 temp8] 1))
						)
						(proc709_5 param1 temp1 temp31 11 6 10)
					)
					(
						(and
							[temp60 temp27]
							(or
								(and (<= 6 temp4 9) (== temp26 1))
								(and (<= 8 temp4 12) (== temp26 2))
							)
							(not
								(and
									(>= temp3 10)
									(or
										(>= [temp18 temp8] 6)
										(and
											(>= [temp18 temp8] 5)
											(>= temp8 3)
											(> temp8 temp25)
										)
									)
								)
							)
						)
						(= temp0 (proc709_0 5 (param1 minLevel: 5)))
						(proc709_5
							param1
							temp27
							2
							5
							(+ 4 (* temp26 2))
							(+ 6 (* temp26 3))
						)
					)
					((param1 supports: temp9)
						(cond
							(
								(and
									(== (= temp30 (param1 minLevel: temp9)) 2)
									(<= 6 temp3 10)
								)
								(= temp0 (proc709_0 temp9 temp30))
								(proc709_5 param1 temp9 3 6 6 10)
							)
							((and (== temp30 3) (<= 11 temp3 12))
								(= temp0 (proc709_0 temp9 temp30))
								(proc709_5 param1 temp9 3 6 11 12)
							)
							(
								(or
									(<= 13 temp3 16)
									(and
										(<= 5 temp3 9)
										(or
											(< [temp18 temp27] 2)
											(>= [temp18 temp27] 4)
										)
										(>= temp51 5)
									)
								)
								(= temp0 (proc709_0 temp9 4))
								(proc709_5 param1 temp9 3 6 5 16)
							)
							((>= temp3 17)
								(= temp0 (+ 5 param4))
								(param1
									minPoints: 17
									maxPoints: 25
									bidBranch: 1
								)
							)
							((and [temp60 temp27] (>= temp3 13))
								(= temp0 (proc709_0 5 (param1 minLevel: 5)))
								(if (< temp26 3)
									(+= temp0 5)
								)
								(proc709_5 param1 temp27 2 5 13 16)
							)
							(else
								(= temp0 0)
								(param1 maxPoints: 9)
							)
						)
					)
					((>= temp3 17)
						(= temp0 temp29)
						(param1 minPoints: 17 maxPoints: 25 bidBranch: 1)
					)
					((< temp3 8)
						(= temp0 0)
						(param1 maxPoints: 9)
					)
					(
						(and
							(or [local0 4] (>= [temp18 4] 4))
							(or [local0 3] (>= [temp18 3] 4))
						)
						(param1 bidBranch: 5)
						(= temp0 50)
						(if (localproc_0 3)
							(proc709_5 param1 3 4 5)
						)
						(if (localproc_0 4)
							(proc709_5 param1 4 4 5)
						)
						(param1 minPoints: 8 maxPoints: 16)
					)
					((and temp86 (>= temp4 13))
						(proc709_5 param1 temp27 2 5 13 16)
						(if (== temp26 1)
							(= temp0 10)
						else
							(= temp0 15)
						)
					)
					((< temp3 10)
						(= temp0 0)
						(param1 maxPoints: 9)
					)
					(else
						(for
							((= temp1 (param1 cheapSuit:)))
							(!= temp1 temp27)
							((++ temp1))
							
							(if (== temp1 5)
								(= temp1 1)
							)
							(if (>= [temp18 temp1] [temp18 temp8])
								(break)
							)
						)
						(if (and (== temp1 temp27) (== (= temp1 temp8) temp27))
							(= temp1 (param1 longSuit: 2))
						)
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
						(proc709_5 param1 temp1 4 11 10 16)
					)
				)
			)
			(
				(and
					(== (BidBox openingBidValue:) 5)
					(== (BidBox openingBidder:) temp52)
					(== temp87 0)
				)
				(cond
					((>= temp4 19)
						(= temp0 30)
						(proc709_4 param1 19 25 0 7 0 7 0 7 0 7)
					)
					(
						(and
							(>= temp3 10)
							(or
								(>= [temp18 (= temp1 3)] 6)
								(>= [temp18 (= temp1 4)] 6)
							)
							(!= temp1 temp27)
						)
						(= temp0
							(proc709_0 temp1 (param1 findGameLevel: temp1))
						)
						(if (== temp1 3)
							(proc709_4 param1 10 17 0 6 0 6 6 11 0 6)
						else
							(proc709_4 param1 10 17 0 6 0 6 0 5 6 11)
						)
					)
					(
						(and
							(>= temp3 10)
							(or
								(>= [temp18 (= temp1 3)] 5)
								(>= [temp18 (= temp1 4)] 5)
							)
							(!= temp1 temp27)
						)
						(if (== (= temp30 (param1 minLevel: temp1)) 2)
							(++ temp30)
						)
						(= temp0 (proc709_0 temp1 temp30))
						(if (== temp1 3)
							(proc709_4 param1 10 17 0 5 0 5 5 6 0 5)
						else
							(proc709_4 param1 10 17 0 5 0 5 0 4 5 6)
						)
					)
					(
						(and
							(>= temp3 12)
							(or
								(>= [temp18 (= temp1 2)] 6)
								(>= [temp18 (= temp1 1)] 6)
							)
							(!= temp1 temp27)
							(or
								(not [temp60 temp27])
								(not (param1 calcHonors: temp27 3))
							)
						)
						(= temp30
							(Max
								(param1 findGameLevel: temp1)
								(param1 minLevel: temp1)
							)
						)
						(= temp0 (proc709_0 temp1 temp30))
					)
					(
						(and
							(>= temp3 9)
							(or [local0 4] (>= [temp18 4] 4))
							(or [local0 3] (>= [temp18 3] 4))
						)
						(param1 bidBranch: 5)
						(= temp0 50)
						(if (localproc_0 3)
							(proc709_4 param1 9 15 -1 -1 -1 -1 4 4 -1 -1)
						)
						(if (localproc_0 4)
							(proc709_4 param1 9 15 -1 -1 -1 -1 -1 -1 4 4)
						)
					)
					((and (>= temp4 10) [temp60 temp27] (u> temp7 20480))
						(= temp0 15)
						(proc709_4 param1 10 17 2 5 2 5 2 5 2 5)
					)
					((and (>= temp4 5) (!= temp8 temp27) (>= [temp18 temp8] 5))
						(= temp0 temp28)
						(proc709_5 param1 temp8 5 11 5 16)
					)
					((and (>= temp3 8) [temp60 temp27])
						(= temp0 (proc709_0 5 (param1 minLevel: 5)))
						(proc709_5 param1 temp27 2 5 8 11)
					)
					(else
						(= temp0 0)
						(proc709_4 param1 0 4 -1 -1 -1 -1 -1 -1 -1 -1)
					)
				)
			)
			(
				(and
					(== temp23 5)
					(== (BidBox openingBidder:) param1)
					(== temp87 1)
					(or (== (temp48 bidBranch:) 3) (== (temp49 bidBranch:) 3))
				)
				(cond
					((== param2 0)
						(cond
							(
								(and
									(>=
										(= temp30 (param1 calcTricks: temp27))
										3
									)
									(or (>= [temp18 temp27] 5) (>= temp30 4))
								)
								(= temp0 50)
							)
							((and (u> temp7 20480) (!= temp8 temp27))
								(= temp0
									(proc709_0 temp8 (param1 minLevel: temp8))
								)
								(proc709_5 param1 temp8 5 11)
							)
							(else
								(= temp0 0)
							)
						)
					)
					((>= temp10 (param1 findGameLevel: temp9))
						(= temp0 0)
					)
					((== param2 10)
						(if (and (>= temp4 16) (param1 stops: temp27))
							(= temp0 15)
							(proc709_5 param1 temp1 2 5 16 18)
						else
							(= temp0 0)
						)
					)
					((<= 13 param2 14)
						(if (and (>= temp3 16) (>= temp51 3))
							(= temp0
								(proc709_0 temp9 (param1 findGameLevel: temp9))
							)
						else
							(= temp0 0)
						)
					)
					((and (== temp50 5) (<= ((proc709_6 1) bidNumber:) 14))
						(cond
							(
								(or
									(>= [temp18 (= temp1 3)] 4)
									(>= [temp18 (= temp1 4)] 4)
								)
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(if (== temp1 3)
									(proc709_4
										param1
										-1
										-1
										-1
										-1
										-1
										-1
										4
										6
										-1
										-1
									)
								else
									(proc709_4
										param1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										-1
										4
										6
									)
								)
							)
							((>= (param1 calcTricks: temp25) 5)
								(= temp0 0)
							)
							(
								(and
									(not (= temp1 (proc709_9 param1 temp27 0)))
									temp86
								)
								(= temp0 (proc709_0 5 (param1 minLevel: 5)))
								(proc709_4 param1 15 18 2 4 2 4 2 4 2 4)
								(proc709_5 param1 temp25 2 5)
							)
							(temp1
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 4 6)
							)
							(else
								(= temp0 0)
								(for
									((= temp1 (param1 cheapSuit:)))
									(!= temp1 temp27)
									((++ temp1))
									
									(if (== temp1 5)
										(= temp1 1)
									)
									(if (>= [temp18 temp1] 4)
										(= temp0
											(proc709_0
												temp1
												(param1 minLevel: temp1)
											)
										)
										(proc709_5 param1 temp1 4 6)
										(break)
									)
								)
								(if (== temp0 0)
									(proc709_5 param1 temp27 4 6)
								)
							)
						)
					)
					((== temp9 5)
						(= temp0 0)
					)
					(
						(and
							(>= temp51 3)
							(param1 agreedSuit: temp9)
							(>= (= temp3 (param1 calcPoints:)) 18)
						)
						(= temp0 (proc709_0 temp9 (+ temp10 1)))
					)
					(
						(and
							(>= [temp60 temp27] 2)
							(< temp51 4)
							(or (< temp51 3) (not (param1 hasCard: temp9 3852)))
						)
						(= temp0 (proc709_0 5 (param1 minLevel: 5)))
						(proc709_5 param1 temp27 2 5)
					)
					((and (u> temp7 20480) (!= temp8 temp9) (!= temp8 temp27))
						(= temp0 (proc709_0 temp8 (param1 minLevel: temp8)))
						(proc709_5 param1 temp1 4 6)
					)
					(
						(or
							(and
								(>= [temp18 (= temp1 2)] 4)
								(param1 canBid: temp1 temp26)
								(>= (param1 calcHCP: temp1) 6)
							)
							(and
								(>= [temp18 (= temp1 3)] 4)
								(param1 canBid: temp1 temp26)
								(>= (param1 calcHCP: temp1) 6)
							)
							(and
								(>= [temp18 (= temp1 4)] 4)
								(param1 canBid: temp1 temp26)
								(>= (param1 calcHCP: temp1) 6)
							)
						)
						(= temp0 (proc709_0 temp1 temp26))
						(proc709_5 param1 temp1 4 11)
					)
					(else
						(= temp0 0)
					)
				)
			)
			((and (or (param1 preempted:) (temp52 preempted:)) (> param4 12))
				(if (not temp39)
					(= temp83 0)
					(for ((= temp1 1)) (<= temp1 4) ((++ temp1))
						(if
							(and
								(!= temp1 temp27)
								(>=
									(= temp30 (+ [temp18 temp1] [temp11 temp1]))
									temp83
								)
							)
							(= temp83 temp30)
							(= temp39 temp1)
						)
					)
				)
				(cond
					((>= temp36 33)
						(param1 agreedSuit: temp39)
						(temp52 agreedSuit: temp39)
						(= temp0 761)
					)
					((and (>= temp36 26) (param1 supports: temp9))
						(= temp0
							(proc709_0 temp9 (param1 findGameLevel: temp9))
						)
						(proc709_5 param1 temp9 4 11)
					)
					(
						(or
							(>= (= temp30 (param1 calcTricks: temp27)) 6)
							(and (>= temp30 4) (>= temp4 10))
						)
						(= temp0 50)
					)
					((and (>= temp35 26) temp86)
						(= temp0 (proc709_0 5 (param1 minLevel: 5)))
						(proc709_5 param1 temp1 3 5)
					)
					(
						(and
							(>= temp36 26)
							(or
								(>= (param1 calcTricks: (= temp1 4)) 10)
								(>= (param1 calcTricks: (= temp1 3)) 10)
								(>= (param1 calcTricks: (= temp1 2)) 10)
								(>= (param1 calcTricks: (= temp1 1)) 10)
							)
						)
						(= temp0
							(proc709_0 temp1 (param1 findGameLevel: temp1))
						)
						(proc709_5 param1 temp1 5 -1)
					)
					(
						(and
							(>= temp36 26)
							(or
								(and
									(proc709_1 param1 4)
									(param1
										canBid: (= temp30 (proc709_0 4 temp26))
									)
								)
								(and
									(proc709_1 param1 3)
									(param1
										canBid: (= temp30 (proc709_0 3 temp26))
									)
								)
								(and
									(proc709_1 param1 2)
									(param1
										canBid: (= temp30 (proc709_0 2 temp26))
									)
								)
								(and
									(proc709_1 param1 1)
									(param1
										canBid: (= temp30 (proc709_0 1 temp26))
									)
								)
							)
						)
						(= temp0 temp30)
						(proc709_5 param1 temp8 5 -1)
					)
					((and (>= temp6 6) (!= [temp18 temp27] 2))
						(= temp0 50)
					)
					(else
						(= temp0 0)
					)
				)
			)
			((and (== (BidBox openingBidder:) param1) (<= 2 param4 12))
				(cond
					((== param2 0)
						(= temp30
							(-
								(= temp30 (+ temp4 temp8))
								(* 4 (- 2 (param1 minLevel: temp8)))
							)
						)
						(= temp31 (if (u> temp7 21760) 2 else 0))
						(if
							(or
								(>= (+ temp30 temp31) 19)
								(and (>= (+ temp30 temp31) 17) (not temp84))
							)
							(= temp31 1)
						)
						(cond
							((not temp31)
								(= temp0 0)
							)
							(
								(and
									(>= temp5 30)
									(or
										(>=
											(+
												(proc709_1 param1 4)
												(proc709_1 param1 3)
												(proc709_1 param1 2)
												(proc709_1 param1 1)
											)
											2
										)
										(==
											(+
												(proc709_3 param1 4)
												(proc709_3 param1 3)
												(proc709_3 param1 2)
												(proc709_3 param1 1)
											)
											3
										)
									)
								)
								(= temp0 temp29)
								(param1 bidBranch: 1)
								(proc709_4 param1 13 21 0 6 0 6 0 6 0 6)
								(proc709_5 param1 temp27 0 3)
							)
							(
								(and
									(<= temp26 2)
									(or [local0 4] (>= [temp18 4] 4))
									(or [local0 3] (>= [temp18 3] 4))
								)
								(= temp0 50)
							)
							(
								(or
									(and
										(>= [temp18 4] 5)
										(localproc_0 (= temp1 4))
									)
									(and
										(>= [temp18 3] 5)
										(localproc_0 (= temp1 3))
									)
									(and
										(>= [temp18 2] 5)
										(localproc_0 (= temp1 2))
									)
									(and
										(>= [temp18 1] 5)
										(localproc_0 (= temp1 1))
									)
								)
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 5 6)
							)
							(
								(and
									(or
										(>= temp4 25)
										(and (>= temp4 21) (== temp26 2))
										(and (>= temp4 18) (== temp26 1))
									)
									(or (not [temp71 4]) (>= [temp60 4] 2))
									(or (not [temp71 3]) (>= [temp60 3] 2))
									(or (not [temp71 2]) (>= [temp60 2] 2))
									(or (not [temp71 1]) (>= [temp60 1] 2))
								)
								(if (>= temp35 26)
									(= temp0 15)
									(proc709_4
										param1
										(- 26 (temp52 minPoints:))
										(- 33 (temp52 maxPoints:))
										2
										5
										2
										5
										2
										5
										2
										5
									)
								else
									(= temp0 (proc709_0 5 (param1 minLevel: 5)))
									(proc709_4
										param1
										(- 18 (temp52 minPoints:))
										(- 25 (temp52 maxPoints:))
										2
										5
										2
										5
										2
										5
										2
										5
									)
								)
							)
							(
								(or
									(= temp1
										(cond
											(
												(and
													(!= temp27 4)
													(>= [temp18 4] 6)
													(localproc_1 4)
												)
												4
											)
											(
												(and
													(!= temp27 3)
													(>= [temp18 3] 6)
													(localproc_1 3)
												)
												3
											)
											(
												(and
													(!= temp27 2)
													(>= [temp18 2] 6)
													(localproc_1 2)
												)
												2
											)
											(
												(and
													(!= temp27 1)
													(>= [temp18 1] 6)
													(localproc_1 1)
												)
												1
											)
											(else 0)
										)
									)
									(= temp1
										(cond
											(
												(and
													(localproc_0 4)
													(>= [temp18 4] 5)
												)
												4
											)
											(
												(and
													(localproc_0 3)
													(>= [temp18 3] 5)
												)
												3
											)
											(
												(and
													(localproc_0 2)
													(>= [temp18 2] 5)
												)
												2
											)
											(
												(and
													(localproc_0 1)
													(>= [temp18 1] 5)
												)
												1
											)
											(else 0)
										)
									)
									(= temp1
										(cond
											(
												(and
													(localproc_0 2)
													(< temp25 2)
													(>= [temp18 2] 4)
												)
												2
											)
											(
												(and
													(localproc_0 3)
													(< temp25 3)
													(>= [temp18 3] 4)
												)
												3
											)
											(
												(and
													(localproc_0 4)
													(< temp25 4)
													(>= [temp18 4] 4)
												)
												4
											)
											(else 0)
										)
									)
									(= temp1
										(cond
											(
												(and
													(!= temp27 4)
													(proc709_1 param1 4)
													(localproc_1 4)
												)
												4
											)
											(
												(and
													(!= temp27 3)
													(proc709_1 param1 3)
													(localproc_1 3)
												)
												3
											)
											(
												(and
													(!= temp27 2)
													(proc709_1 param1 2)
													(localproc_1 2)
												)
												2
											)
											(
												(and
													(!= temp27 1)
													(proc709_1 param1 1)
													(localproc_1 1)
												)
												1
											)
											(else 0)
										)
									)
									(= temp1 (proc709_9 param1 temp23 temp27))
								)
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 5 11 6 16)
							)
							(else
								(= temp0 0)
							)
						)
					)
					((== temp50 4)
						(cond
							(
								(>=
									(= temp30
										(-
											temp36
											(if (>= temp51 2)
												0
											else
												(- 3 temp51)
											)
										)
									)
									37
								)
								(= temp0 (proc709_0 temp9 7))
							)
							((>= temp30 33)
								(= temp0 (proc709_0 temp9 6))
							)
							((>= temp30 26)
								(= temp0
									(proc709_0
										temp9
										(param1 findGameLevel: temp9)
									)
								)
							)
							(else
								(= temp0 0)
							)
						)
					)
					((== temp50 1)
						(cond
							(
								(= temp1
									(cond
										(
											(and
												(localproc_0 4)
												(proc709_1 param1 4)
											)
											4
										)
										(
											(and
												(localproc_0 3)
												(proc709_1 param1 3)
											)
											3
										)
										(
											(and
												(localproc_0 2)
												(proc709_1 param1 2)
											)
											2
										)
										(
											(and
												(localproc_0 1)
												(proc709_1 param1 1)
											)
											1
										)
										((proc709_3 param1 4) 4)
										((proc709_3 param1 3) 3)
										((proc709_3 param1 2) 2)
										((proc709_3 param1 1) 1)
										(else 0)
									)
								)
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 5 11)
							)
							(temp86
								(if (>= temp35 33)
									(= temp0 761)
								else
									(= temp0 15)
									(proc709_5 param1 temp27 2 5)
								)
							)
							(
								(= temp1
									(cond
										((and (>= [temp18 4] 5) (localproc_1 4)) 4)
										((and (>= [temp18 3] 5) (localproc_1 3)) 3)
										((and (>= [temp18 2] 5) (localproc_1 2)) 2)
										((and (>= [temp18 1] 5) (localproc_1 1)) 1)
										(else 0)
									)
								)
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 5 11)
							)
							(else
								(= temp0 temp29)
								(param1 bidBranch: 1)
							)
						)
					)
					((== temp50 5)
						(cond
							(
								(and
									(>= temp36 26)
									(or
										(and
											(>= [temp18 3] 4)
											(localproc_0 3)
											(= temp1 3)
										)
										(and
											(>= [temp18 4] 4)
											(localproc_0 4)
											(= temp1 4)
										)
									)
								)
								(= temp0
									(proc709_0
										temp1
										(param1 findGameLevel: temp1)
									)
								)
								(if (== temp1 3)
									(proc709_4
										param1
										(- (temp52 minPoints:) 26)
										-1
										-1
										-1
										-1
										-1
										4
										6
										-1
										-1
									)
								else
									(proc709_4
										param1
										(- (temp52 minPoints:) 26)
										-1
										-1
										-1
										-1
										-1
										-1
										3
										4
										6
									)
								)
							)
							((and (>= temp36 26) temp86)
								(= temp0
									(proc709_0 5 (param1 findGameLevel: 5))
								)
								(proc709_5 param1 temp27 3 5)
							)
							(
								(or
									(and
										(>= [temp18 3] 4)
										(localproc_0 3)
										(= temp1 3)
									)
									(and
										(>= [temp18 4] 4)
										(localproc_0 4)
										(= temp1 4)
									)
								)
								(if
									(and
										(<=
											(= temp30
												(+ (param1 minLevel: temp1) 1)
											)
											(param1 findGameLevel: temp1)
										)
										(>= temp3 17)
									)
									(= temp0 (proc709_0 temp1 temp30))
								else
									(= temp0 (proc709_0 (- temp30 1)))
								)
								(proc709_5 param1 temp1 3 6)
							)
							([temp60 temp27]
								(= temp0 (proc709_0 5 (param1 minLevel: 5)))
								(proc709_5 param1 temp27 2 5)
							)
							(else
								(= temp1
									(cond
										((and (>= [temp18 4] 5) (!= temp27 4)) 4)
										((and (>= [temp18 3] 5) (!= temp27 3)) 3)
										((and (>= [temp18 2] 5) (!= temp27 2)) 2)
										((and (>= [temp18 1] 5) (!= temp27 1)) 1)
										((and (>= [temp18 4] 4) (localproc_0 4)) 4)
										((and (>= [temp18 3] 4) (localproc_0 3)) 3)
										((and (>= [temp18 2] 4) (localproc_0 2)) 2)
										((and (>= [temp18 1] 4) (localproc_0 1)) 1)
										((and (>= [temp18 4] 3) (localproc_0 4)) 4)
										((and (>= [temp18 3] 3) (localproc_0 3)) 3)
										(else
											(param1 bidBranch: 1)
											temp27
										)
									)
								)
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 5 -1)
							)
						)
					)
					((== temp9 5)
						(cond
							((and (>= temp35 26) (>= (param1 stops: temp27) 1))
								(= temp0 15)
							)
							((and (>= temp4 17) (== param2 5))
								(= temp0 10)
							)
							(
								(and
									(>= temp36 26)
									(or [local0 4] (>= [temp18 4] 4))
									(or [local0 3] (>= [temp18 3] 4))
								)
								(if (== global424 -1)
									(= temp0 50)
								else
									(= temp0 temp29)
									(param1 bidBranch: 1)
								)
							)
							(
								(or
									(= temp1
										(cond
											(
												(and
													(>= [temp18 4] 6)
													(localproc_1 4)
												)
												4
											)
											(
												(and
													(>= [temp18 3] 6)
													(localproc_1 3)
												)
												3
											)
											(
												(and
													(>= [temp18 2] 6)
													(localproc_1 2)
												)
												2
											)
											(
												(and
													(>= [temp18 1] 6)
													(localproc_1 1)
												)
												1
											)
											(else 0)
										)
									)
									(and
										(<= [temp18 temp27] 2)
										(not (param1 calcHCP: temp27))
										(= temp1
											(cond
												(
													(and
														(>= [temp18 4] 5)
														(localproc_0 4)
													)
													4
												)
												(
													(and
														(>= [temp18 3] 5)
														(localproc_0 3)
													)
													3
												)
												(
													(and
														(>= [temp18 2] 5)
														(localproc_0 2)
													)
													2
												)
												(
													(and
														(>= [temp18 1] 5)
														(localproc_0 1)
													)
													1
												)
												(else 0)
											)
										)
									)
								)
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 5 11)
							)
							(else
								(= temp0 0)
							)
						)
					)
					((== temp9 temp23)
						(param1 agreedSuit: (= temp39 temp23))
						(= temp3 (param1 calcPoints:))
						(= temp36
							(+
								(/
									(+
										(* (temp52 minPoints:) 3)
										(temp52 maxPoints:)
									)
									4
								)
								temp3
							)
						)
						(param1 combinedPts: temp36)
						(= temp30 (+ 26 (if (<= temp39 2) 3 else 0)))
						(cond
							((>= temp36 temp30)
								(= temp0
									(proc709_0
										temp39
										(param1 findGameLevel: temp39)
									)
								)
							)
							(
								(and
									(<
										(param1 minLevel: temp39)
										(param1 findGameLevel: temp39)
									)
									(or
										(>=
											(+ temp3 (temp52 maxPoints:))
											temp30
										)
										(and
											(!= global428 param1)
											(!= global428 temp52)
										)
									)
								)
								(= temp0
									(proc709_0 temp39 (param1 minLevel: temp39))
								)
							)
							(else
								(= temp0 0)
							)
						)
					)
					((param1 supports: temp9 1)
						(if (>= temp3 17)
							(param1 minPoints: 17)
							(= temp30 1)
						else
							(param1 maxPoints: 20)
							(= temp30 0)
						)
						(= temp0
							(proc709_0
								temp9
								(+ (param1 minLevel: temp9) temp30)
							)
						)
						(proc709_5 param1 temp9 4 8)
					)
					((and [temp60 1] [temp60 2] [temp60 3] [temp60 4])
						(if (>= temp35 26)
							(= temp0 15)
							(proc709_4
								param1
								(- 26 (temp52 minPoints:))
								-1
								2
								5
								2
								5
								2
								5
								2
								5
							)
						else
							(= temp0 (proc709_0 5 (param1 minLevel: 5)))
							(proc709_4
								param1
								-1
								(- 26 (temp52 minPoints:))
								2
								5
								2
								5
								2
								5
								2
								5
							)
						)
					)
					(else
						(= temp1
							(cond
								((>= [temp18 4] 5) 4)
								((>= [temp18 3] 5) 3)
								((>= [temp18 2] 5) 2)
								((>= [temp18 1] 5) 1)
								((and (>= [temp18 4] 4) (localproc_0 4)) 4)
								((and (>= [temp18 3] 4) (localproc_0 3)) 3)
								((and (>= [temp18 2] 4) (localproc_0 2)) 2)
								((and (>= [temp18 1] 4) (localproc_0 1)) 1)
								((>= temp51 3) temp9)
								(else
									(param1 bidBranch: 1)
									temp27
								)
							)
						)
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
						(proc709_5 param1 temp1 4 8)
					)
				)
			)
			((and (== temp52 (BidBox openingBidder:)) (== (temp52 bidsOpen:) 2))
				(cond
					((and (== param2 50) (>= (param1 calcTricks: temp25) 5))
						(= temp0 0)
					)
					(temp39
						(= temp30
							(Max
								(param1 findGameLevel: temp39)
								(param1 minLevel: temp39)
							)
						)
						(= temp31 (+ 14 (* temp30 3)))
						(cond
							(
								(and
									(>= temp36 26)
									(or
										(!= temp39 5)
										(and
											(>= temp35 29)
											(>=
												(+
													(param1 stops: temp27)
													(temp52 stops: temp27)
												)
												2
											)
										)
									)
								)
								(if
									(and
										(==
											(= temp0 (proc709_0 temp39 temp30))
											(+ global427 5)
										)
										(>=
											temp26
											(param1 findGameLevel: temp39)
										)
									)
									(= temp0 0)
								else
									(param1
										minPoints:
											(- temp31 (temp52 minPoints:))
									)
								)
							)
							((> (param1 points:) (+ 3 (param1 minPoints:)))
								(= temp0
									(proc709_0 temp39 (param1 minLevel: temp39))
								)
								(param1 minPoints: (+ 4 (param1 minPoints:)))
							)
							((!= temp25 temp39)
								(= temp0
									(proc709_0 temp39 (param1 minLevel: temp39))
								)
							)
							(else
								(= temp0 0)
								(param1 maxPoints: (+ 3 (param1 minPoints:)))
							)
						)
					)
					(
						(and
							(>= (+ temp51 [temp11 temp9]) 7)
							(OneOf param2 global427 0 99)
							(or (== temp9 4) (< (+ [temp18 4] [temp11 4]) 9))
							(or (== temp9 3) (< (+ [temp18 3] [temp11 3]) 9))
							(or (== temp9 2) (< (+ [temp18 2] [temp11 2]) 9))
							(or (== temp9 1) (< (+ [temp18 1] [temp11 1]) 9))
						)
						(= temp0 0)
					)
					(
						(= temp1
							(cond
								((and (>= [temp18 4] 6) (localproc_1 4)) 4)
								((and (>= [temp18 3] 6) (localproc_1 3)) 3)
								((and (>= [temp18 2] 6) (localproc_1 2)) 2)
								((and (>= [temp18 1] 6) (localproc_1 1)) 1)
								((and (not [local6 4]) (proc709_3 param1 4)) 4)
								((and (not [local6 3]) (proc709_3 param1 3)) 3)
								((and (not [local6 2]) (proc709_3 param1 2)) 2)
								((and (not [local6 1]) (proc709_3 param1 1)) 1)
								((and (localproc_1 4) (proc709_1 param1 4)) 4)
								((and (localproc_1 3) (proc709_1 param1 3)) 3)
								((and (localproc_1 2) (proc709_1 param1 2)) 2)
								((and (localproc_1 1) (proc709_1 param1 1)) 1)
								(else 0)
							)
						)
						(if (and (== temp1 temp25) (not temp59))
							(= temp0 0)
						else
							(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
							(proc709_5 param1 temp1 5 8)
						)
					)
					(
						(or
							(param1 supports: (= temp1 temp38) 1)
							(param1 supports: (= temp1 temp9) 1)
						)
						(if (and (== temp1 temp25) (not temp59))
							(= temp0 0)
						else
							(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
							(proc709_5 param1 temp9 3 8)
						)
					)
					(else
						(= temp16 1)
						(= temp83 0)
						(while (<= temp16 4)
							(if
								(>
									(= temp30
										(+ [temp18 temp16] [temp11 temp16])
									)
									temp83
								)
								(= temp83 temp30)
							)
							(++ temp16)
						)
						(= temp16 (param1 cheapSuit:))
						(= temp34 100)
						(while (!= temp16 temp25)
							(if (== (+ [temp18 temp16] [temp11 temp16]) temp83)
								(= temp0
									(proc709_0 temp16 (param1 minLevel: temp16))
								)
								(break)
							)
							(++ temp16)
						)
						(= temp0 (if (== temp34 100) 0 else temp34))
					)
				)
			)
			((and (== (BidBox openingBidder:) param1) (== (temp52 bidsOpen:) 2))
				(cond
					(
						(and
							(or
								(= temp1 temp39)
								(>=
									(+ [temp18 (= temp1 temp9)] [temp11 temp9])
									8
								)
							)
							(= temp30
								(Max
									(param1 findGameLevel: temp1)
									(param1 minLevel: temp1)
								)
							)
							(= temp31 (+ 14 (* temp30 3)))
							(>= temp36 temp31)
							(or
								(!= temp1 5)
								(and
									(>= temp35 29)
									(>=
										(+
											(param1 stops: temp27)
											(temp52 stops: temp27)
										)
										2
									)
								)
							)
						)
						(if
							(and
								(== temp1 temp9)
								(>= temp10 (param1 findGameLevel: temp1))
							)
							(= temp0 0)
						else
							(= temp0 (proc709_0 temp1 temp30))
						)
					)
					(
						(or
							(>= (+ [temp18 temp9] [temp11 temp9]) 7)
							(>=
								(+
									(param1 calcTricks: temp9)
									(temp52 calcTricks: temp9)
								)
								10
							)
						)
						(= temp0 0)
					)
					(else
						(= temp16 1)
						(= temp83 0)
						(while (<= temp16 4)
							(if
								(>
									(= temp30
										(+ [temp18 temp16] [temp11 temp16])
									)
									temp83
								)
								(= temp83 temp30)
							)
							(++ temp16)
						)
						(= temp16 (param1 cheapSuit:))
						(= temp34 100)
						(while (!= temp16 temp25)
							(if (== (+ [temp18 temp16] [temp11 temp16]) temp83)
								(= temp0
									(proc709_0 temp16 (param1 minLevel: temp16))
								)
								(break)
							)
							(++ temp16)
						)
						(= temp0 (if (== temp34 100) 0 else temp34))
					)
				)
			)
			(else
				(= temp0 0)
			)
		)
		(return temp0)
	)
)

