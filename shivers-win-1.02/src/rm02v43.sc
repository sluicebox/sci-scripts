;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2430)
(include sci.sh)
(use Main)
(use n951)

(public
	rm02v43 0
)

(instance rm02v43 of ShiversRoom
	(properties
		picture 2080
	)

	(method (init)
		(if (not (IsFlag 2))
			(self picture: 2081)
		)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2540
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 222
		nextRoom 2420
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2450
	)

	(method (init)
		(if (not (IsFlag 2))
			(= nextRoom 2720)
		)
		(self
			createPoly: 36 142 114 76 114 57 119 50 137 50 145 66 145 76 214 142
		)
		(super init: &rest)
	)
)

