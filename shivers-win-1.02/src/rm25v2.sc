;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25020)
(include sci.sh)
(use Main)
(use n951)

(public
	rm25v2 0
)

(instance rm25v2 of ShiversRoom
	(properties
		picture 25020
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(efExitToilet init: 9)
		(if (proc951_11 0 25000)
			(proc951_9 22511)
			(gSounds play: 22511 -1 0 0)
			(gSounds fade: 22511 50 5 16 0 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 0 25000) (!= newRoomNumber 25060)) ; rm25v6
			(gSounds fade: 22511 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 25030
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 25030
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 25000
	)

	(method (init)
		(self createPoly: 111 142 111 31 156 31 156 142)
		(super init: &rest)
	)
)

(instance efExitToilet of ExitFeature
	(properties
		nextRoom 25060
	)

	(method (init)
		(self
			createPoly: 61 142 61 131 52 124 51 115 69 109 80 109 94 114 94 127 86 135 86 142
		)
		(super init: &rest)
	)
)

