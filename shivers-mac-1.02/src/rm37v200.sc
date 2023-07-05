;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37200)
(include sci.sh)
(use Main)

(public
	rm37v200 0
)

(instance rm37v200 of ShiversRoom
	(properties
		picture 37200
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37190
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37170
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37160
	)

	(method (init)
		(self
			createPoly:
				189
				117
				143
				134
				97
				130
				97
				112
				109
				100
				111
				53
				166
				54
				166
				82
				152
				82
				156
				103
				170
				107
		)
		(super init: &rest)
	)
)

