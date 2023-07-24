;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18220)
(include sci.sh)
(use Main)

(public
	rm18v22 0
)

(instance rm18v22 of ShiversRoom
	(properties
		picture 18220
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 18210
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18210
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 18230
	)

	(method (init)
		(self
			createPoly: 75 142 81 123 92 104 104 103 110 37 151 37 155 103 163 103 180 142
		)
		(super init: &rest)
	)
)

