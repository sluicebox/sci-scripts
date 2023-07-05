;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 231)
(include sci.sh)
(use Motion)

(public
	ForwardFrom 0
)

(class ForwardFrom of Fwd
	(properties
		startAt 0
		cycleCount -1
	)

	(method (init param1 param2 param3 param4)
		(= client param1)
		(client cel: (= startAt param2))
		(if (> argc 2)
			(= cycleCount param3)
			(if (> argc 3)
				(= caller param4)
			)
		)
	)

	(method (cycleDone)
		(client cel: startAt)
		(if (not (-- cycleCount))
			(= completed 1)
			(self motionCue:)
		)
	)
)

