;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 299)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	CeliAct5 0
)

(local
	local0
	[local1 200] = [299 0 299 1 299 2 299 3 299 4 299 5 299 6 299 7 299 8 299 9 299 10 299 11 299 12 299 13 299 14 299 15 299 16 299 17 299 18 299 19 299 20 299 21 299 22 299 23 299 24 299 25 299 26 299 27 299 28 299 29 299 30 299 31 299 32 299 33 299 34 299 35 299 36 299 37 299 38 299 39 299 40 299 41 299 42 299 43 299 44 299 45 299 46 299 47 299 48 299 49 299 12 299 50 299 51 299 52 299 53 299 54 299 55 299 56 299 57 299 58 299 59 299 60 299 61 299 62 299 63 299 64 299 65 299 66 299 67 299 68 299 69 299 70 299 71 299 72 299 73 299 74 299 75 299 76 299 77 299 78 299 79 299 80 299 81 299 82 299 83 299 84 299 85 299 86 299 87 299 88 299 89 299 90 299 91 299 92 299 93 299 94 299 95 299 96 299 97 299 98]
	[local201 94] = [8256 10240 8320 8196 64 65 68 320 192 512 528 8 16 1 4 1024 32 40 12288 256 260 272 16385 8208 16384 128 8200 9216 8224 16388 16392 8194 16400 16416 16448 16512 544 8256 10240 8320 8196 0 64 65 68 320 192 512 528 8 16 1 4 1024 1040 32 40 12288 256 272 260 16385 8208 16384 128 8200 9216 8224 16388 16392 8194 16400 16416 16448 16512 544 8196 9216 12288 8208 16392 8194 8196 9216 12288 8208 16392 8194 2 2 2 2 2 -1]
	[local295 5] = [0 37 76 82 88]
	local300 = 89
	[local301 4] = [90 91 92 93]
)

(instance CeliAct5 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 299)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 [temp4 50])
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local295 (- global212 1)]))
					(< temp2 [local295 global212])
					((++ temp2))
					
					(if (== global211 [local201 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(cond
						(
							(and
								(or (== local0 7) (== local0 44) (== local0 65))
								global135
							)
							(switch local0
								(7
									(= temp3 94)
								)
								(45
									(= temp3 95)
								)
								(66
									(= temp3 93)
								)
							)
						)
						((and (== local0 51) (& gCorpseFlags $0001)) ; Gertie
							(= temp3 96)
						)
						((and (== local0 64) (& gCorpseFlags $0002)) ; Wilbur
							(= temp3 97)
						)
						((and (== local0 52) (& gCorpseFlags $0004)) ; Gloria
							(= temp3 98)
						)
						((and (== local0 49) (& gCorpseFlags $0008)) ; Ethel
							(= temp3 99)
						)
						(else
							(= temp3 0)
						)
					)
					(if temp3
						(= [local1 temp1] [local1 (*= temp3 2)])
						(= [local1 (+ temp1 1)] [local1 (+ temp3 1)])
					)
					(cond
						((>= local0 local300)
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
								(== [local201 (++ temp2)] 0)
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

