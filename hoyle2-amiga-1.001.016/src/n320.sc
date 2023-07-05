;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)

(public
	proc320_0 0
)

(procedure (proc320_0 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
		(if (= temp1 ((param1 at: temp0) lastCard:))
			(if (== (= temp2 (param2 rank:)) 1)
				(= temp2 14)
			)
			(if (== (= temp3 (temp1 rank:)) 1)
				(= temp3 14)
			)
			(if (and (== (param2 suit:) (temp1 suit:)) (< temp2 temp3))
				(return 1)
			)
		)
	)
	(return 0)
)

