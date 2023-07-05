;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 219)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	WilbAct1 0
)

(local
	local0
	[local1 136] = [219 0 219 1 219 2 219 3 219 4 219 5 219 6 219 7 219 8 219 9 219 10 219 11 219 12 219 13 219 14 219 15 219 16 219 17 219 18 219 19 219 20 219 21 219 22 219 23 219 24 219 25 219 26 219 27 219 28 219 29 219 30 219 31 219 32 219 33 219 34 219 35 219 36 219 37 219 38 219 39 219 40 219 41 219 42 219 43 219 44 219 45 219 46 219 47 219 48 219 49 219 50 219 51 219 52 219 53 219 54 219 55 219 56 219 57 219 58 219 59 219 60 219 61 219 62 219 63 219 64 219 65 219 65 219 66]
	[local137 69] = [8256 10240 8320 2 64 65 68 512 528 8 16 1 4 1024 32 34 0 40 256 260 272 8208 8200 16388 16392 16400 16416 16448 16512 8256 10240 8320 2 64 65 68 512 528 8 16 1 4 1024 32 34 40 256 260 0 272 8208 8200 16388 16392 16400 16416 16448 16512 8208 16392 8208 16392 128 128 128 128 128 128 -1]
	[local206 5] = [0 29 58 60 62]
	local211 = 63
	[local212 5] = [64 65 66 67 68]
)

(instance WilbAct1 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 219)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local206 (- global212 1)]))
					(< temp2 [local206 global212])
					((++ temp2))
					
					(if (== global211 [local137 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(cond
						((>= local0 local211)
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
								(== [local137 (++ temp2)] 0)
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

