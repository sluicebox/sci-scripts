;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21310)
(include sci.sh)
(use Main)

(public
	rm21v310 0
)

(instance rm21v310 of ShiversRoom
	(properties
		picture 21310
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21320
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21340
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21280
	)

	(method (init)
		(self createPoly: 92 142 90 119 125 32 156 34 192 120 191 142)
		(super init: &rest)
	)
)

