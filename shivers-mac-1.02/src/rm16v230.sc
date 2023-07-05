;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16230)
(include sci.sh)
(use Main)

(public
	rm16v230 0
)

(instance rm16v230 of ShiversRoom
	(properties
		picture 16230
	)

	(method (init)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature ; UNUSED
	(properties
		nextRoom 16240
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16700
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16520
	)

	(method (init)
		(self createPoly: 179 142 178 114 231 82 244 82 244 9 22 9 22 143)
		(super init: &rest)
	)
)

