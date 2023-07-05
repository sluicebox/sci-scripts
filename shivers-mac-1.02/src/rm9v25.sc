;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9250)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)

(public
	rm9v25 0
)

(instance rm9v25 of ShiversRoom
	(properties
		picture 9250
	)

	(method (init)
		(efExitBirds init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 42)
			((Prop new:)
				view: 9250
				setPri: 5 1
				loop: 1
				cycleSpeed: 12
				setCycle: Fwd
				init:
			)
		else
			((Prop new:) view: 9250 setPri: 5 1 loop: 0 init:)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9960
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9940
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9320
	)

	(method (init)
		(self createPoly: 148 88 149 143 228 137 168 90)
		(super init: &rest)
	)
)

(instance efExitBirds of ExitFeature
	(properties
		nextRoom 9120
	)

	(method (init)
		(self createPoly: 22 43 55 50 55 105 22 105 22 43)
		(super init: &rest)
	)
)

