;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16030)
(include sci.sh)
(use Main)
(use n951)

(public
	rm16v30 0
)

(instance rm16v30 of ShiversRoom
	(properties
		picture 16030
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 43)
			(gSounds play: 11602 0 82 0)
			(ClearFlag 43)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16000
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16210
	)

	(method (init)
		(self createPoly: 69 145 112 114 112 75 174 75 174 110 174 113 230 143)
		(super init: &rest)
	)
)

