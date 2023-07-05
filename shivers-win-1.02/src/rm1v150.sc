;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1150)
(include sci.sh)
(use Main)

(public
	rm1v150 0
)

(instance rm1v150 of ShiversRoom
	(properties
		picture 1150
	)

	(method (init &tmp temp0 temp1)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
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
		nextRoom 1152
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1151
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1162
	)

	(method (init)
		(self createPoly: 96 78 92 95 93 143 169 143 170 96 164 78 97 78)
		(super init: &rest)
	)
)

