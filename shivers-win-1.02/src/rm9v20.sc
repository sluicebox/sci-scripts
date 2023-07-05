;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9200)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)

(public
	rm9v20 0
)

(instance rm9v20 of ShiversRoom
	(properties
		picture 9200
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 42)
			((Prop new:)
				view: 9200
				setPri: 5 1
				loop: 1
				cycleSpeed: 12
				setCycle: Fwd
				init:
			)
		else
			((Prop new:) view: 9200 setPri: 5 1 loop: 0 init:)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9230
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9210
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9160
	)

	(method (init)
		(self createPoly: 58 143 91 92 91 43 126 43 126 92 189 142)
		(super init: &rest)
	)
)

