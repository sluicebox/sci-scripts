;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2060)
(include sci.sh)
(use Main)
(use n951)

(public
	rm2v6 0
)

(instance rm2v6 of ShiversRoom
	(properties
		picture 2060
	)

	(method (init)
		(if (not (IsFlag 2))
			(self picture: 2721)
			(efExitLeftDark init: 2)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2070
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2070
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2800
	)

	(method (init)
		(if (not (IsFlag 2))
			(= nextRoom 2350)
		)
		(self
			createPoly: 49 144 108 78 108 60 120 49 141 49 154 59 154 80 212 142
		)
		(super init: &rest)
	)
)

(instance efExitLeftDark of ExitFeature
	(properties
		nextRoom 2040
	)

	(method (init)
		(self createPoly: 88 117 85 93 86 70 93 55 111 43 124 42 122 97 112 99)
		(super init: &rest)
	)
)

