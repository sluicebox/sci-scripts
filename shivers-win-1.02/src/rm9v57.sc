;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9570)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm9v57 0
)

(local
	local0
)

(instance rm9v57 of ShiversRoom
	(properties
		picture 9570
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(hsDoor init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (>= newRoomNumber 10000)
			(gSounds fade: 20903 0 15 8 1 0)
		)
		(if (and local0 (< newRoomNumber 10000))
			(gSounds play: 12020 0 82 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9560
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9560
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20060
	)

	(method (init)
		(self createPoly: 64 144 62 14 200 14 199 143)
		(super init: &rest)
	)
)

(instance pDoor of Prop
	(properties
		priority 25
		fixPriority 1
		view 9570
		cycleSpeed 27
	)
)

(instance hsDoor of HotSpot
	(properties)

	(method (init)
		(self createPoly: 64 144 62 14 200 14 199 143)
		(super init: &rest)
	)

	(method (doVerb)
		(if (== global186 0)
			(gCurRoom setScript: sDoorOpens)
		else
			(gCurRoom setScript: sPurchaseMe)
		)
	)
)

(instance sDoorOpens of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(pDoor init:)
				(proc951_7 12019)
				(= cycles 1)
			)
			(1
				(pDoor setCycle: End)
				(gSounds play: 12019 0 82 self)
			)
			(2
				(gGame handsOn:)
				(efExitForward init: 3)
				(= local0 1)
				(hsDoor dispose:)
				(self dispose:)
			)
		)
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

(instance vDialog of View
	(properties
		x 60
		y 120
		priority 250
		fixPriority 1
		view 921
		cel 4
	)
)

