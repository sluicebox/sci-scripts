;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7200)
(include sci.sh)
(use Main)
(use n951)

(public
	rm7v200 0
)

(instance rm7v200 of ShiversRoom
	(properties
		picture 7200
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (== newRoomNumber 7140) (proc951_11 5 7000)) ; rm7v140
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
		nextRoom 7160
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7170
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 7230
	)

	(method (init)
		(self createPoly: 49 0 49 127 63 127 63 142 162 142 162 1 50 1)
		(super init: &rest)
	)
)

