;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16640)
(include sci.sh)
(use Main)
(use n951)

(public
	rm16v640 0
)

(instance rm16v640 of ShiversRoom
	(properties
		picture 16640
	)

	(method (init)
		(if (IsFlag 13)
			(= picture 16644)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16650
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16650
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16340
	)

	(method (init)
		(self
			createPoly: 76 144 121 83 121 14 128 0 133 2 143 27 146 55 187 82 175 95 183 142
		)
		(super init: &rest)
	)
)

