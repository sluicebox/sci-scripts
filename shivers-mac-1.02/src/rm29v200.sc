;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29200)
(include sci.sh)
(use Main)
(use n951)

(public
	rm29v200 0
)

(instance rm29v200 of ShiversRoom
	(properties
		picture 29200
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 7 29000) (== newRoomNumber 29280)) ; rm29v280
			(gSounds fade: 22902 0 5 16 1 0)
			(proc951_9 22901)
			(gSounds play: 22901 -1 90 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29190
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29210
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 29280
	)

	(method (init)
		(self createPoly: 191 118 191 42 88 42 88 118 191 118)
		(super init: &rest)
	)
)

