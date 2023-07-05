;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16630)
(include sci.sh)
(use Main)

(public
	rm16v630 0
)

(instance rm16v630 of ShiversRoom
	(properties
		picture 16630
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
		nextRoom 16620
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16620
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16180
	)

	(method (init)
		(self createPoly: 39 143 101 76 163 30 199 14 196 51 184 123 196 145)
		(super init: &rest)
	)
)

