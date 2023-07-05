;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9100)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)

(public
	rm9v10 0
)

(instance rm9v10 of ShiversRoom
	(properties
		picture 9100
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitLeftLow init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efExitFountain init: 9)
		(pFountain init:)
		(if (IsFlag 42)
			((Prop new:)
				view: 9100
				setPri: 5 1
				loop: 1
				cycleSpeed: 12
				setCycle: Fwd
				init:
			)
		else
			((Prop new:) view: 9100 setPri: 5 1 loop: 0 init:)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9090
	)

	(method (init)
		(self createPoly: 1 1 20 1 20 43 1 43)
		(super init: &rest)
	)
)

(instance efExitLeftLow of ExitFeature
	(properties
		nextRoom 9090
	)

	(method (init)
		(self createPoly: 1 107 20 107 20 143 1 143)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9110
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9710
	)

	(method (init)
		(self createPoly: 30 142 68 103 68 58 186 58 186 107 204 142)
		(super init: &rest)
	)
)

(instance efExitFountain of ExitFeature
	(properties
		nextRoom 9710
	)

	(method (init)
		(self createPoly: 0 105 20 105 53 99 54 84 40 72 0 54 20 54)
		(super init: &rest)
	)
)

(instance pFountain of ShiversProp
	(properties
		priority 3
		fixPriority 1
		view 9100
	)
)

