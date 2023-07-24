;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3090)
(include sci.sh)
(use Main)

(public
	rm3v090 0
)

(instance rm3v090 of ShiversRoom
	(properties
		picture 3090
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
		nextRoom 3100
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3080
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 3050
	)

	(method (init)
		(self
			createPoly: 253 125 147 126 154 112 150 92 167 86 241 90 241 97 247 99
		)
		(super init: &rest)
	)
)

