;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30390)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)

(public
	rm30v390 0
)

(instance rm30v390 of ShiversRoom
	(properties
		picture 30390
	)

	(method (init)
		(cond
			((and (not (IsFlag 58)) (IsFlag 85))
				(pCrateDoor init:)
				(pCrateDoor setCel: (pCrateDoor lastCel:))
				(pCrateDoor createPoly: 0 0 0 0 0 0)
				(efExitForward init: 3)
			)
			((IsFlag 58)
				(self picture: 30391)
				(if (!= [global118 39] 0)
					(vPotView init:)
				)
				(efExitForward init: 3)
			)
			(else
				(hCrateDoor init:)
			)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30400
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30380
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30420
	)

	(method (init)
		(self createPoly: 197 14 44 14 44 119 200 119 200 14)
		(super init: &rest)
	)
)

(instance vPotView of View
	(properties
		x 130
		y 74
		view 0
	)

	(method (init)
		(self view: [global118 39] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 17 scaleY: 17 setPri: 10)
	)
)

(instance pCrateDoor of ShiversProp
	(properties
		priority 10
		fixPriority 1
		view 30390
	)
)

(instance hCrateDoor of HotSpot
	(properties)

	(method (init)
		(self createPoly: 197 14 44 14 44 119 200 119 200 14)
		(super init: &rest)
	)

	(method (doVerb)
		(SetFlag 85)
		(pCrateDoor init:)
		(pCrateDoor cycleSpeed: 24)
		(pCrateDoor setCycle: End)
		(pCrateDoor createPoly: 0 0 0 0 0 0)
		(gSounds play: 13003 0 82 0)
		(efExitForward init: 3)
		(self dispose:)
	)
)

