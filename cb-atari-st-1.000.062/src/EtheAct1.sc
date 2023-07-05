;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 221)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	EtheAct1 0
)

(local
	local0
	[local1 130] = [221 0 221 1 221 2 221 3 221 4 221 5 221 6 221 7 221 8 221 9 221 10 221 11 221 12 221 13 221 14 221 15 221 16 221 17 221 18 221 19 221 20 221 21 221 22 221 23 221 24 221 25 221 26 221 27 221 28 221 29 221 30 221 31 221 32 221 33 221 34 221 35 221 36 221 37 221 38 221 39 221 40 221 41 221 42 221 43 221 44 221 45 221 46 221 47 221 48 221 49 221 50 221 51 221 52 221 53 221 54 221 55 221 56 221 57 221 58 221 59 221 60 221 61 221 62 221 63 221 64]
	[local131 66] = [8256 10240 8320 2 64 65 68 192 512 528 16 1 4 1024 32 34 256 260 272 8208 128 8200 0 16388 16400 16416 16448 16512 8256 10240 8320 2 64 65 68 192 512 528 16 1 0 4 1024 32 0 34 256 260 272 8208 128 8200 0 16388 16400 16416 16448 16512 8208 8208 8 8 8 8 8 -1]
	[local197 5] = [0 28 58 59 60]
	local202 = 61
	[local203 4] = [62 63 64 65]
)

(instance EtheAct1 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 221)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local197 (- global212 1)]))
					(< temp2 [local197 global212])
					((++ temp2))
					
					(if (== global211 [local131 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(cond
						((>= local0 local202)
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
								(== [local131 (++ temp2)] 0)
							)
							(proc0_23 [local1 (++ temp1)] [local1 (++ temp1)])
						)
					)
					(if (and (== global212 1) (== global211 256))
						(SetFlag 15)
					)
				)
			)
		)
		(client setScript: 0)
	)
)

