;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 258)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	GlorAct3 0
)

(local
	local0
	[local1 164] = [258 0 258 1 258 2 258 3 258 4 258 5 258 6 258 7 258 8 258 9 258 10 258 11 258 12 258 13 258 14 258 15 258 16 258 17 258 18 258 19 258 20 258 21 258 22 258 23 258 24 258 25 258 26 258 27 258 28 258 29 258 30 258 31 258 32 258 33 258 34 258 35 258 36 258 37 258 38 258 39 258 40 258 41 258 42 258 43 258 44 258 45 258 46 258 47 258 48 258 49 258 50 258 51 258 52 258 53 258 54 258 55 258 56 258 57 258 58 258 59 258 60 258 61 258 62 258 63 258 64 258 65 258 66 258 67 258 68 258 69 258 70 258 71 258 72 258 73 258 74 258 75 258 76 258 77 258 78 258 79 258 80 258 81]
	[local165 81] = [8256 10240 8320 8192 0 8196 2 8193 0 64 65 320 192 512 528 8 16 1 1024 32 34 40 256 272 128 16385 8208 12288 8200 16388 16392 8194 16400 16416 16448 16512 8256 10240 0 8320 8196 2 64 65 320 192 512 528 8 16 1 1024 32 34 40 256 272 128 16385 8208 12288 8200 16388 16392 8194 16400 16416 16448 16512 8208 16392 8194 8208 16392 8194 4 4 4 4 4 -1]
	[local246 5] = [0 36 69 72 75]
	local251 = 76
	[local252 4] = [77 78 79 80]
)

(instance GlorAct3 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 258)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(cond
					((or (Said '/boa>') (Said '//boa>'))
						(= global211 8192)
					)
					((or (Said '/cigarette>') (Said '//cigarette>'))
						(= global211 8193)
					)
				)
				(for
					((= temp2 [local246 (- global212 1)]))
					(< temp2 [local246 global212])
					((++ temp2))
					
					(if (== global211 [local165 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(cond
						((and (== local0 50) (& gCorpseFlags $0001)) ; Gertie
							(= temp0 80)
						)
						((and (== local0 57) (& gCorpseFlags $0002)) ; Wilbur
							(= temp0 81)
						)
						(else
							(= temp0 0)
						)
					)
					(if temp0
						(= [local1 temp1] [local1 (*= temp0 2)])
						(= [local1 (+ temp1 1)] [local1 (++ temp0)])
					)
					(cond
						((>= local0 local251)
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
								(== [local165 (++ temp2)] 0)
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

