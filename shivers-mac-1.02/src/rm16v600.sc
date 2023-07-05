;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16600)
(include sci.sh)
(use Main)

(public
	rm16v600 0
)

(instance rm16v600 of ShiversRoom
	(properties
		picture 16600
	)

	(method (init)
		(efBack init: 9)
		(hsKnife init:)
		(super init: &rest)
	)
)

(instance efBack of ExitFeature
	(properties
		nsLeft 0
		nsTop 0
		nsRight 264
		nsBottom 143
		nextRoom 16070
	)

	(method (init)
		(= nextRoom gPrevRoomNum)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (hsKnife onMe: event)
			(event claimed: 1)
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance hsKnife of HotSpot
	(properties
		nsLeft 87
		nsTop 35
		nsRight 181
		nsBottom 121
	)
)

