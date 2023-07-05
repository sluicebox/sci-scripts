;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20640)
(include sci.sh)
(use Main)
(use n951)

(public
	rm20v640 0
)

(instance rm20v640 of ShiversRoom
	(properties
		picture 20640
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
		(if (and (proc951_11 4 20000) (IsFlag 16))
			(gSounds fade: 22002 0 5 8 1 0)
			(proc951_9 22001)
			(gSounds play: 22001 -1 98 0)
		)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 4)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20641
	)

	(method (init)
		(self createPoly: 77 22 77 141 216 141 216 21 77 21)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20650
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20650
	)
)

