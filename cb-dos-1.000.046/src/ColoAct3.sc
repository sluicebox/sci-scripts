;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 285)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	ColoAct3 0
)

(local
	local0
	[local1 176] = [285 0 285 1 285 2 285 3 285 4 285 5 285 6 285 7 285 8 285 9 285 10 285 11 285 12 285 13 285 14 285 15 285 16 285 17 285 18 285 19 285 20 285 21 285 22 285 23 285 24 285 25 285 26 285 27 285 28 285 29 285 30 285 31 285 32 285 33 285 34 285 35 285 36 285 37 285 38 285 39 285 40 285 41 285 42 285 43 285 44 285 45 285 46 285 47 285 48 285 49 285 50 285 51 285 52 285 53 285 54 285 55 285 56 285 57 285 58 285 59 285 60 285 61 285 62 285 63 285 64 285 65 285 66 285 67 285 68 285 69 285 70 285 71 285 72 285 62 285 73 285 74 285 75 285 76 285 77 285 78 285 79 285 80 285 81 285 82 285 83 285 84 285 85 285 86]
	[local177 87] = [8256 10240 8320 8196 2 9216 0 64 65 68 320 192 8 16 1 4 1024 32 0 34 40 12288 256 260 272 16385 8208 0 128 8200 16388 8194 16392 16400 16416 16448 16512 8256 10240 8320 8196 0 2 64 65 68 320 192 8 16 1 4 1024 32 34 0 40 12288 256 260 272 16385 8208 128 8200 16388 8194 16392 16400 16416 16448 16512 8196 8208 8194 16392 8196 8208 8194 16392 512 512 512 512 512 512 -1]
	[local264 5] = [0 37 72 76 80]
	local269 = 81
	[local270 5] = [82 83 84 85 86]
)

(instance ColoAct3 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 285)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local264 (- global212 1)]))
					(< temp2 [local264 global212])
					((++ temp2))
					
					(if (== global211 [local177 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(cond
						((and (== local0 50) (& gCorpseFlags $0001)) ; Gertie
							(= temp3 86)
						)
						((and (== local0 63) (& gCorpseFlags $0002)) ; Wilbur
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
						((>= local0 local269)
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
								(== [local177 (++ temp2)] 0)
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

