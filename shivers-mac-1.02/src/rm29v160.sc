;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29160)
(include sci.sh)
(use Main)
(use n951)

(public
	rm29v160 0
)

(instance rm29v160 of ShiversRoom
	(properties
		picture 29160
	)

	(method (init)
		(if (IsFlag 61)
			(self picture: 29161)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
		(if (proc951_11 7 29000)
			(gSounds fade: 22901 0 5 16 1 0)
			(proc951_9 22902)
			(gSounds play: 22902 -1 50 0)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 7 29000) (!= newRoomNumber 29170) (!= newRoomNumber 29140)) ; rm29v170, rm29v140
			(gSounds fade: 22902 0 5 16 1 0)
			(gSounds stop: 22901)
			(proc951_9 22901)
			(gSounds play: 22901 -1 90 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29140
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29280
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 29170
	)

	(method (init)
		(self createPoly: 191 118 191 42 88 42 88 118 191 118)
		(super init: &rest)
	)
)

