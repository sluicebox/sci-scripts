;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 375)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	ColoAct7 0
)

(local
	local0
	[local1 206] = [375 0 375 1 375 2 375 3 375 4 375 5 375 6 375 7 375 8 375 9 375 10 375 11 375 12 375 13 375 14 375 15 375 16 375 17 375 18 375 19 375 20 375 21 375 22 375 23 375 24 375 25 375 26 375 27 375 28 375 29 375 30 375 31 375 32 375 33 375 34 375 35 375 36 375 37 375 38 375 39 375 40 375 41 375 42 375 15 375 43 375 44 375 45 375 46 375 47 375 48 375 49 375 50 375 51 375 52 375 53 375 54 375 55 375 56 375 57 375 58 375 59 375 60 375 61 375 62 375 63 375 64 375 65 375 66 375 67 375 68 375 69 375 70 375 71 375 72 375 73 375 74 375 75 375 76 375 77 375 78 375 79 375 80 375 81 375 82 375 83 375 84 375 85 375 86 375 87 375 88 375 89 375 90 375 91 375 92 375 93 375 94 375 95 375 96 375 97 375 98 375 99 375 100 375 101]
	[local207 96] = [8256 10240 8320 16386 8196 2 9216 0 64 65 68 192 320 8 16 1 4 1024 1040 0 32 34 40 12288 256 260 272 16385 8208 128 8200 16388 8194 16392 16400 16416 16448 16512 8256 10240 8320 16386 8196 2 9216 64 65 68 192 320 8 16 1 4 1024 1040 32 34 40 12288 256 260 272 16385 8208 128 8200 16388 8194 16392 16400 16416 16448 16512 16386 8196 0 9216 12288 8208 8194 16392 16386 8196 9216 12288 8208 8194 16392 512 512 512 512 512 512 -1]
	[local303 5] = [0 38 74 82 89]
	local308 = 90
	[local309 5] = [91 92 93 94 95]
)

(instance ColoAct7 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 375)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local303 (- global212 1)]))
					(< temp2 [local303 global212])
					((++ temp2))
					
					(if (== global211 [local207 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(cond
						((and (== local0 52) (& gCorpseFlags $0001)) ; Gertie
							(= temp3 98)
						)
						((and (== local0 65) (& gCorpseFlags $0002)) ; Wilbur
							(= temp3 102)
						)
						((and (== local0 53) (& gCorpseFlags $0004)) ; Gloria
							(= temp3 99)
						)
						((and (== local0 50) (& gCorpseFlags $0008)) ; Ethel
							(= temp3 96)
						)
						(
							(and
								(or
									(== local0 51)
									(== local0 54)
									(== local0 55)
								)
								(& gCorpseFlags $0010) ; Jeeves & Fifi
							)
							(switch local0
								(51
									(= temp3 97)
								)
								(54
									(= temp3 100)
								)
								(55
									(= temp3 101)
								)
							)
						)
						((and (== local0 45) (& gCorpseFlags $0020)) ; Clarence
							(= temp3 95)
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
						((>= local0 local308)
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
								(== [local207 (++ temp2)] 0)
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

