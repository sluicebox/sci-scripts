;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13607)
(include sci.sh)
(use Main)

(public
	rm13v607 0
)

(instance rm13v607 of ShiversRoom
	(properties
		picture 13122
	)

	(method (init)
		(efExitForward init: 9)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13435
	)

	(method (init)
		(self createPoly: 163 96 133 93 133 50 163 47)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13012
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13013
	)
)

