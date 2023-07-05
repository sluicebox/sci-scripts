;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3030)
(include sci.sh)
(use Main)

(public
	rm3v030 0
)

(instance rm3v030 of ShiversRoom
	(properties
		picture 3030
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3020
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 3070
	)

	(method (init)
		(self createPoly: 139 94 140 142 250 143 164 92 163 66 140 66)
		(super init: &rest)
	)
)

