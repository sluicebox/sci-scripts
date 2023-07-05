;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37030)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm37v030 0
)

(instance rm37v030 of ShiversRoom
	(properties
		picture 37030
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(hsDoor init:)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37040
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37310
	)

	(method (init)
		(self createPoly: 82 142 81 5 190 3 189 142)
		(super init: &rest)
	)
)

(instance pDoor of Prop
	(properties
		view 37030
		cycleSpeed 18
	)
)

(instance hsDoor of HotSpot
	(properties)

	(method (init)
		(self createPoly: 82 142 81 5 190 3 189 142)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sDoorOpens)
	)
)

(instance sDoorOpens of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(pDoor init: setPri: 25 1)
				(proc951_7 10613)
				(= cycles 1)
			)
			(1
				(pDoor setCycle: End)
				(gSounds play: 10613 0 40 self)
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

