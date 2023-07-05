;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 807)
(include sci.sh)
(use Main)
(use StopWalk)
(use Sound)

(local
	local0
	[local1 3] = [924 925 926]
	[local4 7] = [0 3 16 23 29 33 36]
	[local11 56] = [17 17 36 18 36 36 10 18 17 17 34 17 144 144 132 132 9 9 34 9 18 18 18 18 17 17 9 9 9 9 36 36 136 136 9 9 9 9 18 9 17 34 9 36 9 9 18 18 10 10 5 40 9 40 5 9]
	[local67 8] = [1 2 4 8 16 32 64 128]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (<= temp0 6) ((++ temp0))
		(if (== [local4 temp0] (gEgo view:))
			(= local0 (* 8 temp0))
		)
	)
)

(class FootstepWalk of StopWalk
	(properties)

	(method (init)
		(super init: &rest)
		(= vStopped
			(switch gDisguiseNum
				(1 37) ; beggar
				(2 30) ; jewler (no rouge)
				(3 30) ; jewler (rouge)
				(4 34) ; yeoman
				(5 24) ; abbey monk
				(6 17) ; fens monk
				(else 1)
			)
		)
		(localproc_0)
	)

	(method (doit &tmp temp0)
		(= temp0 (client cel:))
		(super doit:)
		(if
			(and
				(!= temp0 (client cel:))
				(& [local67 (client cel:)] [local11 (+ (client loop:) local0)])
			)
			(stepSound number: [local1 (Random 0 2)] play:)
			(++ global164)
		)
	)
)

(instance stepSound of Sound
	(properties
		flags 1
	)
)

