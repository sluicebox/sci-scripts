;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9890)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)

(public
	rm9v890 0
)

(instance rm9v890 of ShiversRoom
	(properties
		picture 9890
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 42)
			((Prop new:)
				view: 9890
				setPri: 5 1
				loop: 1
				cycleSpeed: 12
				setCycle: Fwd
				init:
			)
		else
			((Prop new:) view: 9890 setPri: 5 1 loop: 0 init:)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9880
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9910
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9170
	)

	(method (init)
		(self createPoly: 148 130 86 131 91 102 89 45 191 43 200 97 141 99)
		(super init: &rest)
	)
)

