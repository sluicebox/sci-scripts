;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 765)
(include sci.sh)
(use Main)
(use System)

(class AudioScript of Script
	(properties
		waitForCue 0
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				waitForCue
				gTheSync
				(u>= (& (gTheSync prevCue:) $fff0) (& waitForCue $fff0))
			)
			(= cycles 1)
			(= waitForCue 0)
		)
	)
)

