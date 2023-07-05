;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 284)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	claract3 0
)

(local
	local0
	[local1 20] = [284 0 284 0 284 1 284 1 284 2 284 3 284 4 284 5 284 6 284 7]
	[local21 11] = [0 0 0 0 64 64 64 64 64 64 -1]
	[local32 4] = [0 1 2 3]
	local36 = 4
	[local37 6] = [5 6 7 8 9 10]
)

(instance claract3 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 284)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local32 (- global212 1)]))
					(< temp2 [local32 global212])
					((++ temp2))
					
					(if
						(or
							(== global211 [local21 temp2])
							(== [local21 temp2] 0)
						)
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(if (!= local0 local36)
						(global209 claimed: 1)
						(Print [local1 temp1] [local1 (++ temp1)])
					else
						(proc243_1 local0 [local1 temp1] [local1 (++ temp1)])
					)
				)
			)
		)
		(client setScript: 0)
	)
)

