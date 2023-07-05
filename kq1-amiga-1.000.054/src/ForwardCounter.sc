;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 956)
(include sci.sh)
(use Motion)

(class ForwardCounter of Fwd
	(properties
		count 0
	)

	(method (init theObj num whoCares)
		(super init: theObj)
		(if (>= argc 2)
			(= count num)
			(if (>= argc 3)
				(= caller whoCares)
			)
		)
	)

	(method (cycleDone)
		(if (-- count)
			(super cycleDone:)
		else
			(= completed 1)
			(self motionCue:)
		)
	)
)

