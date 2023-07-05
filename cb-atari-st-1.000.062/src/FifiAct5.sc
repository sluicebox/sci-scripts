;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 371)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	FifiAct5 0
)

(local
	local0
	[local1 182] = [371 0 371 1 371 2 371 3 371 4 371 5 371 6 371 7 371 8 371 9 371 10 371 11 371 12 371 13 371 14 371 15 371 16 371 17 371 18 371 19 371 20 371 21 371 22 371 23 371 24 371 25 371 26 371 27 371 28 371 29 371 30 371 31 371 32 371 33 371 34 371 35 371 36 371 37 371 38 371 39 371 40 371 41 371 42 371 43 371 44 371 45 371 46 371 47 371 48 371 49 371 50 371 51 371 52 371 53 371 54 371 55 371 56 371 57 371 58 371 59 371 60 371 61 371 62 371 63 371 64 371 65 371 66 371 67 371 68 371 69 371 70 371 71 371 72 371 73 371 74 371 75 371 76 371 77 371 78 371 79 371 80 371 81 371 82 371 83 371 84 371 85 371 86 371 87 371 88 371 89 371 90]
	[local183 88] = [8256 10240 8320 8196 2 9216 64 65 68 320 192 512 8 1 4 1024 32 34 40 12288 256 260 8208 0 16385 0 128 8200 16388 8194 16392 16400 16416 16448 16512 544 8256 10240 8320 8196 9216 2 64 65 68 320 192 512 8 1 4 1024 32 34 40 12288 256 260 16385 8208 128 8200 16388 8194 16392 16400 16416 16448 16512 544 8196 9216 12288 8208 8194 16392 8196 9216 12288 8208 8194 16392 16 16 16 16 16 -1]
	[local271 5] = [0 36 70 76 82]
	local276 = 83
	[local277 4] = [84 85 86 87]
)

(instance FifiAct5 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 371)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local271 (- global212 1)]))
					(< temp2 [local271 global212])
					((++ temp2))
					
					(if (== global211 [local183 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(cond
						((and (== local0 49) (& gCorpseFlags $0001)) ; Gertie
							(= temp3 88)
						)
						((and (== local0 60) (& gCorpseFlags $0002)) ; Wilbur
							(= temp3 90)
						)
						((and (== local0 50) (& gCorpseFlags $0004)) ; Gloria
							(= temp3 89)
						)
						((and (== local0 48) (& gCorpseFlags $0008)) ; Ethel
							(= temp3 87)
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
						((>= local0 local276)
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
								(== [local183 (++ temp2)] 0)
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

