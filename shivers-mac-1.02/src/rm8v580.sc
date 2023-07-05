;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8580)
(include sci.sh)
(use Main)

(public
	rm8v580 0
)

(instance rm8v580 of ShiversRoom
	(properties
		picture 8580
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitBookStand init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8560
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8590
	)
)

(instance efExitBookStand of ExitFeature
	(properties
		nextRoom 8530
	)

	(method (init)
		(self
			createPoly:
				16
				48
				16
				142
				47
				142
				60
				133
				63
				127
				59
				121
				46
				120
				46
				88
				61
				49
				60
				47
				16
				47
		)
		(super init: &rest)
	)
)

