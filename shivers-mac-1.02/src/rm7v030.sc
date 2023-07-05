;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7030)
(include sci.sh)
(use Main)
(use n951)

(public
	rm7v030 0
)

(instance rm7v030 of ShiversRoom
	(properties
		picture 7030
	)

	(method (init)
		(efExitForward init: 9)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(if (IsFlag 43)
			(gSounds play: 10712 0 40 0)
			(ClearFlag 43)
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7010
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 7300
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 7040
	)

	(method (init)
		(self createPoly: 63 14 63 120 187 120 187 15)
		(super init: &rest)
	)
)

