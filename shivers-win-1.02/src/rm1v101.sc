;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1101)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v101 0
)

(instance rm1v101 of ShiversRoom
	(properties
		picture 1101
	)

	(method (init &tmp temp0 temp1)
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
		(proc951_16 82)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForwardLeft init: 3)
		(efExitForwardRight init: 3)
		(super init: &rest)
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 1102
	)

	(method (init)
		(self createPoly: 34 2 34 142 76 142 76 2 35 2)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 1103
	)

	(method (init)
		(self createPoly: 203 1 203 141 232 141 232 2 204 2)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1092
	)

	(method (init)
		(self createPoly: 0 0 0 142 26 142 26 1 1 1)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1092
	)

	(method (init)
		(self createPoly: 237 2 238 141 262 141 262 2 238 2)
		(super init: &rest)
	)
)

