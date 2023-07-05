;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26150)
(include sci.sh)
(use Main)

(public
	rm26v150 0
)

(instance rm26v150 of ShiversRoom
	(properties)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 26140
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26140
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 26180
	)

	(method (init)
		(self createPoly: 21 0 243 0 243 143 21 143)
		(super init: &rest)
	)
)

