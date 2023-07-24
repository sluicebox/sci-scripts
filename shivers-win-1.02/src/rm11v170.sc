;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11170)
(include sci.sh)
(use Main)
(use n951)

(public
	rm11v170 0
)

(instance rm11v170 of ShiversRoom
	(properties
		picture 11170
	)

	(method (init)
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
				(gSounds play: 21101 -1 48 0)
				(gSounds adjChainVol: 32)
				(gSounds playChain: -1 -5 21102 -1)
			)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (<= 11160 newRoomNumber 11180) ; rm11v160, rm11v180
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
		nextRoom 11160
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11180
	)
)

(instance efForwardLeft of ExitFeature
	(properties
		nextRoom 11200
	)

	(method (init)
		(self
			createPoly: 103 118 82 119 53 110 70 58 70 37 24 37 25 138 103 138
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
			createPoly: 103 138 103 118 123 117 141 92 140 66 148 53 195 53 195 137
		)
		(super init: &rest)
	)
)

