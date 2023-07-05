;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24130)
(include sci.sh)
(use Main)
(use n951)

(public
	rm24v130 0
)

(instance rm24v130 of ShiversRoom
	(properties
		picture 24130
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 4)
		(proc951_1 1)
		(if (> newRoomNumber 25000) ; rm25v0
			(gSounds fade: 22403 0 6 30 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 26270
	)

	(method (init)
		(self createPoly: 88 35 88 142 174 142 174 35 89 35)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24000
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24000
	)
)

