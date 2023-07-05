;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 247)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	WilbAct2 0
)

(local
	local0
	[local1 136] = [247 0 247 1 247 2 247 3 247 4 247 5 247 6 247 7 247 8 247 9 247 10 247 11 247 12 247 13 247 14 247 15 247 16 247 17 247 18 247 19 247 20 247 21 247 22 247 23 247 24 247 25 247 26 247 27 247 28 247 29 247 30 247 31 247 32 247 33 247 34 247 35 247 36 247 37 247 38 247 39 247 40 247 41 247 42 247 43 247 44 247 45 247 46 247 47 247 48 247 49 247 50 247 51 247 52 247 53 247 54 247 55 247 56 247 57 247 58 247 59 247 60 247 61 247 62 247 63 247 64 247 65 247 65 247 66]
	[local137 69] = [8256 10240 8320 2 64 65 68 512 528 8 16 0 1 4 1024 32 34 40 256 260 272 8208 8200 16388 16392 16400 16416 16448 16512 8256 10240 8320 2 64 65 68 512 528 8 16 1 4 1024 0 32 34 40 256 272 260 8208 8200 16388 16392 16400 16416 16448 16512 8208 16392 8208 16392 128 128 128 128 128 128 -1]
	[local206 5] = [0 29 58 60 62]
	local211 = 63
	[local212 5] = [64 64 65 66 67]
)

(instance WilbAct2 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 247)
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
					(if (== global212 1)
						(switch global211
							(8320
								(SetFlag 15)
							)
							(4
								(SetFlag 24)
							)
						)
					)
				)
			)
		)
		(client setScript: 0)
	)
)

