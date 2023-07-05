;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35250)
(include sci.sh)
(use Main)

(public
	rm35v250 0
)

(instance rm35v250 of ShiversRoom
	(properties
		picture 35250
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
		(self
			createPoly:
				61
				84
				54
				142
				208
				142
				208
				84
				193
				86
				189
				98
				176
				98
				149
				118
				128
				105
				150
				94
				149
				90
				122
				75
				108
				72
				61
				84
		)
		(super init: &rest)
	)
)

(instance efExitJukebox of ExitFeature
	(properties
		nextRoom 35150
	)

	(method (init)
		(self
			createPoly: 130 78 153 90 153 110 191 81 191 47 191 44 132 44 130 77
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 35210
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 35180
	)
)

