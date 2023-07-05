;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 758)
(include sci.sh)
(use bidBoxWindow)

(public
	proc758_0 0
)

(procedure (proc758_0 param1 param2 param3 &tmp temp0 temp1) ; UNUSED
	(if (BidBox size:)
		(= temp0 0)
		(= temp1 0)
		(while (< temp0 (BidBox size:))
			(cond
				(
					(and
						(== param1 ((BidBox at: temp0) suit:))
						(or (< argc 3) (not param3))
						(or
							(< argc 2)
							(not param2)
							(and
								param2
								(==
									(param2 location:)
									((BidBox at: temp0) location:)
								)
							)
						)
					)
					(++ temp1)
				)
				(
					(and
						(== param1 ((BidBox at: temp0) suit:))
						(== param3 ((BidBox at: temp0) level:))
					)
					(++ temp1)
					(= temp0 (BidBox size:))
				)
			)
			(++ temp0)
		)
	else
		(= temp1 0)
	)
	(return temp1)
)

