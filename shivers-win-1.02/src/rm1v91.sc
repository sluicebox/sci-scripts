;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1091)
(include sci.sh)
(use Main)

(public
	rm1v91 0
)

(instance rm1v91 of ShiversRoom
	(properties
		picture 1091
	)

	(method (init &tmp temp0 temp1)
		(gSounds stopChain:)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
		(= temp1 (Random 1 20))
		(= temp0 (Random 5 10))
		(cond
			((< 0 temp1 4)
				(gSounds playChain: -1 temp0 10119 0)
				(gSounds adjChainVol: 42)
			)
			((< 3 temp1 7)
				(gSounds playChain: -1 temp0 10122 0)
				(gSounds adjChainVol: 42)
			)
			((< 6 temp1 10)
				(gSounds playChain: -1 temp0 10123 0)
				(gSounds adjChainVol: 42)
			)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1095
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1090
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1081
	)

	(method (init)
		(self
			createPoly:
				190
				143
				121
				115
				121
				78
				128
				78
				128
				45
				105
				41
				87
				52
				87
				58
				73
				59
				67
				79
				36
				89
				101
				126
				103
				142
		)
		(super init: &rest)
	)
)

