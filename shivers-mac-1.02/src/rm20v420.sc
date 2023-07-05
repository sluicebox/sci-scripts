;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20420)
(include sci.sh)
(use Main)

(public
	rm20v420 0
)

(instance rm20v420 of ShiversRoom
	(properties
		picture 20420
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20390
	)

	(method (init)
		(self createPoly: 129 48 191 67 191 114 169 127 87 127 68 113 68 67)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20400
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20410
	)
)

