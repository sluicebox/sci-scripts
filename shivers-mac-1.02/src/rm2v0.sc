;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2000)
(include sci.sh)
(use Main)
(use n951)

(public
	rm2v0 0
)

(instance rm2v0 of ShiversRoom
	(properties
		picture 2001
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(if (IsFlag 2)
			(= picture 2000)
		else
			(efExitForward init: 3)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber &rest)
		(if (== newRoomNumber 1251) ; rm1v251
			(gSounds play: 10126 0 90 0)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2340
	)

	(method (init)
		(self createPoly: 220 0 262 0 262 144 220 144 220 0)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1251
	)

	(method (init)
		(self
			createPoly: 79 144 79 55 93 35 109 29 141 29 154 35 174 56 174 144
		)
		(super init: &rest)
	)
)

