;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22320)
(include sci.sh)
(use Main)
(use n951)

(public
	rm22v320 0
)

(instance rm22v320 of ShiversRoom
	(properties
		picture 22320
	)

	(method (init)
		(if (IsFlag 22)
			(self picture: 22321)
		)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22180
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22330
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 22210
	)

	(method (init)
		(self createPoly: 96 8 37 56 37 127 217 127 217 8 97 8)
		(super init: &rest)
	)
)

