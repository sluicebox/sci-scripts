;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33260)
(include sci.sh)
(use Main)

(public
	rm33v260 0
)

(instance rm33v260 of ShiversRoom
	(properties
		picture 33260
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
		nextRoom 33270
	)

	(method (init)
		(self
			createPoly:
				88
				143
				106
				117
				109
				117
				109
				42
				161
				42
				161
				117
				167
				117
				183
				142
				89
				142
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33040
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33040
	)
)

