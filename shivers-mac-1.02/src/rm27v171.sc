;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27171)
(include sci.sh)
(use Main)

(public
	rm27v171 0
)

(instance rm27v171 of ShiversRoom
	(properties
		picture 27171
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
		nextRoom 27161
	)

	(method (init)
		(self createPoly: 90 142 97 130 97 33 162 33 177 142 90 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27170
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27172
	)
)

