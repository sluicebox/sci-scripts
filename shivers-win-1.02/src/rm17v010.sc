;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17010)
(include sci.sh)
(use Main)
(use n951)

(public
	rm17v010 0
)

(instance rm17v010 of ShiversRoom
	(properties
		picture 17010
	)

	(method (init)
		(if (not (IsFlag 14))
			(= picture 17011)
		)
		(efExitForwardLeft init: 9)
		(efExitForward init: 9)
		(efExitTurn180 init: 6)
		(super init: &rest)
		(if (> gPrevRoomNum 18000)
			(gSounds play: 11712 0 32 0)
			(ClearFlag 43)
		)
		(if (proc951_11 9 17000)
			(gSounds fadeChain:)
			(proc951_7 21703)
			(gSounds play: 21703 -1 50 0)
		)
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 17100
	)

	(method (init)
		(self createPoly: 43 112 23 111 19 60 34 57 44 59)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 17040
	)

	(method (init)
		(self createPoly: 109 143 123 105 123 33 149 34 149 105 168 142)
		(super init: &rest)
	)
)

(instance efExitTurn180 of ExitFeature
	(properties
		nextRoom 17020
	)
)

