;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 761)
(include sci.sh)
(use Main)
(use n709)
(use bidBoxWindow)
(use System)

(public
	b1 0
)

(instance b1 of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 [temp14 6] [temp20 7] temp27 temp28 temp29 [temp30 6] [temp36 6])
		(= temp5 (param1 partner:))
		(for ((= temp3 0)) (< temp3 6) ((++ temp3))
			(= [temp14 temp3] 0)
			(= [temp20 temp3] 0)
			(= [temp36 temp3] 0)
			(= [temp30 temp3] 0)
		)
		(= temp0 0)
		(= temp12 (+ 1 (mod (- param2 1) 5)))
		(= [temp30 1] (param1 clubs:))
		(= [temp30 2] (param1 diamonds:))
		(= [temp30 3] (param1 hearts:))
		(= [temp30 4] (param1 spades:))
		(= [temp36 1] (param1 partnerClubs:))
		(= [temp36 2] (param1 partnerDiamonds:))
		(= [temp36 3] (param1 partnerHearts:))
		(= [temp36 4] (param1 partnerSpades:))
		(for ((= temp3 0)) (< temp3 6) ((++ temp3))
			(= [temp14 temp3] 0)
		)
		(= temp28 (= temp29 0))
		(= temp27 (param1 location:))
		(= temp11 (temp5 location:))
		(= temp3 0)
		(= temp7 (BidBox size:))
		(while (< temp3 temp7)
			(= temp10 (BidBox at: temp3))
			(if
				(and
					(not (temp10 artificial:))
					(not (OneOf (= temp8 (temp10 bidNumber:)) 0 50 99))
					(<= 1 (= temp1 (temp10 suit:)) 5)
				)
				(++ [temp20 temp1])
				(switch (temp10 location:)
					(temp11
						(++ [temp14 temp1])
						(if (< temp8 20)
							(= temp28 temp1)
						)
					)
					(temp27
						(= temp29 temp1)
					)
				)
			)
			(++ temp3)
		)
		(= temp6
			(cond
				((= temp9 (param1 agreedSuit:)) temp9)
				(temp28 temp28)
				(temp29 temp29)
				(else 5)
			)
		)
		(if (not temp9)
			(param1 agreedSuit: temp6)
			(temp5 agreedSuit: temp6)
		)
		(= temp13 0)
		(switch (param1 bidBranch:)
			(9
				(= temp0
					(switch (param1 aces:)
						(1 22)
						(2 23)
						(3 24)
						(else 21)
					)
				)
				(param1 bidBranch: 11)
				((param1 partner:) bidBranch: 8)
			)
			(8
				(= temp2
					(+
						(param1 aces:)
						(switch param2
							(21
								(if (param1 aces:) 0 else 4)
							)
							(22 1)
							(23 2)
							(24 3)
							(else 0)
						)
					)
				)
				(= temp13 1)
				(cond
					((> global427 24)
						(= temp0 0)
					)
					((and (>= temp2 4) (>= (param1 combinedPts:) 36))
						(= temp0 25)
						(param1 bidBranch: 10 forcing: 1)
						((param1 partner:) bidBranch: 11)
						(= temp13 0)
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
												(> [temp30 temp1] 1)
												(> [temp36 temp1] 1)
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
										[temp14 4]
									)
									(or
										(<= (param1 hearts:) 1)
										(param1 hasCard: 3 3853)
										[temp14 3]
									)
									(or
										(<= (param1 diamonds:) 1)
										(param1 hasCard: 2 3853)
										[temp14 2]
									)
									(or
										(<= (param1 clubs:) 1)
										(param1 hasCard: 1 3853)
										[temp14 1]
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
						(= temp0 (proc709_0 temp6 6))
					)
					((== temp6 temp12)
						(= temp0 0)
					)
					(
						(and
							(<= 1 temp6 4)
							(param1 canBid: (= temp8 (proc709_0 temp6 5)))
						)
						(= temp0 temp8)
					)
					(
						(or
							(and (< global427 23) (not [temp20 (= temp1 3)]))
							(and (< global427 24) (not [temp20 (= temp1 4)]))
						)
						(= temp0 (proc709_0 temp1 (param1 minLevel: temp1)))
						(= temp13 0)
						(= global439 1)
					)
					(
						(and
							(or
								(>= (+ [temp30 (= temp1 4)] [temp36 4]) 7)
								(>= (+ [temp30 (= temp1 3)] [temp36 3]) 7)
								(>= (+ [temp30 (= temp1 2)] [temp36 2]) 7)
								(>= (+ [temp30 (= temp1 1)] [temp36 1]) 7)
							)
							(param1 canBid: (= temp8 (proc709_0 temp1 5)))
						)
						(= temp0 temp8)
					)
					((param1 canBid: (= temp8 (proc709_0 temp6 6)))
						(= temp0 temp8)
					)
					(else
						(= temp0 0)
					)
				)
			)
			(11
				(cond
					(
						(or
							(and (== param2 23) (not [temp20 3]))
							(and (== param2 24) (not [temp20 4]))
						)
						(= temp0 25)
						(= temp13 1)
					)
					((== param2 25)
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
								(0 26)
								(1 27)
								(2 28)
								(3 29)
								(4
									(proc709_0 temp6 7)
								)
							)
						)
					)
					(else
						(= temp0 0)
					)
				)
				(if (not temp13)
					(param1 bidBranch: 0)
					((param1 partner:) bidBranch: 10)
				)
			)
			(10
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
										(26 0)
										(27 1)
										(28 2)
										(29 3)
										(else 4)
									)
								)
							)
							4
						)
						(if (not (param1 canBid: (= temp0 (proc709_0 temp6 7))))
							(= temp0 0)
						)
					)
					((param1 canBid: (= temp0 (proc709_0 temp6 6))) 0)
					((== temp12 temp6)
						(= temp0 0)
					)
					((param1 canBid: (= temp0 (proc709_0 5 6))) 0)
					(else
						(= temp0 0)
					)
				)
			)
			(else
				(= temp0 0)
				(= temp13 1)
			)
		)
		(if temp13
			(param1 forcing: 0 bidBranch: 0)
			(temp5 forcing: 0 bidBranch: 0)
		)
		(return temp0)
	)
)

