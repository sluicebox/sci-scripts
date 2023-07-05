;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32410)
(include sci.sh)
(use Main)

(public
	rm32v410 0
)

(instance rm32v410 of ShiversRoom
	(properties
		picture 32410
	)

	(method (init)
		(efExitPuzzle init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32390
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32350
	)
)

(instance efExitPuzzle of ExitFeature
	(properties
		nextRoom 32059
	)

	(method (init)
		(self
			createPoly:
				126
				143
				126
				111
				148
				110
				147
				90
				96
				90
				93
				109
				116
				109
				116
				143
				126
				143
		)
		(super init: &rest)
	)
)

