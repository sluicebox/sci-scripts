;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 405)
(include sci.sh)
(use Main)

(public
	proc405_0 0
)

(procedure (proc405_0 param1 &tmp temp0 temp1 temp2 temp3)
	(= global859 param1)
	(global859 clearMarks:)
	(for ((= temp1 0)) (< temp1 4) ((++ temp1))
		(= temp3
			(switch temp1
				(0
					((global859 caller:) spadesList:)
				)
				(1
					((global859 caller:) clubsList:)
				)
				(2
					((global859 caller:) diamondsList:)
				)
				(3
					((global859 caller:) heartsList:)
				)
			)
		)
		(for ((= temp2 0)) (< temp2 (- (temp3 size:) 2)) ((++ temp2))
			(localproc_0 temp3 temp2)
		)
	)
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(for ((= temp1 3)) (<= temp1 (- (param1 size:) param2)) ((++ temp1))
		(= temp2 (param1 atRank: param2))
		(= temp3 1)
		(for ((= temp0 (+ param2 1))) (< temp0 (+ param2 temp1)) ((++ temp0))
			(if
				(not
					(and
						temp3
						(== (- (param1 atRank: temp0) (- temp0 param2)) temp2)
					)
				)
				(= temp3 0)
				(break)
			)
		)
		(if temp3
			(= temp0 param2)
			(= temp4 0)
			(while (< temp0 (+ param2 temp1))
				(if ((param1 at: temp0) inARun:)
					(++ temp4)
				)
				(++ temp0)
			)
			(for ((= temp0 (= temp5 0))) (< temp0 (param1 size:)) ((++ temp0))
				(if ((param1 at: temp0) inARun:)
					(++ temp5)
				)
			)
			(= temp6 0)
			(if temp5
				(if (not temp4)
					(= temp6 10)
					(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
						(if (> ((param1 at: temp0) inARun:) 10)
							(= temp6 20)
							(break)
						)
					)
				else
					(if (< (= temp6 ((param1 at: param2) inARun:)) 10)
						(= temp6 0)
					)
					(cond
						((> temp6 20)
							(= temp6 20)
						)
						((> temp6 10)
							(= temp6 10)
						)
					)
				)
			)
			(for ((= temp0 param2)) (< temp0 (+ param2 temp1)) ((++ temp0))
				((param1 at: temp0)
					inARun: (+ ((param1 at: 0) cardSuit:) 1 temp6)
				)
				(if (and (== temp0 (- (+ param2 temp1) 1)) (>= temp1 4))
					((param1 at: temp0) fourOrMoreInGroup: 1)
				)
			)
		)
	)
)

