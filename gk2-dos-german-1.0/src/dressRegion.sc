;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1030)
(include sci.sh)
(use Main)
(use Timer)
(use Game)

(public
	dressRegion 0
	engelTimer 1
)

(instance dressRegion of Rgn
	(properties
		modNum 1160
		keep 1
	)

	(method (init)
		(super init: &rest)
		(= timer engelTimer)
	)
)

(instance engelTimer of Timer
	(properties)

	(method (cue)
		(if (gCurRoom script:)
			(self setReal: self 2)
		else
			(gCurRoom notify:)
			(self dispose: delete:)
		)
	)
)

