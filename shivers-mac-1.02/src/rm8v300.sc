;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8300)
(include sci.sh)
(use Main)
(use n951)

(public
	rm8v300 0
)

(instance rm8v300 of ShiversRoom
	(properties)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efExitStand init: 3)
		(if (IsFlag 34)
			(= picture 8300)
		else
			(= picture 8310)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8340
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8320
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8370
	)

	(method (init)
		(self createPoly: 99 137 99 96 83 1 171 1 171 135)
		(super init: &rest)
	)
)

(instance efExitStand of ExitFeature
	(properties
		nextRoom 8520
	)

	(method (init)
		(self
			createPoly:
				178
				53
				182
				125
				195
				133
				211
				135
				227
				130
				243
				81
				227
				53
				178
				53
		)
		(super init: &rest)
	)
)

