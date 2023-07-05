;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23680)
(include sci.sh)
(use Main)

(public
	rm23v680 0
)

(instance rm23v680 of ShiversRoom
	(properties
		picture 23680
	)

	(method (init)
		(efExitArch init: 3)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23370
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23380
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23470
	)

	(method (init)
		(self
			createPoly:
				194
				132
				118
				119
				128
				66
				141
				56
				145
				23
				192
				1
				214
				1
				233
				40
				233
				92
				209
				124
		)
		(super init: &rest)
	)
)

(instance efExitArch of ExitFeature
	(properties
		nextRoom 23460
	)

	(method (init)
		(self
			createPoly:
				28
				121
				28
				105
				20
				63
				20
				36
				27
				32
				20
				24
				20
				3
				64
				4
				59
				109
				63
				116
		)
		(super init: &rest)
	)
)

