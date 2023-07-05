;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29450)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm29v450 0
)

(instance rm29v450 of ShiversRoom
	(properties
		picture 29450
	)

	(method (init)
		(pDoorProp init:)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29460
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29460
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30020
	)

	(method (init)
		(self createPoly: 92 143 92 27 168 27 168 143 92 143)
		(super init: &rest)
	)
)

(instance pDoorProp of ShiversProp
	(properties
		priority 10
		fixPriority 1
		view 29450
		cycleSpeed 18
	)

	(method (doVerb)
		(self createPoly: -1 -1 -1 -1 -1 -1)
		(gSounds play: 13013 0 82 0)
		(self setCycle: End)
		(efExitForward init: 3)
		(SetFlag 43)
	)
)

