;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 254)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	CeliAct2 0
)

(local
	local0
	[local1 144] = [254 0 254 1 254 2 254 3 254 4 254 5 254 6 254 7 254 8 254 9 254 10 254 11 254 12 254 13 254 14 254 15 254 16 254 17 254 18 254 19 254 20 254 21 254 22 254 23 254 24 254 25 254 26 254 27 254 28 254 29 254 30 254 31 254 32 254 33 254 34 254 35 254 36 254 37 254 38 254 39 254 40 254 41 254 42 254 43 254 44 254 45 254 46 254 47 254 48 254 49 254 50 254 47 254 51 254 52 254 53 254 54 254 55 254 56 254 57 254 58 254 59 254 60 254 61 254 62 254 63 254 64 254 65 254 66 254 67 254 68 254 69 254 70]
	[local145 72] = [8256 10240 8320 8704 64 65 68 192 512 528 8 16 1 4 1024 32 40 256 260 272 8208 128 8200 16388 16392 8194 16400 16416 16448 16512 8256 10240 8320 8704 64 65 68 192 512 528 8 16 1 4 1024 32 40 256 260 272 8208 128 8200 16388 16392 8194 16400 16416 16448 16512 8208 16392 8194 8208 16392 8194 2 2 2 2 2 -1]
	[local217 5] = [0 30 60 63 66]
	local222 = 67
	[local223 4] = [68 69 70 71]
)

(instance CeliAct2 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 254)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local217 (- global212 1)]))
					(< temp2 [local217 global212])
					((++ temp2))
					
					(if (== global211 [local145 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(if (and (== local0 42) (& gCorpseFlags $0001)) ; Gertie
						(= [local1 84] [local1 142])
						(= [local1 85] [local1 143])
					)
					(cond
						((>= local0 local222)
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
								(== [local145 (++ temp2)] 0)
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

