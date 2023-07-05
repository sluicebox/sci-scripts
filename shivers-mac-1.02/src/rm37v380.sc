;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37380)
(include sci.sh)
(use Main)
(use n951)

(public
	rm37v380 0
)

(instance rm37v380 of ShiversRoom
	(properties
		picture 37380
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efExitDesk init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 9 37000) (== newRoomNumber 37130)) ; rm37v130
			(gSounds fade: 23702 0 5 16 1 0)
			(proc951_9 23701)
			(gSounds play: 23701 -1 74 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37291
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37370
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37130
	)

	(method (init)
		(self createPoly: 175 119 178 99 178 55 207 55 236 100 243 122)
		(super init: &rest)
	)
)

(instance efExitDesk of ExitFeature
	(properties
		nextRoom 37250
	)

	(method (init)
		(self createPoly: 93 137 36 137 30 98 50 44 90 44 123 93)
		(super init: &rest)
	)
)

