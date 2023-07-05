;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17130)
(include sci.sh)
(use Main)

(public
	rm17v130 0
)

(instance rm17v130 of ShiversRoom
	(properties
		picture 17130
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
		nextRoom 17170
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 17190
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 17110
	)

	(method (init)
		(self
			createPoly:
				93
				118
				93
				38
				221
				38
				221
				88
				233
				95
				233
				137
				186
				136
				181
				121
		)
		(super init: &rest)
	)
)

