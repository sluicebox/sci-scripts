;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2660)
(include sci.sh)
(use Main)
(use n951)

(public
	rm2v66 0
)

(instance rm2v66 of ShiversRoom
	(properties
		picture 2060
	)

	(method (init)
		(if (not (IsFlag 2))
			(self picture: 2072)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2650
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2650
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2370
	)

	(method (init)
		(if (not (IsFlag 2))
			(= nextRoom 2530)
		)
		(self
			createPoly: 50 142 109 76 109 59 121 49 141 49 153 57 153 78 213 143
		)
		(super init: &rest)
	)
)

