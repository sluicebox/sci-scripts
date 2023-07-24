;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1094)
(include sci.sh)
(use Main)

(public
	rm1v94 0
)

(instance rm1v94 of ShiversRoom
	(properties
		picture 1094
	)

	(method (init &tmp temp0 temp1)
		(gSounds fade: 10114 0 1 40 1 0)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
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
		nextRoom 1093
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1093
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1091
	)

	(method (init)
		(self
			createPoly: 166 140 152 70 122 55 122 24 102 21 80 29 80 71 86 78 105 78 38 141
		)
		(super init: &rest)
	)
)

(instance efExitStatue of ExitFeature ; UNUSED
	(properties
		nextRoom 1095
	)

	(method (init)
		(self createPoly: 23 142 42 142 81 101 78 1 15 1 16 142 22 142)
		(super init: &rest)
	)
)

