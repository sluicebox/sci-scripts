;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9540)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)

(public
	rm9v54 0
)

(instance rm9v54 of ShiversRoom
	(properties
		picture 9540
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (IsFlag 42)
			((Prop new:)
				view: 9540
				setPri: 5 1
				loop: 1
				cycleSpeed: 12
				setCycle: Fwd
				init:
			)
		else
			((Prop new:) view: 9540 setPri: 5 1 loop: 0 init:)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9530
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9550
	)
)

