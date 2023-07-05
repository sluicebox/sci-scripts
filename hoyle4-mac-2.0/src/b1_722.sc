;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 722)
(include sci.sh)
(use Main)
(use n709)
(use Bid)
(use System)

(public
	b1 0
)

(instance b1 of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 [temp11 6] [temp17 6] temp23 temp24 [temp25 6] [temp31 6])
		(= temp5 (param1 partner:))
		(= temp0 0)
		(= temp9 (+ 1 (mod (- param2 1) 5)))
		(= [temp25 1] (param1 clubs:))
		(= [temp25 2] (param1 diamonds:))
		(= [temp25 3] (param1 hearts:))
		(= [temp25 4] (param1 spades:))
		(= [temp31 1] (param1 partnerClubs:))
		(= [temp31 2] (param1 partnerDiamonds:))
		(= [temp31 3] (param1 partnerHearts:))
		(= [temp31 4] (param1 partnerSpades:))
		(for ((= temp3 0)) (< temp3 6) ((++ temp3))
			(= [temp11 temp3] 0)
		)
		(= temp23 5)
		(= temp3 0)
		(= temp6 (BidBox size:))
		(while (< temp3 temp6)
			(= temp8 (BidBox at: temp3))
			(if
				(and
					(not (temp8 artificial:))
					(not (OneOf (= temp7 (temp8 bidNumber:)) 0 50 99))
					(<= 1 (= temp1 (temp8 suit:)) 5)
				)
				(++ [temp17 temp1])
				(if (== (temp8 location:) (temp5 location:))
					(++ [temp11 temp1])
					(if (< temp7 16)
						(= temp23 temp1)
					)
				)
			)
			(++ temp3)
		)
		(= temp10 0)
		(switch (param1 bidBranch:)
			(13
				(= temp0
					(switch (param1 aces:)
						(1 18)
						(2 19)
						(3 20)
						(else 17)
					)
				)
				(param1 bidBranch: 15)
				((param1 partner:) bidBranch: 12)
			)
			(12
				(= temp2
					(+
						(param1 aces:)
						(switch param2
							(17
								(if (param1 aces:) 0 else 4)
							)
							(18 1)
							(19 2)
							(20 3)
							(else 0)
						)
					)
				)
				(= temp10 1)
				(cond
					((> global427 20)
						(= temp0 0)
					)
					((and (>= temp2 4) (>= (param1 combinedPts:) 36))
						(= temp0 21)
						(param1 bidBranch: 14 forcing: 1)
						((param1 partner:) bidBranch: 15)
						(= temp10 0)
					)
					(
						(and
							(== temp2 3)
							(or
								(and
									(== global195 2)
									(for ((= temp1 1)) (<= temp1 4) ((++ temp1))
										(if
											(and
												(> [temp25 temp1] 1)
												(> [temp31 temp1] 1)
												(not
													(param1 hasCard: temp1 3853)
												)
												(not
													(temp5 hasCard: temp1 3853)
												)
											)
											(= temp1 0)
										)
									)
									temp1
								)
								(and
									(== global195 1)
									(or
										(<= (param1 spades:) 1)
										(param1 hasCard: 4 3853)
										[temp11 4]
									)
									(or
										(<= (param1 hearts:) 1)
										(param1 hasCard: 3 3853)
										[temp11 3]
									)
									(or
										(<= (param1 diamonds:) 1)
										(param1 hasCard: 2 3853)
										[temp11 2]
									)
									(or
										(<= (param1 clubs:) 1)
										(param1 hasCard: 1 3853)
										[temp11 1]
									)
								)
								(and
									(== global195 1)
									(or
										(<= (param1 spades:) 1)
										(param1 hasCard: 4 3853)
									)
									(or
										(<= (param1 hearts:) 1)
										(param1 hasCard: 3 3853)
									)
									(or
										(<= (param1 diamonds:) 1)
										(param1 hasCard: 2 3853)
									)
									(or
										(<= (param1 clubs:) 1)
										(param1 hasCard: 1 3853)
									)
								)
							)
						)
						(= temp0 30)
					)
					(else
						(= temp0 20)
						(= temp10 1)
					)
				)
			)
			(15
				(if (== param2 21)
					(= temp0
						(switch
							(= temp4
								(+
									(param1 hasCard: 1 13)
									(param1 hasCard: 2 13)
									(param1 hasCard: 3 13)
									(param1 hasCard: 4 13)
								)
							)
							(0 22)
							(1 23)
							(2 24)
							(3 25)
							(4 26)
						)
					)
				else
					(= temp0 0)
					(= temp10 1)
				)
				(if (not temp10)
					(param1 bidBranch: 0)
					((param1 partner:) bidBranch: 14)
				)
			)
			(14
				(= temp10 1)
				(cond
					(
						(>=
							(= temp4
								(+
									(param1 hasCard: 1 13)
									(param1 hasCard: 2 13)
									(param1 hasCard: 3 13)
									(param1 hasCard: 4 13)
									(switch param2
										(22 0)
										(23 1)
										(24 2)
										(25 3)
										(26 4)
										(else 0)
									)
								)
							)
							4
						)
						(= temp0 35)
					)
					((== temp4 3)
						(= temp0 30)
					)
					((>= [temp25 (= temp1 (param1 longSuit:))] 7)
						(= temp0 (proc709_0 temp1 6))
					)
					(else
						(= temp0 25)
					)
				)
			)
			(else
				(= temp0 0)
				(= temp10 1)
			)
		)
		(if temp10
			(param1 forcing: 0 bidBranch: 0)
			(temp5 forcing: 0 bidBranch: 0)
		)
		(return temp0)
	)
)

