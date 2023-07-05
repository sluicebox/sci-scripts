;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 252)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	RudyAct2 0
)

(local
	local0
	[local1 140] = [252 0 252 1 252 2 252 3 252 4 252 5 252 6 252 7 252 8 252 9 252 10 252 11 252 12 252 13 252 14 252 15 252 16 252 17 252 18 252 19 252 20 252 21 252 22 252 23 252 24 252 25 252 26 252 27 252 28 252 29 252 30 252 31 252 32 252 33 252 34 252 35 252 36 252 37 252 38 252 39 252 40 252 41 252 42 252 43 252 44 252 45 252 46 252 47 252 48 252 49 252 50 252 51 252 52 252 53 252 54 252 55 252 56 252 57 252 58 252 59 252 60 252 61 252 62 252 63 252 64 252 65 252 66 252 67 252 67 252 68]
	[local141 71] = [8256 0 10240 0 8320 2 64 65 68 192 512 528 8 16 1 4 1024 0 32 34 40 8208 128 8200 0 16388 16392 8194 16400 16416 16448 16512 8256 10240 8320 2 64 65 512 528 8 16 1 4 1024 32 34 40 8208 128 8200 16388 16392 8194 16400 16416 16448 16512 8208 16392 8194 8208 16392 8194 256 256 256 256 256 256 -1]
	[local212 5] = [0 32 58 61 64]
	local217 = 65
	[local218 5] = [66 67 68 69 70]
)

(instance RudyAct2 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 252)
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

