;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 910)
(include sci.sh)
(use Main)
(use System)

(class CartoonScript of Script
	(properties
		countDown 0
		time 10
	)

	(method (init)
		(= countDown time)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (doit)
		(if gModelessDialog
			(gUser canInput: 1)
			(if (> countDown 0)
				(-- countDown)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(if
			(and
				gModelessDialog
				(or
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
					(== (event type:) evMOUSEBUTTON)
				)
			)
			(event claimed: 1)
			(if (not countDown)
				(gUser canInput: 0)
				(gModelessDialog seconds: 0 dispose:)
				(= countDown time)
			)
		)
		(return 1)
	)
)

