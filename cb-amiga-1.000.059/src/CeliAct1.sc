;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 228)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	CeliAct1 0
)

(local
	local0
	[local1 156] = [228 0 228 1 228 2 228 3 228 4 228 5 228 6 228 7 228 8 228 9 228 10 228 11 228 12 228 13 228 14 228 15 228 16 228 17 228 18 228 19 228 20 228 21 228 22 228 23 228 24 228 25 228 26 228 27 228 28 228 29 228 30 228 31 228 32 228 33 228 34 228 35 228 36 228 37 228 38 228 39 228 40 228 41 228 42 228 43 228 44 228 45 228 46 228 47 228 48 228 49 228 50 228 51 228 48 228 52 228 53 228 54 228 55 228 56 228 57 228 58 228 59 228 60 228 61 228 62 228 63 228 64 228 65 228 66 228 67 228 68 228 69 228 70 228 71 228 72 228 73 228 74 228 75 228 76]
	[local157 76] = [8256 10240 8320 8704 64 65 68 192 512 528 8 16 1 4 1024 32 40 256 260 272 8208 128 8200 16388 16392 8194 16400 16416 16448 16512 9216 8256 10240 8320 8704 64 65 68 192 512 528 8 16 1 4 1024 32 40 256 260 272 8208 128 8200 16388 16392 8194 16400 16416 16448 16512 9216 8208 16392 8194 9216 8208 16392 8194 9216 2 2 2 2 2 -1]
	[local233 5] = [0 31 62 66 70]
	local238 = 71
	[local239 4] = [72 73 74 75]
)

(instance CeliAct1 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 228)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local233 (- global212 1)]))
					(< temp2 [local233 global212])
					((++ temp2))
					
					(if (== global211 [local157 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if
					(and
						(!= local0 -1)
						(or (!= global211 9216) (> gAct 2))
					)
					(= temp1 (<< local0 $0001))
					(cond
						((and (== local0 43) (& gCorpseFlags $0001)) ; Gertie
							(= temp3 75)
						)
						((and (== local0 52) (& gCorpseFlags $0002)) ; Wilbur
							(= temp3 76)
						)
						((and (== local0 44) (& gCorpseFlags $0004)) ; Gloria
							(= temp3 77)
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
						((>= local0 local238)
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
								(== [local157 (++ temp2)] 0)
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

