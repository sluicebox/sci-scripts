;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 298)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	ColoAct5 0
)

(local
	local0
	[local1 192] = [298 0 298 1 298 2 298 3 298 4 298 5 298 6 298 7 298 8 298 9 298 10 298 11 298 12 298 13 298 14 298 15 298 16 298 17 298 18 298 19 298 20 298 21 298 22 298 23 298 24 298 25 298 26 298 27 298 28 298 29 298 30 298 31 298 32 298 33 298 34 298 35 298 36 298 37 298 38 298 39 298 40 298 41 298 42 298 43 298 44 298 45 298 46 298 47 298 48 298 49 298 50 298 51 298 52 298 53 298 54 298 55 298 56 298 57 298 58 298 59 298 60 298 61 298 62 298 63 298 64 298 65 298 66 298 67 298 68 298 69 298 70 298 71 298 72 298 73 298 74 298 75 298 76 298 77 298 78 298 79 298 80 298 81 298 82 298 83 298 84 298 85 298 86 298 87 298 88 298 89 298 90 298 91 298 92 298 93 298 94 298 95]
	[local193 93] = [8256 10240 8320 8196 2 9216 64 65 68 320 192 8 16 1 4 1024 32 1040 34 40 12288 256 260 272 16385 8208 128 8200 16388 8194 16392 16400 16416 16448 16512 8256 10240 0 8320 8196 0 9216 0 2 64 65 68 320 192 8 16 1 4 1024 1040 32 34 40 12288 256 260 272 16385 8208 128 8200 16388 8194 16392 16400 16416 16448 16512 8196 8208 9216 0 12288 8194 16392 8196 8208 9216 12288 8194 16392 512 512 512 512 512 512 -1]
	[local286 5] = [0 35 73 80 86]
	local291 = 87
	[local292 5] = [88 89 90 91 92]
)

(instance ColoAct5 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 298)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local286 (- global212 1)]))
					(< temp2 [local286 global212])
					((++ temp2))
					
					(if (== global211 [local193 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(cond
						((and (== local0 51) (& gCorpseFlags $0001)) ; Gertie
							(= temp3 92)
						)
						((and (== local0 64) (& gCorpseFlags $0002)) ; Wilbur
							(= temp3 93)
						)
						((and (== local0 52) (& gCorpseFlags $0004)) ; Gloria
							(= temp3 95)
						)
						((and (== local0 49) (& gCorpseFlags $0008)) ; Ethel
							(= temp3 94)
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
						((>= local0 local291)
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
								(== [local193 (++ temp2)] 0)
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

