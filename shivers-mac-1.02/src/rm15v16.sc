;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15160)
(include sci.sh)
(use Main)

(public
	rm15v16 0
)

(instance rm15v16 of ShiversRoom
	(properties
		picture 15160
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 15150
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15150
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 15180
	)

	(method (init)
		(self
			createPoly: 25 143 109 30 109 0 156 0 156 30 165 30 200 100 218 120 218 141
		)
		(super init: &rest)
	)
)

