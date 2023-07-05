;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29170)
(include sci.sh)
(use Main)
(use n951)

(public
	rm29v170 0
)

(instance rm29v170 of ShiversRoom
	(properties
		picture 29170
	)

	(method (init)
		(if (IsFlag 61)
			(self picture: 29171)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efExitPlaque init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 7 29000) (== newRoomNumber 29220)) ; rm29v220
			(gSounds fade: 22902 0 5 16 1 0)
			(proc951_9 22901)
			(gSounds play: 22901 -1 90 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29210
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29190
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 29220
	)

	(method (init)
		(self createPoly: 23 35 73 35 65 121 23 121 23 35)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 29820
	)

	(method (init)
		(self createPoly: 124 143 126 112 136 101 157 101 162 143 124 143)
		(super init: &rest)
	)
)

