;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 133)
(include sci.sh)
(use Rev)
(use Motion)

(class HardStopFwd of Fwd
	(properties
		hardStopCel -1
	)

	(method (init param1 param2 param3)
		(if (and (== argc 3) param3)
			(= caller param3)
		)
		(= hardStopCel param2)
		(super init: param1)
	)

	(method (doit)
		(if (and (!= hardStopCel -1) (== (client cel:) hardStopCel))
			(= completed 1)
			(self motionCue:)
		else
			(super doit: &rest)
		)
	)

	(method (cycleDone)
		(client cel: 0)
	)
)

(class HardStopRev of Rev
	(properties
		hardStopCel -1
	)

	(method (init param1 param2 param3)
		(if (and (== argc 3) param3)
			(= caller param3)
		)
		(= hardStopCel param2)
		(super init: param1)
	)

	(method (doit)
		(if (and (!= hardStopCel -1) (== (client cel:) hardStopCel))
			(= completed 1)
			(self motionCue:)
		else
			(super doit: &rest)
		)
	)
)

