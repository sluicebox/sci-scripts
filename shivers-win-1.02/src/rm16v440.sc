;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16440)
(include sci.sh)
(use Main)

(public
	rm16v440 0
)

(instance rm16v440 of ShiversRoom
	(properties
		picture 16440
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16430
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16430
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16380
	)

	(method (init)
		(self createPoly: 93 143 92 56 105 11 146 11 165 38 168 142)
		(super init: &rest)
	)
)

