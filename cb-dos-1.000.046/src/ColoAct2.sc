;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 253)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	ColoAct2 0
)

(local
	local0
	[local1 150] = [253 0 253 1 253 2 253 3 253 4 253 5 253 6 253 7 253 8 253 9 253 10 253 11 253 12 253 13 253 14 253 15 253 16 253 17 253 18 253 19 253 20 253 21 253 22 253 23 253 24 253 25 253 26 253 27 253 28 253 29 253 30 253 31 253 32 253 33 253 34 253 35 253 36 253 37 253 38 253 39 253 40 253 41 253 42 253 43 253 44 253 45 253 46 253 47 253 48 253 49 253 50 253 51 253 52 253 53 253 54 253 55 253 56 253 57 253 58 253 59 253 60 253 61 253 62 253 63 253 64 253 65 253 66 253 67 253 68 253 69 253 70 253 71 253 72 253 73 253 74]
	[local151 75] = [8256 10240 8320 2 9216 64 65 68 192 0 8 16 1 4 1024 32 34 40 256 260 272 0 8208 0 128 8200 16388 8194 16392 16400 16416 16448 16512 8256 10240 8320 2 64 65 68 192 8 16 1 4 1024 32 34 40 256 260 272 8208 128 8200 16388 8194 16392 16400 16416 16448 16512 8208 8194 16392 8208 8194 16392 512 512 512 512 512 512 -1]
	[local226 5] = [0 33 62 65 68]
	local231 = 69
	[local232 5] = [70 71 72 73 74]
)

(instance ColoAct2 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 253)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local226 (- global212 1)]))
					(< temp2 [local226 global212])
					((++ temp2))
					
					(if (== global211 [local151 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(if (and (== local0 43) (& gCorpseFlags $0001)) ; Gertie
						(= [local1 86] [local1 148])
						(= [local1 87] [local1 149])
					)
					(cond
						((>= local0 local231)
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
								(== [local151 (++ temp2)] 0)
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

