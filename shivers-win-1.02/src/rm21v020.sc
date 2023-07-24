;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21020)
(include sci.sh)
(use Main)
(use n951)

(public
	rm21v020 0
)

(instance rm21v020 of ShiversRoom
	(properties
		picture 21020
	)

	(method (init)
		(if (IsFlag 83)
			(= picture 21021)
		)
		(efExitForward init: 3)
		(efExitForwardLeft init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(if (>= gPrevRoomNum 22000)
			(if (proc951_11 2 21000)
				(proc951_9 22102)
				(gSounds play: 22102 -1 50 0)
			else
				(proc951_9 22101)
				(gSounds play: 22101 -1 0 0)
				(gSounds fade: 22101 98 5 16 0 0)
			)
			(gSounds play: 12207 0 82 0)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21030
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21090
	)

	(method (init)
		(self
			createPoly: 25 140 70 107 70 40 160 40 160 100 180 100 230 140 25 140
		)
		(super init: &rest)
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 21060
	)

	(method (init)
		(self
			createPoly: 18 123 41 118 41 83 47 77 46 72 40 67 42 42 25 24 6 24 0 32 0 119 17 123
		)
		(super init: &rest)
	)
)

