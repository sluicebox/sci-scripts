;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 287)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	FifiAct3 0
)

(local
	local0
	[local1 162] = [287 0 287 1 287 2 287 3 287 4 287 5 287 6 287 7 287 8 287 9 287 10 287 11 287 12 287 13 287 14 287 15 287 16 287 17 287 18 287 19 287 20 287 21 287 22 287 23 287 24 287 25 287 26 287 27 287 28 287 29 287 30 287 31 287 32 287 33 287 34 287 35 287 36 287 37 287 38 287 39 287 40 287 41 287 42 287 43 287 44 287 45 287 46 287 47 287 48 287 49 287 50 287 51 287 52 287 53 287 54 287 55 287 56 287 57 287 58 287 59 287 60 287 61 287 62 287 63 287 64 287 65 287 66 287 67 287 68 287 69 287 70 287 71 287 72 287 73 287 74 287 75 287 76 287 77 287 78 287 79 287 80]
	[local163 80] = [8256 10240 0 8320 8196 2 64 65 68 320 192 512 8 1 4 1024 32 34 40 12288 256 260 16385 0 8208 128 8200 16388 8194 16392 16400 16416 16448 16512 8256 10240 8320 8196 2 64 65 68 320 192 512 8 1 4 1024 32 34 40 12288 256 260 16385 8208 128 8200 16388 8194 16392 16400 16416 16448 16512 8196 8208 8194 16392 8196 8208 8194 16392 16 16 16 16 16 -1]
	[local243 5] = [0 34 66 70 74]
	local248 = 75
	[local249 4] = [76 77 78 79]
)

(instance FifiAct3 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 287)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local243 (- global212 1)]))
					(< temp2 [local243 global212])
					((++ temp2))
					
					(if (== global211 [local163 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(cond
						((and (== local0 46) (& gCorpseFlags $0001)) ; Gertie
							(= temp3 79)
						)
						((and (== local0 57) (& gCorpseFlags $0002)) ; Wilbur
							(= temp3 80)
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
						((>= local0 local248)
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
								(== [local163 (++ temp2)] 0)
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

