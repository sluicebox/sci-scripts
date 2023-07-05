;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 716)
(include sci.sh)
(use Main)
(use n709)
(use bidBoxWindow)
(use System)

(public
	other1_tree 0
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(= temp0 (param1 findGameLevel: param2))
	(if (not (param1 canBid: temp0))
		(= temp0 (param1 minLevel: param2))
	)
	(proc709_0 param2 temp0)
)

(instance other1_tree of Code
	(properties)

	(method (doit param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24 temp25 temp26 temp27 [temp28 2] temp30 temp31 temp32 temp33 temp34 temp35 temp36 temp37 temp38 temp39 temp40 [temp41 6] [temp47 6] [temp53 6] [temp59 5] [temp64 5] temp69 temp70 temp71 temp72 temp73 temp74 temp75 temp76 temp77)
		(for ((= temp12 0)) (< temp12 5) ((++ temp12))
			(= [temp64 temp12] 0)
			(= [temp59 temp12] 0)
		)
		(for ((= temp12 0)) (< temp12 6) ((++ temp12))
			(= [temp53 temp12] 0)
			(= [temp47 temp12] 0)
			(= [temp41 temp12] 0)
		)
		(= temp17 (param1 location:))
		(= temp38 (param1 partner:))
		(= temp18 (temp38 location:))
		(= temp2 (param1 points:))
		(= temp3 (param1 hcp:))
		(= temp4 (param1 playingTricks:))
		(= temp5 (param1 quickTricks:))
		(= temp6 (param1 singletons:))
		(= temp7 (param1 voids:))
		(= temp8 (param1 shape:))
		(= temp9 (param1 longSuit:))
		(= temp26 (param1 combinedHCP:))
		(= temp27 (param1 combinedPts:))
		(= temp30 (param1 agreedSuit:))
		(= temp74 (+ 1 (mod (- (BidBox openingBidValue:) 1) 5)))
		(= [temp41 0] 0)
		(= [temp41 1] (param1 clubs:))
		(= [temp41 2] (param1 diamonds:))
		(= [temp41 3] (param1 hearts:))
		(= [temp41 4] (param1 spades:))
		(= [temp64 1] (param1 partnerClubs:))
		(= [temp64 2] (param1 partnerDiamonds:))
		(= [temp64 3] (param1 partnerHearts:))
		(= [temp64 4] (param1 partnerSpades:))
		(for ((= temp12 0)) (< temp12 6) ((++ temp12))
			(= [temp47 temp12] (= [temp53 temp12] 0))
		)
		(= temp37 (= temp77 0))
		(= temp12 0)
		(= temp20 (BidBox size:))
		(while (< temp12 temp20)
			(= temp72 (BidBox at: temp12))
			(if
				(and
					(not (temp72 artificial:))
					(not (OneOf (temp72 bidNumber:) 0 50 99))
					(<= 1 (= temp1 (temp72 suit:)) 5)
				)
				(++ [temp47 temp1])
				(if (OneOf (= temp21 (temp72 location:)) temp17 temp18)
					(++ [temp53 temp1])
					(if (== temp21 temp17)
						(= temp15 temp1)
						(if (not temp77)
							(= temp77 temp1)
						)
					else
						(= temp10 temp1)
						(if (not temp37)
							(= temp37 temp1)
						)
					)
				)
			)
			(++ temp12)
		)
		(for ((= temp12 1)) (<= temp12 4) ((++ temp12))
			(if (not (= [temp59 temp12] (param1 stops: temp12 1)))
				(= [temp59 temp12] [temp53 temp12])
			)
		)
		(= temp16 (+ (/ (- param3 1) 5) 1))
		(= temp14 [temp41 temp15])
		(= temp11 (+ (/ (- param2 1) 5) 1))
		(= temp19 [temp41 temp10])
		(if (not (= temp71 (temp38 forcing:)))
			(= temp71 (param1 forcing:))
		)
		(if (and (== temp71 2) (>= temp11 (param1 findGameLevel: temp10)))
			(and (== temp71 3) (>= temp11 6))
			(= temp71 0)
		)
		(= temp0 0)
		(cond
			(
				(and
					(not (= temp23 0))
					(<= 1 param3 4)
					(== (BidBox openingBidder:) param1)
					(== (param1 bidsOpen:) 1)
					(<= (= temp23 param2) (+ param3 10))
					(!= temp10 5)
				)
				(= temp69
					(cond
						((or (== temp11 1) (== temp23 (+ param3 5))) 0)
						((or (<= temp23 (+ param3 5)) (== temp23 (+ param3 10))) 4)
						(else 13)
					)
				)
				(= temp70 (+ temp2 temp69))
				(cond
					((param1 supports: temp10)
						(cond
							((and (>= temp10 3) (>= temp70 20))
								(= temp0 (proc709_0 temp10 4))
								(proc709_5 param1 temp10 4 6 (- 20 temp69) 23)
							)
							((and (<= temp10 2) (>= temp70 20))
								(cond
									(
										(and
											[temp59 4]
											[temp59 3]
											[temp59 2]
											[temp59 1]
										)
										(= temp0 15)
										(proc709_4
											param1
											(- 20 temp69)
											23
											-1
											-1
											4
											6
											-1
											-1
											-1
											-1
										)
									)
									(
										(or
											(and
												(not [temp53 (= temp1 3)])
												[temp59 3]
											)
											(and
												(not [temp53 (= temp1 4)])
												[temp59 4]
											)
										)
										(= temp0
											(proc709_0
												temp1
												(+ (param1 minLevel: temp1) 1)
											)
										)
										(param1
											minPoints: (- 19 temp69)
											maxPoints: 23
											forcing: 2
										)
										(proc709_5 param1 temp1 3 6)
									)
									((= temp1 (proc709_9 param1 temp15 temp10))
										(= temp0
											(proc709_0
												temp1
												(+ 1 (param1 minLevel: temp1))
											)
										)
										(param1
											minPoints: 19
											maxPoints: 23
											forcing: 2
										)
										(proc709_5 param1 temp1 3 6)
									)
									(
										(and
											(>= temp14 6)
											(proc709_1 param1 temp15)
										)
										(= temp0 (proc709_0 temp15 3))
										(proc709_5 param1 temp15 6 11 17 23)
									)
									(else
										(= temp0 (proc709_0 temp10 4))
										(proc709_5 param1 temp10 4 6 20 23)
									)
								)
							)
							(
								(and
									(>= 18 (+ temp3 temp69) 19)
									(OneOf temp8 17203 17458 21298)
								)
								(= temp0 10)
								(proc709_4 param1 18 19 2 5 2 5 2 5 2 5)
							)
							(
								(and
									(>= temp3 16)
									(<= 2 temp11 3)
									(OneOf temp8 17203 17458 21298)
								)
								(= temp0 15)
								(proc709_4 param1 16 19 2 5 2 5 2 5 2 5)
							)
							((>= temp2 17)
								(= temp0
									(proc709_0
										temp10
										(+ (param1 minLevel: temp10) 1)
									)
								)
								(proc709_5 param1 temp10 4 6 (- 17 temp69) 19)
							)
							((== temp10 temp15)
								(= temp0 0)
								(param1 maxPoints: 16)
							)
							(else
								(= temp0
									(proc709_0 temp10 (param1 minLevel: temp10))
								)
								(proc709_5 param1 temp10 4 6 13 16)
							)
						)
					)
					((= temp1 (proc709_9 param1 temp15 temp10))
						(= temp39 (param1 minLevel: temp15))
						(= temp40 (param1 minLevel: temp1))
						(cond
							((>= [temp41 temp15] (+ [temp41 temp1] 2))
								(if (>= temp2 17)
									(= temp0 (proc709_0 temp15 (+ 1 temp39)))
									(proc709_5
										param1
										temp15
										5
										-1
										(- 17 temp69)
										23
									)
								else
									(= temp0 (proc709_0 temp15 temp39))
									(proc709_5 param1 temp15 5 -1 13 16)
								)
							)
							((and (>= temp2 19) (or temp7 temp6))
								(= temp0 (proc709_0 temp1 (+ 1 temp40)))
								(proc709_5 param1 temp1 4 6 19 23)
							)
							((and (<= 18 temp3 19) (not (or temp7 temp6)))
								(= temp0
									(+ 5 (proc709_0 5 (param1 minLevel: 5)))
								)
								(proc709_4 param1 18 21 2 5 2 5 2 5 2 5)
							)
							((and (>= temp1 3) (== temp40 temp11))
								(= temp0 (proc709_0 temp1 temp40))
								(proc709_5 param1 temp1 4 6)
							)
							((and (< temp2 16) (proc709_1 param1 temp15))
								(= temp0 (proc709_0 temp15 temp39))
								(proc709_5 param1 temp15 5 -1 13 15)
							)
							((and (< temp3 16) (not (or temp7 temp6)))
								(= temp0 (proc709_0 5 (param1 minLevel: 5)))
								(param1 maxPoints: 15)
							)
							(
								(or
									(>= temp2 16)
									(< temp1 temp15)
									(== temp40 temp11)
								)
								(= temp0 (proc709_0 temp1 temp40))
								(proc709_5 param1 temp1 4 6)
								(if (and (> temp1 temp15) (> temp40 temp11))
									(param1 minPoints: 16)
								)
							)
							(
								(and
									(or
										(== temp8 21553)
										(== temp8 21538)
										(== temp8 17473)
									)
									(<= temp19 2)
									[temp59
										(if
											(==
												(= temp22 (param1 longSuit: 3))
												temp10
											)
											(param1 longSuit: 4)
										else
											temp22
										)
									]
								)
								(= temp0 (proc709_0 5 (param1 minLevel: 5)))
								(proc709_5 param1 temp10 1 3 13 15)
							)
							((>= [temp41 temp15] 5)
								(= temp0 (proc709_0 temp15 temp39))
								(proc709_5 param1 temp15 5 -1)
							)
							((>= temp19 3)
								(= temp0
									(proc709_0 temp10 (param1 minLevel: temp10))
								)
								(proc709_5 param1 temp10 3 6)
							)
							(else
								(for
									((= temp12 (param1 cheapSuit:)))
									(!= temp12 temp10)
									((++ temp12))
									
									(if (>= [temp41 temp12] 4)
										(= temp0
											(proc709_0
												temp12
												(param1 minLevel: temp12)
											)
										)
										(proc709_5 param1 temp12 4 5)
										(break)
									)
								)
							)
						)
					)
					(
						(and
							(<= 18 (+ temp3 temp69) 19)
							(or
								(== temp8 17203)
								(== temp8 17458)
								(== temp8 21298)
							)
						)
						(= temp0 10)
						(param1
							minPoints: (- 18 temp69)
							maxPoints: (- 20 temp69)
						)
					)
					((proc709_1 param1 temp15)
						(= temp20 (param1 minLevel: temp15))
						(if (>= temp2 17)
							(= temp0 (proc709_0 temp15 (+ temp20 1)))
							(param1 minPoints: 17)
						else
							(= temp0 (proc709_0 temp15 temp20))
							(param1 maxPoints: 16)
						)
					)
					((and [temp59 4] [temp59 3] [temp59 2] [temp59 1])
						(= temp0 (proc709_0 5 (param1 minLevel: 5)))
						(param1 maxPoints: 16)
					)
					((>= temp19 3)
						(= temp0 (proc709_0 temp10 (param1 minLevel: temp10)))
						(proc709_5 param1 temp10 3 6)
					)
					((>= [temp41 temp15] 5)
						(= temp0 (proc709_0 temp15 temp20))
						(proc709_5 param1 temp15 5 -1)
					)
					(
						(or
							(and (not [temp53 1]) (>= [temp41 (= temp1 1)] 4))
							(and (not [temp53 2]) (>= [temp41 (= temp1 2)] 4))
							(and (not [temp53 3]) (>= [temp41 (= temp1 3)] 4))
							(and (not [temp53 4]) (>= [temp41 (= temp1 4)] 4))
						)
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
						(proc709_5 param1 temp1 4 6)
					)
					(else
						(= temp0 (proc709_0 5 (param1 minLevel: 5)))
						(param1 maxPoints: 16)
					)
				)
			)
			((== temp23 5)
				(= temp73 [temp41 (= temp1 (param1 longSuit: 2))])
				(cond
					((not (or temp6 temp7))
						(cond
							((>= temp14 6)
								(if (>= temp2 16)
									(= temp0 (proc709_0 temp15 3))
									(param1 minPoints: 16)
								else
									(= temp0 (proc709_0 temp15 2))
									(param1 maxPoints: 16)
								)
								(proc709_5 param1 temp15 5 -1)
							)
							(
								(or
									(>= temp3 20)
									(and (== temp3 19) (== temp14 5))
								)
								(= temp0 15)
								(param1 minPoints: 20)
							)
							(
								(or
									(>= temp3 17)
									(and (== temp3 16) (== temp14 5))
								)
								(= temp0 10)
								(param1 minPoints: 17 maxPoints: 19)
							)
							((and (>= temp73 4) (>= (param1 calcHCP: temp1) 6))
								(= global425 (proc709_0 temp1 2))
								(proc709_5 param1 temp1 4 4 -1 16)
							)
							(
								(and
									(>= temp14 5)
									(>= (param1 calcHonors: temp15 5) 4)
								)
								(= global425 (proc709_0 temp15 2))
								(proc709_5 param1 temp15 5 -1 -1 16)
							)
							(else
								(= temp0 0)
								(param1 maxPoints: 16)
							)
						)
					)
					((>= temp14 (+ temp73 2))
						(cond
							(
								(and
									(>= temp2 20)
									(>= temp15 3)
									(>= temp14 6)
									(or
										(>= temp14 7)
										(>= (param1 calcHonors: temp15 5) 3)
									)
								)
								(= temp0 (proc709_0 temp15 4))
								(proc709_5 param1 temp15 6 -1 20 -1)
							)
							(
								(and
									(>= temp3 18)
									(not temp7)
									(== temp6 1)
									(param1 hasCard: (param1 longSuit: 4) 3852)
								)
								(= temp0 15)
								(param1 minPoints: 20)
							)
							((>= temp2 17)
								(= temp0 (proc709_0 temp15 3))
								(proc709_5 param1 temp15 5 -1 16 -1)
							)
							(else
								(= temp0 (proc709_0 temp15 2))
								(proc709_5 param1 temp15 5 -1 -1 16)
							)
						)
					)
					((== temp14 temp73)
						(if (>= temp2 19)
							(= temp20 3)
							(param1 minPoints: 16)
						else
							(= temp20 2)
							(param1 maxPoints: 16)
						)
						(cond
							((!= temp8 17473) 0)
							((and (!= temp15 1) (== [temp41 1] 4))
								(= temp1 1)
							)
							((and (!= temp15 2) (== [temp41 2] 4))
								(= temp1 2)
							)
							(else
								(= temp1 3)
							)
						)
						(= temp0 (proc709_0 temp1 temp20))
						(proc709_5 param1 temp1 4 6)
					)
					(
						(and
							(>= (param1 calcHonors: temp15 5) 4)
							(<= (param1 calcHCP: temp1) 3)
						)
						(if (>= temp2 17)
							(= temp20 3)
							(param1 minPoints: 16)
						else
							(= temp20 2)
							(param1 maxPoints: 16)
						)
						(= temp0 (proc709_0 temp15 temp20))
						(proc709_5 param1 temp15 5 -1)
					)
					(
						(or
							(>= temp73 5)
							(>= (param1 calcHCP: temp1) 4)
							(>= (param1 calcHonors: temp1 5) 3)
						)
						(if (>= temp2 19)
							(= temp20 3)
							(param1 minPoints: 16)
						else
							(= temp20 2)
							(param1 maxPoints: 16)
						)
						(= temp0 (proc709_0 temp1 temp20))
						(proc709_5 param1 temp1 4 6)
					)
					(
						(and
							(>= temp3 16)
							(not temp7)
							(== temp6 1)
							(param1 hasCard: (param1 longSuit: 4) 3852)
						)
						(if (>= temp3 19)
							(= temp0 15)
							(param1 minPoints: 20)
						else
							(= temp0 10)
							(param1 minPoints: 16 maxPoints: 19)
						)
					)
					((proc709_1 param1 temp15)
						(if (>= temp2 17)
							(= temp20 3)
							(param1 minPoints: 16)
						else
							(= temp20 2)
							(param1 maxPoints: 16)
						)
						(= temp0 (proc709_0 temp15 temp20))
						(proc709_5 param1 temp15 5 -1)
					)
					(
						(or
							(>= (param1 calcHCP: temp1) 2)
							(>= (param1 calcHonors: temp1 5) 2)
						)
						(= temp0 (proc709_0 temp1 2))
						(proc709_5 param1 temp1 4 6 -1 16)
					)
					(else
						(= temp0 0)
						(param1 maxPoints: 16)
					)
				)
			)
			((== temp23 10)
				(= temp73 [temp41 (= temp1 (param1 longSuit: 2))])
				(cond
					((>= temp2 19)
						(cond
							((>= temp3 20)
								(= temp0 30)
								(param1 minPoints: 20)
							)
							(
								(and
									(not (= temp1 (proc709_9 param1 temp15 0)))
									(>= temp14 6)
								)
								(= temp0 761)
								(param1 agreedSuit: temp15 forcing: 1)
								(temp38 agreedSuit: temp15)
							)
							(temp1
								(= temp0 (proc709_0 temp1 3))
								(proc709_5 param1 temp1 4 6 -1 20)
							)
							((not (+ temp6 temp7))
								(= temp0 15)
								(proc709_4 param1 13 20 2 6 2 6 2 6 2 6)
							)
							(else
								(= temp0
									(proc709_0
										temp15
										(param1 findGameLevel: temp15)
									)
								)
								(proc709_5 param1 temp15 5 -1 19 23)
							)
						)
					)
					((not (+ temp6 temp7))
						(= temp0 15)
						(proc709_4 param1 13 20 2 6 2 6 2 6 2 6)
					)
					((>= temp14 (+ temp73 2))
						(= temp0 (proc709_0 temp15 3))
						(proc709_5 param1 temp15 5 -1 -1 18)
					)
					((== temp14 temp73)
						(cond
							((!= temp8 17473) 0)
							((and (!= temp15 1) (== [temp41 1] 4))
								(= temp1 1)
							)
							((and (!= temp15 2) (== [temp41 2] 4))
								(= temp1 2)
							)
							(else
								(= temp1 3)
							)
						)
						(= temp0 (proc709_0 temp1 3))
						(proc709_5 param1 temp1 4 6 -1 18)
					)
					((proc709_3 param1 temp1)
						(= temp0 (proc709_0 temp1 3))
						(proc709_5 param1 temp1 4 6 -1 18)
					)
					((proc709_1 param1 temp15)
						(= temp0 (proc709_0 temp15 3))
						(proc709_5 param1 temp15 5 -1 -1 18)
					)
					(else
						(= temp0 15)
						(proc709_4 param1 13 20 2 6 2 6 2 6 2 6)
					)
				)
			)
			((and (> temp23 (+ param3 10)) (!= temp10 5))
				(= temp22 (< temp11 (param1 findGameLevel: temp10)))
				(cond
					((and (>= temp2 16) (>= temp19 2) temp22)
						(= temp0 (proc709_0 temp10 (param1 minLevel: temp10)))
					)
					(
						(and
							(<= 16 param2 17)
							(>= temp5 4)
							(>= temp19 2)
							(or (>= temp19 3) (param1 hasCard: temp10 3851))
						)
						(if temp22
							(= temp0 (proc709_0 temp10 5))
						else
							(= temp0 0)
						)
					)
					(
						(and
							(>= temp19 3)
							[temp59 1]
							[temp59 2]
							[temp59 3]
							[temp59 4]
							(< param2 15)
						)
						(= temp0 15)
					)
					((>= temp19 2)
						(= temp0 0)
					)
					((and (not temp19) (or (== temp8 21808) (== temp8 25888)))
						(= temp1 (param1 longSuit: 2))
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
					)
					((or (>= temp8 28672) (and (> temp8 24576) (not temp19)))
						(= temp0 (proc709_0 temp9 (param1 minLevel: temp9)))
					)
					(else
						(= temp0 0)
					)
				)
			)
			(
				(and
					(not (= temp23 0))
					(== (BidBox openingBidder:) temp38)
					(<= 1 (BidBox openingBidValue:) 4)
					(== (param1 bidsOpen:) 1)
					(== (= temp23 ((proc709_6 2) bidNumber:)) 5)
				)
				(cond
					((>= temp11 (param1 findGameLevel: temp10))
						(= temp0 0)
					)
					((or (<= temp3 7) (and (== temp3 8) (== temp8 17203)))
						(cond
							((or (== temp10 5) (== temp10 temp37))
								(= temp0 0)
							)
							((> param2 10)
								(if
									(or
										(param1 supports: (= temp1 temp10))
										(param1 supports: (= temp1 temp37) 1)
									)
									(= temp0
										(proc709_0
											temp1
											(param1 minLevel: temp1)
										)
									)
									(proc709_5 param1 temp1 2 5)
								else
									(= temp0 (proc709_0 5 (param1 minLevel: 5)))
									(proc709_5 param1 temp10 0 3)
								)
							)
							((> [temp41 temp37] [temp41 temp10])
								(= temp0
									(proc709_0 temp37 (param1 minLevel: temp37))
								)
								(proc709_5 param1 temp37 2 3)
							)
							((== [temp41 temp37] [temp41 temp10])
								(if
									(or
										(and (>= temp37 3) (< temp10 3))
										(< temp37 3)
										(>= temp10 3)
									)
									(= temp0
										(proc709_0
											temp37
											(param1 minLevel: temp37)
										)
									)
									(proc709_5 param1 temp1 2 5)
								else
									(= temp0 0)
								)
							)
							((>= [temp41 temp10] 3)
								(= temp0 0)
							)
							(else
								(= temp0 (proc709_0 5 (param1 minLevel: 5)))
							)
						)
					)
					((<= 11 param2 14)
						(if
							(or
								(and
									(== temp37 temp10)
									(param1 supports: temp10 1)
								)
								(and
									(<= (& temp8 $000f) 2)
									(param1 supports: temp10)
								)
							)
							(= temp0 (proc709_0 temp10 4))
						else
							(= temp0 15)
						)
						(param1 minPoints: 8)
					)
					((== param2 10)
						(= temp0 15)
						(param1 minPoints: 8)
					)
					((and (!= temp10 temp37) (>= [temp41 temp10] 4))
						(= temp0 (proc709_0 temp10 3))
						(proc709_5 param1 temp10 4 5 8 -1)
					)
					(
						(or
							(> [temp41 temp37] [temp41 temp10])
							(and
								(== [temp41 temp37] [temp41 temp10])
								(or (>= temp37 3) (< temp10 3))
							)
						)
						(= temp0 (proc709_0 temp37 (param1 minLevel: temp37)))
						(proc709_5 param1 temp1 2 5)
					)
					(else
						(= temp0 0)
					)
				)
			)
			((== temp23 10)
				(cond
					((and (== param2 25) (>= temp3 15))
						(= temp0 30)
					)
					((>= temp11 (param1 findGameLevel: temp10))
						(if (>= [temp41 temp37] [temp41 temp10])
							(= temp0
								(proc709_0 temp37 (param1 minLevel: temp37))
							)
						else
							(= temp0 0)
						)
					)
					(
						(and
							[temp59 1]
							[temp59 2]
							[temp59 3]
							[temp59 4]
							(not (param1 supports: temp37 1))
							(not (param1 supports: temp10))
						)
						(= temp0 (proc709_0 5 (param1 minLevel: 5)))
						(proc709_5 param1 temp10 2 3)
						(proc709_5 param1 temp37 0 3)
					)
					((== temp10 temp37)
						(cond
							((param1 supports: temp10)
								(= temp0
									(proc709_0
										temp10
										(param1 findGameLevel: temp10)
									)
								)
								(proc709_5 param1 temp1 3 5)
							)
							((param1 supports: temp10 1)
								(= temp0
									(proc709_0 temp10 (param1 minLevel: temp10))
								)
								(proc709_5 param1 temp1 2 5)
							)
							(else
								(= temp0 (proc709_0 5 (param1 minLevel: 5)))
								(proc709_5 param1 temp37 0 2)
							)
						)
					)
					((and (< temp37 3) (>= temp10 3))
						(if
							(and
								(<= (& temp8 $000f) 2)
								(or
									(>= [temp41 (= temp1 temp37)] 4)
									(>= [temp41 (= temp1 temp10)] 4)
								)
							)
							(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
							(proc709_5 param1 temp1 3 5)
						else
							(= temp0 (proc709_0 5 (param1 minLevel: 5)))
							(proc709_5 param1 temp10 2 3)
							(proc709_5 param1 temp37 0 3)
						)
					)
					((>= [temp41 temp37] [temp41 temp10])
						(= temp0 (proc709_0 temp37 (param1 minLevel: temp37)))
						(proc709_5 param1 temp37 3 5)
					)
					((param1 supports: temp10 (<= temp10 2))
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
						(proc709_5 param1 temp1 3 5)
					)
					(else
						(= temp0 (proc709_0 5 (param1 minLevel: 5)))
						(proc709_5 param1 temp10 2 3)
						(proc709_5 param1 temp37 0 3)
					)
				)
			)
			(
				(and
					(>
						((proc709_6 2) bidNumber:)
						(+ (BidBox openingBidValue:) 10)
					)
					(!= temp15 5)
				)
				(cond
					(
						(or
							(== temp10 temp15)
							(== temp10 5)
							(and (>= temp19 3) (<= [temp41 temp37] 2))
						)
						(= temp0 0)
					)
					((>= temp8 32768)
						(= temp0 (proc709_0 temp15 (param1 minLevel: temp15)))
					)
					((!= temp10 temp37)
						(if (>= [temp41 temp37] 3)
							(= temp0
								(proc709_0 temp37 (param1 minLevel: temp37))
							)
						else
							(= temp0
								(proc709_0 temp15 (param1 minLevel: temp15))
							)
						)
					)
					((or (>= temp19 2) (param1 hasCard: temp10 3851))
						(= temp0 (proc709_0 temp10 (param1 minLevel: temp10)))
					)
					(else
						(= temp0 0)
					)
				)
			)
			(temp23
				(cond
					((>= temp27 33)
						(cond
							(
								(or
									(param1 supports: temp10)
									(param1 supports: temp37)
								)
								(= temp0 761)
								(param1 forcing: 1)
							)
							((= temp1 (proc709_9 param1 temp15 temp10))
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 4 6)
							)
							((>= [temp41 temp15] 6)
								(= temp0
									(proc709_0
										temp15
										(+ (param1 minLevel: temp15) 1)
									)
								)
								(proc709_5 param1 temp15 6 -1)
							)
							(
								(and
									(or
										(<= 3 (= temp1 temp37) 4)
										(== temp1 temp10)
										(and
											(> param2 (+ param3 5))
											(!= (= temp1 temp10) 5)
										)
									)
									(>= [temp41 temp1] 3)
								)
								(= temp0 761)
								(param1 agreedSuit: temp1)
							)
							((proc709_1 param1 temp15)
								(= temp0
									(proc709_0 temp15 (param1 minLevel: temp15))
								)
								(proc709_5 param1 temp15 5 -1)
							)
							(
								(or
									(and
										(= temp1 temp37)
										(or
											(== temp10 4)
											(== temp1 4)
											(param1 hasCard: 4 14)
											(param1 hasCard: 4 13)
										)
										(or
											(== temp10 3)
											(== temp1 3)
											(param1 hasCard: 3 14)
											(param1 hasCard: 3 13)
										)
										(or
											(== temp10 2)
											(== temp1 2)
											(param1 hasCard: 2 14)
											(param1 hasCard: 2 13)
										)
										(or
											(== temp10 1)
											(== temp1 1)
											(param1 hasCard: 1 14)
											(param1 hasCard: 1 13)
										)
									)
									(>= temp26 34)
								)
								(= temp0 761)
							)
							(
								(and
									(for
										((= temp12 1))
										(<= temp12 4)
										((++ temp12))
										
										(if
											(and
												(>= [temp41 temp12] 4)
												(not [temp53 temp12])
											)
											(= temp0
												(proc709_0
													temp12
													(param1 minLevel: temp12)
												)
											)
											(proc709_5 param1 temp12 4 6)
											(break)
										)
									)
									temp0
								))
							((>= temp14 5)
								(= temp0
									(proc709_0 temp15 (param1 minLevel: temp15))
								)
								(proc709_5 param1 temp15 5 -1)
							)
							((>= [temp41 (= temp1 temp37)] 3)
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 3 6)
							)
							((>= temp19 3)
								(= temp0
									(proc709_0 temp10 (param1 minLevel: temp10))
								)
								(proc709_5 param1 temp10 3 6)
							)
							(else
								(= temp0
									(+ (proc709_0 5 (param1 minLevel: 5)) 5)
								)
								(proc709_5 param1 temp10 0 2)
								(proc709_5 param1 temp37 0 2)
								(proc709_5 param1 temp15 4 4)
							)
						)
					)
					(
						(and
							(< temp27 26)
							(or
								(not
									(OneOf
										temp10
										temp15
										(= temp12 temp37)
										5
									)
								)
								temp71
							)
						)
						(cond
							(
								(or
									(and
										(= temp1 temp10)
										(param1 supports: temp10)
									)
									(and
										(= temp1 temp12)
										(param1 supports: temp12)
									)
								)
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 3 6)
							)
							((>= [temp41 temp15] 6)
								(= temp0
									(proc709_0 temp15 (param1 minLevel: temp15))
								)
								(proc709_5 param1 temp15 5 -1)
							)
							(
								(and
									(not (or temp7 temp6))
									[temp59 4]
									[temp59 3]
									[temp59 2]
									[temp59 1]
								)
								(= temp0 (proc709_0 5 (param1 minLevel: 5)))
								(proc709_5 param1 temp15 -1 5)
							)
							((= temp1 (proc709_9 param1 temp15 temp10))
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 4 6)
							)
							((proc709_1 param1 temp15)
								(= temp0
									(proc709_0 temp15 (param1 minLevel: temp15))
								)
								(proc709_5 param1 temp15 5 -1)
							)
							(
								(or
									(>= temp19 (+ 2 [temp41 temp37]))
									(and
										(== temp19 (+ 1 [temp41 temp37]))
										(param1 hasCard: temp10 3852)
										(not (param1 hasCard: temp37 3852))
									)
								)
								(= temp0
									(proc709_0 temp10 (param1 minLevel: temp10))
								)
								(proc709_5 param1 temp10 3 6)
							)
							(else
								(= temp1 temp37)
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 2 6)
							)
						)
					)
					(
						(and
							(< temp2 10)
							(< temp8 24576)
							(not (param1 supports: temp10))
							(not (param1 supports: temp37))
						)
						(= temp0 0)
						(proc709_5 param1 temp15 -1 5 6 9)
					)
					(
						(or
							(param1 supports: (= temp1 temp37))
							(param1 supports: (= temp1 temp10))
							(== (= temp1 temp10) temp15)
						)
						(cond
							((< temp27 26)
								(if (== temp10 temp1)
									(= temp0 0)
								else
									(= temp0
										(proc709_0
											temp1
											(param1 minLevel: temp1)
										)
									)
									(proc709_5 param1 temp1 3 6)
									(param1 agreedSuit: temp1 maxPoints: 12)
								)
							)
							((>= temp1 3)
								(= temp23
									(proc709_0
										temp1
										(+ (param1 minLevel: temp1) 1)
									)
								)
								(= temp24
									(proc709_0
										temp1
										(param1 findGameLevel: temp1)
									)
								)
								(= temp0 (Min temp24 temp23))
								(param1 agreedSuit: temp1)
								(if (!= temp0 temp24)
									(param1 forcing: 2)
								)
								(if (== temp1 3)
									(proc709_4
										param1
										13
										20
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
										13
										20
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
							(
								(<
									(= temp23
										(proc709_0
											temp1
											(+ (param1 minLevel: temp1) 1)
										)
									)
									15
								)
								(= temp0 temp23)
								(proc709_5 param1 temp1 4 6 13 20)
							)
							((and [temp59 4] [temp59 3] [temp59 2] [temp59 1])
								(= temp0 15)
								(proc709_5 param1 temp10 1 4)
							)
							((or temp6 temp7)
								(= temp0
									(proc709_0
										temp1
										(+ (param1 minLevel: temp1) 1)
									)
								)
								(param1 agreedSuit: temp1 minPoints: 15)
								(proc709_5 param1 temp1 4 7 13 20)
							)
							(else
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(param1 agreedSuit: temp1)
								(proc709_5 param1 temp1 4 7 6 20)
							)
						)
					)
					((OneOf temp8 17203 17458 21298)
						(if
							(and
								(>= temp26 26)
								[temp59 4]
								[temp59 3]
								[temp59 2]
								[temp59 1]
							)
							(= temp0 15)
						else
							(= temp0 (proc709_0 5 (param1 minLevel: 5)))
						)
						(proc709_5 param1 temp10 1 4)
					)
					((>= [temp41 temp15] 6)
						(if (> temp27 26)
							(= temp0
								(proc709_0
									temp15
									(+ (param1 minLevel: temp15) 1)
								)
							)
							(proc709_5 param1 temp15 6 11 13 20)
						else
							(= temp0
								(proc709_0 temp15 (param1 minLevel: temp15))
							)
							(proc709_5 param1 temp15 5 8 6 12)
						)
					)
					((= temp1 (proc709_9 param1 temp15 temp10))
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
						(proc709_5 param1 temp1 4 6)
					)
					(
						(and
							(not temp7)
							(or
								(not temp6)
								(== [temp41 temp10] 1)
								(== [temp41 temp37] 1)
							)
							[temp59 4]
							[temp59 3]
							[temp59 2]
							[temp59 1]
						)
						(if (>= temp3 12)
							(= temp0 15)
							(param1 minPoints: 12)
						else
							(= temp0 (proc709_0 5 (param1 minLevel: 5)))
							(param1 maxPoints: 11)
						)
						(proc709_5 param1 temp10 1 4)
					)
					((proc709_1 param1 temp15)
						(if
							(and
								(>= temp2 13)
								(<
									(= temp23
										(proc709_0
											temp15
											(+ (param1 minLevel: temp15) 1)
										)
									)
									15
								)
							)
							(= temp0 temp23)
							(proc709_5 param1 temp15 5 9 13 20)
						else
							(= temp0
								(proc709_0 temp15 (param1 minLevel: temp15))
							)
							(proc709_5 param1 temp15 5 9 6 20)
						)
					)
					(
						(or
							(>= [temp41 (= temp1 temp37)] 3)
							(>= [temp41 (= temp1 temp10)] 3)
						)
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
						(proc709_5 param1 temp1 2 6)
					)
					((!= (= temp1 temp37) temp10)
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
						(proc709_5 param1 temp1 2 6)
					)
					(else
						(= temp0 (proc709_0 temp15 (param1 minLevel: temp15)))
						(proc709_5 param1 temp15 5 -1)
					)
				)
			)
			(
				(and
					(not (= temp23 0))
					(== (BidBox openingBidder:) param1)
					(== (param1 bidsOpen:) 2)
					(<= 1 (BidBox openingBidValue:) 4)
					(== (= temp23 ((proc709_6 2) bidNumber:)) 5)
				)
				(cond
					(
						(and
							(not (OneOf temp15 temp10 temp77 5))
							(!= temp10 temp77)
							(proc709_1 param1 temp15)
						)
						(= temp0 (proc709_0 temp15 (param1 minLevel: temp15)))
					)
					(
						(and
							(!= temp10 temp15)
							(!= temp10 temp77)
							(!= temp77 temp15)
							(or
								(>= (= temp20 [temp41 temp77]) 7)
								(and
									(== temp20 6)
									(>= (param1 calcHonors: temp77 5) 4)
								)
							)
						)
						(= temp0 (proc709_0 temp77 (param1 minLevel: temp77)))
					)
					(
						(and
							(>= temp3 17)
							(== temp10 5)
							(<
								param2
								(= temp23 (proc709_0 (param1 findGameLevel: 5)))
							)
						)
						(= temp0 temp23)
						(param1 minPoints: 17)
					)
					(else
						(= temp0 0)
					)
				)
			)
			((== temp23 10)
				(cond
					(
						(and
							(>= temp2 20)
							(or (== temp10 temp77) (== temp10 temp15))
						)
						(= temp0 (proc709_0 temp10 6))
					)
					((and (== param2 15) (>= (& temp8 $0f00) 1536))
						(= temp0 (proc709_0 temp15 (param1 minLevel: temp15)))
					)
					((and (== temp15 temp77) (== temp10 temp15))
						(if
							(<
								param2
								(= temp23
									(proc709_0
										temp15
										(param1 findGameLevel: temp15)
									)
								)
							)
							(= temp0 temp23)
						)
					)
					((or (== temp10 temp77) (== temp10 temp15))
						(if
							(<
								param2
								(= temp23
									(proc709_0
										temp10
										(param1 findGameLevel: temp10)
									)
								)
							)
							(= temp0 temp23)
						)
					)
					(
						(and
							(!= temp15 temp77)
							(or
								(proc709_1 param1 (= temp1 temp15))
								(proc709_1 param1 (= temp1 temp77))
							)
						)
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
						(proc709_5 param1 temp1 5 -1)
					)
					((= temp1 (proc709_9 param1 temp15 temp77))
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
						(proc709_5 param1 temp1 4 4)
					)
					(else
						(= temp0 (proc709_0 5 (param1 minLevel: 5)))
					)
				)
			)
			(temp23
				(cond
					(
						(or
							(= temp1 temp30)
							(>= (+ [temp41 (= temp1 temp9)] [temp64 temp9]) 8)
						)
						(param1 agreedSuit: temp1)
						(cond
							((>= temp27 33)
								(= temp0 761)
							)
							(
								(or
									(< temp27 26)
									(and
										(== temp1 temp10)
										(>= param2 (localproc_0 param1 temp10))
									)
								)
								(if (>= (param1 combinedCards:) 7)
									(= temp0 0)
								else
									(= temp0
										(proc709_0
											temp1
											(param1 minLevel: temp1)
										)
									)
								)
							)
							((>= temp1 3)
								(= temp20
									(Max
										(param1 findGameLevel: temp1)
										(param1 minLevel: temp1)
									)
								)
								(if
									(or
										(!= temp10 temp1)
										(not
											(>=
												temp11
												(param1 findGameLevel: temp10)
											)
										)
									)
									(= temp0 (proc709_0 temp1 temp20))
								)
							)
							((and [temp59 4] [temp59 3] [temp59 2] [temp59 1])
								(= temp0 15)
							)
							((>= temp27 29)
								(= temp20
									(Max
										(param1 findGameLevel: temp1)
										(param1 minLevel: temp1)
									)
								)
								(if
									(or
										(!= temp10 temp1)
										(not
											(>=
												temp11
												(param1 findGameLevel: temp10)
											)
										)
									)
									(= temp0 (proc709_0 temp1 temp20))
								)
							)
							(else
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
							)
						)
						(if (<= temp0 param2)
							(= temp0 0)
						)
					)
					(
						(and
							(== temp10 5)
							(or temp6 temp7)
							(or
								(>= [temp41 (= temp1 temp37)] 4)
								(and
									(>= (& temp8 $0fff) 1280)
									(= temp1 (param1 longSuit: 2))
								)
							)
						)
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
					)
					(
						(and
							(or
								(and (== temp11 3) (< temp27 26))
								(and (== temp11 4) (< temp27 29))
							)
							(not temp71)
							(>= (param1 combinedCards:) 7)
						)
						(= temp0 0)
					)
					((and [temp59 4] [temp59 3] [temp59 2] [temp59 1])
						(if (> temp26 26)
							(= temp0 15)
						else
							(= temp0 (proc709_0 5 (param1 minLevel: 5)))
						)
					)
					((>= temp2 (+ 17 (* temp11 3)))
						(cond
							(
								(and
									(!= temp74 temp15)
									(<= 1 temp74 4)
									(<= 1 temp15 4)
									(proc709_1 param1 temp74)
									(proc709_1 param1 temp15)
								)
								(= temp0
									(proc709_0 temp15 (param1 minLevel: temp15))
								)
							)
							(
								(or
									(proc709_1 param1 (= temp1 temp74))
									(proc709_1 param1 (= temp1 temp15))
								)
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 5 9)
							)
							((= temp1 (proc709_9 param1 temp15 temp74))
								(= temp0
									(proc709_0 temp1 (param1 minLevel: temp1))
								)
								(proc709_5 param1 temp1 5 9)
							)
							(
								(and
									[temp59 4]
									[temp59 3]
									[temp59 2]
									[temp59 1]
									(not temp7)
									(or
										(not temp6)
										(and (== temp6 1) (== temp19 1))
									)
								)
								(= temp0 (proc709_0 5 (param1 minLevel: 5)))
								(proc709_5 param1 temp10 1 3)
							)
							(
								(and
									(for ((= temp1 4)) (>= temp1 1) ((-- temp1))
										(if
											(and
												[temp53 (= temp1 4)]
												(>= [temp41 4] 3)
												(!= temp1 temp74)
												(!= temp1 temp15)
											)
											(= temp0
												(proc709_0
													temp1
													(param1 minLevel: temp1)
												)
											)
											(break)
										)
									)
									temp0
								)
								(proc709_5 param1 temp1 3 6)
							)
							(
								(and
									(>= (param1 calcTricks: temp15) 11)
									(== temp15 temp74)
								)
								(= temp0
									(proc709_0 temp15 (param1 minLevel: temp15))
								)
								(proc709_5 param1 temp15 7 11)
							)
							((>= (+ 2 temp19) [temp41 temp37])
								(= temp0
									(proc709_0 temp10 (param1 minLevel: temp10))
								)
							)
							(else
								(= temp0
									(proc709_0 temp37 (param1 minLevel: temp37))
								)
							)
						)
					)
					(else
						(= temp76
							(+ [temp41 (= temp75 temp10)] [temp64 temp75])
						)
						(for ((= temp1 1)) (<= temp1 4) ((++ temp1))
							(= temp13 (+ [temp41 temp1] [temp64 temp1]))
							(if (> (= temp20 (param1 minLevel: temp1)) temp11)
								(-- temp13)
							)
							(if (> temp13 temp76)
								(= temp76 temp13)
								(= temp75 temp1)
							)
						)
						(if (!= temp75 temp10)
							(= temp0
								(proc709_0 temp75 (param1 minLevel: temp75))
							)
						else
							(= temp0 0)
						)
					)
				)
			)
			((and (== (BidBox openingBidder:) temp38) (== (param1 bidsOpen:) 2))
				(= temp33 (+ [temp41 4] [temp64 4]))
				(= temp32 (+ [temp41 3] [temp64 3]))
				(= temp34 (+ [temp41 2] [temp64 2]))
				(= temp35 (+ [temp41 1] [temp64 1]))
				(= temp75 4)
				(= temp76 temp33)
				(if (> temp32 temp76)
					(= temp75 3)
					(= temp76 temp32)
				)
				(if (> temp34 temp76)
					(= temp75 2)
					(= temp76 temp34)
				)
				(if (> temp35 temp76)
					(= temp75 1)
					(= temp76 temp35)
				)
				(cond
					(
						(and
							(not temp71)
							(< temp27 33)
							(or
								(== temp10 5)
								(>= (+ [temp41 temp10] [temp64 temp10]) 8)
							)
							(< temp11 (= temp20 (param1 findGameLevel: temp10)))
						)
						(if
							(or
								(>= temp27 29)
								(and (>= temp26 26) (== temp10 5))
								(and (>= temp27 26) (<= 3 temp10 4))
							)
							(= temp0 (proc709_0 temp10 temp20))
						else
							(= temp0 0)
						)
					)
					(
						(and
							(<= 3 temp10 4)
							(>= temp2 9)
							(>= [temp41 temp10] 3)
							(== (= temp23 ((proc709_6 2) bidNumber:)) 5)
							(< temp11 (= temp20 (param1 findGameLevel: temp10)))
						)
						(= temp0 (proc709_0 temp10 temp20))
						(param1 minPoints: 9)
					)
					((>= temp76 9)
						(cond
							((>= temp27 33)
								(= temp0 761)
							)
							((>= temp27 26)
								(cond
									((>= temp75 3)
										(= temp20
											(param1 findGameLevel: temp75)
										)
										(= temp0 (proc709_0 temp75 temp20))
									)
									(
										(and
											[temp59 4]
											[temp59 3]
											[temp59 2]
											[temp59 1]
										)
										(= temp0 15)
										(= temp75 5)
									)
									((>= temp27 29)
										(= temp20
											(param1 findGameLevel: temp75)
										)
										(= temp0 (proc709_0 temp75 temp20))
									)
									(else
										(= temp0 (proc709_0 temp75 4))
									)
								)
								(if (!= temp75 5)
									(param1 agreedSuit: temp75)
									(proc709_5 param1 temp75 9 13)
								)
								(if (not (param1 canBid: temp0))
									(if (== temp75 temp10)
										(= temp0 0)
									else
										(= temp0
											(proc709_0
												temp75
												(param1 minLevel: temp75)
											)
										)
									)
								)
							)
							(
								(and
									(not temp71)
									(or
										(== temp10 temp75)
										(and (== temp10 5) (<= temp75 2))
									)
								)
								(= temp0 0)
							)
							(else
								(= temp0
									(proc709_0 temp75 (param1 minLevel: temp75))
								)
								(if (!= temp75 5)
									(param1 agreedSuit: temp75)
									(proc709_5 param1 temp75 9 13)
								)
							)
						)
					)
					((>= temp2 33)
						(cond
							((>= temp76 8)
								(= temp0 761)
							)
							((and [temp59 4] [temp59 3] [temp59 2] [temp59 1])
								(= temp0 761)
							)
							(else
								(switch global195
									(0
										(if
											(>=
												temp11
												(param1 findGameLevel: temp10)
											)
											(= temp0 0)
										else
											(= temp0 15)
										)
									)
									(1
										(= temp20 ((proc709_6 4) suit:))
										(cond
											(
												(and
													(or
														(OneOf
															4
															temp37
															temp10
															temp20
														)
														(param1 hasCard: 4 3853)
													)
													(or
														(OneOf
															3
															temp37
															temp10
															temp20
														)
														(param1 hasCard: 3 3853)
													)
													(or
														(OneOf
															2
															temp37
															temp10
															temp20
														)
														(param1 hasCard: 2 3853)
													)
													(or
														(OneOf
															1
															temp37
															temp10
															temp20
														)
														(param1 hasCard: 1 3853)
													)
												)
												(= temp0 761)
											)
											(
												(>=
													temp11
													(param1
														findGameLevel: temp10
													)
												)
												(= temp0 0)
											)
											(else
												(= temp0 15)
											)
										)
									)
									(2
										(cond
											(
												(and
													(or
														(param1 hasCard: 4 3853)
														(temp38 hasCard: 4 3853)
													)
													(or
														(param1 hasCard: 3 3853)
														(temp38 hasCard: 3 3853)
													)
													(or
														(param1 hasCard: 2 3853)
														(temp38 hasCard: 2 3853)
													)
													(or
														(param1 hasCard: 1 3853)
														(temp38 hasCard: 1 3853)
													)
												)
												(= temp0 761)
											)
											((>= temp75 3)
												(= temp0
													(proc709_0
														temp75
														(param1
															findGameLevel:
																temp75
														)
													)
												)
											)
											(else
												(= temp0 15)
											)
										)
									)
								)
							)
						)
					)
					((or (>= temp27 26) temp71 (< (param1 combinedCards:) 7))
						(cond
							(
								(and
									(or
										(and (>= temp33 8) (= temp1 4))
										(and (>= temp32 8) (= temp1 3))
										(and (>= temp34 8) (= temp1 2))
										(and (>= temp35 8) (= temp1 1))
									)
									(param1
										canBid:
											(= temp23
												(if
													(or
														(>= temp27 29)
														(and
															(>= temp27 26)
															(>= temp1 3)
														)
													)
													(localproc_0 param1 temp1)
												else
													(proc709_0 temp1 temp11)
												)
											)
									)
								)
								(= temp0 temp23)
								(param1 agreedSuit: temp1)
							)
							((and [temp59 4] [temp59 3] [temp59 2] [temp59 1])
								(if (>= temp27 26)
									(= temp0 15)
								else
									(= temp0 (proc709_0 5 (param1 minLevel: 5)))
								)
							)
							(
								(and
									(or
										(and (>= temp33 7) (= temp1 4))
										(and (>= temp32 7) (= temp1 3))
										(and (>= temp34 7) (= temp1 2))
										(and (>= temp35 7) (= temp1 1))
									)
									(param1
										canBid:
											(= temp23 (proc709_0 temp1 temp11))
									)
								)
								(= temp0 temp23)
								(param1 agreedSuit: temp1)
							)
							(else
								(= temp0 (proc709_0 temp75 (+ temp11 1)))
								(param1 agreedSuit: temp75)
							)
						)
					)
					(
						(and
							(== global195 2)
							(<= (param1 combinedCards:) 7)
							(>= temp76 9)
						)
						(= temp0 (proc709_0 temp75 (param1 minLevel: temp75)))
						(param1 agreedSuit: temp75)
						(proc709_5 param1 temp75 9 13)
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

