;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17120)
(include sci.sh)
(use Main)
(use n951)

(public
	rm17v120 0
)

(instance rm17v120 of ShiversRoom
	(properties
		picture 17120
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(if (not (IsFlag 14))
			(= picture 17121)
		)
		(if (proc951_11 9 17000)
			(gSounds fade: 21703 0 10 8 1 0)
			(gSounds adjChainVol: 35)
			(gSounds playChain: 21701 -1 -1 -2 21701 -1 -1 -2 21702 -1 -1 -2)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 17110
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 17110
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 17180
	)

	(method (init)
		(self
			createPoly:
				155
				95
				81
				95
				82
				57
				88
				57
				98
				46
				106
				43
				114
				45
				116
				49
				117
				52
				129
				52
				129
				79
				158
				92
		)
		(super init: &rest)
	)
)

