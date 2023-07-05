;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13015)
(include sci.sh)
(use Main)

(public
	rm13v015 0
)

(instance rm13v015 of ShiversRoom
	(properties
		picture 13130
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
		nextRoom 13016
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13017
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13013
	)

	(method (init)
		(self createPoly: 115 94 115 49 159 49 159 94)
		(super init: &rest)
	)
)

