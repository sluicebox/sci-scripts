;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9750)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)

(public
	rm9v75 0
)

(instance rm9v75 of ShiversRoom
	(properties
		picture 9750
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 42)
			((Prop new:)
				view: 9750
				setPri: 5 1
				loop: 1
				cycleSpeed: 12
				setCycle: Fwd
				init:
			)
		else
			((Prop new:) view: 9750 setPri: 5 1 loop: 0 init:)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9760
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9050
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9440
	)

	(method (init)
		(self createPoly: 118 105 120 4 161 18 173 77 200 114 196 128 143 115)
		(super init: &rest)
	)
)

