;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12050)
(include sci.sh)
(use Main)

(public
	rm12v05 0
)

(instance rm12v05 of ShiversRoom
	(properties
		picture 12050
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12060
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12320
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12070
	)

	(method (init)
		(self
			createPoly:
				55
				143
				104
				96
				106
				64
				152
				64
				152
				82
				147
				87
				146
				109
				171
				113
				211
				143
		)
		(super init: &rest)
	)
)

