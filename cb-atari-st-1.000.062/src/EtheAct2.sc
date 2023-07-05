;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 275)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	EtheAct2 0
)

(local
	local0
	[local1 30] = [275 0 275 1 275 2 275 3 275 4 275 5 275 6 275 7 275 8 275 9 275 10 275 11 275 12 275 13 275 14]
)

(instance EtheAct2 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 275)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(switch global212
					(1
						(= local0 (Random 0 7))
					)
					(2
						(= local0 (Random 0 7))
					)
					(3
						(= local0 8)
					)
					(4
						(= local0 9)
					)
					(5
						(= local0 10)
					)
					(6
						(= local0 11)
					)
					(7
						(= local0 12)
					)
					(8
						(= local0 13)
					)
					(9
						(= local0 14)
					)
				)
				(if (!= local0 -1)
					(= temp0 (<< local0 $0001))
					(global209 claimed: 1)
					(cond
						((== local0 10)
							(proc243_1
								local0
								[local1 temp0]
								[local1 (++ temp0)]
							)
						)
						((>= local0 6)
							(Print [local1 temp0] [local1 (++ temp0)])
						)
						(else
							(Say 1 [local1 temp0] [local1 (++ temp0)])
						)
					)
				)
			)
		)
		(client setScript: 0)
	)
)

