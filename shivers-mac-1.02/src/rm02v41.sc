;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2410)
(include sci.sh)
(use Main)
(use n951)

(public
	rm02v41 0
)

(instance rm02v41 of ShiversRoom
	(properties
		picture 2100
	)

	(method (init)
		(if (not (IsFlag 2))
			(self picture: 2051)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2400
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2400
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2550
	)

	(method (init)
		(self
			createPoly: 49 143 97 97 100 71 119 47 146 47 157 60 159 90 222 142
		)
		(super init: &rest)
	)
)

