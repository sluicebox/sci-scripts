;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32090)
(include sci.sh)
(use Main)

(public
	rm32v090 0
)

(instance rm32v090 of ShiversRoom
	(properties
		picture 32090
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32080
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32080
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32050
	)

	(method (init)
		(self
			createPoly: 89 127 172 127 162 108 151 107 143 50 93 50 93 62 84 62 83 58 44 58 44 104 99 104 87 127
		)
		(super init: &rest)
	)
)

