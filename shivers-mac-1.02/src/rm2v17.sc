;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2170)
(include sci.sh)
(use Main)

(public
	rm2v17 0
)

(instance rm2v17 of ShiversRoom
	(properties
		picture 2170
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2460
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2160
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2190
	)

	(method (init)
		(self
			createPoly:
				75
				143
				101
				105
				118
				83
				131
				81
				139
				81
				152
				85
				167
				102
				194
				142
		)
		(super init: &rest)
	)
)

