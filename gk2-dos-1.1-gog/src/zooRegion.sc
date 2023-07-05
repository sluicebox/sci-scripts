;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2299)
(include sci.sh)
(use Main)
(use Timer)
(use Game)

(public
	zooRegion 0
	ThomasLeaveTimer 1
)

(instance zooRegion of Rgn
	(properties
		keep 1
	)

	(method (init)
		(super init: &rest)
		(= timer ThomasLeaveTimer)
	)
)

(instance ThomasLeaveTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom notify:)
	)
)

