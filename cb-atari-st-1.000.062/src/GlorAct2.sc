;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 249)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	GlorAct2 0
)

(local
	local0
	[local1 142] = [249 0 249 1 249 2 249 3 249 4 249 5 249 6 249 7 249 8 249 9 249 10 249 11 249 12 249 13 249 14 249 15 249 16 249 17 249 18 249 19 249 20 249 21 249 22 249 23 249 24 249 25 249 26 249 27 249 28 249 29 249 30 249 31 249 32 249 33 249 34 249 35 249 36 249 37 249 38 249 39 249 40 249 41 249 42 249 43 249 44 249 45 249 46 249 47 249 48 249 49 249 50 249 51 249 52 249 53 249 54 249 55 249 56 249 57 249 58 249 59 249 60 249 61 249 62 249 63 249 64 249 65 249 66 249 67 249 68 249 69 249 70]
	[local143 71] = [8256 10240 8320 8192 0 2 8193 0 64 65 192 512 528 8 16 1 1024 32 34 40 256 272 8208 128 8200 16388 16392 8194 16400 16416 16448 16512 8256 10240 8320 2 64 65 192 512 528 8 16 1 1024 32 34 256 272 8208 128 8200 16388 16392 8194 16400 16416 16448 16512 8208 16392 8194 8208 16392 8194 4 4 4 4 4 -1]
	[local214 5] = [0 32 59 62 65]
	local219 = 66
	[local220 4] = [67 68 69 70]
)

(instance GlorAct2 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 249)
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
					((= temp2 [local214 (- global212 1)]))
					(< temp2 [local214 global212])
					((++ temp2))
					
					(if (== global211 [local143 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(if (and (== local0 43) (& gCorpseFlags $0001)) ; Gertie
						(= [local1 temp1] [local1 140])
						(= [local1 (+ temp1 1)] [local1 141])
					)
					(cond
						((>= local0 local219)
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
								(== [local143 (++ temp2)] 0)
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

