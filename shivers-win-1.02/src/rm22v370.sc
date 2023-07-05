;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22370)
(include sci.sh)
(use Main)
(use n951)

(public
	rm22v370 0
)

(instance rm22v370 of ShiversRoom
	(properties
		picture 22370
	)

	(method (init)
		(efExitSecret init: 3)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (IsFlag 22)
			(self picture: 22371)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22360
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22380
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 22210
	)

	(method (init)
		(self createPoly: 98 4 98 111 178 129 178 1 98 1 98 5)
		(super init: &rest)
	)
)

(instance efExitSecret of ExitFeature
	(properties
		nextRoom 22250
	)

	(method (init)
		(self createPoly: 29 43 84 47 83 105 27 113 29 44)
		(super init: &rest)
	)
)

