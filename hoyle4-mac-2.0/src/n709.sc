;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 709)
(include sci.sh)
(use BScore)
(use Bid)
(use System)

(public
	proc709_0 0
	proc709_1 1
	proc709_2 2
	proc709_3 3
	proc709_4 4
	proc709_5 5
	proc709_6 6
	proc709_7 7
	proc709_8 8
	proc709_9 9
)

(procedure (proc709_0 param1 param2 &tmp temp0)
	(return (+ param1 (* (- param2 1) 5)))
)

(procedure (proc709_2 param1 param2 &tmp temp0 temp1 temp2)
	(if (BidBox size:)
		(= temp0 0)
		(= temp1 0)
		(while (< temp0 (BidBox size:))
			(if
				(and
					(== param1 ((= temp2 (BidBox at: temp0)) suit:))
					(not (temp2 artificial:))
					(or
						(< argc 2)
						(not param2)
						(and
							(IsObject param2)
							(==
								(param2 location:)
								((BidBox at: temp0) location:)
							)
						)
					)
				)
				(++ temp1)
			)
			(++ temp0)
		)
	else
		(= temp1 0)
	)
	(return temp1)
)

(procedure (proc709_1 param1 param2 &tmp temp0)
	(return
		(and
			(>= (= temp0 (param1 countSuit: param2)) 5)
			(>=
				(+ temp0 temp0 (param1 calcHCP: param2))
				(if (< param2 3) 14 else 16)
			)
		)
	)
)

(procedure (proc709_3 param1 param2 &tmp temp0)
	(return
		(and
			(>= (= temp0 (param1 countSuit: param2)) 4)
			(or (>= temp0 5) (param1 hasCard: param2 3852))
		)
	)
)

(procedure (proc709_4 param1 param2 param3 param4 param5 param6 param7 param8 param9 param10 param11)
	(if (== param2 1000)
		(param1
			minPoints: 0
			maxPoints: 37
			minClubs: 0
			maxClubs: 13
			minDiamonds: 0
			maxDiamonds: 13
			minHearts: 0
			maxHearts: 13
			minSpades: 0
			maxSpades: 13
		)
	else
		(if (and (!= param2 -1) (> param2 (param1 minPoints:)))
			(param1 minPoints: param2)
		)
		(if (and (!= param3 -1) (< param3 (param1 maxPoints:)))
			(param1 maxPoints: param3)
		)
		(if (and (!= param4 -1) (> param4 (param1 minClubs:)))
			(param1 minClubs: param4)
		)
		(if (!= param5 -1)
			(param1 maxClubs: param5)
		)
		(if (and (!= param6 -1) (> param6 (param1 minDiamonds:)))
			(param1 minDiamonds: param6)
		)
		(if (!= param7 -1)
			(param1 maxDiamonds: param7)
		)
		(if (and (!= param8 -1) (> param8 (param1 minHearts:)))
			(param1 minHearts: param8)
		)
		(if (!= param9 -1)
			(param1 maxHearts: param9)
		)
		(if (and (!= param10 -1) (> param10 (param1 minSpades:)))
			(param1 minSpades: param10)
		)
		(if (!= param11 -1)
			(param1 maxSpades: param11)
		)
	)
)

(procedure (proc709_5 param1 param2 param3 param4 param5 param6 &tmp temp0 temp1)
	(if (== argc 6)
		(= temp0 param5)
		(= temp1 param6)
	else
		(= temp0 (= temp1 -1))
	)
	(switch param2
		(1
			(proc709_4 param1 temp0 temp1 param3 param4 -1 -1 -1 -1 -1 -1)
		)
		(2
			(proc709_4 param1 temp0 temp1 -1 -1 param3 param4 -1 -1 -1 -1)
		)
		(3
			(proc709_4 param1 temp0 temp1 -1 -1 -1 -1 param3 param4 -1 -1)
		)
		(4
			(proc709_4 param1 temp0 temp1 -1 -1 -1 -1 -1 -1 param3 param4)
		)
	)
)

(procedure (proc709_6 param1 &tmp temp0)
	(= temp0 (BidBox at: (+ param1 (- (BidBox size:) (BidBox bidsSinceOpen:)))))
	(return (if (IsObject temp0) temp0 else 0))
)

(procedure (proc709_7 param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(if (OneOf (param1 location:) 1 3)
		(= temp0 (BScore weGamesWon:))
		(= temp1 (BScore theyGamesWon:))
	else
		(= temp1 (BScore weGamesWon:))
		(= temp0 (BScore theyGamesWon:))
	)
	(if (not temp1)
		(-- param3)
	)
	(if temp0
		(-- param3)
	)
	(if (or (< param3 12) (u< (param1 shape:) 28672))
		(= temp2 0)
	else
		(= temp4 0)
		(for ((= temp3 1)) (<= temp3 4) ((++ temp3))
			(if
				(and
					(= temp5
						(switch temp3
							(1
								(param1 clubs:)
							)
							(2
								(param1 diamonds:)
							)
							(3
								(param1 hearts:)
							)
							(4
								(param1 spades:)
							)
						)
					)
					(not (param1 hasCard: temp3 14))
				)
				(++ temp4)
				(if (and (>= temp5 2) (not (param1 hasCard: temp3 13)))
					(++ temp4)
				)
			)
		)
		(cond
			((< param3 15)
				(= temp2 3)
			)
			((<= param3 17)
				(= temp2 4)
			)
			((<= param3 22)
				(if (>= param2 3)
					(= temp2 4)
				else
					(= temp2 4)
				)
			)
			((and (>= param3 25) (not temp4))
				(= temp2 7)
			)
			((<= temp4 1)
				(= temp2 6)
			)
			((>= (= temp5 (- (- param3 12) temp4)) 6)
				(= temp2 (/ temp5 2))
				(if (not (<= 3 temp2 5))
					(= temp2 0)
				)
			)
			(else
				(= temp2 0)
			)
		)
	)
	(return temp2)
)

(procedure (proc709_8 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2)
	(if (param1 canBid: (proc709_0 param2 param4))
		(= temp0 (+ param4 param5))
	else
		(= temp0 (+ param4 param5 1))
	)
	(if (>= (= temp1 (proc709_7 param1 param2 param3)) temp0)
		(= temp2 (proc709_0 param2 temp1))
		(+= temp1 4)
		(proc709_4 param1 6 15 0 5 0 5 0 5 0 5)
		(proc709_5 param1 param2 temp1 11)
	else
		(= temp2 0)
	)
	(return temp2)
)

(procedure (proc709_9 param1 param2 param3 &tmp temp0)
	(for ((= temp0 4)) (>= temp0 1) ((-- temp0))
		(if (and (!= temp0 param2) (!= temp0 param3) (proc709_3 param1 temp0))
			(return temp0)
		)
	)
	(return 0)
)

