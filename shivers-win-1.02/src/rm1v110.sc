;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1110)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v110 0
)

(instance rm1v110 of ShiversRoom
	(properties
		picture 1110
	)

	(method (init &tmp temp0 temp1)
		(proc951_9 10114)
		(gSounds play: 10114 -1 0 0)
		(gSounds fade: 10114 98 1 40 0 0)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(efExitBench init: 9)
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
		nextRoom 1111
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1111
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1130
	)

	(method (init)
		(self
			createPoly:
				83
				143
				85
				129
				35
				96
				63
				83
				130
				80
				127
				58
				147
				43
				168
				56
				162
				85
				133
				85
				129
				110
				147
				143
		)
		(super init: &rest)
	)
)

(instance efExitBench of ExitFeature
	(properties
		nextRoom 1112
	)

	(method (init)
		(self createPoly: 148 120 153 102 143 75 230 77 256 115 246 128 218 132)
		(super init: &rest)
	)
)

