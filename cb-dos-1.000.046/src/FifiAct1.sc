;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 227)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	FifiAct1 0
)

(local
	local0
	[local1 140] = [227 0 227 1 227 2 227 3 227 4 227 5 227 6 227 7 227 8 227 9 227 10 227 11 227 12 227 13 227 14 227 15 227 16 227 17 227 18 227 19 227 20 227 21 227 22 227 23 227 24 227 25 227 26 227 27 227 28 227 29 227 30 227 31 227 32 227 33 227 34 227 35 227 36 227 37 227 38 227 39 227 40 227 41 227 42 227 43 227 44 227 45 227 46 227 47 227 48 227 49 227 50 227 51 227 52 227 53 227 54 227 55 227 56 227 57 227 58 227 59 227 60 227 61 227 62 227 63 227 64 227 65 227 66 227 67 227 68 227 69]
	[local141 71] = [8256 10240 0 8320 2 64 65 68 192 512 8 1 4 1024 32 34 40 256 260 8208 0 128 8200 16388 8194 16392 16400 16416 16448 16512 8256 10240 8320 2 64 65 68 192 512 1 4 1024 32 34 40 0 256 260 8208 128 8200 16388 8194 16392 16400 16416 16448 16512 8208 0 8194 16392 8208 8194 16392 16 16 16 16 16 -1]
	[local212 5] = [0 30 58 62 65]
	local217 = 66
	[local218 4] = [67 68 69 70]
)

(instance FifiAct1 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 227)
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

