;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23660)
(include sci.sh)
(use Main)

(public
	rm23v660 0
)

(instance rm23v660 of ShiversRoom
	(properties
		picture 23660
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitUTurnLeft init: 7)
		(efExitRight init: 1)
		(efExitDoorway init: 3)
		(super init: &rest)
	)
)

(instance efExitUTurnLeft of ExitFeature
	(properties
		nextRoom 23650
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23600
	)

	(method (init)
		(self createPoly: 47 0 64 0 89 25 89 140 82 142 46 142 46 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23690
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23630
	)

	(method (init)
		(self createPoly: 180 134 96 134 96 62 181 62 181 131)
		(super init: &rest)
	)
)

(instance efExitDoorway of ExitFeature
	(properties
		nextRoom 23400
	)

	(method (init)
		(self
			createPoly:
				183
				19
				183
				116
				242
				116
				242
				97
				235
				97
				235
				90
				225
				88
				225
				19
				184
				19
		)
		(super init: &rest)
	)
)

