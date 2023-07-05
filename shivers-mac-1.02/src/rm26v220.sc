;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26220)
(include sci.sh)
(use Main)

(public
	rm26v220 0
)

(instance rm26v220 of ShiversRoom
	(properties
		picture 26220
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 26230
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26230
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 26200
	)

	(method (init)
		(self
			createPoly: 41 143 47 106 98 2 166 2 206 99 221 108 221 142 222 145
		)
		(super init: &rest)
	)
)

