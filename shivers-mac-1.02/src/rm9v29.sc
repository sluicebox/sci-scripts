;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9290)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)

(public
	rm9v29 0
)

(instance rm9v29 of ShiversRoom
	(properties
		picture 9290
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 42)
			((Prop new:)
				view: 9290
				setPri: 5 1
				loop: 1
				cycleSpeed: 12
				setCycle: Fwd
				init:
			)
		else
			((Prop new:) view: 9290 setPri: 5 1 loop: 0 init:)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9260
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9280
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9320
	)

	(method (init)
		(self createPoly: 200 142 144 90 150 86 150 60 67 60 67 94 25 141)
		(super init: &rest)
	)
)

