;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27172)
(include sci.sh)
(use Main)

(public
	rm27v172 0
)

(instance rm27v172 of ShiversRoom
	(properties
		picture 27172
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
		nextRoom 27182
	)

	(method (init)
		(self createPoly: 83 143 91 132 91 31 158 31 171 142 84 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27171
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27173
	)
)

