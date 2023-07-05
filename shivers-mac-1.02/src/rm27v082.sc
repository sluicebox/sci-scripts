;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27082)
(include sci.sh)
(use Main)
(use n951)

(public
	rm27v082 0
)

(instance rm27v082 of ShiversRoom
	(properties
		picture 27082
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 5 36000) (== newRoomNumber 27072)) ; rm27v072
			(gSounds fade: 22702 0 5 16 1 0)
			(proc951_9 22701)
			(gSounds play: 22701 -1 98 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27072
	)

	(method (init)
		(self createPoly: 86 142 103 42 151 42 169 142 87 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27081
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27083
	)
)

