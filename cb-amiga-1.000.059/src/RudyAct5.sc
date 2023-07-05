;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 373)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	RudyAct5 0
)

(local
	local0
	[local1 194] = [373 0 373 1 373 2 373 3 373 4 373 5 373 6 373 7 373 8 373 9 373 10 373 11 373 12 373 13 373 14 373 15 373 16 373 17 373 18 373 19 373 20 373 21 373 22 373 23 373 24 373 25 373 26 373 27 373 28 373 29 373 30 373 31 373 32 373 33 373 34 373 35 373 36 373 37 373 38 373 39 373 40 373 41 373 42 373 43 373 44 373 45 373 46 373 47 373 48 373 49 373 50 373 51 373 52 373 53 373 54 373 55 373 56 373 57 373 58 373 59 373 60 373 61 373 62 373 63 373 64 373 65 373 66 373 67 373 68 373 69 373 70 373 71 373 72 373 73 373 74 373 75 373 76 373 77 373 78 373 79 373 80 373 81 373 82 373 83 373 84 373 85 373 86 373 87 373 88 373 89 373 90 373 88 373 91 373 92 373 93 373 94 373 95]
	[local195 94] = [8256 10240 8320 8196 0 2 9216 0 64 65 68 0 192 512 528 8 16 1 4 1024 1040 32 0 34 40 12288 16385 0 8208 128 8200 0 16388 16392 8194 16400 16416 16448 16512 544 8256 10240 8320 8196 2 9216 64 65 68 512 528 8 16 1 4 1024 1040 32 34 40 12288 16385 0 8208 128 8200 0 16388 16392 8194 16400 16416 16448 16512 544 8208 8196 9216 12288 16392 8194 8208 8196 9216 12288 16392 8194 256 256 256 256 256 256 -1]
	[local289 5] = [0 40 75 81 87]
	local294 = 88
	[local295 5] = [89 90 91 92 93]
)

(instance RudyAct5 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 373)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local289 (- global212 1)]))
					(< temp2 [local289 global212])
					((++ temp2))
					
					(if (== global211 [local195 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(cond
						((and (== local0 51) (& gCorpseFlags $0008)) ; Ethel
							(= temp3 93)
						)
						((and (== local0 64) (& gCorpseFlags $0002)) ; Wilbur
							(= temp3 94)
						)
						((and (== local0 54) (& gCorpseFlags $0004)) ; Gloria
							(= temp3 95)
						)
						((and (== local0 53) (& gCorpseFlags $0001)) ; Gertie
							(= temp3 96)
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
						((>= local0 local294)
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
								(== [local195 (++ temp2)] 0)
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

