;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21460)
(include sci.sh)
(use Main)

(public
	rm21v460 0
)

(instance rm21v460 of ShiversRoom
	(properties
		picture 21460
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21090
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21030
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21100
	)

	(method (init)
		(self createPoly: 53 7 53 143 150 143 150 7 54 7)
		(super init: &rest)
	)
)

