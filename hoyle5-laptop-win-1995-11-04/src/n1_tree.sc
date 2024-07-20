;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 712)
(include sci.sh)
(use n709)
(use bidBoxWindow)
(use System)

(public
	n1_tree 0
)

(instance n1_tree of Code
	(properties)

	(method (doit param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 [temp13 2] [temp15 6] temp21 temp22 temp23 temp24 temp25 [temp26 3] temp29 temp30 [temp31 3] temp34 [temp35 8] temp43 temp44 temp45)
		(for ((= temp12 0)) (< temp12 5) ((++ temp12))
			(= [temp15 temp12] 0)
		)
		(= temp43 (param1 partner:))
		(= temp2 (param1 points:))
		(= temp3 (param1 hcp:))
		(= temp4 (param1 playingTricks:))
		(= temp5 (param1 quickTricks:))
		(= temp6 (param1 singletons:))
		(= temp7 (param1 voids:))
		(= temp8 (param1 shape:))
		(= temp9 (param1 longSuit:))
		(= temp29 (param1 combinedHCP:))
		(= temp30 (param1 combinedPts:))
		(= temp34 (param1 agreedSuit:))
		(= [temp15 0] 0)
		(= [temp15 2] (param1 diamonds:))
		(= [temp15 1] (param1 clubs:))
		(= [temp15 3] (param1 hearts:))
		(= [temp15 4] (param1 spades:))
		(= temp21 (+ 1 (mod (- param3 1) 5)))
		(= temp22 (+ (/ (- param3 1) 5) 1))
		(= temp10 (+ 1 (mod (- param2 1) 5)))
		(= temp11 (+ (/ (- param2 1) 5) 1))
		(= temp0 0)
		(= temp44 (param1 bidsOpen:))
		(= temp45 (BidBox openingBidder:))
		(cond
			((and (== temp44 1) (== temp45 param1) (== param2 10))
				(if (and (>= temp3 16) (>= temp2 17))
					(= temp0 15)
				)
			)
			((and (== temp44 1) (== temp45 param1) (== temp11 2))
				(if (>= [temp15 temp10] 4)
					(param1 agreedSuit: temp10)
					(if (>= (= temp2 (param1 calcPoints:)) 18)
						(= temp0 (proc709_0 temp10 3))
					)
				)
				(if
					(and
						(u> temp8 20480)
						(<= [temp15 temp10] 2)
						(not (param1 hasCard: temp10 3852))
						(param1 canBid: (= temp23 (proc709_0 temp9 2)))
						(>= temp3 16)
					)
					(= temp0 temp23)
					(proc709_5 param1 temp10 2 2)
					(proc709_5 param1 temp9 5 5)
				)
			)
			((and (== temp44 1) (== temp45 param1) (<= 11 param2 14))
				(if
					(or
						(>= (= temp23 [temp15 temp10]) 4)
						(and
							(>= temp10 3)
							(== temp23 3)
							(param1 hasCard: temp10 3852)
						)
					)
					(= temp0 (proc709_0 temp10 4))
					(proc709_5 param1 temp10 3 5)
				else
					(for ((= temp1 2)) (<= temp1 4) ((++ temp1))
						(if
							(and
								(>= (= temp24 [temp15 temp1]) 4)
								(or
									(>= temp24 5)
									(and
										(>= (param1 calcHonors: temp1 5) 3)
										(>= (param1 calcHCP: temp1) 6)
									)
								)
								(param1 canBid: (= temp25 (proc709_0 temp1 3)))
							)
							(= temp0 temp25)
							(proc709_5 param1 temp1 4 5)
							(proc709_5 param1 temp10 2 3)
							(break)
						)
					)
					(cond
						((!= temp0 0))
						(
							(and
								(>= temp23 3)
								(>= temp10 3)
								(<= (& temp8 $000f) 2)
							)
							(= temp0 (proc709_0 temp10 4))
							(proc709_5 param1 temp10 3 5)
						)
						(else
							(= temp0 15)
							(proc709_5 param1 temp10 0 3)
						)
					)
				)
			)
			((and (== temp44 1) (== temp45 temp43))
				(cond
					(
						(and
							(== temp10 temp21)
							(>= temp2 8)
							(or (>= temp2 11) (>= temp21 3))
							(< temp11 (= temp23 (param1 findGameLevel: temp21)))
						)
						(= temp0 (proc709_0 temp21 temp23))
					)
					((and (== temp10 5) temp7)
						(if
							(>=
								(>> temp8 $000c)
								(+ 2 (>> (& temp8 $0f00) $0008))
							)
							(= temp0 (proc709_0 temp9 (param1 minLevel: temp9)))
							(proc709_5 param1 temp9 6 11)
						else
							(= temp23 (param1 longSuit: 2))
							(= temp0
								(proc709_0 temp23 (param1 minLevel: temp23))
							)
							(proc709_5 param1 temp23 4 6)
						)
					)
					((and (!= temp10 5) (!= temp10 temp21))
						(cond
							((param1 supports: temp10 1)
								(if (>= temp2 8)
									(= temp0
										(proc709_0
											temp10
											(param1 minLevel: temp10)
										)
									)
									(proc709_5 param1 temp10 2 6)
								else
									(= temp0 0)
								)
							)
							(
								(>=
									(>> temp8 $000c)
									(+ 2 (>> (& temp8 $0f00) $0008))
								)
								(= temp0
									(proc709_0 temp9 (param1 minLevel: temp9))
								)
								(proc709_5 param1 temp9 6 11)
								(proc709_5 param1 temp10 0 2)
							)
							(else
								(= temp23 (param1 longSuit: 2))
								(= temp0
									(proc709_0 temp23 (param1 minLevel: temp23))
								)
								(proc709_5 param1 temp23 4 6)
								(proc709_5 param1 temp10 0 2)
							)
						)
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

