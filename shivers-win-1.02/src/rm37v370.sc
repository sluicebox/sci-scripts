;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37370)
(include sci.sh)
(use Main)
(use n951)

(public
	rm37v370 0
)

(instance rm37v370 of ShiversRoom
	(properties
		picture 37370
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 9 37000) (== newRoomNumber 37220)) ; rm37v220
			(gSounds fade: 23702 0 5 16 1 0)
			(proc951_9 23701)
			(gSounds play: 23701 -1 74 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37380
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37291
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37220
	)

	(method (init)
		(self createPoly: 174 15 166 11 55 42 53 110 104 142 176 142)
		(super init: &rest)
	)
)

