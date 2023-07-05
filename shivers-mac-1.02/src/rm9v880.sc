;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9880)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)

(public
	rm9v880 0
)

(instance rm9v880 of ShiversRoom
	(properties
		picture 9880
	)

	(method (init)
		(efExitLeft init: 7)
		(efLeftToSecret init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 42)
			((Prop new:)
				view: 9880
				setPri: 5 1
				loop: 1
				cycleSpeed: 12
				setCycle: Fwd
				init:
			)
		else
			((Prop new:) view: 9880 setPri: 5 1 loop: 0 init:)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9910
	)

	(method (init)
		(self createPoly: 33 142 16 0 0 0 0 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9890
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9160
	)

	(method (init)
		(self createPoly: 128 106 127 47 178 47 245 53 245 117 141 116)
		(super init: &rest)
	)
)

(instance efLeftToSecret of ExitFeature
	(properties
		nextRoom 9630
	)

	(method (init)
		(self createPoly: 33 138 26 74 55 68 61 128)
		(super init: &rest)
	)
)

