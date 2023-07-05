;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9470)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm9v47 0
)

(instance rm9v47 of ShiversRoom
	(properties
		picture 9470
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(hsDoor init:)
		(if (IsFlag 42)
			(cond
				((or (== gPrevRoomNum 9850) (< 9300 gPrevRoomNum 9440)) ; rm9v850, rm9v30, rm9v44
					(PrintDebug {fade to 8})
					(gSounds fade: 10908 8 15 8 0 0)
				)
				((< 9000 gPrevRoomNum 9300) ; rm9v30
					(proc951_7 10908)
					(proc951_9 10908)
					(gSounds play: 10908 -1 8 0)
				)
			)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 2)
		(if (< 1000 newRoomNumber 9000) ; rm1v00
			(gSounds fade: 20903 0 15 8 1 0)
			(PrintDebug {fade to 0})
			(gSounds fade: 10908 0 15 8 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9460
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9440
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8000
	)

	(method (init)
		(self createPoly: 77 143 77 0 184 0 184 142)
		(super init: &rest)
	)
)

(instance pDoor of Prop
	(properties
		priority 25
		fixPriority 1
		view 9470
		cycleSpeed 27
	)
)

(instance hsDoor of HotSpot
	(properties)

	(method (init)
		(self createPoly: 77 143 77 0 184 0 184 142)
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
				(proc951_7 10903)
				(= cycles 1)
			)
			(1
				(pDoor setCycle: End)
				(gSounds play: 10903 0 40 self)
			)
			(2
				(gGame handsOn:)
				(efExitForward init: 3)
				(SetFlag 43)
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
		x 61
		y 115
		priority 250
		fixPriority 1
		view 921
		cel 1
	)
)

