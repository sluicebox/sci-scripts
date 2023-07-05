;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 292)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	ColoAct4 0
)

(local
	local0
	[local1 188] = [292 0 292 1 292 2 292 3 292 4 292 5 292 6 292 7 292 8 292 9 292 10 292 11 292 12 292 13 292 14 292 15 292 16 292 17 292 18 292 19 292 20 292 21 292 22 292 23 292 24 292 25 292 26 292 27 292 28 292 29 292 30 292 31 292 32 292 33 292 34 292 35 292 36 292 37 292 38 292 39 292 40 292 41 292 42 292 43 292 44 292 45 292 46 292 47 292 48 292 49 292 50 292 51 292 52 292 53 292 54 292 55 292 56 292 57 292 58 292 59 292 60 292 61 292 62 292 63 292 64 292 65 292 66 292 67 292 68 292 69 292 70 292 71 292 72 292 73 292 74 292 75 292 76 292 77 292 78 292 79 292 80 292 81 292 82 292 83 292 84 292 85 292 86 292 87 292 88 292 89 292 90 292 91 292 92 292 93]
	[local189 92] = [8256 10240 8320 8196 2 9216 64 65 68 320 192 8 16 0 1 4 1024 32 0 34 40 12288 256 260 272 16385 8208 128 0 8200 16388 8194 16392 16400 16416 16448 16512 8256 10240 8320 8196 0 9216 0 2 64 65 68 320 192 8 16 1 4 1024 32 34 40 12288 256 260 272 16385 8208 128 8200 16388 8194 16392 16400 16416 16448 16512 8196 9216 12288 8208 8194 16392 8196 9216 12288 8208 8194 16392 512 512 512 512 512 512 -1]
	[local281 5] = [0 37 73 77 85]
	local286 = 86
	[local287 5] = [87 88 89 90 91]
)

(instance ColoAct4 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 292)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local281 (- global212 1)]))
					(< temp2 [local281 global212])
					((++ temp2))
					
					(if (== global211 [local189 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(cond
						((and (== local0 52) (& gCorpseFlags $0001)) ; Gertie
							(= temp3 91)
						)
						((and (== local0 64) (& gCorpseFlags $0002)) ; Wilbur
							(= temp3 93)
						)
						((and (== local0 53) (& gCorpseFlags $0004)) ; Gloria
							(= temp3 92)
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
						((>= local0 local286)
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
								(== [local189 (++ temp2)] 0)
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

