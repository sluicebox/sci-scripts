;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 294)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	FifiAct4 0
)

(local
	local0
	[local1 172] = [294 0 294 1 294 2 294 3 294 4 294 5 294 6 294 7 294 8 294 9 294 10 294 11 294 12 294 13 294 14 294 15 294 16 294 17 294 18 294 19 294 20 294 21 294 22 294 23 294 24 294 25 294 26 294 27 294 28 294 29 294 30 294 31 294 32 294 33 294 34 294 35 294 36 294 37 294 38 294 39 294 40 294 41 294 42 294 43 294 44 294 45 294 46 294 47 294 48 294 49 294 50 294 51 294 52 294 53 294 54 294 55 294 56 294 57 294 58 294 59 294 60 294 61 294 62 294 63 294 64 294 65 294 66 294 67 294 68 294 69 294 70 294 71 294 66 294 72 294 73 294 74 294 75 294 76 294 77 294 78 294 79 294 80 294 81 294 82 294 83 294 84]
	[local173 84] = [8256 10240 8320 8196 2 9216 64 65 68 320 192 512 8 1 4 1024 32 34 40 12288 256 260 8208 16385 128 8200 16388 8194 16392 16400 16416 16448 16512 8256 10240 8320 8196 9216 2 64 65 68 320 192 512 8 1 4 1024 32 34 40 12288 256 260 16385 8208 128 8200 16388 8194 16392 16400 16416 16448 16512 8196 9216 12288 8208 8194 16392 8196 9216 12288 8208 8194 16392 16 16 16 16 16 -1]
	[local257 5] = [0 33 66 72 78]
	local262 = 79
	[local263 4] = [80 81 82 83]
)

(instance FifiAct4 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 294)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local257 (- global212 1)]))
					(< temp2 [local257 global212])
					((++ temp2))
					
					(if (== global211 [local173 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(cond
						((and (== local0 46) (& gCorpseFlags $0001)) ; Gertie
							(= temp3 83)
						)
						((and (== local0 57) (& gCorpseFlags $0002)) ; Wilbur
							(= temp3 85)
						)
						((and (== local0 47) (& gCorpseFlags $0004)) ; Gloria
							(= temp3 84)
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
						((>= local0 local262)
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
								(== [local173 (++ temp2)] 0)
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

