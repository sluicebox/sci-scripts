;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13062)
(include sci.sh)
(use Main)

(public
	rm13v062 0
)

(instance rm13v062 of ShiversRoom
	(properties
		picture 13670
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(efExitForwardRight init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13065
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13063
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13066
	)

	(method (init)
		(self createPoly: 62 143 77 128 77 14 180 14 180 125 193 142)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 13032
	)

	(method (init)
		(self createPoly: 180 126 180 15 225 0 225 142)
		(super init: &rest)
	)
)

