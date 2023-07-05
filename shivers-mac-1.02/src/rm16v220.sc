;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16220)
(include sci.sh)
(use Main)

(public
	rm16v220 0
)

(instance rm16v220 of ShiversRoom
	(properties
		picture 16220
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(efExitDoor init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16210
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16210
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16010
	)

	(method (init)
		(self
			createPoly: 66 142 98 106 105 85 105 42 154 42 154 82 237 144 66 142
		)
		(super init: &rest)
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 16020
	)

	(method (init)
		(self createPoly: 193 111 193 40 231 25 231 139 193 111)
		(super init: &rest)
	)
)

