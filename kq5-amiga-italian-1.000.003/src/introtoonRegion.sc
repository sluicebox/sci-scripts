;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 769)
(include sci.sh)
(use Main)
(use Game)
(use System)

(public
	introtoonRegion 0
)

(instance introtoonRegion of Rgn
	(properties)

	(method (init)
		((= gMouseDownHandler myMouseDownHandler) addToFront: self)
		((= gKeyDownHandler myKeyDownHandler) addToFront: self)
		(super init: &rest)
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (event type:)
			(event claimed: 1)
			(gGame restart: 0)
		)
	)

	(method (dispose)
		(myMouseDownHandler release: dispose:)
		(myKeyDownHandler release: dispose:)
		(= gMouseDownHandler (= gKeyDownHandler 0))
		(super dispose:)
	)
)

(instance myMouseDownHandler of EventHandler
	(properties)
)

(instance myKeyDownHandler of EventHandler
	(properties)
)

