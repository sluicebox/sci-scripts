;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24330)
(include sci.sh)
(use Main)
(use n951)

(public
	rm24v330 0
)

(instance rm24v330 of ShiversRoom
	(properties
		picture 24330
	)

	(method (init)
		(if (IsFlag 67)
			(= picture 24331)
		)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(efExitPlaque init: 3)
		(if (proc951_11 1 24000)
			(proc951_9 22404)
			(gSounds play: 22404 -1 50 0)
		else
			(proc951_9 22401)
			(gSounds play: 22401 -1 98 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 24360) (proc951_11 1 24000)) ; rm24v360
			(proc951_9 22401)
			(gSounds play: 22401 -1 0 0)
			(gSounds fade: 22401 98 5 16 0 0)
			(gSounds fade: 22404 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 24360
	)

	(method (init)
		(self
			createPoly: 86 61 111 61 115 82 134 102 130 126 82 129 73 120 79 103 74 94 86 84 86 62
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24340
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24320
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 24820
	)

	(method (init)
		(self createPoly: 83 144 72 121 78 105 65 94 50 97 50 110 43 144 83 144)
		(super init: &rest)
	)
)

