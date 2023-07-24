;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18110)
(include sci.sh)
(use Main)

(public
	rm18v11 0
)

(instance rm18v11 of ShiversRoom
	(properties
		picture 18110
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
		nextRoom 18120
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18120
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 18080
	)

	(method (init)
		(self
			createPoly: 43 143 52 136 92 136 96 91 105 67 126 43 142 60 156 82 161 136 237 136 237 143
		)
		(super init: &rest)
	)
)

