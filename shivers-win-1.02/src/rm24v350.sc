;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24350)
(include sci.sh)
(use Main)
(use n951)

(public
	rm24v350 0
)

(instance rm24v350 of ShiversRoom
	(properties
		picture 24350
	)

	(method (init)
		(if (IsFlag 67)
			(= picture 24351)
		)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 24280) ; rm24v280
			(gSounds fade: 22401 0 6 30 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 24280
	)

	(method (init)
		(self createPoly: 95 14 181 14 180 142 96 142 95 14)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24320
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24340
	)
)

