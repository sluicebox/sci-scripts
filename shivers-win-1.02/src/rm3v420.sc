;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3420)
(include sci.sh)
(use Main)
(use Actor)
(use System)

(public
	rm3v420 0
)

(instance rm3v420 of ShiversRoom
	(properties
		picture 3420
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3450
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3430
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 3310
	)

	(method (init)
		(self createPoly: 90 89 72 5 239 8 206 91)
		(super init: &rest)
	)

	(method (handleEvent event)
		(event localize: gThePlane)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(self onMe: event)
				(gUser canControl:)
			)
			(event claimed: 1)
			(if (== global186 1)
				(gCurRoom setScript: sPurchaseMe)
			)
		)
		(super handleEvent: event)
	)
)

(instance hsDialogArea of HotSpot
	(properties
		nsRight 266
		nsBottom 143
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (doVerb)
		(vDialog dispose:)
		(self dispose:)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance vDialog of View
	(properties
		x 60
		y 110
		priority 250
		fixPriority 1
		view 921
		cel 2
	)
)

(instance sPurchaseMe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(vDialog init:)
				(gSounds play: 35020 0 106 self)
			)
			(1
				(hsDialogArea init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

