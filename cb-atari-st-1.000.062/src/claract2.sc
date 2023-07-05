;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 248)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	claract2 0
)

(local
	local0
	[local1 136] = [248 0 248 1 248 2 248 3 248 4 248 5 248 6 248 7 248 8 248 9 248 10 248 11 248 12 248 13 248 14 248 15 248 16 248 17 248 18 248 19 248 20 248 21 248 22 248 23 248 24 248 25 248 26 248 27 248 28 248 29 248 30 248 31 248 32 248 33 248 34 248 35 248 36 248 37 248 38 248 39 248 40 248 41 248 42 248 43 248 44 248 45 248 46 248 47 248 48 248 49 248 50 248 51 248 52 248 53 248 54 248 55 248 56 248 57 248 58 248 59 248 60 248 61 248 62 248 63 248 64 248 65 248 66 248 67]
	[local137 68] = [8256 10240 0 8320 2 512 528 8 16 1 4 1024 32 34 40 256 272 260 8208 128 8200 16388 8194 16392 16400 16416 16448 16512 8256 10240 8320 2 512 528 8 16 1 4 1024 32 34 40 256 272 260 8208 128 8200 16400 16416 16448 16512 16388 8194 16392 8208 8194 16392 8208 8194 16392 64 64 64 64 64 64 -1]
	[local205 5] = [0 28 55 58 61]
	local210 = 62
	[local211 5] = [63 64 65 66 67]
)

(instance claract2 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 248)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local205 (- global212 1)]))
					(< temp2 [local205 global212])
					((++ temp2))
					
					(if (== global211 [local137 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(if (and (== local0 36) (& gCorpseFlags $0001)) ; Gertie
						(= [local1 temp1] [local1 134])
						(= [local1 (+ temp1 1)] [local1 135])
					)
					(cond
						((>= local0 local210)
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

