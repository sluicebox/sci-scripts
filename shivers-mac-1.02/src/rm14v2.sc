;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14020)
(include sci.sh)
(use Main)
(use n951)

(public
	rm14v2 0
)

(instance rm14v2 of ShiversRoom
	(properties
		picture 14020
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (< gPrevRoomNum 14000)
			(proc951_9 21401)
			(gSounds play: 21401 -1 34 0)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 14310
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14010
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 14110
	)

	(method (init)
		(self
			createPoly:
				84
				95
				90
				90
				88
				52
				113
				46
				115
				69
				163
				67
				162
				91
				217
				96
				207
				81
				207
				64
				227
				60
				247
				66
				245
				85
				223
				104
				142
				96
				119
				105
				81
				100
		)
		(super init: &rest)
	)
)

