;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1251)
(include sci.sh)
(use Main)

(public
	rm1v251 0
)

(instance rm1v251 of ShiversRoom
	(properties
		picture 1251
	)

	(method (init)
		(gSounds interruptChain:)
		(gSounds adjChainVol: 34)
		(gSounds
			playChain:
				20101
				-1
				-1
				-5
				20101
				-1
				-1
				-5
				20102
				-1
				-1
				-5
				20103
				-1
				-1
				-5
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1250
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1250
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1241
	)

	(method (init)
		(self
			createPoly:
				134
				134
				118
				109
				93
				88
				56
				68
				13
				52
				0
				52
				0
				32
				83
				59
				180
				90
				231
				109
				231
				143
				134
				143
		)
		(super init: &rest)
	)
)

