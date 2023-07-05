;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21370)
(include sci.sh)
(use Main)

(public
	rm21v370 0
)

(instance rm21v370 of ShiversRoom
	(properties
		picture 21370
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21340
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21340
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21380
	)

	(method (init)
		(self
			createPoly:
				77
				27
				170
				27
				190
				127
				204
				140
				58
				140
				74
				119
				73
				70
				66
				44
				77
				27
		)
		(super init: &rest)
	)
)

