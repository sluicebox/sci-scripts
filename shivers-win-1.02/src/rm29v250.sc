;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29250)
(include sci.sh)
(use Main)
(use n951)

(public
	rm29v250 0
)

(instance rm29v250 of ShiversRoom
	(properties
		picture 29250
	)

	(method (init)
		(if (IsFlag 61)
			(self picture: 29251)
		)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efExitLight init: 3)
		(super init: &rest)
		(if (proc951_11 7 29000)
			(gSounds fade: 22901 0 5 16 1 0)
			(proc951_9 22902)
			(gSounds play: 22902 -1 50 0)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 7 29000) (!= newRoomNumber 29200) (!= newRoomNumber 29190)) ; rm29v200, rm29v190
			(gSounds fade: 22902 0 5 16 1 0)
			(proc951_9 22901)
			(gSounds play: 22901 -1 90 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29220
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29270
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 29200
	)

	(method (init)
		(self createPoly: 191 118 191 42 88 42 88 118 191 118)
		(super init: &rest)
	)
)

(instance efExitLight of ExitFeature
	(properties
		nextRoom 29190
	)

	(method (init)
		(self
			createPoly:
				33
				83
				52
				46
				52
				2
				69
				2
				69
				65
				94
				101
				94
				126
				24
				126
				24
				101
				33
				83
		)
		(super init: &rest)
	)
)

