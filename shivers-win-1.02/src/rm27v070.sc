;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27070)
(include sci.sh)
(use Main)
(use n951)

(public
	rm27v070 0
)

(instance rm27v070 of ShiversRoom
	(properties
		picture 27070
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(if (proc951_11 5 36000)
			(gSounds fade: 22701 0 5 32 1 0)
			(proc951_9 22702)
			(gSounds play: 22702 -1 0 0)
			(gSounds fade: 22702 50 5 16 0 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 5 36000) (!= newRoomNumber 27080)) ; rm27v080
			(gSounds fade: 22702 0 5 16 1 0)
			(proc951_9 22701)
			(gSounds play: 22701 -1 98 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27080
	)

	(method (init)
		(self createPoly: 90 143 97 133 97 24 170 42 170 123 184 142 91 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27073
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27071
	)
)

