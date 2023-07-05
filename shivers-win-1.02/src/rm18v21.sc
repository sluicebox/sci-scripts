;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18210)
(include sci.sh)
(use Main)
(use n951)

(public
	rm18v21 0
)

(instance rm18v21 of ShiversRoom
	(properties
		picture 18210
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
		(if (IsFlag 43)
			(gSounds play: 11712 0 32 0)
			(ClearFlag 43)
		)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 18220
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18220
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 18190
	)

	(method (init)
		(self
			createPoly:
				23
				141
				100
				123
				120
				50
				118
				12
				150
				12
				146
				66
				160
				122
				234
				141
		)
		(super init: &rest)
	)
)

