;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7220)
(include sci.sh)
(use Main)
(use n951)

(public
	rm7v220 0
)

(instance rm7v220 of ShiversRoom
	(properties
		picture 7220
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForLeft init: 9)
		(efExitForRight init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 7170) (proc951_11 5 7000)) ; rm7v170
			(gSounds interruptChain:)
			(gSounds fade: 20701 0 10 16 1 0)
			(gSounds playChain: -1 -4 20602 -1)
			(gSounds adjChainVol: 34)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 7400
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7110
	)
)

(instance efExitForLeft of ExitFeature
	(properties
		nextRoom 7170
	)

	(method (init)
		(self createPoly: 61 96 0 136 1 142 47 143 95 101)
		(super init: &rest)
	)
)

(instance efExitForRight of ExitFeature
	(properties
		nextRoom 7410
	)

	(method (init)
		(self createPoly: 182 99 160 102 195 143 260 142 262 134)
		(super init: &rest)
	)
)

