;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 377)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	JeevAct4 0
)

(local
	local0
	[local1 36] = [377 0 377 1 377 2 377 3 377 4 377 5 377 6 377 7 377 8 377 9 377 10 377 11 377 12 377 13 377 14 377 15 377 16 377 17]
)

(instance JeevAct4 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 377)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(switch global212
					(1
						(= local0 (Random 0 6))
					)
					(2
						(= local0 (Random 0 6))
					)
					(3
						(= local0 (Random 7 11))
					)
					(4
						(= local0 (Random 7 11))
					)
					(5
						(= local0 12)
					)
					(6
						(= local0 13)
					)
					(7
						(= local0 14)
					)
					(8
						(= local0 15)
					)
					(9
						(= local0 16)
					)
					(10
						(= local0 17)
					)
				)
				(if (!= local0 -1)
					(= temp0 (<< local0 $0001))
					(global209 claimed: 1)
					(cond
						((== local0 12)
							(proc243_1
								local0
								[local1 temp0]
								[local1 (++ temp0)]
							)
						)
						((>= local0 5)
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

