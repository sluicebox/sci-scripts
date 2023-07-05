;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2740)
(include sci.sh)
(use Main)

(public
	rm2v74 0
)

(instance rm2v74 of ShiversRoom
	(properties
		picture 2100
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
		nextRoom 2730
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2730
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2500
	)

	(method (init)
		(self
			createPoly: 49 143 97 97 100 71 119 47 146 47 157 60 159 90 222 142
		)
		(super init: &rest)
	)
)

