;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40190)
(include sci.sh)
(use Main)

(public
	rm40v190 0
)

(instance rm40v190 of ShiversRoom
	(properties
		picture 40130
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 40170
	)

	(method (init)
		(self
			createPoly:
				53
				109
				53
				127
				202
				127
				216
				0
				148
				0
				111
				104
				101
				99
				67
				112
				53
				108
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40180
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40180
	)
)

