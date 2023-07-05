;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2460)
(include sci.sh)
(use Main)
(use n951)

(public
	rm02v46 0
)

(instance rm02v46 of ShiversRoom
	(properties
		picture 2050
	)

	(method (init)
		(if (not (IsFlag 2))
			(self picture: 2051)
			(efExitRightDark init: 6)
		else
			(efExitRight init: 1)
		)
		(efExitLeft init: 7)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2160
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 220
		nextRoom 2170
	)
)

(instance efExitRightDark of ExitFeature
	(properties
		nextRoom 2160
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2710
	)

	(method (init)
		(self createPoly: 60 142 120 70 141 70 201 142)
		(super init: &rest)
	)
)

