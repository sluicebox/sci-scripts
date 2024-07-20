;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 725)
(include sci.sh)
(use System)

(local
	[local0 75]
)

(class SortArray of Code
	(properties
		sequence 0
	)

	(method (init &tmp temp0)
		(for ((= temp0 0)) (< temp0 75) ((++ temp0))
			(= [local0 temp0] 0)
		)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (isCurrent param1 &tmp temp0 temp1)
		(= temp1 -1)
		(for
			((= temp0 (+ (* 15 (param1 suit:)) 14)))
			(>= temp0 (+ (* 15 (param1 suit:)) (param1 rank:)))
			((-- temp0))
			
			(if (== [local0 temp0] 0)
				(++ temp1)
			)
		)
		(return temp1)
	)

	(method (checkCard param1)
		(if (== [local0 (+ (* 15 (param1 suit:)) (param1 rank:))] 1)
			(return 1)
		else
			(return 0)
		)
	)

	(method (discarded param1)
		(= [local0 (+ (* (param1 suit:) 15) (param1 rank:))] 1)
	)

	(method (clearOut &tmp temp0)
		(for ((= temp0 0)) (< temp0 75) ((++ temp0))
			(= [local0 temp0] 0)
		)
	)

	(method (nHighest param1 param2 &tmp temp0 [temp1 2] temp3)
		(= temp0 (+ (* 15 param1) 14))
		(= temp3 0)
		(while (>= temp0 2)
			(if (and (== [local0 temp0] 0) (>= temp0 2) (== (++ temp3) param2))
				(return temp0)
			)
			(-- temp0)
		)
		(return 0)
	)

	(method (lowestUnplayed param1 &tmp temp0)
		(for
			((= temp0 (+ (* 15 param1) 2)))
			(<= temp0 (+ (* 15 param1) 14))
			((++ temp0))
			
			(if [local0 temp0]
				(return (- temp0 (* 15 param1)))
			)
		)
		(return 0)
	)
)

