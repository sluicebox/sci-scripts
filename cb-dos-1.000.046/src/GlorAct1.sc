;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 223)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	GlorAct1 0
)

(local
	local0
	[local1 154] = [223 0 223 1 223 2 223 3 223 4 223 5 223 6 223 7 223 8 223 9 223 10 223 11 223 12 223 13 223 14 223 15 223 16 223 17 223 18 223 19 223 20 223 21 223 22 223 23 223 24 223 25 223 26 223 27 223 28 223 29 223 30 223 31 223 32 223 33 223 34 223 35 223 36 223 37 223 38 223 39 223 40 223 41 223 42 223 43 223 44 223 45 223 46 223 47 223 48 223 49 223 50 223 51 223 52 223 53 223 54 223 55 223 56 223 57 223 58 223 59 223 60 223 61 223 62 223 63 223 64 223 65 223 66 223 67 223 68 223 69 223 70 223 71 223 72 223 73 223 74 223 75 223 76]
	[local155 78] = [8256 10240 0 8320 8192 0 2 8193 0 64 65 192 512 528 8 16 1 1024 32 34 40 256 0 272 8208 128 0 8200 0 16388 16392 8194 16400 16416 16448 16512 8256 10240 0 8320 2 64 65 0 192 512 528 8 16 1 1024 32 34 40 256 272 8208 128 8200 16388 16392 8194 16400 16416 16448 16512 8208 16392 8194 8208 16392 8194 4 4 4 4 4 -1]
	[local233 5] = [0 36 66 69 72]
	local238 = 73
	[local239 4] = [74 75 76 77]
)

(instance GlorAct1 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 223)
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
					((= temp2 [local233 (- global212 1)]))
					(< temp2 [local233 global212])
					((++ temp2))
					
					(if (== global211 [local155 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
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
								(== [local155 (++ temp2)] 0)
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

