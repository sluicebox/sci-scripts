;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23250)
(include sci.sh)
(use Main)

(public
	rm23v250 0
)

(instance rm23v250 of ShiversRoom
	(properties
		picture 23250
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23220
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23240
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23210
	)

	(method (init)
		(self
			createPoly:
				190
				125
				86
				125
				107
				107
				107
				56
				135
				56
				173
				43
				181
				43
				181
				116
				189
				124
		)
		(super init: &rest)
	)
)

