;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 770)
(include sci.sh)
(use Main)
(use n709)
(use Bid)
(use System)

(public
	BridgeStrategy 0
)

(class BridgeStrategy of Code
	(properties
		lastBid 0
	)

	(method (bid param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 [temp16 5] temp21 temp22 temp23 temp24 temp25 temp26 temp27 temp28 temp29 temp30 temp31 [temp32 5] temp37 temp38 temp39 temp40 [temp41 5] [temp46 5] [temp51 5] temp56 temp57 [temp58 6] [temp64 6] [temp70 6] temp76 temp77 temp78 temp79 temp80)
		(param1 points: (param1 calcPoints:))
		(param1 hcp: (param1 calcHCP:))
		(= global439 0)
		(= temp38 (param1 partner:))
		(= temp79 (param1 bidTree:))
		(= temp80 (temp38 bidTree:))
		(= temp1 (param1 points:))
		(= temp2 (param1 hcp:))
		(= temp3 (param1 playingTricks:))
		(= temp4 (param1 quickTricks:))
		(= temp5 (param1 singletons:))
		(= temp6 (param1 voids:))
		(= temp7 (param1 shape:))
		(= temp8 (param1 longSuit:))
		(= temp28 (+ temp2 (temp38 hcp:)))
		(param1 combinedHCP: temp28)
		(if (> (= temp22 (temp38 maxPoints:)) (- 40 temp2))
			(temp38 maxPoints: (= temp22 (- 40 temp2)))
		)
		(= temp29
			(+
				(= temp23 (temp38 minPoints:))
				(/ (+ 3 (- temp22 temp23)) 4)
				temp1
			)
		)
		(param1 combinedPts: temp29)
		(= temp31 (param1 agreedSuit:))
		(= [temp16 0] 0)
		(= [temp16 1] (param1 clubs:))
		(= [temp16 2] (param1 diamonds:))
		(= [temp16 3] (param1 hearts:))
		(= [temp16 4] (param1 spades:))
		(if (== global195 2)
			(param1 partnerClubs: (temp38 clubs:))
			(param1 partnerDiamonds: (temp38 diamonds:))
			(param1 partnerHearts: (temp38 hearts:))
			(param1 partnerSpades: (temp38 spades:))
		else
			(param1
				partnerClubs:
					(/ (+ (* (temp38 minClubs:) 3) (temp38 maxClubs:)) 4)
			)
			(param1
				partnerDiamonds:
					(/ (+ (* (temp38 minDiamonds:) 3) (temp38 maxDiamonds:)) 4)
			)
			(param1
				partnerHearts:
					(/ (+ (* (temp38 minHearts:) 3) (temp38 maxHearts:)) 4)
			)
			(param1
				partnerSpades:
					(/ (+ (* (temp38 minSpades:) 3) (temp38 maxSpades:)) 4)
			)
		)
		(= [temp46 1] (param1 partnerClubs:))
		(= [temp46 2] (param1 partnerDiamonds:))
		(= [temp46 3] (param1 partnerHearts:))
		(= [temp46 4] (param1 partnerSpades:))
		(= temp76 (param1 location:))
		(= temp77 (temp38 location:))
		(= temp9 (= temp37 (= temp11 0)))
		(= temp14 (= temp21 0))
		(= temp10 0)
		(for ((= temp12 0)) (<= temp12 5) ((++ temp12))
			(= [temp58 temp12] (= [temp64 temp12] (= [temp70 temp12] 0)))
		)
		(= temp12 0)
		(= temp22 (BidBox size:))
		(while (< temp12 temp22)
			(= temp78 (BidBox at: temp12))
			(= temp23 (temp78 location:))
			(= temp25 (temp78 bidNumber:))
			(switch temp23
				(temp77
					(= temp9 temp25)
				)
				(temp76
					(= temp11 temp25)
				)
				(else
					(if (!= temp25 0)
						(= temp37 temp25)
					)
				)
			)
			(if
				(and
					(not (temp78 artificial:))
					(not (OneOf temp25 0 50 99))
					(<= 1 (= temp0 (temp78 suit:)) 5)
					(OneOf temp23 temp76 temp77)
				)
				(++ [temp58 temp0])
				(if (== temp23 temp76)
					(++ [temp64 temp0])
				else
					(++ [temp70 temp0])
					(= temp10 temp0)
					(= temp14 (temp78 level:))
				)
			)
			(++ temp12)
		)
		(= temp21 [temp16 temp10])
		(for ((= temp12 1)) (<= temp12 4) ((++ temp12))
			(= [temp41 temp12] (+ (param1 stops: temp12 1) [temp58 temp12]))
		)
		(param1
			combinedCards:
				(if (<= 1 temp10 4)
					(+ [temp16 temp10] [temp46 temp10])
				else
					7
				)
		)
		(= temp27 (= lastBid 0))
		(if (== (= temp22 (param1 forcing:)) 1)
			(param1 forcing: (= temp22 0))
		)
		(if
			(and
				temp22
				(or
					(not (= temp23 (temp38 forcing:)))
					(and (== temp22 3) (== temp23 2))
				)
			)
			(temp38 forcing: temp22)
		)
		(cond
			((OneOf temp79 761 722)
				(= lastBid ((ScriptID temp79 0) doit: param1 temp9 temp11))
			)
			(
				(or
					(== temp79 718)
					(== temp80 718)
					(and
						(BidBox openingBidValue:)
						(not (OneOf (BidBox openingBidder:) param1 temp38))
					)
				)
				(param1 bidTree: 718)
				(temp38 bidTree: 718)
				(= lastBid ((ScriptID 718 0) doit: param1 temp9 temp11 temp37)) ; compete_tree
			)
			(
				(and
					(or temp79 temp80)
					(not (OneOf 718 temp79 temp80))
					(!= temp37 0)
					(or (!= temp37 50) (== (param1 bidBranch:) 721))
				)
				(param1 bidTree: 731)
				(temp38 bidTree: 731)
				(= lastBid ((ScriptID 731 0) doit: param1 temp9 temp11 temp37)) ; compwe_tree
			)
			((= lastBid temp79)
				(if (> lastBid 700)
					(= lastBid
						((ScriptID temp79 0) doit: param1 temp9 temp11 temp37)
					)
				)
			)
			((not (BidBox openingBidder:))
				(cond
					(
						(and
							(<= 18 temp3 21)
							(< temp2 23)
							(<= temp8 2)
							(>= [temp16 temp8] 6)
							(>= (param1 calcTricks: temp8) (/ temp3 2))
							[temp41 4]
							[temp41 3]
							[temp41 2]
							[temp41 1]
						)
						(= lastBid 15)
						(temp38 bidTree: 714)
					)
					(
						(and
							(<= 20 temp2 22)
							(not (+ temp5 temp6))
							[temp41 4]
							[temp41 3]
							[temp41 2]
							[temp41 1]
							(u< temp7 28672)
							(< [temp16 4] 6)
							(< [temp16 3] 6)
						)
						(= lastBid 10)
						(param1 bidTree: 713)
						(temp38 bidTree: 713)
					)
					(
						(or
							(>= temp2 23)
							(and
								(>= temp2 17)
								(= temp22
									(if
										(or
											(and
												(>= [temp16 2] 5)
												(>
													(param1 calcTricks: 2)
													(/ temp3 2)
												)
											)
											(and
												(>= [temp16 1] 5)
												(>
													(param1 calcTricks: 1)
													(/ temp3 2)
												)
											)
										)
										20
									else
										18
									)
								)
								(>= temp3 temp22)
							)
						)
						(= lastBid 6)
						(= global439 1)
						(param1 bidTree: 715 forcing: 1)
					)
					(
						(and
							(>=
								(+
									(if [temp41 1] 1)
									(if [temp41 2] 1)
									(if [temp41 3] 1)
									(if [temp41 4] 1)
								)
								3
							)
							(<= 15 temp2 17)
							(or
								(== temp7 17203)
								(== temp7 17458)
								(and (== temp7 21298) (<= temp8 2))
							)
						)
						(= lastBid 5)
						(param1 bidTree: 712)
					)
					((and (>= temp1 13) (>= temp2 11))
						(param1 bidTree: 716)
						(cond
							(
								(==
									[temp16 temp8]
									[temp16 (= temp22 (param1 longSuit: 2))]
								)
								(if (== [temp16 temp8] 4)
									(cond
										(
											(and
												(= temp0
													(Max temp22 temp8)
												)
												(>=
													(param1 calcHonors: temp0 5)
													4
												)
												(< temp1 16)
											)
											(= lastBid (proc709_0 temp0 1))
										)
										((and (<= temp8 2) (<= temp22 2))
											(if
												(and
													(>= (param1 calcHCP: 1) 8)
													(<= (param1 calcHCP: 2) 2)
												)
												(= lastBid 1)
											else
												(= lastBid 2)
											)
										)
										(
											(or
												(<= (= temp0 temp8) 2)
												(<= (= temp0 temp22) 2)
											)
											(= lastBid (proc709_0 temp0 1))
										)
										(else
											(= temp0
												(if (>= [temp16 2] 3) 2 else 1)
											)
											(= lastBid (proc709_0 temp0 1))
										)
									)
								else
									(= temp0 (Max temp8 temp22))
									(= lastBid (proc709_0 temp0 1))
								)
							)
							(
								(and
									(<= temp1 15)
									(< temp8 temp22)
									(or
										(== (= temp12 (& temp7 $ff00)) 21504)
										(== temp12 25856)
										(== temp12 30208)
									)
								)
								(if
									(and
										(<= (param1 calcHCP: temp8) 2)
										(or
											(and
												(or (<= temp8 2) (<= temp22 2))
												(>= (param1 calcHCP: temp22) 6)
											)
											(>= (param1 calcHCP: temp22) 9)
										)
									)
									(= lastBid (proc709_0 temp22 1))
								else
									(= lastBid (proc709_0 temp8 1))
								)
							)
							((or (u>= temp7 20480) (<= temp8 2))
								(= lastBid (proc709_0 temp8 1))
							)
							(
								(and
									(>= temp8 3)
									(or
										(>= (param1 calcHonors: temp8 5) 4)
										(>= (param1 calcHCP: temp8) 9)
									)
								)
								(= lastBid (proc709_0 temp8 1))
							)
							((>= (param1 calcHCP: 2) (+ (param1 calcHCP: 1) 4))
								(= lastBid 2)
							)
							(else
								(= lastBid 1)
							)
						)
					)
					(
						(and
							(<= 6 temp2 11)
							(== (& temp7 $f000) 24576)
							(>= temp8 2)
							(>= (param1 calcHonors: temp8 4) 2)
							(or (== temp8 4) (< [temp16 4] 4))
							(or (== temp8 3) (< [temp16 3] 4))
							(or (== temp8 2) (< [temp16 2] 5))
							(or (== temp8 1) (< [temp16 1] 5))
						)
						(= lastBid (proc709_0 temp8 2))
						(param1 bidTree: 717)
					)
					(
						(and
							(u>= temp7 28672)
							(>= (= temp22 (proc709_7 param1 temp8 temp3)) 3)
						)
						(= lastBid (proc709_0 temp8 temp22))
						(temp38 bidTree: 719)
					)
					(else
						(param1 bidTree: 0)
						(= lastBid 0)
					)
				)
				(switch lastBid
					(0
						(proc709_4 param1 0 12 0 8 0 8 0 8 0 8)
					)
					(1
						(proc709_4 param1 13 22 3 10 0 5 0 5 0 5)
					)
					(2
						(proc709_4 param1 13 22 0 5 3 10 0 5 0 5)
					)
					(3
						(proc709_4 param1 13 22 0 5 0 5 5 10 0 5)
					)
					(4
						(proc709_4 param1 13 22 0 5 0 5 0 5 5 10)
					)
					(5
						(proc709_4 param1 15 17 2 5 2 5 2 5 2 5)
					)
					(6
						(proc709_4 param1 17 37 0 11 0 11 0 11 0 11)
					)
					(7
						(proc709_4 param1 6 10 0 4 6 6 0 3 0 3)
					)
					(8
						(proc709_4 param1 6 10 0 4 0 4 6 6 0 3)
					)
					(9
						(proc709_4 param1 6 10 0 4 0 4 0 3 6 6)
					)
					(10
						(proc709_4 param1 20 22 2 6 2 6 2 5 2 5)
					)
					(11
						(proc709_4 param1 0 11 7 10 0 6 0 6 0 6)
					)
					(12
						(proc709_4 param1 0 11 0 6 7 10 0 6 0 6)
					)
					(13
						(proc709_4 param1 0 11 0 6 0 6 7 10 0 6)
					)
					(14
						(proc709_4 param1 0 11 0 6 0 6 0 6 7 10)
					)
					(15
						(proc709_4 param1 18 22 2 9 2 9 2 5 2 5)
					)
					(16
						(proc709_4 param1 0 11 8 11 0 5 0 5 0 5)
					)
					(17
						(proc709_4 param1 0 11 0 5 8 11 0 5 0 5)
					)
					(18
						(proc709_4 param1 0 11 0 5 0 5 8 11 0 5)
					)
					(19
						(proc709_4 param1 0 11 0 5 0 5 0 5 8 11)
					)
					(20
						(proc709_4 param1 17 37 0 11 0 11 0 11 0 11)
					)
					(21
						(proc709_4 param1 0 11 9 12 0 4 0 4 0 4)
					)
					(22
						(proc709_4 param1 0 11 0 4 9 12 0 4 0 4)
					)
					(26
						(proc709_4 param1 9 15 10 12 0 2 0 2 0 2)
					)
					(27
						(proc709_4 param1 9 15 0 2 10 12 0 2 0 2)
					)
					(28
						(proc709_4 param1 9 15 0 2 0 2 10 12 0 2)
					)
					(29
						(proc709_4 param1 9 15 0 2 0 2 0 2 10 12)
					)
					(31
						(proc709_4 param1 9 15 11 13 0 1 0 1 0 1)
					)
					(32
						(proc709_4 param1 9 15 0 1 11 13 0 1 0 1)
					)
					(33
						(proc709_4 param1 9 15 0 1 0 1 11 13 0 1)
					)
					(34
						(proc709_4 param1 9 15 0 1 0 1 0 1 11 13)
					)
					(else
						(proc709_4 param1 0 37 0 11 0 11 0 11 0 11)
					)
				)
				(if (!= lastBid 0)
					(BidBox openingBidder: param1 openingBidValue: lastBid)
				)
			)
			(else
				(= temp40 temp1)
				(if (and (<= 1 temp10 4) (<= [temp16 temp10] 2))
					(-= temp40 (- 3 [temp16 temp10]))
				)
				(cond
					((== temp9 5)
						(param1 bidTree: 712)
						(cond
							((u> temp7 20480)
								(cond
									((>= temp2 22)
										(= lastBid 35)
										(proc709_4
											param1
											22
											27
											0
											10
											0
											10
											0
											10
											0
											10
										)
									)
									((>= temp2 20)
										(if (u> temp7 24576)
											(= lastBid 16)
											(param1 bidTree: 722)
											(proc709_4
												param1
												20
												21
												0
												10
												0
												10
												0
												10
												0
												10
											)
										else
											(= lastBid 25)
											(proc709_4
												param1
												20
												23
												0
												6
												0
												6
												0
												6
												0
												6
											)
										)
										(param1 forcing: 3)
									)
									((>= temp1 18)
										(if (or (+ temp5 temp6) (< temp2 18))
											(= lastBid (proc709_0 temp8 6))
											(proc709_4
												param1
												17
												19
												0
												5
												0
												5
												0
												5
												0
												5
											)
											(proc709_5 param1 temp8 6 11)
										else
											(= lastBid 30)
											(proc709_4
												param1
												17
												19
												2
												7
												2
												7
												2
												7
												2
												7
											)
										)
									)
									(
										(and
											(<= 9 temp2 10)
											(or
												(and
													(!= temp8 3)
													(== [temp16 3] 4)
												)
												(and
													(!= temp8 4)
													(== [temp16 4] 4)
												)
											)
										)
										(= lastBid 721)
										(proc709_4 param1 9 17 0 8 0 8 0 6 0 6)
									)
									((>= temp2 10)
										(proc709_4 param1 10 17 0 8 0 8 0 3 0 3)
										(if (and (>= temp8 3) (u> temp7 24576))
											(= lastBid
												(proc709_0
													temp8
													(Max
														2
														(param1
															findGameLevel: temp8
														)
													)
												)
											)
											(proc709_5 param1 temp8 6 11)
										else
											(= lastBid (proc709_0 temp8 3))
											(proc709_5 param1 temp8 5 11)
											(param1 forcing: 2)
										)
									)
									(
										(and
											(!= temp8 1)
											(or
												(u> temp7 24576)
												(+ temp5 temp6)
											)
										)
										(= lastBid (proc709_0 temp8 2))
										(param1 maxPoints: 9)
									)
									(else
										(= lastBid 0)
										(param1 maxPoints: 9)
									)
								)
							)
							(
								(and
									(!= temp7 17203)
									(or (>= [temp16 3] 4) (>= [temp16 4] 4))
								)
								(if
									(or
										(>= temp1 9)
										(and (== temp7 17473) (<= [temp16 1] 2))
									)
									(= lastBid 721)
								else
									(= lastBid 0)
									(proc709_4 param1 0 8 2 5 2 5 2 4 2 4)
									(param1 maxPoints: 9)
								)
							)
							((>= temp2 22)
								(= lastBid 35)
								(proc709_4 param1 22 25 2 5 2 5 2 4 2 4)
							)
							((<= 20 temp2 21)
								(= lastBid 25)
								(proc709_4 param1 20 21 2 5 2 5 2 4 2 4)
								(param1 forcing: 3)
							)
							((<= 18 temp2 19)
								(= lastBid 30)
								(proc709_4 param1 18 19 2 5 2 5 2 4 2 4)
							)
							((<= 16 temp2 17)
								(= lastBid 20)
								(proc709_4 param1 16 17 2 5 2 5 2 4 2 4)
							)
							((<= 11 temp2 15)
								(= lastBid 15)
								(proc709_4 param1 11 15 2 5 2 5 2 4 2 4)
							)
							((<= 9 temp2 10)
								(= lastBid 10)
								(proc709_4 param1 9 10 2 5 2 5 2 4 2 4)
							)
							(else
								(= lastBid 0)
								(proc709_4 param1 0 8 2 5 2 5 2 4 2 4)
							)
						)
					)
					((== temp14 1)
						(param1 bidTree: 716)
						(cond
							(
								(or
									(>= temp40 10)
									(and (>= temp2 8) (proc709_1 param1 temp8))
								)
								(cond
									(
										(and
											(>= temp2 20)
											(param1 supports: temp10)
										)
										(if
											(and
												(== temp21 3)
												(or
													(proc709_1
														param1
														(= temp0 4)
													)
													(proc709_1
														param1
														(= temp0 3)
													)
													(proc709_1
														param1
														(= temp0 2)
													)
													(proc709_1
														param1
														(= temp0 1)
													)
													(= temp0 0)
												)
											)
											(= lastBid
												(proc709_0
													temp0
													(+
														(param1 minLevel: temp0)
														1
													)
												)
											)
											(param1 forcing: 2)
											(proc709_4
												param1
												20
												28
												0
												5
												0
												5
												0
												5
												0
												5
											)
											(proc709_5 param1 temp0 5 10)
										else
											(= lastBid 761)
											(proc709_4
												param1
												20
												28
												0
												5
												0
												5
												0
												5
												0
												5
											)
											(if (<= temp10 2)
												(proc709_5 param1 temp10 5 10)
											else
												(proc709_5 param1 temp10 3 8)
											)
										)
									)
									(
										(and
											(<= 15 temp2 17)
											(or
												(== temp7 17203)
												(== temp7 17458)
												(== temp7 21298)
												(and
													(<= 1 temp21 2)
													(>= (& temp7 $00f0) 48)
												)
											)
											[temp41 4]
											[temp41 3]
											[temp41 2]
											[temp41 1]
										)
										(= lastBid 15)
										(proc709_4 param1 15 17 2 5 2 5 2 5 2 5)
									)
									((>= temp1 17)
										(= temp22 (param1 longSuit:))
										(= temp23 (param1 longSuit: 2))
										(= temp0
											(cond
												(
													(!=
														(= temp12
															[temp16 temp22]
														)
														(= temp13
															[temp16 temp23]
														)
													)
													temp22
												)
												((u> temp7 20480)
													(Max temp22 temp23)
												)
												(else
													(Min temp22 temp23)
												)
											)
										)
										(= lastBid
											(proc709_0
												temp0
												(+ (param1 minLevel: temp0) 1)
											)
										)
										(proc709_4 param1 17 20 0 5 0 5 0 5 0 5)
										(proc709_5 param1 temp0 4 8)
										(param1 forcing: 2)
									)
									(
										(and
											(>= temp2 13)
											(or
												(== temp7 17203)
												(== temp7 17458)
												(== temp7 21298)
												(and
													(<= 1 temp21 2)
													(>= (& temp7 $00f0) 48)
												)
											)
											[temp41 3]
											[temp41 4]
											[temp41 2]
											[temp41 1]
										)
										(= lastBid 10)
										(proc709_4 param1 13 16 2 5 2 5 2 5 2 5)
										(param1 forcing: 2)
									)
									((>= temp1 13)
										(= temp12 (>> temp7 $000c))
										(= temp0 temp10)
										(if (== temp8 temp10)
											(= temp12
												(& (>> temp7 $0008) $000f)
											)
										)
										(if (>= temp12 5)
											(for
												((= temp0 4))
												(>= temp0 1)
												((-- temp0))
												
												(breakif
													(and
														(!= temp0 temp10)
														(>=
															[temp16 temp0]
															temp12
														)
													)
												)
											)
										else
											(repeat
												(if (> (++ temp0) 4)
													(= temp0 1)
												)
												(breakif
													(>= [temp16 temp0] temp12)
												)
											)
										)
										(= lastBid
											(proc709_0
												temp0
												(param1 minLevel: temp0)
											)
										)
										(param1 forcing: 1)
										(proc709_5 param1 temp0 4 8 6 18)
									)
									(
										(and
											(>= temp1 11)
											(param1 supports: temp10)
										)
										(= lastBid (proc709_0 temp10 3))
										(proc709_5 param1 temp10 4 8 11 12)
									)
									(else
										(if
											(and
												(>= [temp16 temp8] 5)
												(param1 canBid: temp8 1)
											)
											(= temp0 temp8)
										else
											(for
												((= temp0 (param1 cheapSuit:)))
												(!= temp0 temp10)
												((++ temp0))
												
												(if (> temp0 4)
													(= temp0 1)
												)
												(if (>= [temp16 temp0] 4)
													(break)
												)
											)
										)
										(= lastBid
											(proc709_0
												temp0
												(param1 minLevel: temp0)
											)
										)
										(param1 forcing: 1)
										(switch temp0
											(1
												(proc709_4
													param1
													6
													15
													4
													9
													0
													5
													0
													5
													0
													5
												)
											)
											(2
												(proc709_4
													param1
													6
													15
													0
													5
													4
													9
													0
													5
													0
													5
												)
											)
											(3
												(proc709_4
													param1
													6
													15
													0
													5
													0
													5
													4
													9
													0
													5
												)
											)
											(4
												(proc709_4
													param1
													6
													15
													0
													5
													0
													5
													0
													5
													4
													9
												)
											)
											(else
												(proc709_4
													param1
													6
													9
													0
													6
													0
													6
													0
													3
													0
													3
												)
											)
										)
									)
								)
							)
							((<= temp1 5)
								(= lastBid 0)
								(proc709_4 param1 0 5 0 7 0 7 0 7 0 7)
							)
							((param1 supports: temp10)
								(= lastBid (proc709_0 temp10 2))
								(proc709_4 param1 6 10 0 5 0 5 0 5 0 5)
								(proc709_5 param1 temp10 3 8)
							)
							(
								(or
									(and
										(>= [temp16 (= temp0 4)] 5)
										(< temp10 4)
									)
									(and
										(>= [temp16 (= temp0 3)] 5)
										(< temp10 3)
									)
									(and
										(>= [temp16 (= temp0 2)] 5)
										(< temp10 2)
									)
								)
								(= lastBid (proc709_0 temp0 1))
								(proc709_4 param1 6 16 0 5 0 5 0 5 0 5)
								(proc709_5 param1 temp0 4 8)
								(param1 forcing: 1)
							)
							(
								(or
									(>= [temp16 temp10] 4)
									(and (>= temp10 3) (== [temp16 temp10] 3))
								)
								(= lastBid (proc709_0 temp10 2))
								(proc709_4 param1 6 10 0 5 0 5 0 5 0 5)
								(proc709_5 param1 temp10 3 8)
							)
							(
								(or
									(and
										(>= [temp16 (= temp0 2)] 4)
										(param1 canBid: 2)
									)
									(and
										(>= [temp16 (= temp0 3)] 4)
										(param1 canBid: 3)
									)
									(and
										(>= [temp16 (= temp0 4)] 4)
										(param1 canBid: 4)
									)
								)
								(= lastBid (proc709_0 temp0 1))
								(proc709_4 param1 6 16 0 5 0 5 0 5 0 5)
								(proc709_5 param1 temp0 4 10)
								(param1 forcing: 1)
							)
							((>= temp2 6)
								(= lastBid 5)
								(proc709_4 param1 6 10 2 5 2 5 2 5 2 5)
							)
							(else
								(= lastBid 0)
								(proc709_4 param1 0 6 0 7 0 7 0 7 0 7)
							)
						)
					)
					((and (== temp14 2) (!= temp10 1))
						(param1 bidTree: 717)
						(cond
							(
								(and
									(<= (& temp7 $000f) 2)
									(param1 supports: temp10 1)
								)
								(cond
									((or (>= temp1 20) (>= temp3 14))
										(= lastBid 761)
										(proc709_4 param1 20 30 0 7 0 7 0 7 0 7)
										(proc709_5 param1 temp10 3 7)
									)
									(
										(and
											(== temp10 2)
											(>= temp1 17)
											(>= temp3 10)
										)
										(= lastBid 22)
										(proc709_4 param1 17 19 0 7 3 7 0 7 0 7)
									)
									(
										(or
											(and
												(>= temp10 3)
												(or (>= temp1 14) (>= temp3 10))
											)
											(and (>= temp21 5) (<= temp1 6))
										)
										(= lastBid (proc709_0 temp10 4))
										(if (== temp10 3)
											(proc709_4
												param1
												0
												19
												0
												7
												0
												7
												3
												7
												0
												7
											)
										else
											(proc709_4
												param1
												0
												19
												0
												7
												0
												7
												0
												7
												3
												7
											)
										)
									)
									(
										(or
											(>= temp1 10)
											(and (>= temp1 7) (>= temp21 4))
										)
										(= lastBid (proc709_0 temp10 3))
										(proc709_4 param1 10 13 0 7 0 7 0 7 0 7)
										(proc709_5 param1 temp10 4 7)
									)
									(else
										(= lastBid 0)
										(proc709_4 param1 0 15 0 7 0 7 0 7 0 7)
										(proc709_5 param1 temp10 0 4)
									)
								)
							)
							((>= temp21 2)
								(cond
									((>= temp1 17)
										(= lastBid 10)
										(= global439 1)
										(param1 forcing: 1)
										(proc709_4 param1 15 30 0 7 0 7 0 7 0 7)
										(proc709_5 param1 temp10 0 4)
									)
									(
										(or
											(and
												(== temp10 2)
												(>= temp1 18)
												(>= temp3 10)
											)
											(and
												(>= temp10 3)
												(or (>= temp1 15) (>= temp3 10))
											)
										)
										(= lastBid
											(proc709_0
												temp10
												(param1 findGameLevel: temp10)
											)
										)
										(proc709_4 param1 18 25 0 7 0 7 0 7 0 7)
										(proc709_5 param1 temp10 2 6)
									)
									(
										(or
											(>= temp1 10)
											(and (>= temp1 7) (>= temp3 6))
										)
										(= lastBid (proc709_0 temp10 3))
										(proc709_4 param1 7 14 0 7 0 7 0 7 0 7)
										(proc709_5 param1 temp10 2 4)
									)
									(else
										(= lastBid 0)
										(proc709_4 param1 0 15 0 7 0 7 0 7 0 7)
										(proc709_5 param1 temp10 0 4)
									)
								)
							)
							(
								(or
									(>= temp40 24)
									(and
										(>= temp3 18)
										(>= (param1 calcHonors: temp10 5) 2)
									)
									(and (>= temp1 18) (== temp21 1))
								)
								(= lastBid 10)
								(= global439 1)
								(param1 forcing: 1)
								(proc709_4 param1 15 30 0 7 0 7 0 7 0 7)
								(proc709_5 param1 temp10 0 4)
							)
							(
								(or
									(u> temp7 -32768)
									(and
										(u> temp7 28672)
										(param1 hasCard: temp8 3852)
									)
									(and
										(u> temp7 24576)
										(>= (param1 calcHonors: temp8 4) 2)
									)
								)
								(cond
									(
										(or
											(>= temp3 18)
											(and (>= temp8 3) (>= temp3 16))
										)
										(= lastBid
											(proc709_0
												temp8
												(param1 findGameLevel: temp8)
											)
										)
										(proc709_4 param1 15 30 0 7 0 7 0 7 0 7)
										(proc709_5 param1 temp8 6 11)
									)
									(
										(and
											(>= temp3 11)
											(= temp22
												(+
													(if
														(and
															(!= temp8 4)
															(!= temp10 4)
															[temp41 4]
														)
														1
													else
														0
													)
													(if
														(and
															(!= temp8 3)
															(!= temp10 3)
															[temp41 3]
														)
														1
													else
														0
													)
													(if
														(and
															(!= temp8 2)
															(!= temp10 2)
															[temp41 2]
														)
														1
													else
														0
													)
													(if
														(and
															(!= temp8 1)
															(!= temp10 1)
															[temp41 1]
														)
														1
													else
														0
													)
												)
											)
										)
										(if
											(or
												(and
													(>=
														(= temp15
															[temp16 temp8]
														)
														7
													)
													(>=
														(param1
															calcHonors: temp8 3
														)
														3
													)
												)
												(and
													(== temp15 6)
													(>=
														(param1
															calcHonors: temp8 4
														)
														4
													)
												)
												(and
													(>= temp22 2)
													(or
														(and
															(>= temp15 7)
															(>=
																(param1
																	calcHonors:
																		temp8
																		3
																)
																2
															)
														)
														(and
															(>= temp15 6)
															(>=
																(param1
																	calcHonors:
																		temp8
																		4
																)
																3
															)
														)
													)
												)
											)
											(= lastBid 10)
											(= global439 1)
											(param1 forcing: 1)
											(proc709_4
												param1
												15
												30
												0
												7
												0
												7
												0
												7
												0
												7
											)
											(proc709_5 param1 temp10 0 4)
										else
											(= lastBid
												(proc709_0
													temp8
													(param1 minLevel: temp8)
												)
											)
											(proc709_4
												param1
												8
												15
												0
												7
												0
												7
												0
												7
												0
												7
											)
											(proc709_5 param1 temp8 6 11)
										)
									)
								)
							)
							((>= temp2 14)
								(= lastBid (proc709_0 temp10 3))
								(proc709_4 param1 14 20 0 7 0 7 0 7 0 7)
								(proc709_5 param1 temp10 0 4)
							)
							(else
								(= lastBid 0)
								(proc709_4 param1 0 15 0 7 0 7 0 7 0 7)
								(proc709_5 param1 temp10 0 4)
							)
						)
					)
					((== (BidBox openingBidValue:) 6)
						(param1 bidTree: 715)
						(cond
							(
								(and
									(or
										(> [temp16 temp8] 5)
										(and
											(== [temp16 temp8] 5)
											(param1 hasCard: temp8 3852)
										)
									)
									(or (>= temp4 3) (>= temp2 8))
								)
								(= temp30 (param1 minLevel: temp8))
								(repeat
									(= lastBid (proc709_0 temp8 temp30))
									(breakif (> lastBid 7))
									(++ temp30)
								)
								(proc709_4 param1 6 14 0 6 0 6 0 6 0 6)
								(proc709_5 param1 temp8 5 12)
								(param1 forcing: 2)
							)
							((and (>= temp2 12) (> (& temp7 $000f) 1))
								(= lastBid 15)
								(proc709_4 param1 12 19 2 4 2 4 2 4 2 4)
							)
							((and (>= temp2 8) (> (& temp7 $000f) 1))
								(= lastBid 10)
								(proc709_4 param1 8 11 2 4 2 4 2 4 2 4)
							)
							(else
								(= lastBid 7)
								(proc709_4 param1 0 9 0 7 0 7 0 7 0 7)
							)
						)
					)
					(else
						(param1 bidTree: 0)
						(= lastBid 0)
						(proc709_4 param1 0 15 0 7 0 7 0 7 0 7)
					)
				)
			)
		)
		(if (>= lastBid 700)
			(= lastBid
				(switch lastBid
					(761
						(param1 bidTree: 761 bidBranch: 8 forcing: 1)
						(temp38 bidTree: 761 bidBranch: 9)
						(= global439 1)
						20
					)
					(722
						(param1 bidTree: 722 bidBranch: 12 forcing: 1)
						(temp38 bidTree: 722 bidBranch: 13)
						(= global439 1)
						16
					)
					(else
						(param1 bidTree: 721 bidsOpen: 0 forcing: 1)
						(= global439 1)
						(BidBox
							openingBidder: temp38
							openingBidValue: temp9
							bidsSinceOpen: 2
						)
						(temp38 bidTree: 721 bidsOpen: 1)
						(proc709_0 1 (param1 minLevel: 1))
					)
				)
			)
		)
		(= temp25 lastBid)
		(= temp22 (+ 1 (/ (- global427 1) 5)))
		(= temp0 (+ 1 (mod (- global427 1) 5)))
		(if (not (param1 canBid: lastBid))
			(= lastBid 0)
		)
		(if
			(and
				(== lastBid 0)
				(= temp23 (temp38 forcing:))
				(or
					(== temp23 1)
					(and (== temp23 3) (< temp22 6))
					(< temp22 (param1 findGameLevel: temp0))
				)
			)
			(= temp57 0)
			(for ((= temp22 1)) (<= temp22 4) ((++ temp22))
				(= [temp51 temp22] (+ [temp16 temp22] [temp46 temp22]))
				(if (>= [temp51 temp22] temp57)
					(= temp57 [temp51 temp22])
					(= temp56 temp22)
				)
			)
			(cond
				((<= 1 temp25 35)
					(if
						(and
							(== (= temp0 (+ 1 (mod (- temp25 1) 5))) temp56)
							(>= temp14 (param1 findGameLevel: temp0))
						)
						(= temp0 0)
					)
				)
				(
					(or
						(and [temp70 (= temp0 4)] (param1 supports: 4 1))
						(and [temp70 (= temp0 3)] (param1 supports: 3 1))
						(and [temp70 (= temp0 2)] (param1 supports: 2 1))
						(and [temp70 (= temp0 1)] (param1 supports: 1 1))
					)
					0
				)
				((and (u> temp7 28672) (< [temp64 temp8] 3))
					(= temp0 temp8)
				)
				((and [temp41 1] [temp41 2] [temp41 3] [temp41 4])
					(= temp0 5)
				)
				(
					(and
						(u> temp7 20480)
						(or
							(< [temp64 (= temp0 temp8)] 2)
							(and
								(< [temp64 (= temp0 (param1 longSuit: 2))] 2)
								(>= (& temp7 $0f00) 1280)
							)
						)
					)
					0
				)
				(
					(or
						(and (>= [temp16 (= temp0 4)] 4) (not [temp64 4]))
						(and (>= [temp16 (= temp0 3)] 4) (not [temp64 3]))
						(and (>= [temp16 (= temp0 2)] 4) (not [temp64 2]))
						(and (>= [temp16 (= temp0 1)] 4) (not [temp64 1]))
					)
					0
				)
				(
					(or
						(and
							(= temp22 [temp70 (= temp0 4)])
							(>= (+ temp22 [temp16 temp0]) 4)
						)
						(and
							(= temp22 [temp70 (= temp0 3)])
							(>= (+ temp22 [temp16 temp0]) 4)
						)
						(and
							(= temp22 [temp70 (= temp0 2)])
							(>= (+ temp22 [temp16 temp0]) 4)
						)
						(and
							(= temp22 [temp70 (= temp0 1)])
							(>= (+ temp22 [temp16 temp0]) 4)
						)
					)
					0
				)
				(
					(or
						(and
							(not [temp64 (= temp0 4)])
							(param1 hasCard: temp0 14)
						)
						(and
							(not [temp64 (= temp0 3)])
							(param1 hasCard: temp0 14)
						)
						(and
							(not [temp64 (= temp0 2)])
							(param1 hasCard: temp0 14)
						)
						(and
							(not [temp64 (= temp0 1)])
							(param1 hasCard: temp0 14)
						)
					)
					0
				)
				(
					(or
						(and (not [temp64 (= temp0 4)]) (param1 stops: temp0))
						(and (not [temp64 (= temp0 3)]) (param1 stops: temp0))
						(and (not [temp64 (= temp0 2)]) (param1 stops: temp0))
						(and (not [temp64 (= temp0 1)]) (param1 stops: temp0))
					)
					0
				)
				(
					(or
						(>= [temp70 (= temp0 4)] 2)
						(>= [temp70 (= temp0 3)] 2)
						(>= [temp70 (= temp0 2)] 2)
						(>= [temp70 (= temp0 1)] 2)
					)
					0
				)
				(temp57
					(= temp0 temp56)
				)
				(else
					(= temp0 5)
				)
			)
			(= lastBid (proc709_0 temp0 (param1 minLevel: temp0)))
			(if (or (not temp0) (not (param1 canBid: lastBid)))
				(= lastBid 0)
			)
		)
		(if
			(and
				(> global427 10)
				(== lastBid 0)
				(== global424 -1)
				(not (OneOf (global428 location:) temp76 temp77))
				(self penalize: param1)
			)
			(= lastBid 50)
		)
		(if (== lastBid 0)
			(++ global116)
		else
			(= global116 0)
			(if (<= 1 lastBid 35)
				(= global428 param1)
				(= global429 param1)
				(= global427 lastBid)
				(= temp0 (+ 1 (mod (- lastBid 1) 5)))
				(if (not (param1 firstBidSuit:))
					(param1 firstBidSuit: temp0)
				)
				(if (and (not (param1 agreedSuit:)) [temp70 temp0])
					(param1 agreedSuit: temp0)
					(temp38 agreedSuit: temp0)
				)
			)
		)
		(if (BidBox openingBidder:)
			(param1 bidsOpen: (+ (param1 bidsOpen:) 1))
		)
		(if
			(and
				(BidBox openingBidder:)
				(not (param1 bidsOpen:))
				(not (temp38 bidsOpen:))
			)
			(param1 directSeat: 1)
		)
		(return lastBid)
	)

	(method (penalize param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 0)
		(= temp0 (* 2 (- 7 (/ (- global427 1) 5))))
		(= temp2 (+ 1 (mod (- global427 1) 5)))
		(= temp4 (param1 calcQTS:))
		(if (== temp2 5)
			(= temp3 temp4)
		else
			(= temp3
				(- (+ temp4 (param1 calcTricks: temp2)) (param1 calcQTS: temp2))
			)
		)
		(if
			(or
				(> temp3 temp0)
				(and
					(== global427 35)
					(or
						(param1 hasCard: 1 14)
						(param1 hasCard: 2 14)
						(param1 hasCard: 3 14)
						(param1 hasCard: 4 14)
					)
				)
				(and
					(>= 31 global427 34)
					(or
						(param1 hasCard: temp2 14)
						(param1 hasCard: temp2 13 12)
						(param1 hasCard: temp2 12 11 10)
					)
				)
				(and
					(>= 26 global427 29)
					(or
						(param1 hasCard: temp2 14 13)
						(param1 hasCard: temp2 14 12 11)
						(param1 hasCard: temp2 13 12 11)
						(and
							(param1 hasCard: temp2 12 11 10)
							(> (param1 countSuit: temp2) 3)
						)
					)
				)
			)
			(= temp1 1)
		)
		(return temp1)
	)

	(method (think &tmp [temp0 3]))
)

