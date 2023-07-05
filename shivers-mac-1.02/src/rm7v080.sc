;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7080)
(include sci.sh)
(use Main)

(public
	rm7v080 0
)

(instance rm7v080 of ShiversRoom
	(properties
		picture 7080
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(efExitForwardRight init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 7090
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7070
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 7300
	)

	(method (init)
		(self createPoly: 34 17 111 17 111 134 87 134 85 119 34 102)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 7040
	)

	(method (init)
		(self createPoly: 174 40 200 21 200 105 163 105 152 92 174 73)
		(super init: &rest)
	)
)

