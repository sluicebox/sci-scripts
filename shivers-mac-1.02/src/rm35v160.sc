;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35160)
(include sci.sh)
(use Main)

(public
	rm35v160 0
)

(instance rm35v160 of ShiversRoom
	(properties
		picture 35160
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
		nextRoom 35170
	)

	(method (init)
		(self
			createPoly:
				70
				28
				52
				68
				53
				75
				243
				90
				249
				35
				187
				31
				187
				24
				119
				22
				117
				30
				71
				28
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 35150
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 35230
	)
)

