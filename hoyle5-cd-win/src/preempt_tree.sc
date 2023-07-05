;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 719)
(include sci.sh)
(use n709)
(use bidBoxWindow)
(use System)

(public
	preempt_tree 0
)

(instance preempt_tree of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 [temp8 6] temp14 temp15 temp16 temp17 temp18 temp19)
		(for ((= temp16 0)) (< temp16 6) ((++ temp16))
			(= [temp8 temp16] 0)
		)
		(= temp0 (param1 partner:))
		(= temp1 0)
		(if (and (== (BidBox openingBidder:) temp0) (not (param1 bidsOpen:)))
			(= [temp8 0] 0)
			(= [temp8 2] (param1 diamonds:))
			(= [temp8 1] (param1 clubs:))
			(= [temp8 3] (param1 hearts:))
			(= [temp8 4] (param1 spades:))
			(= temp7 [temp8 (= temp6 (mod param2 5))])
			(= temp18 (temp0 playingTricks:))
			(= temp3
				(-
					(param1 points:)
					(if (>= temp7 3)
						0
					else
						(- 3 temp7)
					)
				)
			)
			(= temp4 (param1 playingTricks:))
			(= temp5 (param1 quickTricks:))
			(= temp16 1)
			(= temp17 (= temp19 0))
			(while (<= temp16 4)
				(if (and (!= temp6 temp16) [temp8 temp16])
					(if (not (param1 hasCard: temp16 14))
						(++ temp19)
					)
					(if
						(and
							(>= [temp8 temp16] 2)
							(not (param1 hasCard: temp16 3853))
						)
						(++ temp17)
					)
				)
				(++ temp16)
			)
			(cond
				((>= temp7 2)
					(cond
						(
							(and
								(>= (= temp14 (+ temp4 temp18)) 25)
								(== (param1 aces:) 4)
							)
							(= temp1 25)
						)
						((>= temp14 25)
							(= temp1 761)
						)
						((and (>= temp14 24) (<= temp19 1))
							(= temp1 (proc709_0 temp6 6))
						)
						((and (>= temp14 23) (== temp7 5) (<= temp6 2))
							(= temp1 (proc709_0 temp6 6))
						)
						((and (>= temp14 23) (<= 3 temp7 4) (<= temp6 2))
							(= temp1 761)
						)
						((and (>= temp14 23) (> temp6 2) (<= temp19 1))
							(= temp1 (proc709_0 temp6 5))
						)
						((and (<= temp17 1) (>= temp14 21))
							(= temp1
								(proc709_0 temp6 (param1 findGameLevel: temp6))
							)
						)
						((and (<= 15 temp14 22) (>= temp7 3) (> temp6 2))
							(= temp1
								(proc709_0 temp6 (param1 findGameLevel: temp6))
							)
						)
						(else
							(= temp1 0)
						)
					)
				)
				(
					(or
						(= temp15
							(if (== temp7 1)
								(not (param1 calcHonors: temp6))
							)
						)
						(== temp7 0)
					)
					(cond
						(
							(or
								(and
									(not temp7)
									(!= temp6 3)
									(== temp7 [temp8 (= temp2 3)])
								)
								(and
									(not temp7)
									(!= temp6 4)
									(== temp7 [temp8 (= temp2 4)])
								)
								(and
									(not temp7)
									(!= temp6 2)
									(== temp7 [temp8 (= temp2 2)])
								)
								(and
									(not temp7)
									(!= temp6 1)
									(== temp7 [temp8 (= temp2 1)])
								)
								(and
									temp15
									(!= temp6 3)
									(== temp7 [temp8 (= temp2 3)])
								)
								(and
									temp15
									(!= temp6 4)
									(== temp7 [temp8 (= temp2 4)])
								)
								(and
									temp15
									(!= temp6 2)
									(== temp7 [temp8 (= temp2 2)])
								)
								(and
									temp15
									(!= temp6 1)
									(== temp7 [temp8 (= temp2 1)])
								)
							)
							(cond
								((== (= temp16 (param1 calcTricks: temp2)) 26)
									(= temp1 (proc709_0 temp2 7))
								)
								((== temp16 24)
									(= temp1 (proc709_0 temp2 6))
								)
								(else
									(= temp1
										(proc709_0
											temp2
											(param1 minLevel: temp2)
										)
									)
								)
							)
						)
						(
							(and
								(== (= temp14 (+ temp5 temp18)) 26)
								(== (param1 aces:) 4)
							)
							(= temp1 25)
						)
						((== temp14 26)
							(= temp1 761)
						)
						((and (<= 24 temp14 25) (<= temp19 1))
							(= temp1 (proc709_0 temp6 6))
						)
						((and (== temp14 24) temp17)
							(= temp1 761)
						)
						(
							(or
								(and
									(<= 21 temp14 23)
									(<= 3 temp7 4)
									(<= temp6 2)
								)
								(and (<= 17 temp14 23) (== temp7 3) (> temp6 2))
							)
							(= temp1
								(proc709_0 temp6 (param1 findGameLevel: temp6))
							)
						)
						(else
							(= temp1 0)
						)
					)
				)
			)
		)
		(return temp1)
	)
)

