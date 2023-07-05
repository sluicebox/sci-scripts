;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17040)
(include sci.sh)
(use Main)
(use n951)

(public
	rm17v040 0
)

(instance rm17v040 of ShiversRoom
	(properties
		picture 17040
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
		(if (IsFlag 43)
			(gSounds play: 11712 0 32 0)
			(ClearFlag 43)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 9 17000) (== newRoomNumber 17060)) ; rm17v060
			(gSounds fade: 21703 0 10 8 1 0)
			(gSounds adjChainVol: 35)
			(gSounds playChain: 21701 -1 -1 -2 21701 -1 -1 -2 21702 -1 -1 -2)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 17030
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 17020
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 17060
	)

	(method (init)
		(self createPoly: 104 143 101 14 168 13 168 141)
		(super init: &rest)
	)
)

