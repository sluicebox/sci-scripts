;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18040)
(include sci.sh)
(use Main)

(public
	rm18v4 0
)

(instance rm18v4 of ShiversRoom
	(properties
		picture 18040
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 18030
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18020
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 18060
	)

	(method (init)
		(self createPoly: 87 143 109 110 109 56 151 56 151 106 171 142)
		(super init: &rest)
	)
)

