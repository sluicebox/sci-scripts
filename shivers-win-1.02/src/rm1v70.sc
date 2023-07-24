;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1070)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v70 0
)

(instance rm1v70 of ShiversRoom
	(properties
		picture 1070
	)

	(method (init &tmp temp0 temp1)
		(proc951_9 10124)
		(gSounds play: 10124 -1 0 0)
		(gSounds fade: 10124 98 1 40 0 0)
		(gSounds fade: 10111 34 1 40 0 0)
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
		nextRoom 1071
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1071
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1080
	)

	(method (init)
		(self
			createPoly: 99 143 118 109 140 87 135 63 169 63 166 86 193 86 197 68 208 58 208 4 213 0 239 0 239 143
		)
		(super init: &rest)
	)
)

