;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13472)
(include sci.sh)
(use Main)

(public
	rm13v472 0
)

(instance rm13v472 of ShiversRoom
	(properties
		picture 13870
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
		nextRoom 13470
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13473
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13468
	)

	(method (init)
		(self createPoly: 60 143 72 131 72 30 166 30 166 111 190 142)
		(super init: &rest)
	)
)

