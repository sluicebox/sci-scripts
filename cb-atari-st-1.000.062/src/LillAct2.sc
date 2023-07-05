;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 251)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	LillAct2 0
)

(local
	local0
	[local1 140] = [251 0 251 1 251 2 251 3 251 4 251 5 251 6 251 7 251 8 251 9 251 10 251 11 251 12 251 13 251 14 251 15 251 16 251 17 251 18 251 19 251 20 251 21 251 22 251 23 251 24 251 25 251 26 251 27 251 28 251 29 251 30 251 31 251 32 251 33 251 34 251 35 251 36 251 37 251 38 251 39 251 40 251 41 251 42 251 43 251 44 251 45 251 46 251 47 251 48 251 49 251 50 251 51 251 52 251 53 251 54 251 55 251 56 251 57 251 58 251 59 251 60 251 61 251 62 251 63 251 64 251 65 251 66 251 67 251 68 251 69]
	[local141 71] = [8256 0 10240 8320 0 2 64 65 68 192 512 528 8 16 1 4 1024 256 260 272 8208 128 8200 16388 16392 8194 16400 16416 16448 16512 8256 10240 8320 2 64 65 68 192 512 528 8 16 1 4 1024 256 272 260 8208 0 128 8200 16388 16392 8194 16400 16416 16448 16512 8208 16392 8194 8208 16392 8194 32 32 32 32 32 -1]
	[local212 5] = [0 30 59 62 65]
	local217 = 66
	[local218 4] = [67 68 69 70]
)

(instance LillAct2 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 251)
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

