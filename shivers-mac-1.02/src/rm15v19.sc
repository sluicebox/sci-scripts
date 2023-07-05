;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15190)
(include sci.sh)
(use Main)

(public
	rm15v19 0
)

(instance rm15v19 of ShiversRoom
	(properties
		picture 15190
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 15210
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15220
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 15170
	)

	(method (init)
		(self
			createPoly:
				54
				125
				75
				107
				111
				107
				111
				85
				138
				85
				138
				107
				178
				107
				194
				131
				48
				131
		)
		(super init: &rest)
	)
)

