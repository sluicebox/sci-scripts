;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7300)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm7v300 0
)

(instance rm7v300 of ShiversRoom
	(properties
		picture 7300
	)

	(method (init)
		(spDoor init:)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance spDoor of ShiversProp
	(properties
		priority 20
		fixPriority 1
		view 7300
		cycleSpeed 27
	)

	(method (doVerb)
		(SetFlag 43)
		(gMouseDownHandler delete: self)
		(gSounds play: 10711 0 40 0)
		(self setCycle: End)
		(efExitForward init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 7020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7030
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 6270
	)

	(method (init)
		(self createPoly: 85 4 85 142 179 142 179 4 86 4)
		(super init: &rest)
	)
)

