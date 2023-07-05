;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 250)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	FifiAct2 0
)

(local
	local0
	[local1 134] = [250 0 250 1 250 2 250 3 250 4 250 5 250 6 250 7 250 8 250 9 250 10 250 11 250 12 250 13 250 14 250 15 250 16 250 17 250 18 250 19 250 20 250 21 250 22 250 23 250 24 250 25 250 26 250 27 250 28 250 29 250 30 250 31 250 32 250 33 250 34 250 35 250 36 250 37 250 38 250 39 250 40 250 41 250 42 250 43 250 44 250 45 250 46 250 47 250 48 250 49 250 50 250 51 250 52 250 53 250 54 250 55 250 56 250 57 250 58 250 59 250 60 250 61 250 62 250 63 250 64 250 65 250 66]
	[local135 67] = [8256 10240 8320 2 64 65 68 192 512 8 1 4 1024 32 34 40 256 260 8208 128 8200 16388 8194 16392 16400 16416 16448 16512 8256 10240 8320 2 64 65 68 192 512 1 4 1024 32 34 40 256 260 8208 128 8200 16388 8194 16392 16400 16416 16448 16512 8208 8194 16392 8208 8194 16392 16 16 16 16 16 -1]
	[local202 5] = [0 28 55 58 61]
	local207 = 62
	[local208 4] = [63 64 65 66]
)

(instance FifiAct2 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 250)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local202 (- global212 1)]))
					(< temp2 [local202 global212])
					((++ temp2))
					
					(if (== global211 [local135 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(if (and (== local0 37) (& gCorpseFlags $0001)) ; Gertie
						(= [local1 74] [local1 132])
						(= [local1 75] [local1 133])
					)
					(cond
						((>= local0 local207)
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
								(== [local135 (++ temp2)] 0)
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

