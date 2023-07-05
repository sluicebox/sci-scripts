;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7150)
(include sci.sh)
(use Main)
(use n951)

(public
	rm7v150 0
)

(instance rm7v150 of ShiversRoom
	(properties
		picture 7150
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitForward init: 9)
		(efExitRight init: 1)
		(if (proc951_11 5 7000)
			(gSounds stop: 20701)
			(gSounds fadeChain:)
			(proc951_7 20701)
			(gSounds play: 20701 -1 50 0)
		)
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
		nextRoom 7130
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7140
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 7170
	)

	(method (init)
		(self createPoly: 109 58 109 86 107 114 79 143 216 143 164 114 162 59)
		(super init: &rest)
	)
)

