;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32076)
(include sci.sh)
(use Main)
(use n951)
(use n32001)
(use Motion)

(public
	rm32v076 0
)

(instance rm32v076 of ShiversRoom
	(properties
		picture 32076
	)

	(method (init)
		(pDoor init:)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (< newRoomNumber 32000)
			(proc32001_1)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32010
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30440
	)

	(method (init)
		(self createPoly: 158 141 158 43 83 43 83 142 158 142)
		(super init: &rest)
	)
)

(instance pDoor of ShiversProp
	(properties
		priority 120
		fixPriority 1
		view 32070
		cycleSpeed 18
	)

	(method (init)
		(if (IsFlag 85)
			(self view: 32072)
		)
		(super init: &rest)
		(self createPoly: 158 141 158 43 83 43 83 142 158 142)
	)

	(method (doVerb)
		(if (not (IsFlag 43))
			(self cel: 0)
			(gSounds play: 13013 0 82 0)
			(self setCycle: End)
			(self createPoly: 1 1 1 1 1 1 1 1)
			(efExitForward init: 3)
			(SetFlag 43)
		)
	)
)

