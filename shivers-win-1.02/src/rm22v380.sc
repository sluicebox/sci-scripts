;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22380)
(include sci.sh)
(use Main)

(public
	rm22v380 0
)

(instance rm22v380 of ShiversRoom
	(properties
		picture 22380
	)

	(method (init)
		(efExitForward init: 3)
		(efExitDoor init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22370
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22140
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 22060
	)

	(method (init)
		(self createPoly: 35 137 125 117 125 1 35 1 34 137)
		(super init: &rest)
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 22080
	)

	(method (init)
		(self createPoly: 139 123 143 0 177 0 181 142 139 123)
		(super init: &rest)
	)
)

