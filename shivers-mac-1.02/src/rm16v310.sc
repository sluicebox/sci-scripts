;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16310)
(include sci.sh)
(use Main)
(use n951)

(public
	rm16v310 0
)

(instance rm16v310 of ShiversRoom
	(properties
		picture 16310
	)

	(method (init)
		(if (IsFlag 13)
			(= picture 16314)
		)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16740
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16330
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16320
	)

	(method (init)
		(self createPoly: 180 129 184 29 192 15 194 1 222 2 227 25 225 142)
		(super init: &rest)
	)
)

