;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 715)
(include sci.sh)
(use Main)
(use n709)
(use Bid)
(use System)

(public
	c2_tree 0
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2)
	(if
		(or
			(< param1 2)
			(< (BidBox bidsSinceOpen:) param1)
			(not (IsObject (= temp0 (proc709_6 param1))))
			(not (IsObject (= temp1 (proc709_6 (- param1 2)))))
		)
		(return 0)
	else
		(= temp2
			(switch (= temp0 (temp0 bidNumber:))
				(11 12)
				(12 15)
				(else 11)
			)
		)
		(return (== (temp1 bidNumber:) temp2))
	)
)

(instance c2_tree of Code
	(properties)

	(method (doit param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 [temp14 2] [temp16 5] [temp21 5] temp26 temp27 temp28 temp29 temp30 temp31 temp32 temp33 temp34 temp35 temp36 [temp37 5] temp42 temp43 temp44 temp45 temp46 temp47 temp48 temp49 temp50 temp51 temp52 [temp53 6] [temp59 6] [temp65 6] temp71 temp72 temp73 temp74 [temp75 6])
		(= temp49 (param1 partner:))
		(= temp3 (param1 points:))
		(= temp4 (param1 hcp:))
		(= temp5 (param1 playingTricks:))
		(= temp6 (param1 quickTricks:))
		(= temp7 (param1 singletons:))
		(= temp8 (param1 voids:))
		(= temp9 (param1 shape:))
		(= temp10 (param1 longSuit:))
		(= temp35 (param1 combinedHCP:))
		(= temp36 (param1 combinedPts:))
		(= temp42 (param1 agreedSuit:))
		(= temp71 (temp49 forcing:))
		(= [temp16 2] (param1 diamonds:))
		(= [temp16 1] (param1 clubs:))
		(= [temp16 3] (param1 hearts:))
		(= [temp16 4] (param1 spades:))
		(= [temp59 1] (param1 partnerClubs:))
		(= [temp59 2] (param1 partnerDiamonds:))
		(= [temp59 3] (param1 partnerHearts:))
		(= [temp59 4] (param1 partnerSpades:))
		(for ((= temp13 0)) (< temp13 6) ((++ temp13))
			(= [temp65 temp13] (= [temp75 temp13] 0))
		)
		(= temp27 (+ 1 (mod (- param3 1) 5)))
		(= temp28 (+ (/ (- param3 1) 5) 1))
		(= temp11 (+ 1 (mod (- param2 1) 5)))
		(= temp12 (+ (/ (- param2 1) 5) 1))
		(= temp51 (param1 location:))
		(= temp52 (temp49 location:))
		(= temp43 (= temp44 (= temp50 (= temp45 (= temp46 0)))))
		(= temp13 0)
		(= temp31 (BidBox size:))
		(while (< temp13 temp31)
			(= temp1 (BidBox at: temp13))
			(if
				(and
					(not (temp1 artificial:))
					(not (OneOf (temp1 bidNumber:) 0 50 99))
					(<= 1 (= temp2 (temp1 suit:)) 5)
				)
				(++ [temp65 temp2])
				(if (OneOf (= temp32 (temp1 location:)) temp51 temp52)
					(++ [temp75 temp2])
					(if (== temp32 temp51)
						(= temp27 temp2)
						(cond
							((not temp50)
								(= temp50 temp2)
							)
							((not temp45)
								(= temp45 temp2)
							)
						)
						(if (!= temp2 5)
							(= temp46 temp2)
						)
					else
						(= temp11 temp2)
						(cond
							((not temp43)
								(= temp43 temp2)
							)
							((not temp44)
								(= temp44 temp2)
							)
						)
					)
				)
			)
			(++ temp13)
		)
		(for ((= temp13 1)) (<= temp13 4) ((++ temp13))
			(if (not (= [temp53 temp13] (param1 stops: temp13 1)))
				(= [temp53 temp13] [temp75 temp13])
			)
		)
		(= temp74 (= temp73 0))
		(for ((= temp2 1)) (<= temp2 4) ((++ temp2))
			(if (>= (= [temp21 temp2] (+ [temp16 temp2] [temp59 temp2])) temp73)
				(= temp73 [temp21 temp2])
				(= temp74 temp2)
			)
		)
		(= temp30 ((param1 partner:) bidBranch:))
		(= temp29 (== (BidBox openingBidder:) (param1 partner:)))
		(= temp48 (+ 1 (mod (- global427 1) 5)))
		(= temp47 (+ (/ (- global427 1) 5) 1))
		(= temp26 [temp16 temp11])
		(= temp0 0)
		(cond
			((and (not temp29) (== param2 7))
				(param1 forcing: 1)
				(cond
					(
						(and
							(or (>= temp4 37) (>= temp5 26))
							(== (param1 aces:) 4)
						)
						(= temp0 35)
						(proc709_4 param1 22 40 1 10 1 10 1 10 1 10)
						(param1 forcing: 0)
					)
					((and (>= temp5 26) (u>= temp9 24576) temp8)
						(if (== (& temp9 $ff00) 26112)
							(= temp0
								(proc709_0 (= temp31 (param1 strongSuit:)) 7)
							)
							(proc709_4 param1 22 37 0 6 0 6 0 6 0 6)
							(proc709_5 param1 temp31 6 13)
						else
							(= temp0 (proc709_0 temp10 7))
							(proc709_4 param1 22 37 0 6 0 6 0 6 0 6)
							(proc709_5 param1 temp10 6 13)
						)
						(param1 forcing: 0)
					)
					((OneOf temp9 17473 21568 21808 21793)
						(= temp31 (>> temp9 $000c))
						(= temp2 (param1 cheapSuit:))
						(while (!= temp2 temp48)
							(if (== [temp16 temp2] temp31)
								(break)
							)
							(if (> (++ temp2) 4)
								(= temp2 1)
							)
						)
						(= temp0 (proc709_0 temp2 (param1 minLevel: temp2)))
					)
					((and (>= temp5 22) (>= (param1 aces:) 2) (not temp8))
						(= temp0 761)
					)
					(
						(and
							(u> temp9 24576)
							(or (>= temp5 22) (and (>= temp5 20) (>= temp10 3)))
						)
						(= temp0
							(proc709_0 temp10 (+ (param1 minLevel: temp10) 1))
						)
						(proc709_5 param1 temp10 7 11)
					)
					(
						(and
							(>= temp4 25)
							(not temp7)
							(not temp8)
							[temp53 4]
							[temp53 3]
							[temp53 2]
							[temp53 1]
						)
						(= temp0 15)
						(proc709_4 param1 25 27 2 5 2 5 2 5 2 5)
						(param1 forcing: 0)
					)
					(
						(and
							(<= 22 temp4 24)
							(not temp7)
							(not temp8)
							[temp53 4]
							[temp53 3]
							[temp53 2]
							[temp53 1]
						)
						(= temp0 10)
						(proc709_4 param1 22 24 2 5 2 5 2 5 2 5)
						(param1 forcing: 0)
					)
					(else
						(= temp31 (>> temp9 $000c))
						(= temp2 (param1 cheapSuit:))
						(while (!= temp2 temp48)
							(if (== [temp16 temp2] temp31)
								(break)
							)
							(if (> (++ temp2) 4)
								(= temp2 1)
							)
						)
						(= temp0 (proc709_0 temp2 (param1 minLevel: temp2)))
						(proc709_5 param1 temp2 5 10)
					)
				)
			)
			((and temp29 (== (param1 bidsOpen:) 1))
				(= temp31 (if (== global427 15) 8 else 4))
				(= temp72
					(cond
						((== global427 11) 12)
						((>= global427 12) 15)
						(else 11)
					)
				)
				(cond
					((or (== global427 10) (== global427 15))
						(cond
							((< temp3 temp31)
								(= temp0 0)
							)
							((and (u> temp9 20480) (!= temp10 1))
								(= temp0
									(proc709_0 temp10 (param1 minLevel: temp10))
								)
								(proc709_5 param1 temp10 5 10 temp31 -1)
								(param1 forcing: 2)
							)
							(
								(and
									(== global427 10)
									(<= (& temp9 $000f) 2)
									(or (== [temp16 3] 4) (== [temp16 4] 4))
								)
								(= temp0 721)
								(param1 minPoints: temp31)
							)
							(else
								(= temp0 (proc709_0 5 (param1 minLevel: 5)))
								(proc709_4 param1 temp31 10 1 4 1 4 1 4 1 4)
							)
						)
					)
					(
						(and
							(>= temp3 5)
							(or (>= temp3 10) (localproc_0 2))
							(>= temp26 4)
						)
						(= temp0 (proc709_0 temp11 (+ temp12 2)))
						(proc709_4 param1 5 8 0 6 0 6 0 6 0 6)
						(proc709_5 param1 temp11 4 7)
						(param1 agreedSuit: temp11)
						(temp49 agreedSuit: temp11)
					)
					((and (>= temp3 4) (>= temp26 3))
						(= temp0 (proc709_0 temp11 (+ temp12 1)))
						(proc709_4 param1 4 8 0 6 0 6 0 6 0 6)
						(proc709_5 param1 temp11 3 7)
						(param1 agreedSuit: temp11)
						(temp49 agreedSuit: temp11)
					)
					((and (u>= temp9 20480) (>= temp4 4))
						(if
							(==
								(= temp0
									(proc709_0 temp10 (param1 minLevel: temp10))
								)
								temp72
							)
							(+= temp0 5)
						)
						(proc709_4 param1 4 8 0 6 0 6 0 6 0 6)
						(proc709_5 param1 temp10 5 10)
					)
					((>= temp4 8)
						(= temp0 (proc709_0 5 (param1 minLevel: 5)))
						(proc709_4 param1 8 11 2 4 2 4 2 4 2 4)
						(proc709_5 param1 temp11 0 2)
					)
					((>= temp4 4)
						(= temp2 (param1 cheapSuit:))
						(= temp32 0)
						(repeat
							(if
								(and
									(== [temp16 temp2] 4)
									(or
										(!=
											(= temp0
												(proc709_0
													temp2
													(param1 minLevel: temp2)
												)
											)
											temp72
										)
										(and (== temp0 temp32) (+= temp0 5))
									)
								)
								(break)
							)
							(= temp32 temp0)
							(if (> (++ temp2) 4)
								(= temp2 1)
							)
						)
					)
					(else
						(= temp0 temp72)
						(if (not (param1 canBid: temp0))
							(= temp0 15)
						)
						(proc709_4 param1 0 3 -1 -1 -1 -1 -1 -1 -1 -1)
					)
				)
			)
			(
				(and
					(not temp29)
					(== (param1 bidsOpen:) 2)
					(== ((proc709_6 2) bidNumber:) 7)
				)
				(= temp2 0)
				(cond
					((and temp42 (>= (+ temp3 (temp49 points:)) 33))
						(if (>= temp36 33)
							(= temp0 (proc709_0 temp42 6))
						else
							(= temp0 761)
						)
					)
					(
						(and
							(= temp31
								(if (and [temp53 4] [temp53 3] [temp53 2])
									[temp53 1]
								)
							)
							(>= temp36 33)
						)
						(= temp0 761)
					)
					(
						(and
							(or [temp75 (= temp2 4)] (< [temp16 4] 5))
							(or [temp75 (= temp2 3)] (< [temp16 3] 5))
							(or [temp75 (= temp2 2)] (< [temp16 2] 5))
							(or [temp75 (= temp2 1)] (< [temp16 1] 5))
							(not (= temp2 0))
							temp31
							(param1 canBid: 15)
						)
						(= temp0 15)
					)
					((and (not temp31) (param1 supports: temp11))
						(if (>= temp36 33)
							(= temp0 761)
						else
							(= temp0
								(proc709_0
									temp11
									(param1 findGameLevel: temp11)
								)
							)
						)
					)
					((and (u> temp9 24576) (not temp2))
						(= temp0 (proc709_0 temp27 (param1 minLevel: temp27)))
						(proc709_5 param1 temp27 5 9)
					)
					(temp2
						(= temp0 (proc709_0 temp2 (param1 minLevel: temp2)))
						(proc709_5 param1 temp2 3 6)
					)
					(
						(or
							(>= temp26 3)
							(and (>= temp26 2) (param1 hasCard: temp11 3851))
						)
						(= temp0 (proc709_0 temp11 (param1 minLevel: temp11)))
					)
					(
						(or
							(and
								(not [temp75 (= temp2 4)])
								(proc709_3 param1 4)
							)
							(and
								(not [temp75 (= temp2 3)])
								(proc709_3 param1 3)
							)
							(and
								(not [temp75 (= temp2 2)])
								(proc709_3 param1 2)
							)
							(and
								(not [temp75 (= temp2 1)])
								(proc709_3 param1 1)
							)
						)
						(= temp0 (proc709_0 temp2 (param1 minLevel: temp2)))
						(proc709_5 param1 temp2 5 9)
					)
					((proc709_1 param1 temp27)
						(= temp0 (proc709_0 temp27 (param1 minLevel: temp27)))
					)
					(
						(or
							(and (not [temp75 4]) (>= [temp16 (= temp2 4)] 4))
							(and (not [temp75 3]) (>= [temp16 (= temp2 3)] 4))
							(and (not [temp75 2]) (>= [temp16 (= temp2 2)] 4))
							(and (not [temp75 1]) (>= [temp16 (= temp2 1)] 4))
						)
						(= temp0 (proc709_0 temp2 (param1 minLevel: temp2)))
					)
					(else
						(= temp0 (proc709_0 temp11 (param1 minLevel: temp11)))
					)
				)
			)
			(
				(and
					(not temp29)
					(== (param1 bidsOpen:) 1)
					(or (== param2 10) (== param2 15))
				)
				(cond
					((and (+ temp7 temp8) (u> temp9 20480))
						(= temp0 (proc709_0 temp10 (param1 minLevel: temp10)))
						(param1 forcing: 1)
					)
					((>= (= temp31 (+ temp4 (temp49 hcp:))) 37)
						(= temp0 35)
					)
					((>= temp31 33)
						(= temp0 30)
					)
					((u> temp9 20480)
						(= temp0 (proc709_0 temp10 (param1 minLevel: temp10)))
						(param1 forcing: 1)
					)
					((== global427 10)
						(= temp0 15)
					)
					(else
						(= temp0 0)
					)
				)
			)
			(
				(and
					temp29
					(== (param1 bidsOpen:) 2)
					(localproc_0 2)
					(localproc_0 6)
				)
				(cond
					((or (== temp11 5) (== temp11 temp43))
						(= temp0 0)
					)
					(
						(and
							(= temp31
								(<=
									((proc709_6 8) bidNumber:)
									(+ ((proc709_6 6) bidNumber:) 5)
								)
							)
							(> temp26 [temp16 temp43])
						)
						(= temp0 0)
					)
					((>= [temp16 temp43] temp26)
						(= temp0 (proc709_0 temp43 (param1 minLevel: temp43)))
					)
					(
						(or
							(not temp31)
							(>= temp47 (param1 findGameLevel: temp48))
						)
						(= temp0 0)
					)
					(
						(or
							(>= [temp16 temp10] 5)
							(and (== temp11 temp43) (not temp26))
							(and (<= [temp16 temp43] 1) (<= temp26 1))
						)
						(= temp0 (proc709_0 temp10 (param1 minLevel: temp10)))
					)
					((and temp31 (== temp11 temp43))
						(if (>= temp26 (+ [temp16 temp43] 2))
							(= temp0
								(proc709_0
									temp11
									(param1 findGameLevel: temp11)
								)
							)
						else
							(= temp0
								(proc709_0
									temp43
									(param1 findGameLevel: temp43)
								)
							)
						)
					)
					((> temp26 [temp16 temp43])
						(= temp0
							(proc709_0 temp11 (param1 findGameLevel: temp11))
						)
					)
					(else
						(= temp0
							(proc709_0 temp43 (param1 findGameLevel: temp43))
						)
					)
				)
			)
			(
				(and
					temp29
					(== (param1 bidsOpen:) 2)
					(== ((proc709_6 2) bidNumber:) 7)
				)
				(cond
					((>= temp47 (param1 findGameLevel: temp48))
						(cond
							((OneOf temp11 temp27 temp43 5)
								(= temp0 0)
							)
							(
								(and
									(<= temp26 1)
									(u> temp9 24576)
									(or
										(u> temp9 28672)
										(>= (param1 calcHCP: temp10) 3)
									)
								)
								(= temp0
									(proc709_0 temp10 (param1 minLevel: temp10))
								)
								(proc709_5 param1 temp10 6 -1)
							)
							(
								(and
									(<= temp26 2)
									(<= [temp16 temp43] 1)
									(= temp2 (proc709_9 param1 temp27 temp11))
								)
								(= temp0
									(proc709_0 temp2 (param1 minLevel: temp2))
								)
								(proc709_5 param1 temp2 4 6)
							)
							((>= [temp16 temp43] temp26)
								(= temp0
									(proc709_0 temp43 (param1 minLevel: temp43))
								)
							)
							(else
								(= temp0 0)
							)
						)
					)
					(
						(and
							(== temp11 temp27)
							(>= (+ temp3 22) (if (< temp27 3) 29 else 26))
						)
						(= temp0 (proc709_0 temp27 (param1 minLevel: temp27)))
					)
					(
						(and
							(== temp11 temp27)
							(>= [temp16 temp43] 3)
							(<= 5 [temp16 temp27] 6)
							(<= (param1 calcHCP: temp27) 3)
						)
						(= temp0 (proc709_0 temp43 (param1 minLevel: temp43)))
					)
					((== temp27 temp11)
						(= temp0 0)
					)
					(
						(or
							(>= [temp16 temp27] 7)
							(and
								(== [temp16 temp27] 6)
								(>= (param1 calcHCP: temp27) 3)
							)
						)
						(= temp0 (proc709_0 temp27 (param1 minLevel: temp27)))
					)
					(
						(or
							(and (>= [temp16 temp43] 3) (= temp2 temp43))
							(and (>= temp26 3) (= temp2 temp11))
						)
						(= temp0 (proc709_0 temp2 (param1 minLevel: temp2)))
					)
					((> temp26 [temp16 temp43])
						(if (>= (+ temp3 22) (if (< temp11 3) 29 else 26))
							(= temp0
								(proc709_0
									temp11
									(param1 findGameLevel: temp11)
								)
							)
						else
							(= temp0 0)
						)
					)
					((< (+ temp3 22) (if (< temp11 3) 29 else 26))
						(if
							(and
								(<= [temp16 temp43] 1)
								(or
									(and
										(>= [temp16 4] 5)
										(not [temp75 (= temp2 4)])
									)
									(and
										(>= [temp16 3] 5)
										(not [temp75 (= temp2 3)])
									)
									(and
										(>= [temp16 2] 5)
										(not [temp75 (= temp2 2)])
									)
									(and
										(>= [temp16 1] 5)
										(not [temp75 (= temp2 1)])
									)
								)
							)
							(= temp0 (proc709_0 temp2 (param1 minLevel: temp2)))
						else
							(= temp0
								(proc709_0 temp43 (param1 minLevel: temp43))
							)
						)
					)
					((and [temp53 4] [temp53 3] [temp53 2] [temp53 1])
						(= temp0 (proc709_0 5 (param1 minLevel: 5)))
					)
					(
						(or
							(and (>= [temp16 3] 5) (not [temp75 (= temp2 3)]))
							(and (>= [temp16 4] 5) (not [temp75 (= temp2 4)]))
							(and (>= [temp16 2] 5) (not [temp75 (= temp2 2)]))
							(and (>= [temp16 1] 5) (not [temp75 (= temp2 1)]))
						)
						(= temp0 (proc709_0 temp2 (param1 minLevel: temp2)))
					)
					(else
						(= temp0
							(proc709_0 temp43 (param1 findGameLevel: temp43))
						)
					)
				)
			)
			(
				(and
					temp29
					(== (param1 bidsOpen:) 2)
					(!= ((proc709_6 2) bidNumber:) 7)
				)
				(cond
					((< temp12 (param1 findGameLevel: temp11))
						(cond
							((or (== temp11 temp27) (== temp11 temp50))
								(= temp0
									(proc709_0
										temp11
										(param1 findGameLevel: temp11)
									)
								)
							)
							(
								(or
									(>= [temp16 temp27] 7)
									(and
										(== [temp16 temp27] 6)
										(>= (param1 calcHCP: temp27) 3)
									)
								)
								(= temp0
									(proc709_0 temp27 (param1 minLevel: temp27))
								)
							)
							(
								(or
									(>= [temp16 (= temp2 temp43)] 3)
									(and (>= temp26 3) (= temp2 temp11))
								)
								(= temp0
									(proc709_0 temp2 (param1 minLevel: temp2))
								)
							)
							((and [temp53 4] [temp53 3] [temp53 2] [temp53 1])
								(= temp0 15)
							)
							(
								(or
									(and
										(not [temp75 (= temp2 4)])
										(proc709_3 param1 4)
									)
									(and
										(not [temp75 (= temp2 3)])
										(proc709_3 param1 3)
									)
									(and
										(not [temp75 (= temp2 2)])
										(proc709_3 param1 2)
									)
									(and
										(not [temp75 (= temp2 1)])
										(proc709_3 param1 1)
									)
								)
								(= temp0
									(proc709_0 temp2 (param1 minLevel: temp2))
								)
							)
							((== param2 10)
								(= temp0 15)
							)
							(
								(and
									(>= [temp16 temp43] 2)
									(param1 hasCard: temp43 11)
								)
								(= temp0
									(proc709_0 temp43 (param1 minLevel: temp43))
								)
							)
							(
								(or
									(and
										(== [temp75 (= temp2 4)] 1)
										(>= [temp16 4] 5)
										(or
											(>= [temp16 4] 6)
											(>= (param1 calcHCP: 4) 3)
										)
									)
									(and
										(== [temp75 (= temp2 3)] 1)
										(>= [temp16 3] 5)
										(or
											(>= [temp16 3] 6)
											(>= (param1 calcHCP: 3) 3)
										)
									)
									(and
										(== [temp75 (= temp2 2)] 1)
										(>= [temp16 2] 5)
										(or
											(>= [temp16 2] 6)
											(>= (param1 calcHCP: 2) 3)
										)
									)
									(and
										(== [temp75 (= temp2 1)] 1)
										(>= [temp16 1] 5)
										(or
											(>= [temp16 1] 6)
											(>= (param1 calcHCP: 1) 3)
										)
									)
								)
								(= temp0
									(proc709_0 temp2 (param1 minLevel: temp2))
								)
							)
							(
								(and
									(or
										(and
											(>
												(-
													((proc709_6 4) bidNumber:)
													((proc709_6 2) bidNumber:)
												)
												5
											)
											(>= [temp16 temp43] 2)
										)
										(>
											(-
												((proc709_6 8) bidNumber:)
												((proc709_6 6) bidNumber:)
											)
											5
										)
									)
									(or
										(>= [temp16 (= temp2 temp43)] 2)
										(>= [temp16 (= temp2 temp11)] 2)
									)
								)
								(param1 agreedSuit: temp2)
								(if (>= (param1 calcPoints:) 9)
									(= temp0 (proc709_0 temp2 6))
								else
									(= temp0
										(proc709_0
											temp2
											(param1 findGameLevel: temp2)
										)
									)
								)
							)
							((> temp26 [temp16 temp43])
								(= temp0 (proc709_0 temp11 (+ temp12 1)))
							)
							(else
								(= temp0
									(proc709_0 temp43 (param1 minLevel: temp43))
								)
							)
						)
					)
					((>= temp12 6)
						(= temp0 0)
					)
					(
						(and
							(= temp31
								(Min
									(if (== temp30 16) 25 else 21)
									(temp49 minPoints:)
								)
							)
							(>= (+ temp3 temp31) 33)
						)
						(cond
							(
								(and
									(== param2 25)
									(<= ((proc709_6 6) bidNumber:) 19)
									(<
										(-
											((proc709_6 4) bidNumber:)
											((proc709_6 2) bidNumber:)
										)
										5
									)
								)
								(if (>= (param1 calcHonors: temp27 3) 2)
									(= temp0 (proc709_0 temp27 7))
								else
									(= temp0 (proc709_0 temp27 6))
								)
							)
							(
								(and
									(== param2 25)
									(<= ((proc709_6 6) bidNumber:) 19)
								)
								(cond
									((>= (param1 calcHonors: temp11 3) 2)
										(= temp0 (proc709_0 temp11 7))
									)
									(
										(and
											(param1 calcHonors: temp11 3)
											(or
												(== temp11 4)
												(param1 hasCard: 4 3853)
											)
											(or
												(== temp11 3)
												(param1 hasCard: 3 3853)
											)
											(or
												(== temp11 2)
												(param1 hasCard: 2 3853)
											)
											(or
												(== temp11 1)
												(param1 hasCard: 1 3853)
											)
										)
										(= temp0 30)
									)
									(else
										(= temp0 (proc709_0 temp11 6))
									)
								)
							)
							(
								(and
									(>= [temp16 temp10] 7)
									(>= (param1 calcHonors: temp10 3) 3)
									(or
										(== temp11 5)
										(== temp43 5)
										(>= (param1 calcHonors: temp10 4) 4)
									)
								)
								(= temp0 (proc709_0 temp27 6))
							)
							(
								(and
									(>= [temp16 (= temp2 temp10)] 7)
									(>= (param1 calcTricks: temp2) 11)
								)
								(= temp0
									(proc709_0 temp2 (param1 minLevel: temp2))
								)
							)
							((== temp11 5)
								(= temp0 30)
							)
							(
								(or
									(>= [temp16 (= temp2 temp43)] 4)
									(and
										(== [temp16 temp43] 3)
										(param1 hasCard: (= temp2 temp43) 3852)
									)
									(and (>= temp26 4) (= temp2 temp11))
									(and
										(== temp26 3)
										(param1 hasCard: (= temp2 temp11) 3852)
									)
									(and
										(or
											(= temp31 0)
											(and
												(>
													(-
														((proc709_6 8)
															bidNumber:
														)
														((proc709_6 6)
															bidNumber:
														)
													)
													5
												)
												(= temp31 1)
											)
											(== temp43 temp11)
											(>
												(-
													((proc709_6 4) bidNumber:)
													((proc709_6 2) bidNumber:)
												)
												5
											)
										)
										(or
											(>= [temp16 (= temp2 temp43)] 3)
											(and
												(== [temp16 temp43] 2)
												(>
													(param1
														calcHonors: temp43 4
													)
													1
												)
											)
										)
									)
									(and
										temp31
										(or
											(and
												(== temp26 2)
												(param1
													calcHonors:
														(= temp2 temp11)
														4
												)
											)
											(>= temp26 3)
										)
									)
									(== (= temp2 temp43) temp11)
								)
								(= temp0 (proc709_0 temp2 6))
							)
							((== temp11 temp43)
								(= temp0 (proc709_0 temp11 6))
							)
							((< param2 20)
								(= temp0 761)
							)
							((> temp26 [temp16 temp43])
								(= temp0 (+ param2 5))
							)
							(else
								(= temp0
									(proc709_0 temp43 (param1 minLevel: temp43))
								)
							)
						)
					)
					((or (== param2 15) (== temp11 temp27) (== temp11 temp43))
						(= temp0 0)
					)
					(
						(or
							(>= [temp16 (= temp2 temp10)] 7)
							(>= (param1 calcTricks: (= temp2 4)) 11)
							(>= (param1 calcTricks: (= temp2 3)) 11)
							(>= (param1 calcTricks: (= temp2 2)) 11)
							(>= (param1 calcTricks: (= temp2 1)) 11)
						)
						(= temp0 (proc709_0 temp2 (param1 minLevel: temp2)))
					)
					(
						(or
							(and
								(proc709_1 param1 4)
								(not [temp75 (= temp2 4)])
							)
							(and
								(proc709_1 param1 3)
								(not [temp75 (= temp2 3)])
							)
							(and
								(proc709_1 param1 2)
								(not [temp75 (= temp2 2)])
							)
							(and
								(proc709_1 param1 1)
								(not [temp75 (= temp2 1)])
							)
						)
						(= temp0 (proc709_0 temp2 (param1 minLevel: temp2)))
					)
					((>= [temp16 temp43] temp26)
						(= temp0 (proc709_0 temp43 (param1 minLevel: temp43)))
					)
					(else
						(= temp0 0)
					)
				)
			)
			((and (== (param1 bidsOpen:) 3) (not temp29))
				(= temp33
					(+
						temp3
						(cond
							((!= ((proc709_6 2) bidNumber:) 7) 9)
							((not (localproc_0 6)) 6)
							(else 3)
						)
					)
				)
				(cond
					((>= temp12 6)
						(= temp0 0)
					)
					((>= temp33 33)
						(cond
							((>= temp73 8)
								(if (< temp12 4)
									(param1 agreedSuit: temp74)
									(= temp0 761)
								else
									(= temp0 (proc709_0 temp74 6))
								)
							)
							((>= (- (+ temp4 temp33) temp3) 34)
								(= temp0 30)
							)
							((and (>= temp33 35) (>= temp73 7))
								(= temp0 (proc709_0 temp74 6))
							)
							(
								(and
									(>= temp12 (param1 findGameLevel: temp11))
									(or (== temp11 5) (>= [temp21 temp11] 7))
								)
								(= temp0 0)
							)
							((and [temp53 4] [temp53 3] [temp53 2] [temp53 1])
								(= temp0 (proc709_0 5 (param1 minLevel: 5)))
							)
							(else
								(= temp0
									(proc709_0
										temp74
										(param1 findGameLevel: temp74)
									)
								)
								(if (not (param1 canBid: temp0))
									(if (== temp74 temp11)
										(= temp0 0)
									else
										(= temp0
											(proc709_0
												temp74
												(param1 minLevel: temp74)
											)
										)
									)
								)
							)
						)
					)
					(
						(and
							(>= temp12 (param1 findGameLevel: temp11))
							(or
								(== temp11 5)
								(== temp11 temp10)
								(and
									(== temp11 (= temp31 (param1 longSuit: 2)))
									(OneOf temp31 temp11 temp43 temp44)
								)
								(>= [temp16 temp11] 3)
								(and
									(>= [temp75 temp11] 2)
									(>= [temp16 temp11] 2)
								)
							)
						)
						(= temp0 0)
					)
					(
						(or
							(and
								(>= (param1 calcHonors: 4 5) 4)
								(>= (param1 calcTricks: (= temp2 4)) 6)
							)
							(and
								(>= (param1 calcHonors: 3 5) 4)
								(>= (param1 calcTricks: (= temp2 3)) 6)
							)
							(and
								(>= (param1 calcHonors: 2 5) 4)
								(>= (param1 calcTricks: (= temp2 2)) 6)
							)
							(and
								(>= (param1 calcHonors: 1 5) 4)
								(>= (param1 calcTricks: (= temp2 1)) 6)
							)
						)
						(= temp0 (proc709_0 temp2 (param1 minLevel: temp2)))
						(proc709_5 param1 temp2 5 11)
					)
					(
						(or
							(>= [temp16 (= temp2 temp44)] 4)
							(and (>= temp26 4) (= temp2 temp11))
							(>= [temp16 (= temp2 temp43)] 3)
							(and
								(or
									(== (= temp2 temp43) temp44)
									(== temp2 temp11)
									(== (= temp2 temp44) temp11)
								)
								(>= [temp16 temp2] 2)
								(param1 hasCard: temp2 3851)
							)
						)
						(= temp0 (proc709_0 temp2 (param1 minLevel: temp2)))
						(proc709_5 param1 temp2 3 6)
					)
					((and [temp53 4] [temp53 3] [temp53 2] [temp53 1])
						(= temp0 (proc709_0 5 (param1 minLevel: 5)))
					)
					(
						(or
							(and (not [temp75 4]) (>= [temp16 (= temp2 4)] 5))
							(and (not [temp75 3]) (>= [temp16 (= temp2 3)] 5))
							(and (not [temp75 2]) (>= [temp16 (= temp2 2)] 5))
							(and (not [temp75 1]) (>= [temp16 (= temp2 1)] 5))
						)
						(= temp0 (proc709_0 temp2 (param1 minLevel: temp2)))
						(proc709_5 param1 temp2 4 6)
					)
					(
						(or
							(and
								(<= [temp75 4] 1)
								(proc709_1 param1 (= temp2 4))
							)
							(and
								(<= [temp75 3] 1)
								(proc709_1 param1 (= temp2 3))
							)
							(and
								(<= [temp75 2] 1)
								(proc709_1 param1 (= temp2 2))
							)
							(and
								(<= [temp75 1] 1)
								(proc709_1 param1 (= temp2 1))
							)
						)
						(= temp0 (proc709_0 temp2 (param1 minLevel: temp2)))
						(proc709_5 param1 temp2 5 11)
					)
					(
						(or
							(and
								(not [temp75 4])
								(>= [temp16 4] 4)
								(>= (param1 calcHCP: (= temp2 4)) 2)
							)
							(and
								(not [temp75 3])
								(>= [temp16 3] 4)
								(>= (param1 calcHCP: (= temp2 3)) 2)
							)
							(and
								(not [temp75 2])
								(>= [temp16 2] 4)
								(>= (param1 calcHCP: (= temp2 2)) 2)
							)
							(and
								(not [temp75 1])
								(>= [temp16 1] 4)
								(>= (param1 calcHCP: (= temp2 1)) 2)
							)
						)
						(= temp0 (proc709_0 temp2 (param1 minLevel: temp2)))
						(proc709_5 param1 temp2 4 6)
					)
					(
						(and
							(>= [temp21 temp11] 7)
							(or
								(and (>= [temp21 (= temp2 4)] 7) (>= temp33 26))
								(and (>= [temp21 (= temp2 3)] 7) (>= temp33 26))
								(and (>= [temp21 (= temp2 2)] 7) (>= temp33 29))
								(and (>= [temp21 (= temp2 1)] 7) (>= temp33 29))
							)
						)
						(if
							(and
								(>= [temp21 temp11] 7)
								(>= temp12 (param1 findGameLevel: temp11))
							)
							(= temp0 0)
						else
							(if
								(and
									(< [temp21 temp2] temp73)
									(!= (= temp2 temp74) 4)
									(== [temp21 3] temp73)
								)
								(= temp2 3)
							)
							(= temp0
								(proc709_0 temp2 (param1 findGameLevel: temp2))
							)
						)
					)
					(else
						(= temp31 100)
						(for ((= temp2 1)) (<= temp2 4) ((++ temp2))
							(if
								(and
									(>= [temp21 temp2] temp73)
									(<
										(= temp32 (param1 minLevel: temp2))
										temp31
									)
								)
								(= temp31 temp32)
								(= temp74 temp2)
							)
						)
						(= temp0 (proc709_0 temp74 temp31))
					)
				)
			)
			((and (== (param1 bidsOpen:) 3) temp29)
				(= temp31
					(cond
						((== temp43 temp50) 4)
						((or (== temp44 temp50) (== temp11 temp50))
							(if
								(or
									(and
										(==
											((= temp32 (proc709_6 8)) suit:)
											temp50
										)
										(not (temp32 artificial:))
										(>
											(-
												(temp32 bidNumber:)
												((proc709_6 6) bidNumber:)
											)
											5
										)
									)
									(and
										(==
											((= temp32 (proc709_6 12)) suit:)
											temp50
										)
										(not (temp32 artificial:))
										(>
											(-
												(temp32 bidNumber:)
												((proc709_6 10) bidNumber:)
											)
											5
										)
									)
								)
								3
							else
								2
							)
						)
						(else 0)
					)
				)
				(if (> (= temp31 (+ [temp16 temp50] temp31)) [temp21 temp50])
					(= [temp21 temp50] temp31)
				)
				(= temp31
					(cond
						((== temp44 temp45) 4)
						((== temp11 temp45) 3)
						(else 0)
					)
				)
				(if (> (= temp31 (+ [temp16 temp45] temp31)) [temp21 temp45])
					(= [temp21 temp45] temp31)
				)
				(if
					(and
						(== temp11 temp27)
						(>
							(= temp31 (+ [temp16 temp27] temp31))
							[temp21 temp27]
						)
					)
					(= [temp21 temp27] temp31)
				)
				(if (== temp43 temp44)
					(= [temp21 temp43] (+ 7 [temp16 temp43]))
				)
				(if (and (== temp44 temp11) (!= temp43 temp11))
					(= [temp21 temp43] (+ 6 [temp16 temp43]))
					(= [temp21 temp11] (+ 5 [temp16 temp11]))
				)
				(= temp33 [temp21 temp11])
				(cond
					(
						(and
							(or (== temp11 (= temp2 4)) (<= [temp21 4] temp33))
							(or (== temp11 (= temp2 3)) (<= [temp21 3] temp33))
							(or (== temp11 (= temp2 2)) (<= [temp21 2] temp33))
							(or (== temp11 (= temp2 1)) (<= [temp21 1] temp33))
							(not (= temp2 0))
							(>= temp12 (param1 findGameLevel: temp11))
							(or (and (== temp11 5) (= temp33 13)) (>= temp33 7))
						)
						(= temp0 0)
					)
					(temp2
						(= temp0
							(proc709_0
								temp2
								(= temp31 (param1 minLevel: temp2))
							)
						)
						(if (and (> temp31 temp12) (>= temp12 6))
							(= temp0 0)
						)
					)
					((and [temp53 4] [temp53 3] [temp53 2] [temp53 1])
						(= temp0 (proc709_0 5 (param1 minLevel: 5)))
					)
					(
						(and
							(u> temp9 28672)
							(or
								(u> temp9 -32768)
								(>= (param1 calcHCP: temp10) 4)
							)
							(or
								(!= temp27 temp10)
								(!= temp45 temp10)
								(!= temp50 temp10)
							)
						)
						(= temp0 (proc709_0 temp10 (param1 minLevel: temp10)))
					)
					(
						(and
							(= temp2 temp44)
							(OneOf temp9 26128 30208)
							(<= [temp75 temp2] 1)
						)
						(= temp0 (proc709_0 temp2 (param1 minLevel: temp2)))
					)
					((>= [temp16 temp43] [temp16 temp44])
						(= temp0 (proc709_0 temp43 (param1 minLevel: temp43)))
					)
					(
						(or
							(and
								(not [temp75 (= temp2 4)])
								(proc709_3 param1 4)
							)
							(and
								(not [temp75 (= temp2 3)])
								(proc709_3 param1 3)
							)
							(and
								(not [temp75 (= temp2 2)])
								(proc709_3 param1 2)
							)
							(and
								(not [temp75 (= temp2 1)])
								(proc709_3 param1 1)
							)
						)
						(= temp0 (proc709_0 temp2 (param1 minLevel: temp2)))
					)
					(
						(or
							(!= ((proc709_6 2) bidNumber:) 7)
							(>= ((proc709_6 4) bidNumber:) 13)
						)
						(= temp74 (= temp73 0))
						(for ((= temp2 1)) (<= temp2 4) ((++ temp2))
							(if (>= [temp21 temp2] temp73)
								(= temp73 [temp21 temp2])
								(= temp74 temp2)
							)
						)
						(= temp31
							(Max
								(param1 findGameLevel: temp74)
								(param1 minLevel: temp74)
							)
						)
						(if (== param2 (= temp0 (proc709_0 temp74 temp31)))
							(= temp0 0)
						)
					)
					(else
						(= temp0 0)
					)
				)
			)
			((and (== (param1 bidsOpen:) 4) (not temp29))
				(= temp31 13)
				(= temp33 (>= temp12 (param1 findGameLevel: temp11)))
				(for ((= temp2 1)) (<= temp2 4) ((++ temp2))
					(if
						(and
							(>= [temp21 temp2] temp73)
							(< (= temp32 (param1 minLevel: temp2)) temp31)
						)
						(= temp31 temp32)
						(= temp74 temp2)
					)
				)
				(= temp1 (proc709_0 temp2 temp31))
				(cond
					((and temp33 (or (== temp11 5) (>= [temp21 temp11] 7)))
						(= temp0 0)
					)
					((and [temp53 4] [temp53 3] [temp53 2] [temp53 1])
						(= temp0 (proc709_0 5 (param1 minLevel: 5)))
					)
					((and temp33 (<= [temp21 temp11] 6))
						(if (>= temp73 7)
							(= temp0 temp1)
						else
							(= temp0 (proc709_0 5 (param1 minLevel: 5)))
						)
					)
					(
						(and
							(not temp33)
							(or
								(!= ((proc709_6 2) bidNumber:) 7)
								(>= temp36 26)
								(>= temp71 2)
							)
						)
						(= temp0
							(proc709_0 temp74 (param1 findGameLevel: temp74))
						)
					)
					((and (not temp33) (>= [temp21 temp11] 7))
						(= temp0 0)
					)
					(else
						(if
							(and
								(<= temp74 2)
								(or
									(== [temp16 (= temp2 3)] temp73)
									(== [temp16 (= temp2 4)] temp73)
								)
							)
							(= temp1 (proc709_0 temp2 (param1 minLevel: temp2)))
						)
						(= temp0 temp1)
					)
				)
			)
			((and temp29 (== (param1 bidsOpen:) 4))
				(cond
					(
						(and
							(!= temp11 temp10)
							(>= [temp16 temp10] 8)
							(or
								(>= [temp16 temp10] 9)
								(>= (param1 calcHCP: temp10) 4)
							)
						)
						(= temp0 (proc709_0 temp10 (param1 minLevel: temp10)))
					)
					(
						(and
							(>= [temp16 temp43] [temp16 temp11])
							(!= temp11 temp43)
						)
						(= temp0 (proc709_0 temp43 (param1 minLevel: temp43)))
					)
					(else
						(= temp0 0)
					)
				)
			)
			((and (not temp29) (== (param1 bidsOpen:) 5))
				(cond
					(
						(and
							(not temp26)
							(>= [temp16 temp10] 8)
							(or
								(>= [temp16 temp10] 9)
								(>= (param1 calcHCP: temp10) 4)
							)
							(param1 canBid: (= temp1 (proc709_0 temp10 temp12)))
						)
						(= temp0 temp1)
					)
					(
						(and
							(!= temp11 temp10)
							(!= temp11 5)
							(>= (param1 calcTricks: temp10) 15)
						)
						(= temp0 (proc709_0 temp10 (param1 minLevel: temp10)))
					)
					(else
						(= temp0 0)
					)
				)
			)
			(else
				(= temp0 0)
			)
		)
		(return (if temp0 temp0 else 0))
	)
)

