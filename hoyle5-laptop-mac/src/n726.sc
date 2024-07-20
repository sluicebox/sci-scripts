;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 726)
(include sci.sh)
(use Main)
(use SortArray)

(public
	proc726_0 0
)

(procedure (proc726_0 &tmp temp0 temp1 temp2)
	(for ((= temp1 0)) (< temp1 13) ((++ temp1))
		(= [global136 temp1] 0)
		(= [global123 temp1] 0)
		(= [global149 temp1] 0)
		(= [global162 temp1] 0)
	)
	(for ((= temp1 0)) (<= temp1 13) ((++ temp1))
		(if (= temp2 (global429 at: temp1))
			(switch (temp2 suit:)
				(4
					(= [global123 (SortArray isCurrent: temp2)] 1)
				)
				(3
					(= [global136 (SortArray isCurrent: temp2)] 1)
				)
				(2
					(= [global149 (SortArray isCurrent: temp2)] 1)
				)
				(1
					(= [global162 (SortArray isCurrent: temp2)] 1)
				)
			)
		)
		(if (= temp2 (global431 at: temp1))
			(switch (temp2 suit:)
				(4
					(= [global123 (SortArray isCurrent: temp2)] 2)
				)
				(3
					(= [global136 (SortArray isCurrent: temp2)] 2)
				)
				(2
					(= [global149 (SortArray isCurrent: temp2)] 2)
				)
				(1
					(= [global162 (SortArray isCurrent: temp2)] 2)
				)
			)
		)
		(if (= temp2 ((global429 LHO:) at: temp1))
			(switch (temp2 suit:)
				(4
					(= [global123 (SortArray isCurrent: temp2)] 3)
				)
				(3
					(= [global136 (SortArray isCurrent: temp2)] 3)
				)
				(2
					(= [global149 (SortArray isCurrent: temp2)] 3)
				)
				(1
					(= [global162 (SortArray isCurrent: temp2)] 3)
				)
			)
		)
		(if (= temp2 ((global429 RHO:) at: temp1))
			(switch (temp2 suit:)
				(4
					(= [global123 (SortArray isCurrent: temp2)] 4)
				)
				(3
					(= [global136 (SortArray isCurrent: temp2)] 4)
				)
				(2
					(= [global149 (SortArray isCurrent: temp2)] 4)
				)
				(1
					(= [global162 (SortArray isCurrent: temp2)] 4)
				)
			)
		)
	)
)

