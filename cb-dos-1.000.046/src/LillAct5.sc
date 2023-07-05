;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 372)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	LillAct5 0
)

(local
	local0
	[local1 186] = [372 0 372 1 372 2 372 3 372 4 372 5 372 6 372 7 372 8 372 9 372 10 372 11 372 12 372 13 372 14 372 15 372 16 372 17 372 18 372 19 372 20 372 21 372 22 372 23 372 24 372 25 372 26 372 27 372 28 372 29 372 30 372 31 372 32 372 33 372 34 372 35 372 36 372 37 372 38 372 39 372 40 372 41 372 42 372 43 372 44 372 45 372 46 372 47 372 48 372 49 372 50 372 51 372 52 372 53 372 54 372 55 372 56 372 57 372 58 372 59 372 60 372 61 372 62 372 63 372 64 372 65 372 66 372 67 372 68 372 69 372 70 372 71 372 72 372 73 372 74 372 75 372 76 372 77 372 78 372 79 372 80 372 81 372 82 372 83 372 84 372 85 372 86 372 87 372 88 372 89 372 90 372 91 372 92]
	[local187 90] = [8256 10240 8320 8196 2 9216 0 64 65 68 320 192 512 528 8 0 16 1 4 1024 1040 12288 256 260 272 16385 8208 128 8200 16388 16392 8194 16400 16416 16448 16512 8256 10240 8320 8196 2 9216 64 65 68 0 320 192 512 528 8 16 1 4 1024 1040 12288 256 272 260 16385 8208 128 8200 16388 16392 8194 16400 16416 16448 16512 8208 8196 9216 0 12288 16392 8194 8208 8196 9216 12288 16392 8194 32 32 32 32 32 -1]
	[local277 5] = [0 36 71 78 84]
	local282 = 85
	[local283 4] = [86 87 88 89]
)

(instance LillAct5 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 372)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local277 (- global212 1)]))
					(< temp2 [local277 global212])
					((++ temp2))
					
					(if (== global211 [local187 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(cond
						((and (== local0 52) (& gCorpseFlags $0001)) ; Gertie
							(= temp3 90)
						)
						((and (== local0 62) (& gCorpseFlags $0002)) ; Wilbur
							(= temp3 92)
						)
						((and (== local0 53) (& gCorpseFlags $0004)) ; Gloria
							(= temp3 91)
						)
						((and (== local0 50) (& gCorpseFlags $0008)) ; Ethel
							(= temp3 89)
						)
						(else
							(= temp3 0)
						)
					)
					(if temp3
						(= [local1 temp1] [local1 (*= temp3 2)])
						(= [local1 (+ temp1 1)] [local1 (++ temp3)])
					)
					(cond
						((>= local0 local282)
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
								(== [local187 (++ temp2)] 0)
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

