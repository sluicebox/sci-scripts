;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 218)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	ClarAct1 0
)

(local
	local0
	[local1 140] = [218 0 218 1 218 2 218 3 218 4 218 5 218 6 218 7 218 8 218 9 218 10 218 11 218 12 218 13 218 14 218 15 218 16 218 17 218 18 218 19 218 20 218 21 218 22 218 23 218 24 218 25 218 26 218 27 218 28 218 29 218 30 218 31 218 32 218 33 218 34 218 35 218 36 218 37 218 38 218 16 218 39 218 40 218 41 218 42 218 43 218 44 218 45 218 46 218 47 218 48 218 49 218 50 218 51 218 52 218 53 218 54 218 55 218 56 218 57 218 58 218 59 218 60 218 61 218 62 218 63 218 64 218 65 218 66 218 67 218 68]
	[local141 71] = [8256 10240 8320 0 2 512 528 8 16 1 4 1024 32 34 40 256 260 272 8208 0 128 0 8200 16388 8194 16392 16400 16416 16448 16512 8256 10240 8320 2 512 528 0 8 16 1 4 1024 32 40 256 260 8208 128 0 8200 16388 8194 16392 16400 16416 16448 16512 8208 8194 16392 8208 0 8194 16392 64 64 64 64 64 64 -1]
	[local212 5] = [0 30 57 60 64]
	local217 = 65
	[local218 5] = [66 67 68 69 70]
)

(instance ClarAct1 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 218)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local212 (- global212 1)]))
					(< temp2 [local212 global212])
					((++ temp2))
					
					(if (== global211 [local141 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(cond
						((>= local0 local217)
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
								(== [local141 (++ temp2)] 0)
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

