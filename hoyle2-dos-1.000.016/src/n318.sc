;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 318)
(include sci.sh)
(use Main)
(use PlayDealer)

(public
	proc318_0 0
	proc318_1 1
)

(procedure (proc318_0 param1 &tmp temp0 temp1 temp2 temp3 temp4)
	(return
		(if (not (gTheDealer currentlyActive:))
			(proc318_1 param1)
			(= temp2 -1)
			(= temp1 13)
			(if (>= (param1 size:) 13)
				(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
					(if ((param1 at: temp0) faceUp:)
						(= temp3 0)
						(switch 390
							(3
								(if (== ((param1 at: temp0) rank:) 13)
									(= temp2 ((param1 at: temp0) suit:))
									(= temp4 temp0)
								)
								(if (== temp2 ((param1 at: temp0) suit:))
									(= temp3 1)
								)
							)
							(else
								(if (== ((param1 at: temp0) rank:) 13)
									(= temp4 temp0)
								)
								(= temp3 1)
							)
						)
						(if (== temp2 -1)
							(= temp3 1)
						)
						(if (and temp3 (== ((param1 at: temp0) rank:) temp1))
							(if (not (-- temp1))
								(break)
							)
						else
							(= temp2 -1)
							(= temp1 13)
							(if (== ((param1 at: temp0) rank:) 13)
								(= temp1 12)
							)
						)
					)
				)
				(if temp1
					(return 0)
				)
			else
				(return 0)
			)
			(if (proc0_6 108)
				(return 1)
			)
			(proc0_2)
			(Wait 20)
			(for ((= temp0 temp4)) (< temp0 (+ temp4 13)) ((++ temp0))
				((param1 at: temp0) dim:)
				(gTheWorkingDeck add: (param1 at: temp0))
			)
			(param1 showUpdate:)
			(proc0_2)
			(Wait 20)
			(param1 giveUpCards:)
			(proc0_2)
			(++ global402)
		)
	)
)

(procedure (proc318_1 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
	(if
		(or
			(not (PlayDealer currentlyActive:))
			(== (gTheColumns at: (- (gTheColumns size:) 1)) param1)
		)
		(= temp7 global400)
		(for ((= temp2 (= global400 0))) (< temp2 global403) ((++ temp2))
			(if (>= ((gTheColumns at: temp2) numFaceUp:) 2)
				(= temp1 ((gTheColumns at: temp2) firstFaceUp: 1))
				(= temp8 1)
				(while (< temp1 (- ((gTheColumns at: temp2) size:) 1))
					(= temp3 (((gTheColumns at: temp2) at: temp1) rank:))
					(= temp5 (((gTheColumns at: temp2) at: (+ temp1 1)) rank:))
					(cond
						((== ((gTheColumns at: temp2) buildManner:) 3)
							(= temp4 (((gTheColumns at: temp2) at: temp1) suit:))
							(= temp6
								(((gTheColumns at: temp2) at: (+ temp1 1)) suit:)
							)
							(if (and (== temp4 temp6) (== temp3 (+ temp5 1)))
								(++ global400)
								(if temp8
									(++ global400)
									(= temp8 0)
								)
							else
								(= temp8 1)
							)
						)
						((== temp3 (+ temp5 1))
							(++ global400)
							(if temp8
								(++ global400)
								(= temp8 0)
							)
						)
						(else
							(= temp8 1)
						)
					)
					(++ temp1)
				)
			)
		)
		(if (!= (+= global400 (* 13 global402)) temp7)
			(proc0_4)
		)
	)
)

