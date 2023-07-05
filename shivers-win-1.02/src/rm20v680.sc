;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20680)
(include sci.sh)
(use Main)
(use n951)

(public
	rm20v680 0
)

(instance rm20v680 of ShiversRoom
	(properties
		picture 20680
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(if (IsFlag 16)
			(= picture 20681)
		)
		(super init: &rest)
		(if (and (proc951_11 4 20000) (IsFlag 16))
			(proc951_9 22512)
			(gSounds play: 22512 -1 0 0)
			(gSounds fade: 22512 50 5 16 0 0)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 4 20000) (IsFlag 16) (!= newRoomNumber 20700)) ; rm20v700
			(gSounds fade: 22512 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20700
	)

	(method (init)
		(self createPoly: 74 11 189 11 189 142 77 142 74 12)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20660
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20670
	)
)

