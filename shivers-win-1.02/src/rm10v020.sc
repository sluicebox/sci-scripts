;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10020)
(include sci.sh)
(use Main)

(public
	rm10v020 0
)

(instance rm10v020 of ShiversRoom
	(properties
		picture 10020
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(efLipstick init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10010
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10030
	)

	(method (init)
		(self
			createPoly: 41 143 43 129 107 129 112 121 86 121 80 128 44 128 50 21 199 21 204 142
		)
		(super init: &rest)
	)
)

(instance efLipstick of ExitFeature
	(properties
		nextRoom 10060
	)

	(method (init)
		(self createPoly: 107 129 81 129 86 121 112 121)
		(super init: &rest)
	)
)

