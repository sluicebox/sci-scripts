;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(class SlowTurn of Code
	(properties
		view -1
		client 0
		caller 0
	)

	(method (doit param1 param2 param3 &tmp temp0 temp1)
		(if (not client)
			(= client param1)
		)
		(if (>= argc 3)
			(= caller param3)
		)
		(= temp1 (& (/ (+ param2 45) 90) $0003))
		(client loop: temp1 cel: 0 setCycle: End self)
		(gUser canInput: 0)
		((gUser hotCursor:) isHot: 0)
	)

	(method (cue &tmp temp0)
		(= temp0 caller)
		(= client (= caller 0))
		(if temp0
			(temp0 cue:)
		)
		(gUser canInput: 1)
		((gUser hotCursor:) isHot: 1)
	)
)

