;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11030)
(include sci.sh)
(use Main)
(use n951)

(public
	rm11v030 0
)

(instance rm11v030 of ShiversRoom
	(properties
		picture 11030
	)

	(method (init)
		(super init: &rest)
		(if (and (== gPrevRoomNum 11040) (IsFlag 43)) ; rm11v040
			(ClearFlag 43)
			(gSounds play: 11105 0 32 0)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efForwardLeft init: 9)
		(efForwardRight init: 9)
		(cond
			((proc951_11 3 11000)
				(proc951_7 21103)
				(proc951_9 21103)
				(gSounds play: 21103 -1 50 0)
				(gSounds fade: 21101 0 15 8 1 0)
				(gSounds fadeChain:)
			)
			((proc951_11 9 11000)
				(gSounds fade: 21103 0 5 16 1 0)
				(proc951_7 21101)
				(proc951_9 21101)
				(gSounds adjChainVol: 32)
				(gSounds play: 21101 -1 48 0)
				(gSounds playChain: -1 -5 21102 -1)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (<= 11000 newRoomNumber 11040) ; rm11v040
			(if (proc951_11 9 11000)
				(gSounds stop: 21101)
				(gSounds stopChain:)
			)
			(gSounds fade: 21103 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11020
	)
)

(instance efForwardLeft of ExitFeature
	(properties
		nextRoom 11200
	)

	(method (init)
		(self
			createPoly: 193 113 157 108 155 104 174 50 111 50 125 90 112 143 195 143
		)
		(super init: &rest)
	)
)

(instance efForwardRight of ExitFeature
	(properties
		nextRoom 11210
	)

	(method (init)
		(self
			createPoly: 196 143 193 113 225 112 222 103 222 92 229 86 224 63 243 55 243 143
		)
		(super init: &rest)
	)
)

