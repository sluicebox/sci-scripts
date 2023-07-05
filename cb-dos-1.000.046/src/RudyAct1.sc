;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 222)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	RudyAct1 0
)

(local
	local0
	[local1 144] = [222 0 222 1 222 2 222 3 222 4 222 5 222 6 222 7 222 8 222 9 222 10 222 11 222 12 222 13 222 14 222 15 222 16 222 17 222 18 222 19 222 20 222 21 222 22 222 23 222 24 222 25 222 26 222 27 222 28 222 29 222 30 222 31 222 32 222 33 222 34 222 35 222 36 222 37 222 38 222 39 222 40 222 41 222 42 222 43 222 44 222 45 222 46 222 47 222 48 222 49 222 50 222 51 222 52 222 53 222 54 222 55 222 56 222 57 222 58 222 59 222 60 222 61 222 62 222 63 222 64 222 65 222 66 222 67 222 68 222 69 222 69 222 70]
	[local145 73] = [8256 10240 8320 2 64 65 68 192 512 528 8 16 1 4 1024 32 34 40 8208 0 128 8200 0 16388 16392 8194 16400 16416 16448 16512 8256 10240 8320 2 64 0 65 68 192 512 528 8 16 1 4 1024 32 34 40 8208 128 8200 0 16388 16392 8194 16400 16416 16448 16512 8208 16392 8194 8208 16392 8194 256 256 256 256 256 256 -1]
	[local218 5] = [0 30 60 63 66]
	local223 = 67
	[local224 5] = [68 69 70 71 72]
)

(instance RudyAct1 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 222)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local218 (- global212 1)]))
					(< temp2 [local218 global212])
					((++ temp2))
					
					(if (== global211 [local145 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(cond
						((>= local0 local223)
							(global209 claimed: 1)
							(Print [local1 temp1] [local1 (++ temp1)])
						)
						(
							(and
								(not
									(proc243_1
										local0
										[local1 temp1]
										[local1 (++ temp1)]
									)
								)
								(== [local145 (++ temp2)] 0)
							)
							(proc0_23 [local1 (++ temp1)] [local1 (++ temp1)])
						)
					)
				)
			)
		)
		(client setScript: 0)
	)
)

