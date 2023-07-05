;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 225)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	ColoAct1 0
)

(local
	local0
	[local1 152] = [225 0 225 1 225 2 225 3 225 4 225 5 225 6 225 7 225 8 225 9 225 10 225 11 225 12 225 13 225 14 225 15 225 16 225 17 225 18 225 19 225 20 225 21 225 22 225 23 225 24 225 25 225 26 225 27 225 28 225 29 225 30 225 31 225 32 225 33 225 34 225 35 225 36 225 37 225 38 225 39 225 21 225 40 225 41 225 42 225 43 225 44 225 45 225 46 225 47 225 48 225 49 225 50 225 51 225 52 225 53 225 54 225 55 225 56 225 57 225 58 225 59 225 60 225 61 225 62 225 63 225 64 225 65 225 66 225 67 225 68 225 69 225 70 225 71 225 72 225 73 225 74]
	[local153 77] = [8256 10240 0 8320 2 9216 64 65 68 192 8 16 1 4 1024 32 0 34 40 256 0 260 272 8208 128 0 8200 16388 8194 16392 16400 16416 16448 16512 8256 10240 8320 0 2 64 65 68 192 8 16 1 4 1024 32 34 40 256 260 272 8208 128 8200 16388 8194 16392 16400 16416 16448 16512 8208 8194 16392 8208 8194 16392 512 512 512 512 512 512 -1]
	[local230 5] = [0 34 64 67 70]
	local235 = 71
	[local236 5] = [72 73 74 75 76]
)

(instance ColoAct1 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 225)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local230 (- global212 1)]))
					(< temp2 [local230 global212])
					((++ temp2))
					
					(if (== global211 [local153 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(cond
						((>= local0 local235)
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
								(== [local153 (++ temp2)] 0)
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

