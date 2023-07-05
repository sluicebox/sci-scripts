;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22150)
(include sci.sh)
(use Main)

(public
	rm22v150 0
)

(instance rm22v150 of ShiversRoom
	(properties
		picture 22150
	)

	(method (init)
		(efExitForwardHut init: 3)
		(efExitForward init: 3)
		(efExitPlaque init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForwardHut of ExitFeature
	(properties
		nextRoom 22140
	)

	(method (init)
		(self createPoly: 0 61 20 61 20 30 74 40 74 114 33 129 0 129)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 22350
	)

	(method (init)
		(self createPoly: 74 114 170 120 161 80 161 39 75 39)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 22340
	)

	(method (init)
		(self createPoly: 171 120 161 79 192 79 196 117)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22280
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22160
	)

	(method (init)
		(self createPoly: 0 0 20 0 20 61 0 61 0 129 20 129 20 143 0 143)
		(super init: &rest)
	)
)

