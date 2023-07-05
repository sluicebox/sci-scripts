;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35310)
(include sci.sh)
(use Main)

(public
	rm35v310 0
)

(instance rm35v310 of ShiversRoom
	(properties
		picture 35310
	)

	(method (init)
		(efExitDesk init: 3)
		(efExitJukebox init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitDesk of ExitFeature
	(properties
		nextRoom 35160
	)

	(method (init)
		(self createPoly: 32 103 107 98 134 89 133 56 109 51 61 51 24 58 32 103)
		(super init: &rest)
	)
)

(instance efExitJukebox of ExitFeature
	(properties
		nextRoom 35150
	)

	(method (init)
		(self
			createPoly:
				148
				99
				193
				113
				233
				106
				236
				52
				219
				30
				182
				16
				174
				17
				146
				62
				148
				99
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 35190
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 35330
	)
)

