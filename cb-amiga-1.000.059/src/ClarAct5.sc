;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 297)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	ClarAct5 0
)

(local
	local0
	[local1 180] = [297 0 297 1 297 2 297 3 297 4 297 5 297 6 297 7 297 8 297 9 297 10 297 11 297 12 297 13 297 14 297 15 297 16 297 17 297 18 297 19 297 20 297 21 297 22 297 23 297 24 297 25 297 26 297 27 297 28 297 29 297 30 297 31 297 32 297 33 297 34 297 35 297 36 297 37 297 38 297 39 297 40 297 41 297 42 297 43 297 44 297 45 297 46 297 47 297 48 297 49 297 50 297 51 297 52 297 53 297 54 297 55 297 56 297 57 297 58 297 59 297 60 297 61 297 62 297 63 297 64 297 65 297 66 297 67 297 68 297 69 297 70 297 71 297 72 297 73 297 74 297 75 297 76 297 77 297 78 297 79 297 80 297 81 297 82 297 83 297 84 297 85 297 86 297 87 297 88 297 89]
	[local181 87] = [8256 10240 8320 8196 2 9216 0 512 528 8 16 1 4 1024 1040 32 34 40 12288 256 260 272 16385 8208 128 8200 16388 8194 16392 16400 16416 16448 16512 544 8256 10240 8320 8196 2 9216 512 528 8 16 1 4 1024 1040 32 34 40 12288 256 272 260 0 16385 8208 128 8200 16388 8194 16392 16400 16416 16448 16512 544 8196 9216 12288 8208 8194 16392 8196 9216 12288 8208 8194 16392 64 64 64 64 64 64 -1]
	[local268 5] = [0 34 68 74 80]
	local273 = 81
	[local274 5] = [82 83 84 85 86]
)

(instance ClarAct5 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 297)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local268 (- global212 1)]))
					(< temp2 [local268 global212])
					((++ temp2))
					
					(if (== global211 [local181 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(cond
						((and (== local0 44) (& gCorpseFlags $0001)) ; Gertie
							(= temp3 87)
						)
						((and (== local0 58) (& gCorpseFlags $0002)) ; Wilbur
							(= temp3 89)
						)
						((and (== local0 45) (& gCorpseFlags $0004)) ; Gloria
							(= temp3 88)
						)
						((and (== local0 42) (& gCorpseFlags $0008)) ; Ethel
							(= temp3 86)
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
						((>= local0 local273)
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
								(== [local181 (++ temp2)] 0)
							)
							(proc0_23 [local1 (++ temp1)] [local1 (++ temp1)])
						)
					)
					(if (and (== global212 1) (== global211 256))
						(SetFlag 15)
					)
				)
			)
		)
		(client setScript: 0)
	)
)

