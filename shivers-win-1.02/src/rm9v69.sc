;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9690)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm9v69 0
)

(local
	local0
	local1
)

(instance rm9v69 of ShiversRoom
	(properties
		picture 9690
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
		(if (IsFlag 28)
			(hsDoor init:)
			(if (== gPrevRoomNum 9691) ; rm9v691
				(spPuzzle cel: (spPuzzle lastCel:) init:)
				(gCurRoom setScript: sDoorOpens)
			else
				(spPuzzle init:)
			)
		else
			(spPuzzle init:)
			(if (== gPrevRoomNum 9691) ; rm9v691
				(gSounds play: 10926 0 82 0)
				(spPuzzle cel: (spPuzzle lastCel:) setCycle: Beg)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (>= newRoomNumber 10000)
			(gSounds fade: 20903 0 15 8 1 0)
		)
		(super newRoom: newRoomNumber &rest)
		(if (and local0 (< 1000 newRoomNumber 10000)) ; rm1v00
			(gSounds play: 10904 0 40 0)
		)
		(if (and local1 (!= newRoomNumber 9691) (< 1000 newRoomNumber 10000)) ; rm9v691, rm1v00
			(gSounds play: 10926 0 82 0)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9680
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9680
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16000
	)

	(method (init)
		(self createPoly: 41 142 30 8 234 8 221 141)
		(super init: &rest)
	)
)

(instance efPuzzle of ExitFeature
	(properties
		nextRoom 9691
	)

	(method (init)
		(self createPoly: 69 25 69 109 200 109 200 25 70 25)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance spPuzzle of ShiversProp
	(properties
		priority 100
		fixPriority 1
		view 9692
		cycleSpeed 12
	)

	(method (init)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
		(super init: &rest)
	)

	(method (doVerb)
		(gSounds play: 10925 0 82 0)
		(= local1 1)
		(self createPoly: -1 -1 -1 -1 -1 -1 setCycle: End)
		(efPuzzle init: 3)
	)
)

(instance pDoor of Prop
	(properties
		priority 25
		fixPriority 1
		view 9690
		cycleSpeed 27
	)

	(method (init)
		(if (IsFlag 13)
			(self view: 9691)
		)
		(super init: &rest)
	)
)

(instance hsDoor of HotSpot
	(properties)

	(method (init)
		(self createPoly: 41 142 30 8 234 8 221 141)
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
				(efPuzzle dispose:)
				(pDoor init:)
				(if (IsFlag 13)
					(pDoor view: 9691)
				)
				(proc951_7 10903)
				(if (== gPrevRoomNum 9691) ; rm9v691
					(gSounds play: 10926 0 82 0)
					(spPuzzle setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(1
				(spPuzzle hide:)
				(pDoor setCycle: End)
				(gSounds play: 10903 0 82 self)
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
		x 61
		y 115
		priority 250
		fixPriority 1
		view 921
		cel 3
	)
)

