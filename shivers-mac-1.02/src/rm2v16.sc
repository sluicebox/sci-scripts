;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2160)
(include sci.sh)
(use Main)
(use n951)

(public
	rm2v16 0
)

(instance rm2v16 of ShiversRoom
	(properties
		picture 2160
	)

	(method (init)
		(if (not (IsFlag 2))
			(self picture: 2161)
			(efExitLeftDark init: 7)
		else
			(efExitLeft init: 2)
		)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 44
		nextRoom 2170
	)
)

(instance efExitLeftDark of ExitFeature
	(properties
		nextRoom 2460
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2460
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2140
	)

	(method (init)
		(self createPoly: 63 143 121 69 125 59 136 59 142 69 202 142)
		(super init: &rest)
	)
)

