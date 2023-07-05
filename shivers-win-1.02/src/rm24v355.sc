;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24355)
(include sci.sh)
(use Main)
(use n951)

(public
	rm24v355 0
)

(instance rm24v355 of ShiversRoom
	(properties
		picture 24355
	)

	(method (init)
		(if (IsFlag 67)
			(= picture 24356)
		)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (== newRoomNumber 24350) (proc951_11 1 24000)) ; rm24v350
			(proc951_9 22401)
			(gSounds play: 22401 -1 0 0)
			(gSounds fade: 22401 98 15 15 0 0)
			(gSounds fade: 22404 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 24350
	)

	(method (init)
		(self createPoly: 100 19 174 19 172 135 103 135 100 19)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24420
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24370
	)
)

