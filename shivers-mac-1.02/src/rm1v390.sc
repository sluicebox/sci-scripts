;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1390)
(include sci.sh)
(use Main)

(public
	rm1v390 0
)

(instance rm1v390 of ShiversRoom
	(properties
		picture 1390
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1394
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1392
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1373
	)

	(method (init)
		(self createPoly: 5 142 70 126 83 76 143 75 163 118 262 129 262 142)
		(super init: &rest)
	)
)

