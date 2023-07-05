;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37020)
(include sci.sh)
(use Main)
(use n951)

(public
	rm37v020 0
)

(instance rm37v020 of ShiversRoom
	(properties
		picture 37020
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
		nextRoom 37010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37030
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37120
	)

	(method (init)
		(self createPoly: 98 135 98 96 122 84 134 50 173 45 175 115)
		(super init: &rest)
	)
)

