;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16520)
(include sci.sh)
(use Main)

(public
	rm16v520 0
)

(instance rm16v520 of ShiversRoom
	(properties
		picture 16520
	)

	(method (init)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature ; UNUSED
	(properties
		nextRoom 16530
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16700
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16250
	)

	(method (init)
		(self createPoly: 55 144 132 99 133 44 198 44 200 101 178 114 182 142)
		(super init: &rest)
	)
)

