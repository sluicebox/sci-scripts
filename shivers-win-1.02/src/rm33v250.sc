;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33250)
(include sci.sh)
(use Main)
(use n951)

(public
	rm33v250 0
)

(instance rm33v250 of ShiversRoom
	(properties
		picture 33250
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(if (IsFlag 43)
			(ClearFlag 43)
			(gSounds play: 13012 0 82 0)
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 33260
	)

	(method (init)
		(self
			createPoly:
				86
				142
				105
				117
				113
				117
				113
				45
				161
				45
				161
				117
				166
				117
				183
				142
				86
				142
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33050
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33050
	)
)

