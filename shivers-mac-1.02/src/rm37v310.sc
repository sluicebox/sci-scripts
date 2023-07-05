;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37310)
(include sci.sh)
(use Main)
(use n951)

(public
	rm37v310 0
)

(instance rm37v310 of ShiversRoom
	(properties
		picture 37310
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(if (IsFlag 43)
			(gSounds play: 10614 0 40 0)
			(ClearFlag 43)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 9)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37300
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37300
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37340
	)

	(method (init)
		(self createPoly: 49 141 56 8 176 8 184 140)
		(super init: &rest)
	)
)

