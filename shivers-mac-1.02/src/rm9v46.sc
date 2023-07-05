;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9460)
(include sci.sh)
(use Main)
(use n951)

(public
	rm9v46 0
)

(instance rm9v46 of ShiversRoom
	(properties
		picture 9460
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (and (IsFlag 42) (or (== gPrevRoomNum 9850) (< 9000 gPrevRoomNum 9440))) ; rm9v850, rm9v44
			(gSounds fade: 10908 8 15 8 0 0)
		)
		(if (IsFlag 43)
			(gSounds play: 10904 0 40 0)
			(ClearFlag 43)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (IsFlag 42) (> newRoomNumber 9470)) ; rm9v47
			(gSounds fade: 10908 0 20 3 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9450
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9470
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9760
	)

	(method (init)
		(self createPoly: 81 142 81 0 206 0 206 139)
		(super init: &rest)
	)
)

