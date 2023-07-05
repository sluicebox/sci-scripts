;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22160)
(include sci.sh)
(use Main)

(public
	rm22v160 0
)

(instance rm22v160 of ShiversRoom
	(properties
		picture 22160
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
		nextRoom 22080
	)

	(method (init)
		(self
			createPoly:
				70
				128
				69
				93
				74
				53
				77
				48
				84
				40
				89
				38
				97
				40
				103
				47
				107
				52
				112
				68
				113
				114
				116
				128
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22150
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22170
	)
)

