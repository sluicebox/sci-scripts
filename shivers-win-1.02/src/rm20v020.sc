;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20020)
(include sci.sh)
(use Main)

(public
	rm20v020 0
)

(instance rm20v020 of ShiversRoom
	(properties
		picture 20020
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
		nextRoom 20130
	)

	(method (init)
		(self createPoly: 90 36 27 142 156 143 156 32 91 36)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20040
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20060
	)
)

