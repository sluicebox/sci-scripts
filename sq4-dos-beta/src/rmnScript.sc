;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 810)
(include sci.sh)
(use User)
(use System)

(class rmnScript of Script
	(properties
		save1 0
		DTimer 10
		counter 0
	)

	(method (init)
		(= counter DTimer)
		(super init: &rest)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (and (self save1:) (<= (-- counter) 0) ((User curEvent:) type:))
			(self restore:)
			(while ((= temp0 (Event new:)) type:)
				(temp0 dispose:)
			)
			(temp0 dispose:)
			(= seconds 0)
			(= cycles 1)
		)
	)

	(method (restore)
		(if (self save1:)
			(Display 810 0 dsRESTOREPIXELS (self save1:))
			(self save1: 0)
			(self counter: DTimer)
		)
	)
)

