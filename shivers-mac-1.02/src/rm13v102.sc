;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13102)
(include sci.sh)
(use Main)

(public
	rm13v102 0
)

(instance rm13v102 of ShiversRoom
	(properties
		picture 13610
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13105
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13103
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13098
	)

	(method (init)
		(self createPoly: 73 143 82 129 82 31 172 31 172 112 201 142)
		(super init: &rest)
	)
)

