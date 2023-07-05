;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16160)
(include sci.sh)
(use Main)

(public
	rm16v160 0
)

(instance rm16v160 of ShiversRoom
	(properties
		picture 16160
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
		nextRoom 16150
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16150
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16510
	)

	(method (init)
		(self createPoly: 18 144 64 96 63 6 246 6 246 86 166 86 158 130 168 143)
		(super init: &rest)
	)
)

