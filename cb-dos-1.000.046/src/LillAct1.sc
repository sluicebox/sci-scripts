;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 226)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	LillAct1 0
)

(local
	local0
	[local1 140] = [226 0 226 1 226 2 226 3 226 4 226 5 226 6 226 7 226 8 226 9 226 10 226 11 226 12 226 13 226 14 226 15 226 16 226 17 226 18 226 19 226 20 226 21 226 22 226 23 226 24 226 25 226 26 226 27 226 28 226 29 226 30 226 31 226 32 226 33 226 34 226 35 226 36 226 37 226 38 226 39 226 40 226 41 226 42 226 43 226 44 226 45 226 46 226 47 226 48 226 49 226 50 226 51 226 52 226 53 226 54 226 55 226 56 226 57 226 58 226 59 226 60 226 61 226 62 226 63 226 64 226 65 226 66 226 67 226 68 226 69]
	[local141 71] = [8256 10240 8320 2 64 65 68 192 512 528 8 0 16 1 4 1024 256 260 272 8208 0 128 8200 16388 16392 8194 16400 16416 16448 16512 8256 10240 8320 2 0 64 65 68 192 512 528 8 16 1 4 1024 256 272 260 8208 128 8200 16388 16392 8194 16400 16416 16448 16512 8208 16392 8194 8208 16392 8194 32 32 32 32 32 -1]
	[local212 5] = [0 30 59 62 65]
	local217 = 66
	[local218 4] = [67 68 69 70]
)

(instance LillAct1 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 226)
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
					(if (and (== global212 1) (== global211 64))
						(SetFlag 18)
					)
				)
			)
		)
		(client setScript: 0)
	)
)

