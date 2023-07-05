;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31340)
(include sci.sh)
(use Main)
(use n951)
(use n31001)

(public
	rm31v340 0
)

(instance rm31v340 of ShiversRoom
	(properties
		picture 31341
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 31320) ; rm31v320
			(proc31001_0)
			(gSounds fade: 23109 0 5 16 1 0)
			(proc951_9 23101)
			(gSounds play: 23101 -1 0 0)
			(gSounds fade: 23101 90 5 16 0 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31320
	)

	(method (init)
		(self createPoly: 85 28 177 28 177 142 87 142 85 29)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31350
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31370
	)
)

