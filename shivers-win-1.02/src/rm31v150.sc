;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31150)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm31v150 0
)

(instance rm31v150 of ShiversRoom
	(properties
		picture 31150
	)

	(method (init)
		(pDoorProp init:)
		(ClearFlag 43)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)

	(method (newRoom)
		(if (IsFlag 43)
			(gSounds play: 13119 0 82 0)
			(ClearFlag 43)
		)
		(super newRoom: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31070
	)

	(method (init)
		(self createPoly: 76 70 190 70 190 143 77 143 76 71)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31200
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31140
	)
)

(instance pDoorProp of ShiversProp
	(properties
		priority 40
		fixPriority 1
		view 31150
	)

	(method (doVerb)
		(gSounds play: 13115 0 82 0)
		(SetFlag 43)
		(self setCycle: End)
		(efExitForward init: 3)
		(self createPoly: 0 0 0 0 0 0 0 0 0 0)
	)
)

