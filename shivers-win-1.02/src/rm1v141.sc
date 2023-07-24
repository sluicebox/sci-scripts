;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1141)
(include sci.sh)
(use Main)

(public
	rm1v141 0
)

(instance rm1v141 of ShiversRoom
	(properties
		picture 1141
	)

	(method (init &tmp temp0 temp1)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
		(= temp1 (Random 1 30))
		(= temp0 (Random 5 10))
		(cond
			((< 0 temp1 4)
				(gSounds playChain: -1 temp0 10116 0)
				(gSounds adjChainVol: 42)
			)
			((< 3 temp1 7)
				(gSounds playChain: -1 temp0 10117 0)
				(gSounds adjChainVol: 42)
			)
			((< 6 temp1 10)
				(gSounds playChain: -1 temp0 10118 0)
				(gSounds adjChainVol: 42)
			)
			((< 9 temp1 13)
				(gSounds playChain: -1 temp0 10120 0)
				(gSounds adjChainVol: 42)
			)
			((< 12 temp1 16)
				(gSounds playChain: -1 temp0 10121 0)
				(gSounds adjChainVol: 42)
			)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1140
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1140
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1131
	)

	(method (init)
		(self
			createPoly: 115 141 79 105 40 106 43 95 80 68 94 64 111 68 127 78 155 89 217 141
		)
		(super init: &rest)
	)
)

