;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16090)
(include sci.sh)
(use Main)

(public
	rm16v90 0
)

(instance rm16v90 of ShiversRoom
	(properties
		picture 16090
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16080
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16060
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16300
	)

	(method (init)
		(self
			createPoly:
				98
				145
				117
				99
				117
				56
				144
				56
				141
				76
				141
				112
				171
				122
				195
				143
		)
		(super init: &rest)
	)
)

