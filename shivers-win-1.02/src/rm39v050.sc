;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39050)
(include sci.sh)
(use Main)

(public
	rm39v050 0
)

(instance rm39v050 of ShiversRoom
	(properties
		picture 39050
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 39060
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 39080
	)
)

(instance efForward of ExitFeature
	(properties
		nextRoom 39020
	)

	(method (init)
		(self
			createPoly:
				46
				135
				43
				22
				55
				27
				59
				121
				67
				113
				67
				62
				190
				62
				189
				111
				208
				136
		)
		(super init: &rest)
	)
)

