;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 291)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use System)

(public
	ClarAct4 0
)

(local
	local0
	[local1 28] = [291 0 291 1 291 2 291 3 291 4 291 5 291 6 291 7 291 8 291 9 291 10 291 11 291 12 291 13]
)

(instance ClarAct4 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 291)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((event claimed:))
			((and (== (event type:) evSAID) global212)
				(= local0 -1)
				(switch global212
					(1
						(if (== gCurRoomNum 17)
							(if (== global211 256)
								(= local0 0)
							else
								(= local0 1)
							)
						else
							(= local0 4)
						)
					)
					(2
						(if (== gCurRoomNum 17)
							(if (== global211 256)
								(= local0 2)
							else
								(= local0 3)
							)
						else
							(= local0 4)
						)
					)
					(3
						(if (== gCurRoomNum 17)
							(= local0 5)
						else
							(= local0 6)
						)
					)
					(4
						(if (== gCurRoomNum 17)
							(= local0 7)
						else
							(= local0 6)
						)
					)
					(5
						(= local0 8)
					)
					(6
						(= local0 9)
					)
					(7
						(= local0 10)
					)
					(8
						(= local0 11)
					)
					(9
						(= local0 12)
					)
					(10
						(= local0 13)
					)
				)
				(if (!= local0 -1)
					(= temp0 (<< local0 $0001))
					(global209 claimed: 1)
					(cond
						((== local0 8)
							(proc243_1
								local0
								[local1 temp0]
								[local1 (++ temp0)]
							)
						)
						((>= local0 4)
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

