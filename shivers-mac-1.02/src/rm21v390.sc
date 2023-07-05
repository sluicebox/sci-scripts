;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21390)
(include sci.sh)
(use Main)
(use n951)

(public
	rm21v390 0
)

(instance rm21v390 of ShiversRoom
	(properties
		picture 21390
	)

	(method (init)
		(if (proc951_11 4 21000)
			(proc951_9 22512)
			(gSounds play: 22512 -1 50 0)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 21430) (proc951_11 4 21000)) ; rm21v430
			(gSounds fade: 22512 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21420
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21430
	)
)

