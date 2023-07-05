;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20850)
(include sci.sh)
(use Main)

(public
	rm20v850 0
)

(instance rm20v850 of ShiversRoom
	(properties
		picture 20850
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20130
	)

	(method (init)
		(self createPoly: 148 134 148 41 243 41 243 143)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20390
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20380
	)
)

