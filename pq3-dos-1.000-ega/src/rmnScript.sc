;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 883)
(include sci.sh)
(use Main)
(use System)

(class rmnScript of Script
	(properties
		save1 0
		DTimer 10
		counter 0
	)

	(method (init)
		(if (not (gKeyDownHandler contains: self))
			(gKeyDownHandler addToFront: self)
		)
		(if (not (gMouseDownHandler contains: self))
			(gMouseDownHandler addToFront: self)
		)
		(if (not (gDirectionHandler contains: self))
			(gDirectionHandler addToFront: self)
		)
		(= counter DTimer)
		(super init: &rest)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(gDirectionHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(cond
			((and (== seconds 0) (< cycles 2)) 0)
			((and save1 (<= counter 0))
				(event claimed: 1)
				(self restore:)
			)
			(save1
				(event claimed: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if save1
			(-- counter)
		)
	)

	(method (cue)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(super cue:)
	)

	(method (restore)
		(= seconds (= cycles (= save1 0)))
		(= counter DTimer)
		(self cue:)
	)
)

