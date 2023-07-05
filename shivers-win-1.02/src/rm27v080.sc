;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27080)
(include sci.sh)
(use Main)
(use n951)

(public
	rm27v080 0
)

(instance rm27v080 of ShiversRoom
	(properties
		picture 27080
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(if (and (proc951_11 5 36000) (!= gPrevRoomNum 27081)) ; rm27v081
			(proc951_9 20702)
			(gSounds play: 20702 -1 0 0)
			(gSounds fade: 20702 50 5 16 0 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 5 36000) (!= newRoomNumber 27081)) ; rm27v081
			(gSounds fade: 20702 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 210
		nextRoom 27083
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 50
		nextRoom 27081
	)
)

