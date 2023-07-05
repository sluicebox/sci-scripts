;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37040)
(include sci.sh)
(use Main)
(use n951)

(public
	rm37v040 0
)

(instance rm37v040 of ShiversRoom
	(properties
		picture 37040
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 43)
			(gSounds play: 10614 0 40 0)
			(ClearFlag 43)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37030
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37010
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37060
	)

	(method (init)
		(self createPoly: 141 140 23 123 23 28 45 27 156 20)
		(super init: &rest)
	)
)

