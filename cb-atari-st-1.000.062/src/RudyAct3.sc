;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 289)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	RudyAct3 0
)

(local
	local0
	[local1 16] = [289 0 289 1 289 2 289 3 289 4 289 5 289 5 289 6]
)

(instance RudyAct3 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 289)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(switch global212
					(1
						(= local0 0)
					)
					(2
						(= local0 0)
					)
					(3
						(= local0 1)
					)
					(4
						(= local0 1)
					)
					(5
						(= local0 2)
					)
					(6
						(= local0 3)
					)
					(7
						(= local0 4)
					)
					(8
						(= local0 5)
					)
					(9
						(= local0 6)
					)
					(10
						(= local0 7)
					)
				)
				(if (!= local0 -1)
					(= temp0 (<< local0 $0001))
					(if (!= local0 2)
						(global209 claimed: 1)
						(Print [local1 temp0] [local1 (++ temp0)])
					else
						(proc243_1 local0 [local1 temp0] [local1 (++ temp0)])
					)
				)
			)
		)
		(client setScript: 0)
	)
)

