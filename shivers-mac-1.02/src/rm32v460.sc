;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32460)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)

(public
	rm32v460 0
)

(instance rm32v460 of ShiversRoom
	(properties
		picture 32460
	)

	(method (init)
		(if (and (IsFlag 43) (== gPrevRoomNum 32450)) ; rm32v450
			(gSounds play: 13218 0 82 0)
		)
		(ClearFlag 43)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(hsDoor init:)
		(pDoor init:)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32230
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32450
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32490
	)

	(method (init)
		(self createPoly: 184 141 184 27 82 27 82 140 184 140)
		(super init: &rest)
	)
)

(instance hsDoor of HotSpot
	(properties)

	(method (init)
		(self createPoly: 184 141 184 27 82 27 82 140 184 140)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 156)
		(gSounds play: 13203 0 82 0)
		(pDoor cycleSpeed: 3 setCycle: End)
		(SetFlag 43)
		(efExitForward init: 3)
		(self dispose:)
	)
)

(instance pDoor of Prop
	(properties
		priority 5
		fixPriority 1
		view 32460
		cycleSpeed 18
	)
)

