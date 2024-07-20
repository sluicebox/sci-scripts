;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 757)
(include sci.sh)
(use Main)
(use Piles)
(use System)

(class Estimate of Code
	(properties
		LHO 0
		RHO 0
		curPlyr 0
		LHOPoints 0
		RHOPoints 0
		LHOChance 0
		RHOChance 0
		combinedHCP 0
		missingHCP 0
	)

	(method (estimate param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 [temp16 8] temp24 temp25 temp26 temp27 temp28 temp29 temp30 temp31 temp32 temp33 temp34 temp35 temp36 temp37 temp38)
		(= curPlyr (Dealer curPlayer:))
		(= temp30
			(if (== (Dealer curPlayer:) global429)
				global429
			else
				(curPlyr partner:)
			)
		)
		(= temp31 global431)
		(= LHO temp30)
		(= RHO temp31)
		(= temp32 (+ (global431 clubs:) (curPlyr clubs:)))
		(= temp33 (+ (global431 diamonds:) (curPlyr diamonds:)))
		(= temp34 (+ (global431 hearts:) (curPlyr hearts:)))
		(= temp35 (+ (global431 spades:) (curPlyr spades:)))
		(= temp0 (temp30 minClubs:))
		(= temp4 (temp30 maxClubs:))
		(= temp1 (temp30 minDiamonds:))
		(= temp5 (temp30 maxDiamonds:))
		(= temp2 (temp30 minHearts:))
		(= temp6 (temp30 maxHearts:))
		(= temp3 (temp30 minSpades:))
		(= temp7 (temp30 maxSpades:))
		(= temp24 (temp30 minPoints:))
		(= temp25 (temp30 maxPoints:))
		(= temp8 (temp31 minClubs:))
		(= temp9 (temp31 maxClubs:))
		(= temp10 (temp31 minDiamonds:))
		(= temp11 (temp31 maxDiamonds:))
		(= temp12 (temp31 minHearts:))
		(= temp13 (temp31 maxHearts:))
		(= temp14 (temp31 minSpades:))
		(= temp15 (temp31 maxSpades:))
		(= temp26 (temp31 minPoints:))
		(= temp27 (temp31 maxPoints:))
		(for ((= temp38 0)) (< temp38 2) ((++ temp38))
			(if (and (== temp0 temp4) (!= temp8 temp9))
				(= temp9 (= temp8 (= temp9 (- 13 (+ temp32 temp0)))))
			)
			(if (and (== temp1 temp5) (!= temp10 temp11))
				(= temp11 (= temp10 (= temp11 (- 13 (+ temp33 temp1)))))
			)
			(if (and (== temp2 temp6) (!= temp12 temp13))
				(= temp13 (= temp12 (= temp13 (- 13 (+ temp34 temp2)))))
			)
			(if (and (== temp3 temp7) (!= temp14 temp15))
				(= temp15 (= temp14 (= temp15 (- 13 (+ temp35 temp3)))))
			)
			(if (and (== temp8 temp9) (!= temp0 temp4))
				(= temp4 (= temp0 (= temp4 (- 13 (+ temp32 temp8)))))
			)
			(if (and (== temp10 temp11) (!= temp1 temp5))
				(= temp5 (= temp1 (= temp5 (- 13 (+ temp33 temp10)))))
			)
			(if (and (== temp12 temp13) (!= temp2 temp6))
				(= temp6 (= temp2 (= temp6 (- 13 (+ temp34 temp12)))))
			)
			(if (and (== temp14 temp15) (!= temp3 temp7))
				(= temp7 (= temp3 (= temp7 (- 13 (+ temp35 temp14)))))
			)
			(if
				(and
					(== temp0 temp4)
					(== temp1 temp5)
					(== temp2 temp6)
					(!= temp3 temp7)
				)
				(= temp3 (= temp7 (- 13 (+ temp0 temp1 temp2))))
			)
			(if
				(and
					(== temp0 temp4)
					(== temp1 temp5)
					(== temp3 temp7)
					(!= temp2 temp6)
				)
				(= temp2 (= temp6 (- 13 (+ temp0 temp1 temp3))))
			)
			(if
				(and
					(== temp0 temp4)
					(== temp3 temp7)
					(== temp2 temp6)
					(!= temp1 temp5)
				)
				(= temp1 (= temp5 (- 13 (+ temp0 temp3 temp2))))
			)
			(if
				(and
					(== temp3 temp7)
					(== temp1 temp5)
					(== temp2 temp6)
					(!= temp0 temp4)
				)
				(= temp0 (= temp4 (- 13 (+ temp3 temp1 temp2))))
			)
			(if
				(and
					(== temp8 temp9)
					(== temp10 temp11)
					(== temp12 temp13)
					(!= temp14 temp15)
				)
				(= temp14 (= temp15 (- 13 (+ temp8 temp10 temp12))))
			)
			(if
				(and
					(== temp8 temp9)
					(== temp10 temp11)
					(== temp14 temp15)
					(!= temp12 temp13)
				)
				(= temp12 (= temp13 (- 13 (+ temp8 temp10 temp14))))
			)
			(if
				(and
					(== temp8 temp9)
					(== temp14 temp15)
					(== temp12 temp13)
					(!= temp10 temp11)
				)
				(= temp10 (= temp11 (- 13 (+ temp8 temp14 temp12))))
			)
			(if
				(and
					(== temp14 temp15)
					(== temp10 temp11)
					(== temp12 temp13)
					(!= temp8 temp9)
				)
				(= temp8 (= temp9 (- 13 (+ temp14 temp10 temp12))))
			)
		)
		(self calcPoints:)
		(self calcPoints:)
		(= temp28 (global431 points:))
		(= temp29 (curPlyr points:))
		(= temp37 0)
		(cond
			(
				(and
					(== param2 14)
					(temp30 maxPoints:)
					(<
						4
						(-
							40
							(+
								combinedHCP
								(temp30 minPoints:)
								(self RHOPoints:)
							)
						)
					)
				)
				(= temp36 100)
			)
			(
				(and
					(== param2 14)
					(temp30 maxPoints:)
					(<
						4
						(-
							40
							(+
								combinedHCP
								(temp31 minPoints:)
								(self LHOPoints:)
							)
						)
					)
				)
				(= temp36 0)
			)
			(
				(and
					(== param2 13)
					(temp30 maxPoints:)
					(<
						3
						(-
							40
							(+
								combinedHCP
								(temp30 minPoints:)
								(self RHOPoints:)
							)
						)
					)
				)
				(= temp36 100)
			)
			(
				(and
					(== param2 13)
					(temp30 maxPoints:)
					(<
						3
						(-
							40
							(+
								combinedHCP
								(temp31 minPoints:)
								(self LHOPoints:)
							)
						)
					)
				)
				(= temp36 0)
			)
			(
				(and
					(== param2 12)
					(temp30 maxPoints:)
					(<
						2
						(-
							40
							(+
								combinedHCP
								(temp30 minPoints:)
								(self RHOPoints:)
							)
						)
					)
				)
				(= temp36 100)
			)
			(
				(and
					(== param2 12)
					(temp30 maxPoints:)
					(<
						2
						(-
							40
							(+
								combinedHCP
								(temp31 minPoints:)
								(self LHOPoints:)
							)
						)
					)
				)
				(= temp36 0)
			)
			(
				(and
					(== param2 11)
					(temp30 maxPoints:)
					(<
						1
						(-
							40
							(+
								combinedHCP
								(temp30 minPoints:)
								(self RHOPoints:)
							)
						)
					)
				)
				(= temp36 100)
			)
			(
				(and
					(== param2 11)
					(temp30 maxPoints:)
					(<
						1
						(-
							40
							(+
								combinedHCP
								(temp31 minPoints:)
								(self LHOPoints:)
							)
						)
					)
				)
				(= temp36 0)
			)
			((or (== param2 14) (== param2 13) (== param2 12) (== param2 11))
				(= temp36
					(/
						(* 100 (+ (temp30 minPoints:) (temp30 maxPoints:)))
						(+
							(temp30 minPoints:)
							(temp30 maxPoints:)
							(temp31 minPoints:)
							(temp31 maxPoints:)
						)
					)
				)
			)
			(else
				(switch param1
					(1
						(if (== temp0 temp4)
							(= temp37 (/ (* 100 temp0) (+ temp0 temp8)))
						else
							(= temp37
								(/
									(* 100 (+ temp0 temp4))
									(+ temp0 temp4 temp8 temp9)
								)
							)
						)
					)
					(2
						(if (== temp1 temp5)
							(= temp37 (/ (* 100 temp1) (+ temp1 temp10)))
						else
							(= temp37
								(/
									(* 100 (+ temp1 temp5))
									(+ temp1 temp5 temp10 temp11)
								)
							)
						)
					)
					(300
						(if (== temp2 temp6)
							(= temp37 (/ (* 100 temp2) (+ temp2 temp12)))
						else
							(= temp37
								(/
									(* 100 (+ temp2 temp6))
									(+ temp2 temp6 temp12 temp13)
								)
							)
						)
					)
					(300
						(if (== temp3 temp7)
							(= temp37 (/ (* 100 temp3) (+ temp3 temp14)))
						else
							(= temp37
								(/
									(* 100 (+ temp3 temp7))
									(+ temp3 temp7 temp14 temp15)
								)
							)
						)
					)
				)
			)
		)
		(cond
			((or (== temp37 0) (== temp37 100))
				(self LHOChance: temp37)
			)
			((or (== temp36 0) (== temp36 100))
				(self LHOChance: temp36)
			)
			(else
				(self LHOChance: (/ (+ temp37 temp36) 2))
			)
		)
	)

	(method (calcPoints &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp5 (self LHO:))
		(= temp6 (self RHO:))
		(for ((= temp2 (= temp0 (= temp1 0)))) (< temp2 13) ((++ temp2))
			(= temp3 (global431 at: temp2))
			(= temp4 (curPlyr at: temp2))
			(switch (temp3 rank:)
				(14
					(+= temp0 4)
				)
				(13
					(+= temp0 3)
				)
				(12
					(+= temp0 2)
				)
				(11
					(+= temp0 1)
				)
			)
			(switch (temp4 rank:)
				(14
					(+= temp1 4)
				)
				(13
					(+= temp1 3)
				)
				(12
					(+= temp1 2)
				)
				(11
					(+= temp1 1)
				)
			)
		)
		(for
			((= temp2 (= temp7 0)))
			(< temp2 ((temp5 playedList:) size:))
			((++ temp2))
			
			(= temp3 (temp5 at: temp2))
			(switch (temp3 rank:)
				(14
					(+= temp7 4)
				)
				(13
					(+= temp7 3)
				)
				(12
					(+= temp7 2)
				)
				(11
					(+= temp7 1)
				)
			)
		)
		(for
			((= temp2 (= temp8 0)))
			(< temp2 ((temp6 playedList:) size:))
			((++ temp2))
			
			(= temp3 (temp6 at: temp2))
			(switch (temp3 rank:)
				(14
					(+= temp8 4)
				)
				(13
					(+= temp8 3)
				)
				(12
					(+= temp8 2)
				)
				(11
					(+= temp8 1)
				)
			)
		)
		(self LHOPoints: temp7)
		(self RHOPoints: temp8)
		(if (> (temp5 maxPoints:) (+ temp1 temp0 temp8))
			(temp5 maxPoints: (- 40 (+ temp1 temp0 temp8)))
		)
		(if (> (temp6 maxPoints:) (+ temp1 temp0 temp7))
			(temp6 maxPoints: (- 40 (+ temp1 temp0 temp7)))
		)
		(if (> temp7 (temp5 minPoints:))
			(temp5 minPoints: temp7)
		)
		(if (> temp8 (temp6 minPoints:))
			(temp6 minPoints: temp8)
		)
		(if (> (temp5 minPoints:) (temp5 maxPoints:))
			(temp5 maxPoints: (temp5 minPoints:))
		)
		(if (> (temp6 minPoints:) (temp6 maxPoints:))
			(temp6 maxPoints: (temp6 minPoints:))
		)
		(if (== 40 (+ temp0 temp1 temp7 temp8))
			(temp5 maxPoints: 0)
			(temp6 maxPoints: 0)
		)
		(= combinedHCP (+ temp0 temp1))
		(= missingHCP (- 40 combinedHCP))
	)
)

