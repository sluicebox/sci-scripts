;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 295)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	LillAct4 0
)

(local
	local0
	[local1 178] = [295 0 295 1 295 2 295 3 295 4 295 5 295 6 295 7 295 8 295 9 295 10 295 11 295 12 295 13 295 14 295 15 295 16 295 17 295 18 295 19 295 20 295 21 295 22 295 23 295 24 295 25 295 26 295 27 295 28 295 29 295 30 295 31 295 32 295 33 295 34 295 35 295 36 295 37 295 38 295 39 295 40 295 41 295 42 295 43 295 44 295 45 295 46 295 47 295 48 295 49 295 50 295 51 295 52 295 53 295 54 295 55 295 56 295 57 295 58 295 59 295 60 295 61 295 62 295 63 295 64 295 65 295 66 295 67 295 68 295 69 295 70 295 71 295 72 295 73 295 74 295 75 295 76 295 77 295 78 295 79 295 80 295 81 295 82 295 83 295 84 295 85 295 86 295 87 295 88]
	[local179 90] = [8256 10240 8320 8196 2 9216 0 64 65 68 320 192 512 528 8 16 1 4 1024 12288 256 260 272 0 16385 8208 128 8200 16388 16392 8194 16400 16416 16448 16512 8256 10240 0 8320 8196 2 9216 64 65 68 320 192 512 528 8 16 1 4 1024 12288 256 272 260 16385 8208 128 8200 0 16388 16392 8194 16400 16416 16448 16512 8196 0 9216 0 12288 8208 16392 8194 8196 9216 12288 8208 16392 8194 32 32 32 32 32 -1]
	[local269 5] = [0 35 70 78 84]
	local274 = 85
	[local275 4] = [86 87 88 89]
)

(instance LillAct4 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 295)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local269 (- global212 1)]))
					(< temp2 [local269 global212])
					((++ temp2))
					
					(if (== global211 [local179 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(cond
						((>= local0 local274)
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
								(== [local179 (++ temp2)] 0)
							)
							(proc0_23 [local1 (++ temp1)] [local1 (++ temp1)])
						)
					)
					(if (== global212 1)
						(switch global211
							(1024
								(SetFlag 22)
							)
							(256
								(SetFlag 15)
							)
						)
					)
				)
			)
		)
		(client setScript: 0)
	)
)

