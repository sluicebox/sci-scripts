;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8030)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm8v030 0
)

(instance rm8v030 of ShiversRoom
	(properties
		picture 8030
	)

	(method (init)
		(if (and (proc951_11 1 8000) (or (== gPrevRoomNum 8140) (== gPrevRoomNum 8120))) ; rm8v140, rm8v120
			(proc951_7 20801)
			(proc951_9 20801)
			(gSounds play: 20801 -1 0 0)
			(gSounds fade: 20801 66 5 16 0 0)
			(gSounds fade: 20802 0 5 8 1 0)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(pDoor init:)
		(hsDoor init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 6)
		(== newRoomNumber 9450) ; rm9v45
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8040
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9450
	)

	(method (init)
		(self createPoly: 97 142 93 19 182 19 176 142)
		(super init: &rest)
	)
)

(instance pDoor of Prop
	(properties
		view 8030
		cycleSpeed 18
	)
)

(instance hsDoor of HotSpot
	(properties)

	(method (init)
		(self createPoly: 92 0 184 0 177 142 97 142 91 0)
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
				(proc951_7 10809)
				(= cycles 1)
			)
			(1
				(pDoor setCycle: End)
				(gSounds play: 10809 0 40 self)
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

