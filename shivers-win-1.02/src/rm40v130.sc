;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40130)
(include sci.sh)
(use Main)

(public
	rm40v130 0
)

(instance rm40v130 of ShiversRoom
	(properties
		picture 40110
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 40110
	)

	(method (init)
		(self
			createPoly:
				21
				128
				48
				113
				60
				117
				97
				104
				109
				108
				141
				100
				152
				105
				166
				1
				227
				1
				215
				127
				22
				127
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40120
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40120
	)
)

