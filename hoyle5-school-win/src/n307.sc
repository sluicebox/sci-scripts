;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 307)
(include sci.sh)
(use Main)

(public
	proc307_0 0
)

(procedure (proc307_0 param1 &tmp temp0 temp1 temp2)
	(= global501 param1)
	(= temp0 0)
	(if (localproc_0)
		(for ((= temp1 0)) (< temp1 4) ((++ temp1))
			(if
				(and
					(!= (= temp2 (gTheHands at: temp1)) global501)
					(temp2 outOf: global528)
				)
				(++ temp0)
			)
		)
		(if
			(and
				(== temp0 (- global527 1))
				(or (== global498 (global501 cardList:)) (not global498))
			)
			(for ((= temp1 0)) (< temp1 4) ((++ temp1))
				(if (!= (= temp2 (gTheHands at: temp1)) (gTheHands at: 0))
					(temp2 takeAllPlayer: (global501 cardList:) obvious: 1)
				)
			)
		else
			(return 0)
		)
	)
)

(procedure (localproc_0 &tmp temp0 temp1)
	(= temp0 0)
	(if ((gTheHands at: 0) tempTotal:)
		(= temp1 (gTheHands at: 0))
		(++ temp0)
	)
	(if ((gTheHands at: 1) tempTotal:)
		(= temp1 (gTheHands at: 1))
		(++ temp0)
	)
	(if ((gTheHands at: 2) tempTotal:)
		(= temp1 (gTheHands at: 2))
		(++ temp0)
	)
	(if ((gTheHands at: 3) tempTotal:)
		(= temp1 (gTheHands at: 3))
		(++ temp0)
	)
	(= global498 0)
	(if (== temp0 1)
		(= global498 temp1)
	)
	(if (or (not temp0) (and (== temp0 1) (not global530)))
		(return 1)
	)
	(if (and (== temp0 1) global530 (== global501 temp1))
		(return 1)
	)
	(return 0)
)

