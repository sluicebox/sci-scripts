;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20820)
(include sci.sh)
(use Main)

(public
	rm20v820 0
)

(instance rm20v820 of ShiversRoom
	(properties
		picture 20820
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 20460
	)

	(method (init)
		(self createPoly: 60 30 203 30 203 113 60 113)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20470
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20460
	)
)

