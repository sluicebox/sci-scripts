;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 810)
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
		(if (not (gPrints contains: self))
			(gPrints addToFront: self)
		)
		(if (not (gWalkHandler contains: self))
			(gWalkHandler addToFront: self)
		)
		(if (not (gTextSpeed contains: self))
			(gTextSpeed addToFront: self)
		)
		(= counter DTimer)
		(super init: &rest)
	)

	(method (dispose)
		(gPrints delete: self)
		(gWalkHandler delete: self)
		(gTextSpeed delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(cond
			((and save1 (<= counter 0))
				(event claimed: 1)
				(self restore:)
				(= seconds 0)
				(= cycles 1)
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

	(method (restore)
		(if save1
			(Display 810 0 dsRESTOREPIXELS save1)
			(= save1 0)
			(= counter DTimer)
		)
	)
)

