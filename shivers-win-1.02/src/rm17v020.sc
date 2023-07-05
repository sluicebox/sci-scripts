;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17020)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm17v020 0
)

(local
	local0
)

(instance rm17v020 of ShiversRoom
	(properties
		picture 17020
	)

	(method (init)
		(ClearFlag 43)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(hsDoor init:)
		(super init: &rest)
		(if (proc951_11 9 17000)
			(gSounds interruptChain:)
			(proc951_9 21703)
			(gSounds play: 21703 -1 50 0)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 9 17000) (>= newRoomNumber 18000))
			(gSounds fade: 21703 0 10 8 1 0)
			(gSounds adjChainVol: 35)
			(gSounds playChain: 21701 -1 -1 -2 21701 -1 -1 -2 21702 -1 -1 -2)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 17040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 17030
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 18210
	)

	(method (init)
		(self createPoly: 64 142 64 0 187 0 187 142)
		(super init: &rest)
	)
)

(instance hsDoor of HotSpot
	(properties)

	(method (init)
		(self createPoly: 64 142 64 0 187 0 187 142)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sOpenDoor)
	)
)

(instance pDoor of Prop
	(properties
		view 17020
		cycleSpeed 12
	)
)

(instance sOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hsDoor dispose:)
				(pDoor init: setPri: 25 1 setCycle: End self)
				(gSounds play: 11701 0 32 0)
			)
			(1
				(efExitForward init: 3)
				(SetFlag 43)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

