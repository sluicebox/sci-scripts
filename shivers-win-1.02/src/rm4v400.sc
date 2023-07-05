;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4400)
(include sci.sh)
(use Main)

(public
	rm4v400 0
)

(instance rm4v400 of ShiversRoom
	(properties
		picture 4050
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 4410
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4410
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4380
	)

	(method (init)
		(self
			createPoly:
				67
				128
				103
				95
				104
				46
				124
				48
				124
				52
				133
				54
				134
				48
				151
				48
				152
				89
				181
				127
		)
		(super init: &rest)
	)
)

