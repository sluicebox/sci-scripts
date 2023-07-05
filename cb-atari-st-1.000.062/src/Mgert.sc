;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 216)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	Mgert 0
)

(local
	local0
	[local1 124] = [216 0 216 1 216 2 216 3 216 4 216 5 216 6 216 7 216 8 216 9 216 10 216 11 216 12 216 13 216 14 216 15 216 16 216 17 216 18 216 19 216 20 216 21 216 22 216 23 216 24 216 25 216 26 216 27 216 28 216 29 216 30 216 31 216 32 216 33 216 34 216 35 216 36 216 37 216 38 216 39 216 40 216 41 216 42 216 43 216 44 216 45 216 46 216 47 216 48 216 49 216 50 216 51 216 52 216 53 216 54 216 55 216 56 216 57 216 58 216 59 216 60 216 61]
	[local125 63] = [8256 10240 8320 2 64 68 192 512 528 8 16 4 1024 32 34 40 256 260 272 8208 0 128 8200 16388 16400 16416 16448 16512 8256 10240 8320 2 64 68 192 512 528 8 16 4 1024 32 34 40 256 260 272 8208 128 8200 16388 16400 16416 16448 16512 8208 8208 1 1 1 1 1 -1]
	[local188 5] = [0 28 55 56 57]
	local193 = 58
	[local194 4] = [59 60 61 62]
)

(instance Mgert of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 216)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(for
					((= temp2 [local188 (- global212 1)]))
					(< temp2 [local188 global212])
					((++ temp2))
					
					(if (== global211 [local125 temp2])
						(= local0 temp2)
						(break)
					)
				)
				(if (!= local0 -1)
					(= temp1 (<< local0 $0001))
					(cond
						((>= local0 local193)
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
								(== [local125 (++ temp2)] 0)
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

